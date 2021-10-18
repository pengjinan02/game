package cn.pja.manager;

import cn.pja.convert.UserVOConverter;
import cn.pja.mapper.UserMapper;
import cn.pja.model.vo.UserDO;
import cn.pja.model.vo.UserVO;
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
        UserVO userVO = UserVOConverter.convertToUserVO(userMapper.selectUserById(id));
        // todo 这里需要对象转换
        return userVO;
    }

    public UserVO selectUserByIdAndPassWord(String id, String password){
        return null;
    }
}
