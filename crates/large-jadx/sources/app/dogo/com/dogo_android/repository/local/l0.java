package app.dogo.com.dogo_android.s.b;

import app.dogo.externalmodel.model.responses.UserApiModel;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class l0 implements n {

    public final /* synthetic */ p1 a;
    public final /* synthetic */ UserApiModel b;
    public /* synthetic */ l0(p1 p1Var, UserApiModel userApiModel) {
        super();
        this.a = p1Var;
        this.b = userApiModel;
    }

    public final Object apply(Object object) {
        return UserRepository.f0(this.a, this.b, object);
    }
}
