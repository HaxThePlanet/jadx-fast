package com.airbnb.lottie.t.c;

import android.graphics.Path;
import com.airbnb.lottie.v.k.l;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.a;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation.java */
/* loaded from: classes.dex */
public class l extends a<l, Path> {

    private final l i = new l();
    private final Path j = new Path();
    public l(List<a<l>> list) {
        super(list);
        l lVar = new l();
        Path path = new Path();
    }

    @Override // com.airbnb.lottie.t.c.a
    public Path p(a<l> aVar, float f) {
        this.i.c((l)aVar.b, (l)aVar.c, f);
        g.i(this.i, this.j);
        return this.j;
    }
}
