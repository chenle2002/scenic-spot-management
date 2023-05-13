package io.renren.modules.scenic.service.impl;



import io.renren.common.utils.Query;
import io.renren.modules.scenic.dao.ScenicordersDao;
import io.renren.modules.scenic.entity.ScenicSpotEntity;
import io.renren.modules.scenic.entity.ScenicordersEntity;
import io.renren.modules.scenic.entity.VisitorEntity;
import io.renren.modules.scenic.service.ScenicSpotService;
import io.renren.modules.scenic.service.ScenicordersService;
import io.renren.modules.scenic.service.VisitorService;
import io.renren.modules.scenic.vo.ScenicOrderResVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;




@Service("scenicordersService")
public class ScenicordersServiceImpl extends ServiceImpl<ScenicordersDao, ScenicordersEntity> implements ScenicordersService {

    @Autowired
    VisitorService visitorService;
    @Autowired
    ScenicSpotService scenicSpotService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ScenicordersEntity> page = this.page(
                new Query<ScenicordersEntity>().getPage(params),
                new QueryWrapper<ScenicordersEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<ScenicOrderResVo> listall() {
        List<ScenicordersEntity> scenicordersEntities = this.baseMapper.selectList(null);
        List<ScenicOrderResVo> collect = scenicordersEntities.stream().map(item -> {
            ScenicOrderResVo scenicOrderResVo = new ScenicOrderResVo();

            scenicOrderResVo.setScenicId(item.getScenicId());
            scenicOrderResVo.setOrderId(item.getOrderId());
            scenicOrderResVo.setCreatetime(item.getCreatetime());
            scenicOrderResVo.setDescription(item.getDescription());
            scenicOrderResVo.setPrice(item.getPrice());
            scenicOrderResVo.setVisitorId(item.getVisitorId());

            ScenicSpotEntity scenic_id = scenicSpotService.getOne(new QueryWrapper<ScenicSpotEntity>().eq("scenic_id", item.getScenicId()));
            VisitorEntity visitor_id = visitorService.getOne(new QueryWrapper<VisitorEntity>().eq("visitor_id", item.getVisitorId()));
            scenicOrderResVo.setScenicName(scenic_id.getScenicName());
            scenicOrderResVo.setVisitorName(visitor_id.getVisitorname());
            scenicOrderResVo.setVisitorPhone(visitor_id.getPhone());
            return scenicOrderResVo;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public boolean judgeVisitorAlive(ScenicordersEntity scenicorders) {
        VisitorEntity visitor_id = visitorService.getOne(new QueryWrapper<VisitorEntity>().eq("visitor_id", scenicorders.getVisitorId()));
        if(visitor_id==null) return false;
        return true;
    }

    @Override
    public boolean judgeSpotAlive(ScenicordersEntity scenicorders) {
        ScenicSpotEntity scenic_id = scenicSpotService.getOne(new QueryWrapper<ScenicSpotEntity>().eq("scenic_id", scenicorders.getScenicId()));
        if(scenic_id==null) return false;
        return true;
    }

    @Override
    public boolean judgeSpotStatus(ScenicordersEntity scenicorders) {
        ScenicSpotEntity scenic_id = scenicSpotService.getOne(new QueryWrapper<ScenicSpotEntity>().eq("scenic_id", scenicorders.getScenicId()));
        if(!scenic_id.getStatus().equals(1)) return false;
        return true;
    }

}
