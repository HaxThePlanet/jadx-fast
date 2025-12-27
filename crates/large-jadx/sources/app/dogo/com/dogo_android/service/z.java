package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthResult;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class z implements n {

    public final /* synthetic */ h2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ AuthResult c;
    public /* synthetic */ z(h2 h2Var, String str, AuthResult authResult) {
        super();
        this.a = h2Var;
        this.b = str;
        this.c = authResult;
    }

    public final Object apply(Object object) {
        return AuthService.s(this.a, this.b, this.c, object);
    }
}
