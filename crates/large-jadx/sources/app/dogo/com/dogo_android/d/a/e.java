package app.dogo.com.dogo_android.d.a;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* loaded from: classes.dex */
public final class e implements EventListener {

    public final app.dogo.com.dogo_android.d.a.m a;
    public e(app.dogo.com.dogo_android.d.a.m m) {
        super();
        this.a = m;
    }

    @Override // com.google.firebase.firestore.EventListener
    public final void onEvent(Object object, FirebaseFirestoreException firebaseFirestoreException2) {
        m.L(this.a, (QuerySnapshot)object, firebaseFirestoreException2);
    }
}
