package cn.pja.starter.wapper.transaction;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 外部分布式事务监听器
 *
 * @author 彭金安
 * @DATE 2021/12/1
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "inner-topic-transaction",
        consumerGroup = "my-consumer-group" ,
        selectorExpression="tag_goods_transaction")
public class GoodsTransactionListener implements RocketMQListener {
    @Override
    public void onMessage(Object o) {
        // 执行远程事务

        // 执行成功 ps:不抛出异常就行
    }
}
