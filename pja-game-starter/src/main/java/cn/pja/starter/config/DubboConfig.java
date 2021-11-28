package cn.pja.starter.config;

import cn.pja.api.service.UserApiService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * todo dubbo服务配置类，不用的时候注释掉，免得每次都要启动
 *
 * @author 彭金安
 * @DATE 2021/10/13
 */
//@Component
public class DubboConfig {
    //@DubboReference(version = "1.0.0")
    private UserApiService userApiService;

    //@Bean
    public UserApiService userApiService() {
        return userApiService;
    }
}
