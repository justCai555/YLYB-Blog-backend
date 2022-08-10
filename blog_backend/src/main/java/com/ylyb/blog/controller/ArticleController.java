package com.ylyb.blog.controller;


import com.ylyb.blog.entity.Article;
import com.ylyb.blog.service.impl.ArticleServiceImpl;
import com.ylyb.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @Autowired
    private ArticleServiceImpl articleService;

    @RequestMapping(value = "/publish", method = {RequestMethod.POST, RequestMethod.GET})
    public R publish(@RequestBody Map<String, Object> map){
        System.out.println(map.get("articleName"));
        System.out.println(map.get("articleJson"));

        return R.ok();
    }

    @RequestMapping("/getArticleByUid")
    public R userGetArticle(@RequestBody Map<String, Object> map){
        int uid = (int) map.get("uid");
        List<Article> articles= articleService.getArticleByUid(uid);
        return R.ok(articles);
    }

    @RequestMapping("/getArticleById")
    public R getArticleById(@RequestBody Map<String, Object> map){
        int id = (int)map.get("id");
        Article article = articleService.getArticleById(id);
        return R.ok(article);
    }


}

