package app.dogo.com.dogo_android.s.b;

import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.externalmodel.model.responses.UserApiModel;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class t0 implements n {

    public final UserApiModel a;
    public final RemindersModel b;
    public final app.dogo.com.dogo_android.s.b.p1 c;
    public t0(UserApiModel userApiModel, RemindersModel remindersModel2, app.dogo.com.dogo_android.s.b.p1 p13) {
        super();
        this.a = userApiModel;
        this.b = remindersModel2;
        this.c = p13;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return p1.W(this.a, this.b, this.c, (List)object);
    }
}
