package l;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class f0 {
    public static final long a(String string, int i2, int i3) {
        int i10;
        int i8;
        int i9;
        int i7;
        char charAt2;
        int i4;
        int i5;
        int i11;
        int i6;
        int charAt;
        int i;
        int obj11;
        n.f(string, "$this$utf8Size");
        int i12 = 0;
        i10 = 1;
        i9 = i2 >= 0 ? i10 : i12;
        if (i9 == 0) {
        } else {
            i7 = i3 >= i2 ? i10 : i12;
            if (i7 == 0) {
            } else {
                if (i3 <= string.length()) {
                } else {
                    i10 = i12;
                }
                if (i10 == 0) {
                } else {
                    i8 = 0;
                    while (obj11 < i3) {
                        charAt2 = string.charAt(obj11);
                        i11 = 1;
                        if (charAt2 < 128) {
                        } else {
                        }
                        if (charAt2 < 2048) {
                        } else {
                        }
                        if (charAt2 >= 55296) {
                        } else {
                        }
                        i4 = 3;
                        i8 += charAt2;
                        obj11++;
                        i5 = 57343;
                        if (charAt2 > i5) {
                        } else {
                        }
                        i6 = obj11 + 1;
                        if (i6 < i3) {
                        } else {
                        }
                        charAt = i12;
                        if (charAt2 <= 56319 && charAt >= 56320) {
                        } else {
                        }
                        i8 += i11;
                        obj11 = i6;
                        if (charAt >= 56320) {
                        } else {
                        }
                        if (charAt > i5) {
                        } else {
                        }
                        i8 += charAt2;
                        obj11 += 2;
                        charAt = string.charAt(i6);
                        i4 = 2;
                        i8 += i11;
                    }
                    return i8;
                }
                obj11 = new StringBuilder();
                obj11.append("endIndex > string.length: ");
                obj11.append(i3);
                obj11.append(" > ");
                obj11.append(string.length());
                obj11 = new IllegalArgumentException(obj11.toString().toString());
                throw obj11;
            }
            StringBuilder obj10 = new StringBuilder();
            obj10.append("endIndex < beginIndex: ");
            obj10.append(i3);
            obj10.append(" < ");
            obj10.append(i2);
            obj11 = new IllegalArgumentException(obj10.toString().toString());
            throw obj11;
        }
        obj10 = new StringBuilder();
        obj10.append("beginIndex < 0: ");
        obj10.append(i2);
        obj11 = new IllegalArgumentException(obj10.toString().toString());
        throw obj11;
    }

    public static long b(String string, int i2, int i3, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = string.length();
        }
        return f0.a(string, obj1, obj2);
    }
}
