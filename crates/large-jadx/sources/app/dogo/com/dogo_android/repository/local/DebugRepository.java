package app.dogo.com.dogo_android.s.b;

import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.m2;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.j0;

/* compiled from: DebugRepository.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u0015\u001a\u00020\nH\u0002J\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u000c\"\u0004\u0008\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u000c\"\u0004\u0008\u0014\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/repository/local/DebugRepository;", "", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lcom/google/firebase/firestore/FirebaseFirestore;Lapp/dogo/com/dogo_android/service/AuthService;)V", "forceUserDogPremium", "", "getForceUserDogPremium", "()Z", "setForceUserDogPremium", "(Z)V", "forceUserPremium", "getForceUserPremium", "setForceUserPremium", "forceUserResubscribe", "getForceUserResubscribe", "setForceUserResubscribe", "hasPermission", "isAmbassador", "makeUserAmbassador", "", "removeAmbassador", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e1, reason: from kotlin metadata */
public final class DebugRepository {

    /* renamed from: a, reason: from kotlin metadata */
    private final m2 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final FirebaseFirestore firestore;
    /* renamed from: c, reason: from kotlin metadata */
    private final h2 firestoreService;
    /* renamed from: d, reason: from kotlin metadata */
    private boolean forceUserDogPremium;
    /* renamed from: e, reason: from kotlin metadata */
    private boolean forceUserPremium;
    /* renamed from: f, reason: from kotlin metadata */
    private boolean forceUserResubscribe;
    public e1(m2 m2Var, FirebaseFirestore firebaseFirestore, h2 h2Var) {
        n.f(m2Var, "firestoreService");
        n.f(firebaseFirestore, "firestore");
        n.f(h2Var, "authService");
        super();
        this.authService = m2Var;
        this.firestore = firebaseFirestore;
        this.firestoreService = h2Var;
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean hasPermission() {
        return this.firestoreService.C();
    }

    public final boolean a() {
        return this.forceUserPremium;
    }

    public final boolean b() {
        return this.forceUserDogPremium;
    }

    public final boolean c() {
        return this.forceUserResubscribe;
    }

    public final boolean e() {
        if (!hasPermission()) {
            return false;
        }
        return this.authService.H().contains(this.firestoreService.v());
    }

    public final void f() {
        if (!hasPermission()) {
            return;
        }
        this.firestore.collection("ambassadors").document(this.firestoreService.v()).set(j0.h(), SetOptions.merge());
        this.authService.H().add(this.firestoreService.v());
    }

    public final void g() {
        if (!hasPermission()) {
            return;
        }
        this.firestore.collection("ambassadors").document(this.firestoreService.v()).delete();
        this.authService.H().remove(this.firestoreService.v());
    }

    public final void h(boolean z) {
        this.forceUserPremium = z;
    }

    public final void i(boolean z) {
        this.forceUserDogPremium = z;
    }

    public final void j(boolean z) {
        this.forceUserResubscribe = z;
    }
}
