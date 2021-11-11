package cn.pja.service.impl;

import cn.pja.api.service.UserApiService;
import cn.pja.contants.ServiceError;
import cn.pja.exception.ServiceException;
import cn.pja.model.result.ServiceResult;
import cn.pja.model.vo.UserVO;
import cn.pja.service.UserService;
import cn.pja.manager.UserManager;
import cn.pja.utils.LogUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 彭金安
 */
@Service
public class UserServerImpl implements UserService {
    @Autowired
    UserManager userManager;
    @Autowired
    UserApiService userApiService;

    @Override
    public UserVO selectUserByUid(String uid){
        System.out.println("根据uid查询：" + uid);
        UserVO user = userManager.selectUserById(uid);
        if (user == null) {
            // todo 警告日志模板
            LogUtils.warn(this.getClass().getName(),
                    Thread.currentThread().getStackTrace()[1].getMethodName(),
                    "123",
                    "444",
                    JSON.toJSONString(user));
        }

        return user;
    }

    @Override
    public ServiceResult<UserVO> userLogin(String id, String password) {
        // 1. 密码加密 todo 暂时不加密，省的忘记了密码找不回来，麻烦

        // 2. 获取用户信息
        UserVO user = userManager.selectUserByIdAndPassWord(id, password);
        if (user == null) {
            return ServiceResult.buildDefaultFailResult(ServiceError.USER_LOGIN_FAIL);
        }

        return ServiceResult.buildDefaultSuccessResult(user);
    }

    @Override
    public String getDubboString(String name) {
        String message = userApiService.getMessage(name);
        System.out.println(message);
        return message;
    }

}