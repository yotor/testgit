package com.epay.fcc.fses.cins.front.connector.ms.tx;

import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.InstallmentBackwardsRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class InstallmentBackwardsConnectorTest {
    @Resource(name="MS_INSTALLMENT^1037")
    private InstallmentBackwardsConnector creditAuthConnector;

    @Test
    public void test(){
        InstallmentBackwardsRequest settleTrialRequest = new InstallmentBackwardsRequest();
        settleTrialRequest.setFundChannelCode("MS_INSTALLMENT");
        settleTrialRequest.setMerchantNo("wfq");
        settleTrialRequest.setOutOrderId("FAP201903301006140001");
        creditAuthConnector.operator(settleTrialRequest);
    }
}