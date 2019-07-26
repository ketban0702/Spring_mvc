package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

/**
 * @author Minh_Nguyen on  7/21/2019
 * @Project TimeController
 * @Email:
 */
@Controller
public class TimeController {
    @GetMapping("/worldclock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
