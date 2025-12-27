package app.dogo.com.dogo_android.service;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class u1 implements n {

    public final /* synthetic */ u2 a;
    public final /* synthetic */ String b;
    public /* synthetic */ u1(u2 u2Var, String str) {
        super();
        this.a = u2Var;
        this.b = str;
    }

    public final Object apply(Object object) {
        return UserLocalCacheService.d(this.a, this.b, object);
    }
}
