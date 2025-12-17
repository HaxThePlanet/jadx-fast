package com.google.android.gms.internal.firebase-auth-api;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class e {

    static final Charset a;
    public static final byte[] b;
    static {
        e.a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        int i = 0;
        final byte[] bArr = new byte[i];
        e.b = bArr;
        ByteBuffer.wrap(bArr);
        zq.n(bArr, i, i, i);
    }

    public static int a(boolean z) {
        if (z) {
            return 1231;
        }
        return 1237;
    }

    public static int b(byte[] bArr) {
        int obj2;
        final int length = bArr.length;
        if (e.d(length, bArr, 0, length) == 0) {
            obj2 = 1;
        }
        return obj2;
    }

    public static int c(long l) {
        return (int)obj2;
    }

    static int d(int i, byte[] b2Arr2, int i3, int i4) {
        byte b;
        int obj1;
        int obj3;
        obj3 = 0;
        while (obj3 < i4) {
            obj1 += b;
            obj3++;
        }
        return obj1;
    }

    static <T> T e(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    static <T> T f(T t, String string2) {
        Objects.requireNonNull(t, string2);
        return t;
    }

    static Object g(Object object, Object object2) {
        com.google.android.gms.internal.firebase-auth-api.x obj0 = (y)object.n();
        obj0.s1((y)object2);
        return obj0.i();
    }

    public static String h(byte[] bArr) {
        String string = new String(bArr, e.a);
        return string;
    }

    public static boolean i(byte[] bArr) {
        return o1.e(bArr);
    }
}
