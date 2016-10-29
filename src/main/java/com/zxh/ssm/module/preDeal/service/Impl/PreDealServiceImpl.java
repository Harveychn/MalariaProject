package com.zxh.ssm.module.preDeal.service.Impl;

import com.zxh.ssm.module.preDeal.mapper.PreDealMapper;
import com.zxh.ssm.module.preDeal.service.PreDealService;
import com.zxh.ssm.module.whole.mapper.AddressGeocodeMapper;
import com.zxh.ssm.module.whole.pojo.AddressGeocode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/23.
 */
@Service
public class PreDealServiceImpl implements PreDealService {
    @Resource
    private PreDealMapper preDealMapper;
    @Resource
    private AddressGeocodeMapper addressGeocodeMapper;

    public List<String> getAddressList() throws Exception {
        return preDealMapper.selectAddressArray();
    }

    public void saveAddsAndCodes(List<AddressGeocode> addsAndCodeList) throws Exception {
        for (AddressGeocode a : addsAndCodeList) {
            if (null == addressGeocodeMapper.selectByPrimaryKey(a.getAddress())) {
                if (1 == addressGeocodeMapper.insert(a)) {
                    continue;
                }
            }
            if (1 == addressGeocodeMapper.updateByPrimaryKey(a)) {
                System.out.println("更新了地址信息：" + a.getAddress());
            }
        }
    }
}
