package io.renren.modules.scenic.payInterface;


public interface UsePay  {
    //查询支付接口是否可用
    public Boolean isAvailable();
    //付款
    public void pay(String mchid,String appid, double amount);
    //查询订单信息
    public String query(String orderid);
}
