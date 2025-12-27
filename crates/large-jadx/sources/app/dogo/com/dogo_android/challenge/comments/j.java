package app.dogo.com.dogo_android.d.b;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class j implements EventListener {

    public final /* synthetic */ x a;
    public /* synthetic */ j(x xVar) {
        super();
        this.a = xVar;
    }

    public final void onEvent(Object object, FirebaseFirestoreException exc) {
        ChallengeCommentsViewModel.j0(this.a, object, exc);
    }
}
