package cn.pja.starter.wapper.mq;

import cn.pja.starter.contants.GameError;
import cn.pja.starter.utils.LogUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.selector.SelectMessageQueueByHash;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.metrics.StartupStep;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * MQ消息提供者工具类
 *
 * @author 彭金安
 * @DATE 2021/11/28
 */
@Component
@Slf4j
public class MqProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MqProducer.class);

    private static final String KEYS = "KEYS";

    @Autowired
    private RocketMQTemplate template;

    /**
     * 消息发送
     * @param topic  topic分组
     * @param tags   tags(多个按如下格式 tag1 || tag2 || tag3)
     * @param payload 消息体
     */
    public void sendMessage(String topic, String tags, Object payload) throws Exception {
        try {
            String destination = topic + ":" + tags;
            String keys = topic + UUID.randomUUID();

            Message<Object> message = MessageBuilder.withPayload(payload)
                    .setHeader(KEYS, keys)
                    .build();
            template.send(destination, message);
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("topic", topic);
            jsonObject.put("tags", tags);
            jsonObject.put("message", payload);
            LogUtils.error(LOGGER, GameError.MQ_PRODUCER_EXCEPTION, jsonObject.toJSONString());
            e.printStackTrace();
        }
    }

    /**
     * 消息发送
     * @param topic  topic分组
     * @param payload 消息体
     */
    public void sendMessage(String topic, Object payload) throws Exception {
        try {
            template.convertAndSend(topic, payload);
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("topic", topic);
            jsonObject.put("message", payload);
            LogUtils.error(LOGGER, GameError.MQ_PRODUCER_EXCEPTION, jsonObject.toJSONString());
            e.printStackTrace();
        }
    }


    /**
     * 同步消息发送
     * @param topic  topic分组
     * @param payload 消息体
     */
    public void syncSendMessage(String topic, Object payload) throws Exception {
        try {
            System.out.println("同步消息发送");
            template.syncSend(topic, payload);
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("topic", topic);
            jsonObject.put("message", payload);
            LogUtils.error(LOGGER, GameError.MQ_PRODUCER_EXCEPTION, jsonObject.toJSONString());
            e.printStackTrace();
        }
    }


    /**
     * 异步消息发送
     * @param topic  topic分组
     * @param payload 消息体
     */
    public void asyncSendMessage(String topic, Object payload) throws Exception {
        try {
            System.out.println("异步消息发送");
            template.asyncSend(topic, payload, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("send async success");
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("send async exception");
                }
            });
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("topic", topic);
            jsonObject.put("message", payload);
            LogUtils.error(LOGGER, GameError.MQ_PRODUCER_EXCEPTION, jsonObject.toJSONString());
            e.printStackTrace();
        }
    }

    /**
     * 单向消息发送
     * @param topic  topic分组
     * @param payload 消息体
     */
    public void oneWaySendMessage(String topic, Object payload) throws Exception {
        try {
            System.out.println("单向消息发送");
            template.sendOneWay(topic, payload);
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("topic", topic);
            jsonObject.put("message", payload);
            LogUtils.error(LOGGER, GameError.MQ_PRODUCER_EXCEPTION, jsonObject.toJSONString());
            e.printStackTrace();
        }
    }

    /**
     * 发送事务消息（分布式事务实现）
     * @param topic  topic分组
     * @param payload 消息体
     */
    public void transactionSendMessage(String topic, String tag, Object user, Object payload) throws Exception {
        try {
            System.out.println("发送事务消息");
            Message message = MessageBuilder.withPayload(user).setHeader(KEYS, tag).build();
            // 发送事务消息 ps：注意此时消息状态为预投递，即消费端无法消费到此消息
            template.sendMessageInTransaction(topic, message, payload);
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("topic", topic);
            jsonObject.put("message", payload);
            LogUtils.error(LOGGER, GameError.MQ_PRODUCER_EXCEPTION, jsonObject.toJSONString());
            e.printStackTrace();
        }
    }


    /**
     * 发送顺序消息
     * @param topic  topic分组
     * @param payload 消息体
     */
    public void orderlySendMessage(String topic, String tag, Object payload, String hashKey) throws Exception {
        try {
            System.out.println("发送顺序消息");
            // 默认队列是hash取模，所以是可以发送到用一个队列中去的。如果是其他的则无法保证
            template.setMessageQueueSelector(new SelectMessageQueueByHash());

            // 发的消息都会发到统一hashKey里去
            SendResult sendResult = template.syncSendOrderly(topic, MessageBuilder.withPayload(payload).build(),
                    hashKey);
            log.info("queueId", sendResult.getMessageQueue().getQueueId());

        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("topic", topic);
            jsonObject.put("message", payload);
            LogUtils.error(LOGGER, GameError.MQ_PRODUCER_EXCEPTION, jsonObject.toJSONString());
            e.printStackTrace();
        }
    }
}
