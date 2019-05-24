package com.epay.fcc.fses.cins.front.connector.cup.wld.utils;

//~--- non-JDK imports --------------------------------------------------------

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Date;
import java.util.TreeMap;

//~--- JDK imports ------------------------------------------------------------

//~--- classes ----------------------------------------------------------------

/**
 * Class MerAddDemo
 * Description 添加商户demo
 * Create 2017-04-27 09:58:31
 * @author Benny.YEE
 */
public class MerAddDemo {

    /**
     * Method add
     * Description 说明：
     *
     */
    public void add() {
        String timestamp = new Date().getTime() / 1000 + "";    // 时间
        try {
            // 固定参数
            TreeMap<String, String> postmap = new TreeMap<String, String>();    // post请求参数的map
            TreeMap<String, String> getmap  = new TreeMap<String, String>();    // get请求参数的map

            getmap.put("open_id", StaticConfig.open_id);
//          getmap.put("lang", StaticConfig.lang);
            getmap.put("timestamp", timestamp);
            getmap.put("randStr", RandomStringUtils.randomAlphanumeric(32));

            TreeMap<String, Object> datamap = new TreeMap<String, Object>();    // data参数的map



          //样例
            datamap.put("mct_name", "测试商户名称");
            datamap.put("mct_type", "1"); //商户类型
            datamap.put("wb_mct_code","41238182381823123");//微众商户补贴号

            datamap.put("mct_bl_type","1");//营业执照类型
            datamap.put("mct_bl_no","yyzzcode_00001");//营业执照号码
            datamap.put("mct_boss_name","张三");//
            datamap.put("mct_boss_id_no","42900017812381238123992139123");
            datamap.put("mct_boss_tel","13467678915");//
            datamap.put("mct_account_type","1");
            datamap.put("mct_account_name","张三");
            datamap.put("mct_account_no","62284800077889999122112");

            datamap.put("out_mct_no","ut_mct_no20190424");
            datamap.put("mct_bank_name","平安银行深圳分行");
            datamap.put("mct_bank_no","2300011111231231231");
         	 // "Merchantwbdiy/add";



            /**
             * 1 data字段内容进行AES加密，再二进制转十六进制(bin2hex)
             */
            String data = TLinx2Util.handleEncrypt1(datamap);
            postmap.put("data", data);
            /**
             * 2 请求参数签名 按A~z排序，串联成字符串，先进行sha1加密(小写)，再进行RSA加密(小写),二进制转十六进制，得到签名
             */
            String sign = TLinx2Util.handleSign(getmap, postmap);
            postmap.put("sign", sign);
            /**
             * 3 请求、响应
             */
            String uri = StaticConfig.MERCHANT_WB_ADD + "?open_id=" + getmap.get("open_id") /*+ "&lang=" + getmap.get("lang")*/
                    + "&timestamp=" + getmap.get("timestamp") + "&randStr=" + getmap.get("randStr");
            String rspStr = TLinx2Util.handlePost(postmap, uri);

            /**
             * 4 验签  有data节点时才验签
             */
            JSONObject respObject = JSONObject.parseObject(rspStr);

            System.out.println("====响应错误码：" + respObject.get("errcode"));
            System.out.println("====响应错误提示：" + respObject.get("msg"));

            Object dataStr = respObject.get("data");

            if (!rspStr.isEmpty() && ( dataStr != null )) {
                if (TLinx2Util.verifySign(respObject, StaticConfig.publickey)) {    // 验签成功

                    /**
                     * 5 AES解密，并hex2bin
                     */
                    String respData = TLinxAESCoder.decrypt(dataStr.toString(), StaticConfig.open_key);

                    System.out.println("==================响应data内容:" + respData);
                } else {
                    System.out.println("=====验签失败=====");
                }
            } else {
                System.out.println("=====没有返回data数据=====");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method main
     * Description 说明：
     *
     * @param args 说明：
     */
    public static void main(String[] args) {
        new MerAddDemo().add();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
