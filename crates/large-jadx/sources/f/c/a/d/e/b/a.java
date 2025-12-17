package f.c.a.d.e.b;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.signin.internal.c;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.c.d;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.q0;
import com.google.android.gms.common.internal.r;
import f.c.a.d.e.g;

/* loaded from: classes2.dex */
public class a extends h<f.c.a.d.e.b.g> implements g {

    public static final int w;
    private final boolean a = true;
    private final d b;
    private final Bundle c;
    private final Integer v;
    public a(Context context, Looper looper2, boolean z3, d d4, Bundle bundle5, d.a d$a6, d.b d$b7) {
        super(context, looper2, 44, d4, a6, b7);
        int obj8 = 1;
        this.b = d4;
        this.c = bundle5;
        this.v = d4.j();
    }

    public static Bundle c(d d) {
        Object str;
        android.accounts.Account obj4;
        d.i();
        str = d.j();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", d.a());
        if (str != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", str.intValue());
        }
        int i = 0;
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", i);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", i);
        int i2 = 0;
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", i2);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", i);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", i2);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", i2);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", i);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.h
    public final void a() {
        c.d dVar = new c.d(this);
        connect(dVar);
    }

    @Override // com.google.android.gms.common.internal.h
    public final void b(f.c.a.d.e.b.f f) {
        com.google.android.gms.auth.api.signin.GoogleSignInAccount googleSignInAccount;
        r.k(f, "Expecting a valid ISignInCallbacks");
        android.accounts.Account account = this.b.c();
        if ("<<default account>>".equals(account.name)) {
            googleSignInAccount = c.b(getContext()).c();
        } else {
            googleSignInAccount = i2;
        }
        Integer num = this.v;
        r.j(num);
        q0 q0Var = new q0(account, (Integer)num.intValue(), googleSignInAccount);
        j jVar = new j(1, q0Var);
        (g)getService().p2(jVar, f);
    }

    protected final IInterface createServiceInterface(IBinder iBinder) {
        IInterface localInterface;
        boolean z;
        int obj3;
        if (iBinder == null) {
            obj3 = 0;
        } else {
            localInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            if (localInterface instanceof g) {
                obj3 = localInterface;
            } else {
                localInterface = new g(iBinder);
                obj3 = localInterface;
            }
        }
        return obj3;
    }

    protected final Bundle getGetServiceRequestExtraArgs() {
        boolean equals;
        String packageName;
        String str;
        if (!getContext().getPackageName().equals(this.b.f())) {
            this.c.putString("com.google.android.gms.signin.internal.realClientPackageName", this.b.f());
        }
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.h
    public final int getMinApkVersion() {
        return 12451000;
    }

    protected final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.h
    public final boolean requiresSignIn() {
        return this.a;
    }
}
