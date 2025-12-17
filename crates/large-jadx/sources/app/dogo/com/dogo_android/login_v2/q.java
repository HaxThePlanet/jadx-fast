package app.dogo.com.dogo_android.login_v2;

import com.google.firebase.auth.AuthResult;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class q implements n {

    public final AuthResult a;
    public final app.dogo.com.dogo_android.login_v2.b0 b;
    public q(AuthResult authResult, app.dogo.com.dogo_android.login_v2.b0 b02) {
        super();
        this.a = authResult;
        this.b = b02;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return b0.C(this.a, this.b, (AuthResult)object);
    }
}
