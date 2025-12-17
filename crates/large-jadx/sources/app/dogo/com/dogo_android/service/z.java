package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthResult;
import i.b.l0.n;

/* loaded from: classes.dex */
public final class z implements n {

    public final app.dogo.com.dogo_android.service.h2 a;
    public final String b;
    public final AuthResult c;
    public z(app.dogo.com.dogo_android.service.h2 h2, String string2, AuthResult authResult3) {
        super();
        this.a = h2;
        this.b = string2;
        this.c = authResult3;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return h2.c0(this.a, this.b, this.c, (UserApiModel)object);
    }
}
