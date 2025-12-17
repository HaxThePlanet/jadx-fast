package com.google.android.exoplayer2.n2;

import android.os.SystemClock;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.source.k0;
import com.google.android.exoplayer2.source.m0.d;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class e implements com.google.android.exoplayer2.n2.g {

    protected final k0 a;
    protected final int b;
    protected final int[] c;
    private final i1[] d;
    private final long[] e;
    private int f;
    public e(k0 k0, int... i2Arr2) {
        super(k0, i2Arr2, 0);
    }

    public e(k0 k0, int[] i2Arr2, int i3) {
        int i;
        i1[] objArr;
        i1 i1Var;
        int[] obj5;
        int obj6;
        super();
        i = 0;
        obj6 = i2Arr2.length > 0 ? 1 : i;
        g.f(obj6);
        g.e(k0);
        this.a = (k0)k0;
        obj6 = i2Arr2.length;
        this.b = obj6;
        this.d = new i1[obj6];
        obj6 = i;
        for (int i2 : i2Arr2) {
            this.d[obj6] = k0.a(i2);
        }
        Arrays.sort(this.d, a.a);
        this.c = new int[this.b];
        obj5 = this.b;
        while (i < obj5) {
            this.c[i] = k0.b(this.d[i]);
            i++;
            obj5 = this.b;
        }
        this.e = new long[obj5];
    }

    static int v(i1 i1, i1 i12) {
        return obj1 -= obj0;
    }

    @Override // com.google.android.exoplayer2.n2.g
    public final k0 a() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.n2.g
    public boolean c(int i, long l2) {
        boolean z;
        int i3;
        int i2;
        int i4;
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        z = d(i, elapsedRealtime);
        final int i5 = 0;
        i3 = i5;
        i2 = this.b;
        i4 = 1;
        while (i3 < i2) {
            if (!z) {
            }
            if (i3 != i && !d(i3, elapsedRealtime)) {
            } else {
            }
            z = i5;
            i3++;
            i2 = this.b;
            i4 = 1;
            if (!d(i3, elapsedRealtime)) {
            } else {
            }
            z = i4;
        }
        if (!z) {
            return i5;
        }
        final long[] lArr = this.e;
        lArr[i] = Math.max(lArr[i], obj9);
        return i4;
    }

    @Override // com.google.android.exoplayer2.n2.g
    public boolean d(int i, long l2) {
        int obj4;
        obj4 = Long.compare(l, l2) > 0 ? 1 : 0;
        return obj4;
    }

    @Override // com.google.android.exoplayer2.n2.g
    public boolean equals(Object object) {
        int i;
        int[] k0Var;
        Class class;
        Class class2;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (this.a == object.a && Arrays.equals(this.c, object.c)) {
                    if (Arrays.equals(this.c, object.c)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.n2.g
    public void g() {
    }

    @Override // com.google.android.exoplayer2.n2.g
    public final i1 h(int i) {
        return this.d[i];
    }

    @Override // com.google.android.exoplayer2.n2.g
    public int hashCode() {
        int i2;
        int i;
        if (this.f == 0) {
            this.f = i4 += i;
        }
        return this.f;
    }

    @Override // com.google.android.exoplayer2.n2.g
    public void i() {
    }

    @Override // com.google.android.exoplayer2.n2.g
    public final int j(int i) {
        return this.c[i];
    }

    public int k(long l, List<? extends d> list2) {
        return obj3.size();
    }

    @Override // com.google.android.exoplayer2.n2.g
    public final int length() {
        return iArr.length;
    }

    @Override // com.google.android.exoplayer2.n2.g
    public final int m() {
        return this.c[b()];
    }

    @Override // com.google.android.exoplayer2.n2.g
    public final i1 n() {
        return this.d[b()];
    }

    @Override // com.google.android.exoplayer2.n2.g
    public void p(float f) {
    }

    @Override // com.google.android.exoplayer2.n2.g
    public final int t(int i) {
        int i3;
        int i2;
        i3 = 0;
        while (i3 < this.b) {
            i3++;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.n2.g
    public final int u(i1 i1) {
        int i;
        i1 i1Var;
        i = 0;
        while (i < this.b) {
            i++;
        }
        return -1;
    }
}
