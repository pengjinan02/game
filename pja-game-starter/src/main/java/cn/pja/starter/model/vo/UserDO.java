package cn.pja.starter.model.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 用户
 * @author 彭金安
 */
@Data
@Component
public class UserDO {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 注册时间
     */
    private String regDm;
    /**
     * 更新时间
     */
    private String updDm;
    /**
     * 用户状态
     */
    private String state;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 角色
     */
    private Integer role;
}
