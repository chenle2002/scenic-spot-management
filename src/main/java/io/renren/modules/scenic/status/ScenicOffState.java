package io.renren.modules.scenic.status;

/**
 * @Author 陈乐
 * @Date 2023/5/25 16:52
 * @Version 1.0
 */
public class ScenicOffState extends ScenicState{
    @Override
    public boolean checkByScenic() {
        System.out.println("该景区未开放，禁止购票！！！");
        return false;
    }
}
