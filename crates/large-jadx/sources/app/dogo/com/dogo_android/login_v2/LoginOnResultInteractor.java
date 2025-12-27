package app.dogo.com.dogo_android.login_v2;

import android.content.Intent;
import app.dogo.com.dogo_android.s.b.d1;
import app.dogo.com.dogo_android.service.h2;
import com.google.firebase.auth.AuthResult;
import i.b.a0;
import i.b.b;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: LoginOnResultInteractor.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cJ$\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/login_v2/LoginOnResultInteractor;", "", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "credential", "Lapp/dogo/com/dogo_android/repository/local/CredentialsRepository;", "(Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/local/CredentialsRepository;)V", "getAuthService", "()Lapp/dogo/com/dogo_android/service/AuthService;", "getCredential", "()Lapp/dogo/com/dogo_android/repository/local/CredentialsRepository;", "getAuthResult", "Lio/reactivex/Single;", "Lcom/google/firebase/auth/AuthResult;", "launchEmailAuthentication", "email", "", "password", "accCreationFlag", "", "notifyInfo", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "sendPasswordResetEmail", "Lio/reactivex/Completable;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: y, reason: from kotlin metadata */
public final class LoginOnResultInteractor {

    private final h2 a;
    private final d1 b;
    public y(h2 h2Var, d1 d1Var) {
        n.f(h2Var, "authService");
        n.f(d1Var, "credential");
        super();
        this.a = h2Var;
        this.b = d1Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final a0<AuthResult> getAuthResult() {
        a0 error;
        com.google.firebase.auth.AuthCredential authCredential = this.b.a();
        if (authCredential != null) {
            error = this.a.n(authCredential);
        } else {
            n.e(a0.error(new Throwable("no last credentials")), "{\n            Single.error(Throwable(\"no last credentials\"))\n        }");
        }
        return error;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final a0<AuthResult> launchEmailAuthentication(String email, String password, boolean accCreationFlag) {
        n.f(email, "email");
        n.f(password, "password");
        return this.a.g0(email, password, accCreationFlag);
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final void notifyInfo(int requestCode, int resultCode, Intent data) {
        this.a.h(requestCode, resultCode, data);
        this.a.i(requestCode, resultCode, data);
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final b sendPasswordResetEmail(String email) {
        n.f(email, "email");
        return this.a.h0(email);
    }
}
