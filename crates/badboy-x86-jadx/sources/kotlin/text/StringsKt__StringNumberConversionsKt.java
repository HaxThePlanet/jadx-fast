package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\n\n\u0002\u0008\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\u0008*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\u0008*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¢\u0006\u0002\u0010\u000c\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015", d2 = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsKt extends kotlin.text.StringsKt__StringNumberConversionsJVMKt {
    public static final Void numberFormatError(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringBuilder stringBuilder = new StringBuilder();
        NumberFormatException numberFormatException = new NumberFormatException(stringBuilder.append("Invalid number format: '").append(input).append('\'').toString());
        throw numberFormatException;
    }

    public static final Byte toByteOrNull(String $this$toByteOrNull) {
        Intrinsics.checkNotNullParameter($this$toByteOrNull, "<this>");
        return StringsKt.toByteOrNull($this$toByteOrNull, 10);
    }

    public static final Byte toByteOrNull(String $this$toByteOrNull, int radix) {
        int i;
        Intrinsics.checkNotNullParameter($this$toByteOrNull, "<this>");
        Integer intOrNull = StringsKt.toIntOrNull($this$toByteOrNull, radix);
        int i2 = 0;
        int intValue = intOrNull.intValue();
        if (intOrNull != null && intValue >= -128 && intValue > 127) {
            intValue = intOrNull.intValue();
            if (intValue >= -128) {
                if (intValue > 127) {
                }
                return Byte.valueOf((byte)intValue);
            }
            return i2;
        }
        return i2;
    }

    public static final Integer toIntOrNull(String $this$toIntOrNull) {
        Intrinsics.checkNotNullParameter($this$toIntOrNull, "<this>");
        return StringsKt.toIntOrNull($this$toIntOrNull, 10);
    }

    public static final Integer toIntOrNull(String $this$toIntOrNull, int radix) {
        Integer valueOf;
        int start;
        int isNegative;
        int limit;
        int compare;
        int limitBeforeMul;
        int result;
        int i;
        int digitOf;
        int i2;
        Intrinsics.checkNotNullParameter($this$toIntOrNull, "<this>");
        CharsKt.checkRadix(radix);
        int length2 = $this$toIntOrNull.length();
        int i3 = 0;
        if (length2 == 0) {
            return i3;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        char charAt = $this$toIntOrNull.charAt(0);
        if (Intrinsics.compare(charAt, 48) < 0) {
            if (length2 == 1) {
                return i3;
            }
            start = 1;
            switch (charAt) {
                case 43:
                    isNegative = 0;
                    limit = -2147483647;
                    break;
                case 44:
                    return i3;
                default:
                    isNegative = 1;
                    limit = Integer.MIN_VALUE;
            }
        } else {
            start = 0;
            isNegative = 0;
            limit = -2147483647;
        }
        int i10 = -59652323;
        limitBeforeMul = i10;
        result = 0;
        i = start;
        while (i < length2) {
            digitOf = CharsKt.digitOf($this$toIntOrNull.charAt(i), radix);
            result *= radix;
            result2 -= digitOf;
            i++;
        }
        if (isNegative != 0) {
            valueOf = Integer.valueOf(result);
        } else {
            valueOf = Integer.valueOf(-result);
        }
        return valueOf;
    }

    public static final Long toLongOrNull(String $this$toLongOrNull) {
        Intrinsics.checkNotNullParameter($this$toLongOrNull, "<this>");
        return StringsKt.toLongOrNull($this$toLongOrNull, 10);
    }

    public static final Long toLongOrNull(String $this$toLongOrNull, int radix) {
        int i3;
        Long valueOf;
        int start;
        int isNegative;
        long limit;
        int compare;
        long l;
        int result;
        int i2;
        int i4;
        int i;
        int i5;
        final Object obj2 = $this$toLongOrNull;
        final int i6 = radix;
        Intrinsics.checkNotNullParameter(obj2, "<this>");
        CharsKt.checkRadix(i6);
        int length = obj2.length();
        i3 = 0;
        if (length == 0) {
            return i3;
        }
        int i8 = 0;
        int i10 = 0;
        int i11 = 0;
        char charAt2 = obj2.charAt(0);
        if (Intrinsics.compare(charAt2, 48) < 0) {
            if (length == 1) {
                return i3;
            }
            start = 1;
            switch (charAt2) {
                case 43:
                    isNegative = 0;
                    limit = -9223372036854775807L;
                    break;
                case 44:
                    return i3;
                default:
                    isNegative = 1;
                    limit = Long.MIN_VALUE;
            }
        } else {
            start = 0;
            isNegative = 0;
            limit = -9223372036854775807L;
        }
        long l4 = -256204778801521550L;
        l = l4;
        result = 0;
        i2 = start;
        while (i2 < length) {
            i4 = i3;
            int digitOf = CharsKt.digitOf(obj2.charAt(i2), i6);
            i = start;
            i5 = isNegative;
            result *= start3;
            result2 -= l3;
            i2++;
            i3 = i4;
            start = i;
            isNegative = i5;
            i = start;
            i5 = isNegative;
            start = limit / start2;
            l = start;
        }
        int start4 = start;
        if (isNegative != 0) {
            valueOf = Long.valueOf(result);
        } else {
            valueOf = Long.valueOf(-result);
        }
        return valueOf;
    }

    public static final Short toShortOrNull(String $this$toShortOrNull) {
        Intrinsics.checkNotNullParameter($this$toShortOrNull, "<this>");
        return StringsKt.toShortOrNull($this$toShortOrNull, 10);
    }

    public static final Short toShortOrNull(String $this$toShortOrNull, int radix) {
        int i;
        Intrinsics.checkNotNullParameter($this$toShortOrNull, "<this>");
        Integer intOrNull = StringsKt.toIntOrNull($this$toShortOrNull, radix);
        int i2 = 0;
        int intValue = intOrNull.intValue();
        if (intOrNull != null && intValue >= -32768 && intValue > 32767) {
            intValue = intOrNull.intValue();
            if (intValue >= -32768) {
                if (intValue > 32767) {
                }
                return Short.valueOf((short)intValue);
            }
            return i2;
        }
        return i2;
    }
}
