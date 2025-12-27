package app.dogo.com.dogo_android.service;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a0 implements n {

    public final /* synthetic */ h2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public /* synthetic */ a0(h2 h2Var, String str, String str2) {
        super();
        this.a = h2Var;
        this.b = str;
        this.c = str2;
    }

    public final Object apply(Object object) {
        return AuthService.r(this.a, this.b, this.c, object);
    }
}
