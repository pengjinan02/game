package cn.pja.starter.wapper.mq;

import cn.pja.starter.exception.GameException;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 这个需要配置监听配置类
 * ...这里topic应该也要判断的
 *
 * @author 彭金安
 * @DATE 2021/11/30
 */
@Component
public abstract class MqConsumerListener implements MessageListenerConcurrently {

    private Map<String, List<MqConsumerListener>> processors;

    public MqConsumerListener(List<MqConsumerListener> consumerListeners) {
        System.out.println("构造方法注入监听处理器");
        processors = new HashMap<>();
        for (MqConsumerListener consumerListener : consumerListeners) {
            Set<String> tags = consumerListener.getTags();
            if (CollectionUtils.isEmpty(tags)) {
                continue;
            }

            for (String tag : tags) {
                List<MqConsumerListener> listeners = processors.getOrDefault(tag, new ArrayList<>());
                listeners.add(consumerListener);
                processors.put(tag, listeners);
            }
        }
    }

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        try {
            for (MessageExt messageExt : list) {
                if (messageExt.getTags() == null) {
                    continue;
                }
                // 获取message
                String message = String.valueOf(messageExt.getBody());
                if (StringUtils.isBlank(message)) {
                    continue;
                }
                // 获取tag
                String[] tags = messageExt.getTags().split("||");
                if (tags.length == 0) {
                    continue;
                }

                // 获取消息处理器
                List<MqConsumerListener> mqConsumerListeners = getAllProcessors(tags);
                for (MqConsumerListener mqConsumerListener : mqConsumerListeners) {
                    mqConsumerListener.process(message);
                }
            }
        } catch (GameException e) {
            // 服务异常就像重试
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        } catch (Exception e) {
            e.printStackTrace();
            // 其他异常不进行重试
            return null;
        }

        return null;
    }

    /**
     * 获取所有的处理器
     * @param tags
     * @return
     */
    private List<MqConsumerListener> getAllProcessors(String[] tags) {
        // todo 这里可能有问题，即有多个处理器一致
        List<MqConsumerListener> mqConsumerListeners = new ArrayList<>();
        for (String tag : tags) {
            List<MqConsumerListener> consumerListeners = processors.get(tag);
            if (!CollectionUtils.isEmpty(consumerListeners)) {
                mqConsumerListeners.addAll(consumerListeners);
            }
        }

        return mqConsumerListeners;
    }

    /**
     * 业务处理
     * @param message
     */
    abstract void process(String message);

    /**
     * 获取处理器的要处理的tags
     * @return
     */
    abstract Set<String> getTags();
}
