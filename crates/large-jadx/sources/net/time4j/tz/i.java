package net.time4j.tz;

import net.time4j.f1.f;

/* loaded from: classes3.dex */
class i implements f {

    private final long a;
    private final int b;
    private i(long l, int i2) {
        super();
        this.a = l;
        this.b = obj3;
    }

    static f b(long l, int i2) {
        int i;
        int obj3;
        int obj5;
        if (obj5 == null) {
            l -= i;
        }
        obj5 = obj5 == null ? 999999999 : obj5 + -1;
        i iVar = new i(obj3, i2, obj5);
        return iVar;
    }

    @Override // net.time4j.f1.f
    public int a() {
        return this.b;
    }

    @Override // net.time4j.f1.f
    public long x() {
        return this.a;
    }
}
