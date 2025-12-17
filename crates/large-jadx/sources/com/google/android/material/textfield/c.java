package com.google.android.material.textfield;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.view.View;
import f.c.a.e.d0.g;
import f.c.a.e.d0.k;

/* loaded from: classes2.dex */
class c extends g {

    private final Paint R;
    private final RectF S;
    private int T;
    c() {
        super(0);
    }

    c(k k) {
        k obj2;
        if (k != null) {
        } else {
            obj2 = new k();
        }
        super(obj2);
        obj2 = new Paint(1);
        this.R = obj2;
        u0();
        obj2 = new RectF();
        this.S = obj2;
    }

    private void o0(Canvas canvas) {
        boolean z;
        if (!v0(getCallback())) {
            canvas.restoreToCount(this.T);
        }
    }

    private void p0(Canvas canvas) {
        boolean z;
        Canvas obj3;
        final Drawable.Callback callback = getCallback();
        if (v0(callback)) {
            z = 2;
            if ((View)callback.getLayerType() != z) {
                callback.setLayerType(z, 0);
            }
        } else {
            r0(canvas);
        }
    }

    private void r0(Canvas canvas) {
        int height;
        int i5;
        int i;
        int i3;
        int i4;
        float f2;
        float f;
        int i2;
        int obj9;
        if (Build.VERSION.SDK_INT >= 21) {
            this.T = canvas.saveLayer(0, 0, (float)width, (float)height, 0);
        } else {
            this.T = canvas.saveLayer(0, 0, (float)width2, (float)height2, 0, 31);
        }
    }

    private void u0() {
        this.R.setStyle(Paint.Style.FILL_AND_STROKE);
        this.R.setColor(-1);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.R.setXfermode(porterDuffXfermode);
    }

    private boolean v0(Drawable.Callback drawable$Callback) {
        return callback instanceof View;
    }

    @Override // f.c.a.e.d0.g
    public void draw(Canvas canvas) {
        p0(canvas);
        super.draw(canvas);
        o0(canvas);
    }

    @Override // f.c.a.e.d0.g
    boolean n0() {
        return empty ^= 1;
    }

    @Override // f.c.a.e.d0.g
    void q0() {
        final int i = 0;
        s0(i, i, i, i);
    }

    @Override // f.c.a.e.d0.g
    protected void r(Canvas canvas) {
        if (this.S.isEmpty()) {
            super.r(canvas);
        }
        Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmap);
        super.r(canvas2);
        canvas2.drawRect(this.S, this.R);
        int i2 = 0;
        canvas.drawBitmap(bitmap, i2, i2, 0);
    }

    @Override // f.c.a.e.d0.g
    void s0(float f, float f2, float f3, float f4) {
        int cmp;
        final RectF rectF = this.S;
        if (Float.compare(f, left) == 0 && Float.compare(f2, top) == 0 && Float.compare(f3, right) == 0) {
            if (Float.compare(f2, top) == 0) {
                if (Float.compare(f3, right) == 0) {
                    if (Float.compare(f4, bottom) != 0) {
                        rectF.set(f, f2, f3, f4);
                        invalidateSelf();
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }

    @Override // f.c.a.e.d0.g
    void t0(RectF rectF) {
        s0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
