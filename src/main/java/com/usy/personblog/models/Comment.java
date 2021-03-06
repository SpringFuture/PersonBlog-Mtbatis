package com.usy.personblog.models;

import org.springframework.beans.BeanUtils;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.avatar
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private String avatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.content
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.create_time
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.email
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.nickname
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.blog_id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Long blogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.parent_comment_id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Long parentCommentId;

    public String getParentNickname() {
        return parentNickname;
    }

    public void setParentNickname(String parentNickname) {
        this.parentNickname = parentNickname;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.admin_comment
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Boolean adminComment;

    private String parentNickname;

    private List<Comment> replyComments=new ArrayList<>();

    private Comment parentComment;
    private Blog blog;

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Comment() {
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.id
     *
     * @return the value of t_comment.id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.id
     *
     * @param id the value for t_comment.id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.avatar
     *
     * @return the value of t_comment.avatar
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.avatar
     *
     * @param avatar the value for t_comment.avatar
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.content
     *
     * @return the value of t_comment.content
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.content
     *
     * @param content the value for t_comment.content
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.create_time
     *
     * @return the value of t_comment.create_time
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.create_time
     *
     * @param createTime the value for t_comment.create_time
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.email
     *
     * @return the value of t_comment.email
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.email
     *
     * @param email the value for t_comment.email
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.nickname
     *
     * @return the value of t_comment.nickname
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.nickname
     *
     * @param nickname the value for t_comment.nickname
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.blog_id
     *
     * @return the value of t_comment.blog_id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Long getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.blog_id
     *
     * @param blogId the value for t_comment.blog_id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.parent_comment_id
     *
     * @return the value of t_comment.parent_comment_id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Long getParentCommentId() {
        return parentCommentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.parent_comment_id
     *
     * @param parentCommentId the value for t_comment.parent_comment_id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.admin_comment
     *
     * @return the value of t_comment.admin_comment
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Boolean getAdminComment() {
        return adminComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.admin_comment
     *
     * @param adminComment the value for t_comment.admin_comment
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setAdminComment(Boolean adminComment) {
        this.adminComment = adminComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", blogId=" + blogId +
                ", parentCommentId=" + parentCommentId +
                ", adminComment=" + adminComment +
                ", replyComments=" + replyComments +
                ", parentComment=" + parentComment +
                ", blog=" + blog +
                '}';
    }

}