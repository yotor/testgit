package com.epay.fcc.fses.cins.front.connector.ms.tx;

import com.alibaba.fastjson.JSONObject;
import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.unicompayment.fap.front.api.front.cins.model.BaseResponse;
import com.unicompayment.fap.front.api.front.cins.model.LoanApplicationRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class LoanApplicationConnectorTest {
    @Resource(name="MS_INSTALLMENT^0033")
    private LoanApplicationConnector creditAuthConnector;

    @Test
    public void test(){
        String yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        LoanApplicationRequest settleTrialRequest = new LoanApplicationRequest();
        settleTrialRequest.setFundChannelCode("MS_INSTALLMENT");
        settleTrialRequest.setMerchantNo("wfq");
        settleTrialRequest.setFundChnOrderNo("FAP"+yyyyMMddHHmmss + "0001");
        settleTrialRequest.setOrderAmount("333300");
        //带3个字段
        // settleTrialRequest.setExtendInfo("{\"MS\":{\"compId\":\"20132113\",\"cellphone\":\"18519330042\",\"crProdId\":\"3238\",\"storeId\":\"lt2322\",\"storeName\":\"联通门店\",\"storeProvinceCode\":110000,\"storeCityCode\":110100,\"storeZoneCode\":110101,\"storeAddressDetail\":\"城西\",\"salesName\":\"营业员\",\"salesPhone\":13356788765,\"salesId\":\"sales231\",\"cmdtyName\":\"小米9\",\"cmdtyPrice\":\"333300\",\"loanTerm\":\"12\",\"clientId\":\"21ddsdfv\",\"type\":\"bd09II\",\"longitude\":\"116.378937\",\"latitude\":\"39.917577\",\"accuracy\":6,\"brandName\":\"小米\",\"modelName\":\"小米9\",\"downPmtAmt\":\"0\",\"name\":\"马小超\",\"idCardNo\":\"110101199003072834\",\"idCardBegindate\":\"2015.10.11\",\"idCardEnddate\":\"2035.10.11\",\"abodeDetail\":\"广东省深圳市福田区深南大道1101号\",\"nameFlag\":0,\"idCardNoFlag\":0,\"idCardIndateFlag\":0,\"nameModify\":null,\"idCardNoModify\":null,\"idCardBegindateModify\":null,\"idCardEnddateModify\":null,\"bankAccountName\":\"马小超\",\"bankCardNo\":6212260102000094000,\"bankPhone\":18519330042,\"abodeStateCode\":110000,\"abodeCityCode\":110100,\"abodeZoneCode\":110101,\"monthIncome\":500000,\"maritalStatus\":10,\"qualification\":\"LE06\",\"socialIdentity\":\"SI02\",\"unitName\":\"联通支付有限公司\",\"empPhone\":\"8666688\",\"empProvinceCode\":110000,\"empCityCode\":110100,\"empZoneCode\":110101,\"empAddr\":\"二龙路甲33号\",\"contactList\":[{\"contactName\":\"张三\",\"contactMobile\":19988887777,\"contactAddress\":\"蘑菇屯\",\"contactRelation\":\"RF01\"},{\"contactName\":\"李四\",\"contactMobile\":19988884567,\"contactAddress\":\"蘑菇屯\",\"contactRelation\":\"R002\"}],\"authNumber\":\"87494f7b5cef4ac588f1a51c1d898886\",\"appNo\":\"2959369725632647176\",\"fileIdMap\":{\"/upload/msopen/20190329/asd1234.jpg\":\"F\",\"/upload/msopen/20190329/asd1235.jpg\":\"UHDP\",\"/upload/msopen/20190329/asd1236.jpg\":\"R\",\"/upload/msopen/20190329/asd1237.jpg\":\"PHNL\",\"/upload/msopen/20190329/asd1238.jpg\":\"HT_V\"}}}");
        settleTrialRequest.setExtendInfo("{\"MS\":{\"storeId\":\"lt2322\",\"storeName\":\"联通门店\",\"storeProvinceCode\":110000,\"storeCityCode\":110100,\"storeZoneCode\":110101,\"storeAddressDetail\":\"城西\",\"salesName\":\"营业员\",\"salesPhone\":13356788765,\"salesId\":\"sales231\",\"cmdtyName\":\"小米9\",\"cmdtyPrice\":\"333300\",\"loanTerm\":\"12\",\"clientId\":\"21ddsdfv\",\"type\":\"bd09II\",\"longitude\":\"116.378937\",\"latitude\":\"39.917577\",\"accuracy\":6,\"brandName\":\"小米\",\"modelName\":\"小米9\",\"downPmtAmt\":\"0\"," +
                "\"name\":\"马小超\"," +
                "\"idCardNo\":\"110101199001016935\"," +
                "\"idCardBegindate\":\"2015.10.11\",\"idCardEnddate\":\"2035.10.11\",\"abodeDetail\":\"广东省深圳市福田区深南大道1101号\",\"nameFlag\":0,\"idCardNoFlag\":0,\"idCardIndateFlag\":0,\"nameModify\":null,\"idCardNoModify\":null,\"idCardBegindateModify\":null,\"idCardEnddateModify\":null," +
                "\"bankAccountName\":\"马小超\"," +
                "\"bankCardNo\":6212260102000094000," +
                "\"bankPhone\":18519330044,\"abodeStateCode\":110000,\"abodeCityCode\":110100,\"abodeZoneCode\":110101,\"monthIncome\":500000,\"maritalStatus\":10,\"qualification\":\"LE06\",\"socialIdentity\":\"SI02\",\"unitName\":\"联通支付有限公司\",\"empPhone\":\"8666688\",\"empProvinceCode\":110000,\"empCityCode\":110100,\"empZoneCode\":110101,\"empAddr\":\"二龙路甲33号\",\"contactList\":[{\"contactName\":\"走新商品贷\",\"contactMobile\":19988887777,\"contactAddress\":\"蘑菇屯\",\"contactRelation\":\"RF01\"},{\"contactName\":\"一轮快走\",\"contactMobile\":19988884567,\"contactAddress\":\"蘑菇屯\",\"contactRelation\":\"R002\"}]," +
                "\"authNumber\":\"d6a38f3dfbef40b1a84beb55614ce2c1\"," +
                "\"appNo\":\"2959715998447177736\"," +
                "\"fileIdMap\":{\"/upload/msopen/20190329/asd1234.jpg\":\"F\",\"/upload/msopen/20190329/asd1235.jpg\":\"UHDP\",\"/upload/msopen/20190329/asd1236.jpg\":\"R\",\"/upload/msopen/20190329/asd1237.jpg\":\"PHNL\",\"/upload/msopen/20190329/asd1238.jpg\":\"HT_V\"}}}");
        BaseResponse operator = creditAuthConnector.operator(settleTrialRequest);
        System.out.println(JSONObject.toJSONString(operator));
    }
}