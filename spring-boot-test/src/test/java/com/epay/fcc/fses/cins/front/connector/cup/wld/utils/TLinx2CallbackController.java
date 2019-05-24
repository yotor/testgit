package com.epay.fcc.fses.cins.front.connector.cup.wld.utils;

//~--- non-JDK imports --------------------------------------------------------

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

//~--- JDK imports ------------------------------------------------------------

//~--- classes ----------------------------------------------------------------

/**
 * Class TLinx2CallbackController
 * Description
 * Create 2017-04-27 11:07:58
 * @author Benny.YEE
 */
@Controller
@RequestMapping("/callback")
public class TLinx2CallbackController {

    /**
     * Field LOGGER
     * Description
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TLinx2CallbackController.class);

    /**
     * Method testPayCallback
     * Description 说明：
     *
     * @param request 说明：
     *
     * @return 返回值说明：
     */
    @RequestMapping(
        value  = "/scanpay_cashier/payResult",
        method = RequestMethod.GET
    )
    @ResponseBody
    public String testPayCallback(HttpServletRequest request) {
        LOGGER.debug("接收到的支付回调信息为：{}", request);

        Map<String, String> params = new TreeMap<String, String>();

        // 取出所有参数是为了验证签名
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();

            params.put(parameterName, request.getParameter(parameterName));
        }

        JSONObject paramsObject = JSONObject.parseObject(JSON.toJSONString(params));

        if (TLinx2Util.verifySign(paramsObject, StaticConfig.publickey)) {    // 验签
            System.out.println("===========验签成功==");
            System.out.println("===========回调参数是：" + paramsObject.toString());
            return "notify_success";
        } else {
            System.out.println("===========验签失败==");
            return "fail";
        }


    }
}


//~ Formatted by Jindent --- http://www.jindent.com
