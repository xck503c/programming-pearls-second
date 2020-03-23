package com.xck.chapter01.generateNoRepeat;

import com.xck.chapter01.util.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 通过随机生成数字来达到随机目的
 */
public class GenNoRepeatByRandomNum {

    /**
     * 用于测试，生成无重复的，最大为1000w的，100w个非负整数，并写入文件中.
     * 利用Set集合不允许重复的特性
     * @param numSize 生成随机数的数量
     * @param minBound 生成随机数的下限
     * @param maxBound 生成随机数的上限
     * @param pathName
     */
    public static void writeRandomNum_NoRepeate1(int numSize, int minBound, int maxBound, String pathName){
        File file = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        long repeatCountSum = 0;
        long getNumTimeSum = 0;
        long start = System.currentTimeMillis();
        try {
            file = new File(pathName);
            if(!file.exists()){
                file.createNewFile();
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                Set<Integer> set = new HashSet<>();

                int oldSize = set.size();
                long roudStart = System.nanoTime();
                int count = 0; //计数获取的数量
                int repeatCount = 0; //计数获取一个数字需要随机几次
                while(set.size()<numSize){
                    int random = Util.getRandomNumInRange(minBound, maxBound);
                    set.add(random);
                    int newSize = set.size();
                    if (newSize > oldSize) {
                        bw.write(random + "\r\n");
                        oldSize = newSize;
                        //计数和测试
                        long roudEnd = System.nanoTime();
                        getNumTimeSum+=(roudEnd-roudStart);
                        count++;
                        roudStart = roudEnd;

                        repeatCountSum+=repeatCount;
                        repeatCount = 0;
                    }
                    repeatCount++;
                }
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
            System.out.println("总耗时:"+(System.currentTimeMillis()-start)+"ms");
            System.out.println("平均获取数字耗时:"+getNumTimeSum/numSize+"纳秒");
            System.out.println("平均获取数字重复随机次数:"+repeatCountSum/numSize+"次");
        }
    }
}
