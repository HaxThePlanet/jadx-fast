package app.dogo.com.dogo_android.j;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import m.a.c.l.a;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements FirebaseAuth.AuthStateListener {

    public final /* synthetic */ a a;
    public /* synthetic */ b(a aVar) {
        super();
        this.a = aVar;
    }

    public final void onAuthStateChanged(FirebaseAuth firebaseAuth) {
        app.dogo.com.dogo_android.di.d.a.t.c(this.a, firebaseAuth);
    }
}
