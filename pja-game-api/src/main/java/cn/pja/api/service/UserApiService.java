package cn.pja.api.service;


/**
 * 用户信息服务封装服务类 todo 后期修改为通过远程调用的方式来实现
 *
 * @author 彭金安
 * @DATE 2021/9/12
 */
public interface UserApiService {

    /**
     *
     * @param id
     * @return
     */
    String selectUserById(String id);

    /**
     *
     * @param id
     * @param password
     * @return
     */
    String selectUserByIdAndPassWord(String id, String password);


    String getMessage(String name);

}
