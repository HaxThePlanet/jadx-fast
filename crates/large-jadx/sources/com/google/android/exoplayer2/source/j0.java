package com.google.android.exoplayer2.source;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m;

/* loaded from: classes2.dex */
final class j0<V>  {

    private int a = -1;
    private final SparseArray<V> b;
    private final m<V> c;
    public j0(m<V> m) {
        super();
        SparseArray sparseArray = new SparseArray();
        this.b = sparseArray;
        this.c = m;
        final int obj2 = -1;
    }

    public void a(int i, V v2) {
        int i3;
        int keyAt;
        int valueAt;
        int i2;
        valueAt = 0;
        final int i4 = 1;
        if (this.a == -1) {
            i3 = this.b.size() == 0 ? i4 : valueAt;
            g.f(i3);
            this.a = valueAt;
        }
        SparseArray sparseArray3 = this.b;
        keyAt = sparseArray3.keyAt(size2 -= i4);
        if (this.b.size() > 0 && i >= keyAt) {
            sparseArray3 = this.b;
            keyAt = sparseArray3.keyAt(size2 -= i4);
            if (i >= keyAt) {
                valueAt = i4;
            }
            g.a(valueAt);
            if (keyAt == i) {
                SparseArray sparseArray5 = this.b;
                this.c.accept(sparseArray5.valueAt(size3 -= i4));
            }
        }
        this.b.append(i, v2);
    }

    public void b() {
        int i;
        m mVar;
        Object valueAt;
        i = 0;
        while (i < this.b.size()) {
            this.c.accept(this.b.valueAt(i));
            i++;
        }
        this.a = -1;
        this.b.clear();
    }

    public void c(int i) {
        int i2;
        SparseArray keyAt;
        Object valueAt;
        int obj4;
        size--;
        while (i2 >= 0) {
            if (i < this.b.keyAt(i2)) {
            }
            this.c.accept(this.b.valueAt(i2));
            this.b.removeAt(i2);
            i2--;
        }
        if (this.b.size() > 0) {
            obj4 = Math.min(this.a, size2--);
        } else {
            obj4 = -1;
        }
        this.a = obj4;
    }

    public void d(int i) {
        int i4;
        int i2;
        SparseArray sparseArray;
        int keyAt;
        int i3;
        Object valueAt;
        i4 = 0;
        while (i4 < size--) {
            i3 = i4 + 1;
            if (i >= this.b.keyAt(i3)) {
            }
            this.c.accept(this.b.valueAt(i4));
            this.b.removeAt(i4);
            i2 = this.a;
            if (i2 > 0) {
            }
            i4 = i3;
            this.a = i2--;
        }
    }

    public V e(int i) {
        int i3;
        int keyAt;
        int keyAt2;
        int i2;
        if (this.a == -1) {
            this.a = 0;
        }
        keyAt = this.a;
        while (keyAt > 0) {
            if (i < this.b.keyAt(keyAt)) {
            }
            this.a = i4--;
            keyAt = this.a;
        }
        while (this.a < size--) {
            if (i >= this.b.keyAt(i7++)) {
            }
            this.a = i5++;
        }
        return this.b.valueAt(this.a);
    }

    public V f() {
        SparseArray sparseArray = this.b;
        return sparseArray.valueAt(size--);
    }

    public boolean g() {
        int i;
        i = this.b.size() == 0 ? 1 : 0;
        return i;
    }
}
