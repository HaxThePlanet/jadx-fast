package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.f;

/* loaded from: classes.dex */
public final class u0 implements f {

    public static final app.dogo.com.dogo_android.service.u0 a;
    static {
        u0 u0Var = new u0();
        u0.a = u0Var;
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        m2.S(exception);
    }
}
