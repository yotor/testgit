package com.epay.fcc.fses.cins.front.connector.ms.tx;

import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.LoanObtainTextRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class LoanObtainTextConnectorTest {
    @Resource(name="MS_INSTALLMENT^0035")
    private LoanObtainTextConnector settleTrialConnector;

    @Test
    public void test(){
        LoanObtainTextRequest settleTrialRequest = new LoanObtainTextRequest();
        settleTrialRequest.setFundChannelCode("MS_INSTALLMENT");
        settleTrialRequest.setMerchantNo("wfq");
        //settleTrialRequest.setExtendInfo("{MS:{'contractType':'LOAN_PROTOCOL'}}");//商品分期贷款合同
        settleTrialRequest.setExtendInfo("{MS:{contractType:'STUDENT_DISCLAIMER'}}");//承诺函
        settleTrialRequest.setFundChnOrderNo("FAP201903301006140001");
        settleTrialConnector.operator(settleTrialRequest);
    }
}