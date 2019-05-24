package com.epay.fcc.fses.cins.front.connector;

import com.epay.fcc.fses.cins.front.utils.FAPAssembleUtil;
import com.unicompayment.fap.common.constants.FAPTxPortalConst;
import com.unicompayment.fap.common.dto.xml.FAP;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class BaseTest {

    public void byte2image(byte[] data,String path){
        if(data.length<3||path.equals("")) return;
        try{
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
            System.out.println("Make Picture success,Please find image in " + path);
        } catch(Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }


    @Test
    public void test(){
        com.alibaba.fastjson.JSONObject jsonpObject = new com.alibaba.fastjson.JSONObject();
        jsonpObject.put("name","song");
        jsonpObject.put("age",28);
        com.alibaba.fastjson.JSONObject school=new com.alibaba.fastjson.JSONObject();
        school.put("name","{\"amount\":\"0.01\",\"repayOrderNo\":\"20190425154300004035\",\"repayOrderDate\":\"20190425\",\"repayType\":\"0\",\"fundchnOrderNo\":\"438503740380583\"}");
        school.put("level",1);
        jsonpObject.put("school",school);
        log.info("req {}",jsonpObject);
        log.info("req {}",jsonpObject.toString());
        log.info("req {}",jsonpObject.toJSONString());

        FAP resultFap = FAPAssembleUtil.createNewRespFap();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", FAPTxPortalConst.LOAN_APPLICATION_NOTIFY);
        resultMap.put("status", "1");
        resultMap.put("fap", resultFap);
        System.out.println(resultMap);
    }
}
