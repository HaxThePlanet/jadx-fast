package d.h.e;

import java.util.List;

/* loaded from: classes.dex */
class h extends d.h.e.o<Float> implements d.h.e.p.a {
    h(d.h.e.n.a... n$aArr) {
        super(aArr);
    }

    @Override // d.h.e.o
    public Object I1(float f) {
        return d(f);
    }

    @Override // d.h.e.o
    public d.h.e.h c() {
        int i;
        d.h.e.n nVar;
        List list = this.c;
        final int size = list.size();
        final d.h.e.n.a[] arr = new n.a[size];
        i = 0;
        while (i < size) {
            arr[i] = (n.a)(n)list.get(i).a();
            i++;
        }
        h hVar = new h(arr);
        return hVar;
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
    public Float d(float f) {
        return Float.valueOf(n1(f));
    }

    @Override // d.h.e.o
    public float n1(float f) {
        Object obj;
        int floatValue2;
        Object valueOf3;
        int i;
        Object valueOf2;
        int floatValue3;
        int valueOf;
        int floatValue;
        int f3;
        Object obj2;
        int f2;
        int cmp;
        int obj6;
        int i4 = 0;
        int i7 = 1;
        Object obj3 = this.c.get(i4);
        Object obj5 = this.c.get(i7);
        float f7 = (n.a)obj3.p();
        f3 = (n.a)obj5.p();
        float f4 = obj3.b();
        valueOf3 = obj5.c();
        if (Float.compare(f, i2) <= 0 && valueOf3 != null) {
            obj3 = this.c.get(i4);
            obj5 = this.c.get(i7);
            f7 = (n.a)obj3.p();
            f3 = (n.a)obj5.p();
            f4 = obj3.b();
            valueOf3 = obj5.c();
            if (valueOf3 != null) {
                obj6 = valueOf3.getInterpolation(f);
            }
            obj6 /= i13;
            d.h.e.u uVar = this.v;
            if (uVar == null) {
                f7 += obj6;
            } else {
                floatValue3 = (Float)uVar.evaluate(obj6, Float.valueOf(f7), Float.valueOf(f3)).floatValue();
            }
            return floatValue3;
        }
        Object obj4 = this.c.get(i5 += -2);
        obj6 = this.c.get(i11 -= i7);
        float f11 = (n.a)obj4.p();
        f2 = (n.a)obj6.p();
        float f6 = obj4.b();
        valueOf2 = obj6.c();
        if (Float.compare(f, i3) >= 0 && valueOf2 != null) {
            obj4 = this.c.get(i5 += -2);
            obj6 = this.c.get(i11 -= i7);
            f11 = (n.a)obj4.p();
            f2 = (n.a)obj6.p();
            f6 = obj4.b();
            valueOf2 = obj6.c();
            if (valueOf2 != null) {
                obj6 = valueOf2.getInterpolation(f);
            }
            obj6 /= i14;
            d.h.e.u uVar2 = this.v;
            if (uVar2 == null) {
                f11 += obj6;
            } else {
                floatValue = (Float)uVar2.evaluate(obj6, Float.valueOf(f11), Float.valueOf(f2)).floatValue();
            }
            return floatValue;
        }
        obj = this.c.get(i4);
        i = i7;
        int i9 = this.a;
        while (i < i9) {
            obj2 = this.c.get(i);
            i++;
            obj = obj2;
            i9 = this.a;
        }
        return (Float)(n)this.c.get(i9 -= i7).d().floatValue();
    }
}
