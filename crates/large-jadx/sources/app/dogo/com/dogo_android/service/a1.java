package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class a1 implements e {

    public final app.dogo.com.dogo_android.service.m2.b a;
    public final g b;
    public a1(app.dogo.com.dogo_android.service.m2.b m2$b, g g2) {
        super();
        this.a = b;
        this.b = g2;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        m2.b.g(this.a, this.b, j);
    }
}
