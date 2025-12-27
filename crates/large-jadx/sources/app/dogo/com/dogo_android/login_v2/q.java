package app.dogo.com.dogo_android.login_v2;

import com.google.firebase.auth.AuthResult;
import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class q implements n {

    public final /* synthetic */ AuthResult a;
    public final /* synthetic */ b0 b;
    public /* synthetic */ q(AuthResult authResult, b0 b0Var) {
        super();
        this.a = authResult;
        this.b = b0Var;
    }

    public final Object apply(Object object) {
        return LoginViewModel.O(this.a, this.b, object);
    }
}
