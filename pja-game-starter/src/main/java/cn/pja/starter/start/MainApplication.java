package cn.pja.starter.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动入口
 *  注：由于启动类没有在父类目录，所以需要指定包
 *
 * @author 彭金安
 */
@SpringBootApplication(scanBasePackages = "cn")
@MapperScan("cn.pja.starter.mapper")
@RestController
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
