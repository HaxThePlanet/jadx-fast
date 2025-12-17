package kotlin.random;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\u0008\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00082\u0006\u0010\u0004\u001a\u00020\u0008H\u0000¢\u0006\u0004\u0008\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\u000c*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u000b\u001a\u00020\u000c*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000cH\u0007¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a/\u0010\u000b\u001a\u00020\u000c*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0004\u0008\u0016\u0010\u0017\u001a\u0011\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007¢\u0006\u0002\u0010\u0019\u001a\u001b\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\u0008\u001a\u0010\u001b\u001a#\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a\u0019\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a\u0011\u0010!\u001a\u00020\u0008*\u00020\rH\u0007¢\u0006\u0002\u0010\"\u001a\u001b\u0010!\u001a\u00020\u0008*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0008H\u0007¢\u0006\u0004\u0008#\u0010$\u001a#\u0010!\u001a\u00020\u0008*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00082\u0006\u0010\u0004\u001a\u00020\u0008H\u0007¢\u0006\u0004\u0008%\u0010&\u001a\u0019\u0010!\u001a\u00020\u0008*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007¢\u0006\u0002\u0010(¨\u0006)", d2 = {"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class URandomKt {
    public static final void checkUIntRangeBounds-J1ME1BU(int from, int until) {
        int i;
        i = Integer.compareUnsigned(until, from) > 0 ? 1 : 0;
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.box-impl(from), UInt.box-impl(until)).toString());
        throw illegalArgumentException;
    }

    public static final void checkULongRangeBounds-eb3DHEI(long from, long until) {
        int i;
        i = Long.compareUnsigned(obj5, obj6) > 0 ? 1 : 0;
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.box-impl(from), ULong.box-impl(obj5)).toString());
        throw illegalArgumentException;
    }

    public static final byte[] nextUBytes(kotlin.random.Random $this$nextUBytes, int size) {
        Intrinsics.checkNotNullParameter($this$nextUBytes, "<this>");
        return UByteArray.constructor-impl($this$nextUBytes.nextBytes(size));
    }

    public static final byte[] nextUBytes-EVgfTAA(kotlin.random.Random $this$nextUBytes_u2dEVgfTAA, byte[] array) {
        Intrinsics.checkNotNullParameter($this$nextUBytes_u2dEVgfTAA, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        $this$nextUBytes_u2dEVgfTAA.nextBytes(array);
        return array;
    }

    public static final byte[] nextUBytes-Wvrt4B4(kotlin.random.Random $this$nextUBytes_u2dWvrt4B4, byte[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$nextUBytes_u2dWvrt4B4, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        $this$nextUBytes_u2dWvrt4B4.nextBytes(array, fromIndex, toIndex);
        return array;
    }

    public static byte[] nextUBytes-Wvrt4B4$default(kotlin.random.Random random, byte[] b2Arr2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = UByteArray.getSize-impl(b2Arr2);
        }
        return URandomKt.nextUBytes-Wvrt4B4(random, b2Arr2, obj2, obj3);
    }

    public static final int nextUInt(kotlin.random.Random $this$nextUInt) {
        Intrinsics.checkNotNullParameter($this$nextUInt, "<this>");
        return UInt.constructor-impl($this$nextUInt.nextInt());
    }

    public static final int nextUInt(kotlin.random.Random $this$nextUInt, UIntRange range) {
        int nextUInt-a8DCA5k;
        int last-pVg5ArA;
        Intrinsics.checkNotNullParameter($this$nextUInt, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
        } else {
            if (Integer.compareUnsigned(range.getLast-pVg5ArA(), -1) < 0) {
                nextUInt-a8DCA5k = URandomKt.nextUInt-a8DCA5k($this$nextUInt, range.getFirst-pVg5ArA(), UInt.constructor-impl(last-pVg5ArA3++));
            } else {
                if (Integer.compareUnsigned(range.getFirst-pVg5ArA(), 0) > 0) {
                    nextUInt-a8DCA5k = UInt.constructor-impl(nextUInt-a8DCA5k2++);
                } else {
                    nextUInt-a8DCA5k = URandomKt.nextUInt($this$nextUInt);
                }
            }
            return nextUInt-a8DCA5k;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot get random in empty range: ").append(range).toString());
        throw illegalArgumentException;
    }

    public static final int nextUInt-a8DCA5k(kotlin.random.Random $this$nextUInt_u2da8DCA5k, int from, int until) {
        Intrinsics.checkNotNullParameter($this$nextUInt_u2da8DCA5k, "$this$nextUInt");
        URandomKt.checkUIntRangeBounds-J1ME1BU(from, until);
        int i = Integer.MIN_VALUE;
        return UInt.constructor-impl(i ^= nextInt);
    }

    public static final int nextUInt-qCasIEU(kotlin.random.Random $this$nextUInt_u2dqCasIEU, int until) {
        Intrinsics.checkNotNullParameter($this$nextUInt_u2dqCasIEU, "$this$nextUInt");
        return URandomKt.nextUInt-a8DCA5k($this$nextUInt_u2dqCasIEU, 0, until);
    }

    public static final long nextULong(kotlin.random.Random $this$nextULong) {
        Intrinsics.checkNotNullParameter($this$nextULong, "<this>");
        return ULong.constructor-impl($this$nextULong.nextLong());
    }

    public static final long nextULong(kotlin.random.Random $this$nextULong, ULongRange range) {
        long nextULong-jmpaW-c;
        int i;
        long first-s-VKNKU;
        int i2;
        long l;
        Intrinsics.checkNotNullParameter($this$nextULong, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
        } else {
            long l2 = 4294967295L;
            final int i5 = 1;
            if (Long.compareUnsigned(range.getLast-s-VKNKU(), obj1) < 0) {
                nextULong-jmpaW-c = URandomKt.nextULong-jmpaW-c($this$nextULong, range.getFirst-s-VKNKU(), obj5);
            } else {
                if (Long.compareUnsigned(range.getFirst-s-VKNKU(), obj5) > 0) {
                    int i3 = i2 & l2;
                    nextULong-jmpaW-c = ULong.constructor-impl(nextULong-jmpaW-c2 += constructor-impl);
                } else {
                    nextULong-jmpaW-c = URandomKt.nextULong($this$nextULong);
                }
            }
            return nextULong-jmpaW-c;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot get random in empty range: ").append(range).toString());
        throw illegalArgumentException;
    }

    public static final long nextULong-V1Xi4fY(kotlin.random.Random $this$nextULong_u2dV1Xi4fY, long until) {
        Intrinsics.checkNotNullParameter($this$nextULong_u2dV1Xi4fY, "$this$nextULong");
        return URandomKt.nextULong-jmpaW-c($this$nextULong_u2dV1Xi4fY, 0, obj1);
    }

    public static final long nextULong-jmpaW-c(kotlin.random.Random $this$nextULong_u2djmpaW_u2dc, long from, long until) {
        Intrinsics.checkNotNullParameter($this$nextULong_u2djmpaW_u2dc, "$this$nextULong");
        URandomKt.checkULongRangeBounds-eb3DHEI(from, until);
        long l = Long.MIN_VALUE;
        return ULong.constructor-impl(l ^= nextLong);
    }
}
