package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0012\u0018\u0000*\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u0013", d2 = {"Lkotlin/ranges/ComparableOpenEndRange;", "T", "", "Lkotlin/ranges/OpenEndRange;", "start", "endExclusive", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getEndExclusive", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getStart", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
class ComparableOpenEndRange<T extends Comparable<? super T>>  implements kotlin.ranges.OpenEndRange<T> {

    private final T endExclusive;
    private final T start;
    public ComparableOpenEndRange(T start, T endExclusive) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(endExclusive, "endExclusive");
        super();
        this.start = start;
        this.endExclusive = endExclusive;
    }

    public boolean contains(T value) {
        return OpenEndRange.DefaultImpls.contains(this, value);
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean equals(Object other) {
        int i;
        boolean empty;
        Comparable endExclusive;
        if (other instanceof ComparableOpenEndRange) {
            if (isEmpty()) {
                if (!(ComparableOpenEndRange)other.isEmpty()) {
                    if (Intrinsics.areEqual(getStart(), (ComparableOpenEndRange)other.getStart()) && Intrinsics.areEqual(getEndExclusive(), (ComparableOpenEndRange)other.getEndExclusive())) {
                        i = Intrinsics.areEqual(getEndExclusive(), (ComparableOpenEndRange)other.getEndExclusive()) ? 1 : 0;
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

    public T getEndExclusive() {
        return this.endExclusive;
    }

    public T getStart() {
        return this.start;
    }

    @Override // kotlin.ranges.OpenEndRange
    public int hashCode() {
        int i;
        int i2;
        if (isEmpty()) {
            i = -1;
        } else {
            i4 += i2;
        }
        return i;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        return OpenEndRange.DefaultImpls.isEmpty(this);
    }

    @Override // kotlin.ranges.OpenEndRange
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getStart()).append("..<").append(getEndExclusive()).toString();
    }
}
