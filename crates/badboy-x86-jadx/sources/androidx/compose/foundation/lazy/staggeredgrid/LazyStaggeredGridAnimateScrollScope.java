package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J7\u0010\u0015\u001a\u00020\u00162'\u0010\u0017\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0018¢\u0006\u0002\u0008\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u0016*\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0008R\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u0008R\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;)V", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "calculateDistanceTo", "", "targetIndex", "calculateVisibleItemsAverageSize", "layoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "scroll", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "index", "scrollOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridAnimateScrollScope implements LazyLayoutAnimateScrollScope {

    public static final int $stable = 8;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state;
    static {
        final int i = 8;
    }

    public LazyStaggeredGridAnimateScrollScope(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state) {
        super();
        this.state = state;
    }

    private final int calculateVisibleItemsAverageSize(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo layoutInfo) {
        int sum$iv;
        int index$iv$iv;
        Object obj3;
        Object obj;
        int i2;
        Object obj2;
        int i;
        int height-impl;
        Orientation vertical;
        final List visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int i5 = 0;
        sum$iv = 0;
        final List list2 = list;
        final int i6 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list2.size()) {
            i2 = 0;
            obj2 = obj;
            i = 0;
            vertical = Orientation.Vertical;
            if (layoutInfo.getOrientation() == vertical) {
            } else {
            }
            height-impl = IntSize.getWidth-impl((LazyStaggeredGridItemInfo)obj2.getSize-YbymL2g());
            sum$iv += height-impl;
            index$iv$iv++;
            height-impl = IntSize.getHeight-impl(obj2.getSize-YbymL2g());
        }
        return i3 += mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public float calculateDistanceTo(int targetIndex) {
        int visibleItemsAverageSize;
        int laneCount$foundation_release;
        int i4;
        int index$iv$iv;
        int i3;
        float size;
        Object obj;
        Object obj3;
        int i2;
        Object obj2;
        int i5;
        int i;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo layoutInfo = this.state.getLayoutInfo();
        if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0;
        }
        int i7 = 0;
        List list = visibleItemsInfo2;
        i4 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i2 = 0;
            i5 = 0;
            if ((LazyStaggeredGridItemInfo)list.get(index$iv$iv).getIndex() == targetIndex) {
            } else {
            }
            i = 0;
            index$iv$iv++;
            i = 1;
        }
        obj3 = 0;
        Object $this$fastFirstOrNull$iv = obj3;
        if ((LazyStaggeredGridItemInfo)$this$fastFirstOrNull$iv == null) {
            laneCount$foundation_release = this.state.getLaneCount$foundation_release();
            i10 -= size;
        } else {
            laneCount$foundation_release = Orientation.Vertical;
            if (layoutInfo.getOrientation() == laneCount$foundation_release) {
                visibleItemsAverageSize = IntOffset.getY-impl((LazyStaggeredGridItemInfo)$this$fastFirstOrNull$iv.getOffset-nOcc-ac());
            } else {
                visibleItemsAverageSize = IntOffset.getX-impl($this$fastFirstOrNull$iv.getOffset-nOcc-ac());
            }
            i3 = (float)visibleItemsAverageSize;
        }
        return i3;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getLastVisibleItemIndex() {
        int index;
        Object lastOrNull = CollectionsKt.lastOrNull(this.state.getLayoutInfo().getVisibleItemsInfo());
        if ((LazyStaggeredGridItemInfo)lastOrNull != null) {
            index = (LazyStaggeredGridItemInfo)lastOrNull.getIndex();
        } else {
            index = 0;
        }
        return index;
    }

    public Object scroll(Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        Object obj8 = ScrollableState.scroll$default((ScrollableState)this.state, 0, block, $completion, 1, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public void snapToItem(ScrollScope $this$snapToItem, int index, int scrollOffset) {
        final int i = 0;
        this.state.snapToItemInternal$foundation_release(index, scrollOffset, true);
    }
}
