package com.epay.fcc.fses.cins.front.connector.cup.wld.store;

import com.alibaba.fastjson.JSONObject;
import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.BaseResponse;
import com.unicompayment.fap.front.api.front.cins.model.MerchantRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class CupWldStoreQrCodeTest {
    @Resource
    private CupWldStoreQrCode cupWldStoreQrCode;

    @Test
    public void test() throws Exception {

        JSONObject bizContent = new JSONObject();
        bizContent.put("mct_no","862004593");
        bizContent.put("shop_id","s64646310001");


        MerchantRequest request = new MerchantRequest();
        request.setFundChannelCode("CUP_WLD");
        request.setMerchantNo("txagCplS914ba758501bce613353752b");
        request.setBizCountent(bizContent);

        BaseResponse operator = cupWldStoreQrCode.operator(request);
        System.err.println("前置应答: "+JSONObject.toJSONString(operator));
    }
}