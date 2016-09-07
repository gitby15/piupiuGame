package com.kocak.simpleandroidgdf.state;

import android.view.MotionEvent;

import com.kocak.simpleandroidgdf.main.GameMainActivity;
import com.kocak.simpleandroidgdf.util.Painter;

/**
 * Created by 10188927 on 6/29/2016.
 */
public abstract class State {
    public void setCurrentState(State newState){
        GameMainActivity.sGame.setCurrentState(newState);
    }

    public abstract void init();
    public abstract void update(float delta);
    public abstract void render(Painter g);
    public abstract boolean onTouch(MotionEvent e, int scaledX, int scaledY);


}
