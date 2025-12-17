package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import i.b.c0;

/* loaded from: classes.dex */
public final class r implements e {

    public final c0 a;
    public r(c0 c0) {
        super();
        this.a = c0;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        h2.U(this.a, j);
    }
}
