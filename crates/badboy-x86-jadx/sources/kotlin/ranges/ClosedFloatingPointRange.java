package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u0008g\u0018\u0000*\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0008\u001a\u00020\u0005H\u0016J\u001d\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000c¨\u0006\r", d2 = {"Lkotlin/ranges/ClosedFloatingPointRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "contains", "", "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "lessThanOrEquals", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ClosedFloatingPointRange<T extends Comparable<? super T>>  extends kotlin.ranges.ClosedRange<T> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean contains(kotlin.ranges.ClosedFloatingPointRange<T> $this, T value) {
            boolean lessThanOrEquals;
            int i;
            Intrinsics.checkNotNullParameter(value, "value");
            if ($this.lessThanOrEquals($this.getStart(), value) && $this.lessThanOrEquals(value, $this.getEndInclusive())) {
                i = $this.lessThanOrEquals(value, $this.getEndInclusive()) ? 1 : 0;
            } else {
            }
            return i;
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(kotlin.ranges.ClosedFloatingPointRange<T> $this) {
            return lessThanOrEquals ^= 1;
        }
    }
    public abstract boolean contains(T t);

    @Override // kotlin.ranges.ClosedRange
    public abstract boolean isEmpty();

    public abstract boolean lessThanOrEquals(T t, T t2);
}
