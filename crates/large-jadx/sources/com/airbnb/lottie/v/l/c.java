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
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.c;

/* compiled from: ImageLayer.java */
/* loaded from: classes.dex */
public class c extends a {

    private final Rect A = new Rect();
    private final Rect B = new Rect();
    private com.airbnb.lottie.t.c.a<ColorFilter, ColorFilter> C;
    private final Paint z = new a(3);
    c(f fVar, d dVar) {
        super(fVar, dVar);
        com.airbnb.lottie.t.a aVar = new a(3);
        Rect rect = new Rect();
        Rect rect2 = new Rect();
    }

    private Bitmap K() {
        return this.n.s(this.o.k());
    }

    @Override // com.airbnb.lottie.v.l.a
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        Bitmap bitmap = K();
        if (bitmap != null) {
            f2 = (float)bitmap.getWidth() * h.e();
            float f = 0.0f;
            rectF.set(f, f, f2, (float)bitmap.getHeight() * h.e());
            this.m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    public <T> void g(T t, c<T> cVar) {
        super.g(t, cVar);
        if (t == k.E && cVar == null) {
            this.C = null;
        }
    }

    @Override // com.airbnb.lottie.v.l.a
    public void t(Canvas canvas, Matrix matrix, int i) {
        final Bitmap bitmap = K();
    }
}
