package com.dooioo.index.controller;

import com.dooioo.mongodb.service.MongodbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能说明：HelloWordController
 * 作者：liuxing(2014-11-14 02:03)
 */
@Controller
@RequestMapping(value="/index")
public class IndexController {

    @Autowired
    private MongodbService mongodbService;

    /**
     * 进入默认首页
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld() {
        return "index";
    }

    /**
     * 测试ajax中文是否乱码
     * @return
     */
    @RequestMapping(value="/jsonList", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> jsonList() {
        List<Map<String, Object>> reltList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Map<String, Object> map = new HashMap<>();
            mongodbService.findAndModify("80003");
            map.put(String.valueOf(i), mongodbService.findOne("80003"));
            reltList.add(map);
        }

        return reltList;
    }

}