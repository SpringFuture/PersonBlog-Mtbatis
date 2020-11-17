package com.usy.personblog.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usy.personblog.mapper.BlogMapper;
import com.usy.personblog.mapper.TagMapper;
import com.usy.personblog.mapper.TypeMapper;
import com.usy.personblog.models.*;
import com.usy.personblog.util.MyBeanUtils;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminBlogController {

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private TagMapper tagMapper;

    /**
     * 后台博客管理
     * @param pageNum
     * @param pageSize
     * @param model
     *
     * @return
     */
    @GetMapping("/blogs")
    public String blogs(@RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                         @RequestParam(defaultValue="8",value="pageSize")Integer pageSize,
                         Model model){
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;    //设置默认每页显示的数据数
        }
        System.out.println("当前页是："+pageNum+"显示条数是："+pageSize);
        TypeExample typeExample=new TypeExample();
        model.addAttribute("types",typeMapper.selectByExample(typeExample));;
        PageHelper.startPage(pageNum,pageSize);
        BlogExample blogExample=new BlogExample();
        List<Blog> blogList=blogMapper.selectByExample(blogExample);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }

    /**
     * 博客搜索
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/blogs/search",method = RequestMethod.POST)
    public String getBlogList(Model model,@RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                              @RequestParam(defaultValue="5",value="pageSize")Integer pageSize,BlogQuery blogQuery){
        //为了程序的严谨性，判断非空：
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;    //设置默认每页显示的数据数
        }
        System.out.println("当前页是："+pageNum+"显示条数是："+pageSize);
        PageHelper.startPage(pageNum,pageSize);
        BlogExample blogExample=new BlogExample();
        BlogExample.Criteria criteria=blogExample.createCriteria();
        //模糊查询
        if(blogQuery!=null){
            if (blogQuery.getTitle()!=null&& blogQuery.getTitle().length()>0){
                criteria.andTitleLike("%"+blogQuery.getTitle()+"%");
            }
            if (blogQuery.getTypeId()!=null){
                criteria.andTypeIdEqualTo(blogQuery.getTypeId());
            }
            if(blogQuery.isRecommend()){
                criteria.andRecommendEqualTo(blogQuery.isRecommend());
            }
        }
        List<Blog> blogList=blogMapper.selectByBlogExample(blogExample);
        for (int i = 0; i <blogList.size() ; i++) {
            blogList.get(i).setType(typeMapper.selectByPrimaryKey( blogList.get(i).getTypeId()));
        }
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogList,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs :: blogList";
    }

    /**
     * 添加操作
     * @param model
     * @return
     */

    @GetMapping("/blogs/input")
    public String addBlog(Model model){
        TypeExample typeExample=new TypeExample();
        model.addAttribute("types",typeMapper.selectByExample(typeExample));
        TagExample tagExample=new TagExample();
        model.addAttribute("tags",tagMapper.selectByExample(tagExample));
        model.addAttribute("blog",new Blog());
        return "admin/blogs-input";
    }

    /**
     * 添加博客
     * @param blog
     * @param attributes
     * @param session
     * @return
     */
    @RequestMapping(value = "/blogs",method = RequestMethod.POST)
    public String editBlog(Blog blog, RedirectAttributes attributes,HttpSession session){
        //增加
        int b;
        if (blog.getId()==null){
            blog.setUserId((Long) session.getAttribute("id"));
            blog.setTypeId(blog.getTypeId());
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
            b=blogMapper.insert(blog);
        }else {
            //编辑修改
            Blog blogs=blogMapper.selectByPrimaryKey(blog.getId());
            if (blogs == null){
                try {
                    throw new NotFoundException("不存在");
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
            }
            BeanUtils.copyProperties(blog,blogs, MyBeanUtils.gerNullPropertyNames(blog));
            blogs.setUpdateTime(new Date());
            b=blogMapper.updateByPrimaryKey(blogs);
        }
        if (b==0){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/blogs";
    }

    /**
     * 修改博客
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/blogs/input{id}")
    public String updateBlog(@PathVariable Long id,Model model){
        TypeExample typeExample=new TypeExample();
        model.addAttribute("types",typeMapper.selectByExample(typeExample));
        TagExample tagExample=new TagExample();
        model.addAttribute("tags",tagMapper.selectByExample(tagExample));
        Blog blog=blogMapper.selectByPrimaryKey(id);
        //获取tagIds
        blog.init();
        model.addAttribute("blog",blog);
        return "admin/blogs-input";
    }

    /**
     * 删除标签
     * @param id
     * @return
     */
    @GetMapping("/blogs/delete{id}")
    public String deleteBlog(@PathVariable Long id){
        blogMapper.deleteByPrimaryKey(id);
        return "redirect:/admin/blogs";
    }
}
