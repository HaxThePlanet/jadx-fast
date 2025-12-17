package androidx.core.util;

import android.util.Range;
import kotlin.Metadata;
import kotlin.ranges.ClosedRange;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a7\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\u000c\u001a6\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0007\u001a7\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\n\u001a0\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\t\u001a\u0002H\u0002H\u0087\u000c¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000c\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a(\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u000cH\u0007¨\u0006\u000e", d2 = {"and", "Landroid/util/Range;", "T", "", "other", "plus", "value", "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", "rangeTo", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", "toClosedRange", "Lkotlin/ranges/ClosedRange;", "toRange", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RangeKt {
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> $this$and, Range<T> other) {
        final int i = 0;
        return $this$and.intersect(other);
    }

    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> $this$plus, Range<T> other) {
        final int i = 0;
        return $this$plus.extend(other);
    }

    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> $this$plus, T value) {
        final int i = 0;
        return $this$plus.extend(value);
    }

    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T $this$rangeTo, T that) {
        final int i = 0;
        Range range = new Range($this$rangeTo, that);
        return range;
    }

    public static final <T extends Comparable<? super T>> ClosedRange<T> toClosedRange(Range<T> $this$toClosedRange) {
        RangeKt.toClosedRange.1 anon = new RangeKt.toClosedRange.1($this$toClosedRange);
        return (ClosedRange)anon;
    }

    public static final <T extends Comparable<? super T>> Range<T> toRange(ClosedRange<T> $this$toRange) {
        Range range = new Range($this$toRange.getStart(), $this$toRange.getEndInclusive());
        return range;
    }
}
