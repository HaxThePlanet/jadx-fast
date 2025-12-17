package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerClient.Builder;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u000c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0008\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0007¨\u0006\u000f", d2 = {"Lcom/facebook/internal/InstallReferrerUtil;", "", "()V", "IS_REFERRER_UPDATED", "", "isUpdated", "", "()Z", "tryConnectReferrerInfo", "", "callback", "Lcom/facebook/internal/InstallReferrerUtil$Callback;", "tryUpdateReferrerInfo", "updateReferrer", "Callback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class s {

    public static final com.facebook.internal.s a;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006", d2 = {"Lcom/facebook/internal/InstallReferrerUtil$Callback;", "", "onReceiveReferrerUrl", "", "s", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface a {
        public abstract void a(String string);
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0007", d2 = {"com/facebook/internal/InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1", "Lcom/android/installreferrer/api/InstallReferrerStateListener;", "onInstallReferrerServiceDisconnected", "", "onInstallReferrerSetupFinished", "responseCode", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b implements InstallReferrerStateListener {

        final InstallReferrerClient a;
        final com.facebook.internal.s.a b;
        b(InstallReferrerClient installReferrerClient, com.facebook.internal.s.a s$a2) {
            this.a = installReferrerClient;
            this.b = a2;
            super();
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerServiceDisconnected() {
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerSetupFinished(int i) {
            int i2;
            String str;
            int i3;
            int i4;
            com.facebook.internal.s obj5;
            if (a.d(this)) {
            }
            i2 = 2;
            if (i != 0) {
                if (i != i2) {
                } else {
                    s.a(s.a);
                }
            } else {
                obj5 = this.a;
                n.e(obj5, "referrerClient");
                obj5 = obj5.getInstallReferrer();
                n.e(obj5, "referrerClient.installReferrer");
                obj5 = obj5.getInstallReferrer();
                if (obj5 != null) {
                    i3 = 0;
                    i4 = 0;
                    if (!l.R(obj5, "fb", i4, i2, i3)) {
                        if (l.R(obj5, "facebook", i4, i2, i3)) {
                            this.b.a(obj5);
                        }
                    } else {
                    }
                }
                s.a(s.a);
            }
        }
    }
    static {
        s sVar = new s();
        s.a = sVar;
    }

    public static final void a(com.facebook.internal.s s) {
        s.e();
    }

    private final boolean b() {
        final int i = 0;
        return o.f().getSharedPreferences("com.facebook.sdk.appEventPreferences", i).getBoolean("is_referrer_updated", i);
    }

    private final void c(com.facebook.internal.s.a s$a) {
        InstallReferrerClient build = InstallReferrerClient.newBuilder(o.f()).build();
        s.b bVar = new s.b(build, a);
        build.startConnection(bVar);
    }

    public static final void d(com.facebook.internal.s.a s$a) {
        n.f(a, "callback");
        com.facebook.internal.s sVar = s.a;
        if (!sVar.b()) {
            sVar.c(a);
        }
    }

    private final void e() {
        o.f().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("is_referrer_updated", true).apply();
    }
}
