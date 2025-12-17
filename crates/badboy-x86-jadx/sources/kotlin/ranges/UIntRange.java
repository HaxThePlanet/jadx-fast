package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u001c2\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0008\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001cB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u0010\u0019\u001a\u00020\u0010H\u0016J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u001d\u0010\u0008\u001a\u00020\u00038VX\u0097\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000cR\u0017\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000cR\u0017\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000c\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u001d", d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "endExclusive", "getEndExclusive-pVg5ArA$annotations", "()V", "getEndExclusive-pVg5ArA", "()I", "getEndInclusive-pVg5ArA", "getStart-pVg5ArA", "contains", "", "value", "contains-WZ4Q5Ns", "(I)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UIntRange extends kotlin.ranges.UIntProgression implements kotlin.ranges.ClosedRange<UInt>, kotlin.ranges.OpenEndRange<UInt> {

    public static final kotlin.ranges.UIntRange.Companion Companion;
    private static final kotlin.ranges.UIntRange EMPTY;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlin/ranges/UIntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.ranges.UIntRange getEMPTY() {
            return UIntRange.access$getEMPTY$cp();
        }
    }
    static {
        final int i = 0;
        UIntRange.Companion companion = new UIntRange.Companion(i);
        UIntRange.Companion = companion;
        UIntRange uIntRange = new UIntRange(-1, 0, i);
        UIntRange.EMPTY = uIntRange;
    }

    private UIntRange(int start, int endInclusive) {
        super(start, endInclusive, 1, 0);
    }

    public UIntRange(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(i, i2);
    }

    public static final kotlin.ranges.UIntRange access$getEMPTY$cp() {
        return UIntRange.EMPTY;
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    public static void getEndExclusive-pVg5ArA$annotations() {
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean contains(Comparable value) {
        return contains-WZ4Q5Ns((UInt)value.unbox-impl());
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean contains-WZ4Q5Ns(int value) {
        int compareUnsigned;
        int i;
        if (Integer.compareUnsigned(getFirst-pVg5ArA(), value) <= 0 && Integer.compareUnsigned(value, getLast-pVg5ArA()) <= 0) {
            i = Integer.compareUnsigned(value, getLast-pVg5ArA()) <= 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean equals(Object other) {
        int i;
        boolean first-pVg5ArA2;
        int first-pVg5ArA;
        if (other instanceof UIntRange) {
            if (isEmpty()) {
                if (!(UIntRange)other.isEmpty()) {
                    if (getFirst-pVg5ArA() == (UIntRange)other.getFirst-pVg5ArA() && getLast-pVg5ArA() == (UIntRange)other.getLast-pVg5ArA()) {
                        i = getLast-pVg5ArA() == (UIntRange)other.getLast-pVg5ArA() ? 1 : 0;
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

    @Override // kotlin.ranges.UIntProgression
    public Comparable getEndExclusive() {
        return UInt.box-impl(getEndExclusive-pVg5ArA());
    }

    @Override // kotlin.ranges.UIntProgression
    public int getEndExclusive-pVg5ArA() {
        if (getLast-pVg5ArA() == -1) {
        } else {
            return UInt.constructor-impl(last-pVg5ArA2++);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        throw illegalStateException;
    }

    @Override // kotlin.ranges.UIntProgression
    public Comparable getEndInclusive() {
        return UInt.box-impl(getEndInclusive-pVg5ArA());
    }

    @Override // kotlin.ranges.UIntProgression
    public int getEndInclusive-pVg5ArA() {
        return getLast-pVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression
    public Comparable getStart() {
        return UInt.box-impl(getStart-pVg5ArA());
    }

    @Override // kotlin.ranges.UIntProgression
    public int getStart-pVg5ArA() {
        return getFirst-pVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression
    public int hashCode() {
        int i;
        int last-pVg5ArA;
        if (isEmpty()) {
            i = -1;
        } else {
            i2 += last-pVg5ArA;
        }
        return i;
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean isEmpty() {
        int i;
        i = Integer.compareUnsigned(getFirst-pVg5ArA(), getLast-pVg5ArA()) > 0 ? 1 : 0;
        return i;
    }

    @Override // kotlin.ranges.UIntProgression
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(UInt.toString-impl(getFirst-pVg5ArA())).append("..").append(UInt.toString-impl(getLast-pVg5ArA())).toString();
    }
}
