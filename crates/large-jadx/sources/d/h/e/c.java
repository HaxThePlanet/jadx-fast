package d.h.e;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class c implements java.lang.Cloneable {

    ArrayList<d.h.e.c.a> a = null;
    ArrayList<d.h.e.c.b> b = null;
    ArrayList<d.h.e.c.c> c = null;
    boolean v = false;

    public interface a {
        public abstract void a(d.h.e.c c);

        public void b(d.h.e.c c, boolean z2) {
            e(c);
        }

        public abstract void c(d.h.e.c c);

        public abstract void e(d.h.e.c c);

        public void f(d.h.e.c c, boolean z2) {
            a(c);
        }

        public abstract void g(d.h.e.c c);
    }

    public interface b {
        public abstract void d(d.h.e.c c);
    }

    public interface c {
        public abstract void a(d.h.e.c c);
    }
    public c() {
        super();
        int i = 0;
        int i2 = 0;
    }

    static void b(d.h.e.b.b b$b) {
        b.g().a(b);
    }

    static void o(d.h.e.b.b b$b) {
        b.g().k(b);
    }

    @Override // java.lang.Cloneable
    public void c(d.h.e.c.a c$a) {
        ArrayList arrayList;
        if (this.a == null) {
            arrayList = new ArrayList();
            this.a = arrayList;
        }
        this.a.add(a);
    }

    @Override // java.lang.Cloneable
    public void cancel() {
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return d();
    }

    @Override // java.lang.Cloneable
    public d.h.e.c d() {
        ArrayList arrayList2;
        ArrayList arrayList;
        ArrayList list;
        try {
            final Object clone = super.clone();
            if (this.a != null) {
            }
            arrayList2 = new ArrayList(this.a);
            clone.a = arrayList2;
            if (this.b != null) {
            }
            arrayList = new ArrayList(this.b);
            clone.b = arrayList;
            return (c)clone;
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
    }

    @Override // java.lang.Cloneable
    public void e() {
    }

    @Override // java.lang.Cloneable
    public abstract long f();

    @Override // java.lang.Cloneable
    public abstract long g();

    @Override // java.lang.Cloneable
    public long h() {
        final long l = f();
        int i = -1;
        if (Long.compare(l, i) == 0) {
            return i;
        }
        return l2 += l;
    }

    @Override // java.lang.Cloneable
    boolean j() {
        return 1;
    }

    @Override // java.lang.Cloneable
    public abstract boolean k();

    @Override // java.lang.Cloneable
    public boolean l() {
        return k();
    }

    @Override // java.lang.Cloneable
    public void m() {
        boolean clone;
        boolean size;
        int i;
        Object obj;
        this.v = true;
        clone = this.b;
        clone = clone.clone();
        if (l() && !this.v && clone != null && clone instanceof ArrayList != null) {
            if (!this.v) {
                this.v = true;
                clone = this.b;
                if (clone != null) {
                    clone = clone.clone();
                    if (clone instanceof ArrayList != null) {
                        i = 0;
                        while (i < (ArrayList)clone.size()) {
                            (c.b)clone.get(i).d(this);
                            i++;
                        }
                    }
                }
            }
        }
    }

    @Override // java.lang.Cloneable
    boolean n(long l) {
        return 0;
    }

    @Override // java.lang.Cloneable
    public void p(d.h.e.c.a c$a) {
        int obj2;
        final ArrayList list = this.a;
        if (list == null) {
        }
        list.remove(a);
        if (this.a.size() == 0) {
            this.a = 0;
        }
    }

    @Override // java.lang.Cloneable
    void r() {
        IllegalStateException illegalStateException = new IllegalStateException("Reverse is not supported");
        throw illegalStateException;
    }

    @Override // java.lang.Cloneable
    public abstract d.h.e.c s(long l);

    @Override // java.lang.Cloneable
    public abstract void t(d.h.e.m m);

    @Override // java.lang.Cloneable
    void u(boolean z) {
    }

    @Override // java.lang.Cloneable
    public void v() {
    }

    @Override // java.lang.Cloneable
    void w(boolean z) {
        if (z) {
            r();
        } else {
            v();
        }
    }
}
