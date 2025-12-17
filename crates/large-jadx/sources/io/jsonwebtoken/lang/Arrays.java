package io.jsonwebtoken.lang;

/* loaded from: classes3.dex */
public final class Arrays {
    public static byte[] clean(byte[] bArr) {
        byte[] obj1;
        if (Arrays.length(bArr) > 0) {
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static int length(byte[] bArr) {
        int obj0;
        obj0 = bArr != null ? bArr.length : 0;
        return obj0;
    }
}
