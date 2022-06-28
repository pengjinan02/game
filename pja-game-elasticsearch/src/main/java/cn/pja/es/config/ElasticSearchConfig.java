package cn.pja.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 彭金安
 *   todo 说明：ES6.0以上不再允许一个索引包含多于一种类型。
 *
 *
 *关系型数据库（比如Mysql）	非关系型数据库（Elasticsearch）
 * 数据库Database	    索引Index
 * 表Table	            类型Type
 * 数据行Row	            文档Document
 * 数据列Column	        字段Field
 * 约束 Schema	        映射Mapping
 *
 * @DATE 2021/12/9
 */
@Configuration
public class ElasticSearchConfig {

    public static final  RequestOptions COMMON_OPTIONS;

    static {
        // RequestOptions类保存了请求的部分，这些部分应该在同一个应用程序中的许多请求之间共享。
        // 创建一个singqleton实例，并在所有请求之间共享它。可以设置请求头之类的一些配置
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        // builder.addHeader("Authorization", "Bearer " + TOKEN);
        // builder.setHttpAsyncResponseConsumerFactory(
        //         new HttpAsyncResponseConsumerFactory
        //                 .HeapBufferedResponseConsumerFactory(30 * 1024 * 1024 *1024));
        COMMON_OPTIONS = builder.build();
    }

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );
        return client;
    }
}
