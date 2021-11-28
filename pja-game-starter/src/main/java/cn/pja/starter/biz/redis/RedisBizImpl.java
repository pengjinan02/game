package cn.pja.starter.biz.redis;

import cn.pja.starter.mapper.TgoodsMapper;
import cn.pja.starter.model.DO.Tgoods;
import cn.pja.starter.model.DO.TgoodsExample;
import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

/**
 * redis业务实现类
 *
 * @author 彭金安
 * @DATE 2021/11/27
 */
@Component
@RequiredArgsConstructor
public class RedisBizImpl {

    private final TgoodsMapper tgoodsMapper;

    /**
     * 从缓存中获取数据
     * @return
     */
    public String searchTGoodsInfoByRedis(String gid){
        System.out.println("访问数据库");
        Tgoods tgoods = tgoodsMapper.selectByPrimaryKey(gid);
        return JSON.toJSONString(tgoods);
    }

    /**
     * 从数据库中获取数据
     * @return
     */
    public String searchTGoodsInfo(){
        Tgoods tgoods = tgoodsMapper.selectByPrimaryKey("10001");
        return JSON.toJSONString(tgoods);
    }
}
