package io.renren.modules.scenic.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.scenic.entity.AttractionsEntity;
import io.renren.modules.scenic.service.AttractionsService;
import io.renren.modules.scenic.vo.AttractionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 *
 *
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-12 21:01:43
 */
@RestController
@RequestMapping("/attractions")
public class AttractionsController {
    @Autowired
    private AttractionsService attractionsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attractionsService.queryPage(params);
        List<AttractionVo> attractionVos=attractionsService.getlist();
        return R.ok().put("page", attractionVos);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attractionsId}")
    public R info(@PathVariable("attractionsId") Integer attractionsId){
		AttractionsEntity attractions = attractionsService.getById(attractionsId);

        return R.ok().put("attractions", attractions);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttractionsEntity attractions){
        if(attractionsService.judgeSpotAlive(attractions)){
            attractionsService.save(attractions);
            return R.ok();
        }else {
            return R.error("您输入的景区不存在!");
        }

    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttractionsEntity attractions){
		attractionsService.updateById(attractions);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] attractionsIds){
		attractionsService.removeByIds(Arrays.asList(attractionsIds));

        return R.ok();
    }

}
