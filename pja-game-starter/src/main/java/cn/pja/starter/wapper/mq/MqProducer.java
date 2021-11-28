package cn.pja.starter.wapper.mq;

import cn.pja.starter.contants.ServiceError;
import cn.pja.starter.exception.ServiceException;
import cn.pja.starter.utils.LogUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
            LogUtils.error(LOGGER, ServiceError.MQ_PRODUCER_EXCEPTION, jsonObject.toJSONString());
            throw new Exception(ServiceError.MQ_PRODUCER_EXCEPTION.getMessage(), e);
        }
    }

}
