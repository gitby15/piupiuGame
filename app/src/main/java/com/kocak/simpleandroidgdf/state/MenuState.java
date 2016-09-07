package com.kocak.simpleandroidgdf.state;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import com.kocak.simpleandroidgdf.main.Assets;
import com.kocak.simpleandroidgdf.util.Painter;
import com.kocak.simpleandroidgdf.util.UIButton;

/**
 * Created by 10188927 on 6/30/2016.
 */
public class MenuState extends State {

    //public Rect playRect,scoreRect;

    //private boolean playDown = false;
   // private boolean scoreDown = false;


    private UIButton playButton,scoreButton;

    @Override
    public void init() {
        playButton = new UIButton(316,227,484,286,Assets.start,Assets.startDown);
        scoreButton = new UIButton(316,300,484,359,Assets.score,Assets.scoreDown);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(Painter g) {
       // g.drawImage(Assets.welcome,0,0);
       // if(playDown){
       //     g.drawImage(Assets.startDown,playRect.left,playRect.top);
       // }else{
       //     g.drawImage(Assets.start,playRect.left,playRect.top);
       // }
//
       // if(scoreDown){
       //     g.drawImage(Assets.scoreDown,scoreRect.left,scoreRect.top);
       // }else{
       //     g.drawImage(Assets.score,scoreRect.left,scoreRect.top);
//
        g.drawImage(Assets.welcome,0,0);
        playButton.render(g);
        scoreButton.render(g);


    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {

       // if(e.getAction() == MotionEvent.ACTION_DOWN){
       //     if(playRect.contains(scaledX,scaledY)){
       //         playDown = true;
       //         scoreDown = false;
       //     }else if(scoreRect.contains(scaledX,scaledY)){
       //         scoreDown = true;
       //         playDown = false;
       //     }
       // }
//
       // if(e.getAction() == MotionEvent.ACTION_UP){
       //     if(playDown && playRect.contains(scaledX,scaledY)){
       //         playDown = false;
       //         Log.d("MenuState", "Play Button Pressed!");
       //     }else if(scoreDown && scoreRect.contains(scaledX,scaledY)){
       //         scoreDown = false;
       //         Log.d("MenuState","Score Button Pressed!");
       //     }
//
        if(e.getAction() == MotionEvent.ACTION_DOWN){
            playButton.onTouchDown(scaledX,scaledY);
            scoreButton.onTouchDown(scaledX,scaledY);
        }
        if(e.getAction() == MotionEvent.ACTION_UP){
            if(playButton.isPressed(scaledX,scaledY)){
                playButton.cancel();
                setCurrentState(new PlayState());
                Log.d("MenuState", "Play Button Pressed!!");
            }else if(scoreButton.isPressed(scaledX,scaledY)){
                scoreButton.cancel();
                Log.d("MenuState","Score Button Pressed!!");
            }else{
                playButton.cancel();
                scoreButton.cancel();
            }

        }


        return true;
    }
}
