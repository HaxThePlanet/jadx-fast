package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u0000 \u001a2\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0008\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001aB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\u0012\u001a\u00020\u00102\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0010H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\u0008\u001a\u00020\u00038VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000cR\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006\u001b", d2 = {"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(JJ)V", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "()Ljava/lang/Long;", "getEndInclusive", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LongRange extends kotlin.ranges.LongProgression implements kotlin.ranges.ClosedRange<Long>, kotlin.ranges.OpenEndRange<Long> {

    public static final kotlin.ranges.LongRange.Companion Companion;
    private static final kotlin.ranges.LongRange EMPTY;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlin/ranges/LongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/LongRange;", "getEMPTY", "()Lkotlin/ranges/LongRange;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.ranges.LongRange getEMPTY() {
            return LongRange.access$getEMPTY$cp();
        }
    }
    static {
        LongRange.Companion companion = new LongRange.Companion(0);
        LongRange.Companion = companion;
        LongRange longRange = new LongRange(1, obj2, 0, obj4);
        LongRange.EMPTY = longRange;
    }

    public LongRange(long start, long endInclusive) {
        super(start, obj2, obj10, obj4, 1, obj6);
    }

    public static final kotlin.ranges.LongRange access$getEMPTY$cp() {
        return LongRange.EMPTY;
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with Long type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    public static void getEndExclusive$annotations() {
    }

    @Override // kotlin.ranges.LongProgression
    public boolean contains(long value) {
        int cmp;
        int i;
        if (Long.compare(first, value) <= 0 && Long.compare(value, last) <= 0) {
            i = Long.compare(value, last) <= 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlin.ranges.LongProgression
    public boolean contains(Comparable value) {
        return contains((Number)value.longValue());
    }

    @Override // kotlin.ranges.LongProgression
    public boolean equals(Object other) {
        int i;
        boolean empty;
        long first;
        if (other instanceof LongRange) {
            if (isEmpty()) {
                if (!(LongRange)other.isEmpty()) {
                    if (Long.compare(first2, first) == 0 && Long.compare(last, first) == 0) {
                        i = Long.compare(last, first) == 0 ? 1 : 0;
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

    @Override // kotlin.ranges.LongProgression
    public Comparable getEndExclusive() {
        return (Comparable)getEndExclusive();
    }

    @Override // kotlin.ranges.LongProgression
    public Long getEndExclusive() {
        if (Long.compare(last, l) == 0) {
        } else {
            return Long.valueOf(last2 += i2);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        throw illegalStateException;
    }

    @Override // kotlin.ranges.LongProgression
    public Comparable getEndInclusive() {
        return (Comparable)getEndInclusive();
    }

    @Override // kotlin.ranges.LongProgression
    public Long getEndInclusive() {
        return Long.valueOf(getLast());
    }

    @Override // kotlin.ranges.LongProgression
    public Comparable getStart() {
        return (Comparable)getStart();
    }

    @Override // kotlin.ranges.LongProgression
    public Long getStart() {
        return Long.valueOf(getFirst());
    }

    @Override // kotlin.ranges.LongProgression
    public int hashCode() {
        int i2;
        int i4;
        int i;
        int i3;
        if (isEmpty()) {
            i2 = -1;
        } else {
            i3 = 32;
            i2 = (int)i7;
        }
        return i2;
    }

    @Override // kotlin.ranges.LongProgression
    public boolean isEmpty() {
        int i;
        i = Long.compare(first, last) > 0 ? 1 : 0;
        return i;
    }

    @Override // kotlin.ranges.LongProgression
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getFirst()).append("..").append(getLast()).toString();
    }
}
