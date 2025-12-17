package app.dogo.com.dogo_android.service;

import com.google.firebase.auth.AuthCredential;
import i.b.c0;
import i.b.e0;

/* loaded from: classes.dex */
public final class l implements e0 {

    public final app.dogo.com.dogo_android.service.h2 a;
    public final AuthCredential b;
    public l(app.dogo.com.dogo_android.service.h2 h2, AuthCredential authCredential2) {
        super();
        this.a = h2;
        this.b = authCredential2;
    }

    @Override // i.b.e0
    public final void a(c0 c0) {
        h2.O(this.a, this.b, c0);
    }
}
