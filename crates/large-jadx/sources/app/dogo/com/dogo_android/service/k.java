package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthCredential;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class k implements n {

    public final /* synthetic */ h2 a;
    public final /* synthetic */ AuthCredential b;
    public /* synthetic */ k(h2 h2Var, AuthCredential authCredential) {
        super();
        this.a = h2Var;
        this.b = authCredential;
    }

    public final Object apply(Object object) {
        return AuthService.o(this.a, this.b, object);
    }
}
