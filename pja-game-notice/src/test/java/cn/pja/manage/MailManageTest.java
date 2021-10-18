package cn.pja.manage;

import org.junit.Test;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public class MailManageTest {

    @Test
    public void test001(){
        MailManage manage = new MailManage();
        try {
            manage.sendMail();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
