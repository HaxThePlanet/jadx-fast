package app.dogo.com.dogo_android.a0.g.f;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* loaded from: classes.dex */
public final class q implements EventListener {

    public final app.dogo.com.dogo_android.a0.g.f.g0 a;
    public final String b;
    public final String c;
    public q(app.dogo.com.dogo_android.a0.g.f.g0 g0, String string2, String string3) {
        super();
        this.a = g0;
        this.b = string2;
        this.c = string3;
    }

    @Override // com.google.firebase.firestore.EventListener
    public final void onEvent(Object object, FirebaseFirestoreException firebaseFirestoreException2) {
        this.a.G1(this.b, this.c, (QuerySnapshot)object, firebaseFirestoreException2);
    }
}
