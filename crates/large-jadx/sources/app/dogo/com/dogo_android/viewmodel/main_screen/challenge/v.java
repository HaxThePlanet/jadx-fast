package app.dogo.com.dogo_android.a0.g.f;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class v implements EventListener {

    public final /* synthetic */ g0 a;
    public /* synthetic */ v(g0 g0Var) {
        super();
        this.a = g0Var;
    }

    public final void onEvent(Object object, FirebaseFirestoreException exc) {
        this.a.j1(object, exc);
    }
}
