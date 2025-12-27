package o.b;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: CombinedMiddleware.java */
/* loaded from: classes3.dex */
class b implements m {

    private final Collection<m> a = null;

    class a implements e {

        final /* synthetic */ j a;
        final /* synthetic */ f b;
        final /* synthetic */ e c;
        final /* synthetic */ Iterator d;
        final /* synthetic */ b e;
        a(j jVar, f fVar, e eVar, Iterator it) {
            this.e = bVar;
            this.a = jVar;
            this.b = fVar;
            this.c = eVar;
            this.d = it;
            super();
        }

        public void a(a<?> aVar) {
            this.e.b(aVar, this.a, this.b, this.c, this.d);
        }
    }
    b(Collection<m> collection) {
        int size;
        super();
        if (collection == null || collection.size() == 0) {
            int i = 0;
        }
    }

    static /* synthetic */ void a(b bVar, a aVar, j jVar, f fVar, e eVar, Iterator it) {
        bVar.b(aVar, jVar, fVar, eVar, it);
    }

    private void b(a<?> aVar, j jVar, f fVar, e eVar, Iterator<m> iterator) {
        if (iterator.hasNext()) {
            b.a aVar2 = new b.a(this, jVar, fVar, eVar, iterator);
            (m)iterator.next().onAction(aVar, jVar, fVar, aVar2);
        } else {
            eVar.a(aVar);
        }
    }

    public void onAction(a<?> aVar, j jVar, f fVar, e eVar) {
        if (this.a != null) {
            this.b(aVar, jVar, fVar, eVar, this.a.iterator());
        } else {
            eVar.a(aVar);
        }
    }
}
