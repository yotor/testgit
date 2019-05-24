package com.epay.fcc.fses.cins.front.connector.cup.wld.tx;

import com.alibaba.fastjson.JSONObject;
import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.BaseResponse;
import com.unicompayment.fap.front.api.front.cins.model.OrderCloseRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class CupWldCancelOrderConnectorTest {
    @Resource(name="CUP_WLD^1027")
    private CupWldCancelOrderConnector connector;

    @Test
    public void test() throws Exception {

        OrderCloseRequest request = new OrderCloseRequest();
        request.setFundChannelCode("CUP_WLD");
        request.setMerchantNo("txagCplS914ba758501bce613353752b");
        request.setOrigPayFundChnOrderNo("PAY201904281415282");

        BaseResponse operator = connector.operator(request);
        System.err.println(JSONObject.toJSONString(operator));
    }
}