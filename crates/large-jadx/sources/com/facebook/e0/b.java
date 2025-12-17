package com.facebook.e0;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.e0.v.b;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0008\u0010\u000c\u001a\u00020\rH\u0002J\u0008\u0010\u000e\u001a\u00020\rH\u0007J\u0012\u0010\u000f\u001a\u00020\r2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lcom/facebook/appevents/AnalyticsUserIDStore;", "", "()V", "ANALYTICS_USER_ID_KEY", "", "TAG", "initialized", "", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "userID", "getUserID", "initAndWait", "", "initStore", "setUserID", "id", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    private static final String a;
    private static final ReentrantReadWriteLock b;
    private static String c;
    private static volatile boolean d;
    public static final com.facebook.e0.b e;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        public static final com.facebook.e0.b.a a;
        static {
            b.a aVar = new b.a();
            b.a.a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            b.c(b.e);
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class b implements Runnable {

        final String a;
        b(String string) {
            this.a = string;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            com.facebook.e0.b bVar = b.e;
            b.a(bVar).writeLock().lock();
            b.d(bVar, this.a);
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(o.f()).edit();
            edit.putString("com.facebook.appevents.AnalyticsUserIDStore.userID", b.b(bVar));
            edit.apply();
            b.a(bVar).writeLock().unlock();
        }
    }
    static {
        b bVar = new b();
        b.e = bVar;
        String simpleName = b.class.getSimpleName();
        n.e(simpleName, "AnalyticsUserIDStore::class.java.simpleName");
        b.a = simpleName;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        b.b = reentrantReadWriteLock;
    }

    public static final ReentrantReadWriteLock a(com.facebook.e0.b b) {
        return b.b;
    }

    public static final String b(com.facebook.e0.b b) {
        return b.c;
    }

    public static final void c(com.facebook.e0.b b) {
        b.f();
    }

    public static final void d(com.facebook.e0.b b, String string2) {
        b.c = string2;
    }

    public static final String e() {
        boolean z;
        Object lock;
        if (!b.d) {
            Log.w(b.a, "initStore should have been called before calling setUserID");
            b.e.f();
        }
        ReentrantReadWriteLock reentrantReadWriteLock = b.b;
        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.readLock().unlock();
        return b.c;
    }

    private final void f() {
        if (b.d) {
        }
        ReentrantReadWriteLock reentrantReadWriteLock = b.b;
        reentrantReadWriteLock.writeLock().lock();
        if (b.d) {
            reentrantReadWriteLock.writeLock().unlock();
        }
        b.c = PreferenceManager.getDefaultSharedPreferences(o.f()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", 0);
        b.d = true;
        reentrantReadWriteLock.writeLock().unlock();
    }

    public static final void g() {
        if (b.d) {
        }
        m.b.a().execute(b.a.a);
    }

    public static final void h(String string) {
        boolean z;
        String str;
        b.b();
        if (!b.d) {
            Log.w(b.a, "initStore should have been called before calling setUserID");
            b.e.f();
        }
        b.b bVar = new b.b(string);
        m.b.a().execute(bVar);
    }
}
