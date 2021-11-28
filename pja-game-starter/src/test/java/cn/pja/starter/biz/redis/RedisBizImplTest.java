package cn.pja.starter.biz.redis;

import cn.pja.starter.start.MainApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 彭金安
 * @DATE 2021/11/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class RedisBizImplTest {

    @Autowired
    private RedisBizImpl redisBiz;

    @Test
    public void searchTGoodsInfoTest() {
        System.out.println(redisBiz.searchTGoodsInfoByRedis("10001"));
    }
}
