package com.ylyb.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ylyb.blog.entity.Drafts;
import com.ylyb.blog.mapper.DraftsMapper;
import com.ylyb.blog.service.IDraftsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2022-08-05
 */
@Service
public class DraftsServiceImpl extends ServiceImpl<DraftsMapper, Drafts> implements IDraftsService {
    @Autowired
    private DraftsMapper draftsMapper;

    @Override
    public List<Drafts> userGetDrafts(int uid) {
        QueryWrapper<Drafts> queryWrapper = new QueryWrapper();
        queryWrapper.eq("author_id", uid);
        List<Drafts> res = draftsMapper.selectList(queryWrapper);
        return res;
    }
}
