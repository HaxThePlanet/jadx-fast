package net.time4j.tz.model;

import java.util.Comparator;
import net.time4j.engine.m;
import net.time4j.h0;

/* loaded from: classes3.dex */
enum k implements Comparator<net.time4j.tz.model.d> {

    INSTANCE;
    @Override // java.lang.Enum
    public int compare(Object object, Object object2) {
        return compare((d)object, (d)object2);
    }

    @Override // java.lang.Enum
    public int compare(net.time4j.tz.model.d d, net.time4j.tz.model.d d2) {
        int i;
        h0 obj3;
        h0 obj4;
        int i2 = 2000;
        if (d.b(i2).P(d2.b(i2)) == 0) {
            i = d.f().p0(d2.f());
        }
        return i;
    }
}
