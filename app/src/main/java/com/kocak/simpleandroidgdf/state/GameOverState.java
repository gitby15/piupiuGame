package com.kocak.simpleandroidgdf.state;

import android.view.MotionEvent;

import com.kocak.simpleandroidgdf.util.Painter;

/**
 * Created by 10188927 on 7/1/2016.
 */
public class GameOverState extends State {
    public GameOverState(int playerScore) {
        super();
    }

    @Override
    public void init() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(Painter g) {

    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        return false;
    }
}
