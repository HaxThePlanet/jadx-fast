package app.dogo.com.dogo_android.a0.g.f;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class q implements EventListener {

    public final /* synthetic */ g0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public /* synthetic */ q(g0 g0Var, String str, String str2) {
        super();
        this.a = g0Var;
        this.b = str;
        this.c = str2;
    }

    public final void onEvent(Object object, FirebaseFirestoreException exc) {
        this.a.G1(this.b, this.c, object, exc);
    }
}
