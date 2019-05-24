package com.epay.fcc.fses.cins.front.connector.cup.wld.mch;

import com.alibaba.fastjson.JSONObject;
import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.epay.fcc.fses.cins.front.connector.cup.wld.store.CupWldStoreAdd;
import com.unicompayment.fap.front.api.front.cins.model.BaseResponse;
import com.unicompayment.fap.front.api.front.cins.model.MerchantRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class CupWldMchQueryTest {
    @Resource
    private CupWldMchQuery cupWldMchQuery;

    @Test
    public void test() throws Exception {

        JSONObject bizContent = new JSONObject();
        //bizContent.put("mct_no","862004576");
        bizContent.put("out_mct_no","546789662113466");

        MerchantRequest request = new MerchantRequest();
        request.setFundChannelCode("CUP_WLD");
        request.setMerchantNo("txagCplS914ba758501bce613353752b");
        request.setBizCountent(bizContent);

        BaseResponse operator = cupWldMchQuery.operator(request);
        System.err.println("前置应答: "+JSONObject.toJSONString(operator));
    }
}