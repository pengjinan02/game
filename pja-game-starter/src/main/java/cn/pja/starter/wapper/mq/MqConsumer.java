package cn.pja.starter.wapper.mq;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author 彭金安
 * @DATE 2021/11/29
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "inner-topic", consumerGroup = "my-consumer-group")
public class MqConsumer implements RocketMQListener {
    @Override
    public void onMessage(Object o) {
        System.out.println("监听成功！");
        System.out.println(JSON.toJSONString(o));
    }
}
