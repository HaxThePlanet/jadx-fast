package app.dogo.com.dogo_android.service;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class s1 implements n {

    public final app.dogo.com.dogo_android.service.u2 a;
    public s1(app.dogo.com.dogo_android.service.u2 u2) {
        super();
        this.a = u2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return u2.G(this.a, (UserApiModel)object);
    }
}
