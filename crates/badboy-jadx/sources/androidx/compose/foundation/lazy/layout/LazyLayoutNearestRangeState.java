package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 \u00132\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "Landroidx/compose/runtime/State;", "Lkotlin/ranges/IntRange;", "firstVisibleItem", "", "slidingWindowSize", "extraItemCount", "(III)V", "lastFirstVisibleItem", "<set-?>", "value", "getValue", "()Lkotlin/ranges/IntRange;", "setValue", "(Lkotlin/ranges/IntRange;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutNearestRangeState implements State<IntRange> {

    public static final int $stable;
    private static final androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState.Companion Companion;
    private final int extraItemCount;
    private int lastFirstVisibleItem;
    private final int slidingWindowSize;
    private final MutableState value$delegate;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0006H\u0002¨\u0006\t", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState$Companion;", "", "()V", "calculateNearestItemsRange", "Lkotlin/ranges/IntRange;", "firstVisibleItem", "", "slidingWindowSize", "extraItemCount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final IntRange access$calculateNearestItemsRange(androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState.Companion $this, int firstVisibleItem, int slidingWindowSize, int extraItemCount) {
            return $this.calculateNearestItemsRange(firstVisibleItem, slidingWindowSize, extraItemCount);
        }

        private final IntRange calculateNearestItemsRange(int firstVisibleItem, int slidingWindowSize, int extraItemCount) {
            i *= slidingWindowSize;
            return RangesKt.until(Math.max(i2 - extraItemCount, 0), i6 += extraItemCount);
        }
    }
    static {
        LazyLayoutNearestRangeState.Companion companion = new LazyLayoutNearestRangeState.Companion(0);
        LazyLayoutNearestRangeState.Companion = companion;
    }

    public LazyLayoutNearestRangeState(int firstVisibleItem, int slidingWindowSize, int extraItemCount) {
        super();
        this.slidingWindowSize = slidingWindowSize;
        this.extraItemCount = extraItemCount;
        this.value$delegate = SnapshotStateKt.mutableStateOf(LazyLayoutNearestRangeState.Companion.access$calculateNearestItemsRange(LazyLayoutNearestRangeState.Companion, firstVisibleItem, this.slidingWindowSize, this.extraItemCount), SnapshotStateKt.structuralEqualityPolicy());
        this.lastFirstVisibleItem = firstVisibleItem;
    }

    private void setValue(IntRange <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.value$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.State
    public IntRange getValue() {
        final int i = 0;
        final int i2 = 0;
        return (IntRange)(State)this.value$delegate.getValue();
    }

    @Override // androidx.compose.runtime.State
    public final void update(int firstVisibleItem) {
        int lastFirstVisibleItem;
        int slidingWindowSize;
        int extraItemCount;
        if (firstVisibleItem != this.lastFirstVisibleItem) {
            this.lastFirstVisibleItem = firstVisibleItem;
            setValue(LazyLayoutNearestRangeState.Companion.access$calculateNearestItemsRange(LazyLayoutNearestRangeState.Companion, firstVisibleItem, this.slidingWindowSize, this.extraItemCount));
        }
    }
}
