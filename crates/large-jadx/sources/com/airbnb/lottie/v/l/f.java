package com.airbnb.lottie.v.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.d;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.k.n;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class f extends com.airbnb.lottie.v.l.a {

    private final d z;
    f(f f, com.airbnb.lottie.v.l.d d2) {
        super(f, d2);
        n nVar = new n("__container", d2.l(), 0);
        d obj5 = new d(f, this, nVar);
        this.z = obj5;
        obj5.b(Collections.emptyList(), Collections.emptyList());
    }

    protected void D(e e, int i2, List<e> list3, e e4) {
        this.z.c(e, i2, list3, e4);
    }

    @Override // com.airbnb.lottie.v.l.a
    public void d(RectF rectF, Matrix matrix2, boolean z3) {
        super.d(rectF, matrix2, z3);
        this.z.d(rectF, this.m, z3);
    }

    @Override // com.airbnb.lottie.v.l.a
    void t(Canvas canvas, Matrix matrix2, int i3) {
        this.z.f(canvas, matrix2, i3);
    }
}
