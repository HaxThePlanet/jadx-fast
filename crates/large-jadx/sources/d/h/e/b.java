package d.h.e;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import d.e.g;
import java.util.ArrayList;

/* compiled from: AnimationHandler.java */
/* loaded from: classes.dex */
class b {

    public static b b;
    private static b c;
    private static final java.lang.ThreadLocal<b.a> d = new ThreadLocal<>();
    private final b.c a;

    static class a {

        final g<b.b, Long> a = new g<>();
        final ArrayList<b.b> b = new ArrayList<>();
        boolean c = false;
        a() {
            super();
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
        }
    }

    interface b {
        boolean a(long j);
    }

    interface c {
        void a(b.b bVar);

        void b();
    }

    private static class d implements b.c, Runnable {

        private static final java.lang.ThreadLocal<Handler> v = new ThreadLocal<>();
        private long a = -1;
        private long b = 16;
        b c;

        d() {
            super();
            this.c = bVar;
        }

        public void b() {
            c().postDelayed(this, Math.max(this.b - (SystemClock.uptimeMillis() - this.a), 0L));
        }

        Handler c() {
            java.lang.ThreadLocal threadLocal = b.d.v;
            if (threadLocal.get() == null) {
                b.d.v.set(new Handler(Looper.myLooper()));
            }
            return (Handler)b.d.v.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            final long uptimeMillis = SystemClock.uptimeMillis();
            this.a = uptimeMillis;
            this.c.j(uptimeMillis);
        }

        public void a(b.b bVar) {
        }
    }

    private class e implements b.c, Choreographer.FrameCallback {

        final /* synthetic */ b a;
        e() {
            this.a = bVar;
            super();
        }

        public void b() {
            Choreographer.getInstance().postFrameCallback(this);
        }

        public void doFrame(long j) {
            this.a.j(j / 1000000L);
        }

        public void a(b.b bVar) {
        }
    }

    b(b.c cVar) {
        super();
        if (cVar != null) {
            this.a = cVar;
        } else {
            int i = 16;
            if (Build.VERSION.SDK_INT >= 16) {
                this.a = new b.e(this);
            } else {
                this.a = new b.d(this);
            }
        }
    }

    private void c() {
        int i;
        Object item;
        if (i()) {
            i = e().size() - 1;
            while (i >= 0) {
                i = i - 1;
            }
            boolean z = false;
            l(z);
        }
    }

    private void d(long j) {
        int i = 0;
        boolean z;
        i = 0;
        while (i < e().size()) {
            Object item = e().get(i);
            i = i + 1;
        }
        c();
    }

    private ArrayList<b.b> e() {
        Object obj;
        java.lang.ThreadLocal threadLocal = b.d;
        if ((b.a)threadLocal.get() == null) {
            b.d.set(new b.a());
        }
        return obj.b;
    }

    private g<b.b, Long> f() {
        Object obj;
        java.lang.ThreadLocal threadLocal = b.d;
        if ((b.a)threadLocal.get() == null) {
            b.d.set(new b.a());
        }
        return obj.a;
    }

    public static b g() {
        d.h.e.b bVar2 = b.c;
        if (b.c != null) {
            return b.c;
        }
        if (b.b == null) {
            d.h.e.b.c cVar = null;
            b.b = new b(cVar);
        }
        return b.b;
    }

    private boolean h(b.b bVar, long j) {
        Object obj = f().get(bVar);
        final boolean z = true;
        if (obj == null) {
            return true;
        }
        final long value = obj.longValue();
        if (value < j) {
            f().remove(bVar);
            return true;
        }
        return false;
    }

    private boolean i() {
        Object obj;
        java.lang.ThreadLocal threadLocal = b.d;
        if ((b.a)threadLocal.get() == null) {
            b.d.set(new b.a());
        }
        return obj.c;
    }

    private void l(boolean z) {
        Object obj;
        final java.lang.ThreadLocal threadLocal = b.d;
        if ((b.a)threadLocal.get() == null) {
            b.d.set(new b.a());
        }
        obj.c = z;
    }

    void a(b.b bVar) {
        if (e().size() == 0) {
            this.a.b();
        }
        if (!e().contains(bVar)) {
            e().add(bVar);
        }
        this.a.a(bVar);
    }

    void b(r rVar) {
        int i;
        Object item;
        i = e().size() - 1;
        while (i >= 0) {
            item = e().get(i);
            i = i - 1;
        }
    }

    void j(long j) {
        d(j);
        if (e().size() > 0) {
            this.a.b();
        }
    }

    public void k(b.b bVar) {
        f().remove(bVar);
        int indexOf = e().indexOf(bVar);
        if (indexOf >= 0) {
            Object obj = null;
            e().set(indexOf, obj);
            l(true);
        }
    }
}
