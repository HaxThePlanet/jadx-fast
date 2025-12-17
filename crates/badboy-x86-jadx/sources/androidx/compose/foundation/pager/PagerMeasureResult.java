package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerScope;
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
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B¿\u0001\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u000e\u0008\u0002\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0008\u0002\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\t\u0010Y\u001a\u00020JH\u0096\u0001J\u000e\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u0007R\u0014\u0010\t\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u001e\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00070#X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u0014\u0010'\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008(\u0010!R\u0014\u0010\u0010\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010!R\u0011\u0010*\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\u0008+\u0010,R\u001a\u0010\u0016\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010,\"\u0004\u0008.\u0010/R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u00101R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u00103R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107R\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00109R\u0017\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u00109R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u00103R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008<\u0010!\"\u0004\u0008=\u0010>R\u0012\u0010?\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008@\u0010!R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008A\u0010BR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008C\u0010!R\u0014\u0010\u0008\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008D\u0010!R\u0011\u0010\u001a\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008E\u0010,R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010,R'\u0010G\u001a\u0015\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J\u0018\u00010H¢\u0006\u0002\u0008K8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008L\u0010MR\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008N\u0010OR\u0014\u0010\r\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u0010!R\u001a\u0010Q\u001a\u00020R8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008S\u0010TR\u0014\u0010\u000c\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008U\u0010!R\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008V\u00109R\u0012\u0010W\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008X\u0010!\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\\", d2 = {"Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "visiblePagesInfo", "", "Landroidx/compose/foundation/pager/MeasuredPage;", "pageSize", "", "pageSpacing", "afterContentPadding", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "viewportStartOffset", "viewportEndOffset", "reverseLayout", "", "beyondViewportPageCount", "firstVisiblePage", "currentPage", "currentPageOffsetFraction", "", "firstVisiblePageScrollOffset", "canScrollForward", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "measureResult", "remeasureNeeded", "extraPagesBefore", "extraPagesAfter", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Ljava/util/List;IIILandroidx/compose/foundation/gestures/Orientation;IIZILandroidx/compose/foundation/pager/MeasuredPage;Landroidx/compose/foundation/pager/MeasuredPage;FIZLandroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/ui/layout/MeasureResult;ZLjava/util/List;Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "beforeContentPadding", "getBeforeContentPadding", "getBeyondViewportPageCount", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getCurrentPage", "()Landroidx/compose/foundation/pager/MeasuredPage;", "getCurrentPageOffsetFraction", "()F", "setCurrentPageOffsetFraction", "(F)V", "getExtraPagesAfter", "()Ljava/util/List;", "getExtraPagesBefore", "getFirstVisiblePage", "getFirstVisiblePageScrollOffset", "setFirstVisiblePageScrollOffset", "(I)V", "height", "getHeight", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getPageSize", "getPageSpacing", "getRemeasureNeeded", "getReverseLayout", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulers", "()Lkotlin/jvm/functions/Function1;", "getSnapPosition", "()Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "getViewportStartOffset", "getVisiblePagesInfo", "width", "getWidth", "placeChildren", "tryToApplyScrollWithoutRemeasure", "delta", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PagerMeasureResult implements androidx.compose.foundation.pager.PagerLayoutInfo, MeasureResult {

    public static final int $stable = 8;
    private final MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private final int beyondViewportPageCount;
    private boolean canScrollForward;
    private final CoroutineScope coroutineScope;
    private final androidx.compose.foundation.pager.MeasuredPage currentPage;
    private float currentPageOffsetFraction;
    private final List<androidx.compose.foundation.pager.MeasuredPage> extraPagesAfter;
    private final List<androidx.compose.foundation.pager.MeasuredPage> extraPagesBefore;
    private final androidx.compose.foundation.pager.MeasuredPage firstVisiblePage;
    private int firstVisiblePageScrollOffset;
    private final Orientation orientation;
    private final int pageSize;
    private final int pageSpacing;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final SnapPosition snapPosition;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<androidx.compose.foundation.pager.MeasuredPage> visiblePagesInfo;
    static {
        final int i = 8;
    }

    public PagerMeasureResult(List<androidx.compose.foundation.pager.MeasuredPage> visiblePagesInfo, int pageSize, int pageSpacing, int afterContentPadding, Orientation orientation, int viewportStartOffset, int viewportEndOffset, boolean reverseLayout, int beyondViewportPageCount, androidx.compose.foundation.pager.MeasuredPage firstVisiblePage, androidx.compose.foundation.pager.MeasuredPage currentPage, float currentPageOffsetFraction, int firstVisiblePageScrollOffset, boolean canScrollForward, SnapPosition snapPosition, MeasureResult measureResult, boolean remeasureNeeded, List<androidx.compose.foundation.pager.MeasuredPage> extraPagesBefore, List<androidx.compose.foundation.pager.MeasuredPage> extraPagesAfter, CoroutineScope coroutineScope) {
        final Object obj = this;
        super();
        obj.visiblePagesInfo = visiblePagesInfo;
        obj.pageSize = pageSize;
        obj.pageSpacing = pageSpacing;
        obj.afterContentPadding = afterContentPadding;
        obj.orientation = orientation;
        obj.viewportStartOffset = viewportStartOffset;
        obj.viewportEndOffset = viewportEndOffset;
        obj.reverseLayout = reverseLayout;
        obj.beyondViewportPageCount = beyondViewportPageCount;
        obj.firstVisiblePage = firstVisiblePage;
        obj.currentPage = currentPage;
        obj.currentPageOffsetFraction = currentPageOffsetFraction;
        obj.firstVisiblePageScrollOffset = firstVisiblePageScrollOffset;
        obj.canScrollForward = canScrollForward;
        obj.snapPosition = snapPosition;
        obj.remeasureNeeded = remeasureNeeded;
        obj.extraPagesBefore = extraPagesBefore;
        obj.extraPagesAfter = extraPagesAfter;
        obj.coroutineScope = coroutineScope;
        obj.$$delegate_0 = measureResult;
    }

    public PagerMeasureResult(List list, int i2, int i3, int i4, Orientation orientation5, int i6, int i7, boolean z8, int i9, androidx.compose.foundation.pager.MeasuredPage measuredPage10, androidx.compose.foundation.pager.MeasuredPage measuredPage11, float f12, int i13, boolean z14, SnapPosition snapPosition15, MeasureResult measureResult16, boolean z17, List list18, List list19, CoroutineScope coroutineScope20, int i21, DefaultConstructorMarker defaultConstructorMarker22) {
        List emptyList2;
        int emptyList;
        List list2;
        List list3;
        if (i21 & i != 0) {
            list2 = emptyList2;
        } else {
            list2 = list18;
        }
        if (i21 & i5 != 0) {
            list3 = emptyList;
        } else {
            list3 = list19;
        }
        super(list, i2, i3, i4, orientation5, i6, i7, z8, i9, measuredPage10, measuredPage11, f12, i13, z14, snapPosition15, measureResult16, z17, list2, list3, coroutineScope20);
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeforeContentPadding() {
        return -viewportStartOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeyondViewportPageCount() {
        return this.beyondViewportPageCount;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final boolean getCanScrollBackward() {
        int firstVisiblePageScrollOffset;
        int i;
        androidx.compose.foundation.pager.MeasuredPage firstVisiblePage = this.firstVisiblePage;
        if (firstVisiblePage != null) {
            firstVisiblePageScrollOffset = firstVisiblePage.getIndex();
        } else {
            firstVisiblePageScrollOffset = i;
        }
        if (firstVisiblePageScrollOffset == null) {
            if (this.firstVisiblePageScrollOffset != null) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final androidx.compose.foundation.pager.MeasuredPage getCurrentPage() {
        return this.currentPage;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction;
    }

    public final List<androidx.compose.foundation.pager.MeasuredPage> getExtraPagesAfter() {
        return this.extraPagesAfter;
    }

    public final List<androidx.compose.foundation.pager.MeasuredPage> getExtraPagesBefore() {
        return this.extraPagesBefore;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final androidx.compose.foundation.pager.MeasuredPage getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final int getFirstVisiblePageScrollOffset() {
        return this.firstVisiblePageScrollOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSize() {
        return this.pageSize;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSpacing() {
        return this.pageSpacing;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public Function1<RulerScope, Unit> getRulers() {
        return this.$$delegate_0.getRulers();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public SnapPosition getSnapPosition() {
        return this.snapPosition;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public long getViewportSize-YbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    public List<androidx.compose.foundation.pager.MeasuredPage> getVisiblePagesInfo() {
        return this.visiblePagesInfo;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final void setCanScrollForward(boolean <set-?>) {
        this.canScrollForward = <set-?>;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final void setCurrentPageOffsetFraction(float <set-?>) {
        this.currentPageOffsetFraction = <set-?>;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final void setFirstVisiblePageScrollOffset(int <set-?>) {
        this.firstVisiblePageScrollOffset = <set-?>;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final boolean tryToApplyScrollWithoutRemeasure(int delta) {
        boolean firstVisiblePage;
        int i4;
        int i5;
        int i2;
        float f;
        androidx.compose.foundation.pager.MeasuredPage currentPage;
        int deltaToFirstItemChange;
        int i3;
        int index$iv3;
        int index$iv;
        int index$iv2;
        int size;
        Object obj;
        Object obj2;
        int i;
        pageSize += pageSpacing;
        i5 = 0;
        if (!this.remeasureNeeded && !getVisiblePagesInfo().isEmpty() && this.firstVisiblePage != null) {
            if (!getVisiblePagesInfo().isEmpty()) {
                if (this.firstVisiblePage != null) {
                    firstVisiblePageScrollOffset -= delta;
                    i2 = 1;
                    if (i7 >= 0 && i7 < i6) {
                        firstVisiblePage = i7 < i6 ? i2 : i5;
                    } else {
                    }
                    if (firstVisiblePage == 0) {
                    } else {
                        if (i6 != 0) {
                            f2 /= f;
                        } else {
                            i4 = 0;
                        }
                        currentPageOffsetFraction2 -= i4;
                        if (this.currentPage != null && Float.compare(i10, i11) < 0) {
                            if (Float.compare(i10, i11) < 0) {
                                if (Float.compare(i10, i12) <= 0) {
                                } else {
                                    Object first = CollectionsKt.first(getVisiblePagesInfo());
                                    Object last = CollectionsKt.last(getVisiblePagesInfo());
                                    if (delta < 0) {
                                        deltaToFirstItemChange = Math.min(i13 -= viewportStartOffset2, i16 -= viewportEndOffset2) > -delta ? i2 : i5;
                                    } else {
                                        deltaToFirstItemChange = Math.min(viewportStartOffset -= offset3, viewportEndOffset -= offset4) > delta ? i2 : i5;
                                    }
                                    if (deltaToFirstItemChange != 0) {
                                        this.currentPageOffsetFraction = currentPageOffsetFraction -= i4;
                                        this.firstVisiblePageScrollOffset = firstVisiblePageScrollOffset2 -= delta;
                                        List visiblePagesInfo2 = getVisiblePagesInfo();
                                        int i17 = 0;
                                        index$iv = 0;
                                        while (index$iv < visiblePagesInfo2.size()) {
                                            i = 0;
                                            (MeasuredPage)visiblePagesInfo2.get(index$iv).applyScrollDelta(delta);
                                            index$iv++;
                                        }
                                        List $this$fastForEach$iv = this.extraPagesBefore;
                                        int i18 = 0;
                                        index$iv2 = 0;
                                        while (index$iv2 < $this$fastForEach$iv.size()) {
                                            i = 0;
                                            (MeasuredPage)$this$fastForEach$iv.get(index$iv2).applyScrollDelta(delta);
                                            index$iv2++;
                                        }
                                        List $this$fastForEach$iv2 = this.extraPagesAfter;
                                        i3 = 0;
                                        index$iv3 = 0;
                                        while (index$iv3 < $this$fastForEach$iv2.size()) {
                                            i = 0;
                                            (MeasuredPage)$this$fastForEach$iv2.get(index$iv3).applyScrollDelta(delta);
                                            index$iv3++;
                                        }
                                        if (!this.canScrollForward && delta > 0) {
                                            if (delta > 0) {
                                                this.canScrollForward = i2;
                                            }
                                        }
                                        i5 = i2;
                                    } else {
                                    }
                                }
                                return i5;
                            }
                        }
                    }
                    return i5;
                }
            }
        }
        return i5;
    }
}
