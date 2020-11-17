package com.usy.personblog.mapper;

import com.usy.personblog.models.Tag;
import com.usy.personblog.models.TagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    long countByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    int deleteByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    int insert(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    int insertSelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    List<Tag> selectByExampleWithRowbounds(TagExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    List<Tag> selectByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    Tag selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Thu Oct 22 12:19:07 CST 2020
     */
    int updateByPrimaryKey(Tag record);
}