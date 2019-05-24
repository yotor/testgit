package com.epay.fcc.fses.cins.front.connector.ms.tx;

import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.CreditAuthRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class CreditAuthConnectorTest {
    @Resource(name="MS_INSTALLMENT^0037")
    private CreditAuthConnector creditAuthConnector;

    @Test
    public void test(){
        CreditAuthRequest settleTrialRequest = new CreditAuthRequest();
        settleTrialRequest.setFundChannelCode("MS_INSTALLMENT");
        settleTrialRequest.setMerchantNo("wfq");
        settleTrialRequest.setCellphone("18519330041");
        settleTrialRequest.setJumpUrl("https://test1.unicompayment.com/wop/index");
        settleTrialRequest.setName("马小超");
        settleTrialRequest.setIdNo("110101199001012037");
                //{"MS":{"name":"马小超","idNo":"110101199001012037"}}
        creditAuthConnector.operator(settleTrialRequest);
    }
}