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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u0015\u001a\u00020\nH\u0002J\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u000c\"\u0004\u0008\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u000c\"\u0004\u0008\u0014\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/repository/local/DebugRepository;", "", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lcom/google/firebase/firestore/FirebaseFirestore;Lapp/dogo/com/dogo_android/service/AuthService;)V", "forceUserDogPremium", "", "getForceUserDogPremium", "()Z", "setForceUserDogPremium", "(Z)V", "forceUserPremium", "getForceUserPremium", "setForceUserPremium", "forceUserResubscribe", "getForceUserResubscribe", "setForceUserResubscribe", "hasPermission", "isAmbassador", "makeUserAmbassador", "", "removeAmbassador", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e1 {

    private final m2 a;
    private final FirebaseFirestore b;
    private final h2 c;
    private boolean d;
    private boolean e;
    private boolean f;
    public e1(m2 m2, FirebaseFirestore firebaseFirestore2, h2 h23) {
        n.f(m2, "firestoreService");
        n.f(firebaseFirestore2, "firestore");
        n.f(h23, "authService");
        super();
        this.a = m2;
        this.b = firebaseFirestore2;
        this.c = h23;
    }

    private final boolean d() {
        return this.c.C();
    }

    public final boolean a() {
        return this.e;
    }

    public final boolean b() {
        return this.d;
    }

    public final boolean c() {
        return this.f;
    }

    public final boolean e() {
        if (!d()) {
            return 0;
        }
        return this.a.H().contains(this.c.v());
    }

    public final void f() {
        if (!d()) {
        }
        this.b.collection("ambassadors").document(this.c.v()).set(j0.h(), SetOptions.merge());
        this.a.H().add(this.c.v());
    }

    public final void g() {
        if (!d()) {
        }
        this.b.collection("ambassadors").document(this.c.v()).delete();
        this.a.H().remove(this.c.v());
    }

    public final void h(boolean z) {
        this.e = z;
    }

    public final void i(boolean z) {
        this.d = z;
    }

    public final void j(boolean z) {
        this.f = z;
    }
}
