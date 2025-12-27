package d.h.e;

import java.util.List;

/* compiled from: FloatKeyframeSet.java */
/* loaded from: classes.dex */
class h extends o<Float> implements p.a {
    h(n.a... aVarArr) {
        super(aVarArr);
    }

    @Override // d.h.e.o
    public h c() {
        int i = 0;
        final int size = this.c.size();
        final d.h.e.n.a[] arr = new n.a[size];
        i = 0;
        while (i < size) {
            arr[i] = (n.a)(n)this.c.get(i).a();
            i = i + 1;
        }
        return new h(arr);
    }

    @Override // d.h.e.o
    public Float d(float f) {
        return Float.valueOf(n1(f));
    }

    @Override // d.h.e.o
    public float n1(float f) {
        Object item;
        float value;
        int i;
        float value2;
        float value3;
        float interpolation;
        float interpolation2;
        float interpolation3;
        int i4 = 0;
        i = 1;
        if (f <= 0) {
            Object item2 = this.c.get(i4);
            Object item4 = this.c.get(i);
            float f11 = item2.p();
            float f3 = item4.p();
            float f8 = item2.b();
            d.h.e.m mVar = item4.c();
            if (mVar != null) {
                interpolation = mVar.getInterpolation(f);
            }
            float f24 = (interpolation - f8) / (item4.b() - f8);
            if (this.v == null) {
                f3 = f3 - f11;
                f5 = f24 * f3;
                value2 = f11 + f5;
            } else {
                value2 = (Float)this.v.evaluate(f24, Float.valueOf(f11), Float.valueOf(f3)).floatValue();
            }
            return value2;
        }
        if (f >= 1065353216) {
            Object item3 = this.c.get(this.a - 2);
            Object item5 = this.c.get(this.a - i);
            float f16 = item3.p();
            float f4 = item5.p();
            float f10 = item3.b();
            d.h.e.m mVar2 = item5.c();
            if (mVar2 != null) {
                interpolation3 = mVar2.getInterpolation(f);
            }
            float f27 = (interpolation3 - f10) / (item5.b() - f10);
            if (this.v == null) {
                f4 = f4 - f16;
                f7 = f27 * f4;
                value3 = f16 + f7;
            } else {
                value3 = (Float)this.v.evaluate(f27, Float.valueOf(f16), Float.valueOf(f4)).floatValue();
            }
            return value3;
        }
        item = this.c.get(i4);
        while (this.c < this.a) {
            item = this.c.get(i);
            float f19 = item.b();
            if (f < f19) {
                d.h.e.m mVar3 = item.c();
                interpolation2 = (f - item.b()) / (item.b() - item.b());
                float f9 = item.p();
                float f15 = item.p();
            }
        }
        return (Float)(n)this.c.get(i7 - i).d().floatValue();
    }
}
