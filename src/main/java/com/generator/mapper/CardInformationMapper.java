package com.generator.mapper;

import com.generator.pojo.CardInformation;
import com.generator.pojo.CardInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardInformationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_information
     *
     * @mbggenerated
     */
    int countByExample(CardInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_information
     *
     * @mbggenerated
     */
    int deleteByExample(CardInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_information
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer cardid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_information
     *
     * @mbggenerated
     */
    int insert(CardInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_information
     *
     * @mbggenerated
     */
    int insertSelective(CardInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_information
     *
     * @mbggenerated
     */
    List<CardInformation> selectByExample(CardInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_information
     *
     * @mbggenerated
     */
    CardInformation selectByPrimaryKey(Integer cardid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_information
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CardInformation record, @Param("example") CardInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_information
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CardInformation record, @Param("example") CardInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_information
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CardInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table card_information
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CardInformation record);
}