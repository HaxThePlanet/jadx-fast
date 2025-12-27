package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthResult;
import java.util.concurrent.Callable;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c0 implements Callable {

    public final /* synthetic */ AuthResult a;
    public /* synthetic */ c0(AuthResult authResult) {
        super();
        this.a = authResult;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        AuthService.o0(this.a);
        return this.a;
    }
}
