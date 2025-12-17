package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002BÊ\u0001\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000c\u001a\u00020\u0008\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u00123\u0010\u0012\u001a/\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0014\u0012\u0008\u0008\u0015\u0012\u0004\u0008\u0008(\u0016\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u00180\u00170\u0013\u0012\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u0008\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0002\u0010$J\t\u0010[\u001a\u00020LH\u0096\u0001J\u000e\u0010\\\u001a\u00020\u00082\u0006\u0010]\u001a\u00020\u0006R\u0014\u0010\"\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u001e\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00060(X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008*\u0010+R\u0014\u0010,\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008-\u0010&R\u0011\u0010.\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008/\u00100R\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u00100\"\u0004\u00082\u00103R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00109R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010;R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u0010=R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008>\u0010&\"\u0004\u0008?\u0010@R\u0012\u0010A\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008B\u0010&R\u0014\u0010#\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008C\u0010&R\u0014\u0010 \u001a\u00020!X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008D\u0010ER>\u0010\u0012\u001a/\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0014\u0012\u0008\u0008\u0015\u0012\u0004\u0008\u0008(\u0016\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u00180\u00170\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010GR\u0011\u0010\u000c\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008H\u00100R\u0014\u0010\u001f\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008I\u00100R'\u0010J\u001a\u0015\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L\u0018\u00010\u0013¢\u0006\u0002\u0008M8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008N\u0010GR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008O\u0010&R\u0014\u0010\u001e\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u0010&R\u0014\u0010\u001d\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008Q\u0010&R\u001a\u0010R\u001a\u00020S8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008T\u0010UR\u0014\u0010\u001c\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008V\u0010&R\u001a\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u0017X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008W\u0010XR\u0012\u0010Y\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008Z\u0010&\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006^", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleLine", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "firstVisibleLineScrollOffset", "", "canScrollForward", "", "consumedScroll", "", "measureResult", "remeasureNeeded", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "density", "Landroidx/compose/ui/unit/Density;", "slotsPerLine", "prefetchInfoRetriever", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Constraints;", "visibleItemsInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "afterContentPadding", "mainAxisItemSpacing", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;IZFLandroidx/compose/ui/layout/MeasureResult;ZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function1;Ljava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;II)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "beforeContentPadding", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getConsumedScroll", "()F", "setConsumedScroll", "(F)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFirstVisibleLine", "()Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "getFirstVisibleLineScrollOffset", "setFirstVisibleLineScrollOffset", "(I)V", "height", "getHeight", "getMainAxisItemSpacing", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getPrefetchInfoRetriever", "()Lkotlin/jvm/functions/Function1;", "getRemeasureNeeded", "getReverseLayout", "rulers", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "getSlotsPerLine", "getTotalItemsCount", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "getViewportStartOffset", "getVisibleItemsInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "tryToApplyScrollWithoutRemeasure", "delta", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyGridMeasureResult implements androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo, MeasureResult {

    public static final int $stable = 8;
    private final MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private boolean canScrollForward;
    private float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine firstVisibleLine;
    private int firstVisibleLineScrollOffset;
    private final int mainAxisItemSpacing;
    private final Orientation orientation;
    private final Function1<Integer, List<Pair<Integer, Constraints>>> prefetchInfoRetriever;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final int slotsPerLine;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> visibleItemsInfo;
    static {
        final int i = 8;
    }

    public LazyGridMeasureResult(androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine firstVisibleLine, int firstVisibleLineScrollOffset, boolean canScrollForward, float consumedScroll, MeasureResult measureResult, boolean remeasureNeeded, CoroutineScope coroutineScope, Density density, int slotsPerLine, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> prefetchInfoRetriever, List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> visibleItemsInfo, int viewportStartOffset, int viewportEndOffset, int totalItemsCount, boolean reverseLayout, Orientation orientation, int afterContentPadding, int mainAxisItemSpacing) {
        final Object obj = this;
        super();
        obj.firstVisibleLine = firstVisibleLine;
        obj.firstVisibleLineScrollOffset = firstVisibleLineScrollOffset;
        obj.canScrollForward = canScrollForward;
        obj.consumedScroll = consumedScroll;
        obj.remeasureNeeded = remeasureNeeded;
        obj.coroutineScope = coroutineScope;
        obj.density = density;
        obj.slotsPerLine = slotsPerLine;
        obj.prefetchInfoRetriever = prefetchInfoRetriever;
        obj.visibleItemsInfo = visibleItemsInfo;
        obj.viewportStartOffset = viewportStartOffset;
        obj.viewportEndOffset = viewportEndOffset;
        obj.totalItemsCount = totalItemsCount;
        obj.reverseLayout = reverseLayout;
        obj.orientation = orientation;
        obj.afterContentPadding = afterContentPadding;
        obj.mainAxisItemSpacing = mainAxisItemSpacing;
        obj.$$delegate_0 = measureResult;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getBeforeContentPadding() {
        return -viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final boolean getCanScrollBackward() {
        int firstVisibleLineScrollOffset;
        int i;
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine firstVisibleLine = this.firstVisibleLine;
        if (firstVisibleLine != null) {
            firstVisibleLineScrollOffset = firstVisibleLine.getIndex();
        } else {
            firstVisibleLineScrollOffset = i;
        }
        if (firstVisibleLineScrollOffset == null) {
            if (this.firstVisibleLineScrollOffset != null) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine getFirstVisibleLine() {
        return this.firstVisibleLine;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final int getFirstVisibleLineScrollOffset() {
        return this.firstVisibleLineScrollOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    public final Function1<Integer, List<Pair<Integer, Constraints>>> getPrefetchInfoRetriever() {
        return this.prefetchInfoRetriever;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public Function1<RulerScope, Unit> getRulers() {
        return this.$$delegate_0.getRulers();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public long getViewportSize-YbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    public List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final void setCanScrollForward(boolean <set-?>) {
        this.canScrollForward = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final void setConsumedScroll(float <set-?>) {
        this.consumedScroll = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final void setFirstVisibleLineScrollOffset(int <set-?>) {
        this.firstVisibleLineScrollOffset = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public final boolean tryToApplyScrollWithoutRemeasure(int delta) {
        boolean firstVisibleLine;
        int i2;
        int i;
        int i5;
        boolean nonScrollableItem;
        int deltaToFirstItemChange;
        int i3;
        int index$iv;
        int orientation;
        Object obj2;
        Object obj;
        int i4;
        i2 = 0;
        if (!this.remeasureNeeded && !getVisibleItemsInfo().isEmpty() && this.firstVisibleLine != null) {
            if (!getVisibleItemsInfo().isEmpty()) {
                if (this.firstVisibleLine != null) {
                    firstVisibleLineScrollOffset2 -= delta;
                    i5 = 1;
                    if (i >= 0 && i < this.firstVisibleLine.getMainAxisSizeWithSpacings()) {
                        firstVisibleLine = i < this.firstVisibleLine.getMainAxisSizeWithSpacings() ? i5 : i2;
                    } else {
                    }
                    if (firstVisibleLine == 0) {
                    } else {
                        Object first = CollectionsKt.first(getVisibleItemsInfo());
                        Object last = CollectionsKt.last(getVisibleItemsInfo());
                        if (!(LazyGridMeasuredItem)first.getNonScrollableItem()) {
                            if ((LazyGridMeasuredItem)last.getNonScrollableItem()) {
                            } else {
                                if (delta < 0) {
                                    deltaToFirstItemChange = Math.min(i7 -= viewportStartOffset2, i10 -= viewportEndOffset2) > -delta ? i5 : i2;
                                } else {
                                    deltaToFirstItemChange = Math.min(viewportStartOffset -= offsetOnMainAxis3, viewportEndOffset -= offsetOnMainAxis4) > delta ? i5 : i2;
                                }
                                if (deltaToFirstItemChange != 0) {
                                    this.firstVisibleLineScrollOffset = firstVisibleLineScrollOffset -= delta;
                                    List visibleItemsInfo3 = getVisibleItemsInfo();
                                    i3 = 0;
                                    index$iv = 0;
                                    while (index$iv < visibleItemsInfo3.size()) {
                                        i4 = 0;
                                        (LazyGridMeasuredItem)visibleItemsInfo3.get(index$iv).applyScrollDelta(delta);
                                        index$iv++;
                                    }
                                    this.consumedScroll = (float)delta;
                                    if (!this.canScrollForward && delta > 0) {
                                        if (delta > 0) {
                                            this.canScrollForward = i5;
                                        }
                                    }
                                    i2 = i5;
                                } else {
                                }
                            }
                            return i2;
                        }
                    }
                    return i2;
                }
            }
        }
        return i2;
    }
}
