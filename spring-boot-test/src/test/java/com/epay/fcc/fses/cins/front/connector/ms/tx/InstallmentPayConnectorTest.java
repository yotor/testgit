package com.epay.fcc.fses.cins.front.connector.ms.tx;

import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.InstallmentPayRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class InstallmentPayConnectorTest {
    @Resource(name="MS_INSTALLMENT^1036")
    private InstallmentPayConnector settleTrialConnector;

    @Test
    public void test(){
        InstallmentPayRequest settleTrialRequest = new InstallmentPayRequest();
        settleTrialRequest.setFundChannelCode("MS_INSTALLMENT");
        settleTrialRequest.setMerchantNo("wfq");
        settleTrialRequest.setContractPhone("18519220044");
        settleTrialRequest.setOrderAmount("333300");
        settleTrialRequest.setOutOrderId("FAP201903301006140001");
        settleTrialConnector.operator(settleTrialRequest);
    }
}