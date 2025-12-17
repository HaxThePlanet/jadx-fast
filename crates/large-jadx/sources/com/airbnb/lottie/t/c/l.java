package com.airbnb.lottie.t.c;

import android.graphics.Path;
import com.airbnb.lottie.v.k.l;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.a;
import java.util.List;

/* loaded from: classes.dex */
public class l extends com.airbnb.lottie.t.c.a<l, Path> {

    private final l i;
    private final Path j;
    public l(List<a<l>> list) {
        super(list);
        l obj1 = new l();
        this.i = obj1;
        obj1 = new Path();
        this.j = obj1;
    }

    @Override // com.airbnb.lottie.t.c.a
    public Object i(a a, float f2) {
        return p(a, f2);
    }

    public Path p(a<l> a, float f2) {
        this.i.c((l)a.b, (l)a.c, f2);
        g.i(this.i, this.j);
        return this.j;
    }
}
