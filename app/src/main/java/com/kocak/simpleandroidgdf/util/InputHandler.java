package com.kocak.simpleandroidgdf.util;

import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;

import com.kocak.simpleandroidgdf.main.GameMainActivity;
import com.kocak.simpleandroidgdf.state.State;

/**
 * Created by 10188927 on 6/29/2016.
 */
public class InputHandler implements OnTouchListener {

    private State currentState;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int scaledX = (int)((event.getX()/v.getWidth())* GameMainActivity.GAME_WIDTH);
        int scaledY = (int)((event.getY()/v.getHeight())*GameMainActivity.GAME_HEITHT);


        return currentState.onTouch(event,scaledX,scaledY);
    }

    public void setCurrentState(State currentState){
        this.currentState = currentState;
    }



}
