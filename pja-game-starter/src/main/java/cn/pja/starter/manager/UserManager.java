package cn.pja.starter.manager;

import cn.pja.starter.convert.UserVOConverter;
import cn.pja.starter.mapper.UserMapper;
import cn.pja.starter.model.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 彭金安
 * @DATE 2021/9/12
 */
@Component
public class UserManager {
    @Autowired
    UserMapper userMapper;

    public UserVO selectUserById(String id){
        //UserVO userVO = UserVOConverter.convertToUserVO(userMapper.selectUserById(id));
        // todo 这里需要对象转换
        return null;
    }

    public UserVO selectUserByIdAndPassWord(String id, String password){
        return null;
    }
}
