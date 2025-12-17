package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u0000 \u00192\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0008\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u0019B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\u0012\u001a\u00020\u00102\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\u0008\u0010\u0015\u001a\u00020\u0003H\u0016J\u0008\u0010\u0016\u001a\u00020\u0010H\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0008\u001a\u00020\u00038VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000cR\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006\u001a", d2 = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(II)V", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "()Ljava/lang/Integer;", "getEndInclusive", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IntRange extends kotlin.ranges.IntProgression implements kotlin.ranges.ClosedRange<Integer>, kotlin.ranges.OpenEndRange<Integer> {

    public static final kotlin.ranges.IntRange.Companion Companion;
    private static final kotlin.ranges.IntRange EMPTY;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.ranges.IntRange getEMPTY() {
            return IntRange.access$getEMPTY$cp();
        }
    }
    static {
        IntRange.Companion companion = new IntRange.Companion(0);
        IntRange.Companion = companion;
        IntRange intRange = new IntRange(1, 0);
        IntRange.EMPTY = intRange;
    }

    public IntRange(int start, int endInclusive) {
        super(start, endInclusive, 1);
    }

    public static final kotlin.ranges.IntRange access$getEMPTY$cp() {
        return IntRange.EMPTY;
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with Int type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    public static void getEndExclusive$annotations() {
    }

    @Override // kotlin.ranges.IntProgression
    public boolean contains(int value) {
        int first;
        int i;
        if (getFirst() <= value && value <= getLast()) {
            i = value <= getLast() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlin.ranges.IntProgression
    public boolean contains(Comparable value) {
        return contains((Number)value.intValue());
    }

    @Override // kotlin.ranges.IntProgression
    public boolean equals(Object other) {
        int i;
        boolean empty;
        int first;
        if (other instanceof IntRange) {
            if (isEmpty()) {
                if (!(IntRange)other.isEmpty()) {
                    if (getFirst() == (IntRange)other.getFirst() && getLast() == (IntRange)other.getLast()) {
                        i = getLast() == (IntRange)other.getLast() ? 1 : 0;
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

    @Override // kotlin.ranges.IntProgression
    public Comparable getEndExclusive() {
        return (Comparable)getEndExclusive();
    }

    @Override // kotlin.ranges.IntProgression
    public Integer getEndExclusive() {
        if (getLast() == Integer.MAX_VALUE) {
        } else {
            return Integer.valueOf(last2++);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        throw illegalStateException;
    }

    @Override // kotlin.ranges.IntProgression
    public Comparable getEndInclusive() {
        return (Comparable)getEndInclusive();
    }

    @Override // kotlin.ranges.IntProgression
    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    @Override // kotlin.ranges.IntProgression
    public Comparable getStart() {
        return (Comparable)getStart();
    }

    @Override // kotlin.ranges.IntProgression
    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }

    @Override // kotlin.ranges.IntProgression
    public int hashCode() {
        int i;
        int last;
        if (isEmpty()) {
            i = -1;
        } else {
            i2 += last;
        }
        return i;
    }

    @Override // kotlin.ranges.IntProgression
    public boolean isEmpty() {
        int i;
        i = getFirst() > getLast() ? 1 : 0;
        return i;
    }

    @Override // kotlin.ranges.IntProgression
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getFirst()).append("..").append(getLast()).toString();
    }
}
