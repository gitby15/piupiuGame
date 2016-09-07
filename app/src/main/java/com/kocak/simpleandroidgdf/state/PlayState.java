package com.kocak.simpleandroidgdf.state;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

import com.kocak.simpleandroidgdf.main.Assets;
import com.kocak.simpleandroidgdf.main.GameMainActivity;
import com.kocak.simpleandroidgdf.model.Block;
import com.kocak.simpleandroidgdf.model.Cloud;
import com.kocak.simpleandroidgdf.model.Player;
import com.kocak.simpleandroidgdf.util.Painter;

import java.util.ArrayList;


/**
 * Created by 10188927 on 7/1/2016.
 */
public class PlayState extends State {

    private Player player;
    private ArrayList<Block> blocks;
    private Cloud cloud,cloud2;
    private int playerScore = 0;

    private static final int BLOCK_HEIGHT = 50;
    private static final int BLOCK_WIDTH = 15;
    private int blockSpeed = -300;

    private static final int PLAYER_WIDTH = 60;
    private static final int PLAYER_HEIGHT = 92;


    private float recentTouchY;

    @Override
    public void init() {
        player = new Player(160, GameMainActivity.GAME_HEITHT - 45 - PLAYER_HEIGHT,PLAYER_WIDTH,PLAYER_HEIGHT);
        blocks = new ArrayList<Block>();
        cloud = new Cloud(100,100);
        cloud2 = new Cloud(500,50);
        for(int i = 0;i<5;i++){
            Block b = new Block(i*300, GameMainActivity.GAME_HEITHT - 95,BLOCK_WIDTH,BLOCK_HEIGHT);
            blocks.add(b);
        }

    }

    @Override
    public void update(float delta) {
        if(!player.isAlive()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setCurrentState(new MenuState());
            Log.d("PlayState","Game Over!! Your Burden!!!");
        }
        cloud.update(delta);
        cloud2.update(delta);
        Assets.runAnim.update(delta);
        player.update(delta);
        updateBlocks(delta);

    }


    private void updateBlocks(float delta) {
        for(Block b: blocks){
            b.update(delta,blockSpeed);

            if(b.isVisible()){
                if(player.isDucked() && Rect.intersects(b.getRect(),player.getDuckRect())){
                    b.onCollide(player);
                }else if(!player.isDucked() && Rect.intersects(b.getRect(),player.getDuckRect())){
                    b.onCollide(player);
                }
            }
        }

    }

    @Override
    public void render(Painter g) {
        g.setColor(Color.rgb(208,244,247));
        g.fillRect(0,0,GameMainActivity.GAME_WIDTH,GameMainActivity.GAME_HEITHT);

        renderPlayer(g);
        renderBlocks(g);
        renderSun(g);
        renderClouds(g);
        g.drawImage(Assets.grass,0,405);
        renderScore(g);
    }
    private void renderScore(Painter g){
        g.setFont(Typeface.SANS_SERIF, 25);
        g.setColor(Color.GRAY);
        g.drawString("" + playerScore / 199, 20, 30);
    }

    private void renderPlayer(Painter g){
        if(player.isGrounded()){
            if(player.isDucked()){
                g.drawImage(Assets.duck,(int) player.getX(),(int)player.getY());
            }else{
               Assets.runAnim.render(g, (int) player.getX(), (int) player.getY(), player.getWidth(), player.getHeight());
            }
        }else{
            g.drawImage(Assets.jump,(int)player.getX(),(int)player.getY(),player.getWidth(),player.getHeight());
        }
    }

    private void renderBlocks(Painter g){
        for(Block b:blocks){
            if(b.isVisible()){
                g.drawImage(Assets.block,(int)b.getX(),(int)b.getY(),BLOCK_WIDTH,BLOCK_HEIGHT);
            }
        }
    }

    private void renderSun(Painter g){
        g.setColor(Color.rgb(255,165,0));
        g.fillOval(715, -85, 170, 170);
        g.setColor(Color.YELLOW);
        g.fillOval(725,-75,150,150);
    }

    private void renderClouds(Painter g){
        g.drawImage(Assets.cloud1,(int)cloud.getX(),(int)cloud.getY(),100,60);
        g.drawImage(Assets.cloud2,(int)cloud2.getX(),(int)cloud2.getY(),100,60);

    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {

        switch(e.getAction()){
            case MotionEvent.ACTION_DOWN:
            {
                recentTouchY = scaledY;
                break;
            }
            case MotionEvent.ACTION_UP:
            {
               // if(scaledY - recentTouchY <-50){
               //     player.jump();
               // }else if(scaledY - recentTouchY >50){
               //     player.duck();

                if(scaledY - recentTouchY >50){
                    player.duck();
                }else{
                    player.jump();
                }

                break;
            }
        }


      //  if(e.getAction() == MotionEvent.ACTION_DOWN){
      //      recentTouchY = scaledY;
      //  }else if(e.getAction() == MotionEvent.ACTION_UP){
      //      if(scaledY - recentTouchY <-50){
      //          player.jump();
      //      }else if(scaledY - recentTouchY >50){
      //          player.duck();
      //      }
//

        return true;
    }
}
