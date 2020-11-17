package com.usy.personblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usy.personblog.mapper.BlogMapper;
import com.usy.personblog.mapper.TagMapper;
import com.usy.personblog.mapper.TypeMapper;
import com.usy.personblog.mapper.UserMapper;
import com.usy.personblog.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class TagController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private TypeMapper typeMapper;

    /**
     * 便签页
     * @param pageNum
     * @param pageSize
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/tags/{id}")
    public String blogTag(@RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                          @RequestParam(defaultValue = "4",value ="pageSize" )Integer pageSize,
                          @PathVariable Long id, Model model){
        //获取标签
        TagExample tagExample=new TagExample();
        List<Tag> tagList=tagMapper.selectByExample(tagExample);
        if (id==-1){
            id=tagList.get(0).getId();
        }
        //获取博客记录
        for (int i = 0; i < tagList.size(); i++) {
            BlogExample blogExample=new BlogExample();
            blogExample.createCriteria()
                    .andTagIdsLike("%"+tagList.get(i).getId().toString()+"%");
            tagList.get(i).setCount(blogMapper.countByExample(blogExample));
        }
        //分页
        PageHelper.startPage(pageNum,pageSize);
        BlogExample blogExample1=new BlogExample();
        //获取标签博客
        blogExample1.createCriteria()
                .andTagIdsLike("%"+id.toString()+"%");
        List<Blog> blogList=blogMapper.selectByBlogExample(blogExample1);
        //获取博客User
        for (int i = 0; i <blogList.size() ; i++) {
            UserExample userExample=new UserExample();
            userExample.createCriteria()
                    .andIdEqualTo(blogList.get(i).getUserId());
            List<User> users=userMapper.selectByExample(userExample);
            blogList.get(i).setUser(users.get(0));
            TypeExample typeExample1=new TypeExample();
            typeExample1.createCriteria()
                    .andIdEqualTo(blogList.get(i).getTypeId());
            List<Type> type=typeMapper.selectByExample(typeExample1);
            blogList.get(i).setType(type.get(0));
        }
        PageInfo<Blog> pageInfo=new PageInfo<>(blogList,pageSize);
        model.addAttribute("tags",tagList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("activeTagId",id);
        return "tags";
    }

}
