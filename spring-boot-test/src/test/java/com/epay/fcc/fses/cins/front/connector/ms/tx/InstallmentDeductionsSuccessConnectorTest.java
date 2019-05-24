package com.epay.fcc.fses.cins.front.connector.ms.tx;

import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.InstallmentDeductionsSuccessRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class InstallmentDeductionsSuccessConnectorTest {
    @Resource(name="MS_INSTALLMENT^4012")
    private InstallmentDeductionsSuccessConnector creditAuthConnector;

    @Test
    public void test(){
        String yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        InstallmentDeductionsSuccessRequest settleTrialRequest = new InstallmentDeductionsSuccessRequest();
        settleTrialRequest.setFundChannelCode("MS_INSTALLMENT");
        settleTrialRequest.setMerchantNo("wfq");
        settleTrialRequest.setDeductAmt("33300");
        settleTrialRequest.setDeductStatus("Y");
        settleTrialRequest.setFlag("0");
        settleTrialRequest.setOutOrderId("FAP201903301006140001");
        settleTrialRequest.setPayOrderNo("HK"+yyyyMMddHHmmss+"0001");
        settleTrialRequest.setRepayType("0");
        creditAuthConnector.operator(settleTrialRequest);
    }
}