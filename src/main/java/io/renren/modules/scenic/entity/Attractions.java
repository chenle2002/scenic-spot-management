package io.renren.modules.scenic.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

public abstract class Attractions {
    private static final long serialVersionUID = 1L;
    private String scenicName;
    /**
     *
     */
    private Integer scenicId;

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
    /**
     *
     */
    private String scenicDescription;

    public double getPrice() {
        return price;
    }

    public String getScenicDescription() {
        return scenicDescription;
    }
}
