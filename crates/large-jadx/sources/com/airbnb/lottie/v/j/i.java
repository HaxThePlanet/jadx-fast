package com.airbnb.lottie.v.j;

import android.graphics.PointF;
import com.airbnb.lottie.t.c.m;
import java.util.List;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes.dex */
public class i implements m<PointF, PointF> {

    private final b a;
    private final b b;
    public i(b bVar, b bVar2) {
        super();
        this.a = bVar;
        this.b = bVar2;
    }

    public boolean i() {
        boolean z2 = false;
        if (this.a.i()) {
            int r0 = this.b.i() ? 1 : 0;
        }
        return (this.b.i() ? 1 : 0);
    }

    public com.airbnb.lottie.t.c.a<PointF, PointF> j() {
        return new m(this.a.j(), this.b.j());
    }

    public List<com.airbnb.lottie.z.a<PointF>> q() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }
}
