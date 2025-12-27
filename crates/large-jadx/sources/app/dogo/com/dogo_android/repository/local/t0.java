package app.dogo.com.dogo_android.s.b;

import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.externalmodel.model.responses.UserApiModel;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class t0 implements n {

    public final /* synthetic */ UserApiModel a;
    public final /* synthetic */ RemindersModel b;
    public final /* synthetic */ p1 c;
    public /* synthetic */ t0(UserApiModel userApiModel, RemindersModel remindersModel, p1 p1Var) {
        super();
        this.a = userApiModel;
        this.b = remindersModel;
        this.c = p1Var;
    }

    public final Object apply(Object object) {
        return UserRepository.g0(this.a, this.b, this.c, object);
    }
}
