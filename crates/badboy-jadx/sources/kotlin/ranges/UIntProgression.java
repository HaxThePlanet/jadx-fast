package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0017\u0018\u0000 \u00192\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0006H\u0016J\u0008\u0010\u0014\u001a\u00020\u0010H\u0016J\u000f\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0016H\u0086\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0008\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0016\u0010\u000c\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\n\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u001a", d2 = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-pVg5ArA", "()I", "I", "last", "getLast-pVg5ArA", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class UIntProgression implements Iterable<UInt>, KMappedMarker {

    public static final kotlin.ranges.UIntProgression.Companion Companion;
    private final int first;
    private final int last;
    private final int step;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Lkotlin/ranges/UIntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/UIntProgression;", "rangeStart", "Lkotlin/UInt;", "rangeEnd", "step", "", "fromClosedRange-Nkh28Cs", "(III)Lkotlin/ranges/UIntProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.ranges.UIntProgression fromClosedRange-Nkh28Cs(int rangeStart, int rangeEnd, int step) {
            UIntProgression uIntProgression = new UIntProgression(rangeStart, rangeEnd, step, 0);
            return uIntProgression;
        }
    }
    static {
        UIntProgression.Companion companion = new UIntProgression.Companion(0);
        UIntProgression.Companion = companion;
    }

    private UIntProgression(int start, int endInclusive, int step) {
        super();
        if (step == 0) {
        } else {
            if (step == Integer.MIN_VALUE) {
            } else {
                this.first = start;
                this.last = UProgressionUtilKt.getProgressionLastElement-Nkh28Cs(start, endInclusive, step);
                this.step = step;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Step must be non-zero.");
        throw illegalArgumentException2;
    }

    public UIntProgression(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(i, i2, i3);
    }

    @Override // java.lang.Iterable
    public boolean equals(Object other) {
        boolean empty;
        int i;
        int first;
        if (other instanceof UIntProgression) {
            if (isEmpty()) {
                if (!(UIntProgression)other.isEmpty()) {
                    if (this.first == obj2.first && this.last == obj3.last && this.step == obj4.step) {
                        if (this.last == obj3.last) {
                            i = this.step == obj4.step ? 1 : 0;
                        } else {
                        }
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

    @Override // java.lang.Iterable
    public final int getFirst-pVg5ArA() {
        return this.first;
    }

    @Override // java.lang.Iterable
    public final int getLast-pVg5ArA() {
        return this.last;
    }

    @Override // java.lang.Iterable
    public final int getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        int i;
        int step;
        if (isEmpty()) {
            i = -1;
        } else {
            i4 += step;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public boolean isEmpty() {
        int compareUnsigned;
        int i;
        int last;
        i = 1;
        if (this.step > 0) {
            if (Integer.compareUnsigned(this.first, this.last) > 0) {
            } else {
                i = i2;
            }
        } else {
            if (Integer.compareUnsigned(this.first, this.last) < 0) {
            } else {
            }
        }
        return i;
    }

    public final Iterator<UInt> iterator() {
        UIntProgressionIterator uIntProgressionIterator = new UIntProgressionIterator(this.first, this.last, this.step, 0);
        return (Iterator)uIntProgressionIterator;
    }

    @Override // java.lang.Iterable
    public String toString() {
        StringBuilder append;
        int step;
        String string-impl;
        String str = " step ";
        if (this.step > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            append = stringBuilder.append(UInt.toString-impl(this.first)).append("..").append(UInt.toString-impl(this.last)).append(str);
            step = this.step;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            append = stringBuilder2.append(UInt.toString-impl(this.first)).append(" downTo ").append(UInt.toString-impl(this.last)).append(str);
            step = -step3;
        }
        return append.append(step).toString();
    }
}
