package com.epay.fcc.fses.cins.front.connector.ms.tx;

import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.SettleTrialRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class SettleTrialConnectorTest {

    @Resource(name="MS_INSTALLMENT^0038")
    private SettleTrialConnector settleTrialConnector;

    @Test
    public void test(){
        SettleTrialRequest settleTrialRequest = new SettleTrialRequest();
        settleTrialRequest.setFundChannelCode("MS_INSTALLMENT");
        settleTrialRequest.setMerchantNo("wfq");
        settleTrialRequest.setOrigFundChnOrderNo("FAP201903301006140001");
        settleTrialConnector.operator(settleTrialRequest);
    }

}