package io.renren.modules.scenic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.scenic.entity.AdminEntity;

import java.util.Map;

/**
 * 系统用户
 *
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-25 15:49:54
 */
public interface AdminService extends IService<AdminEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

