package app.dogo.com.dogo_android.d.b;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* loaded from: classes.dex */
public final class j implements EventListener {

    public final app.dogo.com.dogo_android.d.b.x a;
    public j(app.dogo.com.dogo_android.d.b.x x) {
        super();
        this.a = x;
    }

    @Override // com.google.firebase.firestore.EventListener
    public final void onEvent(Object object, FirebaseFirestoreException firebaseFirestoreException2) {
        x.t0(this.a, (QuerySnapshot)object, firebaseFirestoreException2);
    }
}
