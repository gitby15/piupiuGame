package com.kocak.simpleandroidgdf.animation;

import android.graphics.Bitmap;

/**
 * Created by 10188927 on 6/30/2016.
 */
public class Frame {
    private Bitmap image;
    private double duration;

    public Frame(Bitmap image,double duration){
        this.image = image;
        this.duration = duration;
    }
    public double getDuration(){
        return duration;
    }
    public Bitmap getImage(){
        return image;
    }




}
