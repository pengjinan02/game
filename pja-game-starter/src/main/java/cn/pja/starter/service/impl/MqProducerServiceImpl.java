package cn.pja.starter.service.impl;

import cn.pja.starter.service.MqProducerService;
import cn.pja.starter.wapper.mq.MqProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 彭金安
 * @DATE 2021/11/28
 */
@Service
@RequiredArgsConstructor
public class MqProducerServiceImpl implements MqProducerService {
    private final MqProducer mqProducer;

    @Override
    public void sendMessage(String message) throws Exception {
        mqProducer.sendMessage("topic-inner", "test-tag", message);
        mqProducer.sendMessage("topic-inner",  message);
        mqProducer.syncSendMessage("topic-inner",  message);
    }
}
