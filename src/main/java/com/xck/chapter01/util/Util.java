package com.xck.chapter01.util;

import java.util.*;

public class Util {
    /**
     * 可以随机出一个数字，在指定的上限和下限之间
     * @param minBound 下限
     * @param maxBound 上限
     * @return
     */
    public static int getRandomNumInRange(int minBound, int maxBound){
        Random random = new Random();
        return random.nextInt(maxBound)%(maxBound-minBound+1)+minBound;
    }
}
