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

/* compiled from: ShapeLayer.java */
/* loaded from: classes.dex */
public class f extends a {

    private final d z = new d();
    f(f fVar, d dVar) {
        super(fVar, dVar);
        new d(fVar, this, new n("__container", dVar.l(), false)).b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.v.l.a
    protected void D(e eVar, int i, List<e> list, e eVar2) {
        this.z.c(eVar, i, list, eVar2);
    }

    @Override // com.airbnb.lottie.v.l.a
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        this.z.d(rectF, this.m, z);
    }

    @Override // com.airbnb.lottie.v.l.a
    void t(Canvas canvas, Matrix matrix, int i) {
        this.z.f(canvas, matrix, i);
    }
}
