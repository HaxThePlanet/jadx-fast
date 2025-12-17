package com.facebook;

import android.content.Intent;
import com.facebook.internal.b0;
import d.q.a.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u001c\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0002J\u001a\u0010\u000c\u001a\u00020\u00122\u0008\u0010\t\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u0014\u001a\u00020\u0010H\u0002R(\u0010\t\u001a\u0004\u0018\u00010\u00082\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00088F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lcom/facebook/ProfileManager;", "", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "profileCache", "Lcom/facebook/ProfileCache;", "(Landroidx/localbroadcastmanager/content/LocalBroadcastManager;Lcom/facebook/ProfileCache;)V", "value", "Lcom/facebook/Profile;", "currentProfile", "getCurrentProfile", "()Lcom/facebook/Profile;", "setCurrentProfile", "(Lcom/facebook/Profile;)V", "currentProfileField", "loadCurrentProfile", "", "sendCurrentProfileChangedBroadcast", "", "oldProfile", "writeToCache", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class y {

    private static volatile com.facebook.y d;
    public static final com.facebook.y.a e;
    private com.facebook.w a;
    private final a b;
    private final com.facebook.x c;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\t\u001a\u00020\u0008H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lcom/facebook/ProfileManager$Companion;", "", "()V", "ACTION_CURRENT_PROFILE_CHANGED", "", "EXTRA_NEW_PROFILE", "EXTRA_OLD_PROFILE", "instance", "Lcom/facebook/ProfileManager;", "getInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final com.facebook.y a() {
            Object yVar2;
            Object yVar3;
            com.facebook.y yVar;
            com.facebook.x xVar;
            if (y.a() == null && y.a() == null) {
                synchronized (this) {
                    yVar2 = a.b(o.f());
                    n.e(yVar2, "LocalBroadcastManager.ge…tance(applicationContext)");
                    xVar = new x();
                    yVar = new y(yVar2, xVar);
                    y.b(yVar);
                    yVar3 = w.a;
                }
            }
            com.facebook.y yVar4 = y.a();
            if (yVar4 == null) {
            } else {
                return yVar4;
            }
            try {
                IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
                throw illegalStateException;
            }
        }
    }
    static {
        y.a aVar = new y.a(0);
        y.e = aVar;
    }

    public y(a a, com.facebook.x x2) {
        n.f(a, "localBroadcastManager");
        n.f(x2, "profileCache");
        super();
        this.b = a;
        this.c = x2;
    }

    public static final com.facebook.y a() {
        return y.d;
    }

    public static final void b(com.facebook.y y) {
        y.d = y;
    }

    private final void e(com.facebook.w w, com.facebook.w w2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", w);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", w2);
        this.b.d(intent);
    }

    private final void g(com.facebook.w w, boolean z2) {
        com.facebook.x obj3;
        final com.facebook.w wVar = this.a;
        this.a = w;
        if (z2 != null) {
            if (w != null) {
                this.c.c(w);
            } else {
                this.c.a();
            }
        }
        if (!b0.c(wVar, w)) {
            e(wVar, w);
        }
    }

    public final com.facebook.w c() {
        return this.a;
    }

    public final boolean d() {
        com.facebook.w wVar = this.c.b();
        final int i2 = 0;
        if (wVar != null) {
            g(wVar, i2);
            return 1;
        }
        return i2;
    }

    public final void f(com.facebook.w w) {
        g(w, true);
    }
}
