package io.renren.modules.scenic.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.modules.scenic.status.ScenicOffState;
import io.renren.modules.scenic.status.ScenicOnState;
import io.renren.modules.scenic.status.ScenicState;
import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-12 21:01:43
 */
@Data
@TableName("scenic_spot")
public class ScenicSpotEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer scenicId;
	/**
	 *
	 */
	private String scenicName;
	/**
	 *
	 */
	private String scenicDescription;
	/**
	 *
	 */
	private String scenicAddress;
	/**
	 *
	 */
	private Integer status;

	@TableField(exist = false)//忽略实体映射
	private ScenicState scenicState;

	public void setState(ScenicState state) {
		this.scenicState = state;
	}

	public void changeState() {
		//判断属性值，根据属性值进行状态转换
		if (status == 0) {
			//景区关闭，将ScenicOffState的对象赋给自己的scenicState
			this.setState(new ScenicOffState());
		}
		else if (status == 1) {
			//景区开放，将ScenicOnState的对象赋给自己的scenicState
			this.setState(new ScenicOnState());
		}
	}

	public boolean checkByScenic() {
		changeState();
		return scenicState.checkByScenic(); //调用状态对象的业务方法
	}
}
