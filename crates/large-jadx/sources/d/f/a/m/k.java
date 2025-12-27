package d.f.a.m;

import java.util.HashSet;

/* compiled from: VirtualLayout.java */
/* loaded from: classes.dex */
public class k extends i {

    private boolean w0 = false;
    public k() {
        super();
    }

    @Override // d.f.a.m.i
    public void c(f fVar) {
        k1();
    }

    @Override // d.f.a.m.i
    public void k1() {
        int i = 0;
        boolean z;
        i = 0;
        while (i < this.v0) {
            d.f.a.m.e eVar = this.u0[i];
            i = i + 1;
        }
    }

    @Override // d.f.a.m.i
    public boolean l1(HashSet<e> hashSet) {
        int i;
        i = 0;
        while (i < this.v0) {
            if (hashSet.contains(this.u0[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // d.f.a.m.i
    public boolean m1() {
        return this.w0;
    }
}
