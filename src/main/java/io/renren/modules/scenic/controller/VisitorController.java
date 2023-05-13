package io.renren.modules.scenic.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.scenic.entity.VisitorEntity;
import io.renren.modules.scenic.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


/**
 * @author chenle
 * @email chenle2020ynu@163.com
 * @date 2023-05-12 21:01:43
 */
@RestController
@RequestMapping("/visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = visitorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{visitorId}")
    public R info(@PathVariable("visitorId") Integer visitorId) {
        VisitorEntity visitor = visitorService.getById(visitorId);

        return R.ok().put("visitor", visitor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody VisitorEntity visitor) {
        visitor.setCreatetime(new Date());
        visitorService.save(visitor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody VisitorEntity visitor) {
        visitorService.updateById(visitor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] visitorIds) {
        visitorService.removeByIds(Arrays.asList(visitorIds));

        return R.ok();
    }

}
