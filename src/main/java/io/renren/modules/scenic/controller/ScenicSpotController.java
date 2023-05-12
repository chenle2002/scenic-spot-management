package io.renren.modules.scenic.controller;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.scenic.entity.ScenicSpotEntity;
import io.renren.modules.scenic.service.ScenicSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;





/**
 *
 *
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-12 21:01:43
 */
@RestController
@RequestMapping("/scenicspot")
public class ScenicSpotController {
    @Autowired
    private ScenicSpotService scenicSpotService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = scenicSpotService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{scenicId}")
    public R info(@PathVariable("scenicId") Integer scenicId){
		ScenicSpotEntity scenicSpot = scenicSpotService.getById(scenicId);

        return R.ok().put("scenicSpot", scenicSpot);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ScenicSpotEntity scenicSpot){
		scenicSpotService.save(scenicSpot);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ScenicSpotEntity scenicSpot){
		scenicSpotService.updateById(scenicSpot);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] scenicIds){
		scenicSpotService.removeByIds(Arrays.asList(scenicIds));

        return R.ok();
    }

}
