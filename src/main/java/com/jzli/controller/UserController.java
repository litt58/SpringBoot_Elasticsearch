package com.jzli.controller;

import com.jzli.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * =======================================================
 *
 * @Company 金色家网络科技有限公司-开发测试云服务部
 * @Date ：2016/7/6
 * @Author ：li.jinzhao
 * @Version ：0.0.1
 * @Description ：
 * ========================================================
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户接口", description = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ApiOperation(value = "hello", httpMethod = "GET", response = String.class)
    public String hello() {
        return "hello";
    }


    @RequestMapping(value = "saveAll", method = RequestMethod.GET)
    @ApiOperation(value = "saveAll", httpMethod = "GET", response = Boolean.class)
    public Boolean saveAll() {
        return userService.saveAll();
    }


    @RequestMapping(value = "search", method = RequestMethod.POST)
    @ApiOperation(value = "{\"search\":\"search\"}", httpMethod = "POST")
    public Object search(String search) {
        return userService.findByNameLikeOrMobileLike(search);
    }

}