package app.dogo.com.dogo_android.d.c;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* loaded from: classes.dex */
public final class f implements EventListener {

    public final app.dogo.com.dogo_android.d.c.h a;
    public f(app.dogo.com.dogo_android.d.c.h h) {
        super();
        this.a = h;
    }

    @Override // com.google.firebase.firestore.EventListener
    public final void onEvent(Object object, FirebaseFirestoreException firebaseFirestoreException2) {
        h.u(this.a, (QuerySnapshot)object, firebaseFirestoreException2);
    }
}
