package com.facebook.internal.g0.h;

import android.util.Log;
import com.facebook.internal.b0;
import com.facebook.internal.g0.a;
import com.facebook.internal.g0.b;
import com.facebook.internal.g0.b.a;
import com.facebook.internal.g0.b.c;
import com.facebook.internal.g0.f;
import com.facebook.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.y.h0;
import kotlin.y.p;
import org.json.JSONArray;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\u0008\u0002\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "previousHandler", "(Ljava/lang/Thread$UncaughtExceptionHandler;)V", "uncaughtException", "", "t", "Ljava/lang/Thread;", "e", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a implements java.lang.Thread.UncaughtExceptionHandler {

    private static final String b;
    private static com.facebook.internal.g0.h.a c;
    public static final com.facebook.internal.g0.h.a.a d;
    private final java.lang.Thread.UncaughtExceptionHandler a;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\t\u001a\u00020\nH\u0007J\u0008\u0010\u000b\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lcom/facebook/internal/instrument/crashreport/CrashHandler$Companion;", "", "()V", "MAX_CRASH_REPORT_NUM", "", "TAG", "", "instance", "Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "enable", "", "sendExceptionReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        private final void b() {
            int length;
            int i2;
            int i;
            b bVar;
            if (b0.T()) {
            }
            java.io.File[] objArr = f.j();
            ArrayList arrayList2 = new ArrayList(objArr.length);
            i2 = 0;
            i = i2;
            while (i < objArr.length) {
                arrayList2.add(b.a.d(objArr[i]));
                i++;
            }
            ArrayList arrayList = new ArrayList();
            Iterator iterator = arrayList2.iterator();
            while (iterator.hasNext()) {
                length = iterator.next();
                if ((b)length.f() != 0) {
                }
                arrayList.add(length);
            }
            List list = p.D0(arrayList, a.a.b.a);
            JSONArray jSONArray = new JSONArray();
            Iterator iterator2 = g.l(i2, Math.min(list.size(), 5)).iterator();
            while (iterator2.hasNext()) {
                jSONArray.put(list.get((h0)iterator2.d()));
            }
            a.a.a aVar = new a.a.a(list);
            f.l("crash_reports", jSONArray, aVar);
        }

        public final void a() {
            synchronized (this) {
                try {
                    b();
                    if (a.a() != null) {
                    }
                    Log.w(a.b(), "Already enabled!");
                    a aVar3 = new a(Thread.getDefaultUncaughtExceptionHandler(), 0);
                    a.c(aVar3);
                    Thread.setDefaultUncaughtExceptionHandler(a.a());
                    throw th;
                }
            }
        }
    }
    static {
        a.a aVar = new a.a(0);
        a.d = aVar;
        a.b = a.class.getCanonicalName();
    }

    private a(java.lang.Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler) {
        super();
        this.a = uncaughtExceptionHandler;
    }

    public a(java.lang.Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler, g g2) {
        super(uncaughtExceptionHandler);
    }

    public static final com.facebook.internal.g0.h.a a() {
        return a.c;
    }

    public static final String b() {
        return a.b;
    }

    public static final void c(com.facebook.internal.g0.h.a a) {
        a.c = a;
    }

    @Override // java.lang.Thread$UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable throwable2) {
        boolean z;
        n.f(thread, "t");
        n.f(throwable2, "e");
        if (f.f(throwable2)) {
            a.b(throwable2);
            b.a.b(throwable2, b.c.CrashReport).g();
        }
        java.lang.Thread.UncaughtExceptionHandler exc = this.a;
        if (exc != null) {
            exc.uncaughtException(thread, throwable2);
        }
    }
}
