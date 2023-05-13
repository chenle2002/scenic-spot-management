package io.renren.modules.scenic.controller;


import java.util.*;

import io.renren.modules.scenic.entity.ScenicordersEntity;
import io.renren.modules.scenic.service.ScenicordersService;
import io.renren.modules.scenic.vo.ScenicOrderResVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-13 16:54:11
 */
@RestController
@RequestMapping("/scenicorders")
public class ScenicordersController {
    @Autowired
    private ScenicordersService scenicordersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {

        List<ScenicOrderResVo> list = scenicordersService.listall();

        return R.ok().put("page", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orderId}")
    public R info(@PathVariable("orderId") String orderId) {
        ScenicordersEntity scenicorders = scenicordersService.getById(orderId);

        return R.ok().put("scenicorders", scenicorders);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ScenicordersEntity scenicorders) {
        //判断游客存不存在
        if (scenicordersService.judgeVisitorAlive(scenicorders)) {
            //判断该景区存不存在
            if (scenicordersService.judgeSpotAlive(scenicorders)) {
                //判断购票景区是否开放
                if (scenicordersService.judgeSpotStatus(scenicorders)) {
                    scenicorders.setCreatetime(new Date());
                    scenicorders.setOrderId(String.valueOf(UUID.randomUUID()));
                    scenicordersService.save(scenicorders);
                    return R.ok();
                } else {
                    return R.error("您输入的景区状态未开放!");
                }
            } else {
                return R.error("您输入的景区不存在!");
            }
        } else {
            return R.error("您输入的游客不存在!");
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ScenicordersEntity scenicorders) {
        scenicordersService.updateById(scenicorders);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] orderIds) {
        scenicordersService.removeByIds(Arrays.asList(orderIds));

        return R.ok();
    }

}
