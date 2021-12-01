package cn.pja.starter.wapper.mq;

import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 顺序消费
 *
 * @author 彭金安
 * @DATE 2021/12/1
 */
public class MqConsumerOrderly implements MessageListenerOrderly {
    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
        return null;
    }
}
