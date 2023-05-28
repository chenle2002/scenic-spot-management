package io.renren.modules.scenic.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.common.utils.PageUtils;
import io.renren.modules.scenic.entity.ScenicordersEntity;
import io.renren.modules.scenic.entity.VisitorEntity;
import io.renren.modules.scenic.service.impl.VisitorServiceImpl;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

public class VisitorServiceProxy extends VisitorServiceImpl implements VisitorService {
    VisitorServiceImpl visitorService;

    public void setVisitorService(VisitorServiceImpl visitorService) {
        this.visitorService = visitorService;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        System.out.println("调用queryPage方法");
        return visitorService.queryPage(params);
    }

    @Override
    public boolean judgeVisitorAlive(ScenicordersEntity scenicorders) {
        System.out.println("调用judgeVisitorAlive方法");
        return visitorService.judgeVisitorAlive(scenicorders);
    }

}
