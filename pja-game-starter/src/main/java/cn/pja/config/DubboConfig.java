package cn.pja.config;

import cn.pja.api.service.UserApiService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author 彭金安
 * @DATE 2021/10/13
 */
@Component
public class DubboConfig {
    @DubboReference(version = "1.0.0")
    private UserApiService userApiService;

    @Bean
    public UserApiService userApiService() {
        return userApiService;
    }
}
