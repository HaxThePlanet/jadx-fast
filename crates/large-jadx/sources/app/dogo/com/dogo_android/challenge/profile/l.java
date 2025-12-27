package app.dogo.com.dogo_android.d.d;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class l implements EventListener {

    public final /* synthetic */ p a;
    public /* synthetic */ l(p pVar) {
        super();
        this.a = pVar;
    }

    public final void onEvent(Object object, FirebaseFirestoreException exc) {
        ChallengeProfileDialogViewModel.j(this.a, object, exc);
    }
}
