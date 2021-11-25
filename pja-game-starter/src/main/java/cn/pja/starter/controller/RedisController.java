package cn.pja.starter.controller;

import cn.pja.starter.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 彭金安
 * @DATE 2021/11/21
 */
@Controller
@RequestMapping("/redis")
public class RedisController {
    private final Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    RedisUtils redisUtils;

    @RequestMapping("getValueByKey")
    @ResponseBody
    public String getValueByKey(String key) {
        return (String) redisUtils.getValue(key);
    }

    @RequestMapping("setValueByKey")
    @ResponseBody
    public Boolean setValueByKey(String key, String value) {
        return redisUtils.setValue(key, value);
    }

}
