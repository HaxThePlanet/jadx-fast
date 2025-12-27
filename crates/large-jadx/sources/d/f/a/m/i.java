package d.f.a.m;

import d.f.a.m.m.i;
import d.f.a.m.m.o;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: HelperWidget.java */
/* loaded from: classes.dex */
public class i extends e implements h {

    public e[] u0;
    public int v0 = 0;
    public i() {
        super();
        this.u0 = new e[4];
    }

    @Override // d.f.a.m.e
    public void a() {
        this.v0 = 0;
        Arrays.fill(this.u0, null);
    }

    @Override // d.f.a.m.e
    public void b(e eVar) {
    }

    @Override // d.f.a.m.e
    public void i1(ArrayList<o> arrayList, int i, o oVar) {
        i = 0;
        while (i < this.v0) {
            oVar.a(this.u0[i]);
            i = i + 1;
        }
        while (i < this.v0) {
            i.a(this.u0[i], i, arrayList, oVar);
            i = i + 1;
        }
    }

    @Override // d.f.a.m.e
    public int j1(int i) {
        int i2 = 0;
        d.f.a.m.e eVar;
        int i4 = 1;
        i2 = 0;
        int i3 = -1;
        while (i2 < this.v0) {
            eVar = this.u0[i2];
            i4 = 1;
            if (i == 1 && eVar.s0 != i3) {
            }
        }
        return i3;
    }

    @Override // d.f.a.m.e
    public void c(f fVar) {
    }
}
