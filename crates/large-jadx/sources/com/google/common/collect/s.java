package com.google.common.collect;

/* loaded from: classes2.dex */
final class s {
    static int a(int i, double d2) {
        int obj3;
        obj3 = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(obj3);
        if (obj3 > (int)obj4) {
            if (highestOneBit << 1 > 0) {
            } else {
                obj3 = 1073741824;
            }
            return obj3;
        }
        return highestOneBit;
    }

    static int b(int i) {
        return (int)i4;
    }

    static int c(Object object) {
        int obj0;
        if (object == null) {
            obj0 = 0;
        } else {
            obj0 = object.hashCode();
        }
        return s.b(obj0);
    }
}
