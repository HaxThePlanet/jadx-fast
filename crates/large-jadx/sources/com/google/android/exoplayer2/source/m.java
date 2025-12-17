package com.google.android.exoplayer2.source;

/* loaded from: classes2.dex */
public class m implements com.google.android.exoplayer2.source.g0 {

    protected final com.google.android.exoplayer2.source.g0[] a;
    public m(com.google.android.exoplayer2.source.g0[] g0Arr) {
        super();
        this.a = g0Arr;
    }

    @Override // com.google.android.exoplayer2.source.g0
    public final long a() {
        int i;
        long l2;
        int cmp;
        long l;
        com.google.android.exoplayer2.source.g0[] objArr = this.a;
        final long l3 = Long.MAX_VALUE;
        i = 0;
        l2 = l3;
        long l4 = Long.MIN_VALUE;
        while (i < objArr.length) {
            l = objArr[i].a();
            if (Long.compare(l, l4) != 0) {
            }
            i++;
            l4 = Long.MIN_VALUE;
            l2 = Math.min(l2, obj6);
        }
        if (Long.compare(l2, l3) == 0) {
            l2 = l4;
        }
        return l2;
    }

    @Override // com.google.android.exoplayer2.source.g0
    public boolean b(long l) {
        int i4;
        long l3;
        long l2;
        Object obj;
        com.google.android.exoplayer2.source.g0[] objArr;
        int length;
        int i2;
        int i3;
        boolean z;
        int cmp;
        int i;
        int cmp2;
        final long l4 = l;
        final int i5 = 0;
        i4 = i5;
        l3 = a();
        l2 = Long.MIN_VALUE;
        while (Long.compare(l3, l2) == 0) {
            objArr = obj.a;
            i3 = i2;
            while (i2 < objArr.length) {
                z = objArr[i2];
                long l5 = z.a();
                if (Long.compare(l5, l2) != 0 && Long.compare(l5, l4) <= 0) {
                } else {
                }
                i = i5;
                if (Long.compare(l5, l3) != 0) {
                } else {
                }
                i3 |= z;
                i2++;
                if (i != 0) {
                }
                if (Long.compare(l5, l4) <= 0) {
                } else {
                }
                i = 1;
            }
            i4 |= i3;
            if (i3 != 0) {
                break;
            }
            l3 = a();
            l2 = Long.MIN_VALUE;
            z = objArr[i2];
            l5 = z.a();
            if (Long.compare(l5, l2) != 0 && Long.compare(l5, l4) <= 0) {
            } else {
            }
            i = i5;
            if (Long.compare(l5, l3) != 0) {
            } else {
            }
            i3 |= z;
            i2++;
            if (i != 0) {
            }
            if (Long.compare(l5, l4) <= 0) {
            } else {
            }
            i = 1;
        }
        obj = this;
        return i4;
    }

    @Override // com.google.android.exoplayer2.source.g0
    public boolean c() {
        int i;
        boolean z;
        com.google.android.exoplayer2.source.g0[] objArr = this.a;
        final int i3 = 0;
        i = i3;
        while (i < objArr.length) {
            i++;
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.source.g0
    public final long e() {
        int i;
        long l2;
        int cmp;
        long l;
        com.google.android.exoplayer2.source.g0[] objArr = this.a;
        final long l3 = Long.MAX_VALUE;
        i = 0;
        l2 = l3;
        long l4 = Long.MIN_VALUE;
        while (i < objArr.length) {
            l = objArr[i].e();
            if (Long.compare(l, l4) != 0) {
            }
            i++;
            l4 = Long.MIN_VALUE;
            l2 = Math.min(l2, obj6);
        }
        if (Long.compare(l2, l3) == 0) {
            l2 = l4;
        }
        return l2;
    }

    @Override // com.google.android.exoplayer2.source.g0
    public final void f(long l) {
        int i;
        com.google.android.exoplayer2.source.g0 g0Var;
        final com.google.android.exoplayer2.source.g0[] objArr = this.a;
        i = 0;
        while (i < objArr.length) {
            objArr[i].f(l);
            i++;
        }
    }
}
