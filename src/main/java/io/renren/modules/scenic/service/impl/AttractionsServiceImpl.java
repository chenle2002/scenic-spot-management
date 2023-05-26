package io.renren.modules.scenic.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.scenic.dao.AttractionsDao;
import io.renren.modules.scenic.entity.AttractionsEntity;
import io.renren.modules.scenic.entity.ScenicSpotEntity;
import io.renren.modules.scenic.service.AttractionsService;
import io.renren.modules.scenic.service.ScenicSpotService;
import io.renren.modules.scenic.vo.AttractionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("attractionsService")
public class AttractionsServiceImpl extends ServiceImpl<AttractionsDao, AttractionsEntity> implements AttractionsService {

    @Autowired
    ScenicSpotService scenicSpotService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttractionsEntity> page = this.page(
                new Query<AttractionsEntity>().getPage(params),
                new QueryWrapper<AttractionsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<AttractionVo> getlist() {
        List<AttractionsEntity> attractionsEntities = this.baseMapper.selectList(null);
        List<AttractionVo> scenic_id1 = attractionsEntities.stream().map(item -> {
            AttractionVo attractionVo = new AttractionVo();
            attractionVo.setAttractionsId(item.getAttractionsId());
            attractionVo.setPeopleNumber(item.getPeopleNumber());
            attractionVo.setScenicName(item.getScenicName());
            attractionVo.setScenicDescription(item.getScenicDescription());
            attractionVo.setStatus(item.getStatus());
            attractionVo.setScenicId(item.getScenicId());

            Integer attractionsId = item.getScenicId();
            ScenicSpotEntity scenic_id = scenicSpotService.getOne(new QueryWrapper<ScenicSpotEntity>().eq("scenic_id", attractionsId));
            attractionVo.setScenicSpotName(scenic_id.getScenicName());
            return attractionVo;
        }).collect(Collectors.toList());
        return scenic_id1;
    }

    @Override
    public boolean judgeSpotAlive(AttractionsEntity attractions) {
        ScenicSpotEntity scenic_id = scenicSpotService.getOne(new QueryWrapper<ScenicSpotEntity>().eq("scenic_id", attractions.getScenicId()));
        if(scenic_id==null) return false;
        return true;
    }

    @Override
    public boolean judgeAttractionAlive(Integer scenicSpotId) {
        List<AttractionsEntity> scenic_id = this.baseMapper.selectList(new QueryWrapper<AttractionsEntity>().eq("scenic_id", scenicSpotId));
        if(scenic_id!=null) return true;
        return false;
    }


}
