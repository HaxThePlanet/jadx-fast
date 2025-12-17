package com.google.android.exoplayer2.video.b0;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* loaded from: classes2.dex */
final class m extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, com.google.android.exoplayer2.video.b0.g.a {

    private final PointF a;
    private final PointF b;
    private final com.google.android.exoplayer2.video.b0.m.a c;
    private final float v;
    private final GestureDetector w;
    private volatile float x = 3.1415927f;

    public interface a {
        public abstract void b(PointF pointF);

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return 0;
        }
    }
    public m(Context context, com.google.android.exoplayer2.video.b0.m.a m$a2, float f3) {
        super();
        PointF pointF = new PointF();
        this.a = pointF;
        PointF pointF2 = new PointF();
        this.b = pointF2;
        this.c = a2;
        this.v = f3;
        GestureDetector obj3 = new GestureDetector(context, this);
        this.w = obj3;
        final int obj2 = 1078530011;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener
    public void a(float[] fArr, float f2) {
        this.x = -f2;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.a.set(motionEvent.getX(), motionEvent.getY());
        return 1;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f3, float f4) {
        obj5 /= obj7;
        PointF obj8 = this.a;
        obj7 /= f2;
        obj8.set(motionEvent2.getX(), motionEvent2.getY());
        double d = (double)obj6;
        float obj6 = (float)d3;
        obj8 = (float)d2;
        PointF pointF = this.b;
        pointF.x = f6 -= i4;
        f7 += obj8;
        pointF.y = i2;
        pointF.y = Math.max(-1036779520, Math.min(1110704128, i2));
        this.c.b(this.b);
        return 1;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.c.onSingleTapUp(motionEvent);
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener
    public boolean onTouch(View view, MotionEvent motionEvent2) {
        return this.w.onTouchEvent(motionEvent2);
    }
}
