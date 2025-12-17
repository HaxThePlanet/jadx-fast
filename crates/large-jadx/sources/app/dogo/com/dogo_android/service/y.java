package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthResult;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class y implements Callable {

    public final app.dogo.com.dogo_android.service.h2 a;
    public final AuthResult b;
    public y(app.dogo.com.dogo_android.service.h2 h2, AuthResult authResult2) {
        super();
        this.a = h2;
        this.b = authResult2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        final AuthResult authResult = this.b;
        h2.b0(this.a, authResult);
        return authResult;
    }
}
