package cn.pja.starter.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动入口
 *  注：由于启动类没有在父类目录，所以需要指定包
 *  MapperScan: mapper文件扫描路径
 *  EnableCaching: 开启缓存
 *
 * @author 彭金安
 */
@SpringBootApplication(scanBasePackages = "cn.pja.starter")
@MapperScan("cn.pja.starter.mapper")
@EnableCaching
@RestController
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
