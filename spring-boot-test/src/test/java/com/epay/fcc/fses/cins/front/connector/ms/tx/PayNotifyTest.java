package com.epay.fcc.fses.cins.front.connector.ms.tx;

import com.alibaba.fastjson.JSONObject;
import com.epay.fcc.fses.cins.front.FccFsesCInsApplication;
import com.epay.fcc.fses.cins.front.utils.FAPAssembleUtil;
import com.epay.fcc.fses.cins.front.utils.HessianUtil;
import com.unicompayment.fap.common.constants.FAPConstants;
import com.unicompayment.fap.common.constants.FAPExcConst;
import com.unicompayment.fap.common.constants.FAPTxPortalConst;
import com.unicompayment.fap.common.dto.xml.FAP;
import com.unicompayment.fap.common.dto.xml.HEAD;
import com.unicompayment.fap.common.dto.xml.TX_INFO;
import com.unicompayment.fap.common.exception.FapSysException;
import com.unicompayment.fap.common.remote.hessian.IFapTxHandler;
import com.unicompayment.fap.common.utils.string.StringUtil;
import com.unicompayment.fap.front.api.common.enums.MsStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PayNotifyTest
 * @Description TODO
 * @Author unicom
 * @Date 2019-3-30 14:36
 * Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes={FccFsesCInsApplication.class})
public class PayNotifyTest {
    @Test
    public  void test(){
        try {
            String fundChnOrderNo = "1244551";
            String orderStatus = "4";

            FAP resultFap = FAPAssembleUtil.createNewRespFap();
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("type", FAPTxPortalConst.LOAN_APPLICATION_NOTIFY);
            TX_INFO txInfo = resultFap.getRESPONSE().getENVELOPE().getTX_INFO();
            HEAD head = resultFap.getRESPONSE().getENVELOPE().getHEAD();
            head.setPAY_TYPE(FAPConstants.PAY_TYPE_27);
            head.setTX_TYPE(FAPConstants.TX_TYPE_1036);
            txInfo.setFUND_CHN_ORDER_NO(fundChnOrderNo);
            txInfo.setFUND_CHANNEL_CODE("MS_INSTALLMENT");
            if(StringUtil.searchInArray(orderStatus,new String[]{MsStatusEnum.STATUS_4.code,
                    MsStatusEnum.STATUS_6.code})) {
                txInfo.setTX_STATUS(FAPConstants.TX_STATUS_1);
            }else if(StringUtil.searchInArray(orderStatus,new String[]{MsStatusEnum.STATUS_2.code,
                    MsStatusEnum.STATUS_5.code})){
                txInfo.setTX_STATUS(FAPConstants.TX_STATUS_2);
            }else{
                throw new FapSysException(FAPExcConst.FAIL_FAP);
            }
            resultMap.put("status", txInfo.getTX_STATUS());
            resultMap.put("fap", resultFap);
            IFapTxHandler fapTxHandler = HessianUtil.getTxHandler();
            boolean callBack = fapTxHandler.callBack(resultMap);
            if (callBack) {
                try {
                    if(FAPConstants.TX_STATUS_1.equals(txInfo.getTX_STATUS())) {
                        fapTxHandler.notifyTx(resultFap);//后台通知
                    }else{
                    }
                } catch (Exception e) {
                }
            } else {
            }
        }catch(Exception e) {
        }
    }
}
