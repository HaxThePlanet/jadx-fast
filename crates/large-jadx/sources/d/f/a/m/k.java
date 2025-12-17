package d.f.a.m;

import java.util.HashSet;

/* loaded from: classes.dex */
public class k extends d.f.a.m.i {

    private boolean w0 = false;
    public k() {
        super();
        int i = 0;
    }

    @Override // d.f.a.m.i
    public void c(d.f.a.m.f f) {
        k1();
    }

    @Override // d.f.a.m.i
    public void k1() {
        int i2;
        d.f.a.m.e eVar;
        int i;
        i2 = 0;
        while (i2 < this.v0) {
            eVar = this.u0[i2];
            if (eVar != null) {
            }
            i2++;
            eVar.L0(true);
        }
    }

    public boolean l1(HashSet<d.f.a.m.e> hashSet) {
        int i;
        boolean contains;
        final int i2 = 0;
        i = i2;
        while (i < this.v0) {
            i++;
        }
        return i2;
    }

    @Override // d.f.a.m.i
    public boolean m1() {
        return this.w0;
    }
}
