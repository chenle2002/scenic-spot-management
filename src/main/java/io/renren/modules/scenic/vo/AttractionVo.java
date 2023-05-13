package io.renren.modules.scenic.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class AttractionVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Integer attractionsId;
    /**
     *
     */
    private String scenicName;
    /**
     *
     */
    private Integer scenicId;

    private String scenicSpotName;
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

}
