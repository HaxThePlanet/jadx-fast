package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthResult;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class d implements Callable {

    public final AuthResult a;
    public d(AuthResult authResult) {
        super();
        this.a = authResult;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        final AuthResult authResult = this.a;
        h2.G(authResult);
        return authResult;
    }
}
