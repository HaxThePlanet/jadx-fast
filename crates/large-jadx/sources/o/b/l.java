package o.b;

import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Listeners.java */
/* loaded from: classes3.dex */
class l {

    private static final Logger a;

    static class a {
    }

    interface c {
        String a();

        void b(o oVar, o oVar2, boolean z);
    }

    private static class b<E> implements l.c {

        private final Class<E> a;
        private final k<E> b;
        private final h<E> c;
        /* synthetic */ b(Class cls, k kVar, h hVar, l.a aVar) {
            this(cls, kVar, hVar);
        }

        public String a() {
            return o.e(this.a);
        }

        public void b(o oVar, o oVar2, boolean z) {
            Object obj = null;
            Object obj2;
            if (oVar != null) {
                obj2 = oVar.b(this.a);
            } else {
            }
            if (oVar2 != null) {
                obj = oVar2.b(this.a);
            }
            l.d(obj, obj2, this.c, this.b, z);
        }

        private b(Class<E> cls, k<E> kVar, h<E> hVar) {
            super();
            this.a = cls;
            this.b = kVar;
            this.c = hVar;
        }
    }

    private static class d<E> implements l.c {

        private final k<E> a;
        private final p<E> b;
        private final h<o> c;
        /* synthetic */ d(k kVar, p pVar, h hVar, l.a aVar) {
            this(kVar, pVar, hVar);
        }

        public void b(o oVar, o oVar2, boolean z) {
            o.b.h hVar;
            if (!z || oVar2 == null) {
                if (oVar != null && oVar2 != null) {
                    if (this.c.a(oVar, oVar2)) {
                        Object data = this.b.selectData(oVar2);
                        if (data != null) {
                            this.a.update(data);
                        }
                    }
                }
            }
        }

        private d(k<E> kVar, p<E> pVar, h<o> hVar) {
            super();
            this.a = kVar;
            this.b = pVar;
            this.c = hVar;
        }

        public String a() {
            return null;
        }
    }
    static {
        l.a = Logger.getLogger("Suas");
    }

    static /* synthetic */ void a(Object object, Object object2, h hVar, k kVar, boolean z) {
        l.d(object, object2, hVar, kVar, z);
    }

    static <E> l.c b(Class<E> cls, h<E> hVar, k<E> kVar) {
        return new l.b(cls, kVar, hVar, null);
    }

    static <E> l.c c(p<E> pVar, h<o> hVar, k<E> kVar) {
        return new l.d(kVar, pVar, hVar, null);
    }

    private static <E> void d(E e, E e2, h<E> hVar, k<E> kVar, boolean z) {
        if (e == null || !z) {
            if (e == null || e2 == null) {
                str = "Requested stateKey not found in store";
                l.a.log(Level.WARNING, str);
            } else {
                if (hVar.a(e2, e)) {
                    kVar.update(e);
                }
            }
        } else {
            kVar.update(e);
        }
    }
}
