package io.renren.modules.scenic.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.scenic.entity.AdminEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户
 *
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-25 15:49:54
 */
@Mapper
public interface AdminDao extends BaseMapper<AdminEntity> {

}
