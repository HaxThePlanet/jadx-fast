package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class t2 implements Comparable<com.google.android.gms.internal.firebase-auth-api.t2> {

    private final byte[] a;
    t2(byte[] bArr, com.google.android.gms.internal.firebase-auth-api.r2 r22) {
        super();
        this.a = Arrays.copyOf(bArr, bArr.length);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object object) {
        int length3;
        byte[] length;
        int i;
        int length2;
        length3 = bArr.length;
        length = bArr2.length;
        if (length3 != length) {
            i = length3 - length;
        } else {
            length3 = i;
            length = this.a;
            while (length3 < length.length) {
                length = length[length3];
                length2 = object.a[length3];
                if (length != length2) {
                    break;
                } else {
                }
                length3++;
                length = this.a;
            }
        }
        return i;
    }

    @Override // java.lang.Comparable
    public final boolean equals(Object object) {
        if (!object instanceof t2) {
            return 0;
        }
        return Arrays.equals(this.a, object.a);
    }

    @Override // java.lang.Comparable
    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // java.lang.Comparable
    public final String toString() {
        return tc.a(this.a);
    }
}
