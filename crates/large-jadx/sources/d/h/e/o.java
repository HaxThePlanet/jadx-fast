package d.h.e;

import android.util.Log;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
class o<T>  implements d.h.e.p<T> {

    int a;
    d.h.e.n<T> b;
    List<d.h.e.n<T>> c;
    d.h.e.u<T> v;
    @SafeVarargs
    o(d.h.e.n<T>... nArr) {
        super();
        this.a = nArr.length;
        this.c = Arrays.asList(nArr);
        Object obj = nArr[0];
        final Object obj2 = nArr[i2--];
        this.b = obj2;
        obj2.c();
    }

    static d.h.e.o<Float> a(float... fArr) {
        int length;
        int i;
        int i2;
        int naN;
        int i3;
        boolean obj7;
        length = fArr.length;
        d.h.e.n.a[] arr = new n.a[Math.max(length, 2)];
        int i7 = 0;
        i2 = 0;
        final int i8 = 1;
        if (length == i8) {
            arr[i2] = (n.a)n.f(i7);
            arr[i8] = (n.a)n.g(1065353216, fArr[i2]);
            if (Float.isNaN(fArr[i2])) {
                i2 = i8;
            }
        } else {
            arr[i2] = (n.a)n.g(i7, fArr[i2]);
            i = i8;
            while (i < length) {
                arr[i] = (n.a)n.g(f /= f2, fArr[i]);
                if (Float.isNaN(fArr[i]) != 0) {
                }
                i++;
                i2 = i8;
            }
        }
        if (i2 != 0) {
            Log.w("Animator", "Bad value (NaN) in float animator");
        }
        obj7 = new h(arr);
        return obj7;
    }

    static d.h.e.o<Integer> b(int... iArr) {
        int length;
        int i4;
        int i2;
        int i;
        int i3;
        d.h.e.n obj6;
        length = iArr.length;
        d.h.e.n.b[] arr = new n.b[Math.max(length, 2)];
        i4 = 0;
        i2 = 0;
        i = 1;
        if (length == i) {
            arr[i2] = (n.b)n.h(i4);
            arr[i] = (n.b)n.j(1065353216, iArr[i2]);
        } else {
            arr[i2] = (n.b)n.j(i4, iArr[i2]);
            while (i < length) {
                arr[i] = (n.b)n.j(f /= f2, iArr[i]);
                i++;
            }
        }
        obj6 = new k(arr);
        return obj6;
    }

    public void l0(d.h.e.u<T> u) {
        this.v = u;
    }

    public List<d.h.e.n<T>> q() {
        return this.c;
    }

    @Override // d.h.e.p
    public String toString() {
        String string;
        int i;
        StringBuilder stringBuilder;
        string = " ";
        i = 0;
        while (i < this.a) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append((n)this.c.get(i).d());
            stringBuilder.append("  ");
            string = stringBuilder.toString();
            i++;
        }
        return string;
    }
}
