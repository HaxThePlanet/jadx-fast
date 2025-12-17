package app.dogo.com.dogo_android.service;

import android.net.Uri;
import app.dogo.com.dogo_android.k.p;
import i.b.c0;
import i.b.e0;

/* loaded from: classes.dex */
public final class o0 implements e0 {

    public final app.dogo.com.dogo_android.service.l2 a;
    public final p b;
    public final Uri c;
    public o0(app.dogo.com.dogo_android.service.l2 l2, p p2, Uri uri3) {
        super();
        this.a = l2;
        this.b = p2;
        this.c = uri3;
    }

    @Override // i.b.e0
    public final void a(c0 c0) {
        l2.l(this.a, this.b, this.c, c0);
    }
}
