package com.example.tennis;

import android.graphics.RectF;

import java.util.Random;

/**
 * The class represents the ball
 *
 * @author Alan Liang
 * @version 0.1 10/8/2019
 *
 * http://gamecodeschool.com/android/programming-a-pong-game-for-android/
 */
public class Ball {

    private RectF mRect;
    private float mXVelocity;
    private float mYVelocity;
    private float mBallWidth;
    private float mBallHeight;

    /**
     * Constructor to init
     * @param screenX
     * @param screenY
     */
    public Ball(int screenX, int screenY){

        // Make the mBall size relative to the screen resolution
        mBallWidth = screenX / 50;
        mBallHeight = mBallWidth;

    /*
        Start the ball travelling straight up
        at a quarter of the screen height per second
    */
        mYVelocity = screenY / 4;
        mXVelocity = mYVelocity;

        // Initialize the Rect that represents the mBall
        mRect = new RectF();

    }

    /**
     * Give access to the Rect
     * @return
     */
    public RectF getRect(){
        return mRect;
    }

    /**
     * Change the position each frame
     * @param fps
     */
    public void update(long fps){
        mRect.left = mRect.left + (mXVelocity / fps);
        mRect.top = mRect.top + (mYVelocity / fps);
        mRect.right = mRect.left + mBallWidth;
        mRect.bottom = mRect.top - mBallHeight;
    }

    /**
     * Reverse the vertical heading
     */
    public void reverseYVelocity(){
        mYVelocity = -mYVelocity;
    }


    /**
     * Reverse the horizontal heading
     */
    public void reverseXVelocity(){
        mXVelocity = -mXVelocity;
    }

    /**
     * Ramdom velocity on X direction
     */
    public void setRandomXVelocity(){

        // Generate a random number either 0 or 1
        Random generator = new Random();
        int answer = generator.nextInt(2);

        if(answer == 0){
            reverseXVelocity();
        }
    }


    /**
     * Speed up by 10%
     * A score of over 20 is quite difficult
     * Reduce or increase 10 to make this easier or harder
     */
    public void increaseVelocity(){
        mXVelocity = mXVelocity + mXVelocity / 10;
        mYVelocity = mYVelocity + mYVelocity / 10;
    }

    /**
     * Clear Y
     * @param y
     */
    public void clearObstacleY(float y){
        mRect.bottom = y;
        mRect.top = y - mBallHeight;
    }

    /**
     * clear X
     * @param x
     */
    public void clearObstacleX(float x){
        mRect.left = x;
        mRect.right = x + mBallWidth;
    }

    /**
     * Reset properties
     * @param x
     * @param y
     */
    public void reset(int x, int y){
        mRect.left = x / 2;
        mRect.top = y - 20;
        mRect.right = x / 2 + mBallWidth;
        mRect.bottom = y - 20 - mBallHeight;
    }

}