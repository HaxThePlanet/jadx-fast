package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthResult;
import java.util.concurrent.Callable;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class y implements Callable {

    public final /* synthetic */ h2 a;
    public final /* synthetic */ AuthResult b;
    public /* synthetic */ y(h2 h2Var, AuthResult authResult) {
        super();
        this.a = h2Var;
        this.b = authResult;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        AuthService.g(this.a, this.b);
        return this.b;
    }
}
