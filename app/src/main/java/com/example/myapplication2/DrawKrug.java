package com.example.myapplication2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.SurfaceHolder;

public class DrawKrug extends Thread {
    private float x, y, r;
    private long time;
    private Paint paint = new Paint();

    public DrawKrug(float x, float y, float r, long time) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.time = time;
        paint.setColor(Color.RED);
    }

    void draw(Canvas canvas) {
        if (time > 0) {
            canvas.drawCircle(x, y, r++, paint);
        }
    }

    void onTick(long ms) {
        time -= ms;
    }
}
