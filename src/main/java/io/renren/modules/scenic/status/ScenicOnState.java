package io.renren.modules.scenic.status;

/**
 * @Author 陈乐
 * @Date 2023/5/25 16:52
 * @Version 1.0
 */
public class ScenicOnState extends ScenicState{
    @Override
    public boolean checkByScenic() {
        System.out.println("该景区开发，可以售票");
        return true;
    }
}
