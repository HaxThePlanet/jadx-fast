package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import i.b.c0;

/* loaded from: classes.dex */
public final class j0 implements e {

    public final c0 a;
    public j0(c0 c0) {
        super();
        this.a = c0;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        k2.f(this.a, j);
    }
}
