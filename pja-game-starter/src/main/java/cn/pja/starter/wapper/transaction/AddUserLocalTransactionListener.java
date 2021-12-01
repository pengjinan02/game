package cn.pja.starter.wapper.transaction;

import cn.pja.starter.utils.TransactionUtils;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.transaction.TransactionStatus;

/**
 * 本地事务监听器
 *
 * @author 彭金安
 * @DATE 2021/12/1
 */
@RocketMQTransactionListener
public class AddUserLocalTransactionListener implements RocketMQLocalTransactionListener {
    @Autowired
    private TransactionUtils transactionUtils;
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        // 这里应该判断topic，tag之类的

        TransactionStatus status = null;
        try {
            // 这里取数据可能需要看一下
            String user = (String) message.getHeaders().get("userMessage");
            // 更新用户信息
            status = transactionUtils.begin();
            // 提交本地事务
            transactionUtils.commit(status);

        } catch (Exception e) {
            // 本地事务执行失败，告诉mq将消息删除
            e.printStackTrace();
            if (status != null) {
                transactionUtils.rollback(status);
                return RocketMQLocalTransactionState.ROLLBACK;
            }
        }

        // 本地执行成功，告诉mq更新消息状态为可投递
        return RocketMQLocalTransactionState.COMMIT;
    }

    /**
     *  本地事务执行情况校验
     *   比如本地执行成功，但是由于网络原因没有响应，一次服务器会回调此方法，来判断本地事务是否执行成功
     * @param message
     * @return
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        // 获取message里的信息
        MessageHeaders headers = message.getHeaders();
        Object object = headers.get("msg");
        if (object == null) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }

        // 查询本地事务执行情况（）
        boolean result = true;
        //
        if (!result) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }


        return RocketMQLocalTransactionState.COMMIT;
    }
}
