package io.renren.modules.scenic.vo;

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
public class ScenicOrderResVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderId;
    /**
     *
     */
    private Integer visitorId;

    private String visitorName;
    private String visitorPhone;
    /**
     *
     */
    private Integer scenicId;

    private String scenicName;
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
    private String type;

}
