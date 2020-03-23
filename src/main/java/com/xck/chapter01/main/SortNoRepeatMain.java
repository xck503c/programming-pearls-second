package com.xck.chapter01.main;

import com.xck.chapter01.sortNoRepeatNum.SortNoRepeatNum;

public class SortNoRepeatMain {
    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        int bw = 100*10000;
        SortNoRepeatNum.readFileAllToVector(bw*10, "D:\\no_repeat_num.txt", "D:\\sort_num.txt");
    }

    public static void test2(){
        int min = 0;
        int max = 4194000;
        while (true) {
            try {
                for (int i=0;i<3;i++) {
                    SortNoRepeatNum.readIntToVectorInRange(max-min, min, max
                            , "D:\\no_repeat_num.txt", "D:\\sort_num.txt");
                    min=max+1;
                    max=min+4194000;
                }
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                max-=8;
            }
        }
    }
}
