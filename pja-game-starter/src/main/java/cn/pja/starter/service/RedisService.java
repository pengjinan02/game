package cn.pja.starter.service;

import cn.pja.starter.model.DO.Tgoods;

/**
 * @author 彭金安
 * @DATE 2021/11/27
 */
public interface RedisService {
    /**
     *
     * @param gid
     * @return
     */
    String searchTGoodsInfo(String gid);
}
