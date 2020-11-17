package com.usy.personblog.controller;
import com.usy.personblog.mapper.UserMapper;
import com.usy.personblog.models.User;
import com.usy.personblog.models.UserExample;
import com.usy.personblog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    /**
     * 登出
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "admin/login";
    }

    /**
     * 登陆
     * @param username
     * @param password
     * @param session
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        //登陆验证
        UserExample userExample=new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username)
                .andPasswordEqualTo(MD5Utils.code(password));
        List<User> user=userMapper.selectByExample(userExample);
        if (user.size()==0){
            attributes.addFlashAttribute("message","用户或密码错误");
            return "redirect:/admin";
        }else{
            session.setAttribute("nickname",user.get(0).getNickname());
            session.setAttribute("user",user.get(0));
            session.setAttribute("id",user.get(0).getId());
            return "redirect:/admin/blogs";
        }
    }
}
