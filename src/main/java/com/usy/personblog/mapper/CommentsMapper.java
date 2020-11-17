package com.usy.personblog.mapper;

import com.usy.personblog.models.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.ManyToOne;
import java.util.List;

@Mapper
@Repository
public interface CommentsMapper {
    //添加一个评论
    int saveComment(Comment comment);
    //查询父级评论
    List<Comment> findByBlogIdNull(@Param("BlogId") Long BlogId);
    //查询一级回复
    List<Comment> findParentIdNotNull(@Param("id") Long id);
    //查询二级以及所有子集回复
    List<Comment> findByReplayId(@Param("childId") Long childId);
}
