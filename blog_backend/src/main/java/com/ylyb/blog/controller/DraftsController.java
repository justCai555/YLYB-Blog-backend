package com.ylyb.blog.controller;


import com.ylyb.blog.entity.Drafts;
import com.ylyb.blog.service.impl.DraftsServiceImpl;
import com.ylyb.blog.utils.R;
import com.ylyb.blog.utils.ResultCode;
import com.ylyb.blog.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2022-08-05
 */
@Controller
@RequestMapping("/api/drafts")
public class DraftsController {
    @Autowired
    DraftsServiceImpl draftsService;

    @RequestMapping("/userGetDrafts")
    public R userGetDrafts(@RequestBody Map<String, String> map){
        String token = map.get("token");
        if(!TokenUtil.verify(token)){
            return R.failed(ResultCode.USER_NOT_LOGIN);
        }
        int uid = Integer.valueOf(map.get("uid"));
        List<Drafts> drafts = draftsService.userGetDrafts(uid);
        return R.ok(drafts);
    }

    @RequestMapping(value = "/saveDraft", produces = "application/json;charset=UTF-8")
    public R saveDraft(@RequestBody Map map){
        String token = (String) map.get("token");
        if(!TokenUtil.verify(token)){
            return R.failed(ResultCode.USER_NOT_LOGIN);
        }
        System.out.println(map.values());
        int uid =  Integer.valueOf((String)map.get("uid"));
        String articleName = (String) map.get("articleName");
        Object articleJson = map.get("articleJson");
//        System.out.println(articleJson.getClass().toString() );   //LinkedHashMap

        LocalDateTime createTime = LocalDateTime.now();
        Drafts draft = new Drafts(articleName, uid, null, createTime);

        boolean res = draftsService.save(draft);
        if(res){
            return R.ok();
        }else {
            return R.failed();
        }

    }

}

