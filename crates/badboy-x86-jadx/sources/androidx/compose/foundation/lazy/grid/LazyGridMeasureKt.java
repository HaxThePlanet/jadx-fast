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
        ArrayList currentMainAxis;
        int currentMainAxis2;
        boolean $this$fastForEach$iv;
        int i3;
        int i8;
        int i12;
        boolean empty;
        int i10;
        int i;
        Object obj3;
        Object index$iv2;
        int i13;
        int index$iv;
        int mainAxisSize2;
        int i2;
        int index;
        int size;
        int iArr;
        Object ltr;
        int last;
        int sum$iv;
        int mainAxisSizeWithSpacings;
        int index$iv$iv;
        int i6;
        Object reverseAwareOffsetIndices;
        int i4;
        int mainAxisSize;
        int i5;
        Object obj;
        int i9;
        int i11;
        int i7;
        currentMainAxis = lines;
        final int i17 = layoutWidth;
        final int i18 = layoutHeight;
        $this$fastForEach$iv = reverseLayout;
        i3 = isVertical ? i18 : i17;
        final int i24 = i3;
        i12 = finalMainAxisOffset < Math.min(i24, maxOffset) ? 1 : 0;
        final int i26 = i12;
        if (i26 != 0) {
            i12 = firstLineScrollOffset == null ? 1 : 0;
            if (i12 == 0) {
            } else {
            }
            int i22 = 0;
            IllegalStateException illegalStateException = new IllegalStateException("non-zero firstLineScrollOffset".toString());
            throw illegalStateException;
        }
        last = 0;
        sum$iv = 0;
        ArrayList list3 = list2;
        mainAxisSizeWithSpacings = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list3.size()) {
            i5 = 0;
            i9 = 0;
            i11 = 0;
            sum$iv += iArr;
            index$iv$iv++;
        }
        i7 = 0;
        ArrayList $this$fastSumBy$iv = new ArrayList(sum$iv);
        ArrayList list4 = $this$fastSumBy$iv;
        if (i26 != 0) {
            if (itemsBefore.isEmpty() && itemsAfter.isEmpty()) {
                mainAxisSize2 = itemsAfter.isEmpty() ? 1 : i7;
            } else {
            }
            if (mainAxisSize2 == 0) {
            } else {
                mainAxisSizeWithSpacings = currentMainAxis.size();
                iArr = new int[mainAxisSizeWithSpacings];
                i10 = i7;
                while (i10 < mainAxisSizeWithSpacings) {
                    iArr[i10] = (LazyGridMeasuredLine)currentMainAxis.get(LazyGridMeasureKt.calculateItemsOffsets$reverseAware(i10, $this$fastForEach$iv, mainAxisSizeWithSpacings)).getMainAxisSize();
                    i10++;
                }
                sum$iv = new int[mainAxisSizeWithSpacings];
                i = i7;
                while (i < mainAxisSizeWithSpacings) {
                    sum$iv[i] = i7;
                    i++;
                }
                if (isVertical) {
                    if (verticalArrangement == null) {
                    } else {
                        i2 = 0;
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
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("null verticalArrangement".toString());
                    throw illegalArgumentException3;
                }
                Density density3 = density;
                if (horizontalArrangement == null) {
                } else {
                    index$iv$iv = 0;
                    horizontalArrangement.arrange(density, i24, iArr, LayoutDirection.Ltr, sum$iv);
                }
                int i14 = 0;
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("null horizontalArrangement".toString());
                throw illegalArgumentException;
            }
            int i15 = 0;
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("no items".toString());
            throw illegalArgumentException2;
        }
        int i16 = 0;
        currentMainAxis2 = firstLineScrollOffset;
        Object obj2 = itemsBefore;
        int i19 = 0;
        if (size2-- >= 0) {
        }
        currentMainAxis = firstLineScrollOffset;
        ArrayList list = lines;
        int i20 = 0;
        index$iv = 0;
        while (index$iv < list.size()) {
            last = iArr;
            sum$iv = 0;
            LazyGridMeasureKt.addAllFromArray((List)list4, (LazyGridMeasuredLine)last.position(currentMainAxis, i17, i18));
            currentMainAxis += mainAxisSizeWithSpacings;
            index$iv++;
        }
        $this$fastForEach$iv = itemsAfter;
        i8 = 0;
        index$iv2 = 0;
        while (index$iv2 < $this$fastForEach$iv.size()) {
            last = iArr;
            sum$iv = 0;
            (LazyGridMeasuredItem)last.position(currentMainAxis, 0, i17, i18);
            list4.add(last);
            currentMainAxis += index$iv$iv;
            index$iv2++;
        }
    }

    private static final int calculateItemsOffsets$reverseAware(int $this$calculateItemsOffsets_u24reverseAware, boolean $reverseLayout, int linesCount) {
        int i;
        i = !$reverseLayout ? $this$calculateItemsOffsets_u24reverseAware : i2 + -1;
        return i;
    }

    public static final androidx.compose.foundation.lazy.grid.LazyGridMeasureResult measureLazyGrid-OZKpZRA(int itemsCount, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider measuredLineProvider, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider measuredItemProvider, int mainAxisAvailableSize, int beforeContentPadding, int afterContentPadding, int spaceBetweenLines, int firstVisibleLineIndex, int firstVisibleLineScrollOffset, float scrollToBeConsumed, long constraints, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density, LazyLayoutItemAnimator<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> itemAnimator, int slotsPerLine, List<Integer> pinnedItems, CoroutineScope coroutineScope, MutableState<Unit> placementScopeInvalidator, GraphicsContext graphicsContext, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> prefetchInfoRetriever, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout) {
        int mainAxisSizeWithSpacings;
        Object size;
        int size2;
        int i28;
        Object invoke;
        Orientation horizontal;
        List i18;
        CoroutineScope firstItemIndex;
        int index$iv3;
        long l;
        int index$iv$iv3;
        int measuredLine;
        int i40;
        int i21;
        int emptyList;
        int andMeasure--hBUhpc2;
        int i35;
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem andMeasure--hBUhpc;
        int constrainWidth-K40F9xA;
        int constrainHeight-K40F9xA;
        int currentMainAxisOffset;
        int currentMainAxisOffset3;
        int currentMainAxisOffset2;
        int i38;
        int i37;
        boolean height-impl;
        int currentFirstLineIndex2;
        int currentFirstLineIndex;
        int sign;
        float f;
        boolean equals-impl0;
        Orientation horizontal2;
        int currentFirstLineScrollOffset;
        int currentFirstLineScrollOffset5;
        int currentFirstLineScrollOffset2;
        int currentFirstLineScrollOffset3;
        int index$iv$iv5;
        int index$iv$iv;
        int $this$fastRoundToInt$iv;
        int sign2;
        int i6;
        int i3;
        int visibleLinesScrollOffset3;
        int visibleLinesScrollOffset2;
        int items$iv3;
        int items$iv2;
        int i7;
        int i8;
        int i5;
        int currentFirstLineScrollOffset4;
        int i22;
        boolean empty;
        Object $this$fastFilter$iv;
        int i19;
        int i26;
        int index2;
        int i31;
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine andMeasure;
        int mainAxisSizeWithSpacings2;
        int layoutWidth;
        int remeasureNeeded;
        int layoutHeight;
        int empty2;
        int i20;
        Object firstLine2;
        int toScrollBack;
        int index3;
        int index;
        int $i$f$calculateExtraItems;
        int i16;
        int companion;
        Object lastOrNull;
        int i15;
        int items$iv;
        int i12;
        int i13;
        int i10;
        int i14;
        int i33;
        int firstItemIndex3;
        int index$iv$iv4;
        int i27;
        int i29;
        androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap keyIndexMap;
        int i2;
        Object firstLine;
        int i30;
        boolean z;
        Object obj;
        int i17;
        int i;
        int index$iv2;
        int i34;
        int i23;
        ArrayList i36;
        int i41;
        long childConstraints-JhjzzOo$foundation_release;
        int i24;
        CoroutineScope coroutineScope2;
        int i4;
        GraphicsContext context;
        int indexInVisibleLines;
        int i9;
        int visibleLinesScrollOffset;
        int firstItemIndex2;
        int i11;
        int index$iv$iv2;
        int i39;
        androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider lazyLayoutMeasuredItemProvider;
        int index$iv;
        int i25;
        int i32;
        long $this$fastForEach$iv$iv;
        i31 = itemsCount;
        mainAxisSizeWithSpacings = measuredLineProvider;
        i18 = beforeContentPadding;
        index$iv3 = constraints;
        Object obj4 = obj71;
        int i49 = 0;
        i38 = i18 >= 0 ? 1 : i49;
        if (i38 == 0) {
        } else {
            i37 = afterContentPadding >= 0 ? 1 : i49;
            if (i37 == 0) {
            } else {
                ArrayList arrayList2 = new ArrayList();
                slotsPerLine.onMeasured(0, Constraints.getMinWidth-impl(index$iv3), Constraints.getMinHeight-impl(index$iv3), (List)arrayList2, measuredItemProvider.getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItemProvider, verticalArrangement, false, pinnedItems, false, 0, 0, placementScopeInvalidator, prefetchInfoRetriever);
                long minSizeToFitDisappearingItems-YbymL2g = slotsPerLine.getMinSizeToFitDisappearingItems-YbymL2g();
                if (i31 <= 0 && !IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g, obj6)) {
                    arrayList2 = new ArrayList();
                    slotsPerLine.onMeasured(0, Constraints.getMinWidth-impl(index$iv3), Constraints.getMinHeight-impl(index$iv3), (List)arrayList2, measuredItemProvider.getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItemProvider, verticalArrangement, false, pinnedItems, false, 0, 0, placementScopeInvalidator, prefetchInfoRetriever);
                    minSizeToFitDisappearingItems-YbymL2g = slotsPerLine.getMinSizeToFitDisappearingItems-YbymL2g();
                    if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g, obj6)) {
                        layoutWidth = ConstraintsKt.constrainWidth-K40F9xA(index$iv3, obj3);
                        layoutHeight = ConstraintsKt.constrainHeight-K40F9xA(index$iv3, obj3);
                    }
                    horizontal2 = verticalArrangement ? Orientation.Vertical : Orientation.Horizontal;
                    LazyGridMeasureResult lazyGridMeasureResult2 = new LazyGridMeasureResult(0, 0, 0, 0, (MeasureResult)obj4.invoke(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight), LazyGridMeasureKt.measureLazyGrid.3.INSTANCE), 0, placementScopeInvalidator, itemAnimator, pinnedItems, layout, CollectionsKt.emptyList(), -i18, mainAxisAvailableSize + afterContentPadding, 0, density, horizontal2, afterContentPadding, spaceBetweenLines);
                    return lazyGridMeasureResult2;
                }
                int i65 = 0;
                $this$fastRoundToInt$iv = Math.round(scrollToBeConsumed);
                i57 -= $this$fastRoundToInt$iv;
                if (firstVisibleLineIndex == 0 && currentFirstLineScrollOffset < 0) {
                    if (currentFirstLineScrollOffset < 0) {
                        $this$fastRoundToInt$iv += currentFirstLineScrollOffset;
                        currentFirstLineScrollOffset = 0;
                    }
                }
                ArrayDeque arrayDeque = new ArrayDeque();
                i19 = spaceBetweenLines < 0 ? spaceBetweenLines : i49;
                i66 += i19;
                int i67 = mainAxisAvailableSize;
                currentFirstLineScrollOffset += i8;
                while (currentFirstLineScrollOffset5 < 0) {
                    if (currentFirstLineIndex2 > 0) {
                    }
                    i26 = currentFirstLineIndex2 + -1;
                    andMeasure = mainAxisSizeWithSpacings.getAndMeasure(i26);
                    arrayDeque.add(i49, andMeasure);
                    currentFirstLineScrollOffset5 += mainAxisSizeWithSpacings2;
                    currentFirstLineIndex2 = i26;
                }
                if (currentFirstLineScrollOffset5 < i8) {
                    $this$fastRoundToInt$iv += currentFirstLineScrollOffset5;
                    currentFirstLineScrollOffset5 = i8;
                }
                index2 = currentFirstLineIndex2;
                int coerceAtLeast = RangesKt.coerceAtLeast(i67 + afterContentPadding, i49);
                currentMainAxisOffset = -currentFirstLineScrollOffset2;
                remeasureNeeded = 0;
                measuredLine = i72;
                empty2 = currentFirstLineIndex2;
                while (measuredLine < arrayDeque.size()) {
                    if (currentMainAxisOffset >= coerceAtLeast) {
                    } else {
                    }
                    index2++;
                    currentMainAxisOffset += mainAxisSizeWithSpacings5;
                    measuredLine++;
                    currentFirstLineIndex2 = empty2;
                    empty2 = currentFirstLineIndex2;
                    arrayDeque.remove(measuredLine);
                    remeasureNeeded = 1;
                    currentFirstLineIndex2 = empty2;
                }
                currentFirstLineIndex = empty2;
                while (index2 < i31) {
                    measuredLine = mainAxisSizeWithSpacings.getAndMeasure(index2);
                    currentMainAxisOffset += mainAxisSizeWithSpacings6;
                    if (currentMainAxisOffset2 <= i8) {
                    } else {
                    }
                    toScrollBack = currentMainAxisOffset2;
                    empty2 = currentFirstLineIndex;
                    arrayDeque.add(measuredLine);
                    currentFirstLineIndex = empty2;
                    index2++;
                    currentMainAxisOffset = toScrollBack;
                    measuredLine = indexInVisibleLines;
                    toScrollBack = currentMainAxisOffset2;
                    empty2 = currentFirstLineIndex;
                    if ((LazyGridMeasuredItem)ArraysKt.last(measuredLine.getItems()).getIndex() != i31 + -1) {
                    } else {
                    }
                    currentFirstLineScrollOffset2 -= mainAxisSizeWithSpacings4;
                    remeasureNeeded = i56;
                    currentFirstLineIndex = currentMainAxisOffset2;
                }
                indexInVisibleLines = measuredLine;
                i20 = currentFirstLineIndex;
                if (currentMainAxisOffset < i67) {
                    i40 = i67 - currentMainAxisOffset;
                    currentFirstLineScrollOffset2 -= i40;
                    currentMainAxisOffset += i40;
                    currentFirstLineIndex = i20;
                    while (currentFirstLineScrollOffset2 < i18) {
                        int toScrollBack2 = currentFirstLineIndex + -1;
                        androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine andMeasure2 = mainAxisSizeWithSpacings.getAndMeasure(toScrollBack2);
                        arrayDeque.add(0, andMeasure2);
                        currentFirstLineScrollOffset2 += mainAxisSizeWithSpacings3;
                        currentFirstLineIndex = i20;
                        i40 = toScrollBack;
                        currentMainAxisOffset3 = i15;
                    }
                    toScrollBack = i40;
                    i15 = currentMainAxisOffset3;
                    $this$fastRoundToInt$iv += toScrollBack;
                    if (currentFirstLineScrollOffset2 < 0) {
                        currentMainAxisOffset = i15 + currentFirstLineScrollOffset2;
                        currentFirstLineScrollOffset2 = 0;
                        i9 = currentFirstLineIndex;
                        i21 = $this$fastRoundToInt$iv;
                    } else {
                        i9 = currentFirstLineIndex;
                        i21 = $this$fastRoundToInt$iv;
                        currentMainAxisOffset = i15;
                    }
                } else {
                    i21 = $this$fastRoundToInt$iv;
                    i9 = i20;
                }
                int i59 = 0;
                int i60 = 0;
                if (MathKt.getSign(Math.round(scrollToBeConsumed)) == MathKt.getSign(i21) && Math.abs(Math.round(scrollToBeConsumed)) >= Math.abs(i21)) {
                    i60 = 0;
                    f = Math.abs(Math.round(scrollToBeConsumed)) >= Math.abs(i21) ? (float)i21 : scrollToBeConsumed;
                } else {
                }
                i6 = currentFirstLineScrollOffset2 >= 0 ? 1 : 0;
                if (i6 == 0) {
                } else {
                    i3 = -currentFirstLineScrollOffset2;
                    firstLine2 = arrayDeque.first();
                    Object firstOrNull = ArraysKt.firstOrNull((LazyGridMeasuredLine)firstLine2.getItems());
                    if ((LazyGridMeasuredItem)firstOrNull != null) {
                        index3 = (LazyGridMeasuredItem)firstOrNull.getIndex();
                    } else {
                        index3 = 0;
                    }
                    visibleLinesScrollOffset = index3;
                    lastOrNull = arrayDeque.lastOrNull();
                    lastOrNull = (LazyGridMeasuredLine)lastOrNull.getItems();
                    lastOrNull = ArraysKt.lastOrNull(lastOrNull);
                    if (lastOrNull != null && lastOrNull != null && (LazyGridMeasuredItem)lastOrNull != null) {
                        lastOrNull = lastOrNull.getItems();
                        if (lastOrNull != null) {
                            lastOrNull = ArraysKt.lastOrNull(lastOrNull);
                            if ((LazyGridMeasuredItem)(LazyGridMeasuredItem)lastOrNull != null) {
                                index = (LazyGridMeasuredItem)(LazyGridMeasuredItem)lastOrNull.getIndex();
                            } else {
                                index = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                    i11 = index;
                    int i76 = 0;
                    items$iv = 0;
                    int i83 = 0;
                    final int i110 = i21;
                    emptyList = coroutineScope.size();
                    int index$iv$iv7 = currentFirstLineScrollOffset2;
                    currentFirstLineScrollOffset3 = i114;
                    while (currentFirstLineScrollOffset3 < emptyList) {
                        int i50 = i10;
                        andMeasure--hBUhpc2 = (Number)i50.get(currentFirstLineScrollOffset3).intValue();
                        i30 = 0;
                        i17 = andMeasure--hBUhpc2;
                        int i98 = 0;
                        if (i17 >= 0) {
                        } else {
                        }
                        index$iv$iv2 = currentFirstLineScrollOffset3;
                        index$iv$iv5 = visibleLinesScrollOffset;
                        firstItemIndex2 = i3;
                        visibleLinesScrollOffset2 = i17;
                        visibleLinesScrollOffset3 = 0;
                        if (visibleLinesScrollOffset3 != 0) {
                        } else {
                        }
                        index$iv2 = andMeasure--hBUhpc2;
                        i10 = i4;
                        i3 = firstItemIndex2;
                        visibleLinesScrollOffset = index$iv$iv5;
                        currentFirstLineScrollOffset3 = i51;
                        emptyList = i2;
                        int spanOf = mainAxisSizeWithSpacings.spanOf(andMeasure--hBUhpc2);
                        if (items$iv == 0) {
                        } else {
                        }
                        visibleLinesScrollOffset3 = items$iv;
                        visibleLinesScrollOffset3.add(measuredItemProvider.getAndMeasure--hBUhpc(andMeasure--hBUhpc2, 0, spanOf, mainAxisSizeWithSpacings.childConstraints-JhjzzOo$foundation_release(0, spanOf)));
                        items$iv = visibleLinesScrollOffset3;
                        ArrayList arrayList3 = new ArrayList();
                        visibleLinesScrollOffset3 = items$iv;
                        index$iv$iv2 = currentFirstLineScrollOffset3;
                        firstItemIndex2 = i3;
                        if (i17 < visibleLinesScrollOffset) {
                        } else {
                        }
                        visibleLinesScrollOffset3 = 1;
                    }
                    i39 = currentFirstLineScrollOffset3;
                    int i107 = i10;
                    index$iv$iv = visibleLinesScrollOffset;
                    if (items$iv == 0) {
                        $i$f$calculateExtraItems = emptyList;
                    } else {
                        $i$f$calculateExtraItems = items$iv;
                    }
                    i14 = 0;
                    int i91 = i52;
                    i35 = coroutineScope.size();
                    index$iv$iv4 = i61;
                    items$iv3 = i115;
                    while (items$iv3 < i35) {
                        int i53 = i12;
                        andMeasure--hBUhpc = (Number)i53.get(items$iv3).intValue();
                        i17 = 0;
                        i41 = 0;
                        int minOffset = i23;
                        if (i11 + 1 <= minOffset && minOffset < i31) {
                        } else {
                        }
                        items$iv2 = 0;
                        if (items$iv2 != 0) {
                        } else {
                        }
                        index$iv = andMeasure--hBUhpc;
                        i5 = 0;
                        items$iv3 = childConstraints-JhjzzOo$foundation_release + 1;
                        i35 = i30;
                        i12 = index$iv2;
                        i8 = i39;
                        int spanOf2 = mainAxisSizeWithSpacings.spanOf(andMeasure--hBUhpc);
                        if (index$iv$iv4 == 0) {
                        } else {
                        }
                        items$iv2 = index$iv$iv4;
                        items$iv2.add(measuredItemProvider.getAndMeasure--hBUhpc(andMeasure--hBUhpc, 0, spanOf2, mainAxisSizeWithSpacings.childConstraints-JhjzzOo$foundation_release(0, spanOf2)));
                        index$iv$iv4 = items$iv2;
                        items$iv2 = new ArrayList();
                        if (minOffset < i31) {
                        } else {
                        }
                        items$iv2 = 1;
                    }
                    int i102 = items$iv3;
                    int i111 = i8;
                    int i99 = i12;
                    int minOffset2 = 0;
                    if (index$iv$iv4 == 0) {
                        i13 = i35;
                    } else {
                        i13 = index$iv$iv4;
                    }
                    if (i18 <= 0) {
                        if (spaceBetweenLines < 0) {
                            i35 = 0;
                            currentFirstLineScrollOffset4 = index$iv$iv7;
                            while (i35 < arrayDeque.size()) {
                                mainAxisSizeWithSpacings = (LazyGridMeasuredLine)arrayDeque.get(i35).getMainAxisSizeWithSpacings();
                                currentFirstLineScrollOffset4 -= index$iv$iv4;
                                firstLine2 = obj2;
                                i35++;
                                mainAxisSizeWithSpacings = measuredLineProvider;
                            }
                            size = firstLine2;
                        } else {
                            currentFirstLineScrollOffset4 = index$iv$iv7;
                            size = firstLine2;
                        }
                    } else {
                    }
                    if (verticalArrangement) {
                        i33 = constrainWidth-K40F9xA;
                    } else {
                        i33 = constrainWidth-K40F9xA;
                    }
                    if (verticalArrangement) {
                        i27 = constrainHeight-K40F9xA;
                    } else {
                        i27 = constrainHeight-K40F9xA;
                    }
                    int i87 = currentMainAxisOffset;
                    int i92 = i67;
                    List itemsOffsets = LazyGridMeasureKt.calculateItemsOffsets((List)arrayDeque, $i$f$calculateExtraItems, i13, i33, i27, i87, i92, i3, verticalArrangement, horizontalArrangement, reverseLayout, density, itemAnimator);
                    int extraItemsAfter = i33;
                    int i54 = i92;
                    int i103 = i87;
                    int i100 = currentFirstLineScrollOffset4;
                    int i80 = i27;
                    slotsPerLine.onMeasured((int)f, extraItemsAfter, i80, itemsOffsets, measuredItemProvider.getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItemProvider, verticalArrangement, false, pinnedItems, false, i100, i103, placementScopeInvalidator, prefetchInfoRetriever);
                    i7 = extraItemsAfter;
                    i22 = i80;
                    int i68 = i103;
                    long minSizeToFitDisappearingItems-YbymL2g2 = slotsPerLine.getMinSizeToFitDisappearingItems-YbymL2g();
                    firstItemIndex3 = index$iv$iv;
                    if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g2, i31)) {
                        equals-impl0 = verticalArrangement ? i22 : i7;
                        index$iv$iv = ConstraintsKt.constrainWidth-K40F9xA(index$iv3, obj3);
                        i7 = verticalArrangement ? i29 : index$iv$iv;
                        if (i7 != equals-impl0) {
                            i22 = itemsOffsets;
                            companion = 0;
                            firstLine = size;
                            size = i22.size();
                            index$iv3 = keyIndexMap;
                            while (index$iv3 < size) {
                                z = false;
                                (LazyGridMeasuredItem)i22.get(index$iv3).updateMainAxisLayoutSize(i7);
                                index$iv3++;
                                size = keyIndexMap;
                            }
                        } else {
                            firstLine = size;
                        }
                        i16 = index$iv$iv;
                    } else {
                        firstLine = size;
                        i16 = i7;
                        i29 = i22;
                    }
                    int i47 = i11;
                    if (i47 == itemsCount + -1) {
                        if (i68 > i54) {
                            index$iv$iv3 = 1;
                        } else {
                            index$iv$iv3 = 0;
                        }
                    } else {
                    }
                    LazyGridMeasureKt.measureLazyGrid.6 anon = new LazyGridMeasureKt.measureLazyGrid.6(itemsOffsets, graphicsContext);
                    invoke = obj4.invoke(Integer.valueOf(i16), Integer.valueOf(i29), anon);
                    if ($i$f$calculateExtraItems.isEmpty() && i13.isEmpty()) {
                        if (i113.isEmpty()) {
                            obj = invoke;
                            i24 = index$iv$iv3;
                            $this$fastFilter$iv = itemsOffsets;
                        } else {
                            List list = itemsOffsets;
                            i31 = 0;
                            obj = invoke;
                            ArrayList arrayList = new ArrayList(list.size());
                            i = 0;
                            i36 = arrayList;
                            size2 = list.size();
                            i24 = index$iv$iv3;
                            index$iv$iv3 = i34;
                            while (index$iv$iv3 < size2) {
                                coroutineScope2 = i34;
                                context = null;
                                i25 = 0;
                                int index4 = (LazyGridMeasuredItem)coroutineScope2.getIndex();
                                int $this$fastForEach$iv$iv2 = firstItemIndex3;
                                if ($this$fastForEach$iv$iv2 <= index4 && index4 <= i47) {
                                } else {
                                }
                                i28 = 0;
                                if (i28 != 0) {
                                } else {
                                }
                                firstItemIndex3 = $this$fastForEach$iv$iv2;
                                firstItemIndex = coroutineScope2;
                                index$iv$iv3++;
                                size2 = i32;
                                i18 = $this$fastForEach$iv$iv;
                                firstItemIndex3 = $this$fastForEach$iv$iv2;
                                (Collection)i36.add(coroutineScope2);
                                if (index4 <= i47) {
                                } else {
                                }
                                i28 = 1;
                            }
                            $this$fastForEach$iv$iv = i18;
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
                    LazyGridMeasureResult lazyGridMeasureResult = new LazyGridMeasureResult(firstLine, i100, i24, f, obj, remeasureNeeded, placementScopeInvalidator, itemAnimator, pinnedItems, layout, $this$fastFilter$iv, -i18, mainAxisAvailableSize + afterContentPadding, itemsCount, density, horizontal, afterContentPadding, spaceBetweenLines);
                    return lazyGridMeasureResult;
                }
                int i44 = 0;
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("negative initial offset".toString());
                throw illegalArgumentException;
            }
            int i45 = 0;
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("negative afterContentPadding".toString());
            throw illegalArgumentException2;
        }
        int i46 = 0;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("negative beforeContentPadding".toString());
        throw illegalArgumentException3;
    }
}
