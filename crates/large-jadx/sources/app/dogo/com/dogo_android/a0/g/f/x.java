package app.dogo.com.dogo_android.a0.g.f;

import app.dogo.com.dogo_android.util.e0.a0;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class x implements e {

    public final app.dogo.com.dogo_android.a0.g.f.g0 a;
    public final a0 b;
    public x(app.dogo.com.dogo_android.a0.g.f.g0 g0, a0 a02) {
        super();
        this.a = g0;
        this.b = a02;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        this.a.l1(this.b, j);
    }
}
