package com.ylyb.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author 作者
 * @since 2022-08-05
 */
public class Drafts implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "draft_id", type = IdType.AUTO)
    private Integer draftId;

    private String articleName;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private Integer authorId;

    private String article;

    public Drafts(String articleName, Integer authorId, String article, LocalDateTime createTime){
        this.article = article;
        this.articleName = articleName;
        this.authorId = authorId;
        this.createTime = createTime;
        this.modifyTime = null;
    }


    public Integer getDraftId() {
        return draftId;
    }

    public void setDraftId(Integer draftId) {
        this.draftId = draftId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Drafts{" +
        "draftId=" + draftId +
        ", articleName=" + articleName +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        ", authorId=" + authorId +
        ", article=" + article +
        "}";
    }
}
