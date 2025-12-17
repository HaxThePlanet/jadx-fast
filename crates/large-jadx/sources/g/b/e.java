package g.b;

import j.a.a;

/* loaded from: classes2.dex */
public final class e<T>  implements a<T> {

    private static final Object c;
    private volatile a<T> a;
    private volatile Object b;
    static {
        Object object = new Object();
        e.c = object;
    }

    private e(a<T> a) {
        super();
        this.b = e.c;
        this.a = a;
    }

    public static <P extends a<T>, T> a<T> a(P p) {
        boolean z;
        if (!p instanceof e && p instanceof a) {
            if (p instanceof a) {
            }
            d.b(p);
            e eVar = new e((a)p);
            return eVar;
        }
        return p;
    }

    public T get() {
        Object obj;
        Object obj2;
        if (this.b == e.c) {
            a aVar = this.a;
            if (aVar == null) {
                obj = this.b;
            } else {
                this.b = aVar.get();
                this.a = 0;
            }
        }
        return obj;
    }
}
