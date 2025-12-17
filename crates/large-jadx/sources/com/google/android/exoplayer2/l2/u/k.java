package com.google.android.exoplayer2.l2.u;

import com.google.android.exoplayer2.l2.s.a;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes2.dex */
public final class k {

    public final boolean a;
    public final String b;
    public final s.a c;
    public final int d;
    public final byte[] e;
    public k(boolean z, String string2, int i3, byte[] b4Arr4, int i5, int i6, byte[] b7Arr7) {
        int i;
        int i2;
        super();
        final int i7 = 0;
        i2 = i3 == 0 ? i : i7;
        if (b7Arr7 == null) {
        } else {
            i = i7;
        }
        g.a(i ^= i2);
        this.a = z;
        this.b = string2;
        this.d = i3;
        this.e = b7Arr7;
        s.a obj4 = new s.a(k.a(string2), b4Arr4, i5, i6);
        this.c = obj4;
    }

    private static int a(String string) {
        int i;
        int equals;
        final int i3 = 1;
        if (string == null) {
            return i3;
        }
        string.hashCode();
        i = -1;
        final int i5 = 2;
        switch (string) {
            case "cbc1":
                i = 0;
                break;
            case "cbcs":
                i = i3;
                break;
            case "cenc":
                i = i5;
                break;
            case "cens":
                i = 3;
                break;
            default:
        }
        if (/* condition */) {
            return i5;
        }
        StringBuilder stringBuilder = new StringBuilder(length += 68);
        stringBuilder.append("Unsupported protection scheme type '");
        stringBuilder.append(string);
        stringBuilder.append("'. Assuming AES-CTR crypto mode.");
        v.h("TrackEncryptionBox", stringBuilder.toString());
        return i3;
    }
}
