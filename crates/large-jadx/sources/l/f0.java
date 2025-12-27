package l;

import kotlin.d0.d.n;

/* compiled from: Utf8.kt */
/* loaded from: classes3.dex */
public final class f0 {
    public static final long a(String str, int i, int i2) {
        int i4 = 0;
        char charAt = 56320;
        int i5 = 2;
        char c = 55296;
        int i6;
        char c2 = 56319;
        n.f(str, "$this$utf8Size");
        i = 0;
        i = 1;
        int r2 = i;
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str8 = "beginIndex < 0: ";
            str5 = str8 + i;
            throw new IllegalArgumentException(str5.toString());
        } else {
            r2 = i;
            if (i == 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str4 = "endIndex < beginIndex: ";
                String str10 = " < ";
                str7 = str4 + i2 + str10 + i;
                throw new IllegalArgumentException(str7.toString());
            } else {
                if (i2 > str.length()) {
                }
                if (i == 0) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str3 = "endIndex > string.length: ";
                    String str9 = " > ";
                    int length2 = str.length();
                    str6 = str3 + i2 + str9 + length2;
                    throw new IllegalArgumentException(str6.toString());
                } else {
                    i4 = 0;
                    while (i6 < i2) {
                        charAt = str.charAt(i6);
                        c = '\u0080';
                        long l = 1L;
                    }
                    return i4;
                }
            }
        }
    }

    public static /* synthetic */ long b(String str, int i, int i2, int i3, Object object) {
        int length;
        if (i3 & 1 != 0) {
            i = 0;
        }
        if (i3 & 2 != 0) {
            length = str.length();
        }
        return f0.a(str, i, length);
    }
}
