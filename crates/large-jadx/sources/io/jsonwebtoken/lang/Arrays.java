package io.jsonwebtoken.lang;

/* compiled from: Arrays.java */
/* loaded from: classes3.dex */
public final class Arrays {
    private Arrays() {
        super();
    }

    public static byte[] clean(byte[] bArr) {
        int i = 0;
        if (Arrays.length(bArr) <= 0) {
            i = 0;
        }
        return i;
    }

    public static int length(byte[] bArr) {
        int length = 0;
        bArr = bArr != null ? bArr.length : 0;
        return (bArr != null ? bArr.length : 0);
    }
}
