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
public class CupWldMchAddTest {
    @Resource
    private CupWldMchAdd cupWldMchAdd;

    @Test
    public void test() throws Exception {

        JSONObject bizContent = new JSONObject();
        bizContent.put("mct_name","中国联合网络通信股份有限公司河北分公司");
        bizContent.put("mct_type","3");//0未知，1个人，2小微，3企事业
        bizContent.put("wb_mct_code","777000048120001");//强制要求
        bizContent.put("mct_bl_type","1");//1三证合一  2非三证合一
        bizContent.put("mct_bl_no","91110000573229057N");
        bizContent.put("mct_boss_name","伏榕轮");
        bizContent.put("mct_boss_id_no","513436200004259878");
        bizContent.put("mct_boss_tel","18519330041");
        bizContent.put("mct_account_type","1");
        bizContent.put("mct_account_name","中国联合网络通信股份有限公司河北分公司");
        bizContent.put("mct_account_no","5456987116464648987");
        bizContent.put("out_mct_no","546789662113466");
        bizContent.put("mct_bank_name","中国银行股份有限公司河北省分行");
        bizContent.put("mct_bank_no","104121004004");

        MerchantRequest request = new MerchantRequest();
        request.setFundChannelCode("CUP_WLD");
        request.setMerchantNo("txagCplS914ba758501bce613353752b");
        request.setBizCountent(bizContent);

        BaseResponse operator = cupWldMchAdd.operator(request);
        System.err.println(JSONObject.toJSONString(operator));
    }
}