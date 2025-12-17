package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u001c2\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0008\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001cB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u0010\u0019\u001a\u00020\u0010H\u0016J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u001d\u0010\u0008\u001a\u00020\u00038VX\u0097\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000cR\u0017\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000cR\u0017\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000c\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u001d", d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "endExclusive", "getEndExclusive-s-VKNKU$annotations", "()V", "getEndExclusive-s-VKNKU", "()J", "getEndInclusive-s-VKNKU", "getStart-s-VKNKU", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ULongRange extends kotlin.ranges.ULongProgression implements kotlin.ranges.ClosedRange<ULong>, kotlin.ranges.OpenEndRange<ULong> {

    public static final kotlin.ranges.ULongRange.Companion Companion;
    private static final kotlin.ranges.ULongRange EMPTY;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlin/ranges/ULongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.ranges.ULongRange getEMPTY() {
            return ULongRange.access$getEMPTY$cp();
        }
    }
    static {
        ULongRange.Companion companion = new ULongRange.Companion(0);
        ULongRange.Companion = companion;
        ULongRange uLongRange = new ULongRange(-1, obj4, 0, obj6, 0);
        ULongRange.EMPTY = uLongRange;
    }

    private ULongRange(long start, long endInclusive) {
        super(start, obj2, obj11, obj4, 1, obj6, 0);
    }

    public ULongRange(long l, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(l, l2, defaultConstructorMarker3, obj4);
    }

    public static final kotlin.ranges.ULongRange access$getEMPTY$cp() {
        return ULongRange.EMPTY;
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    public static void getEndExclusive-s-VKNKU$annotations() {
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean contains(Comparable value) {
        return contains-VKZWuLQ((ULong)value.unbox-impl());
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean contains-VKZWuLQ(long value) {
        int compareUnsigned;
        int i;
        if (Long.compareUnsigned(getFirst-s-VKNKU(), obj1) <= 0 && Long.compareUnsigned(value, obj4) <= 0) {
            i = Long.compareUnsigned(value, obj4) <= 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean equals(Object other) {
        int i;
        boolean empty;
        long first-s-VKNKU;
        if (other instanceof ULongRange) {
            if (isEmpty()) {
                if (!(ULongRange)other.isEmpty()) {
                    if (Long.compare(first-s-VKNKU2, first-s-VKNKU) == 0 && Long.compare(last-s-VKNKU, first-s-VKNKU) == 0) {
                        i = Long.compare(last-s-VKNKU, first-s-VKNKU) == 0 ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // kotlin.ranges.ULongProgression
    public Comparable getEndExclusive() {
        return ULong.box-impl(getEndExclusive-s-VKNKU());
    }

    @Override // kotlin.ranges.ULongProgression
    public long getEndExclusive-s-VKNKU() {
        if (Long.compare(last-s-VKNKU, i2) == 0) {
        } else {
            return ULong.constructor-impl(last-s-VKNKU2 += constructor-impl2);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        throw illegalStateException;
    }

    @Override // kotlin.ranges.ULongProgression
    public Comparable getEndInclusive() {
        return ULong.box-impl(getEndInclusive-s-VKNKU());
    }

    @Override // kotlin.ranges.ULongProgression
    public long getEndInclusive-s-VKNKU() {
        return getLast-s-VKNKU();
    }

    @Override // kotlin.ranges.ULongProgression
    public Comparable getStart() {
        return ULong.box-impl(getStart-s-VKNKU());
    }

    @Override // kotlin.ranges.ULongProgression
    public long getStart-s-VKNKU() {
        return getFirst-s-VKNKU();
    }

    @Override // kotlin.ranges.ULongProgression
    public int hashCode() {
        int i2;
        long l;
        long constructor-impl2;
        long constructor-impl;
        int i;
        long last-s-VKNKU;
        if (isEmpty()) {
            i2 = -1;
        } else {
            i = 32;
            constructor-impl2 = ULong.constructor-impl(first-s-VKNKU2 >>>= i);
            i5 += l;
        }
        return i2;
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean isEmpty() {
        int i;
        i = Long.compareUnsigned(getFirst-s-VKNKU(), obj1) > 0 ? 1 : 0;
        return i;
    }

    @Override // kotlin.ranges.ULongProgression
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(ULong.toString-impl(getFirst-s-VKNKU())).append("..").append(ULong.toString-impl(getLast-s-VKNKU())).toString();
    }
}
