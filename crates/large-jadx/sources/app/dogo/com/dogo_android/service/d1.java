package app.dogo.com.dogo_android.service;

import app.dogo.com.dogo_android.util.n0.u;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d1 implements EventListener {

    public final /* synthetic */ m2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ u e;
    public final /* synthetic */ String f;
    public final /* synthetic */ boolean g;
    public /* synthetic */ d1(m2 m2Var, String str, String str2, String str3, u uVar, String str4, boolean z) {
        super();
        this.a = m2Var;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = uVar;
        this.f = str4;
        this.g = z;
    }

    public final void onEvent(Object object, FirebaseFirestoreException exc) {
        FirestoreService.e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, (QuerySnapshot)object, exc);
    }
}
