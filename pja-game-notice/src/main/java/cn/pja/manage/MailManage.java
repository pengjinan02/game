package cn.pja.manage;

import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Component
public class MailManage {

    public void sendMail() throws MessagingException, UnsupportedEncodingException {
        // 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
        props.put("mail.smtp.port", "587");
        // 此处填写你的账号
        props.put("mail.user", "pengjinan1996@qq.com");
        // 此处的密码就是前面说的16位STMP口令
        props.put("mail.password", "wbalwetzskdsjaai");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人的邮箱
        InternetAddress to = new InternetAddress("pengjinan1996@qq.com");
        message.setRecipient(Message.RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject("测试邮件");

        // 设置邮件的内容体
        message.setContent("这是一封测试邮件", "text/html;charset=UTF-8");

        //添加附件部分
        //邮件内容部分1---文本内容
        MimeBodyPart body0 = new MimeBodyPart(); //邮件中的文字部分
        body0.setContent("这是两张<font color='red'>图片</font>....","text/html;charset=utf-8");
        System.out.println("dir:"+System.getProperty("user.dir"));
        //邮件内容部分2---附件1
        MimeBodyPart body1 = new MimeBodyPart(); //附件1
        body1.setDataHandler( new DataHandler( new FileDataSource(".\\src\\main\\resources\\images\\1.jpg")) );//./代表项目根目录下
        body1.setFileName( MimeUtility.encodeText("中文1.jpg") );//中文附件名，解决乱码

        //邮件内容部分3---附件2
        MimeBodyPart body2 = new MimeBodyPart(); //附件2
        body2.setDataHandler( new DataHandler( new FileDataSource(".\\src\\main\\resources\\images\\2.jpg")) );
        body2.setFileName("2.jpg");

        //把上面的3部分组装在一起，设置到msg中
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(body0);
        mm.addBodyPart(body1);
        mm.addBodyPart(body2);
        message.setContent(mm);

        // 最后当然就是发送邮件啦
        Transport.send(message);
    }
}
