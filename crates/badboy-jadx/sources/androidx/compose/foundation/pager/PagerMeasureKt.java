package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.layout.Arrangement.Absolute;
import androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¬\u0001\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aH\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u001aH\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00082\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00082\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a@\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00082\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00082\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a\u0017\u0010\u0018\u001a\u00020\u00192\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\u0008\u001a\u008c\u0001\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u001e*\u00020\u001f2\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00082\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00082\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00082\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002\u001aj\u0010\u0014\u001a\u00020\u0004*\u00020\u001f2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020)2\u0008\u00107\u001a\u0004\u0018\u0001082\u0008\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010*\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>\u001añ\u0001\u0010?\u001a\u00020@*\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00103\u001a\u0002042\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u0002022\u0006\u0010(\u001a\u00020)2\u0008\u00109\u001a\u0004\u0018\u00010:2\u0008\u00107\u001a\u0004\u0018\u0001082\u0006\u0010*\u001a\u00020+2\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00082\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2/\u0010I\u001a+\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00190\u0015¢\u0006\u0002\u0008L\u0012\u0004\u0012\u00020M0JH\u0000ø\u0001\u0000¢\u0006\u0004\u0008N\u0010O\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006P", d2 = {"MaxPageOffset", "", "MinPageOffset", "calculateNewCurrentPage", "Landroidx/compose/foundation/pager/MeasuredPage;", "viewportSize", "", "visiblePagesInfo", "", "beforeContentPadding", "afterContentPadding", "itemSize", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageCount", "createPagesAfterList", "currentLastPage", "pagesCount", "beyondViewportPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", "index", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "mainAxisAvailableSize", "currentPage", "currentPageOffset", "constraints", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-bmk8ZPk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagerMeasureKt {

    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;
    public static final androidx.compose.foundation.pager.MeasuredPage access$getAndMeasure-SGf7dI0(LazyLayoutMeasureScope $receiver, int index, long childConstraints, androidx.compose.foundation.pager.PagerLazyLayoutItemProvider pagerItemProvider, long visualPageOffset, Orientation orientation, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, LayoutDirection layoutDirection, boolean reverseLayout, int pageAvailableSize) {
        return PagerMeasureKt.getAndMeasure-SGf7dI0($receiver, index, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, layoutDirection, reverseLayout, pageAvailableSize);
    }

    private static final androidx.compose.foundation.pager.MeasuredPage calculateNewCurrentPage(int viewportSize, List<androidx.compose.foundation.pager.MeasuredPage> visiblePagesInfo, int beforeContentPadding, int afterContentPadding, int itemSize, SnapPosition snapPosition, int pageCount) {
        Object maxElem$iv;
        int it2;
        int i$iv;
        int lastIndex;
        int i3;
        int it;
        int compare;
        float distanceToDesiredSnapPosition;
        int index2;
        SnapPosition snapPosition3;
        int i4;
        int i2;
        int offset;
        int index;
        SnapPosition snapPosition2;
        int i;
        final List list = visiblePagesInfo;
        final int i5 = 0;
        if (list.isEmpty()) {
            maxElem$iv = 0;
        } else {
            Object obj = maxElem$iv;
            int i7 = 0;
            it2 = -f;
            lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
            }
        }
        return (MeasuredPage)maxElem$iv;
    }

    private static final List<androidx.compose.foundation.pager.MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope $this$calculatePagesOffsets, List<androidx.compose.foundation.pager.MeasuredPage> pages, List<androidx.compose.foundation.pager.MeasuredPage> extraPagesBefore, List<androidx.compose.foundation.pager.MeasuredPage> extraPagesAfter, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int pagesScrollOffset, Orientation orientation, boolean reverseLayout, Density density, int spaceBetweenPages, int pageAvailableSize) {
        ArrayList list;
        int currentMainAxis;
        int currentMainAxis2;
        int $this$fastForEach$iv;
        Arrangement.HorizontalOrVertical spacedBy-0680j_4;
        int i7;
        int i;
        IntProgression index$iv2;
        Object positionedPages2;
        int index$iv3;
        int index$iv;
        int index;
        int i6;
        Object positionedPages;
        int[] pagesCount;
        int last;
        boolean empty;
        LayoutDirection sizes;
        int[] iArr;
        int i2;
        int i3;
        int step;
        int i8;
        int i4;
        int pagesCount2;
        int i5;
        int size;
        final int i9 = layoutWidth;
        final int i10 = layoutHeight;
        int i11 = pagesScrollOffset;
        Orientation orientation2 = orientation;
        final boolean z = reverseLayout;
        $this$fastForEach$iv = spaceBetweenPages;
        int i14 = pageAvailableSize + $this$fastForEach$iv;
        i7 = orientation2 == Orientation.Vertical ? i10 : i9;
        final int i20 = i7;
        pagesCount = 1;
        i = finalMainAxisOffset < Math.min(i20, maxOffset) ? pagesCount : 0;
        final int i23 = i;
        if (i23 != 0) {
            i = i11 == 0 ? pagesCount : 0;
            if (i == 0) {
            } else {
            }
            int i19 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("non-zero pagesScrollOffset=").append(i11).toString().toString());
            throw illegalStateException;
        }
        positionedPages2 = new ArrayList(i21 += iArr);
        if (i23 != 0) {
            if (extraPagesBefore.isEmpty() && extraPagesAfter.isEmpty()) {
                if (extraPagesAfter.isEmpty()) {
                } else {
                    pagesCount = 0;
                }
            } else {
            }
            if (pagesCount == 0) {
            } else {
                int size4 = pages.size();
                sizes = new int[size4];
                i2 = 0;
                while (i2 < size4) {
                    sizes[i2] = pageAvailableSize;
                    i2++;
                }
                iArr = new int[size4];
                i6 = 0;
                while (i6 < size4) {
                    iArr[i6] = 0;
                    i6++;
                }
                i3 = i14;
                spacedBy-0680j_4 = Arrangement.Absolute.INSTANCE.spacedBy-0680j_4($this$calculatePagesOffsets.toDp-u2uoSUM($this$fastForEach$iv));
                if (orientation2 == Orientation.Vertical) {
                    i8 = 0;
                    spacedBy-0680j_4.arrange(density, i20, sizes, iArr);
                    list = positionedPages2;
                    currentMainAxis = size4;
                    pagesCount = sizes;
                } else {
                    i8 = 0;
                    list = list2;
                    currentMainAxis = i4;
                    spacedBy-0680j_4.arrange(density, i20, sizes, LayoutDirection.Ltr, iArr);
                }
                if (!z) {
                } else {
                    index$iv2 = RangesKt.reversed((IntProgression)ArraysKt.getIndices(iArr));
                }
                index = index$iv2.getFirst();
                last = index$iv2.getLast();
                step = index$iv2.getStep();
                if (step > 0) {
                    if (index > last) {
                        if (step < 0 && last <= index) {
                            if (last <= index) {
                            } else {
                                pagesCount2 = currentMainAxis;
                            }
                        } else {
                        }
                    }
                } else {
                }
                return (List)list;
            }
            int i12 = 0;
            IllegalArgumentException $i$a$RequirePagerMeasureKt$calculatePagesOffsets$2 = new IllegalArgumentException("No extra pages".toString());
            throw $i$a$RequirePagerMeasureKt$calculatePagesOffsets$2;
        }
        i3 = i14;
        list = positionedPages2;
        int i13 = 0;
        currentMainAxis2 = pagesScrollOffset;
        Object obj2 = extraPagesBefore;
        int i15 = 0;
        index$iv3 = 0;
        while (index$iv3 < obj2.size()) {
            last = pagesCount;
            iArr = 0;
            (MeasuredPage)last.position(currentMainAxis2 -= i3, i9, i10);
            list.add(last);
            index$iv3++;
        }
        currentMainAxis = pagesScrollOffset;
        Object obj3 = pages;
        int i16 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            last = pagesCount;
            iArr = 0;
            (MeasuredPage)last.position(currentMainAxis, i9, i10);
            list.add(last);
            currentMainAxis += i3;
            index$iv++;
        }
        $this$fastForEach$iv = extraPagesAfter;
        spacedBy-0680j_4 = 0;
        index$iv2 = 0;
        while (index$iv2 < $this$fastForEach$iv.size()) {
            last = pagesCount;
            iArr = 0;
            (MeasuredPage)last.position(currentMainAxis, i9, i10);
            list.add(last);
            currentMainAxis += i3;
            index$iv2++;
        }
    }

    private static final int calculatePagesOffsets$reverseAware(int $this$calculatePagesOffsets_u24reverseAware, boolean $reverseLayout, int pagesCount) {
        int i;
        i = !$reverseLayout ? $this$calculatePagesOffsets_u24reverseAware : i2 + -1;
        return i;
    }

    private static final List<androidx.compose.foundation.pager.MeasuredPage> createPagesAfterList(int currentLastPage, int pagesCount, int beyondViewportPageCount, List<Integer> pinnedPages, Function1<? super Integer, androidx.compose.foundation.pager.MeasuredPage> getAndMeasure) {
        int list;
        int i2;
        int emptyList;
        Object arrayList;
        int index$iv;
        Object obj;
        int intValue;
        int i;
        int arrayList2;
        int i3;
        list = 0;
        int i5 = Math.min(currentLastPage + beyondViewportPageCount, pagesCount + -1);
        if (currentLastPage + 1 <= i5) {
        }
        Object i7 = pinnedPages;
        int i8 = 0;
        index$iv = 0;
        while (index$iv < i7.size()) {
            intValue = (Number)i7.get(index$iv).intValue();
            i = 0;
            i3 = 0;
            if (i5 + 1 <= intValue && intValue < pagesCount) {
            }
            if (i3 != 0 && list == null) {
            }
            index$iv++;
            if (list == null) {
            }
            list.add(getAndMeasure.invoke(Integer.valueOf(intValue)));
            arrayList2 = new ArrayList();
            list = arrayList2;
            if (intValue < pagesCount) {
            }
            i3 = 1;
        }
        if (list == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            emptyList = list;
        }
        return emptyList;
    }

    private static final List<androidx.compose.foundation.pager.MeasuredPage> createPagesBeforeList(int currentFirstPage, int beyondViewportPageCount, List<Integer> pinnedPages, Function1<? super Integer, androidx.compose.foundation.pager.MeasuredPage> getAndMeasure) {
        int list;
        int i;
        int emptyList;
        Object arrayList2;
        int index$iv;
        Object obj;
        int intValue;
        int i2;
        Object arrayList;
        list = 0;
        int i4 = Math.max(0, currentFirstPage - beyondViewportPageCount);
        if (i4 <= currentFirstPage + -1) {
        }
        Object i6 = pinnedPages;
        int i7 = 0;
        index$iv = 0;
        while (index$iv < i6.size()) {
            intValue = (Number)i6.get(index$iv).intValue();
            i2 = 0;
            if (intValue < i4 && list == null) {
            }
            index$iv++;
            if (list == null) {
            }
            list.add(getAndMeasure.invoke(Integer.valueOf(intValue)));
            arrayList = new ArrayList();
            list = arrayList;
        }
        if (list == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            emptyList = list;
        }
        return emptyList;
    }

    private static final void debugLog(Function0<String> generateMsg) {
        final int i = 0;
    }

    private static final androidx.compose.foundation.pager.MeasuredPage getAndMeasure-SGf7dI0(LazyLayoutMeasureScope $this$getAndMeasure_u2dSGf7dI0, int index, long childConstraints, androidx.compose.foundation.pager.PagerLazyLayoutItemProvider pagerItemProvider, long visualPageOffset, Orientation orientation, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, LayoutDirection layoutDirection, boolean reverseLayout, int pageAvailableSize) {
        MeasuredPage measuredPage = new MeasuredPage(index, obj26, $this$getAndMeasure_u2dSGf7dI0.measure-0kLqBqw(index, childConstraints), orientation, obj6, visualPageOffset.getKey(index), verticalAlignment, layoutDirection, reverseLayout, pageAvailableSize, obj25, 0);
        return measuredPage;
    }

    public static final androidx.compose.foundation.pager.PagerMeasureResult measurePager-bmk8ZPk(LazyLayoutMeasureScope $this$measurePager_u2dbmk8ZPk, int pageCount, androidx.compose.foundation.pager.PagerLazyLayoutItemProvider pagerItemProvider, int mainAxisAvailableSize, int beforeContentPadding, int afterContentPadding, int spaceBetweenPages, int currentPage, int currentPageOffset, long constraints, Orientation orientation, Alignment.Vertical verticalAlignment, Alignment.Horizontal horizontalAlignment, boolean reverseLayout, long visualPageOffset, int pageAvailableSize, int beyondViewportPageCount, List<Integer> pinnedPages, SnapPosition snapPosition, MutableState<Unit> placementScopeInvalidator, CoroutineScope coroutineScope, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout) {
        List list;
        boolean equal;
        int i26;
        ArrayList constrainWidth-K40F9xA;
        Object emptyList;
        Object emptyList2;
        int i40;
        int offset;
        int size2;
        int i3;
        int size3;
        int i7;
        int size;
        int i38;
        int index2;
        Object visiblePages;
        ArrayDeque queue;
        int i19;
        Object visiblePagesInfo;
        float coerceIn;
        int it$iv3;
        int it$iv2;
        int i28;
        int index;
        Orientation it$iv;
        int measuredPage;
        int currentMainAxisOffset3;
        Object currentFirstPageScrollOffset;
        int i39;
        int measuredPage2;
        int minOffset;
        int i22;
        int i31;
        int pageSizeWithSpacing3;
        int indexInVisibleItems;
        int currentMainAxisOffset;
        int i24;
        int i21;
        int maxCrossAxis4;
        int maxCrossAxis2;
        androidx.compose.foundation.pager.MeasuredPage andMeasure-SGf7dI0;
        int index3;
        int maxOffset;
        Orientation maxWidth-impl;
        Orientation maxHeight-impl;
        int currentFirstPageScrollOffset5;
        int index4;
        int $i$f$debugLog;
        int currentMainAxisOffset2;
        int index5;
        int i;
        int currentFirstPageScrollOffset3;
        int currentFirstPageScrollOffset8;
        int currentFirstPageScrollOffset6;
        int currentFirstPageScrollOffset4;
        int i18;
        int index$iv2;
        int i20;
        int crossAxisSize;
        List pagesAfterList;
        ArrayDeque $i$f$debugLog2;
        int visiblePages2;
        Object firstPage;
        int index$iv3;
        int maxCrossAxis;
        int maxCrossAxis3;
        Orientation orientation2;
        int i4;
        int i32;
        int currentMainAxisOffset4;
        int index$iv;
        int index$iv$iv;
        int i13;
        int i27;
        int i8;
        int remeasureNeeded2;
        int remeasureNeeded;
        Orientation orientation4;
        Orientation orientation5;
        List i9;
        int i34;
        int currentFirstPageScrollOffset7;
        int i2;
        int i37;
        int i5;
        int i35;
        int i15;
        Orientation orientation3;
        ArrayList list2;
        int layoutDirection;
        int i17;
        int i29;
        Density density;
        int i16;
        int visiblePagesScrollOffset;
        float f;
        int i23;
        int i36;
        int i12;
        int currentFirstPage;
        int currentFirstPage2;
        int currentFirstPageScrollOffset2;
        int i33;
        int pageSizeWithSpacing;
        int currentFirstPage3;
        List pagesBeforeList;
        Object obj;
        int i14;
        int pageSizeWithSpacing2;
        int firstVisiblePage;
        int firstVisiblePageOffset;
        int i6;
        int i10;
        int i11;
        int maxOffset2;
        int i25;
        int i30;
        int $i$f$fastFilter2;
        int last;
        int $i$f$fastFilter;
        int i61 = pageCount;
        measuredPage = beforeContentPadding;
        list = placementScopeInvalidator;
        measuredPage2 = 0;
        i12 = 1;
        i22 = measuredPage >= 0 ? i12 : measuredPage2;
        if (i22 == 0) {
        } else {
            i31 = afterContentPadding >= 0 ? i12 : measuredPage2;
            if (i31 == 0) {
            } else {
                int coerceAtLeast = RangesKt.coerceAtLeast(pinnedPages + spaceBetweenPages, measuredPage2);
                int i58 = 0;
                if (i61 <= 0) {
                    int i98 = snapPosition;
                    PagerMeasureResult pagerMeasureResult = new PagerMeasureResult(CollectionsKt.emptyList(), pinnedPages, spaceBetweenPages, afterContentPadding, verticalAlignment, -measuredPage, mainAxisAvailableSize + afterContentPadding, 0, i98, 0, 0, 0, 0, 0, coroutineScope, (MeasureResult)obj71.invoke(Integer.valueOf(Constraints.getMinWidth-impl(constraints)), Integer.valueOf(Constraints.getMinHeight-impl(constraints)), PagerMeasureKt.measurePager.4.INSTANCE), 0, 0, 0, obj70, 393216, 0);
                    int i60 = i98;
                    return pagerMeasureResult;
                }
                orientation2 = verticalAlignment;
                int i59 = snapPosition;
                if (orientation2 == Orientation.Vertical) {
                    i13 = maxWidth-impl;
                } else {
                    i13 = pinnedPages;
                }
                if (orientation2 != Orientation.Vertical) {
                    i35 = maxHeight-impl;
                } else {
                    i35 = pinnedPages;
                }
                long l = ConstraintsKt.Constraints$default(0, i13, 0, i35, 5, 0);
                int i63 = 0;
                firstVisiblePage = firstVisiblePage2;
                firstVisiblePageOffset = i72;
                while (firstVisiblePage > 0) {
                    if (firstVisiblePageOffset > 0) {
                    }
                    firstVisiblePage--;
                    firstVisiblePageOffset -= coerceAtLeast;
                }
                int i73 = 0;
                currentFirstPageScrollOffset3 = i120;
                if (firstVisiblePage >= i61) {
                    currentFirstPageScrollOffset5 = i61 + -1;
                    currentFirstPageScrollOffset3 = 0;
                }
                int i78 = 0;
                $i$f$debugLog2 = new ArrayDeque();
                i27 = spaceBetweenPages < 0 ? spaceBetweenPages : measuredPage2;
                i23 = mainAxisAvailableSize;
                currentFirstPageScrollOffset3 += i32;
                i8 = 0;
                i34 = 0;
                currentFirstPage = currentFirstPageScrollOffset5;
                while (currentFirstPageScrollOffset8 < 0) {
                    if (currentFirstPage > 0) {
                    }
                    int currentFirstPageScrollOffset14 = currentFirstPage + -1;
                    ArrayDeque queue2 = $i$f$debugLog2;
                    androidx.compose.foundation.pager.MeasuredPage andMeasure-SGf7dI03 = PagerMeasureKt.getAndMeasure-SGf7dI0($this$measurePager_u2dbmk8ZPk, currentFirstPageScrollOffset14, l, obj12, pagerItemProvider, pageAvailableSize, i32, orientation2, reverseLayout, horizontalAlignment, $this$measurePager_u2dbmk8ZPk.getLayoutDirection());
                    int i70 = 0;
                    queue2.add(0, andMeasure-SGf7dI03);
                    i8 = Math.max(i8, andMeasure-SGf7dI03.getCrossAxisSize());
                    currentFirstPage = currentFirstPageScrollOffset14;
                    orientation2 = verticalAlignment;
                    $i$f$debugLog2 = queue2;
                    currentFirstPageScrollOffset8 = currentFirstPageScrollOffset5;
                    i32 = i25;
                    measuredPage2 = 0;
                    visiblePages = obj71;
                }
                int currentFirstPageScrollOffset10 = currentFirstPageScrollOffset8;
                queue = $i$f$debugLog2;
                int i52 = i30;
                currentFirstPageScrollOffset6 = currentFirstPageScrollOffset10 < i52 ? i52 : currentFirstPageScrollOffset10;
                currentFirstPageScrollOffset6 -= i52;
                int i64 = 0;
                index4 = currentFirstPage;
                currentMainAxisOffset4 = -currentFirstPageScrollOffset12;
                remeasureNeeded2 = 0;
                int i113 = coerceAtLeast;
                pageSizeWithSpacing3 = currentFirstPageScrollOffset7;
                currentFirstPageScrollOffset7 = index4;
                while (pageSizeWithSpacing3 < queue.size()) {
                    if (currentMainAxisOffset4 >= RangesKt.coerceAtLeast(i23 + afterContentPadding, 0)) {
                    } else {
                    }
                    index4 = currentFirstPageScrollOffset7 + 1;
                    currentMainAxisOffset4 += i113;
                    pageSizeWithSpacing3++;
                    currentFirstPageScrollOffset7 = index4;
                    queue.remove(pageSizeWithSpacing3);
                    remeasureNeeded2 = 1;
                    index4 = currentFirstPageScrollOffset7;
                }
                int index11 = 0;
                $i$f$debugLog = currentMainAxisOffset4;
                currentFirstPage3 = currentFirstPage;
                indexInVisibleItems = i113;
                currentFirstPage2 = currentFirstPageScrollOffset12;
                pageSizeWithSpacing = remeasureNeeded2;
                currentFirstPageScrollOffset4 = currentFirstPageScrollOffset7;
                remeasureNeeded = visiblePages2;
                while (currentFirstPageScrollOffset4 < i61) {
                    i14 = indexInVisibleItems;
                    maxCrossAxis4 = remeasureNeeded;
                    andMeasure-SGf7dI0 = PagerMeasureKt.getAndMeasure-SGf7dI0($this$measurePager_u2dbmk8ZPk, currentFirstPageScrollOffset4, l, obj12, pagerItemProvider, pageAvailableSize, currentMainAxisOffset4, verticalAlignment, reverseLayout, horizontalAlignment, $this$measurePager_u2dbmk8ZPk.getLayoutDirection());
                    int i68 = currentFirstPageScrollOffset4;
                    int index13 = 0;
                    if (i68 == i61 + -1) {
                    } else {
                    }
                    i20 = i14;
                    pageSizeWithSpacing4 += i20;
                    if (currentMainAxisOffset5 <= i52 && i68 != i61 + -1) {
                    } else {
                    }
                    queue.add(andMeasure-SGf7dI0);
                    remeasureNeeded = maxCrossAxis4;
                    currentFirstPageScrollOffset4 = i68 + 1;
                    $i$f$debugLog = currentMainAxisOffset5;
                    indexInVisibleItems = i14;
                    i4 = i6;
                    if (i68 != i61 + -1) {
                    } else {
                    }
                    currentFirstPage2 -= i14;
                    currentFirstPage3 = crossAxisSize;
                    pageSizeWithSpacing = visiblePages2;
                    remeasureNeeded = maxCrossAxis4;
                    i20 = pinnedPages;
                }
                pageSizeWithSpacing2 = indexInVisibleItems;
                currentMainAxisOffset = $i$f$debugLog;
                currentMainAxisOffset2 = currentFirstPageScrollOffset4;
                i10 = i4;
                maxCrossAxis2 = remeasureNeeded;
                index3 = i23;
                if (currentMainAxisOffset < index3) {
                    i23 = index3 - currentMainAxisOffset;
                    currentFirstPageScrollOffset4 = currentFirstPageScrollOffset2;
                    while (currentFirstPageScrollOffset4 < measuredPage) {
                        int currentFirstPageScrollOffset13 = currentFirstPage3 + -1;
                        androidx.compose.foundation.pager.MeasuredPage andMeasure-SGf7dI02 = PagerMeasureKt.getAndMeasure-SGf7dI0($this$measurePager_u2dbmk8ZPk, currentFirstPageScrollOffset13, l, obj12, pagerItemProvider, pageAvailableSize, currentMainAxisOffset4, verticalAlignment, reverseLayout, horizontalAlignment, $this$measurePager_u2dbmk8ZPk.getLayoutDirection());
                        queue.add(0, andMeasure-SGf7dI02);
                        maxCrossAxis2 = Math.max(maxCrossAxis2, andMeasure-SGf7dI02.getCrossAxisSize());
                        currentFirstPage3 = currentFirstPageScrollOffset13;
                        measuredPage = beforeContentPadding;
                        currentMainAxisOffset2 = maxOffset4;
                        currentFirstPageScrollOffset4 = visiblePages2;
                        index3 = i11;
                    }
                    maxOffset2 = index3;
                    maxOffset = currentMainAxisOffset2;
                    currentFirstPage2 = currentFirstPageScrollOffset4;
                    index5 = 0;
                    if (currentFirstPage2 < 0) {
                        currentMainAxisOffset = i48;
                        currentMainAxisOffset3 = currentFirstPage2;
                    } else {
                        currentMainAxisOffset3 = currentFirstPage2;
                    }
                } else {
                    maxOffset2 = index3;
                    maxOffset = currentMainAxisOffset2;
                    index5 = 0;
                    currentMainAxisOffset3 = currentFirstPage2;
                }
                i18 = currentMainAxisOffset3 >= 0 ? i12 : index5;
                if (i18 == 0) {
                } else {
                    if (beforeContentPadding <= 0) {
                        if (spaceBetweenPages < 0) {
                            i4 = 0;
                            while (i4 < queue.size()) {
                                remeasureNeeded = pageSizeWithSpacing2;
                                index5 = remeasureNeeded;
                                firstPage = obj2;
                                i4++;
                                currentMainAxisOffset3 = remeasureNeeded;
                                index5 = 0;
                            }
                            currentFirstPageScrollOffset7 = currentMainAxisOffset3;
                            i33 = currentFirstPageScrollOffset7;
                            currentFirstPageScrollOffset = firstPage;
                        } else {
                            i33 = currentMainAxisOffset3;
                            currentFirstPageScrollOffset = firstPage;
                        }
                    } else {
                    }
                    int i112 = 0;
                    PagerMeasureKt.measurePager.extraPagesBefore.1 anon2 = new PagerMeasureKt.measurePager.extraPagesBefore.1($this$measurePager_u2dbmk8ZPk, l, obj12, pagerItemProvider, pageAvailableSize, currentMainAxisOffset4, verticalAlignment, reverseLayout, horizontalAlignment, visualPageOffset, pinnedPages);
                    pagesBeforeList = PagerMeasureKt.createPagesBeforeList(currentFirstPage3, i59, list, (Function1)anon2);
                    List list8 = pagesBeforeList;
                    int i75 = 0;
                    index$iv = i79;
                    index$iv3 = i107;
                    while (index$iv < list8.size()) {
                        i15 = 0;
                        index$iv3 = Math.max(index$iv3, (MeasuredPage)list8.get(index$iv).getCrossAxisSize());
                        index$iv++;
                        queue = i30;
                    }
                    ArrayDeque visiblePages4 = queue;
                    orientation5 = verticalAlignment;
                    PagerMeasureKt.measurePager.extraPagesAfter.1 anon3 = new PagerMeasureKt.measurePager.extraPagesAfter.1($this$measurePager_u2dbmk8ZPk, l, obj12, pagerItemProvider, pageAvailableSize, index$iv, orientation5, reverseLayout, horizontalAlignment, visualPageOffset, pinnedPages);
                    final long l4 = l;
                    Orientation orientation6 = orientation5;
                    pagesAfterList = PagerMeasureKt.createPagesAfterList((MeasuredPage)visiblePages4.last().getIndex(), i61, i59, list, (Function1)anon3);
                    List list6 = pagesAfterList;
                    int i66 = 0;
                    index$iv2 = 0;
                    maxCrossAxis = i108;
                    while (index$iv2 < list6.size()) {
                        i37 = 0;
                        maxCrossAxis = Math.max(maxCrossAxis, (MeasuredPage)list6.get(index$iv2).getCrossAxisSize());
                        index$iv2++;
                        list = placementScopeInvalidator;
                    }
                    if (Intrinsics.areEqual(currentFirstPageScrollOffset, visiblePages4.first()) && pagesBeforeList.isEmpty() && pagesAfterList.isEmpty()) {
                        if (pagesBeforeList.isEmpty()) {
                            i = pagesAfterList.isEmpty() ? i12 : i112;
                        } else {
                        }
                    } else {
                    }
                    i26 = orientation6 == Orientation.Vertical ? maxCrossAxis : currentMainAxisOffset;
                    Object obj3 = constraints;
                    i19 = orientation6 == Orientation.Vertical ? currentMainAxisOffset : maxCrossAxis;
                    index$iv$iv = currentMainAxisOffset;
                    orientation3 = orientation6;
                    i5 = i105;
                    List list9 = pagesBeforeList;
                    i9 = maxOffset2;
                    int i86 = constrainHeight-K40F9xA;
                    int maxOffset6 = maxCrossAxis;
                    maxCrossAxis3 = constrainWidth-K40F9xA;
                    List pagesOffsets = PagerMeasureKt.calculatePagesOffsets($this$measurePager_u2dbmk8ZPk, (List)visiblePages4, list9, pagesAfterList, maxCrossAxis3, i86, index$iv$iv, i9, i5, orientation3, visualPageOffset, (Density)$this$measurePager_u2dbmk8ZPk, spaceBetweenPages, pinnedPages);
                    final int i122 = maxCrossAxis3;
                    final int i123 = i86;
                    int extraPagesBefore = index$iv$iv;
                    int i67 = i9;
                    final int i124 = i5;
                    Orientation layoutHeight = orientation3;
                    if (i != 0) {
                        visiblePagesInfo = pagesOffsets;
                    } else {
                        List list5 = pagesOffsets;
                        i28 = 0;
                        currentMainAxisOffset = new ArrayList(list5.size());
                        pagesAfterList = list5;
                        maxCrossAxis3 = 0;
                        index$iv$iv = 0;
                        i9 = list5;
                        size = pagesAfterList.size();
                        while (index$iv$iv < size) {
                            orientation3 = i5;
                            i17 = 0;
                            density = orientation3;
                            visiblePagesScrollOffset = 0;
                            if ((MeasuredPage)density.getIndex() >= (MeasuredPage)visiblePages4.first().getIndex() && density.getIndex() <= (MeasuredPage)visiblePages4.last().getIndex()) {
                            } else {
                            }
                            i38 = i112;
                            if (i38 != 0) {
                            } else {
                            }
                            it$iv = orientation3;
                            index$iv$iv++;
                            size = i36;
                            i28 = $i$f$fastFilter2;
                            (Collection)currentMainAxisOffset.add(orientation3);
                            if (density.getIndex() <= (MeasuredPage)visiblePages4.last().getIndex()) {
                            } else {
                            }
                            i38 = i12;
                        }
                        $i$f$fastFilter2 = i28;
                        visiblePagesInfo = constrainWidth-K40F9xA;
                    }
                    if (list9.isEmpty()) {
                        list2 = visiblePagesInfo;
                        obj = emptyList;
                    } else {
                        List list4 = pagesOffsets;
                        currentMainAxisOffset = 0;
                        pagesAfterList = new ArrayList(list4.size());
                        maxCrossAxis3 = list4;
                        index$iv$iv = 0;
                        i5 = list4;
                        size3 = maxCrossAxis3.size();
                        list2 = visiblePagesInfo;
                        visiblePagesInfo = i9;
                        while (visiblePagesInfo < size3) {
                            i17 = i9;
                            density = null;
                            i36 = 0;
                            if ((MeasuredPage)i17.getIndex() < (MeasuredPage)visiblePages4.first().getIndex()) {
                            } else {
                            }
                            i7 = i112;
                            if (i7 != 0) {
                            } else {
                            }
                            it$iv2 = i17;
                            visiblePagesInfo = last + 1;
                            size3 = pagesBeforeList;
                            (Collection)pagesAfterList.add(i17);
                            i7 = i12;
                        }
                        last = visiblePagesInfo;
                        obj = emptyList;
                    }
                    if (pagesAfterList.isEmpty()) {
                        emptyList2 = CollectionsKt.emptyList();
                    } else {
                        List list3 = pagesOffsets;
                        visiblePagesInfo = 0;
                        currentMainAxisOffset = new ArrayList(list3.size());
                        pagesAfterList = list3;
                        maxCrossAxis3 = 0;
                        index$iv$iv = 0;
                        i9 = list3;
                        size2 = pagesAfterList.size();
                        while (index$iv$iv < size2) {
                            i17 = i5;
                            density = null;
                            i36 = 0;
                            if ((MeasuredPage)i17.getIndex() > (MeasuredPage)visiblePages4.last().getIndex()) {
                            } else {
                            }
                            i3 = i112;
                            if (i3 != 0) {
                            } else {
                            }
                            it$iv3 = i17;
                            index$iv$iv++;
                            size2 = $i$f$fastFilter2;
                            visiblePagesInfo = $i$f$fastFilter;
                            (Collection)currentMainAxisOffset.add(i17);
                            i3 = i12;
                        }
                        $i$f$fastFilter = visiblePagesInfo;
                        emptyList2 = currentMainAxisOffset;
                    }
                    i40 = layoutHeight == Orientation.Vertical ? i123 : i122;
                    int i125 = i52;
                    int i126 = i116;
                    int i56 = pageSizeWithSpacing2;
                    androidx.compose.foundation.pager.MeasuredPage newCurrentPage = PagerMeasureKt.calculateNewCurrentPage(i40, list2, beforeContentPadding, afterContentPadding, i56, coroutineScope, i61);
                    int i90 = i56;
                    if (newCurrentPage != null) {
                        i21 = minOffset;
                    } else {
                        i21 = i112;
                    }
                    int i62 = pageCount;
                    int i53 = beforeContentPadding;
                    if (newCurrentPage != null) {
                        offset = newCurrentPage.getOffset();
                    } else {
                        offset = i112;
                    }
                    if (i90 == 0) {
                        f = coerceIn;
                    } else {
                        f = coerceIn;
                    }
                    int i43 = 0;
                    int i127 = offset;
                    PagerMeasureKt.measurePager.14 anon = new PagerMeasureKt.measurePager.14(pagesOffsets, layout);
                    int i57 = i90;
                    if (maxOffset >= i62) {
                        if (extraPagesBefore > i67) {
                        } else {
                            i12 = i112;
                        }
                    }
                    int i44 = i50;
                    List maxOffset3 = pagesOffsets;
                    final int i128 = extraPagesBefore;
                    ArrayList positionedPages = list2;
                    PagerMeasureResult maxOffset5 = new PagerMeasureResult(positionedPages, pinnedPages, spaceBetweenPages, afterContentPadding, layoutHeight, -i53, i67 + afterContentPadding, visualPageOffset, snapPosition, currentFirstPageScrollOffset, newCurrentPage, f, i33, i12, coroutineScope, (MeasureResult)obj71.invoke(Integer.valueOf(i122), Integer.valueOf(i123), anon), pageSizeWithSpacing, obj, emptyList2, obj70);
                    ArrayList list11 = positionedPages;
                    return maxOffset5;
                }
                int snapOffset = 0;
                IllegalArgumentException $i$a$RequirePagerMeasureKt$measurePager$10 = new IllegalArgumentException("invalid currentFirstPageScrollOffset".toString());
                throw $i$a$RequirePagerMeasureKt$measurePager$10;
            }
            MutableState mutableState2 = layout;
            int i54 = measuredPage;
            int i47 = 0;
            IllegalArgumentException $i$a$RequirePagerMeasureKt$measurePager$2 = new IllegalArgumentException("negative afterContentPadding".toString());
            throw $i$a$RequirePagerMeasureKt$measurePager$2;
        }
        MutableState mutableState = layout;
        int i51 = measuredPage;
        int i41 = 0;
        IllegalArgumentException $i$a$RequirePagerMeasureKt$measurePager$1 = new IllegalArgumentException("negative beforeContentPadding".toString());
        throw $i$a$RequirePagerMeasureKt$measurePager$1;
    }
}
