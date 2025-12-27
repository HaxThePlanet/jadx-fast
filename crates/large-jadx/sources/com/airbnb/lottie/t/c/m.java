package com.airbnb.lottie.t.c;

import android.graphics.PointF;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.Collections;
import java.util.List;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class m extends a<PointF, PointF> {

    private final PointF i = new PointF();
    private final PointF j = new PointF();
    private final a<Float, Float> k;
    private final a<Float, Float> l;
    protected c<Float> m;
    protected c<Float> n;
    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        PointF pointF = new PointF();
        PointF pointF2 = new PointF();
        this.k = aVar;
        this.l = aVar2;
        m(f());
    }

    @Override // com.airbnb.lottie.t.c.a
    public void m(float f) {
        int i = 0;
        this.k.m(f);
        this.l.m(f);
        this.i.set((Float)this.k.h().floatValue(), (Float)this.l.h().floatValue());
        i = 0;
        while (this.i < this.a.size()) {
            (a.b)this.a.get(i).a();
            i = i + 1;
        }
    }

    @Override // com.airbnb.lottie.t.c.a
    public PointF p() {
        return q(null, 0.0f);
    }

    @Override // com.airbnb.lottie.t.c.a
    PointF q(a<PointF> aVar, float f) {
        int i = 0;
        Float f2;
        c cVar2;
        float value2;
        Object obj;
        Object obj2;
        float f23;
        float f4;
        i = 0;
        if (this.m != null) {
            a aVar7 = this.k.b();
            if (aVar7 != null) {
                value2 = aVar7.h == null ? value2 : value2;
                Object obj3 = this.m.b(aVar7.g, value2, aVar7.b, aVar7.c, f, f, this.k.d());
            } else {
            }
        }
        if (this.n != null) {
            a aVar5 = this.l.b();
            if (aVar5 != null) {
                value2 = aVar5.h == null ? value2 : value2;
            }
        }
        float f7 = 0.0f;
        if (this.m == 0) {
            this.j.set(this.i.x, 0.0f);
        } else {
            this.j.set(i.floatValue(), 0.0f);
        }
        if (this.l == 0) {
            this.j.set(pointF2.x, this.i.y);
        } else {
            this.j.set(pointF2.x, i.floatValue());
        }
        return this.j;
    }

    @Override // com.airbnb.lottie.t.c.a
    public void r(c<Float> cVar) {
        if (this.m != null) {
            com.airbnb.lottie.t.c.a aVar = null;
            this.m.c(aVar);
        }
        this.m = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    @Override // com.airbnb.lottie.t.c.a
    public void s(c<Float> cVar) {
        if (this.n != null) {
            com.airbnb.lottie.t.c.a aVar = null;
            this.n.c(aVar);
        }
        this.n = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
