package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement.Horizontal;
import androidx.compose.foundation.layout.Arrangement.Vertical;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¦\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u001aA\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nH\u0083\u0008\u001a\u008c\u0001\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00020\r2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u00012\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001a¸\u0002\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0017\u001a\u00020\u000b2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00020\u00020-2\u0006\u0010.\u001a\u00020\u00042\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020423\u00105\u001a/\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u00086\u0012\u0008\u00087\u0012\u0004\u0008\u0008(8\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+090\u00010\n2/\u0010:\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=0\n¢\u0006\u0002\u0008>\u0012\u0004\u0012\u00020?0;H\u0000ø\u0001\u0000¢\u0006\u0004\u0008@\u0010A\u001a+\u0010B\u001a\u00020=\"\u0004\u0008\u0000\u0010C*\u0008\u0012\u0004\u0012\u0002HC0\r2\u000c\u0010D\u001a\u0008\u0012\u0004\u0012\u0002HC0EH\u0002¢\u0006\u0002\u0010F\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006G", d2 = {"calculateExtraItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "pinnedItems", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "filter", "Lkotlin/Function1;", "", "calculateItemsOffsets", "", "lines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "slotsPerLine", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "prefetchInfoRetriever", "Lkotlin/ParameterName;", "name", "line", "Lkotlin/Pair;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-OZKpZRA", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "addAllFromArray", "T", "arr", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyGridMeasureKt {
    private static final <T> void addAllFromArray(List<T> $this$addAllFromArray, T[] arr) {
        int i;
        Object obj;
        i = 0;
        while (i < arr.length) {
            $this$addAllFromArray.add(arr[i]);
            i++;
        }
    }

    private static final List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> calculateExtraItems(List<Integer> pinnedItems, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider measuredItemProvider, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider measuredLineProvider, Function1<? super Integer, Boolean> filter) {
        int items;
        int emptyList;
        int index$iv;
        Object obj;
        int i;
        boolean booleanValue;
        int intValue;
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem andMeasure--hBUhpc;
        int spanOf;
        long childConstraints-JhjzzOo$foundation_release;
        Object obj5;
        final Object obj2 = measuredLineProvider;
        final int i2 = 0;
        items = 0;
        Object obj3 = pinnedItems;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            intValue = (Number)obj3.get(index$iv).intValue();
            i = 0;
            spanOf = obj2.spanOf(intValue);
            if ((Boolean)filter.invoke(Integer.valueOf(intValue)).booleanValue() && items == 0) {
            }
            index$iv++;
            spanOf = obj2.spanOf(intValue);
            if (items == 0) {
            }
            items.add(measuredItemProvider.getAndMeasure--hBUhpc(intValue, 0, spanOf, obj2.childConstraints-JhjzzOo$foundation_release(0, spanOf)));
            booleanValue = new ArrayList();
            items = booleanValue;
        }
        Object obj6 = filter;
        if (items == 0) {
            emptyList = CollectionsKt.emptyList();
        } else {
            emptyList = items;
        }
        return emptyList;
    }

    private static final List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> calculateItemsOffsets(List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine> lines, List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> itemsBefore, List<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> itemsAfter, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int firstLineScrollOffset, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density) {
        ArrayList currentMainAxis2;
        int currentMainAxis;
        boolean $this$fastForEach$iv;
        int i13;
        int i8;
        int i7;
        boolean empty;
        int i10;
        int i4;
        Object obj3;
        Object index$iv2;
        int i6;
        int index$iv;
        int mainAxisSize;
        int i5;
        int index;
        int size;
        int iArr;
        Object ltr;
        int last;
        int sum$iv;
        int mainAxisSizeWithSpacings;
        int index$iv$iv;
        int i3;
        Object reverseAwareOffsetIndices;
        int i11;
        int mainAxisSize2;
        int i9;
        Object obj;
        int i12;
        int i;
        int i2;
        currentMainAxis2 = lines;
        final int i17 = layoutWidth;
        final int i18 = layoutHeight;
        $this$fastForEach$iv = reverseLayout;
        i13 = isVertical ? i18 : i17;
        final int i24 = i13;
        i7 = finalMainAxisOffset < Math.min(i24, maxOffset) ? 1 : 0;
        final int i26 = i7;
        if (i26 != 0) {
            i7 = firstLineScrollOffset == null ? 1 : 0;
            if (i7 == 0) {
            } else {
            }
            int i22 = 0;
            IllegalStateException $i$a$CheckLazyGridMeasureKt$calculateItemsOffsets$1 = new IllegalStateException("non-zero firstLineScrollOffset".toString());
            throw $i$a$CheckLazyGridMeasureKt$calculateItemsOffsets$1;
        }
        last = 0;
        sum$iv = 0;
        ArrayList list3 = list2;
        mainAxisSizeWithSpacings = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list3.size()) {
            i9 = 0;
            i12 = 0;
            i = 0;
            sum$iv += iArr;
            index$iv$iv++;
        }
        i2 = 0;
        ArrayList $this$fastSumBy$iv = new ArrayList(sum$iv);
        ArrayList list4 = $this$fastSumBy$iv;
        if (i26 != 0) {
            if (itemsBefore.isEmpty() && itemsAfter.isEmpty()) {
                mainAxisSize = itemsAfter.isEmpty() ? 1 : i2;
            } else {
            }
            if (mainAxisSize == 0) {
            } else {
                mainAxisSizeWithSpacings = currentMainAxis2.size();
                iArr = new int[mainAxisSizeWithSpacings];
                i10 = i2;
                while (i10 < mainAxisSizeWithSpacings) {
                    iArr[i10] = (LazyGridMeasuredLine)currentMainAxis2.get(LazyGridMeasureKt.calculateItemsOffsets$reverseAware(i10, $this$fastForEach$iv, mainAxisSizeWithSpacings)).getMainAxisSize();
                    i10++;
                }
                sum$iv = new int[mainAxisSizeWithSpacings];
                i4 = i2;
                while (i4 < mainAxisSizeWithSpacings) {
                    sum$iv[i4] = i2;
                    i4++;
                }
                if (isVertical) {
                    if (verticalArrangement == null) {
                    } else {
                        i5 = 0;
                        verticalArrangement.arrange(density, i24, iArr, sum$iv);
                        if ($this$fastForEach$iv) {
                            index$iv2 = RangesKt.reversed((IntProgression)ArraysKt.getIndices(sum$iv));
                        }
                        index = index$iv2.getFirst();
                        last = index$iv2.getLast();
                        index$iv$iv = index$iv2.getStep();
                        if (index$iv$iv > 0) {
                            if (index > last) {
                                if (index$iv$iv < 0 && last <= index) {
                                    if (last <= index) {
                                    } else {
                                        reverseAwareOffsetIndices = index$iv2;
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                        return (List)list4;
                    }
                    Density density2 = density;
                    int i23 = 0;
                    IllegalArgumentException $i$a$RequireNotNullLazyGridMeasureKt$calculateItemsOffsets$3 = new IllegalArgumentException("null verticalArrangement".toString());
                    throw $i$a$RequireNotNullLazyGridMeasureKt$calculateItemsOffsets$3;
                }
                Density density3 = density;
                if (horizontalArrangement == null) {
                } else {
                    index$iv$iv = 0;
                    horizontalArrangement.arrange(density, i24, iArr, LayoutDirection.Ltr, sum$iv);
                }
                int i14 = 0;
                IllegalArgumentException $i$a$RequireNotNullLazyGridMeasureKt$calculateItemsOffsets$5 = new IllegalArgumentException("null horizontalArrangement".toString());
                throw $i$a$RequireNotNullLazyGridMeasureKt$calculateItemsOffsets$5;
            }
            int i15 = 0;
            IllegalArgumentException $i$a$RequireLazyGridMeasureKt$calculateItemsOffsets$2 = new IllegalArgumentException("no items".toString());
            throw $i$a$RequireLazyGridMeasureKt$calculateItemsOffsets$2;
        }
        int i16 = 0;
        currentMainAxis = firstLineScrollOffset;
        Object obj2 = itemsBefore;
        int i19 = 0;
        if (size2-- >= 0) {
        }
        currentMainAxis2 = firstLineScrollOffset;
        ArrayList list = lines;
        int i20 = 0;
        index$iv = 0;
        while (index$iv < list.size()) {
            last = iArr;
            sum$iv = 0;
            LazyGridMeasureKt.addAllFromArray((List)list4, (LazyGridMeasuredLine)last.position(currentMainAxis2, i17, i18));
            currentMainAxis2 += mainAxisSizeWithSpacings;
            index$iv++;
        }
        $this$fastForEach$iv = itemsAfter;
        i8 = 0;
        index$iv2 = 0;
        while (index$iv2 < $this$fastForEach$iv.size()) {
            last = iArr;
            sum$iv = 0;
            (LazyGridMeasuredItem)last.position(currentMainAxis2, 0, i17, i18);
            list4.add(last);
            currentMainAxis2 += index$iv$iv;
            index$iv2++;
        }
    }

    private static final int calculateItemsOffsets$reverseAware(int $this$calculateItemsOffsets_u24reverseAware, boolean $reverseLayout, int linesCount) {
        int i;
        i = !$reverseLayout ? $this$calculateItemsOffsets_u24reverseAware : i2 + -1;
        return i;
    }

    public static final androidx.compose.foundation.lazy.grid.LazyGridMeasureResult measureLazyGrid-OZKpZRA(int itemsCount, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider measuredLineProvider, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider measuredItemProvider, int mainAxisAvailableSize, int beforeContentPadding, int afterContentPadding, int spaceBetweenLines, int firstVisibleLineIndex, int firstVisibleLineScrollOffset, float scrollToBeConsumed, long constraints, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density, LazyLayoutItemAnimator<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> itemAnimator, int slotsPerLine, List<Integer> pinnedItems, CoroutineScope coroutineScope, MutableState<Unit> placementScopeInvalidator, GraphicsContext graphicsContext, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> prefetchInfoRetriever, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout) {
        int mainAxisSizeWithSpacings2;
        Object size2;
        int size;
        int i40;
        Object invoke;
        Orientation horizontal;
        List i41;
        CoroutineScope firstItemIndex2;
        int index$iv;
        long l;
        int index$iv$iv;
        int measuredLine;
        int i31;
        int i24;
        int emptyList;
        int andMeasure--hBUhpc2;
        int i12;
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem andMeasure--hBUhpc;
        int constrainWidth-K40F9xA;
        int constrainHeight-K40F9xA;
        int currentMainAxisOffset2;
        int currentMainAxisOffset3;
        int currentMainAxisOffset;
        int i34;
        int i15;
        boolean height-impl;
        int currentFirstLineIndex;
        int currentFirstLineIndex2;
        int sign2;
        float f;
        boolean equals-impl0;
        Orientation horizontal2;
        int currentFirstLineScrollOffset2;
        int currentFirstLineScrollOffset4;
        int currentFirstLineScrollOffset3;
        int currentFirstLineScrollOffset;
        int index$iv$iv4;
        int index$iv$iv3;
        int $this$fastRoundToInt$iv;
        int sign;
        int i7;
        int i11;
        int visibleLinesScrollOffset;
        int visibleLinesScrollOffset3;
        int items$iv3;
        int items$iv;
        int i14;
        int i23;
        int i4;
        int currentFirstLineScrollOffset5;
        int i38;
        boolean empty;
        Object $this$fastFilter$iv;
        int i13;
        int i30;
        int index3;
        int i;
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine andMeasure;
        int mainAxisSizeWithSpacings;
        int layoutWidth;
        int remeasureNeeded;
        int layoutHeight;
        int empty2;
        int i39;
        Object firstLine2;
        int toScrollBack;
        int index;
        int index2;
        int $i$f$calculateExtraItems;
        int i32;
        int companion;
        Object lastOrNull;
        int i35;
        int items$iv2;
        int i18;
        int i5;
        int i9;
        int i21;
        int i16;
        int firstItemIndex3;
        int index$iv$iv2;
        int i17;
        int i6;
        androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap keyIndexMap;
        int i33;
        Object firstLine;
        int i36;
        boolean z;
        Object obj;
        int i37;
        int i2;
        int index$iv3;
        int i20;
        int i19;
        ArrayList i3;
        int i25;
        long childConstraints-JhjzzOo$foundation_release;
        int i26;
        CoroutineScope coroutineScope2;
        int i28;
        GraphicsContext context;
        int indexInVisibleLines;
        int i27;
        int visibleLinesScrollOffset2;
        int firstItemIndex;
        int i10;
        int index$iv$iv5;
        int i29;
        androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider lazyLayoutMeasuredItemProvider;
        int index$iv2;
        int i8;
        int i22;
        long $this$fastForEach$iv$iv;
        i = itemsCount;
        mainAxisSizeWithSpacings2 = measuredLineProvider;
        i41 = beforeContentPadding;
        index$iv = constraints;
        Object obj4 = obj71;
        int i49 = 0;
        i34 = i41 >= 0 ? 1 : i49;
        if (i34 == 0) {
        } else {
            i15 = afterContentPadding >= 0 ? 1 : i49;
            if (i15 == 0) {
            } else {
                ArrayList arrayList2 = new ArrayList();
                slotsPerLine.onMeasured(0, Constraints.getMinWidth-impl(index$iv), Constraints.getMinHeight-impl(index$iv), (List)arrayList2, measuredItemProvider.getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItemProvider, verticalArrangement, false, pinnedItems, false, 0, 0, placementScopeInvalidator, prefetchInfoRetriever);
                long minSizeToFitDisappearingItems-YbymL2g = slotsPerLine.getMinSizeToFitDisappearingItems-YbymL2g();
                if (i <= 0 && !IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g, obj6)) {
                    arrayList2 = new ArrayList();
                    slotsPerLine.onMeasured(0, Constraints.getMinWidth-impl(index$iv), Constraints.getMinHeight-impl(index$iv), (List)arrayList2, measuredItemProvider.getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItemProvider, verticalArrangement, false, pinnedItems, false, 0, 0, placementScopeInvalidator, prefetchInfoRetriever);
                    minSizeToFitDisappearingItems-YbymL2g = slotsPerLine.getMinSizeToFitDisappearingItems-YbymL2g();
                    if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g, obj6)) {
                        layoutWidth = ConstraintsKt.constrainWidth-K40F9xA(index$iv, obj3);
                        layoutHeight = ConstraintsKt.constrainHeight-K40F9xA(index$iv, obj3);
                    }
                    horizontal2 = verticalArrangement ? Orientation.Vertical : Orientation.Horizontal;
                    LazyGridMeasureResult lazyGridMeasureResult2 = new LazyGridMeasureResult(0, 0, 0, 0, (MeasureResult)obj4.invoke(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight), LazyGridMeasureKt.measureLazyGrid.3.INSTANCE), 0, placementScopeInvalidator, itemAnimator, pinnedItems, layout, CollectionsKt.emptyList(), -i41, mainAxisAvailableSize + afterContentPadding, 0, density, horizontal2, afterContentPadding, spaceBetweenLines);
                    return lazyGridMeasureResult2;
                }
                int i65 = 0;
                $this$fastRoundToInt$iv = Math.round(scrollToBeConsumed);
                i57 -= $this$fastRoundToInt$iv;
                if (firstVisibleLineIndex == 0 && currentFirstLineScrollOffset2 < 0) {
                    if (currentFirstLineScrollOffset2 < 0) {
                        $this$fastRoundToInt$iv += currentFirstLineScrollOffset2;
                        currentFirstLineScrollOffset2 = 0;
                    }
                }
                ArrayDeque arrayDeque = new ArrayDeque();
                i13 = spaceBetweenLines < 0 ? spaceBetweenLines : i49;
                i66 += i13;
                int i67 = mainAxisAvailableSize;
                currentFirstLineScrollOffset2 += i23;
                while (currentFirstLineScrollOffset4 < 0) {
                    if (currentFirstLineIndex > 0) {
                    }
                    i30 = currentFirstLineIndex + -1;
                    andMeasure = mainAxisSizeWithSpacings2.getAndMeasure(i30);
                    arrayDeque.add(i49, andMeasure);
                    currentFirstLineScrollOffset4 += mainAxisSizeWithSpacings;
                    currentFirstLineIndex = i30;
                }
                if (currentFirstLineScrollOffset4 < i23) {
                    $this$fastRoundToInt$iv += currentFirstLineScrollOffset4;
                    currentFirstLineScrollOffset4 = i23;
                }
                index3 = currentFirstLineIndex;
                int coerceAtLeast = RangesKt.coerceAtLeast(i67 + afterContentPadding, i49);
                currentMainAxisOffset2 = -currentFirstLineScrollOffset3;
                remeasureNeeded = 0;
                measuredLine = i72;
                empty2 = currentFirstLineIndex;
                while (measuredLine < arrayDeque.size()) {
                    if (currentMainAxisOffset2 >= coerceAtLeast) {
                    } else {
                    }
                    index3++;
                    currentMainAxisOffset2 += mainAxisSizeWithSpacings5;
                    measuredLine++;
                    currentFirstLineIndex = empty2;
                    empty2 = currentFirstLineIndex;
                    arrayDeque.remove(measuredLine);
                    remeasureNeeded = 1;
                    currentFirstLineIndex = empty2;
                }
                currentFirstLineIndex2 = empty2;
                while (index3 < i) {
                    measuredLine = mainAxisSizeWithSpacings2.getAndMeasure(index3);
                    currentMainAxisOffset2 += mainAxisSizeWithSpacings6;
                    if (currentMainAxisOffset <= i23) {
                    } else {
                    }
                    toScrollBack = currentMainAxisOffset;
                    empty2 = currentFirstLineIndex2;
                    arrayDeque.add(measuredLine);
                    currentFirstLineIndex2 = empty2;
                    index3++;
                    currentMainAxisOffset2 = toScrollBack;
                    measuredLine = indexInVisibleLines;
                    toScrollBack = currentMainAxisOffset;
                    empty2 = currentFirstLineIndex2;
                    if ((LazyGridMeasuredItem)ArraysKt.last(measuredLine.getItems()).getIndex() != i + -1) {
                    } else {
                    }
                    currentFirstLineScrollOffset3 -= mainAxisSizeWithSpacings4;
                    remeasureNeeded = i56;
                    currentFirstLineIndex2 = currentMainAxisOffset;
                }
                indexInVisibleLines = measuredLine;
                i39 = currentFirstLineIndex2;
                if (currentMainAxisOffset2 < i67) {
                    i31 = i67 - currentMainAxisOffset2;
                    currentFirstLineScrollOffset3 -= i31;
                    currentMainAxisOffset2 += i31;
                    currentFirstLineIndex2 = i39;
                    while (currentFirstLineScrollOffset3 < i41) {
                        int toScrollBack2 = currentFirstLineIndex2 + -1;
                        androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine andMeasure2 = mainAxisSizeWithSpacings2.getAndMeasure(toScrollBack2);
                        arrayDeque.add(0, andMeasure2);
                        currentFirstLineScrollOffset3 += mainAxisSizeWithSpacings3;
                        currentFirstLineIndex2 = i39;
                        i31 = toScrollBack;
                        currentMainAxisOffset3 = i35;
                    }
                    toScrollBack = i31;
                    i35 = currentMainAxisOffset3;
                    $this$fastRoundToInt$iv += toScrollBack;
                    if (currentFirstLineScrollOffset3 < 0) {
                        currentMainAxisOffset2 = i35 + currentFirstLineScrollOffset3;
                        currentFirstLineScrollOffset3 = 0;
                        i27 = currentFirstLineIndex2;
                        i24 = $this$fastRoundToInt$iv;
                    } else {
                        i27 = currentFirstLineIndex2;
                        i24 = $this$fastRoundToInt$iv;
                        currentMainAxisOffset2 = i35;
                    }
                } else {
                    i24 = $this$fastRoundToInt$iv;
                    i27 = i39;
                }
                int i59 = 0;
                int i60 = 0;
                if (MathKt.getSign(Math.round(scrollToBeConsumed)) == MathKt.getSign(i24) && Math.abs(Math.round(scrollToBeConsumed)) >= Math.abs(i24)) {
                    i60 = 0;
                    f = Math.abs(Math.round(scrollToBeConsumed)) >= Math.abs(i24) ? (float)i24 : scrollToBeConsumed;
                } else {
                }
                i7 = currentFirstLineScrollOffset3 >= 0 ? 1 : 0;
                if (i7 == 0) {
                } else {
                    i11 = -currentFirstLineScrollOffset3;
                    firstLine2 = arrayDeque.first();
                    Object firstOrNull = ArraysKt.firstOrNull((LazyGridMeasuredLine)firstLine2.getItems());
                    if ((LazyGridMeasuredItem)firstOrNull != null) {
                        index = (LazyGridMeasuredItem)firstOrNull.getIndex();
                    } else {
                        index = 0;
                    }
                    visibleLinesScrollOffset2 = index;
                    lastOrNull = arrayDeque.lastOrNull();
                    lastOrNull = (LazyGridMeasuredLine)lastOrNull.getItems();
                    lastOrNull = ArraysKt.lastOrNull(lastOrNull);
                    if (lastOrNull != null && lastOrNull != null && (LazyGridMeasuredItem)lastOrNull != null) {
                        lastOrNull = lastOrNull.getItems();
                        if (lastOrNull != null) {
                            lastOrNull = ArraysKt.lastOrNull(lastOrNull);
                            if ((LazyGridMeasuredItem)(LazyGridMeasuredItem)lastOrNull != null) {
                                index2 = (LazyGridMeasuredItem)(LazyGridMeasuredItem)lastOrNull.getIndex();
                            } else {
                                index2 = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                    i10 = index2;
                    int i76 = 0;
                    items$iv2 = 0;
                    int i83 = 0;
                    final int i110 = i24;
                    emptyList = coroutineScope.size();
                    int index$iv$iv7 = currentFirstLineScrollOffset3;
                    currentFirstLineScrollOffset = i114;
                    while (currentFirstLineScrollOffset < emptyList) {
                        int i50 = i9;
                        andMeasure--hBUhpc2 = (Number)i50.get(currentFirstLineScrollOffset).intValue();
                        i36 = 0;
                        i37 = andMeasure--hBUhpc2;
                        int i98 = 0;
                        if (i37 >= 0) {
                        } else {
                        }
                        index$iv$iv5 = currentFirstLineScrollOffset;
                        index$iv$iv4 = visibleLinesScrollOffset2;
                        firstItemIndex = i11;
                        visibleLinesScrollOffset3 = i37;
                        visibleLinesScrollOffset = 0;
                        if (visibleLinesScrollOffset != null) {
                        } else {
                        }
                        index$iv3 = andMeasure--hBUhpc2;
                        i9 = i28;
                        i11 = firstItemIndex;
                        visibleLinesScrollOffset2 = index$iv$iv4;
                        currentFirstLineScrollOffset = i51;
                        emptyList = i33;
                        int spanOf = mainAxisSizeWithSpacings2.spanOf(andMeasure--hBUhpc2);
                        if (items$iv2 == 0) {
                        } else {
                        }
                        visibleLinesScrollOffset = items$iv2;
                        visibleLinesScrollOffset.add(measuredItemProvider.getAndMeasure--hBUhpc(andMeasure--hBUhpc2, 0, spanOf, mainAxisSizeWithSpacings2.childConstraints-JhjzzOo$foundation_release(0, spanOf)));
                        items$iv2 = visibleLinesScrollOffset;
                        ArrayList arrayList3 = new ArrayList();
                        visibleLinesScrollOffset = items$iv2;
                        index$iv$iv5 = currentFirstLineScrollOffset;
                        firstItemIndex = i11;
                        if (i37 < visibleLinesScrollOffset2) {
                        } else {
                        }
                        visibleLinesScrollOffset = 1;
                    }
                    i29 = currentFirstLineScrollOffset;
                    int i107 = i9;
                    index$iv$iv3 = visibleLinesScrollOffset2;
                    if (items$iv2 == 0) {
                        $i$f$calculateExtraItems = emptyList;
                    } else {
                        $i$f$calculateExtraItems = items$iv2;
                    }
                    i21 = 0;
                    int i91 = i52;
                    i12 = coroutineScope.size();
                    index$iv$iv2 = i61;
                    items$iv3 = i115;
                    while (items$iv3 < i12) {
                        int i53 = i18;
                        andMeasure--hBUhpc = (Number)i53.get(items$iv3).intValue();
                        i37 = 0;
                        i25 = 0;
                        int minOffset = i19;
                        if (i10 + 1 <= minOffset && minOffset < i) {
                        } else {
                        }
                        items$iv = 0;
                        if (items$iv != 0) {
                        } else {
                        }
                        index$iv2 = andMeasure--hBUhpc;
                        i4 = 0;
                        items$iv3 = childConstraints-JhjzzOo$foundation_release + 1;
                        i12 = i36;
                        i18 = index$iv3;
                        i23 = i29;
                        int spanOf2 = mainAxisSizeWithSpacings2.spanOf(andMeasure--hBUhpc);
                        if (index$iv$iv2 == 0) {
                        } else {
                        }
                        items$iv = index$iv$iv2;
                        items$iv.add(measuredItemProvider.getAndMeasure--hBUhpc(andMeasure--hBUhpc, 0, spanOf2, mainAxisSizeWithSpacings2.childConstraints-JhjzzOo$foundation_release(0, spanOf2)));
                        index$iv$iv2 = items$iv;
                        items$iv = new ArrayList();
                        if (minOffset < i) {
                        } else {
                        }
                        items$iv = 1;
                    }
                    int i102 = items$iv3;
                    int i111 = i23;
                    int i99 = i18;
                    int minOffset2 = 0;
                    if (index$iv$iv2 == 0) {
                        i5 = i12;
                    } else {
                        i5 = index$iv$iv2;
                    }
                    if (i41 <= 0) {
                        if (spaceBetweenLines < 0) {
                            i12 = 0;
                            currentFirstLineScrollOffset5 = index$iv$iv7;
                            while (i12 < arrayDeque.size()) {
                                mainAxisSizeWithSpacings2 = (LazyGridMeasuredLine)arrayDeque.get(i12).getMainAxisSizeWithSpacings();
                                currentFirstLineScrollOffset5 -= index$iv$iv2;
                                firstLine2 = obj2;
                                i12++;
                                mainAxisSizeWithSpacings2 = measuredLineProvider;
                            }
                            size2 = firstLine2;
                        } else {
                            currentFirstLineScrollOffset5 = index$iv$iv7;
                            size2 = firstLine2;
                        }
                    } else {
                    }
                    if (verticalArrangement) {
                        i16 = constrainWidth-K40F9xA;
                    } else {
                        i16 = constrainWidth-K40F9xA;
                    }
                    if (verticalArrangement) {
                        i17 = constrainHeight-K40F9xA;
                    } else {
                        i17 = constrainHeight-K40F9xA;
                    }
                    int i87 = currentMainAxisOffset2;
                    int i92 = i67;
                    List itemsOffsets = LazyGridMeasureKt.calculateItemsOffsets((List)arrayDeque, $i$f$calculateExtraItems, i5, i16, i17, i87, i92, i11, verticalArrangement, horizontalArrangement, reverseLayout, density, itemAnimator);
                    int extraItemsAfter = i16;
                    int i54 = i92;
                    int i103 = i87;
                    int i100 = currentFirstLineScrollOffset5;
                    int i80 = i17;
                    slotsPerLine.onMeasured((int)f, extraItemsAfter, i80, itemsOffsets, measuredItemProvider.getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItemProvider, verticalArrangement, false, pinnedItems, false, i100, i103, placementScopeInvalidator, prefetchInfoRetriever);
                    i14 = extraItemsAfter;
                    i38 = i80;
                    int i68 = i103;
                    long minSizeToFitDisappearingItems-YbymL2g2 = slotsPerLine.getMinSizeToFitDisappearingItems-YbymL2g();
                    firstItemIndex3 = index$iv$iv3;
                    if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g2, i)) {
                        equals-impl0 = verticalArrangement ? i38 : i14;
                        index$iv$iv3 = ConstraintsKt.constrainWidth-K40F9xA(index$iv, obj3);
                        i14 = verticalArrangement ? i6 : index$iv$iv3;
                        if (i14 != equals-impl0) {
                            i38 = itemsOffsets;
                            companion = 0;
                            firstLine = size2;
                            size2 = i38.size();
                            index$iv = keyIndexMap;
                            while (index$iv < size2) {
                                z = false;
                                (LazyGridMeasuredItem)i38.get(index$iv).updateMainAxisLayoutSize(i14);
                                index$iv++;
                                size2 = keyIndexMap;
                            }
                        } else {
                            firstLine = size2;
                        }
                        i32 = index$iv$iv3;
                    } else {
                        firstLine = size2;
                        i32 = i14;
                        i6 = i38;
                    }
                    int i47 = i10;
                    if (i47 == itemsCount + -1) {
                        if (i68 > i54) {
                            index$iv$iv = 1;
                        } else {
                            index$iv$iv = 0;
                        }
                    } else {
                    }
                    LazyGridMeasureKt.measureLazyGrid.6 anon = new LazyGridMeasureKt.measureLazyGrid.6(itemsOffsets, graphicsContext);
                    invoke = obj4.invoke(Integer.valueOf(i32), Integer.valueOf(i6), anon);
                    if ($i$f$calculateExtraItems.isEmpty() && i5.isEmpty()) {
                        if (i113.isEmpty()) {
                            obj = invoke;
                            i26 = index$iv$iv;
                            $this$fastFilter$iv = itemsOffsets;
                        } else {
                            List list = itemsOffsets;
                            i = 0;
                            obj = invoke;
                            ArrayList arrayList = new ArrayList(list.size());
                            i2 = 0;
                            i3 = arrayList;
                            size = list.size();
                            i26 = index$iv$iv;
                            index$iv$iv = i20;
                            while (index$iv$iv < size) {
                                coroutineScope2 = i20;
                                context = null;
                                i8 = 0;
                                int index4 = (LazyGridMeasuredItem)coroutineScope2.getIndex();
                                int $this$fastForEach$iv$iv2 = firstItemIndex3;
                                if ($this$fastForEach$iv$iv2 <= index4 && index4 <= i47) {
                                } else {
                                }
                                i40 = 0;
                                if (i40 != 0) {
                                } else {
                                }
                                firstItemIndex3 = $this$fastForEach$iv$iv2;
                                firstItemIndex2 = coroutineScope2;
                                index$iv$iv++;
                                size = i22;
                                i41 = $this$fastForEach$iv$iv;
                                firstItemIndex3 = $this$fastForEach$iv$iv2;
                                (Collection)i3.add(coroutineScope2);
                                if (index4 <= i47) {
                                } else {
                                }
                                i40 = 1;
                            }
                            $this$fastForEach$iv$iv = i41;
                            $this$fastFilter$iv = invoke;
                        }
                    } else {
                    }
                    horizontal = verticalArrangement ? Orientation.Vertical : Orientation.Horizontal;
                    List list3 = itemsOffsets;
                    long l4 = l3;
                    int i95 = i47;
                    int firstLine3 = i54;
                    int consumedScroll = coerceAtLeast;
                    int i104 = i88;
                    int currentMainAxisOffset5 = firstItemIndex3;
                    int firstItemIndex4 = i74;
                    ArrayDeque index5 = arrayDeque;
                    LazyGridMeasureResult lazyGridMeasureResult = new LazyGridMeasureResult(firstLine, i100, i26, f, obj, remeasureNeeded, placementScopeInvalidator, itemAnimator, pinnedItems, layout, $this$fastFilter$iv, -i41, mainAxisAvailableSize + afterContentPadding, itemsCount, density, horizontal, afterContentPadding, spaceBetweenLines);
                    return lazyGridMeasureResult;
                }
                int i44 = 0;
                IllegalArgumentException $i$a$RequireLazyGridMeasureKt$measureLazyGrid$4 = new IllegalArgumentException("negative initial offset".toString());
                throw $i$a$RequireLazyGridMeasureKt$measureLazyGrid$4;
            }
            int i45 = 0;
            IllegalArgumentException $i$a$RequireLazyGridMeasureKt$measureLazyGrid$2 = new IllegalArgumentException("negative afterContentPadding".toString());
            throw $i$a$RequireLazyGridMeasureKt$measureLazyGrid$2;
        }
        int i46 = 0;
        IllegalArgumentException $i$a$RequireLazyGridMeasureKt$measureLazyGrid$1 = new IllegalArgumentException("negative beforeContentPadding".toString());
        throw $i$a$RequireLazyGridMeasureKt$measureLazyGrid$1;
    }
}
