package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.internal.b0;
import d.q.a.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0017\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u001c\u0010\u0013\u001a\u00020\u00102\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0002J\u001a\u0010\u000c\u001a\u00020\u00102\u0008\u0010\t\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u0015\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0004\u0018\u00010\u00082\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00088F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lcom/facebook/AuthenticationTokenManager;", "", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "authenticationTokenCache", "Lcom/facebook/AuthenticationTokenCache;", "(Landroidx/localbroadcastmanager/content/LocalBroadcastManager;Lcom/facebook/AuthenticationTokenCache;)V", "value", "Lcom/facebook/AuthenticationToken;", "currentAuthenticationToken", "getCurrentAuthenticationToken", "()Lcom/facebook/AuthenticationToken;", "setCurrentAuthenticationToken", "(Lcom/facebook/AuthenticationToken;)V", "currentAuthenticationTokenField", "currentAuthenticationTokenChanged", "", "loadCurrentAuthenticationToken", "", "sendCurrentAuthenticationTokenChangedBroadcastIntent", "oldAuthenticationToken", "saveToCache", "Companion", "CurrentAuthenticationTokenChangedBroadcastReceiver", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class AuthenticationTokenManager {

    private static com.facebook.AuthenticationTokenManager d;
    public static final com.facebook.AuthenticationTokenManager.a e;
    private com.facebook.g a;
    private final a b;
    private final com.facebook.h c;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t", d2 = {"Lcom/facebook/AuthenticationTokenManager$CurrentAuthenticationTokenChangedBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class CurrentAuthenticationTokenChangedBroadcastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            n.f(context, "context");
            n.f(intent2, "intent");
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000b\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lcom/facebook/AuthenticationTokenManager$Companion;", "", "()V", "ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED", "", "EXTRA_NEW_AUTHENTICATION_TOKEN", "EXTRA_OLD_AUTHENTICATION_TOKEN", "SHARED_PREFERENCES_NAME", "TAG", "instanceField", "Lcom/facebook/AuthenticationTokenManager;", "getInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final com.facebook.AuthenticationTokenManager a() {
            com.facebook.AuthenticationTokenManager authenticationTokenManager;
            com.facebook.h hVar;
            com.facebook.AuthenticationTokenManager authenticationTokenManager2;
            com.facebook.AuthenticationTokenManager authenticationTokenManager3 = AuthenticationTokenManager.a();
            if (authenticationTokenManager3 == null && AuthenticationTokenManager.a() == null) {
                synchronized (this) {
                    a aVar = a.b(o.f());
                    n.e(aVar, "LocalBroadcastManager.ge…tance(applicationContext)");
                    hVar = new h();
                    authenticationTokenManager2 = new AuthenticationTokenManager(aVar, hVar);
                    AuthenticationTokenManager.b(authenticationTokenManager2);
                    authenticationTokenManager = authenticationTokenManager2;
                    return authenticationTokenManager;
                }
            }
            return authenticationTokenManager3;
        }
    }
    static {
        AuthenticationTokenManager.a aVar = new AuthenticationTokenManager.a(0);
        AuthenticationTokenManager.e = aVar;
    }

    public AuthenticationTokenManager(a a, com.facebook.h h2) {
        n.f(a, "localBroadcastManager");
        n.f(h2, "authenticationTokenCache");
        super();
        this.b = a;
        this.c = h2;
    }

    public static final com.facebook.AuthenticationTokenManager a() {
        return AuthenticationTokenManager.d;
    }

    public static final void b(com.facebook.AuthenticationTokenManager authenticationTokenManager) {
        AuthenticationTokenManager.d = authenticationTokenManager;
    }

    private final void d(com.facebook.g g, com.facebook.g g2) {
        Intent intent = new Intent(o.f(), AuthenticationTokenManager.CurrentAuthenticationTokenChangedBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_AUTHENTICATION_TOKEN", g);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_AUTHENTICATION_TOKEN", g2);
        this.b.d(intent);
    }

    private final void f(com.facebook.g g, boolean z2) {
        Object obj3;
        final com.facebook.g gVar = c();
        this.a = g;
        if (z2 != null) {
            if (g != null) {
                this.c.b(g);
            } else {
                this.c.a();
                b0.h(o.f());
            }
        }
        if (!b0.c(gVar, g)) {
            d(gVar, g);
        }
    }

    public final com.facebook.g c() {
        return this.a;
    }

    public final void e(com.facebook.g g) {
        f(g, true);
    }
}
