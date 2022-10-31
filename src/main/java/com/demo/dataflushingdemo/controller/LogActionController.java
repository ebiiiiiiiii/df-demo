package com.demo.dataflushingdemo.controller;

import com.demo.dataflushingdemo.service.LogMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ruitao.wei
 * @description: TODO
 * @date: 2022/10/31 16:23
 */
@RestController
public class LogActionController {

    @Autowired
    LogMqService logMqService;

    @GetMapping("/api/log/create")
    public String createRandomLog(Integer num) {
        return logMqService.produceRandomLogs(num) ? "success": "failure";
    }

}
