package cn.pja.es.utils;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * todo 说明：ES6.0以上不再允许一个索引包含多于一种类型。
 *
 * @author 彭金安
 * @DATE 2021/12/9
 */
@Component
public class EsUtils {

    @Autowired
    protected RestHighLevelClient client;

    /**
     * 创建索引（即数据库）
     * @param index 索引
     */
    public void createIndex(String index) throws IOException {
        if (existsIndex(index)) {
            return;
        }
        CreateIndexRequest request = new CreateIndexRequest(index);
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println("createIndex:"+ JSON.toJSONString(response));
    }

    /**
     * 判断索引是否存在
     * @param index 索引
     */
    public boolean existsIndex(String index) throws IOException {
        GetIndexRequest request = new GetIndexRequest(index);
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println("existsIndex:"+ exists);
        return exists;
    }
}
