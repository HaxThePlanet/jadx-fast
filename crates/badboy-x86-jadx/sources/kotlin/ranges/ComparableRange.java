package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0012\u0018\u0000*\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u0013", d2 = {"Lkotlin/ranges/ComparableRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "start", "endInclusive", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getEndInclusive", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getStart", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
class ComparableRange<T extends Comparable<? super T>>  implements kotlin.ranges.ClosedRange<T> {

    private final T endInclusive;
    private final T start;
    public ComparableRange(T start, T endInclusive) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(endInclusive, "endInclusive");
        super();
        this.start = start;
        this.endInclusive = endInclusive;
    }

    public boolean contains(T value) {
        return ClosedRange.DefaultImpls.contains(this, value);
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean equals(Object other) {
        int i;
        boolean empty;
        Comparable endInclusive;
        if (other instanceof ComparableRange) {
            if (isEmpty()) {
                if (!(ComparableRange)other.isEmpty()) {
                    if (Intrinsics.areEqual(getStart(), (ComparableRange)other.getStart()) && Intrinsics.areEqual(getEndInclusive(), (ComparableRange)other.getEndInclusive())) {
                        i = Intrinsics.areEqual(getEndInclusive(), (ComparableRange)other.getEndInclusive()) ? 1 : 0;
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

    public T getEndInclusive() {
        return this.endInclusive;
    }

    public T getStart() {
        return this.start;
    }

    @Override // kotlin.ranges.ClosedRange
    public int hashCode() {
        int i2;
        int i;
        if (isEmpty()) {
            i2 = -1;
        } else {
            i4 += i;
        }
        return i2;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }

    @Override // kotlin.ranges.ClosedRange
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getStart()).append("..").append(getEndInclusive()).toString();
    }
}
