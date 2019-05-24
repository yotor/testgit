package com.epay.fcc.fses.cins.front.connector.cup.wld.mch;

import com.alibaba.fastjson.JSONObject;
import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.BaseResponse;
import com.unicompayment.fap.front.api.front.cins.model.MerchantRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class CupWldMchUpdateTest {
    @Resource
    private CupWldMchUpdate cupWldMchUpdate;

    @Test
    public void test() throws Exception {

        JSONObject bizContent = new JSONObject();
        bizContent.put("mct_no","862004576");
        bizContent.put("mct_name","中国联合网络通信股份有限公司河北分公司");
        bizContent.put("mct_type","3");
        bizContent.put("wb_mct_code","777000048120001");//强制要求
        bizContent.put("mct_bl_type","1");//1三证合一  2非三证合一
        bizContent.put("mct_bl_no","91110000573229057N");
        bizContent.put("mct_boss_name","马小超");
        bizContent.put("mct_boss_id_no","51343620000426815X");
        bizContent.put("mct_boss_tel","18519330041");
        bizContent.put("mct_account_type","1");
        bizContent.put("mct_account_name","中国联合网络通信股份有限公司河北分公司");
        bizContent.put("mct_account_no","5456987116464648987");

        MerchantRequest request = new MerchantRequest();
        request.setFundChannelCode("CUP_WLD");
        request.setMerchantNo("txagCplS914ba758501bce613353752b");
        request.setBizCountent(bizContent);

        BaseResponse operator = cupWldMchUpdate.operator(request);
        System.err.println(JSONObject.toJSONString(operator));
    }
}