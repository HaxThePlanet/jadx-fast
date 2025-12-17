package o.b;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class d implements o.b.t {

    private final Collection<o.b.t> a;
    private d(Collection<o.b.t> collection) {
        super();
        this.a = collection;
    }

    public static o.b.t d(o.b.t... tArr) {
        d dVar = new d(Arrays.asList(tArr));
        return dVar;
    }

    @Override // o.b.t
    public void a() {
        Object next;
        Iterator iterator = this.a.iterator();
        for (t next : iterator) {
            next.a();
        }
    }

    @Override // o.b.t
    public void b() {
        Object next;
        Iterator iterator = this.a.iterator();
        for (t next : iterator) {
            next.b();
        }
    }

    @Override // o.b.t
    public void c() {
        Object next;
        Iterator iterator = this.a.iterator();
        for (t next : iterator) {
            next.c();
        }
    }
}
