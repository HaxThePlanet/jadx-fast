package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Density;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0014\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B£\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000c\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J\t\u0010\\\u001a\u00020JH\u0096\u0001J\u000e\u0010]\u001a\u00020\n2\u0006\u0010^\u001a\u00020\u0014R\u0014\u0010\u001d\u001a\u00020\u0014X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u001e\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00140%X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008'\u0010(R\u0014\u0010\u001c\u001a\u00020\u0014X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010#R\u0011\u0010*\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008+\u0010,R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010,\"\u0004\u0008.\u0010/R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u00101\"\u0004\u00082\u00103R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00105R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u00107R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00109R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008:\u00109\"\u0004\u0008;\u0010<R\u0012\u0010=\u001a\u00020\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008>\u0010#R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010,R\u0014\u0010\u001e\u001a\u00020\u0014X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008?\u0010#R\u0011\u0010\u0008\u001a\u00020\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008@\u0010AR\u0014\u0010B\u001a\u00020CX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008D\u0010ER\u0011\u0010\u000c\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010,R'\u0010G\u001a\u0015\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J\u0018\u00010H¢\u0006\u0002\u0008K8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008L\u0010MR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008N\u0010OR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u0010QR\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008R\u0010#R\u0014\u0010\u001b\u001a\u00020\u0014X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008S\u0010#R\u001c\u0010\u0018\u001a\u00020\u0019X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010V\u001a\u0004\u0008T\u0010UR\u0014\u0010\u001a\u001a\u00020\u0014X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008W\u0010#R\u001a\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008X\u0010YR\u0012\u0010Z\u001a\u00020\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008[\u0010#\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006_", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleItemIndices", "", "firstVisibleItemScrollOffsets", "consumedScroll", "", "measureResult", "canScrollForward", "", "isVertical", "remeasureNeeded", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "spanProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "density", "Landroidx/compose/ui/unit/Density;", "totalItemsCount", "", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "viewportStartOffset", "viewportEndOffset", "beforeContentPadding", "afterContentPadding", "mainAxisItemSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "([I[IFLandroidx/compose/ui/layout/MeasureResult;ZZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;Landroidx/compose/ui/unit/Density;ILjava/util/List;JIIIIILkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getConsumedScroll", "()F", "setConsumedScroll", "(F)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFirstVisibleItemIndices", "()[I", "getFirstVisibleItemScrollOffsets", "setFirstVisibleItemScrollOffsets", "([I)V", "height", "getHeight", "getMainAxisItemSpacing", "getMeasureResult", "()Landroidx/compose/ui/layout/MeasureResult;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getRemeasureNeeded", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "getSlots", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "getSpanProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "getTotalItemsCount", "getViewportEndOffset", "getViewportSize-YbymL2g", "()J", "J", "getViewportStartOffset", "getVisibleItemsInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "tryToApplyScrollWithoutRemeasure", "delta", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridMeasureResult implements androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo, MeasureResult {

    public static final int $stable = 8;
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private boolean canScrollForward;
    private float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final int[] firstVisibleItemIndices;
    private int[] firstVisibleItemScrollOffsets;
    private final boolean isVertical;
    private final int mainAxisItemSpacing;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final boolean remeasureNeeded;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots slots;
    private final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpanProvider spanProvider;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final long viewportSize;
    private final int viewportStartOffset;
    private final List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> visibleItemsInfo;
    static {
        final int i = 8;
    }

    private LazyStaggeredGridMeasureResult(int[] firstVisibleItemIndices, int[] firstVisibleItemScrollOffsets, float consumedScroll, MeasureResult measureResult, boolean canScrollForward, boolean isVertical, boolean remeasureNeeded, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots slots, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpanProvider spanProvider, Density density, int totalItemsCount, List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> visibleItemsInfo, long viewportSize, int viewportStartOffset, int viewportEndOffset, int beforeContentPadding, int afterContentPadding, int mainAxisItemSpacing, CoroutineScope coroutineScope) {
        Orientation horizontal;
        final Object obj = this;
        super();
        obj.firstVisibleItemIndices = firstVisibleItemIndices;
        obj.firstVisibleItemScrollOffsets = firstVisibleItemScrollOffsets;
        obj.consumedScroll = consumedScroll;
        obj.measureResult = measureResult;
        obj.canScrollForward = canScrollForward;
        obj.isVertical = isVertical;
        obj.remeasureNeeded = remeasureNeeded;
        obj.slots = slots;
        obj.spanProvider = spanProvider;
        obj.density = density;
        obj.totalItemsCount = totalItemsCount;
        obj.visibleItemsInfo = visibleItemsInfo;
        obj.viewportSize = viewportSize;
        obj.viewportStartOffset = viewportEndOffset;
        obj.viewportEndOffset = beforeContentPadding;
        obj.beforeContentPadding = afterContentPadding;
        obj.afterContentPadding = mainAxisItemSpacing;
        obj.mainAxisItemSpacing = coroutineScope;
        obj.coroutineScope = obj36;
        horizontal = obj.isVertical ? Orientation.Vertical : Orientation.Horizontal;
        obj.orientation = horizontal;
    }

    public LazyStaggeredGridMeasureResult(int[] iArr, int[] i2Arr2, float f3, MeasureResult measureResult4, boolean z5, boolean z6, boolean z7, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots lazyStaggeredGridSlots8, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider9, Density density10, int i11, List list12, long l13, int i14, int i15, int i16, int i17, int i18, CoroutineScope coroutineScope19, DefaultConstructorMarker defaultConstructorMarker20) {
        super(iArr, i2Arr2, f3, measureResult4, z5, z6, z7, lazyStaggeredGridSlots8, lazyStaggeredGridSpanProvider9, density10, i11, list12, l13, i14, i15, i16, i17, i18, coroutineScope19, defaultConstructorMarker20);
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.measureResult.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final boolean getCanScrollBackward() {
        int i2;
        int i;
        i = 0;
        if (this.firstVisibleItemIndices[i] == 0) {
            if (this.firstVisibleItemScrollOffsets[i] > 0) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final int[] getFirstVisibleItemIndices() {
        return this.firstVisibleItemIndices;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final int[] getFirstVisibleItemScrollOffsets() {
        return this.firstVisibleItemScrollOffsets;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getHeight() {
        return this.measureResult.getHeight();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final MeasureResult getMeasureResult() {
        return this.measureResult;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    public Function1<RulerScope, Unit> getRulers() {
        return this.measureResult.getRulers();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots getSlots() {
        return this.slots;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpanProvider getSpanProvider() {
        return this.spanProvider;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public long getViewportSize-YbymL2g() {
        return this.viewportSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    public List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int getWidth() {
        return this.measureResult.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final boolean isVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public void placeChildren() {
        this.measureResult.placeChildren();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final void setCanScrollForward(boolean <set-?>) {
        this.canScrollForward = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final void setConsumedScroll(float <set-?>) {
        this.consumedScroll = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final void setFirstVisibleItemScrollOffsets(int[] <set-?>) {
        this.firstVisibleItemScrollOffsets = <set-?>;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public final boolean tryToApplyScrollWithoutRemeasure(int delta) {
        int remeasureNeeded;
        int i2;
        int i;
        int index$iv;
        int index$iv2;
        int size;
        Object obj2;
        Object obj;
        int i3;
        int i4;
        boolean nonScrollableItem;
        int mainAxisOffset;
        int viewportEndOffset;
        int viewportStartOffset;
        i2 = 0;
        if (!this.remeasureNeeded && !getVisibleItemsInfo().isEmpty()) {
            if (!getVisibleItemsInfo().isEmpty()) {
                i = 1;
                remeasureNeeded = firstVisibleItemIndices.length == 0 ? i : i2;
                if (remeasureNeeded == 0) {
                    remeasureNeeded = firstVisibleItemScrollOffsets.length == 0 ? i : i2;
                    if (remeasureNeeded != 0) {
                    } else {
                        List visibleItemsInfo2 = getVisibleItemsInfo();
                        int i6 = 0;
                        index$iv2 = 0;
                        while (index$iv2 < visibleItemsInfo2.size()) {
                            obj = obj2;
                            i3 = 0;
                            if (obj.getMainAxisOffset() <= 0) {
                            } else {
                            }
                            nonScrollableItem = i2;
                            if (mainAxisOffset6 += delta <= 0) {
                            } else {
                            }
                            viewportEndOffset = i2;
                            index$iv2++;
                            if (delta < 0) {
                            } else {
                            }
                            if (viewportEndOffset2 -= viewportEndOffset > delta) {
                            } else {
                            }
                            i4 = i2;
                            i4 = i;
                            if (i11 -= viewportEndOffset3 > -delta) {
                            } else {
                            }
                            i4 = i2;
                            i4 = i;
                            if (delta < 0) {
                            } else {
                            }
                            if (viewportStartOffset2 -= viewportStartOffset > delta) {
                            } else {
                            }
                            mainAxisOffset = i2;
                            mainAxisOffset = i;
                            if (i8 -= viewportStartOffset3 > -delta) {
                            } else {
                            }
                            mainAxisOffset = i2;
                            mainAxisOffset = i;
                            viewportEndOffset = i;
                            nonScrollableItem = i;
                        }
                        int length3 = $this$fastForEach$iv.length;
                        int[] iArr = new int[length3];
                        while (i2 < length3) {
                            iArr[i2] = i7 -= delta;
                            i2++;
                        }
                        this.firstVisibleItemScrollOffsets = iArr;
                        List visibleItemsInfo3 = getVisibleItemsInfo();
                        int i5 = 0;
                        index$iv = 0;
                        while (index$iv < visibleItemsInfo3.size()) {
                            obj = 0;
                            (LazyStaggeredGridMeasuredItem)visibleItemsInfo3.get(index$iv).applyScrollDelta(delta);
                            index$iv++;
                        }
                        this.consumedScroll = (float)delta;
                        if (!this.canScrollForward && delta > 0) {
                            if (delta > 0) {
                                this.canScrollForward = i;
                            }
                        }
                    }
                    return i;
                }
            }
        }
        return i2;
    }
}
