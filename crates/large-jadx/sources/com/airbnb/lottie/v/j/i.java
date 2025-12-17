package com.airbnb.lottie.v.j;

import android.graphics.PointF;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.m;
import com.airbnb.lottie.z.a;
import java.util.List;

/* loaded from: classes.dex */
public class i implements com.airbnb.lottie.v.j.m<PointF, PointF> {

    private final com.airbnb.lottie.v.j.b a;
    private final com.airbnb.lottie.v.j.b b;
    public i(com.airbnb.lottie.v.j.b b, com.airbnb.lottie.v.j.b b2) {
        super();
        this.a = b;
        this.b = b2;
    }

    @Override // com.airbnb.lottie.v.j.m
    public boolean i() {
        boolean z;
        int i;
        if (this.a.i() && this.b.i()) {
            i = this.b.i() ? 1 : 0;
        } else {
        }
        return i;
    }

    public a<PointF, PointF> j() {
        m mVar = new m(this.a.j(), this.b.j());
        return mVar;
    }

    public List<a<PointF>> q() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
        throw unsupportedOperationException;
    }
}
