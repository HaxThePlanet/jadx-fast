package d.h.e;

import android.util.Log;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyframeSet.java */
/* loaded from: classes.dex */
class o<T> implements p<T> {

    int a;
    n<T> b;
    List<n<T>> c;
    u<T> v;
    @SafeVarargs
    o(n<T>... nVarArr) {
        super();
        this.a = nVarArr.length;
        this.c = Arrays.asList(nVarArr);
        Object obj = nVarArr[0];
        final Object obj2 = nVarArr[this.a - 1];
        this.b = obj2;
        obj2.c();
    }

    static o<Float> a(float... fArr) {
        int length;
        int i;
        int i2;
        float f;
        boolean naN;
        length = fArr.length;
        d.h.e.n.a[] arr = new n.a[Math.max(length, 2)];
        float f2 = 0.0f;
        i = 0;
        i = 1;
        if (length != i) {
            arr[i] = (n.a)n.g(0.0f, fArr[i]);
            while (0.0f < length) {
                arr[i] = (n.a)n.g((float)i / (float)(length - 1), fArr[i]);
                i = i + 1;
            }
        } else {
            arr[i] = (n.a)n.f(0.0f);
            arr[i] = (n.a)n.g(1f, fArr[i]);
            if (Float.isNaN(fArr[i])) {
            }
        }
        if (i != 0) {
            Log.w("Animator", "Bad value (NaN) in float animator");
        }
        return new h(arr);
    }

    static o<Integer> b(int... iArr) {
        d.h.e.n nVar;
        int i = 0;
        int i2 = 1;
        int length = iArr.length;
        d.h.e.n.b[] arr = new n.b[Math.max(length, 2)];
        float f2 = 0.0f;
        i = 0;
        i2 = 1;
        if (length == i2) {
            arr[i] = (n.b)n.h(0.0f);
            float f = 1f;
            arr[i2] = (n.b)n.j(f, iArr[i]);
        } else {
            arr[i] = (n.b)n.j(0.0f, iArr[i]);
            while (i2 < length) {
                arr[i2] = (n.b)n.j((float)i2 / (float)(length - 1), iArr[i2]);
                i2 = i2 + 1;
            }
        }
        return new k(arr);
    }

    public void l0(u<T> uVar) {
        this.v = uVar;
    }

    public List<n<T>> q() {
        return this.c;
    }

    @Override // java.lang.Object
    public String toString() {
        String str;
        int i = 0;
        str = " ";
        i = 0;
        while (i < this.a) {
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = (n)this.c.get(i).d();
            String str2 = "  ";
            str = str + obj + str2;
            i = i + 1;
        }
        return str;
    }
}
