package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0017\u0018\u0000 \u001a2\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u001f\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0010H\u0016J\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0017H\u0086\u0002J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0008\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0016\u0010\u000c\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\n\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u001b", d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "first", "getFirst-s-VKNKU", "()J", "J", "last", "getLast-s-VKNKU", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ULongProgression implements Iterable<ULong>, KMappedMarker {

    public static final kotlin.ranges.ULongProgression.Companion Companion;
    private final long first;
    private final long last;
    private final long step;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", "", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.ranges.ULongProgression fromClosedRange-7ftBX0g(long rangeStart, long rangeEnd, long step) {
            ULongProgression uLongProgression = new ULongProgression(rangeStart, obj2, step, obj4, obj13, obj6, 0);
            return uLongProgression;
        }
    }
    static {
        ULongProgression.Companion companion = new ULongProgression.Companion(0);
        ULongProgression.Companion = companion;
    }

    private ULongProgression(long start, long endInclusive, long step) {
        super();
        if (Long.compare(obj7, i) == 0) {
        } else {
            if (Long.compare(obj7, l) == 0) {
            } else {
                this.first = start;
                this.last = UProgressionUtilKt.getProgressionLastElement-7ftBX0g(start, endInclusive, step);
                this.step = obj7;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Step must be non-zero.");
        throw illegalArgumentException2;
    }

    public ULongProgression(long l, long l2, long l3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(l, l2, l3, defaultConstructorMarker4, obj5, obj6);
    }

    @Override // java.lang.Iterable
    public boolean equals(Object other) {
        boolean empty;
        int i;
        long first;
        if (other instanceof ULongProgression) {
            if (isEmpty()) {
                if (!(ULongProgression)other.isEmpty()) {
                    if (Long.compare(first2, first) == 0 && Long.compare(last, first) == 0 && Long.compare(step, first) == 0) {
                        if (Long.compare(last, first) == 0) {
                            i = Long.compare(step, first) == 0 ? 1 : 0;
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
    public final long getFirst-s-VKNKU() {
        return this.first;
    }

    @Override // java.lang.Iterable
    public final long getLast-s-VKNKU() {
        return this.last;
    }

    @Override // java.lang.Iterable
    public final long getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        int i;
        long l2;
        long constructor-impl;
        long l;
        int i2;
        long step;
        if (isEmpty()) {
            i = -1;
        } else {
            i2 = 32;
            constructor-impl = ULong.constructor-impl(first2 >>>= i2);
            i7 += l2;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public boolean isEmpty() {
        int compareUnsigned;
        int i;
        i = 1;
        final long first = this.first;
        final long last = this.last;
        if (Long.compare(step, i2) > 0) {
            if (Long.compareUnsigned(first, obj4) > 0) {
            } else {
                i = i3;
            }
        } else {
            if (Long.compareUnsigned(first, obj4) < 0) {
            } else {
            }
        }
        return i;
    }

    public final Iterator<ULong> iterator() {
        ULongProgressionIterator uLongProgressionIterator = new ULongProgressionIterator(this.first, obj2, this.last, obj4, this.step, obj6, 0);
        return (Iterator)uLongProgressionIterator;
    }

    @Override // java.lang.Iterable
    public String toString() {
        StringBuilder append;
        long step;
        String string-impl;
        String str = " step ";
        if (Long.compare(step2, i) > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            append = stringBuilder.append(ULong.toString-impl(this.first)).append("..").append(ULong.toString-impl(this.last)).append(str);
            step = this.step;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            append = stringBuilder2.append(ULong.toString-impl(this.first)).append(" downTo ").append(ULong.toString-impl(this.last)).append(str);
            step = -step3;
        }
        return append.append(step).toString();
    }
}
