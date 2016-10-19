package com.zxh.ssm.module.user.mapper;

import com.zxh.ssm.module.whole.pojo.PatientInformationKey;
import com.zxh.ssm.module.whole.mapper.PatientInformationMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 郑晓辉 on 2016/10/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class PatientInformationMapperTest {

    @Resource
    private PatientInformationMapper patientInformationMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {
        PatientInformationKey patientInformationKey = new PatientInformationKey();
        patientInformationKey.setCardid(4949510);
        patientInformationKey.setYear(2005);
        System.out.println("数据年份" + patientInformationKey.getYear());
        System.out.println(patientInformationMapper.selectByPrimaryKey(patientInformationKey));
    }

}