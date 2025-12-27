package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthCredential;
import i.b.c0;
import i.b.e0;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class m implements e0 {

    public final /* synthetic */ h2 a;
    public final /* synthetic */ AuthCredential b;
    public /* synthetic */ m(h2 h2Var, AuthCredential authCredential) {
        super();
        this.a = h2Var;
        this.b = authCredential;
    }

    public final void a(c0 c0Var) {
        AuthService.q0(this.a, this.b, c0Var);
    }
}
