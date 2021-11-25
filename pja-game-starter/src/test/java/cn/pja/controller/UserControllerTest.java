package cn.pja.controller;

import cn.pja.starter.controller.UserController;
import cn.pja.starter.start.MainApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 彭金安
 * @DATE 2021/10/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class UserControllerTest {

    @Autowired
    UserController userController;

    @Test
    public void test001() {
        String str = userController.getUser();
        System.out.println(str);
    }
}
