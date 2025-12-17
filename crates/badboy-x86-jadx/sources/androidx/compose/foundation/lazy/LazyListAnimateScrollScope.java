package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J7\u0010\u0015\u001a\u00020\u00162'\u0010\u0017\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0018¢\u0006\u0002\u0008\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u0016*\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0008R\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u0008R\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Landroidx/compose/foundation/lazy/LazyListAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;)V", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "calculateDistanceTo", "", "targetIndex", "calculateVisibleItemsAverageSize", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "scroll", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "index", "scrollOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyListAnimateScrollScope implements LazyLayoutAnimateScrollScope {

    public static final int $stable;
    private final androidx.compose.foundation.lazy.LazyListState state;
    static {
    }

    public LazyListAnimateScrollScope(androidx.compose.foundation.lazy.LazyListState state) {
        super();
        this.state = state;
    }

    private final int calculateVisibleItemsAverageSize(androidx.compose.foundation.lazy.LazyListLayoutInfo layoutInfo) {
        int sum$iv;
        int index$iv$iv;
        Object obj2;
        Object obj;
        int i;
        int it;
        int i2;
        final List visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int i5 = 0;
        sum$iv = 0;
        final List list2 = list;
        final int i6 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list2.size()) {
            i = 0;
            i2 = 0;
            sum$iv += it;
            index$iv$iv++;
        }
        return i3 += mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public float calculateDistanceTo(int targetIndex) {
        int visibleItemsAverageSize;
        int list;
        int i4;
        int index$iv$iv;
        Object obj3;
        Object obj;
        int i2;
        Object obj2;
        int i3;
        int i;
        androidx.compose.foundation.lazy.LazyListLayoutInfo layoutInfo = this.state.getLayoutInfo();
        if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0;
        }
        int i6 = 0;
        list = visibleItemsInfo2;
        int i7 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i2 = 0;
            i3 = 0;
            if ((LazyListItemInfo)list.get(index$iv$iv).getIndex() == targetIndex) {
            } else {
            }
            i = 0;
            index$iv$iv++;
            i = 1;
        }
        obj = 0;
        Object $this$fastFirstOrNull$iv = obj;
        if ((LazyListItemInfo)$this$fastFirstOrNull$iv == null) {
            f -= index$iv$iv;
        } else {
            i4 = (float)visibleItemsAverageSize;
        }
        return i4;
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
        if ((LazyListItemInfo)lastOrNull != null) {
            index = (LazyListItemInfo)lastOrNull.getIndex();
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
