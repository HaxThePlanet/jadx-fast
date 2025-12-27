package app.dogo.com.dogo_android.s.b;

import com.google.firebase.auth.AuthCredential;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: CredentialsRepository.kt */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/repository/local/CredentialsRepository;", "", "()V", "lastCredential", "Lcom/google/firebase/auth/AuthCredential;", "getLastCredential", "()Lcom/google/firebase/auth/AuthCredential;", "setLastCredential", "(Lcom/google/firebase/auth/AuthCredential;)V", "saveCredential", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d1, reason: from kotlin metadata */
public final class CredentialsRepository {

    /* renamed from: a, reason: from kotlin metadata */
    private AuthCredential lastCredential;
    public final AuthCredential a() {
        return this.lastCredential;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final void saveCredential(AuthCredential lastCredential) {
        n.f(lastCredential, "lastCredential");
        this.lastCredential = lastCredential;
    }
}
