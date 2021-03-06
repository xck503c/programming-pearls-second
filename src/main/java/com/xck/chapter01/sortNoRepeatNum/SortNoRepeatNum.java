package com.xck.chapter01.sortNoRepeatNum;

import com.xck.chapter01.util.BitVector;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class SortNoRepeatNum {

    /**
     * 读取指定文件中的所有整数到位向量中
     * @param numSize
     * @param srcPathName
     * @param targetPathName
     * @return
     */
    public static void readFileAllToVector(int numSize, String srcPathName, String targetPathName){
        File srcFile = null;
        FileReader fr = null;
        BufferedReader br = null;
        BitVector bitVector = new BitVector(numSize);
        try {
            srcFile = new File(srcPathName);
            if(srcFile.exists()){
                fr = new FileReader(srcFile);
                br = new BufferedReader(fr);

                int count = 0;
                String result;
                while((result = br.readLine())!=null){
                    boolean setResult = bitVector.set(Integer.parseInt(result));
                    if(!setResult){
                        System.out.println(result);
                    }
                    count++;
                }
                System.out.println("读取整数: " + count);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File targetFile = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        long start = System.currentTimeMillis();
        try {
            targetFile = new File(targetPathName);
            if(!targetFile.exists()){
                targetFile.createNewFile();
                fw = new FileWriter(targetFile);
                bw = new BufferedWriter(fw);
                Iterator<Integer> it = bitVector.iterator();
                int count = 0;
                while (it.hasNext()){
                    bw.write(it.next()+"\r\n");
                    count++;
                }
                System.out.println("写入总数: " + count);
            }
            System.out.println("写入耗时: " + (System.currentTimeMillis()-start));
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

    /**
     * 读取指定文件中的指定范围整数到位向量中
     * @param numSize
     * @param srcPathName
     * @param targetPathName
     * @return
     */
    public static void readIntToVectorInRange(int numSize, int minBound, int maxBound
            , String srcPathName, String targetPathName){
        File srcFile = null;
        FileReader fr = null;
        BufferedReader br = null;
        BitVector bitVector = new BitVector(numSize);
        System.out.println("最大位数: " + numSize);
        try {
            srcFile = new File(srcPathName);
            if(srcFile.exists()){
                fr = new FileReader(srcFile);
                br = new BufferedReader(fr);

                int count = 0;
                String result;
                while((result = br.readLine())!=null){
                    int targetInt = Integer.parseInt(result);
                    if(targetInt>maxBound || targetInt<minBound) continue;
                    boolean setResult = bitVector.set(targetInt);
                    if(!setResult){
                        System.out.println(result);
                    }
                    count++;
                }
                System.out.println("读取总数: " + count);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File targetFile = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        long start = System.currentTimeMillis();
        try {
            targetFile = new File(targetPathName);
            if(!targetFile.exists()){
                targetFile.createNewFile();
            }
            fw = new FileWriter(targetFile, true);
            bw = new BufferedWriter(fw);
            Iterator<Integer> it = bitVector.iterator();
            int count = 0;
            while (it.hasNext()){
                bw.write((minBound+it.next())+"\r\n");
                count++;
            }
            System.out.println("写入总数: " + count);
            System.out.println("写入耗时: " + (System.currentTimeMillis()-start));
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

    /**
     * 读取指定文件中的指定范围的整数到位向量中
     * @param numSize
     * @param srcPathName
     * @param targetPathName
     * @return
     */
    public static void readIntToArrayInRange(int numSize, int minBound, int maxBound
            , String srcPathName, String targetPathName){
        File srcFile = null;
        FileReader fr = null;
        BufferedReader br = null;
        int[] tmpArray = new int[numSize+1];
        try {
            srcFile = new File(srcPathName);
            if(srcFile.exists()){
                fr = new FileReader(srcFile);
                br = new BufferedReader(fr);

                int count = 0;
                String result;
                while((result = br.readLine())!=null){
                    int targetInt = Integer.parseInt(result);
                    if(targetInt>maxBound || targetInt<minBound) continue;
                    tmpArray[count] = targetInt;
                    count++;
                }
                System.out.println("读取总数: " + count);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long start = System.currentTimeMillis();
        Arrays.sort(tmpArray);
        System.out.println("排序耗时:"+(System.currentTimeMillis()-start));

        File targetFile = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        start = System.currentTimeMillis();
        try {
            targetFile = new File(targetPathName);
            if(!targetFile.exists()){
                targetFile.createNewFile();
            }
            fw = new FileWriter(targetFile, true);
            bw = new BufferedWriter(fw);
            for(int i=0; i<tmpArray.length;i++){
                bw.write(tmpArray[i] + "\n\r");
            }
            System.out.println("写入耗时: " + (System.currentTimeMillis()-start));
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
