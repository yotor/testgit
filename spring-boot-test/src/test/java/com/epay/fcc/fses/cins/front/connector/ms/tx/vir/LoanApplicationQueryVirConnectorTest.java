package com.epay.fcc.fses.cins.front.connector.ms.tx.vir;

import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.LoanApplicationQueryRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class LoanApplicationQueryVirConnectorTest {
    @Resource(name="MS_INSTALLMENT^3044Vir")
    private LoanApplicationQueryVirConnector loanApplicationQueryVirConnector;

    @Test
    public void test(){
        LoanApplicationQueryRequest settleTrialRequest = new LoanApplicationQueryRequest();
        loanApplicationQueryVirConnector.operator(settleTrialRequest);
    }
}