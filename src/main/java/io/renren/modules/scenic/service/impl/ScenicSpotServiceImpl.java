package io.renren.modules.scenic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.scenic.dao.ScenicSpotDao;
import io.renren.modules.scenic.entity.ScenicSpotEntity;
import io.renren.modules.scenic.service.ScenicSpotService;
import org.springframework.stereotype.Service;

import java.util.Map;




@Service("scenicSpotService")
public class ScenicSpotServiceImpl extends ServiceImpl<ScenicSpotDao, ScenicSpotEntity> implements ScenicSpotService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ScenicSpotEntity> page = this.page(
                new Query<ScenicSpotEntity>().getPage(params),
                new QueryWrapper<ScenicSpotEntity>()
        );

        return new PageUtils(page);
    }

}
