package com.xck.chapter01.generateNoRepeat;

import com.xck.chapter01.util.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过随机交换索引来达到随机目的
 */
public class GenNoRepeatByRandomIndex {

    /**
     * 参考地址https://www.cnblogs.com/Zeroinger/p/5502382.html
     * 通过事先初始化一定长度的数组，而后进行随机交换达到随机的目的
     * @param numSize 需要获取随机数的数量
     * @param minBound 需要获取随机数的下限
     * @param maxBound 需要获取随机数的上限
     * @param pathName
     */
    public static void writeRandomNumAndNoRepeateInRandomIndex(int numSize, int minBound, int maxBound, String pathName){
        File file = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        long start = System.currentTimeMillis();
        try {
            file = new File(pathName);
            if(!file.exists()){
                int diff = maxBound - minBound;
                //要生成多少个数字，list就多长
                List<Integer> list = new ArrayList<>(numSize);
                for(int i=0; i<numSize; i++){
                    //因为要生成指定区间内的顺序数字 100~200 1000
                    list.add((minBound+i)>maxBound?minBound+(minBound+i)%diff:(minBound+i));
                }
                System.out.println("初始化耗时: " + (System.currentTimeMillis()-start));

                start = System.currentTimeMillis();
                int temp;
                for(int i=0; i<numSize; i++){//要生成多少个数字，就随机多少次
                    int randomIndex = Util.getRandomNumInRange(0, numSize);
                    if(randomIndex!=i){
                        temp = list.set(i, list.get(randomIndex));
                        list.set(randomIndex, temp);
                    }
                }
                System.out.println("随机耗时: " + (System.currentTimeMillis()-start));

                start = System.currentTimeMillis();
                file.createNewFile();
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                for(int i=0; i<numSize; i++){
                    bw.write(list.get(i) + "\r\n");
                }
                System.out.println("写入耗时: " + (System.currentTimeMillis()-start));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if(fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeRandomNumAndNoRepeateInRandomIndex_array(int numSize, int minBound, int maxBound, String pathName){
        File file = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        long start = System.currentTimeMillis();
        try {
            file = new File(pathName);
            if(!file.exists()){
                int diff = maxBound - minBound;
                //要生成多少个数字，list就多长
                int[] tmpArr = new int[numSize];
                for(int i=0; i<numSize; i++){
                    //因为要生成指定区间内的顺序数字 100~200 1000
                    tmpArr[i] = (minBound+i)>maxBound?minBound+(minBound+i)%diff:(minBound+i);
                }
                System.out.println("初始化耗时: " + (System.currentTimeMillis()-start));

                start = System.currentTimeMillis();
                int temp;
                for(int i=0; i<numSize; i++){//要生成多少个数字，就随机多少次
                    int randomIndex = Util.getRandomNumInRange(0, numSize);
                    if(randomIndex!=i){
                        temp = tmpArr[i];
                        tmpArr[i] = tmpArr[randomIndex];
                        tmpArr[randomIndex] = temp;
                    }
                }
                System.out.println("随机耗时: " + (System.currentTimeMillis()-start));

                start = System.currentTimeMillis();
                file.createNewFile();
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                for(int i=0; i<numSize; i++){
                    bw.write(tmpArr[i] + "\r\n");
                }
                System.out.println("写入耗时: " + (System.currentTimeMillis()-start));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if(fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
