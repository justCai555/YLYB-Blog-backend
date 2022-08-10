package com.ylyb.blog.service;

import com.ylyb.blog.entity.Drafts;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 作者
 * @since 2022-08-05
 */
public interface IDraftsService extends IService<Drafts> {

    public List<Drafts> userGetDrafts(int uid);
}
