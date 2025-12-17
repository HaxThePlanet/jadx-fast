package app.dogo.com.dogo_android.service;

import app.dogo.com.dogo_android.util.n0.u;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* loaded from: classes.dex */
public final class d1 implements EventListener {

    public final app.dogo.com.dogo_android.service.m2 a;
    public final String b;
    public final String c;
    public final String d;
    public final u e;
    public final String f;
    public final boolean g;
    public d1(app.dogo.com.dogo_android.service.m2 m2, String string2, String string3, String string4, u u5, String string6, boolean z7) {
        super();
        this.a = m2;
        this.b = string2;
        this.c = string3;
        this.d = string4;
        this.e = u5;
        this.f = string6;
        this.g = z7;
    }

    @Override // com.google.firebase.firestore.EventListener
    public final void onEvent(Object object, FirebaseFirestoreException firebaseFirestoreException2) {
        m2.Z(this.a, this.b, this.c, this.d, this.e, this.f, this.g, (QuerySnapshot)object, firebaseFirestoreException2);
    }
}
