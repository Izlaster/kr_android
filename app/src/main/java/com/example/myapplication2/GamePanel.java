package com.example.myapplication2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.os.health.TimerStat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.Timer;

public class GamePanel extends View {

    LinkedList<DrawKrug> krugList;
    private float x, y, r;

    class PaintTimer extends CountDownTimer {
        private long countDownInterval = 0;

        public PaintTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            this.countDownInterval = countDownInterval;
        }

        @Override
        public void onTick(long l) {
            for (int i = 0; i < krugList.size(); i++) {
                krugList.get(i).onTick(countDownInterval);
            }
            invalidate();
        }

        @Override
        public void onFinish() {

        }
    }

    public GamePanel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        krugList = new LinkedList<>();
        new PaintTimer(Long.MAX_VALUE, 50).start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < krugList.size(); i++) {
            krugList.get(i).draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        krugList.add(new DrawKrug(x, y, 0, 5000));
        return false;
    }
}
