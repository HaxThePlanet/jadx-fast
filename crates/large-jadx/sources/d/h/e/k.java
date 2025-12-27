package d.h.e;

import java.util.List;

/* compiled from: IntKeyframeSet.java */
/* loaded from: classes.dex */
class k extends o<Integer> implements p.b {
    k(n.b... bVarArr) {
        super(bVarArr);
    }

    @Override // d.h.e.o
    public int N0(float f) {
        Object item;
        int value;
        int i;
        int value2;
        int value3;
        float interpolation;
        float interpolation2;
        float interpolation3;
        int i10 = 0;
        i = 1;
        if (f <= 0) {
            Object item2 = this.c.get(i10);
            Object item4 = this.c.get(i);
            int i13 = item2.p();
            int i3 = item4.p();
            float f5 = item2.b();
            d.h.e.m mVar = item4.c();
            if (mVar != null) {
                interpolation = mVar.getInterpolation(f);
            }
            float f17 = (interpolation - f5) / (item4.b() - f5);
            if (this.v == null) {
                i3 = i3 - i13;
                f2 = (float)i3;
                i5 = (int)(f17 * f2);
                value2 = i13 + i5;
            } else {
                value2 = (Integer)this.v.evaluate(f17, Integer.valueOf(i13), Integer.valueOf(i3)).intValue();
            }
            return value2;
        }
        if (f >= 1065353216) {
            Object item3 = this.c.get(this.a - 2);
            Object item5 = this.c.get(this.a - i);
            int i15 = item3.p();
            int i4 = item5.p();
            float f6 = item3.b();
            d.h.e.m mVar2 = item5.c();
            if (mVar2 != null) {
                interpolation3 = mVar2.getInterpolation(f);
            }
            float f22 = (interpolation3 - f6) / (item5.b() - f6);
            if (this.v == null) {
                i4 = i4 - i15;
                f3 = (float)i4;
                i6 = (int)(f22 * f3);
                value3 = i15 + i6;
            } else {
                value3 = (Integer)this.v.evaluate(f22, Integer.valueOf(i15), Integer.valueOf(i4)).intValue();
            }
            return value3;
        }
        item = this.c.get(i10);
        while (this.c < this.a) {
            item = this.c.get(i);
            float f12 = item.b();
            if (f < f12) {
                d.h.e.m mVar3 = item.c();
                interpolation2 = (f - item.b()) / (item.b() - item.b());
                int i9 = item.p();
                int i14 = item.p();
            }
        }
        return (Integer)(n)this.c.get(i16 - i).d().intValue();
    }

    @Override // d.h.e.o
    public k c() {
        int i = 0;
        final int size = this.c.size();
        final d.h.e.n.b[] arr = new n.b[size];
        i = 0;
        while (i < size) {
            arr[i] = (n.b)(n)this.c.get(i).a();
            i = i + 1;
        }
        return new k(arr);
    }

    @Override // d.h.e.o
    public Integer d(float f) {
        return Integer.valueOf(N0(f));
    }
}
