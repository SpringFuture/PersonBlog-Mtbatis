package com.usy.personblog.models;

import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Long id;

    private User user;



    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.appreciation
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Boolean appreciation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.commentable
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Boolean commentable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.create_time
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.first_picture
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private String firstPicture;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.flag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private String flag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.published
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Boolean published;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.recommend
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Boolean recommend;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.share_statement
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Boolean shareStatement;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.title
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.update_time
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.views
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Integer views;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.type_id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Long typeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.user_id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.tag_ids
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    @Transient
    private String tagIds;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.description
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_blog.content
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    private String content;


    private Type type;


    private List<Tag> tags=new ArrayList<>();

    private List<Comment> comments =new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Blog() {
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.id
     *
     * @return the value of t_blog.id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.id
     *
     * @param id the value for t_blog.id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.appreciation
     *
     * @return the value of t_blog.appreciation
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Boolean getAppreciation() {
        return appreciation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.appreciation
     *
     * @param appreciation the value for t_blog.appreciation
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setAppreciation(Boolean appreciation) {
        this.appreciation = appreciation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.commentable
     *
     * @return the value of t_blog.commentable
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Boolean getCommentable() {
        return commentable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.commentable
     *
     * @param commentable the value for t_blog.commentable
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setCommentable(Boolean commentable) {
        this.commentable = commentable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.create_time
     *
     * @return the value of t_blog.create_time
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.create_time
     *
     * @param createTime the value for t_blog.create_time
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.first_picture
     *
     * @return the value of t_blog.first_picture
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public String getFirstPicture() {
        return firstPicture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.first_picture
     *
     * @param firstPicture the value for t_blog.first_picture
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture == null ? null : firstPicture.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.flag
     *
     * @return the value of t_blog.flag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public String getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.flag
     *
     * @param flag the value for t_blog.flag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.published
     *
     * @return the value of t_blog.published
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Boolean getPublished() {
        return published;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.published
     *
     * @param published the value for t_blog.published
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setPublished(Boolean published) {
        this.published = published;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.recommend
     *
     * @return the value of t_blog.recommend
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Boolean getRecommend() {
        return recommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.recommend
     *
     * @param recommend the value for t_blog.recommend
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.share_statement
     *
     * @return the value of t_blog.share_statement
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Boolean getShareStatement() {
        return shareStatement;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.share_statement
     *
     * @param shareStatement the value for t_blog.share_statement
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setShareStatement(Boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.title
     *
     * @return the value of t_blog.title
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.title
     *
     * @param title the value for t_blog.title
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.update_time
     *
     * @return the value of t_blog.update_time
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.update_time
     *
     * @param updateTime the value for t_blog.update_time
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.views
     *
     * @return the value of t_blog.views
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Integer getViews() {
        return views;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.views
     *
     * @param views the value for t_blog.views
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.type_id
     *
     * @return the value of t_blog.type_id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.type_id
     *
     * @param typeId the value for t_blog.type_id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.user_id
     *
     * @return the value of t_blog.user_id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.user_id
     *
     * @param userId the value for t_blog.user_id
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.tag_ids
     *
     * @return the value of t_blog.tag_ids
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public String getTagIds() {
        return tagIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.tag_ids
     *
     * @param tagIds the value for t_blog.tag_ids
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setTagIds(String tagIds) {
        this.tagIds = tagIds == null ? null : tagIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.description
     *
     * @return the value of t_blog.description
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.description
     *
     * @param description the value for t_blog.description
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_blog.content
     *
     * @return the value of t_blog.content
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_blog.content
     *
     * @param content the value for t_blog.content
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", user=" + user +
                ", appreciation=" + appreciation +
                ", commentable=" + commentable +
                ", createTime=" + createTime +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", published=" + published +
                ", recommend=" + recommend +
                ", shareStatement=" + shareStatement +
                ", title='" + title + '\'' +
                ", updateTime=" + updateTime +
                ", views=" + views +
                ", typeId=" + typeId +
                ", userId=" + userId +
                ", tagIds='" + tagIds + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", tags=" + tags +
                '}';
    }
    public void init(){
        this.tagIds = tagsToIds(this.getTags());
    }
    //获取后1,2,3
    private String tagsToIds(List<Tag> tags){
        if (!tags.isEmpty()){
            StringBuffer ids=new StringBuffer();
            boolean flag=false;
            for (Tag tag : tags){
                if (flag){
                    ids.append(",");
                }else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        }else {
            return tagIds;
        }
    }
}