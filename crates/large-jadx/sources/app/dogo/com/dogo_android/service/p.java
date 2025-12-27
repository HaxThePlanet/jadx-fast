package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthCredential;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class p implements n {

    public final /* synthetic */ h2 a;
    public final /* synthetic */ AuthCredential b;
    public final /* synthetic */ String c;
    public /* synthetic */ p(h2 h2Var, AuthCredential authCredential, String str) {
        super();
        this.a = h2Var;
        this.b = authCredential;
        this.c = str;
    }

    public final Object apply(Object object) {
        return AuthService.q(this.a, this.b, this.c, object);
    }
}
