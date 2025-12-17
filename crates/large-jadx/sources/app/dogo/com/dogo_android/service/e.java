package app.dogo.com.dogo_android.service;

import i.b.c0;
import i.b.e0;

/* loaded from: classes.dex */
public final class e implements e0 {

    public final app.dogo.com.dogo_android.service.h2 a;
    public final String b;
    public final String c;
    public e(app.dogo.com.dogo_android.service.h2 h2, String string2, String string3) {
        super();
        this.a = h2;
        this.b = string2;
        this.c = string3;
    }

    @Override // i.b.e0
    public final void a(c0 c0) {
        h2.H(this.a, this.b, this.c, c0);
    }
}
