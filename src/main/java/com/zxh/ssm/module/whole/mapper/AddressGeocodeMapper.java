package com.zxh.ssm.module.whole.mapper;

import com.zxh.ssm.module.whole.pojo.AddressGeocode;
import com.zxh.ssm.module.whole.pojo.AddressGeocodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressGeocodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int countByExample(AddressGeocodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int deleteByExample(AddressGeocodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String address);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int insert(AddressGeocode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int insertSelective(AddressGeocode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    List<AddressGeocode> selectByExample(AddressGeocodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    AddressGeocode selectByPrimaryKey(String address);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AddressGeocode record, @Param("example") AddressGeocodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AddressGeocode record, @Param("example") AddressGeocodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AddressGeocode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address_geocode
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AddressGeocode record);
}