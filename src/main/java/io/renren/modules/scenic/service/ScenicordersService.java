package io.renren.modules.scenic.service;



import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.scenic.entity.ScenicordersEntity;
import io.renren.modules.scenic.vo.ScenicOrderResVo;


import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-13 16:54:11
 */
public interface ScenicordersService extends IService<ScenicordersEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ScenicOrderResVo> listall();

    boolean judgeVisitorAlive(ScenicordersEntity scenicorders);

    boolean judgeSpotAlive(ScenicordersEntity scenicorders);

    boolean judgeSpotStatus(ScenicordersEntity scenicorders);
}

