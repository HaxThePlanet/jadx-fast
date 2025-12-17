package d.h.e;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import d.e.g;
import java.util.ArrayList;

/* loaded from: classes.dex */
class b {

    public static d.h.e.b b;
    private static d.h.e.b c;
    private static final java.lang.ThreadLocal<d.h.e.b.a> d;
    private final d.h.e.b.c a;

    static class a {

        final g<d.h.e.b.b, Long> a;
        final ArrayList<d.h.e.b.b> b;
        boolean c = false;
        a() {
            super();
            g gVar = new g();
            this.a = gVar;
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            int i = 0;
        }
    }

    interface b {
        public abstract boolean a(long l);
    }

    interface c {
        public abstract void a(d.h.e.b.b b$b);

        public abstract void b();
    }

    private static class d implements d.h.e.b.c, Runnable {

        private static final java.lang.ThreadLocal<Handler> v;
        private long a = -1;
        private long b = 16;
        d.h.e.b c;
        static {
            ThreadLocal threadLocal = new ThreadLocal();
            b.d.v = threadLocal;
        }

        d(d.h.e.b b) {
            super();
            int i = -1;
            int i2 = 16;
            this.c = b;
        }

        @Override // d.h.e.b$c
        public void a(d.h.e.b.b b$b) {
        }

        @Override // d.h.e.b$c
        public void b() {
            c().postDelayed(this, Math.max(l -= i2, obj1));
        }

        @Override // d.h.e.b$c
        Handler c() {
            Object handler;
            Looper myLooper;
            java.lang.ThreadLocal threadLocal = b.d.v;
            if (threadLocal.get() == null) {
                handler = new Handler(Looper.myLooper());
                threadLocal.set(handler);
            }
            return (Handler)threadLocal.get();
        }

        @Override // d.h.e.b$c
        public void run() {
            final long uptimeMillis = SystemClock.uptimeMillis();
            this.a = uptimeMillis;
            this.c.j(uptimeMillis);
        }
    }

    private class e implements d.h.e.b.c, Choreographer.FrameCallback {

        final d.h.e.b a;
        e(d.h.e.b b) {
            this.a = b;
            super();
        }

        @Override // d.h.e.b$c
        public void a(d.h.e.b.b b$b) {
        }

        @Override // d.h.e.b$c
        public void b() {
            Choreographer.getInstance().postFrameCallback(this);
        }

        @Override // d.h.e.b$c
        public void doFrame(long l) {
            this.a.j(l /= i);
        }
    }
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        b.d = threadLocal;
    }

    b(d.h.e.b.c b$c) {
        int i;
        Object obj2;
        super();
        if (c == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                obj2 = new b.e(this);
                this.a = obj2;
            } else {
                obj2 = new b.d(this);
                this.a = obj2;
            }
        } else {
            this.a = c;
        }
    }

    private void c() {
        boolean z;
        int i;
        Object obj;
        if (i()) {
            size--;
            while (i >= 0) {
                if (e().get(i) == null) {
                }
                i--;
                e().remove(i);
            }
            l(false);
        }
    }

    private void d(long l) {
        int i;
        Object obj;
        boolean z;
        i = 0;
        while (i < e().size()) {
            obj = e().get(i);
            if ((b.b)obj == null) {
            } else {
            }
            if (h((b.b)obj, SystemClock.uptimeMillis())) {
            }
            i++;
            obj.a(l);
        }
        c();
    }

    private ArrayList<d.h.e.b.b> e() {
        Object aVar;
        java.lang.ThreadLocal threadLocal = b.d;
        if ((b.a)threadLocal.get() == null) {
            aVar = new b.a();
            threadLocal.set(aVar);
        }
        return aVar.b;
    }

    private g<d.h.e.b.b, Long> f() {
        Object aVar;
        java.lang.ThreadLocal threadLocal = b.d;
        if ((b.a)threadLocal.get() == null) {
            aVar = new b.a();
            threadLocal.set(aVar);
        }
        return aVar.a;
    }

    public static d.h.e.b g() {
        d.h.e.b bVar;
        int i;
        d.h.e.b bVar2 = b.c;
        if (bVar2 != null) {
            return bVar2;
        }
        if (b.b == null) {
            bVar = new b(0);
            b.b = bVar;
        }
        return b.b;
    }

    private boolean h(d.h.e.b.b b$b, long l2) {
        Object obj = f().get(b);
        final int i = 1;
        if ((Long)obj == null) {
            return i;
        }
        if (Long.compare(longValue, l2) < 0) {
            f().remove(b);
            return i;
        }
        return 0;
    }

    private boolean i() {
        Object aVar;
        java.lang.ThreadLocal threadLocal = b.d;
        if ((b.a)threadLocal.get() == null) {
            aVar = new b.a();
            threadLocal.set(aVar);
        }
        return aVar.c;
    }

    private void l(boolean z) {
        Object aVar;
        final java.lang.ThreadLocal threadLocal = b.d;
        if ((b.a)threadLocal.get() == null) {
            aVar = new b.a();
            threadLocal.set(aVar);
        }
        aVar.c = z;
    }

    void a(d.h.e.b.b b$b) {
        int size;
        boolean contains;
        if (e().size() == 0) {
            this.a.b();
        }
        if (!e().contains(b)) {
            e().add(b);
        }
        this.a.a(b);
    }

    void b(d.h.e.r r) {
        int i;
        Object obj;
        size--;
        while (i >= 0) {
            obj = e().get(i);
            if ((b.b)obj == null) {
            } else {
            }
            if (r.h0((b.b)obj)) {
            }
            i--;
            (c)e().get(i).cancel();
        }
    }

    void j(long l) {
        int obj1;
        d(l);
        if (e().size() > 0) {
            this.a.b();
        }
    }

    public void k(d.h.e.b.b b$b) {
        ArrayList list;
        int i;
        int obj3;
        f().remove(b);
        obj3 = e().indexOf(b);
        if (obj3 >= 0) {
            e().set(obj3, 0);
            l(true);
        }
    }
}
