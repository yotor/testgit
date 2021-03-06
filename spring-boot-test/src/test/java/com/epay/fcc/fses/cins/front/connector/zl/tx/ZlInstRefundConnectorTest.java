package com.epay.fcc.fses.cins.front.connector.zl.tx;

import com.alibaba.fastjson.JSONObject;
import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.BaseResponse;
import com.unicompayment.fap.front.api.front.cins.model.InstallmentBackwardsRequest;
import com.unicompayment.fap.front.api.front.cins.model.InstallmentPayQueryRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class ZlInstRefundConnectorTest {
    @Resource(name="ZL_INSTALLMENT^1037")
    private ZlInstRefundConnector connector;

    @Test
    public void test(){

        Date date = new Date();
        String yyyyMMddHHmmSS = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

        InstallmentBackwardsRequest request = new InstallmentBackwardsRequest();
        request.setFundChannelCode("ZL_INSTALLMENT");
        request.setMerchantNo("30700002");
        request.setOutOrderId("PAY201904161933918");
        request.setRefundOutOrderId("REF"+yyyyMMddHHmmSS);
        request.setOrderAmount("123400");

        BaseResponse operator = connector.operator(request);
        System.err.println(JSONObject.toJSONString(operator));
    }
}