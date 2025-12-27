package f.c.a.d.e.b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.c.d;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.q0;
import com.google.android.gms.common.internal.r;
import f.c.a.d.e.g;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public class a extends h<g> implements g {

    public static final /* synthetic */ int w = 0;
    private final boolean a = true;
    private final d b;
    private final Bundle c;
    private final Integer v;
    public a(Context context, Looper looper, boolean z, d dVar, Bundle bundle, d.a aVar, d.b bVar) {
        super(context, looper, 44, dVar, aVar, bVar);
        this.b = dVar;
        this.c = bundle;
        this.v = dVar.j();
    }

    public static Bundle c(d dVar) {
        dVar.i();
        Integer num = dVar.j();
        final Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.a());
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        boolean z = false;
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", z);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", z);
        String str3 = null;
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", str3);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", z);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", str3);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", str3);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", z);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.h
    public final void a() {
        connect(new c.d(this));
    }

    @Override // com.google.android.gms.common.internal.h
    public final void b(f fVar) {
        com.google.android.gms.auth.api.signin.GoogleSignInAccount googleSignInAccount;
        r.k(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account account = this.b.c();
            if ("<<default account>>".equals(account.name)) {
                googleSignInAccount = c.b(getContext()).c();
            } else {
                int i3 = 0;
            }
            r.j(this.v);
            (g)getService().p2(new j(1, new q0(account, num.intValue(), googleSignInAccount)), fVar);
        } catch (android.os.RemoteException unused) {
            fVar = "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.";
            Log.wtf(str2, fVar, th);
            return;
        }
    }

    @Override // com.google.android.gms.common.internal.h
    protected final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.b.f())) {
            str = "com.google.android.gms.signin.internal.realClientPackageName";
            this.c.putString(str, this.b.f());
        }
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.h
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.h
    public final boolean requiresSignIn() {
        return this.a;
    }
}
