package com.epay.fcc.fses.cins.front.connector.cup.wld.utils;

//~--- non-JDK imports --------------------------------------------------------


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

//~--- JDK imports ------------------------------------------------------------

//~--- classes ----------------------------------------------------------------

/**
 * Class TLinx2Util
 * Description tlinx api 工具类
 * Create 2017-03-07 14:01:23
 * @author Benny.YEE
 */
public class TLinx2Util {

    /**
     * 签名
     * @param postMap
     * @param privatekey 说明：
     * @return
     */
    public static String sign(Map<String, String> postMap, String privatekey) {
        String sortStr = null;
        String sign    = null;

        try {

            /**
             * 1 A~z排序
             */
            sortStr = sort(postMap);
            System.out.println("====排序后的待签名字符串= "+sortStr);

            /**
             * 2 sha1加密(小写)
             */
            String sha1 = TLinxSHA1.SHA1(sortStr);
            System.out.println("====sha1加密后的待签名字符串=" + sha1);

            /**
             * 3 RSA加密(小写),二进制转十六进制
             */
            sign = TLinxRSACoder.sign(sha1.getBytes("utf-8"), privatekey);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sign;
    }

    /**
     * 验签
     * @param respObject
     * @param publickey 说明：
     * @return
     */
    public static Boolean verifySign(JSONObject respObject, String publickey) {
        boolean verify = false;
        try {
            String respSign = respObject.getString("sign");

            respObject.remove("sign");                          // 删除sign节点
            System.out.println("==========开始验签==========");

            String rspparm = sortjson(respObject);    // ȥsign json
            String sha1    = TLinxSHA1.SHA1(rspparm);           // sha1����
            verify = TLinxRSACoder.verify(sha1.getBytes(), publickey, respSign);

            System.out.println("==========结束验签==========");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return verify;
    }

    /**
     * AES加密，再二进制转十六进制(bin2hex)
     * @param datamap 说明：
     *
     * @return 返回值说明：
     * @throws Exception
     */
    public static String handleEncrypt(TreeMap<String, String> datamap) throws Exception {
        JSONObject dataobj = JSONObject.parseObject(JSON.toJSONString(datamap));
        String     data    = TLinxAESCoder.encrypt(dataobj.toString(), StaticConfig.open_key);    // AES加密，并bin2hex
        System.out.println("====加密后的data= "+data);
        return data;
    }

    public static String handleEncrypt1(TreeMap<String, Object> datamap) throws Exception {
        JSONObject dataobj = JSONObject.parseObject(JSON.toJSONString(datamap));
        String     data    = TLinxAESCoder.encrypt(dataobj.toString(), StaticConfig.open_key);    // AES加密，并bin2hex
        System.out.println("====加密后的data= "+data);
        return data;
    }

    /**
     * 签名
     * @param getmap
     * @param datamap 说明：
     *
     * @return 返回值说明：
     */
    public static String handleSign(TreeMap<String, String> getmap, TreeMap<String, String> datamap) {
        Map<String, String> veriDataMap = new HashMap<String, String>();

        veriDataMap.putAll(getmap);
        veriDataMap.putAll(datamap);

        String sign = sign(veriDataMap, StaticConfig.privatekey);
        System.out.println("====已签名字符串= " + sign);
        // 签名
        return sign;
    }

    /**
     * 根据返回格式来选择post请求处理方式
     * @param postmap
     * @param uri
     * @param tarType
     * @return
     */
    public static String handlePostbyTarType(TreeMap<String, String> postmap, String uri, String tarType) {
        if("gzip".equals(tarType)){
            return handlePostGZIP(postmap, uri);
        }else{
            return handlePost(postmap, uri);
        }
    }

    /**
     * 请求接口
     * @param postmap
     * @param uri 说明：
     * @return      响应字符串
     */
    public static String handlePost(TreeMap<String, String> postmap, String uri) {
        String url = StaticConfig.url + uri;
        String rspStr = "";
        System.out.println("====请求地址= " + url);
        if (url.contains("https")) {
            rspStr = HttpsUtil.httpMethodPost(url, postmap, "UTF-8");
        } else {
            rspStr = HttpUtil.httpMethodPost(url, postmap, "UTF-8");
        }
        System.out.println("====post响应字符串= " + rspStr);
        return rspStr;
    }

    public static String handlePost(String url, TreeMap<String, String> postmap) {
        //url = "http://openapi.tlinx.cn/org1/order?open_id=txaalQ4ae3fde16fab071bb1bc452dfb&lang=zh-cn&timestamp=1493791966&randStr=lAMUR5ALaxopwkTZSTrUQ4MSXEid9GdJ";
        if (url.contains("https")) {
            return HttpsUtil.httpMethodPost(url, postmap, "UTF-8");
        } else {
            return HttpUtil.httpMethodPost(url, postmap, "UTF-8");
        }
    }

    public static String handlePostGZIP(TreeMap<String, String> postmap, String uri) {
        String url = StaticConfig.url + uri;
        if (url.contains("https")) {
            return HttpsUtil.httpMethodPostGZIP(url, postmap, "UTF-8");
        } else {
            return HttpUtil.httpMethodPostGZIP(url, postmap, "UTF-8");
        }
    }

    /**
     * Method main
     * Description 说明：
     *
     * @param args 说明：
     */
    public static void main(String[] args) {

    }

    // 排序
    public static String sort(Map paramMap) throws Exception {
        String sort = "";
        TLinxMapUtil signMap = new TLinxMapUtil();
        if (paramMap != null) {
            String key;
            for (Iterator it = paramMap.keySet().iterator(); it.hasNext();) {
                key = (String) it.next();
                String value = ((paramMap.get(key) != null) && (!(""
                        .equals(paramMap.get(key).toString())))) ? paramMap
                        .get(key).toString() : "";
                signMap.put(key, value);
            }
            signMap.sort();
            for (Iterator it = signMap.keySet().iterator(); it.hasNext();) {
                key = (String) it.next();
                sort = sort + key + "=" + signMap.get(key).toString() + "&";
            }
            if ((sort != null) && (!("".equals(sort)))) {
                sort = sort.substring(0, sort.length() - 1);
            }
        }
        return sort;
    }


    // 排序
    public static String sortjson(Map paramMap) throws Exception {
        String sort = "";
        TLinxMapUtil signMap = new TLinxMapUtil();
        if (paramMap != null) {
            String key;
            for (Iterator it = paramMap.keySet().iterator(); it.hasNext(); ) {
                key = (String) it.next();
                String value = ((paramMap.get(key) != null) && (!("".equals(paramMap.get(key).toString())))) ? paramMap.get(key).toString() : "";
                signMap.put(key, value);
            }
            signMap.sort();
            for (Iterator it = signMap.keySet().iterator(); it.hasNext(); ) {
                key = (String) it.next();
                sort = sort + key + "=" + signMap.get(key).toString() + "&";
            }
            if ((sort != null) && (!("".equals(sort)))) {
                sort = sort.substring(0, sort.length() - 1);
            }
        }
        return sort;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
