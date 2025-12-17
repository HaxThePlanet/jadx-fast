package d.f.a.m;

import d.f.a.m.m.i;
import d.f.a.m.m.o;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class i extends d.f.a.m.e implements d.f.a.m.h {

    public d.f.a.m.e[] u0;
    public int v0 = 0;
    public i() {
        super();
        this.u0 = new e[4];
        int i2 = 0;
    }

    @Override // d.f.a.m.e
    public void a() {
        this.v0 = 0;
        Arrays.fill(this.u0, 0);
    }

    @Override // d.f.a.m.e
    public void b(d.f.a.m.e e) {
        int copyOf;
        d.f.a.m.e[] objArr;
        int i;
        int length;
        if (e != this) {
            if (e == null) {
            } else {
                d.f.a.m.e[] objArr2 = this.u0;
                if (i2++ > objArr2.length) {
                    this.u0 = (e[])Arrays.copyOf(objArr2, length2 *= 2);
                }
                int i4 = this.v0;
                this.u0[i4] = e;
                this.v0 = i4++;
            }
        }
    }

    @Override // d.f.a.m.e
    public void c(d.f.a.m.f f) {
    }

    public void i1(ArrayList<o> arrayList, int i2, o o3) {
        int i;
        int i3;
        d.f.a.m.e eVar;
        i3 = i;
        while (i3 < this.v0) {
            o3.a(this.u0[i3]);
            i3++;
        }
        while (i < this.v0) {
            i.a(this.u0[i], i2, arrayList, o3);
            i++;
        }
    }

    @Override // d.f.a.m.e
    public int j1(int i) {
        int i2;
        d.f.a.m.e eVar;
        int i4;
        int i3;
        i2 = 0;
        i4 = -1;
        while (i2 < this.v0) {
            eVar = this.u0[i2];
            i2++;
            i4 = -1;
            eVar = eVar.s0;
            i3 = eVar.r0;
        }
        return i4;
    }
}
