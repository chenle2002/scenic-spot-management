package io.renren.modules.scenic.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.scenic.dao.AttractionsDao;
import io.renren.modules.scenic.entity.AttractionsEntity;
import io.renren.modules.scenic.service.AttractionsService;
import org.springframework.stereotype.Service;

import java.util.Map;




@Service("attractionsService")
public class AttractionsServiceImpl extends ServiceImpl<AttractionsDao, AttractionsEntity> implements AttractionsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttractionsEntity> page = this.page(
                new Query<AttractionsEntity>().getPage(params),
                new QueryWrapper<AttractionsEntity>()
        );

        return new PageUtils(page);
    }

}
