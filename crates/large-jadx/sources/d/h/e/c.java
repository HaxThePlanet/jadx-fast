package d.h.e;

import java.util.ArrayList;

/* compiled from: Animator.java */
/* loaded from: classes.dex */
public abstract class c implements java.lang.Cloneable {

    ArrayList<c.a> a = null;
    ArrayList<c.b> b = null;
    ArrayList<c.c> c = null;
    boolean v = false;

    public interface a {
        default void b(c cVar, boolean z) {
            e(cVar);
        }

        default void f(c cVar, boolean z) {
            a(cVar);
        }

        void a(c cVar);

        void c(c cVar);

        void e(c cVar);

        void g(c cVar);
    }

    public interface b {
        void d(c cVar);
    }

    public interface c {
        void a(c cVar);
    }
    public c() {
        super();
    }

    static void b(b.b bVar) {
        b.g().a(bVar);
    }

    static void o(b.b bVar) {
        b.g().k(bVar);
    }

    public void c(c.a aVar) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(aVar);
    }

    public c d() {
        ArrayList list;
        try {
            final Object clone = super.clone();
            if (this.a != null) {
                clone.a = new ArrayList(this.a);
            }
            if (this.b != null) {
                clone.b = new ArrayList(this.b);
            }
        } catch (java.lang.CloneNotSupportedException unused) {
            throw new AssertionError();
        }
        return clone;
    }

    public long h() {
        final long l = f();
        long l2 = -1L;
        if (l == l2) {
            return l2;
        }
        return g() + l;
    }

    public boolean l() {
        return k();
    }

    public void m() {
        int i = 0;
        Object item;
        if (l() && !this.v) {
            this.v = true;
            if (this.b != null) {
                Object clone = this.b.clone();
                z2 = clone instanceof ArrayList;
                if (clone instanceof ArrayList) {
                    i = 0;
                    while (i < clone.size()) {
                        (c.b)clone.get(i).d(this);
                        i = i + 1;
                    }
                }
            }
        }
    }

    public void p(c.a aVar) {
        if (this.a == null) {
            return;
        }
        this.a.remove(aVar);
        if (this.a.size() == 0) {
            this.a = null;
        }
    }

    void r() {
        throw new IllegalStateException("Reverse is not supported");
    }

    void w(boolean z) {
        if (z) {
            r();
        } else {
            v();
        }
    }

    public void cancel() {
    }

    public void e() {
    }

    public abstract long f();

    public abstract long g();

    boolean j() {
        return true;
    }

    public abstract boolean k();

    boolean n(long j) {
        return false;
    }

    public abstract c s(long j);

    public abstract void t(m mVar);

    void u(boolean z) {
    }

    public void v() {
    }
}
