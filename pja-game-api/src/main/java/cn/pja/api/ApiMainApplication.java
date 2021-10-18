package cn.pja.api;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * EnableAutoConfiguration 开启dubbo的自动配置
 *
 * @author 彭金安
 * @DATE 2021/10/12
 */
@SpringBootApplication(scanBasePackages = "cn")
@EnableDubbo
public class ApiMainApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(ApiMainApplication.class, args);
    }
}
