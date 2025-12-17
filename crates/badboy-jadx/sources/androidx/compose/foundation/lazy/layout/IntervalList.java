package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008w\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0010J6\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u00042\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\r\u0012\u0004\u0012\u00020\u00080\u000cH&J\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000f\u001a\u00020\u0004H¦\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0001\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0012À\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/layout/IntervalList;", "T", "", "size", "", "getSize", "()I", "forEach", "", "fromIndex", "toIndex", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "get", "index", "Interval", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IntervalList<T>  {

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008\u0007\u0018\u0000*\u0006\u0008\u0001\u0010\u0001 \u00012\u00020\u0002B\u001f\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0001¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0013\u0010\u0006\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "T", "", "startIndex", "", "size", "value", "(IILjava/lang/Object;)V", "getSize", "()I", "getStartIndex", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Interval {

        public static final int $stable;
        private final int size;
        private final int startIndex;
        private final T value;
        static {
        }

        public Interval(int startIndex, int size, T value) {
            int i2;
            int i;
            super();
            this.startIndex = startIndex;
            this.size = size;
            this.value = value;
            int i5 = 0;
            i2 = this.startIndex >= 0 ? i : i5;
            if (i2 == 0) {
            } else {
                if (this.size > 0) {
                } else {
                    i = i5;
                }
                if (i == 0) {
                } else {
                }
                int i4 = 0;
                StringBuilder stringBuilder2 = new StringBuilder();
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("size should be >0, but was ").append(this.size).toString().toString());
                throw illegalArgumentException2;
            }
            int i3 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("startIndex should be >= 0, but was ").append(this.startIndex).toString().toString());
            throw illegalArgumentException;
        }

        public final int getSize() {
            return this.size;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final T getValue() {
            return this.value;
        }
    }
    public static void forEach$default(androidx.compose.foundation.lazy.layout.IntervalList intervalList, int i2, int i3, Function1 function14, int i5, Object object6) {
        int obj1;
        int obj2;
        if (object6 != null) {
        } else {
            if (i5 & 1 != 0) {
                obj1 = 0;
            }
            if (i5 &= 2 != 0) {
                obj2--;
            }
            intervalList.forEach(obj1, obj2, function14);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forEach");
        throw obj0;
    }

    public abstract void forEach(int i, int i2, Function1<? super androidx.compose.foundation.lazy.layout.IntervalList.Interval<? extends T>, Unit> function13);

    public abstract androidx.compose.foundation.lazy.layout.IntervalList.Interval<T> get(int i);

    public abstract int getSize();
}
