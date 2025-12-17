package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\r\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\u0008\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0081\u0008¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\tH\u0081\u0008¢\u0006\u0002\u0010\u000c\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0001\u001a\u001f\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0001¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a\u001f\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0001¢\u0006\u0004\u0008\u0015\u0010\u0013\u001a\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u000eH\u0001\u001a\u0011\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\u0008\u001a\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\u0008\u001a\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\u0008\u001a\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0081\u0008\u001a\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\u0008¢\u0006\u0002\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0019H\u0001\u001a\u001f\u0010 \u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\u0008!\u0010\"\u001a\u001f\u0010#\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\u0008$\u0010\"\u001a\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0019H\u0001\u001a\u0011\u0010&\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0019H\u0081\u0008\u001a\u0011\u0010'\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0019H\u0081\u0008\u001a\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000eH\u0000¨\u0006(", d2 = {"doubleToUInt", "Lkotlin/UInt;", "value", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "floatToUInt", "", "(F)I", "floatToULong", "(F)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "uintToFloat", "uintToLong", "", "uintToString", "", "base", "uintToULong", "(I)J", "ulongCompare", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToFloat", "ulongToString", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UnsignedKt {
    public static final int doubleToUInt(double value) {
        int constructor-impl;
        int constructor-impl2;
        double uintToDouble;
        if (Double.isNaN(value)) {
        } else {
            if (Double.compare(value, uintToDouble) <= 0) {
            } else {
                if (Double.compare(value, uintToDouble) >= 0) {
                } else {
                    if (Double.compare(value, l) <= 0) {
                        constructor-impl2 = UInt.constructor-impl((int)value);
                    } else {
                        int i = Integer.MAX_VALUE;
                        constructor-impl2 = UInt.constructor-impl(constructor-impl3 += constructor-impl);
                    }
                }
            }
        }
        return constructor-impl2;
    }

    public static final long doubleToULong(double value) {
        int naN;
        int constructor-impl;
        long cmp;
        double ulongToDouble;
        if (Double.isNaN(value)) {
        } else {
            if (Double.compare(value, ulongToDouble) <= 0) {
            } else {
                constructor-impl = -1;
                if (Double.compare(value, ulongToDouble) >= 0) {
                } else {
                    long l = 4890909195324358656L;
                    if (Double.compare(value, l) < 0) {
                        constructor-impl = ULong.constructor-impl((long)value);
                    } else {
                        constructor-impl = ULong.constructor-impl(constructor-impl2 += cmp);
                    }
                }
            }
        }
        return constructor-impl;
    }

    private static final int floatToUInt(float value) {
        return UnsignedKt.doubleToUInt((double)value);
    }

    private static final long floatToULong(float value) {
        return UnsignedKt.doubleToULong((double)value);
    }

    public static final int uintCompare(int v1, int v2) {
        int i = Integer.MIN_VALUE;
        return Intrinsics.compare(v1 ^ i, i ^= v2);
    }

    public static final int uintDivide-J1ME1BU(int v1, int v2) {
        long l2 = 4294967295L;
        return UInt.constructor-impl((int)i2);
    }

    public static final int uintRemainder-J1ME1BU(int v1, int v2) {
        long l2 = 4294967295L;
        return UInt.constructor-impl((int)i2);
    }

    public static final double uintToDouble(int value) {
        return d += i6;
    }

    private static final float uintToFloat(int value) {
        return (float)uintToDouble;
    }

    private static final long uintToLong(int value) {
        return l &= l2;
    }

    private static final String uintToString(int value) {
        return String.valueOf(l &= l2);
    }

    private static final String uintToString(int value, int base) {
        return UnsignedKt.ulongToString(l &= l2, obj1);
    }

    private static final long uintToULong(int value) {
        return ULong.constructor-impl(l &= l2);
    }

    public static final int ulongCompare(long v1, long v2) {
        long l = Long.MIN_VALUE;
        return Intrinsics.compare(v1 ^ l, obj3);
    }

    public static final long ulongDivide-eb3DHEI(long v1, long v2) {
        int i;
        int i2;
        final int i3 = v1;
        final int i4 = obj15;
        i2 = 0;
        if (Long.compare(i4, i2) < 0) {
            if (Long.compareUnsigned(v1, v2) < 0) {
            } else {
                i2 = 1;
            }
            return ULong.constructor-impl(i2);
        }
        if (Long.compare(i3, i2) >= 0) {
            return ULong.constructor-impl(i3 / i4);
        }
        i = 1;
        i7 <<= i;
        if (Long.compareUnsigned(ULong.constructor-impl(i3 - i9), obj10) >= 0) {
        } else {
            i = 0;
        }
        return ULong.constructor-impl(l += i8);
    }

    public static final long ulongRemainder-eb3DHEI(long v1, long v2) {
        int i;
        long constructor-impl;
        final int i2 = v1;
        final int i3 = obj16;
        i = 0;
        if (Long.compare(i3, i) < 0) {
            if (Long.compareUnsigned(v1, v2) < 0) {
                constructor-impl = v1;
            } else {
                constructor-impl = ULong.constructor-impl(v1 - obj16);
            }
            return constructor-impl;
        }
        if (Long.compare(i2, i) >= 0) {
            return ULong.constructor-impl(i2 % i3);
        }
        int i7 = 1;
        int i12 = i2 - i11;
        if (Long.compareUnsigned(ULong.constructor-impl(i12), obj11) >= 0) {
            i = i3;
        }
        return ULong.constructor-impl(i12 - i);
    }

    public static final double ulongToDouble(long value) {
        return i3 += d3;
    }

    private static final float ulongToFloat(long value) {
        return (float)ulongToDouble;
    }

    private static final String ulongToString(long value) {
        return UnsignedKt.ulongToString(value, obj2);
    }

    public static final String ulongToString(long value, int base) {
        int quotient;
        int rem;
        long i;
        final String str = "toString(...)";
        if (Long.compare(value, i2) >= 0) {
            String string = Long.toString(value, base);
            Intrinsics.checkNotNullExpressionValue(string, str);
            return string;
        }
        int i3 = 1;
        i5 <<= i3;
        rem = value - i6;
        if (Long.compare(rem, i) >= 0) {
            rem -= l3;
            quotient += i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = Long.toString(quotient, obj3);
        Intrinsics.checkNotNullExpressionValue(string3, str);
        String string4 = Long.toString(rem, obj5);
        Intrinsics.checkNotNullExpressionValue(string4, str);
        return stringBuilder.append(string3).append(string4).toString();
    }
}
