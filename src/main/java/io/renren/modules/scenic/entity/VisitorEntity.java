package io.renren.modules.scenic.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-12 21:01:43
 */
@Data
@TableName("visitor")
public class VisitorEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer visitorId;
	private String phone;
	private String visitorname;
	private Date createtime;
}
