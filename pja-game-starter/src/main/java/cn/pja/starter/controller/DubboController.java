package cn.pja.starter.controller;

import cn.pja.starter.service.MyDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 彭金安
 * @DATE 2021/11/28
 */
@Controller
@RequestMapping("/dubbo")
public class DubboController {

    @Autowired
    private MyDubboService myDubboService;


    @RequestMapping("getDubboString")
    @ResponseBody
    public String getDubboString(String name) {
        return myDubboService.getDubboString(name);
    }
}
