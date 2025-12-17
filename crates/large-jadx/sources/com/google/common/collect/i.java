package com.google.common.collect;

import com.google.common.base.n;

/* loaded from: classes2.dex */
final class i {
    static void a(Object object, Object object2) {
        if (object == null) {
        } else {
            if (object2 == null) {
            } else {
            }
            String obj2 = String.valueOf(object);
            StringBuilder stringBuilder = new StringBuilder(length += 26);
            stringBuilder.append("null value in entry: ");
            stringBuilder.append(obj2);
            stringBuilder.append("=null");
            NullPointerException obj3 = new NullPointerException(stringBuilder.toString());
            throw obj3;
        }
        obj3 = String.valueOf(object2);
        StringBuilder stringBuilder2 = new StringBuilder(length2 += 24);
        stringBuilder2.append("null key in entry: null=");
        stringBuilder2.append(obj3);
        obj2 = new NullPointerException(stringBuilder2.toString());
        throw obj2;
    }

    static int b(int i, String string2) {
        if (i < 0) {
        } else {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder(length += 40);
        stringBuilder.append(string2);
        stringBuilder.append(" cannot be negative but was: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    static void c(boolean z) {
        n.v(z, "no calls to next() since the last call to remove()");
    }
}
