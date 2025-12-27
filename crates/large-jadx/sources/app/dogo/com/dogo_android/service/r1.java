package app.dogo.com.dogo_android.service;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class r1 implements n {

    public final /* synthetic */ u2 a;
    public final /* synthetic */ String b;
    public /* synthetic */ r1(u2 u2Var, String str) {
        super();
        this.a = u2Var;
        this.b = str;
    }

    public final Object apply(Object object) {
        return UserLocalCacheService.n(this.a, this.b, object);
    }
}
