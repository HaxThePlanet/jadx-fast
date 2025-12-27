package app.dogo.com.dogo_android.d.a;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class e implements EventListener {

    public final /* synthetic */ m a;
    public /* synthetic */ e(m mVar) {
        super();
        this.a = mVar;
    }

    public final void onEvent(Object object, FirebaseFirestoreException exc) {
        ChallengeFanListDialogViewModel.x(this.a, object, exc);
    }
}
