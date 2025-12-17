package app.dogo.com.dogo_android.s.b;

import app.dogo.externalmodel.model.responses.UserApiModel;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class l0 implements n {

    public final app.dogo.com.dogo_android.s.b.p1 a;
    public final UserApiModel b;
    public l0(app.dogo.com.dogo_android.s.b.p1 p1, UserApiModel userApiModel2) {
        super();
        this.a = p1;
        this.b = userApiModel2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return p1.O(this.a, this.b, (RemindersModel)object);
    }
}
