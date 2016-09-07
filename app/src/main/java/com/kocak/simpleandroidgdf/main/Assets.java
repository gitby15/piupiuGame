package com.kocak.simpleandroidgdf.main;
import android.graphics.Bitmap.*;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.*;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import com.kocak.simpleandroidgdf.animation.Animation;
import com.kocak.simpleandroidgdf.animation.Frame;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 10188927 on 6/29/2016.
 */
public class Assets {
    public static final boolean TRANSPARENCY = false;
    private static SoundPool soundPool;
    public static Bitmap welcome, block, cloud1, cloud2, duck, grass, jump, run1, run2, run3, run4, run5, score, scoreDown, startDown, start;
    public static Animation runAnim;
    public static int hitID, onJumpID;




    public static void Load(){

        welcome = LoadBitmap("welcome.png",false);
        block = LoadBitmap("block.png", false);
        cloud1 = LoadBitmap("cloud1.png",true);
        cloud2 = LoadBitmap("cloud2.png",true);
        duck = LoadBitmap("duck.png",true);
        grass = LoadBitmap("grass.png",false);
        jump = LoadBitmap("jump.png",true);
        run1 = LoadBitmap("run_anim1.png",true);
        run2 = LoadBitmap("run_anim2.png",true);
        run3 = LoadBitmap("run_anim3.png",true);
        run4 = LoadBitmap("run_anim4.png",true);
        run5 = LoadBitmap("run_anim5.png",true);

        scoreDown = LoadBitmap("score_button_down.png", true);
        score = LoadBitmap("score_button.png", true);
        start = LoadBitmap("start_button.png", true);
        startDown = LoadBitmap("start_button_down.png", true);

        Frame f1 = new Frame(run1,0.1f);
        Frame f2 = new Frame(run2,0.1f);
        Frame f3 = new Frame(run3,0.1f);
        Frame f4 = new Frame(run4,0.1f);
        Frame f5 = new Frame(run5,0.1f);

        runAnim = new Animation(f1,f2,f3,f4,f5,f3,f2);

        hitID = LoadSound("hit.wav");
        onJumpID = LoadSound("onjump.wav");








    }

    private static Bitmap LoadBitmap(String filename , boolean transparency){
        InputStream inputStream = null;
        try{
            inputStream = GameMainActivity.assets.open(filename);
        }catch(IOException e){
            Log.e("IOE","------------ get welcome picture fail ------------");
            e.printStackTrace();
        }
        Options options = new BitmapFactory.Options();
        if(transparency){
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }else{
            options.inPreferredConfig = Config.RGB_565;
        }
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream,null,options);

        return bitmap;

    }
    private static int LoadSound(String filename){
        int soundID = 0;
        if(soundPool == null){
            soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC,0);
        }try{
            soundID = soundPool.load(GameMainActivity.assets.openFd(filename),1);
        }catch(IOException e){
            e.printStackTrace();
        }
        return soundID;
    }

    public static void playSound(int soundID){
        soundPool.play(soundID,1,1,1,0,1);
    }




}
