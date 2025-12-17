package app.dogo.com.dogo_android.s.b;

import app.dogo.externalmodel.model.responses.UserApiModel;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class w0 implements Callable {

    public final UserApiModel a;
    public w0(UserApiModel userApiModel) {
        super();
        this.a = userApiModel;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        final UserApiModel userApiModel = this.a;
        p1.Z(userApiModel);
        return userApiModel;
    }
}
