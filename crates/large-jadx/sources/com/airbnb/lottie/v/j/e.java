package com.airbnb.lottie.v.j;

import android.graphics.PointF;
import com.airbnb.lottie.t.c.i;
import com.airbnb.lottie.t.c.j;
import java.util.List;

/* compiled from: AnimatablePathValue.java */
/* loaded from: classes.dex */
public class e implements m<PointF, PointF> {

    private final List<com.airbnb.lottie.z.a<PointF>> a;
    public e(List<com.airbnb.lottie.z.a<PointF>> list) {
        super();
        this.a = list;
    }

    public boolean i() {
        boolean z2 = false;
        final int i = 1;
        if (this.a.size() == i) {
            if ((a)this.a.get(0).h()) {
            }
        }
        return z2;
    }

    public com.airbnb.lottie.t.c.a<PointF, PointF> j() {
        if ((a)this.a.get(0).h()) {
            return new j(this.a);
        }
        return new i(this.a);
    }

    public List<com.airbnb.lottie.z.a<PointF>> q() {
        return this.a;
    }
}
