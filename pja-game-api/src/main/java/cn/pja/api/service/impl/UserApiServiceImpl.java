package cn.pja.api.service.impl;

import cn.pja.api.service.UserApiService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 用户信息服务封装服务实现类
 *
 * @author 彭金安
 * @DATE 2021/9/12
 */
@DubboService(version = "1.0.0")
public class UserApiServiceImpl implements UserApiService {
    @Override
    public String selectUserById(String id) {

        return "userDO";
    }

    @Override
    public String selectUserByIdAndPassWord(String id, String password) {
        return null;
    }

    @Override
    public String getMessage(String name) {
        return name + "真是个帅哥";
    }
}
