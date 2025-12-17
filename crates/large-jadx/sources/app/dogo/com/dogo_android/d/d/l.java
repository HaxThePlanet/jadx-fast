package app.dogo.com.dogo_android.d.d;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* loaded from: classes.dex */
public final class l implements EventListener {

    public final app.dogo.com.dogo_android.d.d.p a;
    public l(app.dogo.com.dogo_android.d.d.p p) {
        super();
        this.a = p;
    }

    @Override // com.google.firebase.firestore.EventListener
    public final void onEvent(Object object, FirebaseFirestoreException firebaseFirestoreException2) {
        p.N(this.a, (QuerySnapshot)object, firebaseFirestoreException2);
    }
}
