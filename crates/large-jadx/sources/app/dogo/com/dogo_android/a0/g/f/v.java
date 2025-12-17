package app.dogo.com.dogo_android.a0.g.f;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* loaded from: classes.dex */
public final class v implements EventListener {

    public final app.dogo.com.dogo_android.a0.g.f.g0 a;
    public v(app.dogo.com.dogo_android.a0.g.f.g0 g0) {
        super();
        this.a = g0;
    }

    @Override // com.google.firebase.firestore.EventListener
    public final void onEvent(Object object, FirebaseFirestoreException firebaseFirestoreException2) {
        this.a.j1((QuerySnapshot)object, firebaseFirestoreException2);
    }
}
