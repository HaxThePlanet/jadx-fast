package app.dogo.com.dogo_android.j;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import m.a.c.l.a;

/* loaded from: classes.dex */
public final class b implements FirebaseAuth.AuthStateListener {

    public final a a;
    public b(a a) {
        super();
        this.a = a;
    }

    @Override // com.google.firebase.auth.FirebaseAuth$AuthStateListener
    public final void onAuthStateChanged(FirebaseAuth firebaseAuth) {
        d.a.t.h(this.a, firebaseAuth);
    }
}
