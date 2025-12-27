package com.airbnb.lottie.t.c;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.z.a;
import com.airbnb.lottie.z.c;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class i extends f<PointF> {

    private final PointF i = new PointF();
    private final float[] j;
    private final PathMeasure k = new PathMeasure();
    private h l;
    public i(List<? extends a<PointF>> list) {
        super(list);
        PointF pointF = new PointF();
        this.j = new float[2];
        PathMeasure pathMeasure = new PathMeasure();
    }

    @Override // com.airbnb.lottie.t.c.f
    public PointF p(a<PointF> aVar, float f) {
        Object aVar2 = aVar;
        android.graphics.Path path = aVar2.j();
        if (path == null) {
            return (PointF)aVar.b;
        }
        if (this.e != null) {
            Object obj3 = this.e.b(aVar2.g, aVar2.h.floatValue(), aVar2.b, aVar2.c, e(), f, f());
            if (obj3 != null) {
                return obj3;
            }
        }
        boolean z = false;
        if (this.l != aVar2) {
            this.k.setPath(path, z);
            this.l = aVar2;
        }
        this.k.getPosTan(f * this.k.getLength(), this.j, null);
        this.i.set(fArr2[z], fArr2[1]);
        return this.i;
    }
}
