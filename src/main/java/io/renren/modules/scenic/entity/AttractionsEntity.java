package io.renren.modules.scenic.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 *
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-12 21:01:43
 */
@Data
@TableName("attractions")
@NoArgsConstructor
@AllArgsConstructor
public class AttractionsEntity extends Attractions implements Serializable {
	@TableId
	private Integer attractionsId;
	private String scenicName;
	/**
	 *
	 */
	private Integer scenicId;
	/**
	 *
	 */
	private String scenicDescription;

	/**
	 *
	 */
	private Integer peopleNumber;
	/**
	 *
	 */
	private Integer status;
	/**
	 *
	 */
	private double price;
}
