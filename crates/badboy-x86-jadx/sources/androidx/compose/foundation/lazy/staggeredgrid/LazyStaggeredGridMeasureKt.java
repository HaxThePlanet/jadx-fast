package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u009e\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a\u0017\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007H\u0082\u0008\u001a5\u0010\t\u001a\u0002H\n\"\u0004\u0008\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\u0008\u000fH\u0083\u0008¢\u0006\u0002\u0010\u0010\u001aR\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u0001H\u0083\u0008\u001a;\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00130\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\"\u001a\u001d\u0010#\u001a\u00020\u0008*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00130\u001e0\u001dH\u0002¢\u0006\u0002\u0010$\u001a\u001c\u0010%\u001a\u00020\u0005*\u00020\u00142\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0003H\u0002\u001a7\u0010(\u001a\u00020\u0005\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u00122\u0008\u0008\u0002\u0010)\u001a\u00020\u00012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\u0008\u001a\u001c\u0010+\u001a\u00020\u0003*\u00020\u00142\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a+\u0010.\u001a\u00020\u0005*\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\u0008ø\u0001\u0000¢\u0006\u0004\u00080\u00101\u001a\u000c\u00102\u001a\u00020\u0003*\u00020 H\u0002\u001a2\u00103\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\n*\u0008\u0012\u0004\u0012\u0002H\n0\u001d2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00030\u000eH\u0082\u0008¢\u0006\u0002\u00104\u001a\u0016\u00105\u001a\u00020\u0003*\u00020 2\u0008\u0008\u0002\u00106\u001a\u00020\u0003H\u0000\u001a\u001e\u00107\u001a\u00020\u0003*\u00020 2\u0006\u00108\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\u00089\u0010:\u001a,\u0010;\u001a\u00020<*\u00020\u00142\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u0001H\u0003\u001a\u008c\u0001\u0010A\u001a\u00020<*\u00020\u000c2\u0006\u0010B\u001a\u00020C2\u000c\u0010D\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u00032\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0001ø\u0001\u0000¢\u0006\u0004\u0008W\u0010X\u001a\u0014\u0010Y\u001a\u00020\u0005*\u00020 2\u0006\u0010Z\u001a\u00020\u0003H\u0002\u001a!\u0010[\u001a\u00020 *\u00020 2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0082\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\\", d2 = {"DebugLoggingEnabled", "", "Unset", "", "debugLog", "", "message", "Lkotlin/Function0;", "", "withDebugLogging", "T", "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "calculateExtraItems", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "calculateVisibleItems", "measuredItems", "", "Lkotlin/collections/ArrayDeque;", "itemScrollOffsets", "", "mainAxisLayoutSize", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[II)Ljava/util/List;", "debugRender", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "ensureIndicesInRange", "indices", "itemCount", "fastForEach", "reverse", "action", "findPreviousItemIndex", "item", "lane", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "indexOfMaxValue", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "minBound", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "measureStaggeredGrid", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-XtK8cYQ", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridMeasureKt {

    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;
    private static final List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> calculateExtraItems(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext $this$calculateExtraItems, Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem, Unit> position, Function1<? super Integer, Boolean> filter, boolean beforeVisibleBounds) {
        long spanRange-lOCCd4c;
        List emptyList;
        int $i$f$calculateExtraItems2;
        int result;
        int andMeasure-jy6DScQ;
        List index$iv$iv;
        int size;
        int i2;
        int intValue;
        Object obj;
        int andMeasure-jy6DScQ2;
        Object itemProvider;
        int i;
        Object result2;
        int $i$f$calculateExtraItems;
        int i3;
        final Object obj2 = $this$calculateExtraItems;
        final Object obj3 = position;
        $i$f$calculateExtraItems2 = 0;
        result = 0;
        final List pinnedItems = obj2.getPinnedItems();
        final int i4 = 0;
        andMeasure-jy6DScQ = 0;
        if (beforeVisibleBounds) {
            index$iv$iv = pinnedItems;
            size = 0;
            if (size2-- >= 0) {
            } else {
                $i$f$calculateExtraItems = $i$f$calculateExtraItems2;
            }
        } else {
            $i$f$calculateExtraItems = $i$f$calculateExtraItems2;
            andMeasure-jy6DScQ = 0;
            index$iv$iv = 0;
            while (index$iv$iv < pinnedItems.size()) {
                intValue = (Number)$i$f$calculateExtraItems2.get(index$iv$iv).intValue();
                obj = 0;
                if ((Boolean)spanRange-lOCCd4c.invoke(Integer.valueOf(intValue)).booleanValue()) {
                } else {
                }
                result2 = $i$f$calculateExtraItems2;
                i = 0;
                index$iv$iv++;
                spanRange-lOCCd4c = filter;
                $i$f$calculateExtraItems2 = result2;
                result2 = $i$f$calculateExtraItems2;
                if (result == null) {
                }
                andMeasure-jy6DScQ2 = obj2.getMeasuredItemProvider().getAndMeasure-jy6DScQ(intValue, obj2.getSpanRange-lOCCd4c(obj2.getItemProvider(), intValue, 0));
                obj3.invoke(andMeasure-jy6DScQ2);
                result.add(andMeasure-jy6DScQ2);
                itemProvider = new ArrayList();
                result = itemProvider;
            }
            result2 = $i$f$calculateExtraItems2;
        }
        if (result == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            emptyList = result;
        }
        return emptyList;
    }

    private static final List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> calculateVisibleItems(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext $this$calculateVisibleItems, ArrayDeque<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem>[] measuredItems, int[] itemScrollOffsets, int mainAxisLayoutSize) {
        Object[] objArr;
        long[] lArr;
        int i$iv;
        int first;
        int maxInRange-jy6DScQ;
        int result$iv;
        int i5;
        int min$iv;
        int i6;
        int i$iv2;
        int length;
        int i3;
        boolean empty;
        int index;
        int i7;
        long l3;
        long l;
        int i4;
        long l2;
        int i2;
        int i;
        objArr = measuredItems;
        lArr = itemScrollOffsets;
        first = 0;
        maxInRange-jy6DScQ = 0;
        while (first < objArr.length) {
            min$iv = 0;
            maxInRange-jy6DScQ += result$iv;
            first++;
        }
        ArrayList arrayList = new ArrayList(maxInRange-jy6DScQ);
        while (/* condition */) {
            while (i6 < length3) {
                i3 = 0;
                i6++;
            }
            i5 = 0;
            if (i5 != 0) {
            }
            int[] iArr = measuredItems;
            int i12 = 0;
            result$iv = -1;
            min$iv = Integer.MAX_VALUE;
            i$iv2 = 0;
            while (i$iv2 < iArr.length) {
                empty = false;
                Object firstOrNull = iArr[i$iv2].firstOrNull();
                if ((LazyStaggeredGridMeasuredItem)firstOrNull != null) {
                } else {
                }
                index = Integer.MAX_VALUE;
                if (min$iv > index) {
                }
                i$iv2++;
                min$iv = index;
                result$iv = i$iv2;
                index = (LazyStaggeredGridMeasuredItem)firstOrNull.getIndex();
            }
            first = objArr[result$iv].removeFirst();
            if ((LazyStaggeredGridMeasuredItem)first.getLane() != result$iv) {
            } else {
            }
            min$iv = SpanRange.constructor-impl(first.getLane(), first.getSpan());
            maxInRange-jy6DScQ = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(lArr, min$iv);
            first.position(maxInRange-jy6DScQ, $this$calculateVisibleItems.getResolvedSlots().getPositions()[result$iv], mainAxisLayoutSize);
            (Collection)arrayList.add(first);
            empty = min$iv;
            i7 = 0;
            int i14 = 0;
            int i15 = 0;
            i$iv = (int)i10;
            first = 0;
            i4 = 0;
            while (i$iv < (int)i8) {
                first = 0;
                itemScrollOffsets[i$iv] = mainAxisSizeWithSpacings += maxInRange-jy6DScQ;
                i$iv++;
            }
            objArr = measuredItems;
            lArr = itemScrollOffsets;
            Object[] objArr2 = measuredItems;
            int i11 = 0;
            i6 = 0;
            first = 0;
            itemScrollOffsets[i$iv] = mainAxisSizeWithSpacings += maxInRange-jy6DScQ;
            i$iv++;
            empty = false;
            firstOrNull = iArr[i$iv2].firstOrNull();
            if ((LazyStaggeredGridMeasuredItem)firstOrNull != null) {
            } else {
            }
            index = Integer.MAX_VALUE;
            if (min$iv > index) {
            }
            i$iv2++;
            min$iv = index;
            result$iv = i$iv2;
            index = (LazyStaggeredGridMeasuredItem)firstOrNull.getIndex();
            i3 = 0;
            if (!(Collection)objArr2[i6].isEmpty()) {
            } else {
            }
            i6++;
            i5 = 1;
        }
        int i13 = mainAxisLayoutSize;
        return (List)arrayList;
    }

    private static final void debugLog(Function0<String> message) {
        final int i = 0;
    }

    private static final String debugRender(ArrayDeque<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem>[] $this$debugRender) {
        return "";
    }

    private static final void ensureIndicesInRange(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext $this$ensureIndicesInRange, int[] indices, int itemCount) {
        int i3;
        int i;
        int previousItemIndex;
        int assignedToLane;
        int i2;
        if (length-- >= 0) {
        }
    }

    private static final <T> void fastForEach(List<? extends T> $this$fastForEach, boolean reverse, Function1<? super T, Unit> action) {
        int i;
        int index$iv;
        int size;
        Object obj;
        final int i2 = 0;
        final Object obj2 = $this$fastForEach;
        if (reverse) {
            i = 0;
            if (size2-- >= 0) {
            }
        } else {
            i = 0;
            index$iv = 0;
            while (index$iv < obj2.size()) {
                action.invoke(obj2.get(index$iv));
                index$iv++;
            }
        }
    }

    static void fastForEach$default(List $this$fastForEach_u24default, boolean reverse, Function1 action, int i4, Object object5) {
        int i;
        int index$iv;
        int size;
        Object obj;
        int obj5;
        if (i4 &= 1 != 0) {
            obj5 = 0;
        }
        int obj7 = 0;
        final Object obj8 = $this$fastForEach_u24default;
        if (obj5 != null) {
            i = 0;
            if (size2-- >= 0) {
            }
        } else {
            i = 0;
            index$iv = 0;
            while (index$iv < obj8.size()) {
                action.invoke(obj8.get(index$iv));
                index$iv++;
            }
        }
    }

    private static final int findPreviousItemIndex(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext $this$findPreviousItemIndex, int item, int lane) {
        return $this$findPreviousItemIndex.getLaneInfo().findPreviousItemIndex(item, lane);
    }

    private static final void forEach-nIS5qE8(long $this$forEach_u2dnIS5qE8, Function1<? super Integer, Unit> block) {
        int valueOf;
        int value$iv$iv;
        final int i = 0;
        int i2 = 0;
        final int i5 = 0;
        value$iv$iv = (int)i7;
        valueOf = 0;
        int i8 = 0;
        while (value$iv$iv < (int)i9) {
            obj10.invoke(Integer.valueOf(value$iv$iv));
            value$iv$iv++;
        }
    }

    private static final int indexOfMaxValue(int[] $this$indexOfMaxValue) {
        int result;
        int max;
        int i;
        int i2;
        result = -1;
        max = Integer.MIN_VALUE;
        i = 0;
        while (i < $this$indexOfMaxValue.length) {
            if (max < $this$indexOfMaxValue[i]) {
            }
            i++;
            max = $this$indexOfMaxValue[i];
            result = i;
        }
        return result;
    }

    private static final <T> int indexOfMinBy(T[] $this$indexOfMinBy, Function1<? super T, Integer> block) {
        int result;
        int min;
        int i;
        int intValue;
        final int i2 = 0;
        result = -1;
        min = Integer.MAX_VALUE;
        i = 0;
        while (i < $this$indexOfMinBy.length) {
            intValue = (Number)block.invoke($this$indexOfMinBy[i]).intValue();
            if (min > intValue) {
            }
            i++;
            min = intValue;
            result = i;
        }
        return result;
    }

    public static final int indexOfMinValue(int[] $this$indexOfMinValue, int minBound) {
        int result;
        int min;
        int i;
        int i4;
        int i2;
        int i3;
        result = -1;
        min = Integer.MAX_VALUE;
        i = 0;
        while (i < $this$indexOfMinValue.length) {
            i2 = $this$indexOfMinValue[i];
            i3 = 0;
            if (minBound + 1 <= i2 && i2 < min) {
            }
            if (i3 != 0) {
            }
            i++;
            min = $this$indexOfMinValue[i];
            result = i;
            if (i2 < min) {
            }
            i3 = 1;
        }
        return result;
    }

    public static int indexOfMinValue$default(int[] iArr, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = Integer.MIN_VALUE;
        }
        return LazyStaggeredGridMeasureKt.indexOfMinValue(iArr, obj1);
    }

    private static final int maxInRange-jy6DScQ(int[] $this$maxInRange_u2djy6DScQ, long indexRange) {
        int max;
        int i2;
        int value$iv$iv$iv;
        int i;
        int i3;
        int i4 = 0;
        max = Integer.MIN_VALUE;
        final int i5 = indexRange;
        final int i6 = 0;
        int i7 = 0;
        i = 0;
        value$iv$iv$iv = (int)i11;
        i2 = 0;
        i3 = 0;
        while (value$iv$iv$iv < (int)i12) {
            i = 0;
            max = Math.max(max, $this$maxInRange_u2djy6DScQ[value$iv$iv$iv]);
            value$iv$iv$iv++;
        }
        return max;
    }

    private static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult measure(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext $this$measure, int initialScrollDelta, int[] initialItemIndices, int[] initialItemOffsets, boolean canRestartMeasure) {
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext measuredItem2;
        int i25;
        int i17;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider itemProvider;
        int previousItemIndex2;
        int initialItemsMeasured2;
        int i28;
        int i32;
        long i15;
        int maxInRange-jy6DScQ;
        int i72;
        int initialItemsMeasured;
        int[] $i$f$debugLog4;
        int $this$all$iv3;
        float scrollToBeConsumed$foundation_release;
        float f;
        int[] iArr;
        int $this$all$iv6;
        int[] iArr5;
        int i26;
        int i11;
        int sign2;
        int indexOfMaxValue;
        int laneIndex2;
        int i18;
        int i24;
        int i8;
        int scrollDelta2;
        boolean constraints-msEJaDk;
        int[] i$iv4;
        int scrollDelta4;
        int i$iv2;
        int $i$f$debugLog3;
        int $this$all$iv;
        int i62;
        int $i$f$debugLog;
        int scrollDelta;
        int index$iv3;
        int emptyList;
        int index$iv4;
        int i19;
        int i42;
        int measuredItem;
        int i49;
        int i33;
        int gaps2;
        int i$iv5;
        int[] iArr7;
        int initialLaneToMeasure5;
        int i70;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo laneInfo;
        int initialLaneToMeasure2;
        int sign;
        int itemScrollOffsets;
        int index$iv$iv$iv2;
        int initialLaneToMeasure3;
        int initialLaneToMeasure;
        int i41;
        int layoutWidth;
        int[] offset2;
        int i3;
        int i12;
        int indexOfMinValue$default2;
        int gapDetected3;
        int laneIndex;
        int constrainWidth-K40F9xA;
        int constrainHeight-K40F9xA;
        int i57;
        int extraItemOffset;
        int i27;
        int i21;
        int $this$all$iv4;
        int it;
        int i79;
        int $this$all$iv2;
        int it3;
        int beforeVisibleBounds$iv;
        int i66;
        int length3;
        int i76;
        int gaps;
        int gapDetected2;
        int layoutHeight;
        String length2;
        int i50;
        int i71;
        int i$iv;
        int i$iv3;
        int mainAxisSpacing;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem $this$calculateExtraItems$iv;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext mainAxisSizeWithSpacings;
        boolean equals-impl0;
        int i10;
        int i68;
        int iArr2;
        ArrayList height-impl;
        int[] laneToCheckForGaps;
        int $i$f$calculateExtraItems;
        int i30;
        int i34;
        int remeasureNeeded3;
        int remeasureNeeded;
        int index;
        int previousItemIndex;
        int length;
        int visible;
        int i61;
        int $i$f$debugLog2;
        int[] offset;
        int i78;
        int[] beforeVisibleBounds$iv2;
        int result$iv;
        int i58;
        int measure$lambda$38$hasSpaceBeforeFirst;
        int spanRange;
        int itemCount2;
        ArrayDeque spanRange-lOCCd4c;
        int i;
        int i7;
        int length4;
        int i44;
        int i43;
        long l2;
        int spanRange-lOCCd4c2;
        long index$iv2;
        int i5;
        int i65;
        int i36;
        int it2;
        int i74;
        int size;
        int measure$lambda$38$misalignedStart;
        int i16;
        int index2;
        long l10;
        int i59;
        int i69;
        int i4;
        int result$iv2;
        int scrollDelta5;
        int scrollDelta6;
        long l8;
        List list;
        int i56;
        int $this$all$iv7;
        int i45;
        int i37;
        List $this$fastForEachReversed$iv$iv$iv;
        int index$iv$iv$iv;
        int i40;
        int scrollDelta3;
        int initialItemsMeasured4;
        int i51;
        long l11;
        int i67;
        int indexOfMinValue$default;
        int scrollDelta7;
        int i29;
        int i6;
        int gapDetected;
        int l;
        float f2;
        float consumedScroll;
        long l3;
        long l5;
        int maxOffsetLane;
        long l7;
        int i52;
        long l4;
        int $this$all$iv5;
        int i73;
        int[] i31;
        int i60;
        int remeasureNeeded2;
        int i35;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem index$iv5;
        long l9;
        int i75;
        long l13;
        int laneIndex3;
        long l14;
        long l15;
        int itemCount;
        long l6;
        int index$iv;
        int i46;
        int i38;
        int i22;
        int i47;
        int i53;
        int i77;
        long l12;
        int i9;
        int i23;
        int[] iArr4;
        int[] iArr3;
        String str;
        String str2;
        int i14;
        int i39;
        int[] iArr6;
        int initialItemsMeasured3;
        int i55;
        int initialLaneToMeasure4;
        int i2;
        int i48;
        int i63;
        int i20;
        int i54;
        int i64;
        int i13;
        int contentPadding;
        measuredItem2 = $this$measure;
        i$iv4 = initialItemIndices;
        iArr7 = initialItemOffsets;
        final int i245 = 0;
        final LazyLayoutMeasureScope lazyLayoutMeasureScope3 = measureScope;
        final int i246 = 0;
        itemCount2 = measuredItem2.getItemProvider().getItemCount();
        if (itemCount2 > 0) {
            if (measuredItem2.getLaneCount() == 0) {
                itemCount = itemCount2;
                layoutWidth = Constraints.getMinWidth-impl($this$measure.getConstraints-msEJaDk());
                layoutHeight = Constraints.getMinHeight-impl($this$measure.getConstraints-msEJaDk());
                ArrayList arrayList = new ArrayList();
                CoroutineScope coroutineScope = $this$measure.getCoroutineScope();
                int i136 = 0;
                $this$measure.getState().getItemAnimator$foundation_release().onMeasured(i136, layoutWidth, layoutHeight, (List)arrayList, $this$measure.getMeasuredItemProvider().getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)$this$measure.getMeasuredItemProvider(), $this$measure.isVertical(), false, $this$measure.getLaneCount(), false, 0, 0, coroutineScope, $this$measure.getGraphicsContext());
                long minSizeToFitDisappearingItems-YbymL2g = $this$measure.getState().getItemAnimator$foundation_release().getMinSizeToFitDisappearingItems-YbymL2g();
                if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g, itemProvider)) {
                    i34 = layoutWidth;
                    i61 = layoutHeight;
                } else {
                    i34 = layoutWidth;
                    i61 = layoutHeight;
                }
                int i247 = i34;
                int i253 = i61;
                long l23 = l17;
                LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult = new LazyStaggeredGridMeasureResult(initialItemIndices, initialItemOffsets, 0, MeasureScope.layout$default((MeasureScope)lazyLayoutMeasureScope3, i34, i61, 0, (Function1)LazyStaggeredGridMeasureKt.measure.1.1.INSTANCE, 4, 0), 0, $this$measure.isVertical(), 0, $this$measure.getResolvedSlots(), $this$measure.getItemProvider().getSpanProvider(), (Density)lazyLayoutMeasureScope3, itemCount, CollectionsKt.emptyList(), IntSizeKt.IntSize(Constraints.getMinWidth-impl($this$measure.getConstraints-msEJaDk()), Constraints.getMinHeight-impl($this$measure.getConstraints-msEJaDk())), coroutineScope, -beforeContentPadding3, mainAxisAvailableSize4 + afterContentPadding, $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), $this$measure.getMainAxisSpacing(), $this$measure.getCoroutineScope(), 0);
                return lazyStaggeredGridMeasureResult;
            } else {
                offset2 = Arrays.copyOf(i$iv4, i$iv4.length);
                length2 = "copyOf(this, size)";
                Intrinsics.checkNotNullExpressionValue(offset2, length2);
                laneToCheckForGaps = Arrays.copyOf(iArr7, iArr7.length);
                Intrinsics.checkNotNullExpressionValue(laneToCheckForGaps, length2);
                remeasureNeeded3 = 0;
                LazyStaggeredGridMeasureKt.ensureIndicesInRange(measuredItem2, offset2, itemCount2);
                LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, -previousItemIndex2);
                int laneCount2 = measuredItem2.getLaneCount();
                ArrayDeque[] arr = new ArrayDeque[laneCount2];
                measure$lambda$38$hasSpaceBeforeFirst = 0;
                while (measure$lambda$38$hasSpaceBeforeFirst < laneCount2) {
                    spanRange-lOCCd4c = new ArrayDeque(16);
                    arr[measure$lambda$38$hasSpaceBeforeFirst] = spanRange-lOCCd4c;
                    measure$lambda$38$hasSpaceBeforeFirst++;
                }
                LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, -beforeContentPadding7);
                int i199 = 0;
                $i$f$debugLog2 = -1;
                i4 = 32;
                while (LazyStaggeredGridMeasureKt.measure$lambda$38$hasSpaceBeforeFirst(offset2, laneToCheckForGaps, measuredItem2)) {
                    measure$lambda$38$hasSpaceBeforeFirst = LazyStaggeredGridMeasureKt.indexOfMaxValue(offset2);
                    l8 = 4294967295L;
                    length4 = laneToCheckForGaps.length;
                    i58 = l10;
                    i40 = 0;
                    while (i58 < length4) {
                        if (offset2[i58] != offset2[measure$lambda$38$hasSpaceBeforeFirst] && laneToCheckForGaps[i58] < laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst]) {
                        }
                        i58++;
                        previousItemIndex2 = scrollDelta3;
                        if (laneToCheckForGaps[i58] < laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst]) {
                        }
                        laneToCheckForGaps[i58] = laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst];
                    }
                    previousItemIndex2 = LazyStaggeredGridMeasureKt.findPreviousItemIndex(measuredItem2, offset2[measure$lambda$38$hasSpaceBeforeFirst], measure$lambda$38$hasSpaceBeforeFirst);
                    if (previousItemIndex2 < 0) {
                        break;
                    } else {
                    }
                    spanRange-lOCCd4c = measuredItem2.getSpanRange-lOCCd4c(measuredItem2.getItemProvider(), previousItemIndex2, measure$lambda$38$hasSpaceBeforeFirst);
                    long l21 = spanRange-lOCCd4c;
                    int i265 = 0;
                    l4 = l21;
                    i35 = context7;
                    int i277 = 0;
                    int i279 = 0;
                    int i281 = 0;
                    int i288 = 0;
                    index$iv = 0;
                    i77 = i153;
                    if (i47 - i127 != 1) {
                    } else {
                    }
                    i49 = i40;
                    if (i49 != 0) {
                    } else {
                    }
                    scrollDelta5 = i134;
                    i35 = i41;
                    i33 = (int)i135;
                    measuredItem2.getLaneInfo().setLane(previousItemIndex2, i33);
                    long l22 = spanRange-lOCCd4c;
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context3 = $this$measure;
                    int i235 = 0;
                    int i262 = 0;
                    int i266 = 0;
                    int i273 = 0;
                    $this$all$iv5 = 0;
                    laneIndex3 = i154;
                    if (i60 - i131 != 1) {
                    } else {
                    }
                    i69 = i40;
                    if (i69 != 0) {
                    } else {
                    }
                    gaps2 = 0;
                    l11 = spanRange-lOCCd4c;
                    int i156 = 0;
                    int i209 = 0;
                    int i233 = 0;
                    scrollDelta5 = gaps2;
                    i58 = 0;
                    gapDetected = i133;
                    i$iv5 = i37;
                    while (i$iv5 < (int)i$iv7) {
                        i58 = i$iv5;
                        l10 = 0L;
                        offset2[i58] = previousItemIndex2;
                        if (scrollDelta5 == 0) {
                        } else {
                        }
                        i4 = scrollDelta5[i58];
                        i236 += i4;
                        laneToCheckForGaps[i58] = l8;
                        if (mainAxisAvailableSize7 += l8 <= 0) {
                        }
                        i$iv5++;
                        remeasureNeeded3 = 1;
                        i4 = i40;
                    }
                    i$iv4 = initialItemIndices;
                    iArr7 = initialItemOffsets;
                    previousItemIndex2 = scrollDelta3;
                    i4 = 32;
                    i58 = i$iv5;
                    l10 = 0L;
                    offset2[i58] = maxOffsetLane;
                    if (scrollDelta5 == 0) {
                    } else {
                    }
                    i4 = scrollDelta5[i58];
                    i236 += i4;
                    laneToCheckForGaps[i58] = l8;
                    if (mainAxisAvailableSize7 += l8 <= 0) {
                    }
                    i$iv5++;
                    remeasureNeeded3 = 1;
                    i4 = i40;
                    gaps2 = measuredItem2.getLaneInfo().getGaps(previousItemIndex2);
                    i69 = 1;
                    i33 = -2;
                    i49 = 1;
                    if (offset2[i58] != offset2[measure$lambda$38$hasSpaceBeforeFirst] && laneToCheckForGaps[i58] < laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst]) {
                    }
                    i58++;
                    previousItemIndex2 = scrollDelta3;
                    if (laneToCheckForGaps[i58] < laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst]) {
                    }
                    laneToCheckForGaps[i58] = laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst];
                }
                scrollDelta3 = previousItemIndex2;
                l8 = 4294967295L;
                i40 = 0;
                int scrollDelta8 = 0;
                int i84 = -beforeContentPadding;
                if (laneToCheckForGaps[i40] < i84) {
                    i123 += scrollDelta3;
                    LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, i84 - i151);
                    iArr7 = 0;
                } else {
                    scrollDelta4 = scrollDelta3;
                }
                LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, measuredItem2.getBeforeContentPadding());
                int i137 = -1;
                if ($i$f$debugLog2 == i137) {
                    spanRange = ArraysKt.indexOf(offset2, i40);
                } else {
                    spanRange = $i$f$debugLog2;
                }
                $i$f$debugLog2 = spanRange;
                if (spanRange != i137 && LazyStaggeredGridMeasureKt.measure$lambda$38$misalignedStart(offset2, measuredItem2, laneToCheckForGaps, $i$f$debugLog2) && canRestartMeasure) {
                    $i$f$debugLog2 = spanRange;
                    if (LazyStaggeredGridMeasureKt.measure$lambda$38$misalignedStart(offset2, measuredItem2, laneToCheckForGaps, $i$f$debugLog2)) {
                        if (canRestartMeasure) {
                            measuredItem2.getLaneInfo().reset();
                            int length10 = offset2.length;
                            int[] iArr11 = new int[length10];
                            i = 0;
                            while (i < length10) {
                                iArr11[i] = i137;
                                i++;
                            }
                            int length5 = laneToCheckForGaps.length;
                            int[] iArr10 = new int[length5];
                            i7 = 0;
                            while (i7 < length5) {
                                iArr10[i7] = laneToCheckForGaps[$i$f$debugLog2];
                                i7++;
                            }
                            return LazyStaggeredGridMeasureKt.measure(measuredItem2, scrollDelta4, iArr11, iArr10, false);
                        }
                    }
                }
                offset = Arrays.copyOf(offset2, offset2.length);
                Intrinsics.checkNotNullExpressionValue(offset, length2);
                int length14 = laneToCheckForGaps.length;
                int[] iArr12 = new int[length14];
                i44 = 0;
                while (i44 < length14) {
                    iArr12[i44] = -i229;
                    i44++;
                }
                mainAxisSpacing3 += i84;
                it2 = 0;
                i43 = RangesKt.coerceAtLeast(mainAxisAvailableSize6 += afterContentPadding4, it2);
                int i242 = 0;
                remeasureNeeded2 = remeasureNeeded3;
                initialItemsMeasured2 = initialItemsMeasured4;
                initialLaneToMeasure5 = indexOfMinValue$default;
                while (initialLaneToMeasure5 != -1) {
                    if (initialItemsMeasured2 < measuredItem2.getLaneCount()) {
                    }
                    remeasureNeeded3 = offset[initialLaneToMeasure5];
                    initialLaneToMeasure5 = LazyStaggeredGridMeasureKt.indexOfMinValue(offset, remeasureNeeded3);
                    initialItemsMeasured2++;
                    if (remeasureNeeded3 >= 0) {
                    } else {
                    }
                    initialItemsMeasured4 = initialItemsMeasured2;
                    indexOfMinValue$default = scrollDelta4;
                    gapDetected = initialLaneToMeasure5;
                    iArr4 = offset2;
                    str = length2;
                    iArr6 = offset;
                    indexOfMinValue$default = scrollDelta4;
                    long spanRange-lOCCd4c3 = measuredItem2.getSpanRange-lOCCd4c(measuredItem2.getItemProvider(), remeasureNeeded3, initialLaneToMeasure5);
                    gapDetected = initialLaneToMeasure5;
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem andMeasure-jy6DScQ4 = measuredItem2.getMeasuredItemProvider().getAndMeasure-jy6DScQ(remeasureNeeded3, spanRange-lOCCd4c3);
                    iArr6 = offset;
                    long l26 = spanRange-lOCCd4c3;
                    int i274 = 0;
                    l6 = context8;
                    i46 = 0;
                    i47 = 0;
                    int i289 = 0;
                    l12 = l13;
                    int i295 = 0;
                    iArr4 = offset2;
                    str = length2;
                    int i290 = 0;
                    i14 = i183;
                    if (i23 - i160 != 1) {
                    } else {
                    }
                    i3 = 0;
                    if (i3 != 0) {
                    } else {
                    }
                    l6 = i162;
                    i46 = i50;
                    i12 = (int)i163;
                    measuredItem2.getLaneInfo().setLane(remeasureNeeded3, i12);
                    int maxInRange-jy6DScQ3 = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(iArr12, spanRange-lOCCd4c3);
                    i71 = 0;
                    int i200 = 0;
                    l9 = l5;
                    int i270 = 0;
                    laneIndex3 = spanRange-lOCCd4c3;
                    i78 = 0;
                    int i284 = i106;
                    i28 = (int)i$iv6;
                    i$iv2 = i73;
                    while (i$iv2 < i28) {
                        i78 = i$iv2;
                        i73 = 0;
                        iArr12[i78] = mainAxisSizeWithSpacings6 += maxInRange-jy6DScQ3;
                        iArr6[i78] = remeasureNeeded3;
                        arr[i78].addLast(andMeasure-jy6DScQ4);
                        i$iv2++;
                        i28 = l9;
                    }
                    i71 = i90;
                    i78 = i$iv2;
                    if (maxInRange-jy6DScQ3 < i208 && iArr12[(int)i91] <= i208) {
                    }
                    long l16 = laneIndex3;
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context2 = $this$measure;
                    int i201 = 0;
                    l3 = 0;
                    int i267 = 0;
                    $this$all$iv5 = 0;
                    index$iv5 = 0;
                    i77 = i107;
                    if (i75 - i88 != 1) {
                    } else {
                    }
                    i32 = 0;
                    if (i32 != 0) {
                    } else {
                    }
                    initialItemsMeasured2 = initialItemsMeasured4;
                    scrollDelta4 = indexOfMinValue$default;
                    initialLaneToMeasure5 = gapDetected;
                    offset2 = iArr4;
                    length2 = str;
                    offset = iArr6;
                    initialItemsMeasured2 = measuredItem2.getLaneCount();
                    scrollDelta4 = indexOfMinValue$default;
                    initialLaneToMeasure5 = gapDetected;
                    offset2 = iArr4;
                    length2 = str;
                    offset = iArr6;
                    i32 = 1;
                    i71 = i90;
                    i78 = i$iv2;
                    if (iArr12[(int)i91] <= i208) {
                    }
                    andMeasure-jy6DScQ4.setVisible(false);
                    remeasureNeeded2 = i28;
                    i78 = i$iv2;
                    i73 = 0;
                    iArr12[i78] = mainAxisSizeWithSpacings6 += maxInRange-jy6DScQ3;
                    iArr6[i78] = remeasureNeeded3;
                    arr[i78].addLast(andMeasure-jy6DScQ4);
                    i$iv2++;
                    i28 = l9;
                    i12 = -2;
                    i3 = 1;
                }
                scrollDelta7 = scrollDelta4;
                iArr3 = offset2;
                str2 = length2;
                int[] iArr18 = offset;
                int scrollDelta9 = 0;
                $i$f$debugLog3 = 0;
                while (/* condition */) {
                    while (index < length2) {
                        it2 = offset;
                        initialItemsMeasured4 = 0;
                        if (it2 >= i43) {
                        } else {
                        }
                        gapDetected = 1;
                        index++;
                        if (it2 <= 0) {
                        } else {
                        }
                        gapDetected = 0;
                    }
                    $this$all$iv = 0;
                    if ($this$all$iv != 0) {
                        break;
                    } else {
                    }
                    indexOfMinValue$default2 = LazyStaggeredGridMeasureKt.indexOfMinValue$default(iArr12, 0, 1, 0);
                    $this$all$iv = ArraysKt.maxOrThrow(iArr18);
                    length2 = $this$all$iv + 1;
                    if (length2 >= itemCount2) {
                        break;
                    } else {
                    }
                    initialItemsMeasured3 = initialItemsMeasured2;
                    i55 = initialLaneToMeasure5;
                    l6 = itemCount2;
                    l12 = i43;
                    remeasureNeeded = str2;
                    int initialItemsMeasured5 = 0;
                    l11 = -1;
                    int[] scrollDelta11 = laneToCheckForGaps;
                    int firstItemOffsets = spanRange;
                    long spanRange-lOCCd4c5 = measuredItem2.getSpanRange-lOCCd4c(measuredItem2.getItemProvider(), length2, indexOfMinValue$default2);
                    long l19 = spanRange-lOCCd4c5;
                    int i248 = 0;
                    l = l19;
                    l7 = context5;
                    int i271 = 0;
                    int i276 = 0;
                    int i278 = 0;
                    laneIndex3 = 0;
                    i77 = $this$all$iv;
                    int i110 = 0;
                    index$iv = 0;
                    if (i47 - i81 != 1) {
                    } else {
                    }
                    i25 = 0;
                    if (i25 != 0) {
                    } else {
                    }
                    l = 0;
                    l3 = i82;
                    i17 = (int)i83;
                    measuredItem2.getLaneInfo().setLane(length2, i17);
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem andMeasure-jy6DScQ = $this$measure.getMeasuredItemProvider().getAndMeasure-jy6DScQ(length2, spanRange-lOCCd4c5);
                    maxInRange-jy6DScQ = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(iArr12, spanRange-lOCCd4c5);
                    int i202 = 0;
                    int i238 = 0;
                    int i249 = 0;
                    long l24 = l20;
                    int i268 = 0;
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context9 = context;
                    $this$all$iv5 = initialLaneToMeasure6;
                    int i250 = 0;
                    i75 = i140;
                    int i141 = 1;
                    if (maxOffsetLane - i114 != i141) {
                    } else {
                    }
                    i62 = 0;
                    if (i62 != 0) {
                    } else {
                    }
                    $i$f$debugLog3 = 0;
                    int i203 = 0;
                    int i231 = 0;
                    gapDetected = l2;
                    int i239 = 0;
                    initialItemsMeasured4 = indexOfMinValue$default2;
                    i59 = 0;
                    index$iv5 = i164;
                    i70 = (int)i$iv8;
                    offset2 = i37;
                    while (offset2 < i70) {
                        i59 = offset2;
                        i37 = 0;
                        if ($i$f$debugLog3 != 0) {
                        }
                        iArr18[i59] = length2;
                        iArr12[i59] = mainAxisSizeWithSpacings5 += maxInRange-jy6DScQ;
                        arr[i59].addLast(andMeasure-jy6DScQ);
                        offset2++;
                        i70 = gapDetected;
                        $i$f$debugLog3[i59] = maxInRange-jy6DScQ - i257;
                    }
                    $this$measure.getLaneInfo().setGaps(length2, $i$f$debugLog3);
                    if (maxInRange-jy6DScQ < i208) {
                    } else {
                    }
                    offset = maxInRange-jy6DScQ;
                    l10 = $i$f$debugLog3;
                    it2 = 0;
                    measuredItem2 = $this$measure;
                    spanRange = firstItemOffsets;
                    str2 = remeasureNeeded;
                    laneToCheckForGaps = scrollDelta11;
                    scrollDelta7 = $this$all$iv5;
                    itemCount2 = l6;
                    i43 = l12;
                    initialItemsMeasured2 = initialItemsMeasured3;
                    initialLaneToMeasure5 = i55;
                    int[] $i$f$debugLog7 = iArr12;
                    indexOfMinValue$default2 = 0;
                    index = 0;
                    laneInfo = 0;
                    offset2 = null;
                    offset = maxInRange-jy6DScQ;
                    l10 = $i$f$debugLog3;
                    if (iArr12[(int)offset3] <= i208) {
                    } else {
                    }
                    it2 = 0;
                    andMeasure-jy6DScQ.setVisible(false);
                    measuredItem2 = $this$measure;
                    spanRange = firstItemOffsets;
                    str2 = remeasureNeeded;
                    laneToCheckForGaps = scrollDelta11;
                    scrollDelta7 = $this$all$iv5;
                    itemCount2 = l6;
                    i43 = l12;
                    initialItemsMeasured2 = initialItemsMeasured3;
                    initialLaneToMeasure5 = i55;
                    i59 = offset2;
                    i37 = 0;
                    if ($i$f$debugLog3 != 0) {
                    }
                    iArr18[i59] = length2;
                    iArr12[i59] = mainAxisSizeWithSpacings5 += maxInRange-jy6DScQ;
                    arr[i59].addLast(andMeasure-jy6DScQ);
                    offset2++;
                    i70 = gapDetected;
                    $i$f$debugLog3[i59] = maxInRange-jy6DScQ - i257;
                    if ($this$measure.getLaneInfo().getGaps(length2) == null) {
                    }
                    $i$f$debugLog3 = new int[$this$measure.getLaneCount()];
                    i62 = i141;
                    i17 = -2;
                    i25 = 1;
                    ArrayDeque[] objArr = arr;
                    indexOfMinValue$default2 = 0;
                    index = 0;
                    while (index < objArr.length) {
                        initialItemsMeasured4 = 0;
                        index++;
                    }
                    $this$all$iv = 1;
                    if ($this$all$iv != 0) {
                        break;
                    }
                    initialItemsMeasured4 = 0;
                    if (objArr[index].isEmpty() == 0) {
                    } else {
                    }
                    index++;
                    $this$all$iv = 0;
                    it2 = offset;
                    initialItemsMeasured4 = 0;
                    if (it2 >= i43) {
                    } else {
                    }
                    gapDetected = 1;
                    if (gapDetected != 0) {
                    } else {
                    }
                    index++;
                    $this$all$iv = 1;
                    if (it2 <= 0) {
                    } else {
                    }
                    gapDetected = 0;
                }
                int previousItemIndex4 = 0;
                $i$f$debugLog = 0;
                while ($i$f$debugLog < arr.length) {
                    length2 = arr[$i$f$debugLog];
                    offset = 1;
                    while (length2.size() > offset) {
                        if (!(LazyStaggeredGridMeasuredItem)length2.first().isVisible()) {
                        }
                        index = length2.removeFirst();
                        if ((LazyStaggeredGridMeasuredItem)index.getSpan() != offset) {
                        } else {
                        }
                        offset = 0;
                        if (offset == null) {
                        } else {
                        }
                        gapDetected = offset[$i$f$debugLog];
                        laneToCheckForGaps[$i$f$debugLog] = i228 -= initialItemsMeasured4;
                        offset = 1;
                        gapDetected = 0;
                        offset = measuredItem2.getLaneInfo().getGaps(index.getIndex());
                    }
                    Object firstOrNull = length2.firstOrNull();
                    if ((LazyStaggeredGridMeasuredItem)firstOrNull != null) {
                    } else {
                    }
                    index = -1;
                    iArr3[$i$f$debugLog] = index;
                    $i$f$debugLog++;
                    index = (LazyStaggeredGridMeasuredItem)firstOrNull.getIndex();
                    if (!(LazyStaggeredGridMeasuredItem)length2.first().isVisible()) {
                    }
                    index = length2.removeFirst();
                    if ((LazyStaggeredGridMeasuredItem)index.getSpan() != offset) {
                    } else {
                    }
                    offset = 0;
                    if (offset == null) {
                    } else {
                    }
                    gapDetected = offset[$i$f$debugLog];
                    laneToCheckForGaps[$i$f$debugLog] = i228 -= initialItemsMeasured4;
                    gapDetected = 0;
                    offset = measuredItem2.getLaneInfo().getGaps(index.getIndex());
                }
                int[] laneIndex5 = iArr18;
                int i165 = 0;
                previousItemIndex = 0;
                while (previousItemIndex < laneIndex5.length) {
                    initialItemsMeasured4 = 0;
                    if (laneIndex5[previousItemIndex] == itemCount2 + -1) {
                    } else {
                    }
                    i72 = 0;
                    previousItemIndex++;
                    initialItemsMeasured2 = initialItemsMeasured3;
                    i72 = 1;
                }
                initialItemsMeasured3 = initialItemsMeasured2;
                initialItemsMeasured = 0;
                if (initialItemsMeasured != 0) {
                    LazyStaggeredGridMeasureKt.offsetBy(iArr12, -mainAxisSpacing2);
                }
                int i97 = 0;
                int $i$f$debugLog5 = 0;
                int i116 = 0;
                i$iv = 0;
                while (i$iv < $i$f$debugLog4.length) {
                    it2 = 0;
                    if ($i$f$debugLog4[i$iv] < measuredItem2.getMainAxisAvailableSize()) {
                    } else {
                    }
                    i8 = 0;
                    i$iv++;
                    $i$f$debugLog4 = initialItemsMeasured4;
                    i8 = 1;
                }
                initialItemsMeasured4 = $i$f$debugLog4;
                $this$all$iv3 = 1;
                if ($this$all$iv3 != 0) {
                    mainAxisAvailableSize3 -= i174;
                    LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, -measuredItem);
                    LazyStaggeredGridMeasureKt.offsetBy(iArr12, measuredItem);
                    gapDetected3 = 0;
                    while (/* condition */) {
                        while (measure$lambda$38$misalignedStart < length13) {
                            l3 = 0;
                            if (iArr2[measure$lambda$38$misalignedStart] < measuredItem2.getBeforeContentPadding()) {
                            } else {
                            }
                            i24 = 0;
                            measure$lambda$38$misalignedStart++;
                            indexOfMaxValue = maxOffsetLane;
                            measuredItem = $this$all$iv5;
                            i24 = 1;
                        }
                        maxOffsetLane = indexOfMaxValue;
                        $this$all$iv5 = measuredItem;
                        laneIndex2 = 0;
                        laneIndex2 = LazyStaggeredGridMeasureKt.indexOfMinValue$default(laneToCheckForGaps, 0, 1, 0);
                        measuredItem = LazyStaggeredGridMeasureKt.indexOfMaxValue(iArr3);
                        if (laneIndex2 != measuredItem) {
                        }
                        if (iArr3[laneIndex2] == -1) {
                        } else {
                        }
                        iArr2 = iArr3[laneIndex2];
                        previousItemIndex = LazyStaggeredGridMeasureKt.findPreviousItemIndex(measuredItem2, iArr2, laneIndex2);
                        if (previousItemIndex < 0) {
                            break;
                        } else {
                        }
                        initialItemsMeasured4 = measuredItem;
                        gapDetected = gapDetected3;
                        offset = iArr3;
                        long spanRange-lOCCd4c4 = measuredItem2.getSpanRange-lOCCd4c(measuredItem2.getItemProvider(), previousItemIndex, laneIndex2);
                        long l29 = spanRange-lOCCd4c4;
                        int i263 = 0;
                        l14 = l29;
                        i22 = context6;
                        i53 = 0;
                        int i291 = 0;
                        int i294 = 0;
                        int i296 = 0;
                        i2 = i224;
                        i23 = 0;
                        i48 = i225;
                        if (i297 - i220 != 1) {
                        } else {
                        }
                        i5 = 0;
                        if (i5 != 0) {
                        } else {
                        }
                        i22 = i222;
                        i53 = i16;
                        i65 = (int)i223;
                        measuredItem2.getLaneInfo().setLane(previousItemIndex, i65);
                        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem andMeasure-jy6DScQ2 = measuredItem2.getMeasuredItemProvider().getAndMeasure-jy6DScQ(previousItemIndex, spanRange-lOCCd4c4);
                        int maxInRange-jy6DScQ4 = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(laneToCheckForGaps, spanRange-lOCCd4c4);
                        long l30 = spanRange-lOCCd4c4;
                        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context4 = $this$measure;
                        int i254 = 0;
                        int i264 = 0;
                        int i280 = 0;
                        int i286 = 0;
                        int i285 = 0;
                        i77 = i187;
                        if (i287 - i178 != 1) {
                        } else {
                        }
                        i76 = 0;
                        if (i76 != 0) {
                        } else {
                        }
                        gaps = 0;
                        int i226 = 0;
                        l15 = index$iv5;
                        int i255 = 0;
                        l3 = gaps;
                        index$iv = i189;
                        it2 = 0;
                        i47 = i190;
                        i$iv = i6;
                        while (i$iv < (int)i$iv9) {
                            it2 = i$iv;
                            i6 = 0;
                            if (laneToCheckForGaps[it2] != maxInRange-jy6DScQ4) {
                            }
                            arr[it2].addFirst(andMeasure-jy6DScQ2);
                            offset[it2] = previousItemIndex;
                            if (l3 == 0) {
                            } else {
                            }
                            i18 = l3[it2];
                            laneToCheckForGaps[it2] = i283 += i18;
                            i$iv++;
                            laneIndex2 = l15;
                            i18 = 0;
                            gapDetected = 1;
                        }
                        laneIndex3 = laneIndex2;
                        scrollDelta7 = initialLaneToMeasure7;
                        iArr3 = offset;
                        gapDetected3 = gapDetected;
                        indexOfMaxValue = maxOffsetLane;
                        measuredItem = $this$all$iv5;
                        i43 = i14;
                        initialLaneToMeasure5 = i55;
                        iArr2 = laneToCheckForGaps;
                        previousItemIndex = 0;
                        measure$lambda$38$misalignedStart = 0;
                        it2 = i$iv;
                        i6 = 0;
                        if (laneToCheckForGaps[it2] != maxInRange-jy6DScQ4) {
                        }
                        arr[it2].addFirst(andMeasure-jy6DScQ2);
                        offset[it2] = previousItemIndex;
                        if (l3 == 0) {
                        } else {
                        }
                        i18 = l3[it2];
                        laneToCheckForGaps[it2] = i283 += i18;
                        i$iv++;
                        laneIndex2 = l15;
                        i18 = 0;
                        gapDetected = 1;
                        gaps = measuredItem2.getLaneInfo().getGaps(previousItemIndex);
                        i76 = 1;
                        i65 = -2;
                        i5 = 1;
                        iArr2 = itemCount2;
                        if (laneToCheckForGaps[laneIndex2] == laneToCheckForGaps[measuredItem]) {
                        } else {
                        }
                        gapDetected3 = 1;
                        laneIndex2 = measuredItem;
                        l3 = 0;
                        if (iArr2[measure$lambda$38$misalignedStart] < measuredItem2.getBeforeContentPadding()) {
                        } else {
                        }
                        i24 = 0;
                        if (i24 != 0) {
                        } else {
                        }
                        measure$lambda$38$misalignedStart++;
                        indexOfMaxValue = maxOffsetLane;
                        measuredItem = $this$all$iv5;
                        laneIndex2 = 1;
                        i24 = 1;
                    }
                    initialLaneToMeasure4 = initialLaneToMeasure5;
                    i39 = i43;
                    initialLaneToMeasure3 = scrollDelta7;
                    beforeVisibleBounds$iv2 = iArr3;
                    if (gapDetected3 != 0 && canRestartMeasure) {
                        if (canRestartMeasure) {
                            measuredItem2.getLaneInfo().reset();
                            return LazyStaggeredGridMeasureKt.measure(measuredItem2, initialLaneToMeasure3, beforeVisibleBounds$iv2, laneToCheckForGaps, false);
                        }
                    }
                    $this$all$iv3 = LazyStaggeredGridMeasureKt.indexOfMinValue$default(laneToCheckForGaps, 0, 1, 0);
                    if (laneToCheckForGaps[$this$all$iv3] < 0) {
                        initialLaneToMeasure2 = laneToCheckForGaps[$this$all$iv3];
                        scrollDelta += initialLaneToMeasure2;
                        LazyStaggeredGridMeasureKt.offsetBy(iArr12, initialLaneToMeasure2);
                        LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, -initialLaneToMeasure2);
                    }
                } else {
                    initialLaneToMeasure4 = initialLaneToMeasure5;
                    i39 = i43;
                    beforeVisibleBounds$iv2 = iArr3;
                    scrollDelta = initialLaneToMeasure2;
                }
                int i98 = 0;
                int $i$f$debugLog6 = 0;
                int i144 = 0;
                int i149 = 0;
                if (MathKt.getSign(Math.round(measuredItem2.getState().getScrollToBeConsumed$foundation_release())) == MathKt.getSign(scrollDelta) && Math.abs(Math.round(measuredItem2.getState().getScrollToBeConsumed$foundation_release())) >= Math.abs(scrollDelta)) {
                    i149 = 0;
                    if (Math.abs(Math.round(measuredItem2.getState().getScrollToBeConsumed$foundation_release())) >= Math.abs(scrollDelta)) {
                        f2 = scrollToBeConsumed$foundation_release;
                    } else {
                        f2 = scrollToBeConsumed$foundation_release;
                    }
                } else {
                }
                f = f2;
                int[] copyOf = Arrays.copyOf(laneToCheckForGaps, laneToCheckForGaps.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, str2);
                int i166 = 0;
                i$iv3 = 0;
                while (i$iv3 < copyOf.length) {
                    it2 = 0;
                    copyOf[i$iv3] = -i217;
                    i$iv3++;
                }
                int i167 = 0;
                if (measuredItem2.getBeforeContentPadding() > measuredItem2.getMainAxisSpacing()) {
                    laneIndex = 0;
                    while (laneIndex < arr.length) {
                        length = arr[laneIndex];
                        i43 = 0;
                        while (i43 < length.size()) {
                            i4 = length.get(i43);
                            l8 = laneIndex;
                            int[] gaps3 = measuredItem2.getLaneInfo().getGaps((LazyStaggeredGridMeasuredItem)i4.getIndex());
                            if (gaps3 == null) {
                            } else {
                            }
                            i45 = gaps3[l8];
                            mainAxisSizeWithSpacings2 += i45;
                            i37 = gaps3;
                            laneToCheckForGaps[l8] = i119 -= laneIndex;
                            beforeVisibleBounds$iv2[l8] = (LazyStaggeredGridMeasuredItem)length.get(i43 + 1).getIndex();
                            i43++;
                            scrollDelta = scrollDelta5;
                            laneIndex = l8;
                            i45 = 0;
                        }
                        scrollDelta5 = scrollDelta;
                        l8 = laneIndex;
                        laneIndex = l8 + 1;
                        scrollDelta = scrollDelta5;
                        i4 = length.get(i43);
                        l8 = laneIndex;
                        gaps3 = measuredItem2.getLaneInfo().getGaps((LazyStaggeredGridMeasuredItem)i4.getIndex());
                        if (gaps3 == null) {
                        } else {
                        }
                        i45 = gaps3[l8];
                        mainAxisSizeWithSpacings2 += i45;
                        i37 = gaps3;
                        if (i43 != CollectionsKt.getLastIndex((List)length)) {
                        } else {
                        }
                        if (laneToCheckForGaps[l8] != 0) {
                        } else {
                        }
                        if (laneToCheckForGaps[l8] >= laneIndex) {
                        } else {
                        }
                        laneToCheckForGaps[l8] = i119 -= laneIndex;
                        beforeVisibleBounds$iv2[l8] = (LazyStaggeredGridMeasuredItem)length.get(i43 + 1).getIndex();
                        i43++;
                        scrollDelta = scrollDelta5;
                        laneIndex = l8;
                        i45 = 0;
                    }
                    scrollDelta6 = scrollDelta;
                    l8 = laneIndex;
                } else {
                    scrollDelta6 = scrollDelta;
                }
                int scrollDelta10 = 0;
                beforeContentPadding4 += afterContentPadding2;
                if (measuredItem2.isVertical()) {
                    constrainWidth-K40F9xA = Constraints.getMaxWidth-impl(measuredItem2.getConstraints-msEJaDk());
                } else {
                    constrainWidth-K40F9xA = ConstraintsKt.constrainWidth-K40F9xA(measuredItem2.getConstraints-msEJaDk(), mainAxisSpacing);
                }
                i63 = constrainWidth-K40F9xA;
                if (measuredItem2.isVertical()) {
                    i54 = constrainHeight-K40F9xA;
                } else {
                    i54 = constrainHeight-K40F9xA;
                }
                i57 = measuredItem2.isVertical() ? i54 : i63;
                int i185 = 0;
                i193 += afterContentPadding3;
                int i169 = 0;
                extraItemOffset = copyOf[0];
                $this$calculateExtraItems$iv = $this$measure;
                result$iv2 = 0;
                int i237 = 0;
                $this$fastForEachReversed$iv$iv$iv = pinnedItems2;
                int i251 = 0;
                i67 = -1;
                if (size2-- >= 0) {
                } else {
                    contentPadding = index$iv3;
                    l6 = $this$calculateExtraItems$iv;
                    laneIndex3 = laneToCheckForGaps;
                    iArr3 = beforeVisibleBounds$iv2;
                    i47 = spanRange-lOCCd4c2;
                    $this$all$iv5 = i74;
                    maxOffsetLane = $this$fastForEachReversed$iv$iv$iv;
                }
                if (result$iv2 == 0) {
                    result$iv2 = index$iv3;
                }
                List visibleItems = LazyStaggeredGridMeasureKt.calculateVisibleItems(measuredItem2, arr, copyOf, i194);
                int i244 = 0;
                i79 = i244;
                $i$f$calculateExtraItems = 0;
                size = 0;
                $this$all$iv7 = 0;
                emptyList = $this$measure.getPinnedItems().size();
                final int[] iArr19 = copyOf;
                itemScrollOffsets = i240;
                index$iv$iv$iv = i205;
                result$iv = i51;
                while (itemScrollOffsets < emptyList) {
                    List list2 = list;
                    index$iv4 = (Number)list2.get(itemScrollOffsets).intValue();
                    i67 = 0;
                    l3 = 0;
                    index$iv$iv$iv2 = i259;
                    if (index$iv$iv$iv2 >= itemCount2) {
                    } else {
                    }
                    if (/* condition */) {
                    } else {
                    }
                    $this$all$iv5 = $i$f$calculateExtraItems;
                    if (iArr18[lane4] < index$iv$iv$iv2) {
                    } else {
                    }
                    beforeVisibleBounds$iv = 0;
                    if (beforeVisibleBounds$iv != 0) {
                    } else {
                    }
                    index$iv5 = index$iv4;
                    i75 = mainAxisSizeWithSpacings;
                    i30 = spanRange;
                    l6 = itemCount2;
                    itemScrollOffsets = maxOffsetLane + 1;
                    spanRange = i30;
                    emptyList = i51;
                    list = i29;
                    i79 = f2;
                    $i$f$calculateExtraItems = $this$all$iv5;
                    mainAxisSizeWithSpacings = i75;
                    itemCount2 = l6;
                    i30 = spanRange;
                    l6 = itemCount2;
                    if (index$iv$iv$iv == 0) {
                    } else {
                    }
                    index$iv$iv$iv2 = index$iv$iv$iv;
                    beforeVisibleBounds$iv = mainAxisSizeWithSpacings.getMeasuredItemProvider().getAndMeasure-jy6DScQ(index$iv4, mainAxisSizeWithSpacings.getSpanRange-lOCCd4c(mainAxisSizeWithSpacings.getItemProvider(), index$iv4, 0));
                    l3 = 0;
                    index$iv5 = index$iv4;
                    i75 = mainAxisSizeWithSpacings;
                    index$iv4 = lazyStaggeredGridMeasuredItem2;
                    index$iv4.position(result$iv, 0, i194);
                    result$iv += mainAxisSizeWithSpacings;
                    index$iv$iv$iv2.add(beforeVisibleBounds$iv);
                    index$iv$iv$iv = index$iv$iv$iv2;
                    ArrayList arrayList3 = new ArrayList();
                    index$iv$iv$iv2 = index$iv$iv$iv;
                    beforeVisibleBounds$iv = 1;
                    index$iv5 = 0;
                    i75 = lane4;
                    int[] lane5 = $i$f$calculateExtraItems3;
                    $this$all$iv5 = $i$f$calculateExtraItems;
                    $this$all$iv2 = 0;
                    while ($this$all$iv2 < lane5.length) {
                        l12 = 0;
                        if (lane5[$this$all$iv2] < index$iv$iv$iv2) {
                        } else {
                        }
                        it3 = 0;
                        $this$all$iv2 = i9 + 1;
                        it3 = 1;
                    }
                    beforeVisibleBounds$iv = 1;
                    l12 = 0;
                    if (l6[$this$all$iv2] < index$iv$iv$iv2) {
                    } else {
                    }
                    it3 = 0;
                    if (it3 == 0) {
                    } else {
                    }
                    $this$all$iv2 = i9 + 1;
                    beforeVisibleBounds$iv = 0;
                    it3 = 1;
                    f2 = i79;
                    $this$all$iv5 = $i$f$calculateExtraItems;
                    beforeVisibleBounds$iv = 0;
                }
                int i269 = itemScrollOffsets;
                int i260 = i79;
                androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context10 = mainAxisSizeWithSpacings;
                int i272 = $i$f$calculateExtraItems;
                int $i$f$calculateExtraItems2 = spanRange;
                int i282 = itemCount2;
                List list5 = list;
                if (index$iv$iv$iv == 0) {
                    index$iv$iv$iv = emptyList;
                }
                ArrayList arrayList2 = new ArrayList();
                (List)arrayList2.addAll((Collection)result$iv2);
                arrayList2.addAll((Collection)visibleItems);
                arrayList2.addAll((Collection)index$iv$iv$iv);
                int i147 = 0;
                ArrayList list6 = arrayList2;
                measuredItem2.getState().getItemAnimator$foundation_release().onMeasured((int)f, i63, i54, list6, measuredItem2.getMeasuredItemProvider().getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItem2.getMeasuredItemProvider(), measuredItem2.isVertical(), false, measuredItem2.getLaneCount(), false, ArraysKt.minOrThrow(laneIndex3), maxOrThrow + contentPadding, measuredItem2.getCoroutineScope(), measuredItem2.getGraphicsContext());
                i66 = i63;
                i19 = i54;
                ArrayList list4 = list6;
                long minSizeToFitDisappearingItems-YbymL2g2 = measuredItem2.getState().getItemAnimator$foundation_release().getMinSizeToFitDisappearingItems-YbymL2g();
                if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g2, itemCount2)) {
                    i20 = measuredItem2.isVertical() ? i19 : i66;
                    consumedScroll = f;
                    i63 = constrainWidth-K40F9xA2;
                    i54 = constrainHeight-K40F9xA2;
                    f = measuredItem2.isVertical() ? i54 : i63;
                    if (f != i20) {
                        i66 = 0;
                        index$iv2 = 0;
                        while (index$iv2 < list4.size()) {
                            i51 = 0;
                            (LazyStaggeredGridMeasuredItem)i19.get(index$iv2).updateMainAxisLayoutSize(f);
                            index$iv2++;
                            i19 = $this$all$iv7;
                        }
                        $this$all$iv7 = i19;
                    }
                    i64 = i63;
                    i13 = i54;
                } else {
                    consumedScroll = f;
                    i13 = i19;
                    i64 = i66;
                }
                i42 = 0;
                i10 = 0;
                while (i10 < iArr.length) {
                    list = null;
                    if (iArr[i10] > measuredItem2.getMainAxisAvailableSize()) {
                    } else {
                    }
                    i11 = 0;
                    i10++;
                    iArr = $this$all$iv7;
                    i11 = 1;
                }
                $this$all$iv7 = iArr;
                $this$all$iv6 = 0;
                if ($this$all$iv6 == 0) {
                    i42 = 0;
                    i10 = 0;
                    while (i10 < iArr5.length) {
                        list = null;
                        if (iArr5[i10] < i282 + -1) {
                        } else {
                        }
                        i26 = 0;
                        i10++;
                        iArr5 = $this$all$iv7;
                        i26 = 1;
                    }
                    $this$all$iv7 = iArr5;
                    $this$all$iv6 = 1;
                    if ($this$all$iv6 != 0) {
                        i52 = 1;
                    } else {
                        i52 = 0;
                    }
                } else {
                }
            }
            LazyStaggeredGridMeasureKt.measure.1.30 anon = new LazyStaggeredGridMeasureKt.measure.1.30(list4, measuredItem2);
            int[] iArr15 = iArr3;
            LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult2 = new LazyStaggeredGridMeasureResult(iArr15, laneIndex3, consumedScroll, MeasureScope.layout$default((MeasureScope)lazyLayoutMeasureScope3, i64, i13, 0, (Function1)anon, 4, 0), i52, measuredItem2.isVertical(), remeasureNeeded2, measuredItem2.getResolvedSlots(), measuredItem2.getItemProvider().getSpanProvider(), (Density)lazyLayoutMeasureScope3, i282, visibleItems, IntSizeKt.IntSize(i64, i13), i77, i84, i39, measuredItem2.getBeforeContentPadding(), measuredItem2.getAfterContentPadding(), measuredItem2.getMainAxisSpacing(), measuredItem2.getCoroutineScope(), 0);
            int[] iArr17 = iArr15;
            return lazyStaggeredGridMeasureResult2;
        }
        itemCount = itemCount2;
    }

    private static final boolean measure$lambda$38$hasSpaceBeforeFirst(int[] firstItemIndices, int[] firstItemOffsets, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext $this_measure) {
        int lane;
        int i3;
        int i2;
        int i4;
        int i;
        lane = 0;
        int i6 = 0;
        while (lane < firstItemIndices.length) {
            lane++;
            i6 = 0;
        }
        return i6;
    }

    private static final boolean measure$lambda$38$misalignedStart(int[] firstItemIndices, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext $this_measure, int[] firstItemOffsets, int referenceLane) {
        int lane;
        int lane2;
        int length;
        int i4;
        int i2;
        int i3;
        int previousItemIndex;
        int previousItemIndex2;
        int i;
        lane = 0;
        i4 = -1;
        i2 = 0;
        i3 = 1;
        while (lane < firstItemIndices.length) {
            if (LazyStaggeredGridMeasureKt.findPreviousItemIndex($this_measure, firstItemIndices[lane], lane) == i4 && firstItemOffsets[lane] != firstItemOffsets[referenceLane]) {
            } else {
            }
            lane++;
            i4 = -1;
            i2 = 0;
            i3 = 1;
            if (firstItemOffsets[lane] != firstItemOffsets[referenceLane]) {
            } else {
            }
            i2 = i3;
        }
        lane2 = 0;
        while (lane2 < firstItemIndices.length) {
            if (LazyStaggeredGridMeasureKt.findPreviousItemIndex($this_measure, firstItemIndices[lane2], lane2) != i4 && firstItemOffsets[lane2] >= firstItemOffsets[referenceLane]) {
            } else {
            }
            previousItemIndex = i2;
            lane2++;
            if (firstItemOffsets[lane2] >= firstItemOffsets[referenceLane]) {
            } else {
            }
            previousItemIndex = i3;
        }
        int lane3 = $this_measure.getLaneInfo().getLane(i2);
        if (lane3 != 0 && lane3 != i4 && lane3 != -2) {
            if (lane3 != i4) {
                if (lane3 != -2) {
                    i2 = i3;
                }
            }
        }
        return i2;
    }

    public static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult measureStaggeredGrid-XtK8cYQ(LazyLayoutMeasureScope $this$measureStaggeredGrid_u2dXtK8cYQ, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state, List<Integer> pinnedItems, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider itemProvider, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots resolvedSlots, long constraints, boolean isVertical, boolean reverseLayout, long contentOffset, int mainAxisAvailableSize, int mainAxisSpacing, int beforeContentPadding, int afterContentPadding, CoroutineScope coroutineScope, GraphicsContext graphicsContext) {
        int[] iArr;
        int[] iArr2;
        int laneCount2;
        int[] laneCount;
        int i2;
        int lane;
        boolean length;
        int laneInfo;
        int length2;
        int i;
        CoroutineScope coroutineScope2;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(state, pinnedItems, itemProvider, resolvedSlots, constraints, obj6, reverseLayout, $this$measureStaggeredGrid_u2dXtK8cYQ, beforeContentPadding, mainAxisAvailableSize, obj11, coroutineScope, graphicsContext, contentOffset, afterContentPadding, obj34, obj35, 0);
        int i3 = 0;
        int i4 = 0;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState lazyStaggeredGridState2 = state;
        int[] scrollPositionIfTheFirstItemWasMoved$foundation_release = lazyStaggeredGridState2.updateScrollPositionIfTheFirstItemWasMoved$foundation_release((LazyLayoutItemProvider)itemProvider, state.getScrollPosition$foundation_release().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState2.getScrollPosition$foundation_release().getScrollOffsets();
        int i7 = 0;
        int i8 = 1;
        if (scrollPositionIfTheFirstItemWasMoved$foundation_release.length == lazyStaggeredGridMeasureContext.getLaneCount()) {
            iArr2 = scrollPositionIfTheFirstItemWasMoved$foundation_release;
        } else {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            laneCount2 = iArr2;
            i2 = 0;
            lane = 0;
            while (lane < laneCount2.length) {
                if (lane < scrollPositionIfTheFirstItemWasMoved$foundation_release.length && scrollPositionIfTheFirstItemWasMoved$foundation_release[lane] != -1) {
                } else {
                }
                if (lane == 0) {
                } else {
                }
                maxInRange-jy6DScQ += i8;
                laneCount2[lane] = i;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(laneCount2[lane], lane);
                lane++;
                i = i7;
                if (scrollPositionIfTheFirstItemWasMoved$foundation_release[lane] != -1) {
                } else {
                }
                i = scrollPositionIfTheFirstItemWasMoved$foundation_release[lane];
            }
        }
        if (scrollOffsets.length == lazyStaggeredGridMeasureContext.getLaneCount()) {
            iArr = scrollOffsets;
        } else {
            laneCount = iArr;
            i2 = 0;
            lane = 0;
            while (lane < laneCount.length) {
                if (lane < scrollOffsets.length) {
                } else {
                }
                if (lane == 0) {
                } else {
                }
                laneInfo = laneCount[lane + -1];
                laneCount[lane] = laneInfo;
                lane++;
                laneInfo = i7;
                laneInfo = scrollOffsets[lane];
            }
        }
        int i5 = 0;
        return LazyStaggeredGridMeasureKt.measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState2.getScrollToBeConsumed$foundation_release()), iArr2, iArr, i8);
    }

    private static final void offsetBy(int[] $this$offsetBy, int delta) {
        int i;
        int i2;
        i = 0;
        while (i < $this$offsetBy.length) {
            $this$offsetBy[i] = i3 += delta;
            i++;
        }
    }

    private static final int[] transform(int[] $this$transform, Function1<? super Integer, Integer> block) {
        int i;
        int intValue;
        final int i2 = 0;
        i = 0;
        while (i < $this$transform.length) {
            $this$transform[i] = (Number)block.invoke(Integer.valueOf($this$transform[i])).intValue();
            i++;
        }
        return $this$transform;
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope scope, Function1<? super LazyLayoutMeasureScope, ? extends T> block) {
        final int i = 0;
        return block.invoke(scope);
    }
}
