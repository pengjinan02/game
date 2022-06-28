package cn.pja.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 彭金安
 * @DATE 2021/12/9
 */

@SpringBootApplication(scanBasePackages = "cn.pja.es")
@RestController
public class EsApplication {
    public static void main(String[] args) {

        SpringApplication.run(EsApplication.class, args);
    }
}
