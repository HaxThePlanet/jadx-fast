package com.airbnb.lottie.t.c;

import android.graphics.PointF;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class m extends com.airbnb.lottie.t.c.a<PointF, PointF> {

    private final PointF i;
    private final PointF j;
    private final com.airbnb.lottie.t.c.a<Float, Float> k;
    private final com.airbnb.lottie.t.c.a<Float, Float> l;
    protected c<Float> m;
    protected c<Float> n;
    public m(com.airbnb.lottie.t.c.a<Float, Float> a, com.airbnb.lottie.t.c.a<Float, Float> a2) {
        super(Collections.emptyList());
        PointF pointF = new PointF();
        this.i = pointF;
        PointF pointF2 = new PointF();
        this.j = pointF2;
        this.k = a;
        this.l = a2;
        m(f());
    }

    @Override // com.airbnb.lottie.t.c.a
    public Object h() {
        return p();
    }

    @Override // com.airbnb.lottie.t.c.a
    Object i(a a, float f2) {
        return q(a, f2);
    }

    @Override // com.airbnb.lottie.t.c.a
    public void m(float f) {
        float floatValue;
        int obj3;
        this.k.m(f);
        this.l.m(f);
        this.i.set((Float)this.k.h().floatValue(), (Float)this.l.h().floatValue());
        obj3 = 0;
        while (obj3 < this.a.size()) {
            (a.b)this.a.get(obj3).a();
            obj3++;
        }
    }

    @Override // com.airbnb.lottie.t.c.a
    public PointF p() {
        return q(0, 0);
    }

    PointF q(a<PointF> a, float f2) {
        int i;
        float floatValue3;
        float floatValue2;
        Float floatValue;
        Object cVar;
        float f7;
        c cVar2;
        float f3;
        float f;
        Object obj;
        Object obj2;
        float f5;
        float f6;
        float f4;
        Object obj11;
        Object obj12;
        obj11 = this.k.b();
        if (this.m != null && obj11 != null) {
            obj11 = this.k.b();
            if (obj11 != null) {
                floatValue = obj11.h;
                f3 = obj11.g;
                if (floatValue == null) {
                    f = f3;
                } else {
                    f = floatValue;
                }
                obj11 = this.m.b(f3, f, obj11.b, obj11.c, f2, f2, this.k.d());
            } else {
                obj11 = i;
            }
        } else {
        }
        cVar = this.l.b();
        if (this.n != null && cVar != null) {
            cVar = this.l.b();
            if (cVar != null) {
                floatValue2 = cVar.h;
                f3 = cVar.g;
                if (floatValue2 == null) {
                    f = f3;
                } else {
                    f = floatValue2;
                }
                i = obj12;
            }
        }
        obj12 = 0;
        if (obj11 == null) {
            this.j.set(pointF2.x, obj12);
        } else {
            this.j.set(obj11.floatValue(), obj12);
        }
        if (i == 0) {
            obj11 = this.j;
            obj11.set(obj11.x, pointF.y);
        } else {
            obj11 = this.j;
            obj11.set(obj11.x, i.floatValue());
        }
        return this.j;
    }

    public void r(c<Float> c) {
        int i;
        final c cVar = this.m;
        if (cVar != null) {
            cVar.c(0);
        }
        this.m = c;
        if (c != null) {
            c.c(this);
        }
    }

    public void s(c<Float> c) {
        int i;
        final c cVar = this.n;
        if (cVar != null) {
            cVar.c(0);
        }
        this.n = c;
        if (c != null) {
            c.c(this);
        }
    }
}
