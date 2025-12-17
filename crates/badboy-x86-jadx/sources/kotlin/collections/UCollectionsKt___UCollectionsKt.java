package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\u0008\u0006\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0007*\u0008\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\u0008\u0008\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\u0008\u000b\u0010\u0005\u001a\u0017\u0010\u000c\u001a\u00020\r*\u0008\u0012\u0004\u0012\u00020\u00030\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u0011*\u0008\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\u0014*\u0008\u0012\u0004\u0012\u00020\u00070\u000eH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\u0008\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019", d2 = {"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt {
    public static final int sumOfUByte(Iterable<UByte> $this$sum) {
        int sum;
        byte unbox-impl;
        int i;
        Intrinsics.checkNotNullParameter($this$sum, "<this>");
        sum = 0;
        final Iterator iterator = $this$sum.iterator();
        for (UByte next2 : iterator) {
            sum = UInt.constructor-impl(constructor-impl += sum);
        }
        return sum;
    }

    public static final int sumOfUInt(Iterable<UInt> $this$sum) {
        int sum;
        int unbox-impl;
        int i;
        Intrinsics.checkNotNullParameter($this$sum, "<this>");
        sum = 0;
        final Iterator iterator = $this$sum.iterator();
        for (UInt next2 : iterator) {
            sum = UInt.constructor-impl(sum + unbox-impl);
        }
        return sum;
    }

    public static final long sumOfULong(Iterable<ULong> $this$sum) {
        int sum;
        long unbox-impl;
        int i;
        Intrinsics.checkNotNullParameter($this$sum, "<this>");
        sum = 0;
        final Iterator iterator = $this$sum.iterator();
        for (ULong next2 : iterator) {
            sum = ULong.constructor-impl(sum + unbox-impl);
        }
        return sum;
    }

    public static final int sumOfUShort(Iterable<UShort> $this$sum) {
        int sum;
        short unbox-impl;
        int i;
        Intrinsics.checkNotNullParameter($this$sum, "<this>");
        sum = 0;
        final Iterator iterator = $this$sum.iterator();
        for (UShort next2 : iterator) {
            sum = UInt.constructor-impl(constructor-impl += sum);
        }
        return sum;
    }

    public static final byte[] toUByteArray(Collection<UByte> $this$toUByteArray) {
        int i2;
        byte unbox-impl;
        int i;
        Intrinsics.checkNotNullParameter($this$toUByteArray, "<this>");
        byte[] constructor-impl = UByteArray.constructor-impl($this$toUByteArray.size());
        i2 = 0;
        final Iterator iterator = $this$toUByteArray.iterator();
        for (UByte next2 : iterator) {
            UByteArray.set-VurrAj0(constructor-impl, i2, next2.unbox-impl());
            i2 = i;
        }
        return constructor-impl;
    }

    public static final int[] toUIntArray(Collection<UInt> $this$toUIntArray) {
        int i2;
        int unbox-impl;
        int i;
        Intrinsics.checkNotNullParameter($this$toUIntArray, "<this>");
        int[] constructor-impl = UIntArray.constructor-impl($this$toUIntArray.size());
        i2 = 0;
        final Iterator iterator = $this$toUIntArray.iterator();
        for (UInt next2 : iterator) {
            UIntArray.set-VXSXFK8(constructor-impl, i2, next2.unbox-impl());
            i2 = i;
        }
        return constructor-impl;
    }

    public static final long[] toULongArray(Collection<ULong> $this$toULongArray) {
        int i2;
        long unbox-impl;
        int i;
        Intrinsics.checkNotNullParameter($this$toULongArray, "<this>");
        long[] constructor-impl = ULongArray.constructor-impl($this$toULongArray.size());
        i2 = 0;
        final Iterator iterator = $this$toULongArray.iterator();
        for (ULong next2 : iterator) {
            ULongArray.set-k8EXiF4(constructor-impl, i2, next2.unbox-impl());
            i2 = i;
        }
        return constructor-impl;
    }

    public static final short[] toUShortArray(Collection<UShort> $this$toUShortArray) {
        int i2;
        short unbox-impl;
        int i;
        Intrinsics.checkNotNullParameter($this$toUShortArray, "<this>");
        short[] constructor-impl = UShortArray.constructor-impl($this$toUShortArray.size());
        i2 = 0;
        final Iterator iterator = $this$toUShortArray.iterator();
        for (UShort next2 : iterator) {
            UShortArray.set-01HTLdE(constructor-impl, i2, next2.unbox-impl());
            i2 = i;
        }
        return constructor-impl;
    }
}
