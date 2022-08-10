package com.ylyb.blog.controller;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-07-26
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @RequestMapping(value = "/publish", method = {RequestMethod.POST, RequestMethod.GET})
    public boolean publish(@RequestBody Map<String, Object> map){
        System.out.println(map.get("articleName"));
        System.out.println(map.get("articleJson"));

        return Boolean.TRUE;
    }
}

