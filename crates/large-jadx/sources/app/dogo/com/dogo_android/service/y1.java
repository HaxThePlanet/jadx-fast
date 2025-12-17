package app.dogo.com.dogo_android.service;

import e.a.a.a.b.d.h;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class y1 implements n {

    public final app.dogo.com.dogo_android.service.u2 a;
    public final h b;
    public y1(app.dogo.com.dogo_android.service.u2 u2, h h2) {
        super();
        this.a = u2;
        this.b = h2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return u2.M(this.a, this.b, (List)object);
    }
}
