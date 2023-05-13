package io.renren.modules.scenic.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 *
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-13 16:54:11
 */
@Data
@TableName("scenic_orders")
public class ScenicordersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private String orderId;
	/**
	 *
	 */
	private Integer visitorId;
	/**
	 *
	 */
	private Integer scenicId;
	/**
	 *
	 */
	private String description;
	/**
	 *
	 */
	private String price;
	/**
	 *
	 */
	private Date createtime;

}
