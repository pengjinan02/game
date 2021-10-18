package cn.pja.mapper;

import cn.pja.model.vo.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 彭金安
 */
@Mapper
public interface UserMapper {

    /**
     * 根据id获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    UserDO selectUserById(String id);

    /**
     * 根据id获取用户信息
     * @param id 用户id
     * @param password 密码
     * @return 用户信息
     */
    UserDO selectUserByPassWord(@Param("id")String id, @Param("password")String password);

    /**
     * 根据id删除用户信息
     * @param id 用户id
     * @return 删除的数量
     */
    int deleteUserById(String id);

    /**
     * 插入用户数据
     * @param userDO 用户信息
     * @return 插入的数量
     */
    int insertUser(UserDO userDO);

    /**
     * 更新用户数据
     * @param userDO 用户信息
     * @return 更新的数量
     */
    int updateUserById(UserDO userDO);
}
