package cn.losemen.statistics.controller.admin;

import cn.losemen.common.vo.R;
import cn.losemen.statistics.service.DailyService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/4 - 15:11
 */
@CrossOrigin
@RestController
@RequestMapping("/admin/statistics/daily")
public class DailyAdminController {

    @Autowired
    private DailyService dailyService;

    @GetMapping("{day}")
    public R createStatisticsByDate(@PathVariable String day) {
        dailyService.createStatisticsByDay(day);
        return R.success();
    }

    @GetMapping("/show-chart/{begin}/{end}/{type}")
public R showChart(@PathVariable String begin,@PathVariable String end,@PathVariable String type){
    Map<String, Object> map = dailyService.getChartData(begin, end, type);
    return R.success().data(map);
}
}
