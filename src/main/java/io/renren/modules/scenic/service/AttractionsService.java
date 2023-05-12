package io.renren.modules.scenic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.scenic.entity.AttractionsEntity;

import java.util.Map;

/**
 *
 *
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-12 21:01:43
 */
public interface AttractionsService extends IService<AttractionsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

