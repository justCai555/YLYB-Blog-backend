package com.ylyb.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ylyb.blog.entity.Article;
import com.ylyb.blog.mapper.ArticleMapper;
import com.ylyb.blog.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2022-07-26
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public boolean publish(Article article) {
        int i = articleMapper.insert(article);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Article> getArticleByUid(Integer uid) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper();
        queryWrapper.eq("article_author", uid);
        List<Article> res = articleMapper.selectList(queryWrapper);
        return res;
    }

    @Override
    public Article getArticleById(Integer id) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper();
        queryWrapper.eq("article_id", id);
        Article article = articleMapper.selectOne(queryWrapper);
        return article;
    }

    @Override
    public boolean deleteArticleById(Integer id) {
        Article article = new Article(id);
        int i = articleMapper.deleteById(article);
        if(i >0){
            return true;
        }else {
            return false;
        }
    }
}
