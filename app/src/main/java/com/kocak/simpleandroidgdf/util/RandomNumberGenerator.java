package com.kocak.simpleandroidgdf.util;

import java.util.Random;

/**
 * Created by 10188927 on 6/30/2016.
 */
public class RandomNumberGenerator {
    private static Random rand = new Random();

    public static int getRandIntBetween(int lowerBound, int upperBound){
        return rand.nextInt(upperBound - lowerBound) + lowerBound;
    }

    public static int getRandInt(int upperBound){
        return rand.nextInt(upperBound);
    }

}
