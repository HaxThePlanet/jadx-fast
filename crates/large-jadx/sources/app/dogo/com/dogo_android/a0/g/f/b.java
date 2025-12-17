package app.dogo.com.dogo_android.a0.g.f;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* loaded from: classes.dex */
public final class b implements EventListener {

    public final app.dogo.com.dogo_android.a0.g.f.e0 a;
    public b(app.dogo.com.dogo_android.a0.g.f.e0 e0) {
        super();
        this.a = e0;
    }

    @Override // com.google.firebase.firestore.EventListener
    public final void onEvent(Object object, FirebaseFirestoreException firebaseFirestoreException2) {
        e0.L(this.a, (QuerySnapshot)object, firebaseFirestoreException2);
    }
}
