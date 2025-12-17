package app.dogo.com.dogo_android.service;

import android.net.Uri;
import i.b.c0;
import i.b.e0;

/* loaded from: classes.dex */
public final class k0 implements e0 {

    public final app.dogo.com.dogo_android.service.k2 a;
    public final Uri b;
    public final String c;
    public final String d;
    public final String e;
    public k0(app.dogo.com.dogo_android.service.k2 k2, Uri uri2, String string3, String string4, String string5) {
        super();
        this.a = k2;
        this.b = uri2;
        this.c = string3;
        this.d = string4;
        this.e = string5;
    }

    @Override // i.b.e0
    public final void a(c0 c0) {
        k2.g(this.a, this.b, this.c, this.d, this.e, c0);
    }
}
