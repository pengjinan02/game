package cn.pja.service;

import cn.pja.model.result.ServiceResult;
import cn.pja.model.vo.UserVO;

/**
 * @author 彭金安
 */
public interface UserService {
    /**
     * 根据uid获取用户信息
     * @param id 用户uid
     * @return 用户信息
     */
    UserVO selectUserByUid(String id);

    /**
     * 用户登录
     * @param id      用户id
     * @param password 用户密码
     * @return 用户信息
     */
    ServiceResult<UserVO> userLogin(String id, String password);

    String getDubboString(String name);
}
