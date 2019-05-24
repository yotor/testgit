package com.epay.fcc.fses.cins.front.connector.ms.tx;

import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.LoanTextConfirmRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class LoanTextConfirmConnectorTest{

    @Resource(name="MS_INSTALLMENT^0036")
    private LoanTextConfirmConnector settleTrialConnector;

    @Test
    public void test(){
        LoanTextConfirmRequest settleTrialRequest = new LoanTextConfirmRequest();
        settleTrialRequest.setFundChannelCode("MS_INSTALLMENT");
        settleTrialRequest.setMerchantNo("wfq");
        settleTrialRequest.setFundChnOrderNo("FAP201903301006140001");
        settleTrialConnector.operator(settleTrialRequest);
    }
}