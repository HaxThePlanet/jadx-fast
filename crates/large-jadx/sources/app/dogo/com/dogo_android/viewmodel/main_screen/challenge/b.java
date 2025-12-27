package app.dogo.com.dogo_android.a0.g.f;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements EventListener {

    public final /* synthetic */ e0 a;
    public /* synthetic */ b(e0 e0Var) {
        super();
        this.a = e0Var;
    }

    public final void onEvent(Object object, FirebaseFirestoreException exc) {
        ChallengeEntryCreationViewModel.x(this.a, object, exc);
    }
}
