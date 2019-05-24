package com.epay.fcc.fses.cins.front.connector.cup.wld.tx;

import com.alibaba.fastjson.JSONObject;
import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.epay.fcc.fses.cins.front.connector.ms.tx.CheckFormatConnector;
import com.unicompayment.fap.front.api.front.cins.model.BaseResponse;
import com.unicompayment.fap.front.model.CheckFormatRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})

public class CupWldCheckFormatConnectorTest {
    @Resource(name="CUP_WLD^4004")
    private CupWldCheckFormatConnector checkFormatConnector;

    @Test
    public void test(){
        CheckFormatRequest settleTrialRequest = new CheckFormatRequest();
        settleTrialRequest.setFundChannelCode("CUP_WLD");
        settleTrialRequest.setMerchantNo("txagCplS914ba758501bce613353752b");
        settleTrialRequest.setCheckDate("20190430");
        BaseResponse operator = checkFormatConnector.operator(settleTrialRequest);
        System.out.println(JSONObject.toJSONString(operator));
    }
}