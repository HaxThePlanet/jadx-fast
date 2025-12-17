package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u009d\u0001\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000c\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0008\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0008\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0002\u0010\u001eJ\t\u0010W\u001a\u00020HH\u0096\u0001J\u0016\u0010X\u001a\u00020\u00082\u0006\u0010Y\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0008R\u0014\u0010\u001c\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u001e\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00060\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0014\u0010&\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010 R\u0011\u0010(\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008)\u0010*R\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010*\"\u0004\u0008,\u0010-R\u0019\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00100\u001a\u0004\u0008.\u0010/R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u00106R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010:R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008;\u0010 \"\u0004\u0008<\u0010=R\u0012\u0010>\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008?\u0010 R\u0014\u0010\u001d\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008@\u0010 R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008A\u0010BR\u0011\u0010\r\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008C\u0010*R\u0014\u0010\u0019\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008D\u0010*R'\u0010E\u001a\u0015\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H\u0018\u00010F¢\u0006\u0002\u0008I8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008J\u0010KR\u0011\u0010\u000c\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008L\u00102R\u0014\u0010\u0018\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008M\u0010 R\u0014\u0010\u0017\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008N\u0010 R\u001a\u0010O\u001a\u00020P8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008Q\u0010/R\u0014\u0010\u0016\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008R\u0010 R\u001a\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0015X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008S\u0010TR\u0012\u0010U\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008V\u0010 \u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006[", d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleItem", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "firstVisibleItemScrollOffset", "", "canScrollForward", "", "consumedScroll", "", "measureResult", "scrollBackAmount", "remeasureNeeded", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "density", "Landroidx/compose/ui/unit/Density;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "visibleItemsInfo", "", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "afterContentPadding", "mainAxisItemSpacing", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;IZFLandroidx/compose/ui/layout/MeasureResult;FZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;JLjava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "beforeContentPadding", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getChildConstraints-msEJaDk", "()J", "J", "getConsumedScroll", "()F", "setConsumedScroll", "(F)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFirstVisibleItem", "()Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "getFirstVisibleItemScrollOffset", "setFirstVisibleItemScrollOffset", "(I)V", "height", "getHeight", "getMainAxisItemSpacing", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getRemeasureNeeded", "getReverseLayout", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "getScrollBackAmount", "getTotalItemsCount", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "getViewportStartOffset", "getVisibleItemsInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "tryToApplyScrollWithoutRemeasure", "delta", "updateAnimations", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyListMeasureResult implements androidx.compose.foundation.lazy.LazyListLayoutInfo, MeasureResult {

    public static final int $stable = 8;
    private final MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private boolean canScrollForward;
    private final long childConstraints;
    private float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final androidx.compose.foundation.lazy.LazyListMeasuredItem firstVisibleItem;
    private int firstVisibleItemScrollOffset;
    private final int mainAxisItemSpacing;
    private final Orientation orientation;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final float scrollBackAmount;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<androidx.compose.foundation.lazy.LazyListMeasuredItem> visibleItemsInfo;
    static {
        final int i = 8;
    }

    private LazyListMeasureResult(androidx.compose.foundation.lazy.LazyListMeasuredItem firstVisibleItem, int firstVisibleItemScrollOffset, boolean canScrollForward, float consumedScroll, MeasureResult measureResult, float scrollBackAmount, boolean remeasureNeeded, CoroutineScope coroutineScope, Density density, long childConstraints, List<androidx.compose.foundation.lazy.LazyListMeasuredItem> visibleItemsInfo, int viewportStartOffset, int viewportEndOffset, int totalItemsCount, boolean reverseLayout, Orientation orientation, int afterContentPadding, int mainAxisItemSpacing) {
        final Object obj = this;
        super();
        obj.firstVisibleItem = firstVisibleItem;
        obj.firstVisibleItemScrollOffset = firstVisibleItemScrollOffset;
        obj.canScrollForward = canScrollForward;
        obj.consumedScroll = consumedScroll;
        obj.scrollBackAmount = scrollBackAmount;
        obj.remeasureNeeded = remeasureNeeded;
        obj.coroutineScope = coroutineScope;
        obj.density = density;
        obj.childConstraints = childConstraints;
        obj.visibleItemsInfo = viewportStartOffset;
        obj.viewportStartOffset = viewportEndOffset;
        obj.viewportEndOffset = totalItemsCount;
        obj.totalItemsCount = reverseLayout;
        obj.reverseLayout = orientation;
        obj.orientation = afterContentPadding;
        obj.afterContentPadding = mainAxisItemSpacing;
        obj.mainAxisItemSpacing = obj35;
        obj.$$delegate_0 = measureResult;
    }

    public LazyListMeasureResult(androidx.compose.foundation.lazy.LazyListMeasuredItem lazyListMeasuredItem, int i2, boolean z3, float f4, MeasureResult measureResult5, float f6, boolean z7, CoroutineScope coroutineScope8, Density density9, long l10, List list11, int i12, int i13, int i14, boolean z15, Orientation orientation16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker19) {
        super(lazyListMeasuredItem, i2, z3, f4, measureResult5, f6, z7, coroutineScope8, density9, l10, list11, i12, i13, i14, z15, orientation16, i17, i18, defaultConstructorMarker19);
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getBeforeContentPadding() {
        return -viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final boolean getCanScrollBackward() {
        int firstVisibleItemScrollOffset;
        int i;
        androidx.compose.foundation.lazy.LazyListMeasuredItem firstVisibleItem = this.firstVisibleItem;
        if (firstVisibleItem != null) {
            firstVisibleItemScrollOffset = firstVisibleItem.getIndex();
        } else {
            firstVisibleItemScrollOffset = i;
        }
        if (firstVisibleItemScrollOffset == null) {
            if (this.firstVisibleItemScrollOffset != null) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final long getChildConstraints-msEJaDk() {
        return this.childConstraints;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final androidx.compose.foundation.lazy.LazyListMeasuredItem getFirstVisibleItem() {
        return this.firstVisibleItem;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final int getFirstVisibleItemScrollOffset() {
        return this.firstVisibleItemScrollOffset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public Function1<RulerScope, Unit> getRulers() {
        return this.$$delegate_0.getRulers();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final float getScrollBackAmount() {
        return this.scrollBackAmount;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public long getViewportSize-YbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    public List<androidx.compose.foundation.lazy.LazyListMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final void setCanScrollForward(boolean <set-?>) {
        this.canScrollForward = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final void setConsumedScroll(float <set-?>) {
        this.consumedScroll = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final void setFirstVisibleItemScrollOffset(int <set-?>) {
        this.firstVisibleItemScrollOffset = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final boolean tryToApplyScrollWithoutRemeasure(int delta, boolean updateAnimations) {
        boolean firstVisibleItem;
        int i;
        int i2;
        int i4;
        boolean nonScrollableItem;
        int deltaToFirstItemChange;
        int i3;
        int index$iv;
        int size;
        Object obj2;
        Object obj;
        int i5;
        i = 0;
        if (!this.remeasureNeeded && !getVisibleItemsInfo().isEmpty() && this.firstVisibleItem != null) {
            if (!getVisibleItemsInfo().isEmpty()) {
                if (this.firstVisibleItem != null) {
                    firstVisibleItemScrollOffset2 -= delta;
                    i4 = 1;
                    if (i2 >= 0 && i2 < this.firstVisibleItem.getMainAxisSizeWithSpacings()) {
                        firstVisibleItem = i2 < this.firstVisibleItem.getMainAxisSizeWithSpacings() ? i4 : i;
                    } else {
                    }
                    if (firstVisibleItem == 0) {
                    } else {
                        Object first = CollectionsKt.first(getVisibleItemsInfo());
                        Object last = CollectionsKt.last(getVisibleItemsInfo());
                        if (!(LazyListMeasuredItem)first.getNonScrollableItem()) {
                            if ((LazyListMeasuredItem)last.getNonScrollableItem()) {
                            } else {
                                if (delta < 0) {
                                    deltaToFirstItemChange = Math.min(i7 -= viewportStartOffset2, i10 -= viewportEndOffset2) > -delta ? i4 : i;
                                } else {
                                    deltaToFirstItemChange = Math.min(viewportStartOffset -= offset3, viewportEndOffset -= offset4) > delta ? i4 : i;
                                }
                                if (deltaToFirstItemChange != 0) {
                                    this.firstVisibleItemScrollOffset = firstVisibleItemScrollOffset -= delta;
                                    List visibleItemsInfo3 = getVisibleItemsInfo();
                                    i3 = 0;
                                    index$iv = 0;
                                    while (index$iv < visibleItemsInfo3.size()) {
                                        i5 = 0;
                                        (LazyListMeasuredItem)visibleItemsInfo3.get(index$iv).applyScrollDelta(delta, updateAnimations);
                                        index$iv++;
                                    }
                                    this.consumedScroll = (float)delta;
                                    if (!this.canScrollForward && delta > 0) {
                                        if (delta > 0) {
                                            this.canScrollForward = i4;
                                        }
                                    }
                                    i = i4;
                                } else {
                                }
                            }
                            return i;
                        }
                    }
                    return i;
                }
            }
        }
        return i;
    }
}
