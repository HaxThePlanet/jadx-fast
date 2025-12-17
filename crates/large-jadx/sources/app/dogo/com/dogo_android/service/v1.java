package app.dogo.com.dogo_android.service;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class v1 implements n {

    public final app.dogo.com.dogo_android.service.u2 a;
    public final String b;
    public v1(app.dogo.com.dogo_android.service.u2 u2, String string2) {
        super();
        this.a = u2;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return u2.J(this.a, this.b, (w)object);
    }
}
