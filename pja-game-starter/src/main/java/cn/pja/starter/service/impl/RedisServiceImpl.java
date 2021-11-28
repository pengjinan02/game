package cn.pja.starter.service.impl;

import cn.pja.starter.biz.redis.RedisBizImpl;
import cn.pja.starter.model.DO.Tgoods;
import cn.pja.starter.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 彭金安
 * @DATE 2021/11/27
 */
@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService {

    private final RedisBizImpl redisBiz;

    @Override
    public String searchTGoodsInfo(String gid) {
        return redisBiz.searchTGoodsInfoByRedis(gid);
    }
}
