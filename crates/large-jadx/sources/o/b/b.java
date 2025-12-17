package o.b;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
class b implements o.b.m {

    private final Collection<o.b.m> a = null;

    class a implements o.b.e {

        final o.b.j a;
        final o.b.f b;
        final o.b.e c;
        final Iterator d;
        final o.b.b e;
        a(o.b.b b, o.b.j j2, o.b.f f3, o.b.e e4, Iterator iterator5) {
            this.e = b;
            this.a = j2;
            this.b = f3;
            this.c = e4;
            this.d = iterator5;
            super();
        }

        public void a(o.b.a<?> a) {
            b.a(this.e, a, this.a, this.b, this.c, this.d);
        }
    }
    b(Collection<o.b.m> collection) {
        int size;
        Collection obj2;
        super();
        if (collection != null) {
            if (collection.size() == 0) {
                obj2 = 0;
            } else {
                this.a = collection;
            }
        } else {
        }
    }

    static void a(o.b.b b, o.b.a a2, o.b.j j3, o.b.f f4, o.b.e e5, Iterator iterator6) {
        b.b(a2, j3, f4, e5, iterator6);
    }

    private void b(o.b.a<?> a, o.b.j j2, o.b.f f3, o.b.e e4, Iterator<o.b.m> iterator5) {
        Object next;
        o.b.b.a aVar;
        o.b.b bVar;
        o.b.j jVar;
        o.b.f fVar;
        o.b.e eVar;
        Iterator it;
        o.b.b.a aVar2;
        if (iterator5.hasNext()) {
            super(this, j2, f3, e4, iterator5);
            (m)iterator5.next().onAction(a, j2, f3, aVar2);
        } else {
            e4.a(a);
        }
    }

    public void onAction(o.b.a<?> a, o.b.j j2, o.b.f f3, o.b.e e4) {
        Object obj;
        o.b.a aVar;
        o.b.j jVar;
        o.b.f fVar;
        o.b.e eVar;
        Iterator iterator;
        final Collection collection = this.a;
        if (collection != null) {
            this.b(a, j2, f3, e4, collection.iterator());
        } else {
            e4.a(a);
        }
    }
}
