package com.airbnb.lottie.v.l;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.a;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.c;

/* loaded from: classes.dex */
public class c extends com.airbnb.lottie.v.l.a {

    private final Rect A;
    private final Rect B;
    private a<ColorFilter, ColorFilter> C;
    private final Paint z;
    c(f f, com.airbnb.lottie.v.l.d d2) {
        super(f, d2);
        a obj1 = new a(3);
        this.z = obj1;
        obj1 = new Rect();
        this.A = obj1;
        obj1 = new Rect();
        this.B = obj1;
    }

    private Bitmap K() {
        return this.n.s(this.o.k());
    }

    @Override // com.airbnb.lottie.v.l.a
    public void d(RectF rectF, Matrix matrix2, boolean z3) {
        int i;
        Object obj3;
        boolean obj4;
        super.d(rectF, matrix2, z3);
        obj3 = K();
        if (obj3 != null) {
            i = 0;
            rectF.set(i, i, obj4 *= f, obj3 *= f2);
            this.m.mapRect(rectF);
        }
    }

    public <T> void g(T t, c<T> c2) {
        Object obj2;
        super.g(t, c2);
        if (t == k.E) {
            if (c2 == null) {
                this.C = 0;
            } else {
                obj2 = new p(c2);
                this.C = obj2;
            }
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    public void t(Canvas canvas, Matrix matrix2, int i3) {
        Paint recycled;
        Paint paint;
        int i2;
        int i;
        Object obj6;
        Object obj7;
        final Bitmap bitmap = K();
        if (bitmap != null) {
            if (bitmap.isRecycled()) {
            } else {
                float f = h.e();
                this.z.setAlpha(i3);
                obj7 = this.C;
                if (obj7 != null) {
                    this.z.setColorFilter((ColorFilter)obj7.h());
                }
                canvas.save();
                canvas.concat(matrix2);
                i = 0;
                this.A.set(i, i, bitmap.getWidth(), bitmap.getHeight());
                this.B.set(i, i, (int)obj7, (int)i2);
                canvas.drawBitmap(bitmap, this.A, this.B, this.z);
                canvas.restore();
            }
        }
    }
}
