package com.google.android.exoplayer2.l2.t;

import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.w;

/* loaded from: classes2.dex */
final class d implements com.google.android.exoplayer2.l2.t.g {

    private final long a;
    private final w b;
    private final w c;
    private long d;
    public d(long l, long l2, long l3) {
        super();
        this.d = l;
        this.a = obj5;
        w obj1 = new w();
        this.b = obj1;
        w obj2 = new w();
        this.c = obj2;
        obj1.a(0);
        obj2.a(l3);
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public long a() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public boolean b() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public long c(long l) {
        final int i = 1;
        return this.b.b(p0.e(this.c, l, obj4, i));
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public boolean d(long l) {
        int i;
        w wVar = this.b;
        if (Long.compare(obj4, i2) < 0) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public void e(long l, long l2) {
        if (d(l)) {
        }
        this.b.a(l);
        this.c.a(obj4);
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    void f(long l) {
        this.d = l;
    }

    @Override // com.google.android.exoplayer2.l2.t.g
    public long getDurationUs() {
        return this.d;
    }
}
