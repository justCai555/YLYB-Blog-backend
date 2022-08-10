package com.ylyb.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author 作者
 * @since 2022-07-26
 */
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;

    private String articleName;

    private String articleContent;

    private String articleImg;

    private Integer articleAuthor;

    private LocalDate articleCreateTime;

    private LocalDate articleModifyTime;

    private Integer isAudit;


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleImg() {
        return articleImg;
    }

    public void setArticleImg(String articleImg) {
        this.articleImg = articleImg;
    }

    public Integer getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(Integer articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public LocalDate getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(LocalDate articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    public LocalDate getArticleModifyTime() {
        return articleModifyTime;
    }

    public void setArticleModifyTime(LocalDate articleModifyTime) {
        this.articleModifyTime = articleModifyTime;
    }

    public Integer getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(Integer isAudit) {
        this.isAudit = isAudit;
    }

    @Override
    public String toString() {
        return "Article{" +
        "articleId=" + articleId +
        ", articleName=" + articleName +
        ", articleContent=" + articleContent +
        ", articleImg=" + articleImg +
        ", articleAuthor=" + articleAuthor +
        ", articleCreateTime=" + articleCreateTime +
        ", articleModifyTime=" + articleModifyTime +
        ", isAudit=" + isAudit +
        "}";
    }
}
