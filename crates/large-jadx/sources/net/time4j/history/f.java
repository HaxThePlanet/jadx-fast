package net.time4j.history;

import net.time4j.engine.z;
import net.time4j.g0;

/* loaded from: classes3.dex */
final class f {

    final long a;
    final net.time4j.history.c b;
    final net.time4j.history.h c;
    final net.time4j.history.h d;
    f(long l, net.time4j.history.c c2, net.time4j.history.c c3) {
        int cmp;
        net.time4j.history.h obj3;
        net.time4j.history.j obj4;
        int obj5;
        int obj6;
        super();
        this.a = l;
        this.b = obj6;
        if (Long.compare(l, l2) == 0) {
            obj6 = 1;
            obj3 = new h(j.BC, 1000000000, obj6, obj6);
            this.c = obj3;
            this.d = obj3;
        } else {
            this.c = obj6.fromMJD(l);
            this.d = c3.fromMJD(l -= cmp);
        }
    }

    public boolean equals(Object object) {
        int i;
        int cmp;
        long l;
        Object obj8;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof f) {
            if (Long.compare(l, l2) == 0 && this.b == object.b && this.d.equals(object.d)) {
                if (this.b == object.b) {
                    if (this.d.equals(object.d)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        long l = this.a;
        return (int)i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f.class.getName());
        stringBuilder.append("[start=");
        stringBuilder.append(this.a);
        stringBuilder.append(" (");
        stringBuilder.append(g0.P0(this.a, obj2));
        stringBuilder.append("),algorithm=");
        stringBuilder.append(this.b);
        stringBuilder.append(",date-before-cutover=");
        stringBuilder.append(this.d);
        stringBuilder.append(",date-at-cutover=");
        stringBuilder.append(this.c);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
