package app.dogo.com.dogo_android.service;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class u implements n {

    public final app.dogo.com.dogo_android.service.h2 a;
    public final boolean b;
    public u(app.dogo.com.dogo_android.service.h2 h2, boolean z2) {
        super();
        this.a = h2;
        this.b = z2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return h2.X(this.a, this.b, (w)object);
    }
}
