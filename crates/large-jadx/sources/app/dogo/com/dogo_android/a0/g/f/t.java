package app.dogo.com.dogo_android.a0.g.f;

import app.dogo.com.dogo_android.util.e0.a0;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class t implements e {

    public final a0 a;
    public t(a0 a0) {
        super();
        this.a = a0;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        g0.L1(this.a, j);
    }
}
