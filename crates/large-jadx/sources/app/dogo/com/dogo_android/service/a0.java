package app.dogo.com.dogo_android.service;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class a0 implements n {

    public final app.dogo.com.dogo_android.service.h2 a;
    public final String b;
    public final String c;
    public a0(app.dogo.com.dogo_android.service.h2 h2, String string2, String string3) {
        super();
        this.a = h2;
        this.b = string2;
        this.c = string3;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return h2.d0(this.a, this.b, this.c, (AuthResult)object);
    }
}
