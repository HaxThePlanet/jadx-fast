package app.dogo.com.dogo_android.service;

import i.b.c;
import i.b.e;

/* loaded from: classes.dex */
public final class f implements e {

    public final app.dogo.com.dogo_android.service.h2 a;
    public final String b;
    public f(app.dogo.com.dogo_android.service.h2 h2, String string2) {
        super();
        this.a = h2;
        this.b = string2;
    }

    @Override // i.b.e
    public final void a(c c) {
        h2.I(this.a, this.b, c);
    }
}
