package io.renren.modules.scenic.service;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.scenic.entity.ScenicordersEntity;
import io.renren.modules.scenic.entity.VisitorEntity;

import java.util.Map;

/**
 *
 *
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-12 21:01:43
 */
public interface VisitorService extends IService<VisitorEntity> {

    PageUtils queryPage(Map<String, Object> params);
    public boolean judgeVisitorAlive(ScenicordersEntity scenicorders);
}

