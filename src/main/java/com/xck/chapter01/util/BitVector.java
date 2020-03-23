package com.xck.chapter01.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * 位向量
 *
 * 这里使用字节数组来实现位向量，主要目的是给文件中所保存的(无重复的)整数排序 --- 位排序。
 *
 * 原理：
 * 一个字节有8bit，相当于一个字节可以表示8个非负整数。
 * 在每个bit上用0/1来表示是否有这个整数存在，0-没有，1-有。
 * 存放完成之后，只需要从头开始遍历，跳过0的位，将有1的位所表示的整数放入文件中。
 *
 * 好处：在内存中只需要处理0/1即可，所有的实现均采用位运算
 */
public class BitVector implements Iterable{
    private byte[] bitVector; //位向量
    private int size; //位向量可以存放整数的数量，最多Integer.MAX_VALUE

    public BitVector(int size) {
        //size>>3=size/8
        this.bitVector = new byte[(size>>3)+1];
        this.size = size;
    }

    /**
     * 置位：1
     * index&7=index%8
     * bitVector[index>>3] = 00000000
     * 00000000 | (1<<5) = 00000000 | 00010000 = 00010000
     * 异或| 只有不相同才会为1，所以需要有重复判断
     * @param index 需要存储的数字
     */
    public boolean set(int index){
        if(isExist(index)){
            return false;
        }
        bitVector[index>>3] |= 1<<(index&7);
        return true;
    }

    /**
     * & 只有都是1才会返回1
     * 判断index是否存在
     * 11110111 & 00001000 = 0
     * 11111111 & 10000000 = 10000000
     * @param index
     * @return
     */
    public boolean isExist(int index){
        return (bitVector[index>>3] & (1<<(index&7))) != 0;
    }

    /**
     * 清0
     * @param index
     */
    public void clear(int index){
        if(!isExist(index)){
            return;
        }
        bitVector[index>>3] &= ~(1<<(index&7));
    }

    public int getSize(){
        return size;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Itr();
    }

    /**
     * 方便后面遍历，没有进行同步
     */
    private class Itr implements Iterator<Integer>{
        int cursor = 0; //游标表示下一个要返回的索引

        Itr() {}

        @Override
        public void remove() {
            throw new UnsupportedClassVersionError();
        }

        @Override
        public void forEachRemaining(Consumer action) {
            throw new UnsupportedClassVersionError();
        }

        @Override
        public boolean hasNext() {
            int i = cursor;
            if(i >= size){
                return false;
            }
            while (!isExist(i)){
                i++;
                if(i >= size)
                    return false;
            }
            cursor = i;
            return true;
        }

        @Override
        public Integer next() {
            int i = cursor;
            if(i >= size)
                throw new NoSuchElementException();
            cursor = i+1;
            return i;
        }
    }
}

