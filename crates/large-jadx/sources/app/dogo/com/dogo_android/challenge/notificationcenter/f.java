package app.dogo.com.dogo_android.d.c;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements EventListener {

    public final /* synthetic */ h a;
    public /* synthetic */ f(h hVar) {
        super();
        this.a = hVar;
    }

    public final void onEvent(Object object, FirebaseFirestoreException exc) {
        ChallengeNotificationCenterViewModel.h(this.a, object, exc);
    }
}
