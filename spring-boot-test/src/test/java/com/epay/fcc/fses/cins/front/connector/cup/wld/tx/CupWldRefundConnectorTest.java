package com.epay.fcc.fses.cins.front.connector.cup.wld.tx;

import com.alibaba.fastjson.JSONObject;
import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.BaseResponse;
import com.unicompayment.fap.front.api.front.cins.model.InstallmentBackwardsRequest;
import com.unicompayment.fap.front.api.front.cins.model.OrderCloseRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class CupWldRefundConnectorTest {
    @Resource(name="CUP_WLD^1037")
    private CupWldRefundConnector connector;

    @Test
    public void test() throws Exception {

        Date date = new Date();
        String yyyyMMddHHmmSS = new SimpleDateFormat("yyyyMMddHHmmss").format(date);

        InstallmentBackwardsRequest request = new InstallmentBackwardsRequest();
        request.setFundChannelCode("CUP_WLD");
        request.setMerchantNo("txagCplS914ba758501bce613353752b");
        request.setOutOrderId("FAP20190508221728045267");
        request.setRefundOutOrderId("RFD"+yyyyMMddHHmmSS);
        request.setOrderAmount("1000000");

        BaseResponse operator = connector.operator(request);
        System.err.println(JSONObject.toJSONString(operator));
    }
}