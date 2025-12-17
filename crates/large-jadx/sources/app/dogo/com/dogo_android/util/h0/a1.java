package app.dogo.com.dogo_android.util.h0;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import i.b.c0;
import i.b.e0;

/* loaded from: classes.dex */
public final class a1 implements e0 {

    public final FirebaseUser a;
    public final AuthCredential b;
    public a1(FirebaseUser firebaseUser, AuthCredential authCredential2) {
        super();
        this.a = firebaseUser;
        this.b = authCredential2;
    }

    @Override // i.b.e0
    public final void a(c0 c0) {
        j1.g0(this.a, this.b, c0);
    }
}
