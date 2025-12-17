package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthResult;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class c0 implements Callable {

    public final AuthResult a;
    public c0(AuthResult authResult) {
        super();
        this.a = authResult;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        final AuthResult authResult = this.a;
        h2.f0(authResult);
        return authResult;
    }
}
