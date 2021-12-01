package cn.pja.starter.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * 本地事务管理器
 *
 * @author 彭金安
 * @DATE 2021/12/1
 */
@Component
public class TransactionUtils {
    @Autowired
    DataSourceTransactionManager transactionManager;

    public TransactionStatus begin(){
        TransactionStatus transactionStatus  = transactionManager.getTransaction(new DefaultTransactionAttribute());
        return transactionStatus;
    }

    public void commit(TransactionStatus status){
        transactionManager.commit(status);
    }

    public void rollback(TransactionStatus status){
        transactionManager.rollback(status);
    }
}
