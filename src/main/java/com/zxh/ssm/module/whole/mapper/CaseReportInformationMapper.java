package com.zxh.ssm.module.whole.mapper;

import com.zxh.ssm.module.whole.pojo.CaseReportInformation;
import com.zxh.ssm.module.whole.pojo.CaseReportInformationExample;
import com.zxh.ssm.module.whole.pojo.CaseReportInformationKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseReportInformationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table case_report_information
     *
     * @mbggenerated
     */
    int countByExample(CaseReportInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table case_report_information
     *
     * @mbggenerated
     */
    int deleteByExample(CaseReportInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table case_report_information
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(CaseReportInformationKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table case_report_information
     *
     * @mbggenerated
     */
    int insert(CaseReportInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table case_report_information
     *
     * @mbggenerated
     */
    int insertSelective(CaseReportInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table case_report_information
     *
     * @mbggenerated
     */
    List<CaseReportInformation> selectByExample(CaseReportInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table case_report_information
     *
     * @mbggenerated
     */
    CaseReportInformation selectByPrimaryKey(CaseReportInformationKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table case_report_information
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseReportInformation record, @Param("example") CaseReportInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table case_report_information
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseReportInformation record, @Param("example") CaseReportInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table case_report_information
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseReportInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table case_report_information
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseReportInformation record);
}