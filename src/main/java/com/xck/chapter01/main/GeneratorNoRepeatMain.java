package com.xck.chapter01.main;

import com.xck.chapter01.generateNoRepeat.GenNoRepeatByRandomIndex;
import com.xck.chapter01.generateNoRepeat.GenNoRepeatByRandomNum;

public class GeneratorNoRepeatMain {

    public static void main(String[] args) {

    }

    public static void test1(){
        int bw = 100*10000;
        //生成1千万个数字，每个数字都是大于>1百万的整数
        GenNoRepeatByRandomNum.writeRandomNum_NoRepeate1(bw, bw, bw*10-1, "D:\\no_repeat_num.txt");
        //卡在获取第9000000数字耗时:1424556726纳秒, 每次都要循环几次获取:4225300
    }

    public static void test2(){
        int bw = 100*10000;
        //生成1千万个数字，每个数字都是大于>1百万的整数
        GenNoRepeatByRandomIndex.writeRandomNumAndNoRepeateInRandomIndex(bw, bw, bw*10-1, "D:\\no_repeat_num.txt");
    }

    public static void test3(){
        int bw = 100*10000;
        //生成1千万个数字，每个数字都是大于>1百万的整数
        GenNoRepeatByRandomIndex.writeRandomNumAndNoRepeateInRandomIndex_array(bw, bw, bw*10-1, "D:\\no_repeat_num.txt");
    }
}
