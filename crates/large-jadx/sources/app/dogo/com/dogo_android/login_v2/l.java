package app.dogo.com.dogo_android.login_v2;

import com.google.firebase.auth.AuthResult;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class l implements n {

    public final app.dogo.com.dogo_android.login_v2.b0 a;
    public final AuthResult b;
    public l(app.dogo.com.dogo_android.login_v2.b0 b0, AuthResult authResult2) {
        super();
        this.a = b0;
        this.b = authResult2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        final AuthResult authResult = this.b;
        b0.x(this.a, authResult, (Boolean)object);
        return authResult;
    }
}
