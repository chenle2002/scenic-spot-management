package io.renren.modules.scenic.service;



import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.scenic.entity.OrderEntity;

import java.util.Map;

/**
 *
 *
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-12 21:01:42
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

