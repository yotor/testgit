package com.epay.fcc.fses.cins.front.connector.cup.wld.tx;

import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.model.CheckDownloadRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class CupWldCheckDownloadConnectorTest {
    @Resource(name="CUP_WLD^4003")
    private CupWldCheckDownloadConnector checkFormatConnector;

    @Test
    public void test() throws Exception {
        CheckDownloadRequest settleTrialRequest = new CheckDownloadRequest();
        settleTrialRequest.setFundChannelCode("CUP_WLD");
        settleTrialRequest.setMerchantNo("txagCplS914ba758501bce613353752b");
        settleTrialRequest.setCheckDate("20190430");
        checkFormatConnector.operator(settleTrialRequest);
    }
}