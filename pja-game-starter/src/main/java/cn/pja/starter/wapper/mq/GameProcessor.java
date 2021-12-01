package cn.pja.starter.wapper.mq;

import com.google.common.collect.ImmutableSet;

import java.util.List;
import java.util.Set;

/**
 * @author 彭金安
 * @DATE 2021/11/30
 */
public class GameProcessor extends MqConsumerListener {
    public GameProcessor(List<MqConsumerListener> consumerListeners) {
        super(consumerListeners);
    }

    @Override
    void process(String message) {
        System.out.println("tag_game和tag_goods消息处理");
    }

    @Override
    Set<String> getTags() {
        return ImmutableSet.of(
                "tag_game",
                "tag_goods"
        );
    }
}
