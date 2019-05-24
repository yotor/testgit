package com.epay.fcc.fses.cins.front.connector.zl.tx;

import com.alibaba.fastjson.JSONObject;
import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.BaseResponse;
import com.unicompayment.fap.front.api.front.cins.model.InstallmentPayRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class ZlInstCreateOrderConnectorTest {
    @Resource(name="ZL_INSTALLMENT^1036")
    private ZlInstCreateOrderConnector connector;

    @Test
    public void test(){

        Date date = new Date();
        String yyyyMMddHHmmSS = new SimpleDateFormat("yyyyMMddHHmmSS").format(date);
        InstallmentPayRequest request = new InstallmentPayRequest();
        request.setFundChannelCode("ZL_INSTALLMENT");
        request.setMerchantNo("30700002");
        request.setOutOrderId("PAY"+yyyyMMddHHmmSS);
        request.setOrderAmount("1200");

        JSONObject extendInfo = new JSONObject();
        extendInfo.put("productType","01");
        extendInfo.put("managerId","managerId0001");
        extendInfo.put("unicomBusiOrderId","unicomBusiOrderId"+yyyyMMddHHmmSS);
        extendInfo.put("unicomBusiNo","unicomBusiNo"+yyyyMMddHHmmSS);
        extendInfo.put("storeProvince","51");//省分编码 测试环境必须为51
        extendInfo.put("storeCity","540");//城市编码 测试环境必须为540
        extendInfo.put("storeCounty","storeCounty1234");//区县编码
        extendInfo.put("isMerchantFee","1");//是否商户贴息 1是 其他否
        extendInfo.put("productName","productName Ipad Pro 256g");
        extendInfo.put("woMerchantId","woMerchantId1234");
        extendInfo.put("productDetail","productDetail Ipad Pro 256g");
        extendInfo.put("contractPhoneNo","18519330040");
        extendInfo.put("activityNo","activityNo1234");
        extendInfo.put("couponRepay","1");//1=电子券还款, 其他=正常还款
        extendInfo.put("deviceAdd","deviceAdd丰台春园");
        JSONObject zl = new JSONObject();
        zl.put("timeout",10*60);
        zl.put("orderDesc","orderDesc Ipad Pro 256g");
        zl.put("deviceId","deviceId0001");
        zl.put("payCode","186101593412550546");//支付码
        zl.put("storeId","storeId0001");
        zl.put("operatorId","operatorId0001");
        zl.put("merOrderTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        zl.put("installCount","12");
        zl.put("extendInfo",extendInfo);
        JSONObject fapextendInfo = new JSONObject();
        fapextendInfo.put("ZL",zl);
        request.setExtendInfo(fapextendInfo);
        BaseResponse operator = connector.operator(request);
        System.err.println(JSONObject.toJSONString(operator));
    }
}