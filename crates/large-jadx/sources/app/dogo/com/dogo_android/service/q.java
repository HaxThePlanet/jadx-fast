package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthResult;
import java.util.concurrent.Callable;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class q implements Callable {

    public final /* synthetic */ AuthResult a;
    public /* synthetic */ q(AuthResult authResult) {
        super();
        this.a = authResult;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        AuthService.t(this.a);
        return this.a;
    }
}
