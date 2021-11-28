package cn.pja.starter.service;

/**
 * @author 彭金安
 * @DATE 2021/11/28
 */
public interface MqProducerService {
    /**
     * 发送消息
     * @param message
     */
    void sendMessage(String message) throws Exception;
}
