package com.gfang.sevennineone.dao.mall;

import com.gfang.sevennineone.model.po.mall.LitemallSearchHistory;
import com.gfang.sevennineone.model.po.mall.LitemallSearchHistoryExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface LitemallSearchHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    long countByExample(LitemallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    int insert(LitemallSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    int insertSelective(LitemallSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    LitemallSearchHistory selectOneByExample(LitemallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    LitemallSearchHistory selectOneByExampleSelective(@Param("example") LitemallSearchHistoryExample example, @Param("selective") LitemallSearchHistory.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    List<LitemallSearchHistory> selectByExampleSelective(@Param("example") LitemallSearchHistoryExample example, @Param("selective") LitemallSearchHistory.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    List<LitemallSearchHistory> selectByExample(LitemallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    LitemallSearchHistory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallSearchHistory.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    LitemallSearchHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    LitemallSearchHistory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallSearchHistory record, @Param("example") LitemallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallSearchHistory record, @Param("example") LitemallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LitemallSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_search_history
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}