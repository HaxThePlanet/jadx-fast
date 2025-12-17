package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.f;

/* loaded from: classes.dex */
public final class b1 implements f {

    public static final app.dogo.com.dogo_android.service.b1 a;
    static {
        b1 b1Var = new b1();
        b1.a = b1Var;
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        m2.X(exception);
    }
}
