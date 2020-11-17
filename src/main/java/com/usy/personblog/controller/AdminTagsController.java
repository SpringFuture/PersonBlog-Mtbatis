package com.usy.personblog.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usy.personblog.mapper.BlogMapper;
import com.usy.personblog.mapper.TagMapper;
import com.usy.personblog.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminTagsController {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private BlogMapper blogMapper;

    /**
     * 获取标签列表
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("/tags")
    public String listTag(@RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                        @RequestParam(defaultValue = "6",value = "pageSize")Integer pageSize,Model model){
        if (pageNum==null){
            pageNum=1;
        }
        if (pageNum<=1){
            pageNum=1;
        }if (pageSize==null){
            pageSize=6;
        }
        PageHelper.startPage(pageNum,pageSize);
        TagExample tagExample=new TagExample();
        List<Tag> tagList=tagMapper.selectByExample(tagExample);
        PageInfo<Tag> tagInfo=new PageInfo<>(tagList,pageSize);
        model.addAttribute("pageInfo",tagInfo);
        return "admin/tags";
    }

    /**
     * 跳转增加标签页面
     * @param model
     * @return
     */
    @GetMapping("/tags/input")
    public String inputTag(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }

    /**
     * 添加博客
     * @param tag
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/tags",method = RequestMethod.POST)
    public String addTag(Tag tag,RedirectAttributes attributes){
        TagExample tagExample=new TagExample();
        tagExample.createCriteria()
                .andNameEqualTo(tag.getName());
        List<Tag> tagList=tagMapper.selectByExample(tagExample);
        if(!tagList.isEmpty()){
            attributes.addFlashAttribute("messages", "标签名称已经存在");
            return "redirect:/admin/tags/input";
        }else {
            int t=tagMapper.insert(tag);
            if (t == 0) {
                attributes.addFlashAttribute("message", "新增失败");

            } else {
                attributes.addFlashAttribute("message", "新增成功");
            }
        }
        return "redirect:/admin/tags";
    }

    /**
     * 回显编辑的标签
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/tags/{id}/input")
    public String getEditTag(@PathVariable Long id,Model model){
        model.addAttribute("tag",tagMapper.selectByPrimaryKey(id));
        return "admin/tags-input";
    }

    /**
     * 编辑博客
     * @param tag
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/tags/edit",method = RequestMethod.POST)
    public String edit(Tag tag,RedirectAttributes attributes){
        TagExample tagExample =new TagExample();
        tagExample.createCriteria()
                .andNameEqualTo(tag.getName());
        List<Tag> tagList=tagMapper.selectByExample(tagExample);
        if(!tagList.isEmpty()){
            attributes.addFlashAttribute("messages", "标签名称已经存在");
            return "redirect:/admin/tags/input";
        }else {
            int t=tagMapper.updateByPrimaryKey(tag);
            if (t == 0) {
                attributes.addFlashAttribute("message", "新增失败");

            } else {
                attributes.addFlashAttribute("message", "新增成功");
            }
        }
        return "redirect:/admin/tags";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/tags/{id}/delete")
    public String deleteTag(@PathVariable Long id,RedirectAttributes attributes) {
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria()
                .andTagIdsLike("%" + id.toString() + "%");
        List<Blog> blogList = blogMapper.selectByBlogExample(blogExample);
        if (!blogList.isEmpty()) {
            attributes.addFlashAttribute("messages", "这是有关联的数据无法删除,请先删除相关数据");
            return "redirect:/admin/tags";
        } else {
            tagMapper.deleteByPrimaryKey(id);
            attributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/admin/tags";
    }
}
