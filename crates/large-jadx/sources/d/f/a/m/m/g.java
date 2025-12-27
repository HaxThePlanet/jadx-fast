package d.f.a.m.m;

import java.util.Iterator;
import java.util.List;

/* compiled from: DimensionDependency.java */
/* loaded from: classes.dex */
class g extends f {

    public int m;
    public g(p pVar) {
        super(pVar);
        if (pVar instanceof l) {
            this.e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // d.f.a.m.m.f
    public void d(int i) {
        if (this.j) {
            return;
        }
        boolean z = true;
        this.j = z;
        this.g = i;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            item.a(item);
        }
    }
}
