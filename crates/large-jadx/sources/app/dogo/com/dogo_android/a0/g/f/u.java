package app.dogo.com.dogo_android.a0.g.f;

import android.net.Uri;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class u implements c {

    public final app.dogo.com.dogo_android.a0.g.f.g0 a;
    public final Uri b;
    public final app.dogo.com.dogo_android.a0.g.f.h0 c;
    public u(app.dogo.com.dogo_android.a0.g.f.g0 g0, Uri uri2, app.dogo.com.dogo_android.a0.g.f.h0 h03) {
        super();
        this.a = g0;
        this.b = uri2;
        this.c = h03;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        final app.dogo.com.dogo_android.a0.g.f.h0 h0Var = this.c;
        this.a.w1(this.b, h0Var, j);
        return h0Var;
    }
}
