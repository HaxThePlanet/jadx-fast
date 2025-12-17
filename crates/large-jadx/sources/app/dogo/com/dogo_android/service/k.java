package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthCredential;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class k implements n {

    public final app.dogo.com.dogo_android.service.h2 a;
    public final AuthCredential b;
    public k(app.dogo.com.dogo_android.service.h2 h2, AuthCredential authCredential2) {
        super();
        this.a = h2;
        this.b = authCredential2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return h2.N(this.a, this.b, (Throwable)object);
    }
}
