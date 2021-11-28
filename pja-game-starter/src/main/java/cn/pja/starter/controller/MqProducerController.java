package cn.pja.starter.controller;

import cn.pja.starter.service.MqProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 彭金安
 * @DATE 2021/11/28
 */
@Controller
@RequestMapping("/mqProducer")
public class MqProducerController {

    @Autowired
    private MqProducerService mqProducerService;

    @RequestMapping("sendMessage")
    @ResponseBody
    public String sendMessage(String message) throws Exception {
        mqProducerService.sendMessage(message);
        return "发送mq消息成功！";
    }
}
