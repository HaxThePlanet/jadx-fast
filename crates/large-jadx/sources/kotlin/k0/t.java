package kotlin.k0;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\n\n\u0002\u0008\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\u0008*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\u0008*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¢\u0006\u0002\u0010\u000c\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015", d2 = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
class t extends kotlin.k0.s {
    public static Byte l(String string, int i2) {
        String str;
        Integer obj1;
        n.f(string, "$this$toByteOrNull");
        obj1 = l.n(string, i2);
        obj1 = obj1.intValue();
        if (obj1 != null && obj1 >= -128 && obj1 > 127) {
            obj1 = obj1.intValue();
            if (obj1 >= -128) {
                if (obj1 > 127) {
                }
                return Byte.valueOf((byte)obj1);
            }
        }
        return null;
    }

    public static Integer m(String string) {
        n.f(string, "$this$toIntOrNull");
        return l.n(string, 10);
    }

    public static Integer n(String string, int i2) {
        int i;
        int i8;
        int i3;
        int i4;
        int i9;
        int i7;
        int i5;
        int i6;
        Integer obj10;
        n.f(string, "$this$toIntOrNull");
        a.a(i2);
        int length = string.length();
        final int i10 = 0;
        if (length == 0) {
            return i10;
        }
        i = 0;
        char charAt = string.charAt(i);
        i4 = -2147483647;
        i9 = 1;
        if (n.h(charAt, 48) < 0 && length == i9) {
            if (length == i9) {
                return i10;
            }
            if (charAt == 45) {
                i4 = Integer.MIN_VALUE;
                i8 = i9;
                int i13 = -59652323;
                i7 = i13;
                while (i9 < length) {
                    i5 = b.b(string.charAt(i9), i2);
                    i *= i2;
                    i11 -= i5;
                    i9++;
                }
                if (i8 != 0) {
                    obj10 = Integer.valueOf(i);
                } else {
                    obj10 = Integer.valueOf(-i);
                }
                return obj10;
            } else {
                if (charAt == 43) {
                    i8 = i;
                }
            }
            return i10;
        }
        i9 = i8;
    }

    public static Long o(String string) {
        n.f(string, "$this$toLongOrNull");
        return l.p(string, 10);
    }

    public static Long p(String string, int i2) {
        Long valueOf;
        int i5;
        long l2;
        int i6;
        long l;
        int i7;
        int i;
        long cmp2;
        int cmp3;
        int cmp;
        int i4;
        int i3;
        Object obj = string;
        final int i9 = i2;
        n.f(obj, "$this$toLongOrNull");
        a.a(i2);
        int length = string.length();
        final int i10 = 0;
        if (length == 0) {
            return i10;
        }
        i5 = 0;
        char charAt = obj.charAt(i5);
        l = -9223372036854775807L;
        i7 = 1;
        if (n.h(charAt, 48) < 0 && length == i7) {
            if (length == i7) {
                return i10;
            }
            if (charAt == 45) {
                l = Long.MIN_VALUE;
                i5 = i7;
                i = 0;
                cmp2 = l2;
                while (i5 < length) {
                    int i13 = b.b(obj.charAt(i5), i9);
                    i *= l3;
                    long l4 = (long)i13;
                    i12 -= l4;
                    i5++;
                    l2 = -256204778801521550L;
                }
                if (i7 != 0) {
                    valueOf = Long.valueOf(i);
                } else {
                    valueOf = Long.valueOf(-i);
                }
                return valueOf;
            } else {
                if (charAt == 43) {
                    i7 = i5;
                    i5 = i3;
                }
            }
            return i10;
        }
        i7 = i5;
    }

    public static Short q(String string, int i2) {
        String str;
        Integer obj1;
        n.f(string, "$this$toShortOrNull");
        obj1 = l.n(string, i2);
        obj1 = obj1.intValue();
        if (obj1 != null && obj1 >= -32768 && obj1 > 32767) {
            obj1 = obj1.intValue();
            if (obj1 >= -32768) {
                if (obj1 > 32767) {
                }
                return Short.valueOf((short)obj1);
            }
        }
        return null;
    }
}
