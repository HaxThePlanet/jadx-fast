package androidx.recyclerview.widget;

import d.e.d;
import d.e.g;
import d.h.k.f;
import d.h.k.g;

/* loaded from: classes.dex */
class b0 {

    final g<androidx.recyclerview.widget.RecyclerView.e0, androidx.recyclerview.widget.b0.a> a;
    final d<androidx.recyclerview.widget.RecyclerView.e0> b;

    static class a {

        static f<androidx.recyclerview.widget.b0.a> d;
        int a;
        androidx.recyclerview.widget.RecyclerView.m.c b;
        androidx.recyclerview.widget.RecyclerView.m.c c;
        static {
            g gVar = new g(20);
            b0.a.d = gVar;
        }

        static void a() {
            while (b0.a.d.b() != null) {
            }
        }

        static androidx.recyclerview.widget.b0.a b() {
            Object aVar;
            if ((b0.a)b0.a.d.b() == null) {
                aVar = new b0.a();
            }
            return aVar;
        }

        static void c(androidx.recyclerview.widget.b0.a b0$a) {
            a.a = 0;
            int i2 = 0;
            a.b = i2;
            a.c = i2;
            b0.a.d.a(a);
        }
    }

    interface b {
        public abstract void a(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0);

        public abstract void b(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3);

        public abstract void c(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3);

        public abstract void d(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c3);
    }
    b0() {
        super();
        g gVar = new g();
        this.a = gVar;
        d dVar = new d();
        this.b = dVar;
    }

    private androidx.recyclerview.widget.RecyclerView.m.c l(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2) {
        int i;
        int i5;
        int i4;
        int i3;
        androidx.recyclerview.widget.RecyclerView.m.c obj6;
        int obj5 = this.a.g(e0);
        int i6 = 0;
        if (obj5 < 0) {
            return i6;
        }
        Object obj = this.a.n(obj5);
        i4 = obj.a;
        if ((b0.a)obj != null && i4 & i2 != 0) {
            i4 = obj.a;
            if (i4 & i2 != 0) {
                i7 &= i4;
                obj.a = i8;
                if (i2 == 4) {
                    obj6 = obj.b;
                    if (i8 &= 12 == 0) {
                        this.a.l(obj5);
                        b0.a.c((b0.a)obj);
                    }
                    return obj6;
                } else {
                    if (i2 != 8) {
                    } else {
                        obj6 = obj.c;
                    }
                }
                obj5 = new IllegalArgumentException("Must provide flag PRE or POST");
                throw obj5;
            }
        }
        return i6;
    }

    void a(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2) {
        Object obj;
        g gVar;
        if ((b0.a)this.a.get(e0) == null) {
            this.a.put(e0, b0.a.b());
        }
        obj.a = obj3 |= 2;
        obj.b = c2;
    }

    void b(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        Object obj;
        g gVar;
        if ((b0.a)this.a.get(e0) == null) {
            this.a.put(e0, b0.a.b());
        }
        obj.a = obj3 |= 1;
    }

    void c(long l, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02) {
        this.b.k(l, e02);
    }

    void d(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2) {
        Object obj;
        g gVar;
        if ((b0.a)this.a.get(e0) == null) {
            this.a.put(e0, b0.a.b());
        }
        obj.c = c2;
        obj.a = obj3 |= 8;
    }

    void e(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.m.c recyclerView$m$c2) {
        Object obj;
        g gVar;
        if ((b0.a)this.a.get(e0) == null) {
            this.a.put(e0, b0.a.b());
        }
        obj.b = c2;
        obj.a = obj3 |= 4;
    }

    void f() {
        this.a.clear();
        this.b.b();
    }

    androidx.recyclerview.widget.RecyclerView.e0 g(long l) {
        return (RecyclerView.e0)this.b.f(l);
    }

    boolean h(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        int i;
        Object obj2;
        obj2 = this.a.get(e0);
        if ((b0.a)obj2 != null && obj2 &= i != 0) {
            if (obj2 &= i != 0) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    boolean i(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        Object obj2;
        obj2 = this.a.get(e0);
        if ((b0.a)obj2 != null && obj2 &= 4 != 0) {
            obj2 = obj2 &= 4 != 0 ? 1 : 0;
        } else {
        }
        return obj2;
    }

    void j() {
        b0.a.a();
    }

    public void k(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        p(e0);
    }

    androidx.recyclerview.widget.RecyclerView.m.c m(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        return l(e0, 8);
    }

    androidx.recyclerview.widget.RecyclerView.m.c n(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        return l(e0, 4);
    }

    void o(androidx.recyclerview.widget.b0.b b0$b) {
        int i;
        Object obj;
        Object obj2;
        int i4;
        int i2;
        int i3;
        size--;
        while (i >= 0) {
            obj = this.a.j(i);
            obj2 = this.a.l(i);
            i4 = obj2.a;
            if (i4 & 3 == 3) {
            } else {
            }
            if (i4 & 1 != 0) {
            } else {
            }
            if (i4 & 14 == 14) {
            } else {
            }
            if (i4 & 12 == 12) {
            } else {
            }
            if (i4 & 4 != 0) {
            } else {
            }
            if (i4 &= 8 != 0) {
            }
            b0.a.c((b0.a)obj2);
            i--;
            b.b((RecyclerView.e0)obj, obj2.b, obj2.c);
            b.c(obj, obj2.b, 0);
            b.d(obj, obj2.b, obj2.c);
            b.b(obj, obj2.b, obj2.c);
            i4 = obj2.b;
            if (i4 == null) {
            } else {
            }
            b.c(obj, i4, obj2.c);
            b.a(obj);
            b.a(obj);
        }
    }

    void p(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        final Object obj2 = this.a.get(e0);
        if ((b0.a)obj2 == null) {
        }
        obj2.a = i &= -2;
    }

    void q(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        int i;
        Object obj;
        i2--;
        while (i >= 0) {
            if (e0 == this.b.o(i)) {
                break;
            } else {
            }
            i--;
        }
        final Object obj3 = this.a.remove(e0);
        if ((b0.a)obj3 != null) {
            b0.a.c((b0.a)obj3);
        }
    }
}
