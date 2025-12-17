package com.facebook.internal.g0.i;

import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.g0.a;
import com.facebook.internal.g0.b;
import com.facebook.internal.g0.b.a;
import com.facebook.internal.g0.b.c;
import com.facebook.o;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0002\u0008\u0008\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\t\u001a\u00020\nH\u0007J\u0008\u0010\u000b\u001a\u00020\nH\u0007J\u001a\u0010\u000c\u001a\u00020\n2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0007J\u0008\u0010\u0010\u001a\u00020\u0008H\u0007J\u0010\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u0001H\u0007J\u0012\u0010\u0012\u001a\u00020\n2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0007J\u0008\u0010\u0013\u001a\u00020\nH\u0007J\u0008\u0010\u0014\u001a\u00020\nH\u0007J\u0012\u0010\u0015\u001a\u00020\n2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R2\u0010\u0003\u001a&\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00010\u0001 \u0005*\u0012\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lcom/facebook/internal/instrument/crashshield/CrashShieldHandler;", "", "()V", "crashingObjects", "", "kotlin.jvm.PlatformType", "", "enabled", "", "disable", "", "enable", "handleThrowable", "e", "", "o", "isDebug", "isObjectCrashing", "methodFinished", "reset", "resetCrashingObjects", "scheduleCrashInDebug", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static final Set<Object> a;
    private static boolean b;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0017¨\u0006\u0004", d2 = {"com/facebook/internal/instrument/crashshield/CrashShieldHandler$scheduleCrashInDebug$1", "Ljava/lang/Runnable;", "run", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Runnable {

        final Throwable a;
        a(Throwable throwable) {
            this.a = throwable;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            RuntimeException runtimeException = new RuntimeException(this.a);
            throw runtimeException;
        }
    }
    static {
        WeakHashMap weakHashMap = new WeakHashMap();
        a.a = Collections.newSetFromMap(weakHashMap);
    }

    public static final void a() {
        a.b = true;
    }

    public static final void b(Throwable throwable, Object object2) {
        boolean obj2;
        n.f(object2, "o");
        if (!a.b) {
        }
        a.a.add(object2);
        if (o.j()) {
            a.b(throwable);
            b.a.b(throwable, b.c.CrashShield).g();
        }
        a.e(throwable);
    }

    public static final boolean c() {
        return 0;
    }

    public static final boolean d(Object object) {
        n.f(object, "o");
        return a.a.contains(object);
    }

    public static final void e(Throwable throwable) {
        boolean handler;
        com.facebook.internal.g0.i.a.a aVar;
        if (a.c()) {
            handler = new Handler(Looper.getMainLooper());
            aVar = new a.a(throwable);
            handler.post(aVar);
        }
    }
}
