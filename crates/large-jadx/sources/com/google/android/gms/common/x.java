package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.internal.a2;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.z1;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.b;
import java.util.Arrays;

/* loaded from: classes2.dex */
abstract class x extends z1 {

    private final int a;
    protected x(byte[] bArr) {
        int i;
        super();
        i = bArr.length == 25 ? 1 : 0;
        r.a(i);
        this.a = Arrays.hashCode(bArr);
    }

    protected static byte[] p2(String string) {
        try {
            return string.getBytes("ISO-8859-1");
            AssertionError assertionError = new AssertionError(string);
            throw assertionError;
        }
    }

    @Override // com.google.android.gms.common.internal.z1
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.z1
    public final a b() {
        return b.p2(n());
    }

    @Override // com.google.android.gms.common.internal.z1
    public final boolean equals(Object object) {
        String str2;
        String str;
        Object obj4;
        final int i = 0;
        if (object != null) {
            if (!object instanceof a2) {
            } else {
                if ((a2)object.a() != this.a) {
                    return i;
                }
                obj4 = object.b();
                if (obj4 == null) {
                    return i;
                }
            }
            return Arrays.equals(n(), (byte[])b.n(obj4));
        }
        return i;
    }

    @Override // com.google.android.gms.common.internal.z1
    public final int hashCode() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.z1
    abstract byte[] n();
}
