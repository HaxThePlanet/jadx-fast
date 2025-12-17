package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class d9 {

    static final Charset a;
    public static final byte[] b;
    static {
        Charset.forName("US-ASCII");
        d9.a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        int i = 0;
        final byte[] bArr = new byte[i];
        d9.b = bArr;
        ByteBuffer.wrap(bArr);
        int i2 = b8.a;
        super(bArr, 0, 0, 0, 0);
        z7Var2.c(i);
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
        if (d9.d(length, bArr, 0, length) == 0) {
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
        com.google.android.gms.internal.measurement.x9 obj0 = (y9)object.c();
        obj0.J0((y9)object2);
        return obj0.t0();
    }

    public static String h(byte[] bArr) {
        String string = new String(bArr, d9.a);
        return string;
    }

    public static boolean i(byte[] bArr) {
        return mb.e(bArr);
    }
}
