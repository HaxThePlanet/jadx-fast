package app.dogo.com.dogo_android.service;

import i.b.c;
import i.b.e;

/* loaded from: classes.dex */
public final class d2 implements e {

    public final app.dogo.com.dogo_android.service.u2 a;
    public final String b;
    public final String c;
    public d2(app.dogo.com.dogo_android.service.u2 u2, String string2, String string3) {
        super();
        this.a = u2;
        this.b = string2;
        this.c = string3;
    }

    @Override // i.b.e
    public final void a(c c) {
        u2.R(this.a, this.b, this.c, c);
    }
}
