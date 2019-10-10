package com.example.tennis;

import android.graphics.RectF;

/**
 * The class represents the bat
 *
 * @author Alan Liang
 * @version 0.1 10/8/2019
 *
 * http://gamecodeschool.com/android/programming-a-pong-game-for-android/
 */
public class Bat {

    // RectF is an object that holds four coordinates - just what we need
    private RectF mRect;

    // How long and high our mBat will be
    private float mLength;
    private float mHeight;

    // X is the far left of the rectangle which forms our mBat
    private float mXCoord;

    // Y is the top coordinate
    private float mYCoord;

    // This will hold the pixels per second speed that
    // the mBat will move
    private float mBatSpeed;

    // Which ways can the mBat move
    public final int STOPPED = 0;
    public final int LEFT = 1;
    public final int RIGHT = 2;

    // Is the mBat moving and in which direction
    private int mBatMoving = STOPPED;

    // The screen length and width in pixels
    private int mScreenX;
    private int mScreenY;



    /**
     * This is the constructor method
     * When we create an object from this class we will pass
     * in the screen width and mHeight
     * @param x
     * @param y
     */
    public Bat(int x, int y){

        mScreenX = x;
        mScreenY = y;

        // 1/8 screen width wide
        mLength = mScreenX / 8;

        // 1/25 screen mHeight high
        mHeight = mScreenY / 25;

        // Start mBat in roughly the sceen centre
        mXCoord = mScreenX / 2;
        mYCoord = mScreenY * 3 / 4;

        mRect = new RectF(mXCoord, mYCoord, mXCoord + mLength, mYCoord + mHeight);

        // How fast is the mBat in pixels per second
        mBatSpeed = mScreenX;
        // Cover entire screen in 1 second
    }



    /**
     * This is a getter method to make the rectangle that
     * defines our bat available in PongView class
     * @return
     */
    public RectF getRect(){
        return mRect;
    }



    /**
     * This method will be used to change/set if the mBat is going
     * left, right or nowhere
     * @param state
     */
    public void setMovementState(int state){
        mBatMoving = state;
    }



    /**
     * This update method will be called from update in PongView
     * It determines if the Bat needs to move and changes the coordinates
     * contained in mRect if necessary
     * @param fps
     */
    public void update(long fps){

        if(mBatMoving == LEFT){
            mXCoord = mXCoord - mBatSpeed / fps;
        }

        if(mBatMoving == RIGHT){
            mXCoord = mXCoord + mBatSpeed / fps;
        }

        // Make sure it's not leaving screen
        if(mRect.left < 0){ mXCoord = 0; } if(mRect.right > mScreenX){
            mXCoord = mScreenX -
                    // The width of the Bat
                    (mRect.right - mRect.left);
        }

        // Update the Bat graphics
        mRect.left = mXCoord;
        mRect.right = mXCoord + mLength;
    }

}