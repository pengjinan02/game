package cn.pja.starter.biz.dubbo;

import cn.pja.api.service.UserApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author 彭金安
 * @DATE 2021/11/28
 */
@Component
@RequiredArgsConstructor
public class DubboBizImpl {

    private UserApiService userApiService;

    public String getDubboString(String name) {
        String message = userApiService.getMessage(name);
        System.out.println(message);
        return message;
    }
}
