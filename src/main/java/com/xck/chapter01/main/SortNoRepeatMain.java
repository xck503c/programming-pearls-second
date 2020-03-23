package com.xck.chapter01.main;

import com.xck.chapter01.sortNoRepeatNum.SortNoRepeatNum;

public class SortNoRepeatMain {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        int bw = 100*10000;
        SortNoRepeatNum.readFileAllToVector(bw*10, "D:\\no_repeat_num.txt", "D:\\sort_num.txt");
    }

    public static void test2(){
//        int min = 0;
//        int max =
//        SortNoRepeatNum.readIntToVectorInRange(bw*10, );
    }
}
