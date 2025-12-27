package d.k.a;

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
class a {

    public static final java.lang.ThreadLocal<a> g = new ThreadLocal<>();
    private final g<a.b, Long> a = new g<>();
    final ArrayList<a.b> b = new ArrayList<>();
    private final a.a c = new a$a();
    private a.c d;
    long e = 0;
    private boolean f = false;

    class a {

        final /* synthetic */ a a;
        a() {
            this.a = aVar;
            super();
        }

        void a() {
            this.a.e = SystemClock.uptimeMillis();
            this.a.c(aVar2.e);
            if (this.a.b.size() > 0) {
                this.a.e().a();
            }
        }
    }

    interface b {
        boolean a(long j);
    }

    static abstract class c {

        final a.a a;
        c(a.a aVar) {
            super();
            this.a = aVar;
        }

        abstract void a();
    }

    private static class d extends a.c {

        private final Runnable b = new a$d$a();
        private final Handler c = new Handler();
        long d = -1;
        d(a.a aVar) {
            super(aVar);
            d.k.a.a.d.a aVar2 = new a.d.a(this);
            Handler handler = new Handler(Looper.myLooper());
        }

        @Override // d.k.a.a$c
        void a() {
            this.c.postDelayed(this.b, Math.max(10L - (SystemClock.uptimeMillis() - this.d), 0L));
        }
    }

    private static class e extends a.c {

        private final Choreographer b;
        private final Choreographer.FrameCallback c = new a$e$a();
        e(a.a aVar) {
            super(aVar);
            this.b = Choreographer.getInstance();
            d.k.a.a.e.a aVar2 = new a.e.a(this);
        }

        @Override // d.k.a.a$c
        void a() {
            this.b.postFrameCallback(this.c);
        }
    }

    a() {
        super();
        g gVar = new g();
        ArrayList arrayList = new ArrayList();
        d.k.a.a.a aVar = new a.a(this);
    }

    private void b() {
        int i;
        Object item;
        if (this.f) {
            i = this.b.size() - 1;
            while (this.f >= 0) {
                i = i - 1;
            }
            boolean z = false;
            this.f = z;
        }
    }

    public static a d() {
        java.lang.ThreadLocal threadLocal = a.g;
        if (threadLocal.get() == null) {
            a.g.set(new a());
        }
        return (a)a.g.get();
    }

    private boolean f(a.b bVar, long j) {
        Object obj = this.a.get(bVar);
        final boolean z = true;
        if (obj == null) {
            return true;
        }
        final long value = obj.longValue();
        if (value < j) {
            this.a.remove(bVar);
            return true;
        }
        return false;
    }

    public void a(a.b bVar, long j) {
        if (this.b.size() == 0) {
            e().a();
        }
        if (!this.b.contains(bVar)) {
            this.b.add(bVar);
        }
        if (j > 0) {
            l = SystemClock.uptimeMillis() + j;
            this.a.put(bVar, Long.valueOf(l));
        }
    }

    void c(long j) {
        int i = 0;
        boolean z;
        i = 0;
        while (i < this.b.size()) {
            Object item = this.b.get(i);
            i = i + 1;
        }
        b();
    }

    a.c e() {
        if (this.d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.d = new a.e(this.c);
            } else {
                this.d = new a.d(this.c);
            }
        }
        return this.d;
    }

    public void g(a.b bVar) {
        this.a.remove(bVar);
        int indexOf = this.b.indexOf(bVar);
        if (indexOf >= 0) {
            Object obj = null;
            this.b.set(indexOf, obj);
            this.f = true;
        }
    }
}
