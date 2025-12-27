package o.b;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: CombinedSubscription.java */
/* loaded from: classes3.dex */
public class d implements t {

    private final Collection<t> a;
    private d(Collection<t> collection) {
        super();
        this.a = collection;
    }

    public static t d(t... tVarArr) {
        return new d(Arrays.asList(tVarArr));
    }

    public void a() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            (t)it.next().a();
        }
    }

    public void b() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            (t)it.next().b();
        }
    }

    public void c() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            (t)it.next().c();
        }
    }
}
