package com.airbnb.lottie.v.l;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.a;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.o;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.z.c;

/* loaded from: classes.dex */
public class g extends com.airbnb.lottie.v.l.a {

    private final Paint A;
    private final float[] B;
    private final Path C;
    private final com.airbnb.lottie.v.l.d D;
    private a<ColorFilter, ColorFilter> E;
    private final RectF z;
    g(f f, com.airbnb.lottie.v.l.d d2) {
        super(f, d2);
        RectF obj2 = new RectF();
        this.z = obj2;
        obj2 = new a();
        this.A = obj2;
        this.B = new float[8];
        Path path = new Path();
        this.C = path;
        this.D = d2;
        obj2.setAlpha(0);
        obj2.setStyle(Paint.Style.FILL);
        obj2.setColor(d2.m());
    }

    @Override // com.airbnb.lottie.v.l.a
    public void d(RectF rectF, Matrix matrix2, boolean z3) {
        super.d(rectF, matrix2, z3);
        final int i2 = 0;
        this.z.set(i2, i2, (float)obj5, (float)i);
        this.m.mapRect(this.z);
        rectF.set(this.z);
    }

    public <T> void g(T t, c<T> c2) {
        Object obj2;
        super.g(t, c2);
        if (t == k.E) {
            if (c2 == null) {
                this.E = 0;
            } else {
                obj2 = new p(c2);
                this.E = obj2;
            }
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    public void t(Canvas canvas, Matrix matrix2, int i3) {
        Object aVar;
        int intValue;
        int i8;
        int i5;
        int i2;
        int i4;
        int i9;
        int i;
        int i7;
        int i6;
        Path obj11;
        int obj12;
        int alpha = Color.alpha(this.D.m());
        if (alpha == 0) {
        }
        if (this.v.h() == null) {
            intValue = 100;
        } else {
            intValue = (Integer)this.v.h().h().intValue();
        }
        i5 = 1132396544;
        obj12 = (int)obj12;
        this.A.setAlpha(obj12);
        aVar = this.E;
        if (aVar != null) {
            this.A.setColorFilter((ColorFilter)aVar.h());
        }
        if (obj12 > 0) {
            obj12 = this.B;
            int i14 = 0;
            int i15 = 0;
            obj12[i14] = i15;
            i5 = 1;
            obj12[i5] = i15;
            i4 = 2;
            obj12[i4] = (float)i17;
            obj12 = this.B;
            i2 = 3;
            obj12[i2] = i15;
            i = 4;
            obj12[i] = (float)i18;
            i7 = 5;
            this.B[i7] = (float)i19;
            obj12 = this.B;
            i9 = 6;
            obj12[i9] = i15;
            i6 = 7;
            obj12[i6] = (float)i16;
            matrix2.mapPoints(this.B);
            this.C.reset();
            obj12 = this.B;
            this.C.moveTo(obj12[i14], obj12[i5]);
            obj12 = this.B;
            this.C.lineTo(obj12[i4], obj12[i2]);
            obj12 = this.B;
            this.C.lineTo(obj12[i], obj12[i7]);
            obj12 = this.B;
            this.C.lineTo(obj12[i9], obj12[i6]);
            obj12 = this.B;
            this.C.lineTo(obj12[i14], obj12[i5]);
            this.C.close();
            canvas.drawPath(this.C, this.A);
        }
    }
}
