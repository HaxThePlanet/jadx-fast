package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0013\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\u0008\u0005\u0010\u0006\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\u0008\u0008\u0010\t\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0012\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u0014\u001a\u00020\u0007*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0014\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u0018\u001a\u00020\n*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u0018\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001a\u001a\u000e\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\r*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001d\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001e\u001a\u000e\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006 ", d2 = {"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UStringsKt {
    public static final String toString-JSWoG40(long $this$toString_u2dJSWoG40, int radix) {
        return UnsignedKt.ulongToString($this$toString_u2dJSWoG40, radix);
    }

    public static final String toString-LxnNnR4(byte $this$toString_u2dLxnNnR4, int radix) {
        String string = Integer.toString($this$toString_u2dLxnNnR4 & 255, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String toString-V7xB4Y4(int $this$toString_u2dV7xB4Y4, int radix) {
        return UnsignedKt.ulongToString(l &= l2, obj2);
    }

    public static final String toString-olVBNx4(short $this$toString_u2dolVBNx4, int radix) {
        String string = Integer.toString(i &= $this$toString_u2dolVBNx4, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final byte toUByte(String $this$toUByte) {
        Intrinsics.checkNotNullParameter($this$toUByte, "<this>");
        UByte uByteOrNull = UStringsKt.toUByteOrNull($this$toUByte);
        if (uByteOrNull == null) {
        } else {
            return uByteOrNull.unbox-impl();
        }
        StringsKt.numberFormatError($this$toUByte);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final byte toUByte(String $this$toUByte, int radix) {
        Intrinsics.checkNotNullParameter($this$toUByte, "<this>");
        UByte uByteOrNull = UStringsKt.toUByteOrNull($this$toUByte, radix);
        if (uByteOrNull == null) {
        } else {
            return uByteOrNull.unbox-impl();
        }
        StringsKt.numberFormatError($this$toUByte);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final UByte toUByteOrNull(String $this$toUByteOrNull) {
        Intrinsics.checkNotNullParameter($this$toUByteOrNull, "<this>");
        return UStringsKt.toUByteOrNull($this$toUByteOrNull, 10);
    }

    public static final UByte toUByteOrNull(String $this$toUByteOrNull, int radix) {
        Intrinsics.checkNotNullParameter($this$toUByteOrNull, "<this>");
        UInt uIntOrNull = UStringsKt.toUIntOrNull($this$toUByteOrNull, radix);
        int i = 0;
        int unbox-impl = uIntOrNull.unbox-impl();
        if (uIntOrNull != null && Integer.compareUnsigned(unbox-impl, UInt.constructor-impl(255)) > 0) {
            unbox-impl = uIntOrNull.unbox-impl();
            if (Integer.compareUnsigned(unbox-impl, UInt.constructor-impl(255)) > 0) {
                return i;
            }
            return UByte.box-impl(UByte.constructor-impl((byte)unbox-impl));
        }
        return i;
    }

    public static final int toUInt(String $this$toUInt) {
        Intrinsics.checkNotNullParameter($this$toUInt, "<this>");
        UInt uIntOrNull = UStringsKt.toUIntOrNull($this$toUInt);
        if (uIntOrNull == null) {
        } else {
            return uIntOrNull.unbox-impl();
        }
        StringsKt.numberFormatError($this$toUInt);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final int toUInt(String $this$toUInt, int radix) {
        Intrinsics.checkNotNullParameter($this$toUInt, "<this>");
        UInt uIntOrNull = UStringsKt.toUIntOrNull($this$toUInt, radix);
        if (uIntOrNull == null) {
        } else {
            return uIntOrNull.unbox-impl();
        }
        StringsKt.numberFormatError($this$toUInt);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final UInt toUIntOrNull(String $this$toUIntOrNull) {
        Intrinsics.checkNotNullParameter($this$toUIntOrNull, "<this>");
        return UStringsKt.toUIntOrNull($this$toUIntOrNull, 10);
    }

    public static final UInt toUIntOrNull(String $this$toUIntOrNull, int radix) {
        int start;
        int compare;
        int limitBeforeMul;
        int result;
        int i;
        int digitOf;
        int i2;
        int compareUnsigned2;
        int compareUnsigned;
        Intrinsics.checkNotNullParameter($this$toUIntOrNull, "<this>");
        CharsKt.checkRadix(radix);
        int length = $this$toUIntOrNull.length();
        int i3 = 0;
        if (length == 0) {
            return i3;
        }
        int i5 = 0;
        char charAt = $this$toUIntOrNull.charAt(0);
        if (Intrinsics.compare(charAt, 48) < 0 && length != 1 && charAt != 43) {
            if (length != 1) {
                if (charAt != 43) {
                }
                start = 1;
                int i8 = 119304647;
                limitBeforeMul = i8;
                final int constructor-impl = UInt.constructor-impl(radix);
                result = 0;
                i = start;
                while (i < length) {
                    digitOf = CharsKt.digitOf($this$toUIntOrNull.charAt(i), radix);
                    int result2 = UInt.constructor-impl(result * constructor-impl);
                    i++;
                }
                return UInt.box-impl(result);
            }
            return i3;
        }
        start = 0;
    }

    public static final long toULong(String $this$toULong) {
        Intrinsics.checkNotNullParameter($this$toULong, "<this>");
        ULong uLongOrNull = UStringsKt.toULongOrNull($this$toULong);
        if (uLongOrNull == null) {
        } else {
            return uLongOrNull.unbox-impl();
        }
        StringsKt.numberFormatError($this$toULong);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final long toULong(String $this$toULong, int radix) {
        Intrinsics.checkNotNullParameter($this$toULong, "<this>");
        ULong uLongOrNull = UStringsKt.toULongOrNull($this$toULong, radix);
        if (uLongOrNull == null) {
        } else {
            return uLongOrNull.unbox-impl();
        }
        StringsKt.numberFormatError($this$toULong);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final ULong toULongOrNull(String $this$toULongOrNull) {
        Intrinsics.checkNotNullParameter($this$toULongOrNull, "<this>");
        return UStringsKt.toULongOrNull($this$toULongOrNull, 10);
    }

    public static final ULong toULongOrNull(String $this$toULongOrNull, int radix) {
        Object obj;
        int i;
        int length;
        int i3;
        int start;
        int compare;
        long limitBeforeMul;
        int result;
        int i2;
        int compareUnsigned;
        int compareUnsigned2;
        long l;
        obj = $this$toULongOrNull;
        i = radix;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        CharsKt.checkRadix(i);
        length = obj.length();
        int i6 = 0;
        if (length == 0) {
            return i6;
        }
        int i8 = 0;
        char charAt2 = obj.charAt(0);
        if (Intrinsics.compare(charAt2, 48) < 0 && length != 1 && charAt2 != 43) {
            if (length != 1) {
                if (charAt2 != 43) {
                }
                start = 1;
                long l4 = 512409557603043100L;
                limitBeforeMul = l4;
                long constructor-impl3 = ULong.constructor-impl((long)i);
                result = 0;
                int i12 = i6;
                i3 = i14;
                while (i3 < length) {
                    int digitOf = CharsKt.digitOf(obj.charAt(i3), i);
                    long result2 = ULong.constructor-impl(result * constructor-impl3);
                    i3++;
                    obj = $this$toULongOrNull;
                    i = radix;
                    length = i2;
                }
                return ULong.box-impl(result);
            }
            return i6;
        }
        start = 0;
    }

    public static final short toUShort(String $this$toUShort) {
        Intrinsics.checkNotNullParameter($this$toUShort, "<this>");
        UShort uShortOrNull = UStringsKt.toUShortOrNull($this$toUShort);
        if (uShortOrNull == null) {
        } else {
            return uShortOrNull.unbox-impl();
        }
        StringsKt.numberFormatError($this$toUShort);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final short toUShort(String $this$toUShort, int radix) {
        Intrinsics.checkNotNullParameter($this$toUShort, "<this>");
        UShort uShortOrNull = UStringsKt.toUShortOrNull($this$toUShort, radix);
        if (uShortOrNull == null) {
        } else {
            return uShortOrNull.unbox-impl();
        }
        StringsKt.numberFormatError($this$toUShort);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final UShort toUShortOrNull(String $this$toUShortOrNull) {
        Intrinsics.checkNotNullParameter($this$toUShortOrNull, "<this>");
        return UStringsKt.toUShortOrNull($this$toUShortOrNull, 10);
    }

    public static final UShort toUShortOrNull(String $this$toUShortOrNull, int radix) {
        Intrinsics.checkNotNullParameter($this$toUShortOrNull, "<this>");
        UInt uIntOrNull = UStringsKt.toUIntOrNull($this$toUShortOrNull, radix);
        int i = 0;
        int unbox-impl = uIntOrNull.unbox-impl();
        if (uIntOrNull != null && Integer.compareUnsigned(unbox-impl, UInt.constructor-impl(65535)) > 0) {
            unbox-impl = uIntOrNull.unbox-impl();
            if (Integer.compareUnsigned(unbox-impl, UInt.constructor-impl(65535)) > 0) {
                return i;
            }
            return UShort.box-impl(UShort.constructor-impl((short)unbox-impl));
        }
        return i;
    }
}
