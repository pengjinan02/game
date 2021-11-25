package cn.pja.starter.mapper;

import cn.pja.starter.model.DO.Tgoods;
import cn.pja.starter.model.DO.TgoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TgoodsMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(TgoodsExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(TgoodsExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String gid);

    /**
     *
     * @mbg.generated
     */
    int insert(Tgoods record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Tgoods record);

    /**
     *
     * @mbg.generated
     */
    List<Tgoods> selectByExample(TgoodsExample example);

    /**
     *
     * @mbg.generated
     */
    Tgoods selectByPrimaryKey(String gid);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Tgoods record, @Param("example") TgoodsExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Tgoods record, @Param("example") TgoodsExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Tgoods record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Tgoods record);
}