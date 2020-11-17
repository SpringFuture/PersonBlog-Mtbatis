package com.usy.personblog.controller;
import com.usy.personblog.models.Comment;
import com.usy.personblog.models.User;
import com.usy.personblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {


    //评论区用户头像固定
    @Value("${comment.avatar}")
    private String avatar;

    @Autowired
    private CommentService commentService;

    /**
     * 评论后刷新
     * @param blogId
     * @param model
     * @return
     */
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        List<Comment> comments = commentService.listComment(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";

    }

    /**
     * 保存评论区
     * @param comment
     * @param session
     * @return
     */
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session){
        Long blogId=comment.getBlog().getId();
        User user = (User) session.getAttribute("user");
        if (user!=null){
            comment.setAvatar(user.getAvatar());
            comment.setBlogId(blogId);
            comment.setAdminComment(true);
        }else{
            comment.setBlogId(blogId);
            comment.setAdminComment(false);
            comment.setAvatar(avatar);
        }
        if (comment.getParentComment().getId()!=-1){
            comment.setParentCommentId(comment.getParentComment().getId());
        }else {
            comment.setParentCommentId((long) 0);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/"+blogId;
    }
}
