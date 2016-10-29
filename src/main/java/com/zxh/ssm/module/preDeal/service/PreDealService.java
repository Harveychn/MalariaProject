package com.zxh.ssm.module.preDeal.service;

import com.zxh.ssm.module.whole.pojo.AddressGeocode;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/23.
 */
public interface PreDealService {
    List<String> getAddressList() throws Exception;

    void saveAddsAndCodes(List<AddressGeocode> addsAndCodeList) throws Exception;
}
