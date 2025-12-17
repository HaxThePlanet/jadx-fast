package o.b;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
class l {

    private static final Logger a;

    static class a {
    }

    interface c {
        public abstract String a();

        public abstract void b(o.b.o o, o.b.o o2, boolean z3);
    }

    private static class b implements o.b.l.c {

        private final Class<E> a;
        private final o.b.k<E> b;
        private final o.b.h<E> c;
        private b(Class<E> class, o.b.k<E> k2, o.b.h<E> h3) {
            super();
            this.a = class;
            this.b = k2;
            this.c = h3;
        }

        b(Class class, o.b.k k2, o.b.h h3, o.b.l.a l$a4) {
            super(class, k2, h3);
        }

        @Override // o.b.l$c
        public String a() {
            return o.e(this.a);
        }

        @Override // o.b.l$c
        public void b(o.b.o o, o.b.o o2, boolean z3) {
            int i;
            Class cls;
            Object obj3;
            if (o != null) {
                obj3 = o.b(this.a);
            } else {
                obj3 = i;
            }
            if (o2 != null) {
                i = o2.b(this.a);
            }
            l.a(i, obj3, this.c, this.b, z3);
        }
    }

    private static class d implements o.b.l.c {

        private final o.b.k<E> a;
        private final o.b.p<E> b;
        private final o.b.h<o.b.o> c;
        private d(o.b.k<E> k, o.b.p<E> p2, o.b.h<o.b.o> h3) {
            super();
            this.a = k;
            this.b = p2;
            this.c = h3;
        }

        d(o.b.k k, o.b.p p2, o.b.h h3, o.b.l.a l$a4) {
            super(k, p2, h3);
        }

        @Override // o.b.l$c
        public String a() {
            return null;
        }

        @Override // o.b.l$c
        public void b(o.b.o o, o.b.o o2, boolean z3) {
            Object obj1;
            Object obj2;
            o.b.h obj3;
            if (z3 != null) {
                if (o2 == null) {
                    obj1 = this.b.selectData(o2);
                    if (o != null && o2 != null && this.c.a(o, o2) && obj1 != null) {
                        if (o2 != null) {
                            if (this.c.a(o, o2)) {
                                obj1 = this.b.selectData(o2);
                                if (obj1 != null) {
                                    this.a.update(obj1);
                                }
                            }
                        }
                    }
                } else {
                }
            } else {
            }
        }
    }
    static {
        l.a = Logger.getLogger("Suas");
    }

    static void a(Object object, Object object2, o.b.h h3, o.b.k k4, boolean z5) {
        l.d(object, object2, h3, k4, z5);
    }

    static <E> o.b.l.c b(Class<E> class, o.b.h<E> h2, o.b.k<E> k3) {
        l.b bVar = new l.b(class, k3, h2, 0);
        return bVar;
    }

    static <E> o.b.l.c c(o.b.p<E> p, o.b.h<o.b.o> h2, o.b.k<E> k3) {
        l.d dVar = new l.d(k3, p, h2, 0);
        return dVar;
    }

    private static <E> void d(E e, E e2, o.b.h<E> h3, o.b.k<E> k4, boolean z5) {
        Object obj0;
        Level obj1;
        String obj2;
        if (e != null && z5) {
            if (z5) {
                k4.update(e);
            } else {
                if (e != null && e2 != null) {
                    if (e2 != null) {
                        if (h3.a(e2, e)) {
                            k4.update(e);
                        }
                    } else {
                        l.a.log(Level.WARNING, "Requested stateKey not found in store");
                    }
                } else {
                }
            }
        } else {
        }
    }
}
