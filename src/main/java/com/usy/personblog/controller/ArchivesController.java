package com.usy.personblog.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usy.personblog.mapper.BlogMapper;
import com.usy.personblog.models.Blog;
import com.usy.personblog.models.BlogExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArchivesController {

    @Autowired
    private BlogMapper blogMapper;

    /**归档页
     * 获取
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("/blog/archives")
    public String blogArchives(@RequestParam(required = false,defaultValue = "1",value = "pageNum") Integer pageNum,
                               @RequestParam(defaultValue ="6",value = "pageSize")Integer pageSize,
                               Model model){
        PageHelper.startPage(pageNum,pageSize);
        BlogExample blogExample=new BlogExample();
        List<Blog> blogList =blogMapper.selectByBlogExample(blogExample);
        PageInfo<Blog> pageInfo=new PageInfo<>(blogList,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "archives";
    }
}
