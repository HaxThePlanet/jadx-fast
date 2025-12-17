package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.LongIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0016\u0018\u0000 \u00182\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u000eH\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u0019", d2 = {"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class LongProgression implements Iterable<Long>, KMappedMarker {

    public static final kotlin.ranges.LongProgression.Companion Companion;
    private final long first;
    private final long last;
    private final long step;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0006¨\u0006\t", d2 = {"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.ranges.LongProgression fromClosedRange(long rangeStart, long rangeEnd, long step) {
            LongProgression longProgression = new LongProgression(rangeStart, obj2, step, obj4, obj12, obj6);
            return longProgression;
        }
    }
    static {
        LongProgression.Companion companion = new LongProgression.Companion(0);
        LongProgression.Companion = companion;
    }

    public LongProgression(long start, long endInclusive, long step) {
        super();
        if (Long.compare(obj7, i) == 0) {
        } else {
            if (Long.compare(obj7, l) == 0) {
            } else {
                this.first = start;
                this.last = ProgressionUtilKt.getProgressionLastElement(start, endInclusive, step);
                this.step = obj7;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Step must be non-zero.");
        throw illegalArgumentException2;
    }

    @Override // java.lang.Iterable
    public boolean equals(Object other) {
        boolean empty;
        int i;
        long first;
        if (other instanceof LongProgression) {
            if (isEmpty()) {
                if (!(LongProgression)other.isEmpty()) {
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
    public final long getFirst() {
        return this.first;
    }

    @Override // java.lang.Iterable
    public final long getLast() {
        return this.last;
    }

    @Override // java.lang.Iterable
    public final long getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        int i3;
        int i;
        int i4;
        int i2;
        int i5;
        if (isEmpty()) {
            i3 = -1;
        } else {
            long l = (long)i6;
            i2 = 32;
            i3 = (int)i8;
        }
        return i3;
    }

    @Override // java.lang.Iterable
    public boolean isEmpty() {
        int cmp;
        int i;
        i = 1;
        final long first = this.first;
        final long last = this.last;
        if (Long.compare(step, i2) > 0) {
            if (Long.compare(first, last) > 0) {
            } else {
                i = i3;
            }
        } else {
            if (Long.compare(first, last) < 0) {
            } else {
            }
        }
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return (Iterator)iterator();
    }

    @Override // java.lang.Iterable
    public LongIterator iterator() {
        LongProgressionIterator longProgressionIterator = new LongProgressionIterator(this.first, obj2, this.last, obj4, this.step, obj6);
        return (LongIterator)longProgressionIterator;
    }

    @Override // java.lang.Iterable
    public String toString() {
        StringBuilder append;
        long step;
        long last;
        String str = " step ";
        if (Long.compare(step2, i) > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            append = stringBuilder.append(this.first).append("..").append(this.last).append(str);
            step = this.step;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            append = stringBuilder2.append(this.first).append(" downTo ").append(this.last).append(str);
            step = -step3;
        }
        return append.append(step).toString();
    }
}
