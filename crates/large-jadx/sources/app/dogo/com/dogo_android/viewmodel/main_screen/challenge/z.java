package app.dogo.com.dogo_android.a0.g.f;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class z implements EventListener {

    public final /* synthetic */ g0 a;
    public final /* synthetic */ String b;
    public /* synthetic */ z(g0 g0Var, String str) {
        super();
        this.a = g0Var;
        this.b = str;
    }

    public final void onEvent(Object object, FirebaseFirestoreException exc) {
        this.a.f1(this.b, object, exc);
    }
}
