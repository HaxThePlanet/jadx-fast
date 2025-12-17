package com.google.common.base;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class k extends com.google.common.base.f {
    public static boolean a(Object object, Object object2) {
        boolean obj0;
        if (object != object2) {
            if (object != null && object.equals(object2)) {
                if (object.equals(object2)) {
                    obj0 = 1;
                } else {
                    obj0 = 0;
                }
            } else {
            }
        } else {
        }
        return obj0;
    }

    public static int b(Object... objectArr) {
        return Arrays.hashCode(objectArr);
    }
}
