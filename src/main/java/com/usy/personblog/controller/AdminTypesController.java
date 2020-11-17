package com.usy.personblog.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usy.personblog.mapper.BlogMapper;
import com.usy.personblog.mapper.TypeMapper;
import com.usy.personblog.models.Blog;
import com.usy.personblog.models.BlogExample;
import com.usy.personblog.models.Type;
import com.usy.personblog.models.TypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminTypesController {
    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private BlogMapper blogMapper;

    /**
     * 列出所有分类
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("/types")
    public String listType(@RequestParam(required = false, defaultValue = "1", value = "pageNum") Integer pageNum,
                           @RequestParam(defaultValue = "6", value = "pageSize") Integer pageSize, Model model) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        PageHelper.startPage(pageNum, pageSize);
        TypeExample typeExample = new TypeExample();
        typeExample.setOrderByClause("ID DESC");
        List<Type> typeList = typeMapper.selectByExample(typeExample);
        PageInfo<Type> typeInfo = new PageInfo<>(typeList, pageSize);
        model.addAttribute("pageInfo", typeInfo);
        return "admin/types";
    }

    /**
     * 跳转到增加页面
     *
     * @param model
     * @return
     */
    @GetMapping("/types/input")
    public String inputType(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    /**
     * 增加分类
     *
     * @param type
     * @return
     */
    @RequestMapping(value = "/types", method = RequestMethod.POST)
    public String addType(Type type, RedirectAttributes attributes) {
        TypeExample typeExample = new TypeExample();
        typeExample.createCriteria()
                .andNameEqualTo(type.getName());
        List<Type> type1 = typeMapper.selectByExample(typeExample);
        if (!type1.isEmpty()) {
            attributes.addFlashAttribute("messages", "分类名称已经存在");
            return "redirect:/admin/types/input";
        } else {
            int t = typeMapper.insert(type);
            if (t == 0) {
                attributes.addFlashAttribute("message", "新增失败");

            } else {
                attributes.addFlashAttribute("message", "新增成功");
            }
            return "redirect:/admin/types";
        }
    }

    /**
     * 回显编辑的分类
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/types/{id}/input")
    public String getEditType(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeMapper.selectByPrimaryKey(id));
        return "admin/types-input";
    }

    /**
     * 修改分类
     *
     * @param type
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/types/edit")
    public String updateType(Type type, RedirectAttributes attributes) {
        TypeExample typeExample = new TypeExample();
        typeExample.createCriteria()
                .andNameEqualTo(type.getName());
        List<Type> type1 = typeMapper.selectByExample(typeExample);
        if (!type1.isEmpty()) {
            attributes.addFlashAttribute("messages", "修改分类名称已经存在");
            return "redirect:/admin/types/input";
        } else {
            int t = typeMapper.updateByPrimaryKey(type);
            if (t == 0) {
                attributes.addFlashAttribute("message", "修改失败");

            } else {
                attributes.addFlashAttribute("message", "修改成功");
            }
            return "redirect:/admin/types";
        }
    }

    /**
     * 删除分类
     *
     * @param id
     * @return
     */
    @GetMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id, RedirectAttributes attributes) {
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria()
                .andTypeIdEqualTo(id);
        List<Blog> blog = blogMapper.selectByBlogExample(blogExample);
        if (!blog.isEmpty()) {
            attributes.addFlashAttribute("messages", "这是有关联的数据无法删除,请先删除相关数据");
            return "redirect:/admin/types";
        } else {
            typeMapper.deleteByPrimaryKey(id);
            attributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/admin/types";

    }
}