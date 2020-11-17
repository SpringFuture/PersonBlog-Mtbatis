package com.usy.personblog.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usy.personblog.mapper.*;
import com.usy.personblog.models.*;
import com.usy.personblog.service.CommentService;
import com.usy.personblog.util.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class indexController {
    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired

    private UserMapper userMapper;

    @Autowired
    private CommentService commentService;

    /**
     * 博客首页
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("/")
    public String getBlogList(@RequestParam(required = false,defaultValue = "1",value = "pageNum") Integer pageNum,
                              @RequestParam(defaultValue ="6",value = "pageSize")Integer pageSize,
                              Model model,Blog blog){
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;    //设置默认每页显示的数据数
        }
        //获取博客
        BlogExample blogExample=new BlogExample();
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogList=blogMapper.selectByBlogUserExample(blogExample);
        PageInfo<Blog> pageInfo=new PageInfo<>(blogList,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        //获取分类
        TypeExample typeExample=new TypeExample();
        PageHelper.startPage(pageNum,pageSize);
        List<Type> typeList=typeMapper.selectByExample(typeExample);
        for (int i = 0; i < typeList.size(); i++) {
            BlogExample blogExample1=new BlogExample();
            blogExample1.createCriteria()
                    .andTypeIdEqualTo(typeList.get(i).getId());
            typeList.get(i).setCount(blogMapper.countByExample(blogExample1));
        }
        PageInfo<Type> typePageInfo=new PageInfo<>(typeList,pageSize);
        model.addAttribute("typePageInfo",typePageInfo);
        //获取标签
        TagExample tagExample=new TagExample();
        PageHelper.startPage(pageNum,pageSize);
        List<Tag> tagList=tagMapper.selectByExample(tagExample);
        for (int i = 0; i < tagList.size(); i++) {
            BlogExample blogExample2=new BlogExample();
            blogExample2.createCriteria()
                    .andTagIdsLike("%"+tagList.get(i).getId().toString()+"%");
            tagList.get(i).setCount(blogMapper.countByExample(blogExample2));
        }
        PageInfo<Tag> tagPageInfo=new PageInfo<>(tagList,pageSize);
        model.addAttribute("tagPageInfo",tagPageInfo);
        //获取最新推荐
        BlogExample blogExample1=new BlogExample();
        PageHelper.startPage(pageNum,pageSize);
        blogExample1.createCriteria()
                .andRecommendEqualTo(true);
        List<Blog> blogList1=blogMapper.selectByBlogExample(blogExample1);
        PageInfo<Blog> pageInfo1=new PageInfo<>(blogList1,pageSize);
        model.addAttribute("recommendBlog",pageInfo1);
        return "index";
    }

    /**
     * 搜索博客
     * @param pageNum
     * @param pageSize
     * @param model
     * @param blog
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String searchBlog(@RequestParam(required = false,defaultValue = "1",value = "pageNum") Integer pageNum,
                             @RequestParam(defaultValue ="6",value = "pageSize")Integer pageSize,
                             Model model,Blog blog){
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;    //设置默认每页显示的数据数
        }
        //获取博客
        PageHelper.startPage(pageNum,pageSize);
        BlogExample blogExample=new BlogExample();
        blogExample.createCriteria()
                .andTitleLike("%"+blog.getTitle()+"%");
        List<Blog> blogList=blogMapper.selectByBlogExample(blogExample);
        for (int i = 0; i <blogList.size() ; i++) {
            UserExample userExample=new UserExample();
            userExample.createCriteria()
                    .andIdEqualTo(blogList.get(i).getUserId());
            List<User> users=userMapper.selectByExample(userExample);
            blogList.get(i).setUser(users.get(0));
            TypeExample typeExample=new TypeExample();
            typeExample.createCriteria()
                    .andIdEqualTo(blogList.get(i).getTypeId());
            List<Type> type=typeMapper.selectByExample(typeExample);
            blogList.get(i).setType(type.get(0));
        }
        PageInfo<Blog> pageInfo=new PageInfo<>(blogList,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        //获取分类
        TypeExample typeExample=new TypeExample();
        PageHelper.startPage(pageNum,pageSize);
        List<Type> typeList=typeMapper.selectByExample(typeExample);
        for (int i = 0; i < typeList.size(); i++) {
            BlogExample blogExample3=new BlogExample();
            blogExample3.createCriteria()
                    .andTypeIdEqualTo(typeList.get(i).getId());
            typeList.get(i).setCount(blogMapper.countByExample(blogExample3));
        }
        PageInfo<Type> typePageInfo=new PageInfo<>(typeList,pageSize);
        model.addAttribute("typePageInfo",typePageInfo);
        //获取标签
        TagExample tagExample=new TagExample();
        PageHelper.startPage(pageNum,pageSize);
        List<Tag> tagList=tagMapper.selectByExample(tagExample);
        for (int i = 0; i < typeList.size(); i++) {
            BlogExample blogExample2=new BlogExample();
            blogExample2.createCriteria()
                    .andTagIdsLike("%"+tagList.get(i).getId().toString()+"%");
            tagList.get(i).setCount(blogMapper.countByExample(blogExample2));
        }
        PageInfo<Tag> tagPageInfo=new PageInfo<>(tagList,pageSize);
        model.addAttribute("tagPageInfo",tagPageInfo);
        //获取最新推荐
        BlogExample blogExample1=new BlogExample();
        PageHelper.startPage(pageNum,pageSize);
        blogExample1.createCriteria()
                .andRecommendEqualTo(true);
        List<Blog> blogList1=blogMapper.selectByBlogExample(blogExample1);
        PageInfo<Blog> pageInfo1=new PageInfo<>(blogList1,pageSize);
        model.addAttribute("recommendBlog",pageInfo1);
        return "index";
    }

    /**
     * 博客详情
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model){
        Blog blog=blogMapper.selectByPrimaryKey(id);
        Blog b=new Blog();
        BeanUtils.copyProperties(blog,b);
        String content =b.getContent();
        b.setContent( MarkdownUtils.markdownToHtmlExtensions(content));
        User user=userMapper.selectByPrimaryKey(b.getUserId());
        b.setUser(user);
        //增加浏览次数
        int view=blog.getViews()+1;
        b.setViews(view);
        blogMapper.updateByPrimaryKey(b);
        model.addAttribute("blog",b);
        //获取评论
        List<Comment> comments = commentService.listComment(id);
        model.addAttribute("comments", comments);
        //获取标签
        List<Long> tagList=convertToList(blog.getTagIds());
        TagExample tagExample=new TagExample();
        tagExample.createCriteria()
                .andIdIn(tagList);
        model.addAttribute("tags",tagMapper.selectByExample(tagExample));
        return "blog";
    }

    /**
     * 关于自己
     * @return
     */
    @RequestMapping(value = "/blog/about",method = RequestMethod.GET)
    public String about(){
        return "about";
    }

    /**
     * 关于女神
     * @return
     */
    @GetMapping("/blog/goddess")
    public String goddess(){
        return "goddess";
    }

    /**
     * 获取tagIds
     * @param ids
     * @return
     */
    private List<Long> convertToList(String ids){
        List<Long> list=new ArrayList<>();

        if (!"".equals(ids) && ids !=null){
            String[] idArray=ids.split(",");
            for (int i = 0; i <idArray.length ; i++) {
                list.add(new Long(idArray[i]));
            }
        }
        return list;
    }

}
