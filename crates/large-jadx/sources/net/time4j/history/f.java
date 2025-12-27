package net.time4j.history;

import net.time4j.engine.z;
import net.time4j.g0;

/* compiled from: CutOverEvent.java */
/* loaded from: classes3.dex */
final class f {

    final long a;
    final c b;
    final h c = new h();
    final h d = new h();
    f(long j, c cVar, c cVar2) {
        super();
        this.a = j;
        this.b = cVar2;
        if (j == -9223372036854775808L) {
            int i = 1000000000;
            int i2 = 1;
            net.time4j.history.h hVar = new h(j.BC, i, i2, i2);
        } else {
            this.c = cVar2.fromMJD(j);
            this.d = cVar.fromMJD(j - 1L);
        }
    }

    public boolean equals(Object object) {
        boolean z = true;
        int cmp;
        long l;
        boolean equals;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof f) {
            if (this.a == object.a) {
                if (this.b == object.b) {
                    if (!(this.d.equals(object.d))) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (int)(l ^ (l >>> 32L));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String name = f.class.getName();
        String str2 = "[start=";
        String str3 = " (";
        g0 g0Var = g0.P0(this.a, z.MODIFIED_JULIAN_DATE);
        String str4 = "),algorithm=";
        String str5 = ",date-before-cutover=";
        String str6 = ",date-at-cutover=";
        str = name + str2 + this.a + str3 + g0Var + str4 + this.b + str5 + this.d + str6 + this.c + 93;
        return str;
    }
}
