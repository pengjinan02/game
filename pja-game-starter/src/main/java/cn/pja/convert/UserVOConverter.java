package cn.pja.convert;

import cn.pja.model.vo.UserDO;
import cn.pja.model.vo.UserVO;

/**
 * @author 彭金安
 * @DATE 2021/10/4
 */
public class UserVOConverter {

    /**
     * 转换
     * @param userDO do
     * @return vo
     */
    public static UserVO convertToUserVO(UserDO userDO) {
        if (userDO == null) {
            return null;
        }

        UserVO userVO = new UserVO();
        userVO.setAge(userDO.getAge());
        userVO.setId(userDO.getId());
        userVO.setName(userDO.getName());
        userVO.setPassword(userDO.getPassword());
        userVO.setRole(userDO.getRole());
        userVO.setRegDm(userDO.getRegDm());
        userVO.setUpdDm(userDO.getUpdDm());
        userVO.setState(userDO.getState());

        return userVO;
    }

}
