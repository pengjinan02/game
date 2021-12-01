package cn.pja.starter.wapper.mq;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 这种方式似乎是抛出异常就重试（次数16）
 *
 * @author 彭金安
 * @DATE 2021/11/29
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "inner-topic",
        consumerGroup = "my-consumer-group" ,
        selectorExpression="tag_game||tag_goods",
        // 是否是顺序消费
        consumeMode = ConsumeMode.CONCURRENTLY,
        // 广播消费还是一对一消费
        messageModel= MessageModel.CLUSTERING)
public class MqConsumer implements RocketMQListener {
    @Override
    public void onMessage(Object o) {
        System.out.println("监听成功！");
        try {
            MessageExt messageExt = (MessageExt) o;
            messageExt.getTags();
            System.out.println(JSON.toJSONString(o));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
