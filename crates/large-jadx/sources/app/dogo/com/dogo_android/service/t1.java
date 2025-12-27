package app.dogo.com.dogo_android.service;

import app.dogo.externalmodel.model.responses.UserApiModel;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class t1 implements n {

    public final /* synthetic */ UserApiModel a;
    public final /* synthetic */ u2 b;
    public final /* synthetic */ String c;
    public /* synthetic */ t1(UserApiModel userApiModel, u2 u2Var, String str) {
        super();
        this.a = userApiModel;
        this.b = u2Var;
        this.c = str;
    }

    public final Object apply(Object object) {
        return UserLocalCacheService.d0(this.a, this.b, this.c, object);
    }
}
