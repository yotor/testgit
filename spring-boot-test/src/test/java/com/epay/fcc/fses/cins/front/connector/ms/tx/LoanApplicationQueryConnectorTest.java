package com.epay.fcc.fses.cins.front.connector.ms.tx;

import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.LoanApplicationQueryRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class LoanApplicationQueryConnectorTest {
    @Resource(name="MS_INSTALLMENT^3044")
    private LoanApplicationQueryConnector settleTrialConnector;

    @Test
    public void test(){
        LoanApplicationQueryRequest settleTrialRequest = new LoanApplicationQueryRequest();
        settleTrialRequest.setFundChannelCode("MS_INSTALLMENT");
        settleTrialRequest.setMerchantNo("wfq");
        settleTrialRequest.setFundChnOrderNo("FAP201903301006140001");
        settleTrialConnector.operator(settleTrialRequest);
    }
}