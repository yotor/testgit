package com.epay.fcc.fses.cins.front.connector.ms.tx;

import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.BillQueryRequest;
import com.unicompayment.fap.front.model.CheckFormatRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class CheckFormatConnectorTest {
    @Resource(name="MS_INSTALLMENT^4004")
    private CheckFormatConnector checkFormatConnector;

    @Test
    public void test(){
        CheckFormatRequest settleTrialRequest = new CheckFormatRequest();
        settleTrialRequest.setFundChannelCode("MS_INSTALLMENT");
        settleTrialRequest.setMerchantNo("wfq");
        settleTrialRequest.setCheckDate("20190404");
        checkFormatConnector.operator(settleTrialRequest);
    }
}