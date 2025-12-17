package app.dogo.com.dogo_android.j;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import m.a.c.l.a;

/* loaded from: classes.dex */
public final class c implements e {

    public final a a;
    public c(a a) {
        super();
        this.a = a;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        d.a.t.j(this.a, j);
    }
}
