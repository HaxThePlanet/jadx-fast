package com.airbnb.lottie.t.c;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.a;

/* compiled from: PathKeyframe.java */
/* loaded from: classes.dex */
public class h extends a<PointF> {

    private Path q;
    private final a<PointF> r;
    public h(d dVar, a<PointF> aVar) {
        super(dVar, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g, aVar.h);
        this.r = aVar;
        i();
    }

    @Override // com.airbnb.lottie.z.a
    public void i() {
        int i = 1;
        Object obj2;
        float f;
        if (this.c != null && this.b != null) {
            int r0 = obj2.equals((PointF)obj.x, obj.y) ? 1 : 0;
        }
        if (this.b != null && this.c != null && obj.y == 0) {
            this.q = h.d(obj3, obj4, aVar.o, aVar.p);
        }
    }

    @Override // com.airbnb.lottie.z.a
    Path j() {
        return this.q;
    }
}
