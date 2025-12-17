package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.util.d0;

/* loaded from: classes2.dex */
public final class o {

    public final String a;
    private o(int i, int i2, String string3) {
        super();
        this.a = string3;
    }

    public static com.google.android.exoplayer2.video.o a(d0 d0) {
        String str2;
        int i;
        String str;
        d0.J(2);
        int i3 = d0.x();
        final int i8 = i3 >> 1;
        int i9 = 5;
        obj6 |= i5;
        if (i8 != 4 && i8 != i9) {
            if (i8 != i9) {
                if (i8 == 7) {
                } else {
                    if (i8 == 8) {
                        str2 = "hev1";
                        final String str3 = ".0";
                        str = obj6 < 10 ? str3 : ".";
                        StringBuilder stringBuilder = new StringBuilder(i11 += length2);
                        stringBuilder.append(str2);
                        stringBuilder.append(str3);
                        stringBuilder.append(i8);
                        stringBuilder.append(str);
                        stringBuilder.append(obj6);
                        o oVar = new o(i8, obj6, stringBuilder.toString());
                        return oVar;
                    } else {
                        if (i8 == 9) {
                            str2 = "avc3";
                        }
                    }
                }
                return null;
            }
        }
        str2 = "dvhe";
    }
}
