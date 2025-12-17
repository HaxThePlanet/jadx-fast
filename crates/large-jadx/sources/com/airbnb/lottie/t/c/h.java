package com.airbnb.lottie.t.c;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.a;

/* loaded from: classes.dex */
public class h extends a<PointF> {

    private Path q;
    private final a<PointF> r;
    public h(d d, a<PointF> a2) {
        super(d, a2.b, a2.c, a2.d, a2.e, a2.f, a2.g, a2.h);
        this.r = a2;
        i();
    }

    @Override // com.airbnb.lottie.z.a
    public void i() {
        int i;
        Object equals;
        Object obj;
        float f;
        PointF pointF;
        equals = this.c;
        obj = this.b;
        if ((PointF)equals != null && obj != null && (PointF)obj.equals(obj3.x, equals.y)) {
            obj = this.b;
            if (obj != null) {
                i = (PointF)obj.equals(obj3.x, equals.y) ? 1 : 0;
            } else {
            }
        } else {
        }
        Object obj2 = this.b;
        f = this.c;
        if (obj2 != null && f != null && i == 0) {
            f = this.c;
            if (f != null) {
                if (i == 0) {
                    a aVar = this.r;
                    this.q = h.d((PointF)obj2, (PointF)f, aVar.o, aVar.p);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.z.a
    Path j() {
        return this.q;
    }
}
