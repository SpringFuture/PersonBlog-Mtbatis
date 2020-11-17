package com.usy.personblog.service;

import com.usy.personblog.models.Comment;

import java.util.List;


public interface CommentService {
    //查询评论列表
    List<Comment> listComment(Long blogId);
    //保存评论
    int saveComment(Comment comment);
}
