package d.k.a;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import d.e.g;
import java.util.ArrayList;

/* loaded from: classes.dex */
class a {

    public static final java.lang.ThreadLocal<d.k.a.a> g;
    private final g<d.k.a.a.b, Long> a;
    final ArrayList<d.k.a.a.b> b;
    private final d.k.a.a.a c;
    private d.k.a.a.c d;
    long e = 0;
    private boolean f = false;

    class a {

        final d.k.a.a a;
        a(d.k.a.a a) {
            this.a = a;
            super();
        }

        void a() {
            int size;
            aVar.e = SystemClock.uptimeMillis();
            d.k.a.a aVar2 = this.a;
            aVar2.c(aVar2.e);
            if (aVar3.b.size() > 0) {
                this.a.e().a();
            }
        }
    }

    interface b {
        public abstract boolean a(long l);
    }

    static abstract class c {

        final d.k.a.a.a a;
        c(d.k.a.a.a a$a) {
            super();
            this.a = a;
        }

        abstract void a();
    }

    private static class d extends d.k.a.a.c {

        private final Runnable b;
        private final Handler c;
        long d = -1;
        d(d.k.a.a.a a$a) {
            super(a);
            int i = -1;
            a.d.a obj3 = new a.d.a(this);
            this.b = obj3;
            obj3 = new Handler(Looper.myLooper());
            this.c = obj3;
        }

        @Override // d.k.a.a$c
        void a() {
            this.c.postDelayed(this.b, Math.max(i3 -= i, obj3));
        }
    }

    private static class e extends d.k.a.a.c {

        private final Choreographer b;
        private final Choreographer.FrameCallback c;
        e(d.k.a.a.a a$a) {
            super(a);
            this.b = Choreographer.getInstance();
            a.e.a obj1 = new a.e.a(this);
            this.c = obj1;
        }

        @Override // d.k.a.a$c
        void a() {
            this.b.postFrameCallback(this.c);
        }
    }
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        a.g = threadLocal;
    }

    a() {
        super();
        g gVar = new g();
        this.a = gVar;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        a.a aVar = new a.a(this);
        this.c = aVar;
        int i = 0;
        int i2 = 0;
    }

    private void b() {
        boolean z;
        int i;
        Object obj;
        if (this.f) {
            size--;
            while (i >= 0) {
                if (this.b.get(i) == null) {
                }
                i--;
                this.b.remove(i);
            }
            this.f = false;
        }
    }

    public static d.k.a.a d() {
        Object aVar;
        java.lang.ThreadLocal threadLocal = a.g;
        if (threadLocal.get() == null) {
            aVar = new a();
            threadLocal.set(aVar);
        }
        return (a)threadLocal.get();
    }

    private boolean f(d.k.a.a.b a$b, long l2) {
        Object obj = this.a.get(b);
        final int i = 1;
        if ((Long)obj == null) {
            return i;
        }
        if (Long.compare(longValue, l2) < 0) {
            this.a.remove(b);
            return i;
        }
        return 0;
    }

    public void a(d.k.a.a.b a$b, long l2) {
        int size;
        boolean contains;
        int cmp;
        int i;
        int obj5;
        if (this.b.size() == 0) {
            e().a();
        }
        if (!this.b.contains(b)) {
            this.b.add(b);
        }
        if (Long.compare(l2, i2) > 0) {
            this.a.put(b, Long.valueOf(uptimeMillis += l2));
        }
    }

    void c(long l) {
        int i;
        Object obj;
        boolean z;
        i = 0;
        while (i < this.b.size()) {
            obj = this.b.get(i);
            if ((a.b)obj == null) {
            } else {
            }
            if (f((a.b)obj, SystemClock.uptimeMillis())) {
            }
            i++;
            obj.a(l);
        }
        b();
    }

    d.k.a.a.c e() {
        d.k.a.a.c dVar;
        d.k.a.a.a aVar;
        if (this.d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                dVar = new a.e(this.c);
                this.d = dVar;
            } else {
                dVar = new a.d(this.c);
                this.d = dVar;
            }
        }
        return this.d;
    }

    public void g(d.k.a.a.b a$b) {
        ArrayList list;
        int i;
        int obj3;
        this.a.remove(b);
        obj3 = this.b.indexOf(b);
        if (obj3 >= 0) {
            this.b.set(obj3, 0);
            this.f = true;
        }
    }
}
