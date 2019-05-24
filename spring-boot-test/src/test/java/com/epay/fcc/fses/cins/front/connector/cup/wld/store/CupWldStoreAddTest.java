package com.epay.fcc.fses.cins.front.connector.cup.wld.store;

import com.alibaba.fastjson.JSONObject;
import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.epay.fcc.fses.cins.front.connector.cup.wld.mch.CupWldMchAdd;
import com.unicompayment.fap.front.api.front.cins.model.BaseResponse;
import com.unicompayment.fap.front.api.front.cins.model.MerchantRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class CupWldStoreAddTest {
    @Resource
    private CupWldStoreAdd cupWldStoreAdd;

    @Test
    public void test() throws Exception {

        JSONObject bizContent = new JSONObject();
        bizContent.put("mct_no","862004576");
        bizContent.put("shop_id","s64646316491");
        bizContent.put("shop_name","河北省石家庄市长安区解放路联通营业厅");
        bizContent.put("shop_add_time",new Date().getTime()/1000);
        bizContent.put("shop_city_id","130102");
        bizContent.put("shop_address","河北省石家庄市长安区xxx");
        bizContent.put("shop_contact","马小超");
        bizContent.put("shop_contact_tel","18519330042");

        MerchantRequest request = new MerchantRequest();
        request.setFundChannelCode("CUP_WLD");
        request.setMerchantNo("txagCplS914ba758501bce613353752b");
        request.setBizCountent(bizContent);

        BaseResponse operator = cupWldStoreAdd.operator(request);
        System.err.println("前置应答: "+JSONObject.toJSONString(operator));
    }
}