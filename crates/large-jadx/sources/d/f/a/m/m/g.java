package d.f.a.m.m;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class g extends d.f.a.m.m.f {

    public int m;
    public g(d.f.a.m.m.p p) {
        d.f.a.m.m.f.a obj1;
        super(p);
        if (p instanceof l) {
            this.e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // d.f.a.m.m.f
    public void d(int i) {
        int next;
        if (this.j) {
        }
        this.j = true;
        this.g = i;
        Iterator obj2 = this.k.iterator();
        for (d next : obj2) {
            next.a(next);
        }
    }
}
