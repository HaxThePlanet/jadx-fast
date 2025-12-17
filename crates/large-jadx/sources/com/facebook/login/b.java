package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import d.c.b.b;
import d.c.b.d;
import d.c.b.e;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u000c", d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper;", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "()V", "onCustomTabsServiceConnected", "", "name", "Landroid/content/ComponentName;", "newClient", "Landroidx/browser/customtabs/CustomTabsClient;", "onServiceDisconnected", "componentName", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class b extends d {

    private static b a;
    private static e b;
    private static final ReentrantLock c;
    public static final com.facebook.login.b.a v;

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0007J\u0008\u0010\u000e\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper$Companion;", "", "()V", "client", "Landroidx/browser/customtabs/CustomTabsClient;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "session", "Landroidx/browser/customtabs/CustomTabsSession;", "getPreparedSessionOnce", "mayLaunchUrl", "", "url", "Landroid/net/Uri;", "prepareSession", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public static final void a(com.facebook.login.b.a b$a) {
            a.d();
        }

        private final void d() {
            Object eVar;
            int i;
            b.c().lock();
            eVar = b.b();
            if (b.d() == null && eVar != null) {
                eVar = b.b();
                if (eVar != null) {
                    b.e(eVar.c(0));
                }
            }
            b.c().unlock();
        }

        public final e b() {
            b.c().lock();
            b.e(0);
            b.c().unlock();
            return b.d();
        }

        public final void c(Uri uri) {
            int i;
            n.f(uri, "url");
            d();
            b.c().lock();
            e eVar = b.d();
            if (eVar != null) {
                i = 0;
                eVar.c(uri, i, i);
            }
            b.c().unlock();
        }
    }
    static {
        b.a aVar = new b.a(0);
        b.v = aVar;
        ReentrantLock reentrantLock = new ReentrantLock();
        b.c = reentrantLock;
    }

    public static final b b() {
        return b.a;
    }

    public static final ReentrantLock c() {
        return b.c;
    }

    public static final e d() {
        return b.b;
    }

    public static final void e(e e) {
        b.b = e;
    }

    public static final void f(Uri uri) {
        b.v.c(uri);
    }

    @Override // d.c.b.d
    public void a(ComponentName componentName, b b2) {
        n.f(componentName, "name");
        n.f(b2, "newClient");
        b2.d(0);
        b.a = b2;
        b.a.a(b.v);
    }

    @Override // d.c.b.d
    public void onServiceDisconnected(ComponentName componentName) {
        n.f(componentName, "componentName");
    }
}
