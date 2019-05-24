package com.epay.fcc.fses.cins.front.connector.cup.wld.tx;

import com.alibaba.fastjson.JSONObject;
import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.BaseResponse;
import com.unicompayment.fap.front.api.front.cins.model.InstallmentPayQueryRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class CupWldQueryOrderConnectorTest {
    @Resource(name="CUP_WLD^3052")
    private CupWldQueryOrderConnector connector;

    @Test
    public void test() throws Exception {

        InstallmentPayQueryRequest request = new InstallmentPayQueryRequest();
        request.setFundChannelCode("CUP_WLD");
        request.setMerchantNo("txagCplS914ba758501bce613353752b");
        request.setOutOrderId("FAP20190430093333689008");

        BaseResponse operator = connector.operator(request);
        System.err.println(JSONObject.toJSONString(operator));
    }
}