package com.epay.fcc.fses.cins.front.connector.cup.wld.tx;

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
public class CupWldPayOrderConnectorTest {
    @Resource(name="CUP_WLD^1036")
    private CupWldPayOrderConnector connector;

    @Test
    public void test() throws Exception {

        Date date = new Date();
        String yyyyMMddHHmmSS = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
        InstallmentPayRequest request = new InstallmentPayRequest();
        request.setFundChannelCode("CUP_WLD");
        request.setMerchantNo("txagCplS914ba758501bce613353752b");
        request.setOutOrderId("PAY"+yyyyMMddHHmmSS);
        request.setOrderAmount("50000");

        JSONObject ord_extend = new JSONObject();
        ord_extend.put("site_no","45649");//必须为数字
        ord_extend.put("site_worker_no","0001");
        ord_extend.put("trade_con_type","01");//01 合约机 02 花费
        ord_extend.put("city_id","440305");

        JSONObject CW = new JSONObject();
        CW.put("pmt_tag","WebankDCU");
        CW.put("ord_name","订单名称");
        CW.put("auth_code","");
        CW.put("statge_num","5");//3 6 12 24 有要求
        CW.put("mct_no","862004576");
        CW.put("shop_id","s64646316491");
        CW.put("remark","订单备注");
        CW.put("tag","订单标记");
        CW.put("ord_extend",ord_extend.toJSONString());
        JSONObject fapextendInfo = new JSONObject();
        fapextendInfo.put("CW",CW);

        request.setExtendInfo(fapextendInfo);

        BaseResponse operator = connector.operator(request);
        System.err.println(JSONObject.toJSONString(operator));
    }
}