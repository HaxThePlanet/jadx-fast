package d.h.e;

import java.util.List;

/* loaded from: classes.dex */
class k extends d.h.e.o<Integer> implements d.h.e.p.b {
    k(d.h.e.n.b... n$bArr) {
        super(bArr);
    }

    @Override // d.h.e.o
    public Object I1(float f) {
        return d(f);
    }

    @Override // d.h.e.o
    public int N0(float f) {
        float uVar2;
        Object obj2;
        int intValue3;
        float uVar;
        Object valueOf2;
        int i3;
        float uVar3;
        Object valueOf;
        int intValue;
        int valueOf3;
        int intValue2;
        int i;
        Object obj;
        int i2;
        int cmp;
        int obj6;
        int i7 = 0;
        int i10 = 1;
        Object obj3 = this.c.get(i7);
        Object obj5 = this.c.get(i10);
        int i11 = (n.b)obj3.p();
        i = (n.b)obj5.p();
        float f2 = obj3.b();
        valueOf2 = obj5.c();
        if (Float.compare(f, i4) <= 0 && valueOf2 != null) {
            obj3 = this.c.get(i7);
            obj5 = this.c.get(i10);
            i11 = (n.b)obj3.p();
            i = (n.b)obj5.p();
            f2 = obj3.b();
            valueOf2 = obj5.c();
            if (valueOf2 != null) {
                obj6 = valueOf2.getInterpolation(f);
            }
            obj6 /= i19;
            uVar2 = this.v;
            if (uVar2 == null) {
                i11 += obj6;
            } else {
                intValue = (Integer)uVar2.evaluate(obj6, Integer.valueOf(i11), Integer.valueOf(i)).intValue();
            }
            return intValue;
        }
        Object obj4 = this.c.get(i8 += -2);
        obj6 = this.c.get(i17 -= i10);
        int i14 = (n.b)obj4.p();
        i2 = (n.b)obj6.p();
        float f3 = obj4.b();
        valueOf = obj6.c();
        if (Float.compare(f, i5) >= 0 && valueOf != null) {
            obj4 = this.c.get(i8 += -2);
            obj6 = this.c.get(i17 -= i10);
            i14 = (n.b)obj4.p();
            i2 = (n.b)obj6.p();
            f3 = obj4.b();
            valueOf = obj6.c();
            if (valueOf != null) {
                obj6 = valueOf.getInterpolation(f);
            }
            obj6 /= i20;
            uVar = this.v;
            if (uVar == null) {
                i14 += obj6;
            } else {
                intValue2 = (Integer)uVar.evaluate(obj6, Integer.valueOf(i14), Integer.valueOf(i2)).intValue();
            }
            return intValue2;
        }
        obj2 = this.c.get(i7);
        i3 = i10;
        int i15 = this.a;
        while (i3 < i15) {
            obj = this.c.get(i3);
            i3++;
            obj2 = obj;
            i15 = this.a;
        }
        return (Integer)(n)this.c.get(i15 -= i10).d().intValue();
    }

    @Override // d.h.e.o
    public d.h.e.k c() {
        int i;
        d.h.e.n nVar;
        List list = this.c;
        final int size = list.size();
        final d.h.e.n.b[] arr = new n.b[size];
        i = 0;
        while (i < size) {
            arr[i] = (n.b)(n)list.get(i).a();
            i++;
        }
        k kVar = new k(arr);
        return kVar;
    }

    @Override // d.h.e.o
    public d.h.e.p clone() {
        return c();
    }

    @Override // d.h.e.o
    public Object clone() {
        return c();
    }

    @Override // d.h.e.o
    public Integer d(float f) {
        return Integer.valueOf(N0(f));
    }
}
