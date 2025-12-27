package app.dogo.com.dogo_android.s.b;

import app.dogo.externalmodel.model.responses.UserApiModel;
import java.util.concurrent.Callable;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class w0 implements Callable {

    public final /* synthetic */ UserApiModel a;
    public /* synthetic */ w0(UserApiModel userApiModel) {
        super();
        this.a = userApiModel;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        UserRepository.addParticipatingChallenge(this.a);
        return this.a;
    }
}
