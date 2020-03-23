package com.xck.chapter01.main;

import com.xck.chapter01.sortNoRepeatNum.SortNoRepeatNum;

public class SortNoRepeatMain {
    public static void main(String[] args) {
        test3();
    }

    public static void test1(){
        int bw = 100*10000;
        SortNoRepeatNum.readFileAllToVector(bw*10, "D:\\no_repeat_num.txt", "D:\\sort_num.txt");
    }

    public static void test2(){
        int bw = 100*10000;
        int min = bw;
        int max = min+4194000;
        int diff = max-min;
        while (true) {
            try {
                for (int i=0;i<bw/diff+1;i++) {
                    SortNoRepeatNum.readIntToVectorInRange(diff, min, max
                            , "/Users/xck/workDir/no_repeat_num.txt"
                            , "/Users/xck/workDir/sort_num.txt");
                    min=max+1;
                    max=min+diff;
                }
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                max-=8;
            }
        }
    }

    public static void test3(){
        int bw = 100*10000;
        int diff = 131067;
        int min = bw;
        int max = bw+diff;
        while (true) {
            try {
                for (int i=0;i<bw/diff+1;i++) {
                    SortNoRepeatNum.readIntToArrayInRange(diff, min, max
                            , "/Users/xck/workDir/no_repeat_num.txt"
                            , "/Users/xck/workDir/sort_num.txt");
                    min=max+1;
                    max=min+diff-1;
                }
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                max-=8;
            }
        }
    }
}
