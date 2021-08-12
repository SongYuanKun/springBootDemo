package com.songyuankun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取远端配置
 *
 * @author Administrator
 */

@RestController
//开启更新功能
@RequestMapping("api")
public class ConfigController {

    @Value("${my.version}")
    private String fromValue;

    /**
     * 返回配置文件中的值
     */
    @GetMapping("/from")
    @ResponseBody
    public String returnFormValue() {
        return fromValue;
    }
}