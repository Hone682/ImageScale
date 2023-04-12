package com.example.imagescale;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import androidx.annotation.NonNull;

public class MyImageVIew extends View {
    Drawable image;
    ScaleGestureDetector gestureDetector;
    float scale = 1f;

    public MyImageVIew(Context context) {
        super(context);
        image = context.getResources().getDrawable(R.drawable.starry_night);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        gestureDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.scale(scale, scale);
        image.draw(canvas);
        canvas.restore(); // canvas 원래대로 돌려 놓음
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        invalidate(); /** 시험 나올 수 있음 **/
        // 해당 뷰 화면이 무효(invalid)임을 안드로이드에게 알리게 되고, 안드로이드는 현재의 뷰 상태를 반영하여 새로 화면을 그려준다.
        return true;
    }

    class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(@NonNull ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            if(scale >= 10f) scale = 10f;
            if(scale <= 0.1f) scale = 0.1f;

            return true;
        }
    }


}