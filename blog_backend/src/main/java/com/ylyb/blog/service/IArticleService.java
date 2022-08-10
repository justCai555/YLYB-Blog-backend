package com.ylyb.blog.service;

import com.ylyb.blog.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2022-07-26
 */
public interface IArticleService extends IService<Article> {
    /**
     * 发布文章
     * @param article
     * @return boolean
     */
    public boolean publish(Article article);

    /**
     * 根据用户uid来获取文章列表
     * @param uid
     * @return
     */
    public List<Article> getArticleByUid(Integer uid);

    /**
     * 根据文章id来获取文章详细内容
     * @param id
     * @return
     */
    public Article getArticleById(Integer id);

    /**
     * 根据文章id删除文章
     * @param id
     * @return
     */
    public boolean deleteArticleById(Integer id);
}
