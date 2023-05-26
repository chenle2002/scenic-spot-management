package io.renren.modules.scenic.factory;

import io.renren.modules.scenic.payInterface.UsePay;

/**
 * @Author 陈乐
 * @Date 2023/5/26 10:32
 * @Version 1.0
 */
public class PayServiceFactory {
    public static UsePay getPayService(String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        UsePay usePay = null;
        Class c = Class.forName("io.renren.modules.scenic.payInterface.Impl." + type + "Impl");

        usePay = (UsePay) c.newInstance();
        return usePay;
    }
}
