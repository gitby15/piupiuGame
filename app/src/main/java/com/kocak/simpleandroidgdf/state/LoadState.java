package com.kocak.simpleandroidgdf.state;

import android.view.MotionEvent;

import com.kocak.simpleandroidgdf.main.Assets;
import com.kocak.simpleandroidgdf.util.Painter;

/**
 * Created by 10188927 on 6/30/2016.
 */
public class LoadState extends State {

    @Override
    public void init() {
        Assets.Load();
    }

    @Override
    public void update(float delta) {
        setCurrentState(new MenuState());
    }

    @Override
    public void render(Painter g) {

    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        return false;
    }
}
