package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.f;
import i.b.c0;

/* loaded from: classes.dex */
public final class n0 implements f {

    public final c0 a;
    public n0(c0 c0) {
        super();
        this.a = c0;
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        l2.k(this.a, exception);
    }
}
