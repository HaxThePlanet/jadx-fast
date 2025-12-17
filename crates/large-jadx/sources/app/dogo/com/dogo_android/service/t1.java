package app.dogo.com.dogo_android.service;

import app.dogo.externalmodel.model.responses.UserApiModel;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class t1 implements n {

    public final UserApiModel a;
    public final app.dogo.com.dogo_android.service.u2 b;
    public final String c;
    public t1(UserApiModel userApiModel, app.dogo.com.dogo_android.service.u2 u22, String string3) {
        super();
        this.a = userApiModel;
        this.b = u22;
        this.c = string3;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return u2.H(this.a, this.b, this.c, (String)object);
    }
}
