package com.generator.mapper;

import com.generator.pojo.WeatherData;
import com.generator.pojo.WeatherDataExample;
import com.generator.pojo.WeatherDataKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeatherDataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather_data
     *
     * @mbggenerated
     */
    int countByExample(WeatherDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather_data
     *
     * @mbggenerated
     */
    int deleteByExample(WeatherDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather_data
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(WeatherDataKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather_data
     *
     * @mbggenerated
     */
    int insert(WeatherData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather_data
     *
     * @mbggenerated
     */
    int insertSelective(WeatherData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather_data
     *
     * @mbggenerated
     */
    List<WeatherData> selectByExample(WeatherDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather_data
     *
     * @mbggenerated
     */
    WeatherData selectByPrimaryKey(WeatherDataKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather_data
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") WeatherData record, @Param("example") WeatherDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather_data
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") WeatherData record, @Param("example") WeatherDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather_data
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WeatherData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weather_data
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WeatherData record);
}