package cn.pja.starter.controller;

import cn.pja.starter.model.result.ServiceResult;
import cn.pja.starter.model.vo.UserVO;
import cn.pja.starter.service.UserService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 彭金安
 */
@Controller
@RequestMapping("/")
@Slf4j
public class UserController {
    @Autowired
    UserService userServer;

    @RequestMapping("get")
    public ModelAndView get(){
        ModelAndView modelAndView = new ModelAndView();
        UserVO user = new UserVO();
        user.setId("666");
        user.setName("777");
        modelAndView.setViewName("index");
        modelAndView.addObject("userVO",user);
        modelAndView.addObject("errorCode","E10001");
        modelAndView.addObject("errorMessage","账号或密码错误");
        return modelAndView;
    }

    @RequestMapping("getUser")
    public String getUser() {
        return JSON.toJSONString(userServer.selectUserByUid("1234"));
    }



    @RequestMapping("login")
    public ModelAndView login(String id, String password) {
        ServiceResult<UserVO> result = userServer.userLogin(id, password);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", result.getResult());
        modelAndView.setViewName("index");
        if (result == null || result.getResult() == null) {
            UserVO user = new UserVO();
            user.setId(id);
            user.setPassword(password);

            modelAndView.addObject("errorMessage", result.getErrorMessage());
            modelAndView.addObject("errorCode", result.getErrorCode());
            modelAndView.addObject("userVO", user);
            modelAndView.setViewName("index");
        }

        return modelAndView;
    }
}
