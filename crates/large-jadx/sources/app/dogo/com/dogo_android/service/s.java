package app.dogo.com.dogo_android.service;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class s implements n {

    public final app.dogo.com.dogo_android.service.h2 a;
    public s(app.dogo.com.dogo_android.service.h2 h2) {
        super();
        this.a = h2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return h2.V(this.a, (AuthResult)object);
    }
}
