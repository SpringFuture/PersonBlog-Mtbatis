package com.usy.personblog.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usy.personblog.mapper.BlogMapper;
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
public class TypeController {

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 分类页
     * @param pageNum
     * @param pageSize
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/types/{id}")
    public String blogType(@RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                           @RequestParam(defaultValue = "4",value ="pageSize" )Integer pageSize,
                           @PathVariable Long id, Model model){

        TypeExample typeExample=new TypeExample();
        List<Type> typeList=typeMapper.selectByExample(typeExample);
        if (id==-1){
            id=typeList.get(0).getId();
        }
        for (int i = 0; i < typeList.size(); i++) {
            BlogExample blogExample1=new BlogExample();
            blogExample1.createCriteria()
                    .andTypeIdEqualTo(typeList.get(i).getId());
            typeList.get(i).setCount(blogMapper.countByExample(blogExample1));
        }
        PageHelper.startPage(pageNum,pageSize);
        BlogExample blogExample=new BlogExample();
        blogExample.createCriteria()
                .andTypeIdEqualTo(id);
        List<Blog> blogList=blogMapper.selectByBlogExample(blogExample);
        for (int i = 0; i <blogList.size() ; i++) {
            UserExample userExample=new UserExample();
            userExample.createCriteria()
                    .andIdEqualTo(blogList.get(i).getUserId());
            List<User> users=userMapper.selectByExample(userExample);
            blogList.get(i).setUser(users.get(0));
            TypeExample typeExample1=new TypeExample();
            typeExample.createCriteria()
                    .andIdEqualTo(blogList.get(i).getTypeId());
            List<Type> type=typeMapper.selectByExample(typeExample1);
            blogList.get(i).setType(type.get(0));
        }
        PageInfo<Blog> pageInfo=new PageInfo<>(blogList,pageSize);
        model.addAttribute("types",typeList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("activeTypeId",id);
    return "types";
    }

}
