package com.google.android.exoplayer2.l2;

/* loaded from: classes2.dex */
public class e implements com.google.android.exoplayer2.l2.q {

    private final long a;
    private final long b;
    private final int c;
    private final long d = -9223372036854775807L;
    public e(long l, long l2, int i3, int i4) {
        int i;
        long obj3;
        super();
        this.a = i3;
        int i2 = -1;
        this.c = obj7;
        i = -1;
        if (Long.compare(l, i) == 0) {
            this.b = i;
            obj3 = -9223372036854775807L;
        } else {
            this.b = l - i3;
            this.d = e.e(l, l2, i3);
        }
    }

    private static long e(long l, long l2, int i3) {
        return obj0 /= obj2;
    }

    @Override // com.google.android.exoplayer2.l2.q
    public boolean b() {
        int i;
        i = Long.compare(l, i2) != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.android.exoplayer2.l2.q
    public long d(long l) {
        return e.e(l, obj5, this.a);
    }

    @Override // com.google.android.exoplayer2.l2.q
    public long getDurationUs() {
        return this.d;
    }
}
