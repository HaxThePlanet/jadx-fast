package app.dogo.com.dogo_android.a0.g.f;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* loaded from: classes.dex */
public final class z implements EventListener {

    public final app.dogo.com.dogo_android.a0.g.f.g0 a;
    public final String b;
    public z(app.dogo.com.dogo_android.a0.g.f.g0 g0, String string2) {
        super();
        this.a = g0;
        this.b = string2;
    }

    @Override // com.google.firebase.firestore.EventListener
    public final void onEvent(Object object, FirebaseFirestoreException firebaseFirestoreException2) {
        this.a.f1(this.b, (DocumentSnapshot)object, firebaseFirestoreException2);
    }
}
