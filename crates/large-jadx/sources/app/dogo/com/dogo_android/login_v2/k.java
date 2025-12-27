package app.dogo.com.dogo_android.login_v2;

import com.google.firebase.auth.AuthResult;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class k implements n {

    public final /* synthetic */ AuthResult a;
    public final /* synthetic */ b0 b;
    public /* synthetic */ k(AuthResult authResult, b0 b0Var) {
        super();
        this.a = authResult;
        this.b = b0Var;
    }

    public final Object apply(Object object) {
        return LoginViewModel.P(this.a, this.b, object);
    }
}
