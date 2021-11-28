package cn.pja.starter.service.impl;

import cn.pja.starter.biz.dubbo.DubboBizImpl;
import cn.pja.starter.service.MyDubboService;
import cn.pja.starter.utils.CheckUtils;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.common.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author 彭金安
 * @DATE 2021/11/28
 */
@Service
@RequiredArgsConstructor
public class MyDubboServiceImpl implements MyDubboService {

    private DubboBizImpl dubboBiz;
    @Override
    public String getDubboString(String name) {
        // 参数校验
        checkDubboStringParam(name);

        return dubboBiz.getDubboString(name);
    }

    /**
     * 参数校验
     * @param name
     */
    private void checkDubboStringParam(String name) {
        CheckUtils.isTrue(StringUtils.isBlank(name));
    }
}
