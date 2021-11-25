package cn.pja.starter.mapper;

import cn.pja.starter.model.DO.User;
import cn.pja.starter.model.DO.UserExample;
import cn.pja.starter.model.DO.UserWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     *
     * @mbg.generated 2021-11-25
     */
    long countByExample(UserExample example);

    /**
     *
     * @mbg.generated 2021-11-25
     */
    int deleteByExample(UserExample example);

    /**
     *
     * @mbg.generated 2021-11-25
     */
    int insert(UserWithBLOBs record);

    /**
     *
     * @mbg.generated 2021-11-25
     */
    int insertSelective(UserWithBLOBs record);

    /**
     *
     * @mbg.generated 2021-11-25
     */
    List<UserWithBLOBs> selectByExampleWithBLOBs(UserExample example);

    /**
     *
     * @mbg.generated 2021-11-25
     */
    List<User> selectByExample(UserExample example);

    /**
     *
     * @mbg.generated 2021-11-25
     */
    int updateByExampleSelective(@Param("record") UserWithBLOBs record, @Param("example") UserExample example);

    /**
     *
     * @mbg.generated 2021-11-25
     */
    int updateByExampleWithBLOBs(@Param("record") UserWithBLOBs record, @Param("example") UserExample example);

    /**
     *
     * @mbg.generated 2021-11-25
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}