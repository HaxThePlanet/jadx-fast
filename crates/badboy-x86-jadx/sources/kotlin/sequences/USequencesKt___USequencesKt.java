package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\u0008\u0006\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0007*\u0008\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\u0008\u0008\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\u0008\u000b\u0010\u0005¨\u0006\u000c", d2 = {"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/sequences/USequencesKt")
class USequencesKt___USequencesKt {
    public static final int sumOfUByte(kotlin.sequences.Sequence<UByte> $this$sum) {
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

    public static final int sumOfUInt(kotlin.sequences.Sequence<UInt> $this$sum) {
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

    public static final long sumOfULong(kotlin.sequences.Sequence<ULong> $this$sum) {
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

    public static final int sumOfUShort(kotlin.sequences.Sequence<UShort> $this$sum) {
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
}
