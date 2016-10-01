package com.zxh.ssm.module.user.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by 郑晓辉 on 2016/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class PatientAddressMapperTest {

    @Resource
    private PatientAddressMapper patientAddressMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {

        PatientAddress patientAddress = patientAddressMapper.selectByPrimaryKey(4952200);

        System.out.println("-----test success ! information :" + patientAddress.getPaaddress());
    }

    @Test
    public void selectByExample() throws Exception{
        PatientAddressExample patientAddressExample = new PatientAddressExample();
        patientAddressExample.createCriteria().andPaaddressLike("云南省保山市腾冲县%").andCardidBetween(4952200,4952687);
        List<PatientAddress> patientAddressList = patientAddressMapper.selectByExample(patientAddressExample);
        System.out.println("  patientAddressList.size() :" + patientAddressList.size() );
    }

}