package cn.pja.starter.utils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 *  todo 方法名改成redis命令 @彭金安
 *
 * @author 彭金安
 * @DATE 2021/11/21
 */
@Component
@Slf4j
public class RedisUtils {
    @Autowired
    RedisTemplate redisTemplate;

    public void test() {
        ValueOperations<Serializable, Object> strOperations = redisTemplate.opsForValue();
        ListOperations<Serializable, Object> listOperations = redisTemplate.opsForList();
        SetOperations<Serializable, Object> setOperations = redisTemplate.opsForSet();
        ZSetOperations<Serializable, Object> zSetOperations = redisTemplate.opsForZSet();
        HashOperations<Serializable, Object, Object> hashOperations = redisTemplate.opsForHash();
        ClusterOperations<Serializable, Object> clusterOperations = redisTemplate.opsForCluster();
        GeoOperations<Serializable, Object> geoOperations = redisTemplate.opsForGeo();
        HyperLogLogOperations<Serializable, Object> hyperLogLogOperations = redisTemplate.opsForHyperLogLog();
        StreamOperations<Serializable, Object, Object> streamOperations = redisTemplate.opsForStream();
    }

    /**
     * 设置缓存
     * @param key 键
     * @param value 值
     * @return
     */
    public boolean setValue(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存并设置过期时间
     *   原子操作
     * @param key 键
     * @param value 值
     * @param expireTime 过期时间
     * @param timeUnit 时间单位
     * @return
     */
    public boolean setValueAndExpireTime(final String key, Object value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 设置过期时间
     * @param key 键
     * @param expireTime 过期时间
     * @param timeUnit 时间单位
     * @return
     */
    public boolean setExpireTime(final String key, Long expireTime, TimeUnit timeUnit) {
        return redisTemplate.expire(key, expireTime, timeUnit);
    }

    /**
     * 删除key 可变参数
     * @param keys
     */
    public void deleteKey(final String... keys) {
        if (keys != null && keys.length > 0) {
            redisTemplate.delete(Lists.newArrayList(keys));
        }
    }

    /**
     * 设置缓存
     *    如果存在则设置失败，不存在就设置成功
     * @param key
     * @param value
     */
    public boolean setValueIfAbsent(final String key, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * 设置缓存和过期时间
     *    如果存在则设置失败，不存在就设置成功
     * @param key
     * @param value
     */
    public boolean setValueAndExpireTimeIfAbsent(final String key, Object value, long expireTime, TimeUnit timeUnit) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, expireTime, timeUnit);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean existsKey(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 获取缓存的值
     * @param key
     * @return
     */
    public Object getValue(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 哈希添加
     * @param key
     * @param hashKey
     * @param value
     */
    public void setHashValue(String key, Object hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    public Object getHashValue(String key, Object hashKey) {
        return  redisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * 列表添加
     * @param key
     * @param value
     */
    public void setListValue(String key, Object value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 列表获取
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> getListValue(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 集合添加
     * @param key
     * @param value
     */
    public void addSet(String key, Object value) {
        redisTemplate.opsForSet().add(key, value);
    }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public Set<Object> getMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param score
     */
    public void zAdd(String key, Object value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 有序集合获取
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<Object> rangeByScore(String key, double min, double max) {
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.rangeByScore(key, min, max);
    }

    /**
     * 获取过期时间
     * @param key
     * @return
     */
    public long getExpireTime(String key) {
        return redisTemplate.getExpire(key);
    }
}
