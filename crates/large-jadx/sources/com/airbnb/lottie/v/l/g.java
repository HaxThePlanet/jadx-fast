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
import com.airbnb.lottie.t.c.o;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.z.c;

/* compiled from: SolidLayer.java */
/* loaded from: classes.dex */
public class g extends a {

    private final Paint A = new a();
    private final float[] B;
    private final Path C = new Path();
    private final d D;
    private com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> E;
    private final RectF z = new RectF();
    g(f fVar, d dVar) {
        super(fVar, dVar);
        RectF rectF = new RectF();
        com.airbnb.lottie.t.a aVar = new a();
        this.B = new float[8];
        Path path = new Path();
        this.D = dVar;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(dVar.m());
    }

    @Override // com.airbnb.lottie.v.l.a
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        final float f2 = 0.0f;
        this.z.set(f2, f2, (float)this.D.o(), (float)this.D.n());
        this.m.mapRect(this.z);
        rectF.set(this.z);
    }

    @Override // com.airbnb.lottie.v.l.a
    public <T> void g(T t, c<T> cVar) {
        super.g(t, cVar);
        if (t == k.E && cVar == null) {
            this.E = null;
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    public void t(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.t.c.a aVar;
        int value = 100;
        float f = 1120403456;
        int alpha = Color.alpha(this.D.m());
        if (alpha == 0) {
            return;
        }
        if (this.v.h() == null) {
            value = 100;
        } else {
            value = (Integer)this.v.h().h().intValue();
        }
        float f2 = 255f;
        f = 100f;
        i8 = (int)(float)i / f2 * (float)alpha / f2 * (float)value / f * f2;
        this.A.setAlpha(i8);
        if (this.E != null) {
            this.A.setColorFilter((ColorFilter)this.E.h());
        }
        if (i8 > 0) {
            int i10 = 0;
            float f9 = 0.0f;
            this.B[i10] = f9;
            int i12 = 1;
            this.B[i12] = f9;
            int i2 = 2;
            this.B[i2] = (float)this.D.o();
            i = 3;
            this.B[i] = f9;
            int i5 = 4;
            this.B[i5] = (float)this.D.o();
            int i6 = 5;
            this.B[i6] = (float)this.D.n();
            int i4 = 6;
            this.B[i4] = f9;
            int i7 = 7;
            this.B[i7] = (float)this.D.n();
            matrix.mapPoints(this.B);
            this.C.reset();
            this.C.moveTo(fArr6[i10], fArr6[i12]);
            this.C.lineTo(fArr7[i2], fArr7[i]);
            this.C.lineTo(fArr8[i5], fArr8[i6]);
            this.C.lineTo(fArr9[i4], fArr9[i7]);
            this.C.lineTo(fArr10[i10], fArr10[i12]);
            this.C.close();
            canvas.drawPath(this.C, this.A);
        }
    }
}
