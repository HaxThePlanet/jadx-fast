package com.facebook.e0.q;

import android.app.Activity;
import com.facebook.internal.a;
import com.facebook.internal.a.a;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.p;
import com.facebook.internal.q;
import com.facebook.o;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0008H\u0007J\u0010\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0008\u0010\u000c\u001a\u00020\u0008H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lcom/facebook/appevents/aam/MetadataIndexer;", "", "()V", "TAG", "", "enabled", "", "enable", "", "onActivityResumed", "activity", "Landroid/app/Activity;", "updateRules", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static final String a = "com.facebook.e0.q.a";
    private static boolean b;
    public static final com.facebook.e0.q.a c;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        public static final com.facebook.e0.q.a.a a;
        static {
            a.a aVar = new a.a();
            a.a.a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            a.a aVar;
            if (a.d(this)) {
            }
            if (!a.h.h(o.f())) {
                z = a.c;
                a.b(z);
                a.a(z, true);
            }
        }
    }
    static {
        a aVar = new a();
        a.c = aVar;
    }

    public static final void a(com.facebook.e0.q.a a, boolean z2) {
        if (a.d(a.class)) {
        }
        a.b = z2;
    }

    public static final void b(com.facebook.e0.q.a a) {
        if (a.d(a.class)) {
        }
        a.e();
    }

    public static final void c() {
        Executor executor;
        com.facebook.e0.q.a.a aVar;
        if (a.d(a.class)) {
        }
        o.n().execute(a.a.a);
    }

    public static final void d(Activity activity) {
        boolean empty;
        if (a.d(a.class)) {
        }
        n.f(activity, "activity");
        if (a.b) {
            if (c.e.c().isEmpty()) {
            } else {
                d.x.e(activity);
            }
        }
    }

    private final void e() {
        Object pVar;
        int i;
        if (a.d(this)) {
        }
        pVar = q.o(o.g(), false);
        pVar = pVar.f();
        if (pVar != null && pVar != null) {
            pVar = pVar.f();
            if (pVar != null) {
                c.e.d(pVar);
            }
        }
    }
}
