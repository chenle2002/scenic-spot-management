package io.renren.modules.scenic.payInterface.Impl;


import com.alibaba.fastjson.JSONObject;
import io.renren.modules.scenic.config.RequestConfig;
import io.renren.modules.scenic.config.Token;
import io.renren.modules.scenic.payInterface.UsePay;
import io.renren.modules.scenic.utils.HttpUtil;
import org.springframework.stereotype.Component;

@Component("AlipayImpl")
public class AlipayImpl implements UsePay {

    public Boolean isAvailable() {
        String result = HttpUtil.sendGet(RequestConfig.ALIPAY_ISRUNING, null);
        System.out.println(result + '\n');
        System.out.println("这里是阿里支付" + '\n');

        //先把String对象转换成json对象
        JSONObject object = JSONObject.parseObject(result);
        String token = (String) object.getJSONObject("data").get("token");
        System.out.println(token);

        if (token != null) {
            Token.setToken(token);
            return true;
        }
        return false;
    }

    public void pay(String mchid, String appid, double amount) {
        String request = "amount=" + amount + "&" + "appid=20201120309" + "&" + "mchid=20170100" + "&" + "content=0" + "&" + "token=" + Token.getToken();
        String result = HttpUtil.sendPost(RequestConfig.ALIPAY_PAY, request);
        System.out.println(result);
    }

    public String query(String orderid) {
        String request = "orderID=" + orderid + "&token=" + Token.getToken();
        String result = HttpUtil.sendGet(RequestConfig.ALIPAY_QUERY, request);
        System.out.println(result);
        return result;
    }

}
