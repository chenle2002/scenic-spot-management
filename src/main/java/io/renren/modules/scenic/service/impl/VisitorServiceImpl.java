package io.renren.modules.scenic.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.scenic.dao.VisitorDao;
import io.renren.modules.scenic.entity.ScenicordersEntity;
import io.renren.modules.scenic.entity.VisitorEntity;
import io.renren.modules.scenic.service.VisitorService;
import org.springframework.stereotype.Service;

import java.util.Map;



@Service("visitorService")
public class VisitorServiceImpl extends ServiceImpl<VisitorDao, VisitorEntity> implements VisitorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<VisitorEntity> page = this.page(
                new Query<VisitorEntity>().getPage(params),
                new QueryWrapper<VisitorEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public boolean judgeVisitorAlive(ScenicordersEntity scenicorders) {
        VisitorEntity visitor=this.baseMapper.selectOne(new QueryWrapper<VisitorEntity>().eq("visitor_id", scenicorders.getVisitorId()));
        if(visitor==null) return false;
        return true;
    }

}
