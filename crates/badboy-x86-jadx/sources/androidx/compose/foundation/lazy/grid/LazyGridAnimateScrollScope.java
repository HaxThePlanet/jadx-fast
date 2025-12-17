package androidx.compose.foundation.lazy.grid;

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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J7\u0010\u0015\u001a\u00020\u00162'\u0010\u0017\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0018¢\u0006\u0002\u0008\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u0016*\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0008R\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u0008R\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)V", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "calculateDistanceTo", "", "targetIndex", "calculateLineAverageMainAxisSize", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "scroll", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "index", "scrollOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyGridAnimateScrollScope implements LazyLayoutAnimateScrollScope {

    public static final int $stable;
    private final androidx.compose.foundation.lazy.grid.LazyGridState state;
    static {
    }

    public LazyGridAnimateScrollScope(androidx.compose.foundation.lazy.grid.LazyGridState state) {
        super();
        this.state = state;
    }

    private final int calculateLineAverageMainAxisSize(androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo layoutInfo) {
        int i;
        int totalLinesMainAxisSize;
        int linesCount;
        int lineStartIndex;
        int intValue2;
        int lineMainAxisSize;
        int lineEndIndex;
        int intValue;
        int height-impl;
        i = layoutInfo.getOrientation() == Orientation.Vertical ? 1 : 0;
        List visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        LazyGridAnimateScrollScope.calculateLineAverageMainAxisSize.lineOf.1 anon = new LazyGridAnimateScrollScope.calculateLineAverageMainAxisSize.lineOf.1(i, visibleItemsInfo);
        totalLinesMainAxisSize = 0;
        linesCount = 0;
        lineStartIndex = 0;
        while (lineStartIndex < visibleItemsInfo.size()) {
            intValue2 = (Number)(Function1)anon.invoke(Integer.valueOf(lineStartIndex)).intValue();
            if (intValue2 == -1) {
            } else {
            }
            lineMainAxisSize = 0;
            lineEndIndex = lineStartIndex;
            while (lineEndIndex < visibleItemsInfo.size()) {
                if ((Number)anon.invoke(Integer.valueOf(lineEndIndex)).intValue() == intValue2) {
                }
                if (i != 0) {
                } else {
                }
                height-impl = IntSize.getWidth-impl((LazyGridItemInfo)visibleItemsInfo.get(lineEndIndex).getSize-YbymL2g());
                lineMainAxisSize = intValue;
                lineEndIndex++;
                height-impl = IntSize.getHeight-impl((LazyGridItemInfo)visibleItemsInfo.get(lineEndIndex).getSize-YbymL2g());
            }
            totalLinesMainAxisSize += lineMainAxisSize;
            linesCount++;
            lineStartIndex = lineEndIndex;
            if ((Number)anon.invoke(Integer.valueOf(lineEndIndex)).intValue() == intValue2) {
            }
            if (i != 0) {
            } else {
            }
            height-impl = IntSize.getWidth-impl((LazyGridItemInfo)visibleItemsInfo.get(lineEndIndex).getSize-YbymL2g());
            lineMainAxisSize = intValue;
            lineEndIndex++;
            height-impl = IntSize.getHeight-impl((LazyGridItemInfo)visibleItemsInfo.get(lineEndIndex).getSize-YbymL2g());
            lineStartIndex++;
        }
        return i2 += mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public float calculateDistanceTo(int targetIndex) {
        int slotsPerLine$foundation_release;
        int lineAverageMainAxisSize;
        int i6;
        int index$iv$iv;
        int i2;
        float size;
        int i3;
        int i;
        Object obj3;
        Object obj;
        int i5;
        Object obj2;
        int i4;
        final Object obj4 = this;
        final int i7 = targetIndex;
        androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo layoutInfo = obj4.state.getLayoutInfo();
        if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0;
        }
        int i9 = 0;
        List list = visibleItemsInfo2;
        i6 = 0;
        index$iv$iv = 0;
        i = 1;
        while (index$iv$iv < list.size()) {
            i5 = 0;
            i4 = 0;
            if ((LazyGridItemInfo)list.get(index$iv$iv).getIndex() == i7) {
            } else {
            }
            i3 = 0;
            index$iv$iv++;
            i = 1;
            i3 = i;
        }
        obj = 0;
        Object $this$fastFirstOrNull$iv = obj;
        if ((LazyGridItemInfo)$this$fastFirstOrNull$iv == null) {
            slotsPerLine$foundation_release = obj4.state.getSlotsPerLine$foundation_release();
            i3 = i7 < obj4.getFirstVisibleItemIndex() ? i : 0;
            if (i3 != 0) {
                i = -1;
            }
            f -= size;
        } else {
            lineAverageMainAxisSize = Orientation.Vertical;
            if (layoutInfo.getOrientation() == lineAverageMainAxisSize) {
                slotsPerLine$foundation_release = IntOffset.getY-impl((LazyGridItemInfo)$this$fastFirstOrNull$iv.getOffset-nOcc-ac());
            } else {
                slotsPerLine$foundation_release = IntOffset.getX-impl($this$fastFirstOrNull$iv.getOffset-nOcc-ac());
            }
            i2 = (float)slotsPerLine$foundation_release;
        }
        return i2;
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
        if ((LazyGridItemInfo)lastOrNull != null) {
            index = (LazyGridItemInfo)lastOrNull.getIndex();
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
        this.state.snapToItemIndexInternal$foundation_release(index, scrollOffset, true);
    }
}
