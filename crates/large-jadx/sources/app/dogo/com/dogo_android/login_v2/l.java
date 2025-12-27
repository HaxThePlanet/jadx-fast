package app.dogo.com.dogo_android.login_v2;

import com.google.firebase.auth.AuthResult;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class l implements n {

    public final /* synthetic */ b0 a;
    public final /* synthetic */ AuthResult b;
    public /* synthetic */ l(b0 b0Var, AuthResult authResult) {
        super();
        this.a = b0Var;
        this.b = authResult;
    }

    public final Object apply(Object object) {
        LoginViewModel.N(this.a, this.b, object);
        return this.b;
    }
}
