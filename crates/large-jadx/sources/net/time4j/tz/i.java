package net.time4j.tz;

import net.time4j.f1.f;

/* compiled from: SimpleUT.java */
/* loaded from: classes3.dex */
class i implements f {

    private final long a;
    private final int b;
    private i(long j, int i) {
        super();
        this.a = j;
        this.b = i;
    }

    static f b(long j, int i) {
        long l2;
        if (i == 0) {
            long l = 1L;
            l2 = j - l;
        }
        i = i == 0 ? 999999999 : i - 1;
        i iVar = new i(l2, r4, (i == 0 ? 999999999 : i - 1));
        return iVar;
    }

    public int a() {
        return this.b;
    }

    public long x() {
        return this.a;
    }
}
