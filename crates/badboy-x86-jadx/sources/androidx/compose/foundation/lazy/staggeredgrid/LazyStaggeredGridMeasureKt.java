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
        int $i$f$calculateExtraItems;
        int result2;
        int andMeasure-jy6DScQ2;
        List index$iv$iv;
        int size;
        int i;
        int intValue;
        Object obj;
        int andMeasure-jy6DScQ;
        Object itemProvider;
        int i2;
        Object result;
        int $i$f$calculateExtraItems2;
        int i3;
        final Object obj2 = $this$calculateExtraItems;
        final Object obj3 = position;
        $i$f$calculateExtraItems = 0;
        result2 = 0;
        final List pinnedItems = obj2.getPinnedItems();
        final int i4 = 0;
        andMeasure-jy6DScQ2 = 0;
        if (beforeVisibleBounds) {
            index$iv$iv = pinnedItems;
            size = 0;
            if (size2-- >= 0) {
            } else {
                $i$f$calculateExtraItems2 = $i$f$calculateExtraItems;
            }
        } else {
            $i$f$calculateExtraItems2 = $i$f$calculateExtraItems;
            andMeasure-jy6DScQ2 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < pinnedItems.size()) {
                intValue = (Number)$i$f$calculateExtraItems.get(index$iv$iv).intValue();
                obj = 0;
                if ((Boolean)spanRange-lOCCd4c.invoke(Integer.valueOf(intValue)).booleanValue()) {
                } else {
                }
                result = $i$f$calculateExtraItems;
                i2 = 0;
                index$iv$iv++;
                spanRange-lOCCd4c = filter;
                $i$f$calculateExtraItems = result;
                result = $i$f$calculateExtraItems;
                if (result2 == null) {
                }
                andMeasure-jy6DScQ = obj2.getMeasuredItemProvider().getAndMeasure-jy6DScQ(intValue, obj2.getSpanRange-lOCCd4c(obj2.getItemProvider(), intValue, 0));
                obj3.invoke(andMeasure-jy6DScQ);
                result2.add(andMeasure-jy6DScQ);
                itemProvider = new ArrayList();
                result2 = itemProvider;
            }
            result = $i$f$calculateExtraItems;
        }
        if (result2 == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            emptyList = result2;
        }
        return emptyList;
    }

    private static final List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> calculateVisibleItems(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext $this$calculateVisibleItems, ArrayDeque<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem>[] measuredItems, int[] itemScrollOffsets, int mainAxisLayoutSize) {
        Object[] objArr;
        long[] lArr;
        int i$iv2;
        int first;
        int maxInRange-jy6DScQ;
        int result$iv;
        int i;
        int min$iv;
        int i3;
        int i$iv;
        int length;
        int i4;
        boolean empty;
        int index;
        int i7;
        long l;
        long l2;
        int i2;
        long l3;
        int i5;
        int i6;
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
            while (i3 < length3) {
                i4 = 0;
                i3++;
            }
            i = 0;
            if (i != 0) {
            }
            int[] iArr = measuredItems;
            int i12 = 0;
            result$iv = -1;
            min$iv = Integer.MAX_VALUE;
            i$iv = 0;
            while (i$iv < iArr.length) {
                empty = false;
                Object firstOrNull = iArr[i$iv].firstOrNull();
                if ((LazyStaggeredGridMeasuredItem)firstOrNull != null) {
                } else {
                }
                index = Integer.MAX_VALUE;
                if (min$iv > index) {
                }
                i$iv++;
                min$iv = index;
                result$iv = i$iv;
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
            i$iv2 = (int)i10;
            first = 0;
            i2 = 0;
            while (i$iv2 < (int)i8) {
                first = 0;
                itemScrollOffsets[i$iv2] = mainAxisSizeWithSpacings += maxInRange-jy6DScQ;
                i$iv2++;
            }
            objArr = measuredItems;
            lArr = itemScrollOffsets;
            Object[] objArr2 = measuredItems;
            int i11 = 0;
            i3 = 0;
            first = 0;
            itemScrollOffsets[i$iv2] = mainAxisSizeWithSpacings += maxInRange-jy6DScQ;
            i$iv2++;
            empty = false;
            firstOrNull = iArr[i$iv].firstOrNull();
            if ((LazyStaggeredGridMeasuredItem)firstOrNull != null) {
            } else {
            }
            index = Integer.MAX_VALUE;
            if (min$iv > index) {
            }
            i$iv++;
            min$iv = index;
            result$iv = i$iv;
            index = (LazyStaggeredGridMeasuredItem)firstOrNull.getIndex();
            i4 = 0;
            if (!(Collection)objArr2[i3].isEmpty()) {
            } else {
            }
            i3++;
            i = 1;
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
        int i2;
        int previousItemIndex;
        int assignedToLane;
        int i;
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
        int i2;
        int i3;
        int i4;
        result = -1;
        min = Integer.MAX_VALUE;
        i = 0;
        while (i < $this$indexOfMinValue.length) {
            i3 = $this$indexOfMinValue[i];
            i4 = 0;
            if (minBound + 1 <= i3 && i3 < min) {
            }
            if (i4 != 0) {
            }
            i++;
            min = $this$indexOfMinValue[i];
            result = i;
            if (i3 < min) {
            }
            i4 = 1;
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
        int i3;
        int i;
        int i4 = 0;
        max = Integer.MIN_VALUE;
        final int i5 = indexRange;
        final int i6 = 0;
        int i7 = 0;
        i3 = 0;
        value$iv$iv$iv = (int)i11;
        i2 = 0;
        i = 0;
        while (value$iv$iv$iv < (int)i12) {
            i3 = 0;
            max = Math.max(max, $this$maxInRange_u2djy6DScQ[value$iv$iv$iv]);
            value$iv$iv$iv++;
        }
        return max;
    }

    private static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult measure(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext $this$measure, int initialScrollDelta, int[] initialItemIndices, int[] initialItemOffsets, boolean canRestartMeasure) {
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext measuredItem;
        int i41;
        int i20;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider itemProvider;
        int previousItemIndex2;
        int initialItemsMeasured;
        int i46;
        int i21;
        long i73;
        int maxInRange-jy6DScQ;
        int i47;
        int initialItemsMeasured3;
        int[] $i$f$debugLog;
        int $this$all$iv7;
        float scrollToBeConsumed$foundation_release;
        float f;
        int[] iArr3;
        int $this$all$iv;
        int[] iArr;
        int i33;
        int i40;
        int sign2;
        int indexOfMaxValue;
        int laneIndex3;
        int i68;
        int i65;
        int i78;
        int scrollDelta;
        boolean constraints-msEJaDk;
        int[] i$iv3;
        int scrollDelta2;
        int i$iv;
        int $i$f$debugLog4;
        int $this$all$iv3;
        int i58;
        int $i$f$debugLog3;
        int scrollDelta4;
        int index$iv4;
        int emptyList;
        int index$iv;
        int i64;
        int i8;
        int measuredItem2;
        int i;
        int i27;
        int gaps;
        int i$iv2;
        int[] $i$f$forEachNIS5qE8;
        int initialLaneToMeasure2;
        int i45;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo laneInfo;
        int initialLaneToMeasure3;
        int sign;
        int itemScrollOffsets;
        int index$iv$iv$iv;
        int initialLaneToMeasure;
        int initialLaneToMeasure5;
        int i67;
        int layoutWidth;
        int[] offset;
        int i43;
        int i18;
        int indexOfMinValue$default;
        int gapDetected2;
        int laneIndex2;
        int constrainWidth-K40F9xA;
        int constrainHeight-K40F9xA;
        int i57;
        int extraItemOffset;
        int i75;
        int i44;
        int $this$all$iv6;
        int it;
        int i3;
        int $this$all$iv5;
        int it2;
        int beforeVisibleBounds$iv;
        int i35;
        int length3;
        int i76;
        int gaps2;
        int gapDetected;
        int layoutHeight;
        String length2;
        int i7;
        int i70;
        int i$iv5;
        int i$iv4;
        int mainAxisSpacing;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem $this$calculateExtraItems$iv;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext mainAxisSizeWithSpacings;
        boolean equals-impl0;
        int i13;
        int i77;
        int iArr5;
        ArrayList height-impl;
        int[] laneToCheckForGaps;
        int $i$f$calculateExtraItems;
        int i53;
        int i24;
        int remeasureNeeded3;
        int remeasureNeeded;
        int index2;
        int previousItemIndex;
        int length;
        int visible;
        int i16;
        int $i$f$debugLog2;
        int[] offset2;
        int i2;
        int[] beforeVisibleBounds$iv2;
        int result$iv2;
        int i19;
        int measure$lambda$38$hasSpaceBeforeFirst;
        int spanRange;
        int itemCount;
        ArrayDeque spanRange-lOCCd4c2;
        int i22;
        int i51;
        int length4;
        int i56;
        int i17;
        long l7;
        int spanRange-lOCCd4c;
        long index$iv5;
        int i52;
        int i6;
        int i79;
        int it3;
        int i48;
        int size;
        int measure$lambda$38$misalignedStart;
        int i23;
        int index;
        long l13;
        int i42;
        int i49;
        int i59;
        int result$iv;
        int scrollDelta6;
        int scrollDelta7;
        long l11;
        List list;
        int i60;
        int $this$all$iv2;
        int i69;
        int i11;
        List $this$fastForEachReversed$iv$iv$iv;
        int index$iv$iv$iv2;
        int i12;
        int scrollDelta3;
        int initialItemsMeasured4;
        int i14;
        long l9;
        int i38;
        int indexOfMinValue$default2;
        int scrollDelta5;
        int i74;
        int i61;
        int gapDetected3;
        int l10;
        float f2;
        float consumedScroll;
        long l2;
        long l6;
        int maxOffsetLane;
        long l14;
        int i63;
        long l15;
        int $this$all$iv4;
        int i31;
        int[] i10;
        int i4;
        int remeasureNeeded2;
        int i9;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem index$iv2;
        long l3;
        int i34;
        long l4;
        int laneIndex;
        long l5;
        long l12;
        int itemCount2;
        long l8;
        int index$iv3;
        int i36;
        int i25;
        int i71;
        int i30;
        int i5;
        int i50;
        long l;
        int i37;
        int i39;
        int[] iArr2;
        int[] iArr6;
        String str2;
        String str;
        int i62;
        int i32;
        int[] iArr4;
        int initialItemsMeasured2;
        int i26;
        int initialLaneToMeasure4;
        int i72;
        int i54;
        int i55;
        int i15;
        int i28;
        int i29;
        int i66;
        int contentPadding;
        measuredItem = $this$measure;
        i$iv3 = initialItemIndices;
        $i$f$forEachNIS5qE8 = initialItemOffsets;
        final int i240 = 0;
        final LazyLayoutMeasureScope lazyLayoutMeasureScope3 = measureScope;
        final int i241 = 0;
        itemCount = measuredItem.getItemProvider().getItemCount();
        if (itemCount > 0) {
            if (measuredItem.getLaneCount() == 0) {
                itemCount2 = itemCount;
                layoutWidth = Constraints.getMinWidth-impl($this$measure.getConstraints-msEJaDk());
                layoutHeight = Constraints.getMinHeight-impl($this$measure.getConstraints-msEJaDk());
                ArrayList arrayList = new ArrayList();
                CoroutineScope coroutineScope = $this$measure.getCoroutineScope();
                int i133 = 0;
                $this$measure.getState().getItemAnimator$foundation_release().onMeasured(i133, layoutWidth, layoutHeight, (List)arrayList, $this$measure.getMeasuredItemProvider().getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)$this$measure.getMeasuredItemProvider(), $this$measure.isVertical(), false, $this$measure.getLaneCount(), false, 0, 0, coroutineScope, $this$measure.getGraphicsContext());
                long minSizeToFitDisappearingItems-YbymL2g = $this$measure.getState().getItemAnimator$foundation_release().getMinSizeToFitDisappearingItems-YbymL2g();
                if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g, itemProvider)) {
                    i24 = layoutWidth;
                    i16 = layoutHeight;
                } else {
                    i24 = layoutWidth;
                    i16 = layoutHeight;
                }
                int i242 = i24;
                int i248 = i16;
                long l23 = l17;
                LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult = new LazyStaggeredGridMeasureResult(initialItemIndices, initialItemOffsets, 0, MeasureScope.layout$default((MeasureScope)lazyLayoutMeasureScope3, i24, i16, 0, (Function1)LazyStaggeredGridMeasureKt.measure.1.1.INSTANCE, 4, 0), 0, $this$measure.isVertical(), 0, $this$measure.getResolvedSlots(), $this$measure.getItemProvider().getSpanProvider(), (Density)lazyLayoutMeasureScope3, itemCount2, CollectionsKt.emptyList(), IntSizeKt.IntSize(Constraints.getMinWidth-impl($this$measure.getConstraints-msEJaDk()), Constraints.getMinHeight-impl($this$measure.getConstraints-msEJaDk())), coroutineScope, -beforeContentPadding3, mainAxisAvailableSize4 + afterContentPadding, $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), $this$measure.getMainAxisSpacing(), $this$measure.getCoroutineScope(), 0);
                return lazyStaggeredGridMeasureResult;
            } else {
                offset = Arrays.copyOf(i$iv3, i$iv3.length);
                length2 = "copyOf(this, size)";
                Intrinsics.checkNotNullExpressionValue(offset, length2);
                laneToCheckForGaps = Arrays.copyOf($i$f$forEachNIS5qE8, $i$f$forEachNIS5qE8.length);
                Intrinsics.checkNotNullExpressionValue(laneToCheckForGaps, length2);
                remeasureNeeded3 = 0;
                LazyStaggeredGridMeasureKt.ensureIndicesInRange(measuredItem, offset, itemCount);
                LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, -previousItemIndex2);
                int laneCount2 = measuredItem.getLaneCount();
                ArrayDeque[] arr = new ArrayDeque[laneCount2];
                measure$lambda$38$hasSpaceBeforeFirst = 0;
                while (measure$lambda$38$hasSpaceBeforeFirst < laneCount2) {
                    spanRange-lOCCd4c2 = new ArrayDeque(16);
                    arr[measure$lambda$38$hasSpaceBeforeFirst] = spanRange-lOCCd4c2;
                    measure$lambda$38$hasSpaceBeforeFirst++;
                }
                LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, -beforeContentPadding7);
                int i195 = 0;
                $i$f$debugLog2 = -1;
                i59 = 32;
                while (LazyStaggeredGridMeasureKt.measure$lambda$38$hasSpaceBeforeFirst(offset, laneToCheckForGaps, measuredItem)) {
                    measure$lambda$38$hasSpaceBeforeFirst = LazyStaggeredGridMeasureKt.indexOfMaxValue(offset);
                    l11 = 4294967295L;
                    length4 = laneToCheckForGaps.length;
                    i19 = l13;
                    i12 = 0;
                    while (i19 < length4) {
                        if (offset[i19] != offset[measure$lambda$38$hasSpaceBeforeFirst] && laneToCheckForGaps[i19] < laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst]) {
                        }
                        i19++;
                        previousItemIndex2 = scrollDelta3;
                        if (laneToCheckForGaps[i19] < laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst]) {
                        }
                        laneToCheckForGaps[i19] = laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst];
                    }
                    previousItemIndex2 = LazyStaggeredGridMeasureKt.findPreviousItemIndex(measuredItem, offset[measure$lambda$38$hasSpaceBeforeFirst], measure$lambda$38$hasSpaceBeforeFirst);
                    if (previousItemIndex2 < 0) {
                        break;
                    } else {
                    }
                    spanRange-lOCCd4c2 = measuredItem.getSpanRange-lOCCd4c(measuredItem.getItemProvider(), previousItemIndex2, measure$lambda$38$hasSpaceBeforeFirst);
                    long l21 = spanRange-lOCCd4c2;
                    int i260 = 0;
                    l15 = l21;
                    i9 = context7;
                    int i272 = 0;
                    int i274 = 0;
                    int i276 = 0;
                    int i283 = 0;
                    index$iv3 = 0;
                    i50 = i150;
                    if (i30 - i125 != 1) {
                    } else {
                    }
                    i = i12;
                    if (i != 0) {
                    } else {
                    }
                    scrollDelta6 = i132;
                    i9 = i67;
                    i27 = (int)$i$f$getStartImpl3;
                    measuredItem.getLaneInfo().setLane(previousItemIndex2, i27);
                    long l22 = spanRange-lOCCd4c2;
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context3 = $this$measure;
                    int i230 = 0;
                    int i257 = 0;
                    int i261 = 0;
                    int i268 = 0;
                    $this$all$iv4 = 0;
                    laneIndex = i151;
                    if (i4 - i129 != 1) {
                    } else {
                    }
                    i49 = i12;
                    if (i49 != 0) {
                    } else {
                    }
                    gaps = 0;
                    l9 = spanRange-lOCCd4c2;
                    int i153 = 0;
                    int i205 = 0;
                    int i228 = 0;
                    scrollDelta6 = gaps;
                    i19 = 0;
                    gapDetected3 = i131;
                    i$iv2 = i11;
                    while (i$iv2 < (int)i$iv7) {
                        i19 = i$iv2;
                        l13 = 0L;
                        offset[i19] = previousItemIndex2;
                        if (scrollDelta6 == 0) {
                        } else {
                        }
                        i59 = scrollDelta6[i19];
                        i231 += i59;
                        laneToCheckForGaps[i19] = l11;
                        if (mainAxisAvailableSize7 += l11 <= 0) {
                        }
                        i$iv2++;
                        remeasureNeeded3 = 1;
                        i59 = i12;
                    }
                    i$iv3 = initialItemIndices;
                    $i$f$forEachNIS5qE8 = initialItemOffsets;
                    previousItemIndex2 = scrollDelta3;
                    i59 = 32;
                    i19 = i$iv2;
                    l13 = 0L;
                    offset[i19] = maxOffsetLane;
                    if (scrollDelta6 == 0) {
                    } else {
                    }
                    i59 = scrollDelta6[i19];
                    i231 += i59;
                    laneToCheckForGaps[i19] = l11;
                    if (mainAxisAvailableSize7 += l11 <= 0) {
                    }
                    i$iv2++;
                    remeasureNeeded3 = 1;
                    i59 = i12;
                    gaps = measuredItem.getLaneInfo().getGaps(previousItemIndex2);
                    i49 = 1;
                    i27 = -2;
                    i = 1;
                    if (offset[i19] != offset[measure$lambda$38$hasSpaceBeforeFirst] && laneToCheckForGaps[i19] < laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst]) {
                    }
                    i19++;
                    previousItemIndex2 = scrollDelta3;
                    if (laneToCheckForGaps[i19] < laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst]) {
                    }
                    laneToCheckForGaps[i19] = laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst];
                }
                scrollDelta3 = previousItemIndex2;
                l11 = 4294967295L;
                i12 = 0;
                int scrollDelta8 = 0;
                int i83 = -beforeContentPadding;
                if (laneToCheckForGaps[i12] < i83) {
                    i121 += scrollDelta3;
                    LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, i83 - i148);
                    $i$f$forEachNIS5qE8 = 0;
                } else {
                    scrollDelta2 = scrollDelta3;
                }
                LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, measuredItem.getBeforeContentPadding());
                int i134 = -1;
                if ($i$f$debugLog2 == i134) {
                    spanRange = ArraysKt.indexOf(offset, i12);
                } else {
                    spanRange = $i$f$debugLog2;
                }
                $i$f$debugLog2 = spanRange;
                if (spanRange != i134 && LazyStaggeredGridMeasureKt.measure$lambda$38$misalignedStart(offset, measuredItem, laneToCheckForGaps, $i$f$debugLog2) && canRestartMeasure) {
                    $i$f$debugLog2 = spanRange;
                    if (LazyStaggeredGridMeasureKt.measure$lambda$38$misalignedStart(offset, measuredItem, laneToCheckForGaps, $i$f$debugLog2)) {
                        if (canRestartMeasure) {
                            measuredItem.getLaneInfo().reset();
                            int length10 = offset.length;
                            int[] iArr10 = new int[length10];
                            i22 = 0;
                            while (i22 < length10) {
                                iArr10[i22] = i134;
                                i22++;
                            }
                            int length5 = laneToCheckForGaps.length;
                            int[] iArr9 = new int[length5];
                            i51 = 0;
                            while (i51 < length5) {
                                iArr9[i51] = laneToCheckForGaps[$i$f$debugLog2];
                                i51++;
                            }
                            return LazyStaggeredGridMeasureKt.measure(measuredItem, scrollDelta2, iArr10, iArr9, false);
                        }
                    }
                }
                offset2 = Arrays.copyOf(offset, offset.length);
                Intrinsics.checkNotNullExpressionValue(offset2, length2);
                int length14 = laneToCheckForGaps.length;
                int[] iArr11 = new int[length14];
                i56 = 0;
                while (i56 < length14) {
                    iArr11[i56] = -i224;
                    i56++;
                }
                mainAxisSpacing3 += i83;
                it3 = 0;
                i17 = RangesKt.coerceAtLeast(mainAxisAvailableSize6 += afterContentPadding4, it3);
                int i237 = 0;
                remeasureNeeded2 = remeasureNeeded3;
                initialItemsMeasured = initialItemsMeasured4;
                initialLaneToMeasure2 = indexOfMinValue$default2;
                while (initialLaneToMeasure2 != -1) {
                    if (initialItemsMeasured < measuredItem.getLaneCount()) {
                    }
                    remeasureNeeded3 = offset2[initialLaneToMeasure2];
                    initialLaneToMeasure2 = LazyStaggeredGridMeasureKt.indexOfMinValue(offset2, remeasureNeeded3);
                    initialItemsMeasured++;
                    if (remeasureNeeded3 >= 0) {
                    } else {
                    }
                    initialItemsMeasured4 = initialItemsMeasured;
                    indexOfMinValue$default2 = scrollDelta2;
                    gapDetected3 = initialLaneToMeasure2;
                    iArr2 = offset;
                    str2 = length2;
                    iArr4 = offset2;
                    indexOfMinValue$default2 = scrollDelta2;
                    long spanRange-lOCCd4c3 = measuredItem.getSpanRange-lOCCd4c(measuredItem.getItemProvider(), remeasureNeeded3, initialLaneToMeasure2);
                    gapDetected3 = initialLaneToMeasure2;
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem andMeasure-jy6DScQ4 = measuredItem.getMeasuredItemProvider().getAndMeasure-jy6DScQ(remeasureNeeded3, spanRange-lOCCd4c3);
                    iArr4 = offset2;
                    long l26 = spanRange-lOCCd4c3;
                    int i269 = 0;
                    l8 = context8;
                    i36 = 0;
                    i30 = 0;
                    int i284 = 0;
                    l = l4;
                    int i290 = 0;
                    iArr2 = offset;
                    str2 = length2;
                    int i285 = 0;
                    i62 = i179;
                    if (i39 - i157 != 1) {
                    } else {
                    }
                    i43 = 0;
                    if (i43 != 0) {
                    } else {
                    }
                    l8 = i159;
                    i36 = i7;
                    i18 = (int)$i$f$getStartImpl4;
                    measuredItem.getLaneInfo().setLane(remeasureNeeded3, i18);
                    int maxInRange-jy6DScQ3 = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(iArr11, spanRange-lOCCd4c3);
                    i70 = 0;
                    int i196 = 0;
                    l3 = l6;
                    int i265 = 0;
                    laneIndex = spanRange-lOCCd4c3;
                    i2 = 0;
                    int i279 = i104;
                    i46 = (int)i$iv6;
                    i$iv = i31;
                    while (i$iv < i46) {
                        i2 = i$iv;
                        i31 = 0;
                        iArr11[i2] = mainAxisSizeWithSpacings6 += maxInRange-jy6DScQ3;
                        iArr4[i2] = remeasureNeeded3;
                        arr[i2].addLast(andMeasure-jy6DScQ4);
                        i$iv++;
                        i46 = l3;
                    }
                    i70 = i89;
                    i2 = i$iv;
                    if (maxInRange-jy6DScQ3 < i204 && iArr11[(int)$i$f$getStartImpl2] <= i204) {
                    }
                    long l16 = laneIndex;
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context2 = $this$measure;
                    int i197 = 0;
                    l2 = 0;
                    int i262 = 0;
                    $this$all$iv4 = 0;
                    index$iv2 = 0;
                    i50 = i105;
                    if (i34 - i87 != 1) {
                    } else {
                    }
                    i21 = 0;
                    if (i21 != 0) {
                    } else {
                    }
                    initialItemsMeasured = initialItemsMeasured4;
                    scrollDelta2 = indexOfMinValue$default2;
                    initialLaneToMeasure2 = gapDetected3;
                    offset = iArr2;
                    length2 = str2;
                    offset2 = iArr4;
                    initialItemsMeasured = measuredItem.getLaneCount();
                    scrollDelta2 = indexOfMinValue$default2;
                    initialLaneToMeasure2 = gapDetected3;
                    offset = iArr2;
                    length2 = str2;
                    offset2 = iArr4;
                    i21 = 1;
                    i70 = i89;
                    i2 = i$iv;
                    if (iArr11[(int)$i$f$getStartImpl2] <= i204) {
                    }
                    andMeasure-jy6DScQ4.setVisible(false);
                    remeasureNeeded2 = i46;
                    i2 = i$iv;
                    i31 = 0;
                    iArr11[i2] = mainAxisSizeWithSpacings6 += maxInRange-jy6DScQ3;
                    iArr4[i2] = remeasureNeeded3;
                    arr[i2].addLast(andMeasure-jy6DScQ4);
                    i$iv++;
                    i46 = l3;
                    i18 = -2;
                    i43 = 1;
                }
                scrollDelta5 = scrollDelta2;
                iArr6 = offset;
                str = length2;
                int[] iArr17 = offset2;
                int scrollDelta9 = 0;
                $i$f$debugLog4 = 0;
                while (/* condition */) {
                    while (index2 < length2) {
                        it3 = offset2;
                        initialItemsMeasured4 = 0;
                        if (it3 >= i17) {
                        } else {
                        }
                        gapDetected3 = 1;
                        index2++;
                        if (it3 <= 0) {
                        } else {
                        }
                        gapDetected3 = 0;
                    }
                    $this$all$iv3 = 0;
                    if ($this$all$iv3 != 0) {
                        break;
                    } else {
                    }
                    indexOfMinValue$default = LazyStaggeredGridMeasureKt.indexOfMinValue$default(iArr11, 0, 1, 0);
                    $this$all$iv3 = ArraysKt.maxOrThrow(iArr17);
                    length2 = $this$all$iv3 + 1;
                    if (length2 >= itemCount) {
                        break;
                    } else {
                    }
                    initialItemsMeasured2 = initialItemsMeasured;
                    i26 = initialLaneToMeasure2;
                    l8 = itemCount;
                    l = i17;
                    remeasureNeeded = str;
                    int initialItemsMeasured5 = 0;
                    l9 = -1;
                    int[] scrollDelta11 = laneToCheckForGaps;
                    int firstItemOffsets = spanRange;
                    long spanRange-lOCCd4c5 = measuredItem.getSpanRange-lOCCd4c(measuredItem.getItemProvider(), length2, indexOfMinValue$default);
                    long l19 = spanRange-lOCCd4c5;
                    int i243 = 0;
                    l10 = l19;
                    l14 = context5;
                    int i266 = 0;
                    int i271 = 0;
                    int i273 = 0;
                    laneIndex = 0;
                    i50 = $this$all$iv3;
                    int i108 = 0;
                    index$iv3 = 0;
                    if (i30 - i81 != 1) {
                    } else {
                    }
                    i41 = 0;
                    if (i41 != 0) {
                    } else {
                    }
                    l10 = 0;
                    l2 = i82;
                    i20 = (int)$i$f$getStartImpl;
                    measuredItem.getLaneInfo().setLane(length2, i20);
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem andMeasure-jy6DScQ = $this$measure.getMeasuredItemProvider().getAndMeasure-jy6DScQ(length2, spanRange-lOCCd4c5);
                    maxInRange-jy6DScQ = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(iArr11, spanRange-lOCCd4c5);
                    int i198 = 0;
                    int i233 = 0;
                    int i244 = 0;
                    long l24 = l20;
                    int i263 = 0;
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context9 = context;
                    $this$all$iv4 = initialLaneToMeasure6;
                    int i245 = 0;
                    i34 = i137;
                    int i138 = 1;
                    if (maxOffsetLane - i112 != i138) {
                    } else {
                    }
                    i58 = 0;
                    if (i58 != 0) {
                    } else {
                    }
                    $i$f$debugLog4 = 0;
                    int i199 = 0;
                    int i226 = 0;
                    gapDetected3 = l7;
                    int i234 = 0;
                    initialItemsMeasured4 = indexOfMinValue$default;
                    i42 = 0;
                    index$iv2 = i160;
                    i45 = (int)i$iv8;
                    offset = i11;
                    while (offset < i45) {
                        i42 = offset;
                        i11 = 0;
                        if ($i$f$debugLog4 != 0) {
                        }
                        iArr17[i42] = length2;
                        iArr11[i42] = mainAxisSizeWithSpacings5 += maxInRange-jy6DScQ;
                        arr[i42].addLast(andMeasure-jy6DScQ);
                        offset++;
                        i45 = gapDetected3;
                        $i$f$debugLog4[i42] = maxInRange-jy6DScQ - i252;
                    }
                    $this$measure.getLaneInfo().setGaps(length2, $i$f$debugLog4);
                    if (maxInRange-jy6DScQ < i204) {
                    } else {
                    }
                    offset2 = maxInRange-jy6DScQ;
                    l13 = $i$f$debugLog4;
                    it3 = 0;
                    measuredItem = $this$measure;
                    spanRange = firstItemOffsets;
                    str = remeasureNeeded;
                    laneToCheckForGaps = scrollDelta11;
                    scrollDelta5 = $this$all$iv4;
                    itemCount = l8;
                    i17 = l;
                    initialItemsMeasured = initialItemsMeasured2;
                    initialLaneToMeasure2 = i26;
                    int[] $i$f$debugLog7 = iArr11;
                    indexOfMinValue$default = 0;
                    index2 = 0;
                    laneInfo = 0;
                    offset = null;
                    offset2 = maxInRange-jy6DScQ;
                    l13 = $i$f$debugLog4;
                    if (iArr11[(int)offset3] <= i204) {
                    } else {
                    }
                    it3 = 0;
                    andMeasure-jy6DScQ.setVisible(false);
                    measuredItem = $this$measure;
                    spanRange = firstItemOffsets;
                    str = remeasureNeeded;
                    laneToCheckForGaps = scrollDelta11;
                    scrollDelta5 = $this$all$iv4;
                    itemCount = l8;
                    i17 = l;
                    initialItemsMeasured = initialItemsMeasured2;
                    initialLaneToMeasure2 = i26;
                    i42 = offset;
                    i11 = 0;
                    if ($i$f$debugLog4 != 0) {
                    }
                    iArr17[i42] = length2;
                    iArr11[i42] = mainAxisSizeWithSpacings5 += maxInRange-jy6DScQ;
                    arr[i42].addLast(andMeasure-jy6DScQ);
                    offset++;
                    i45 = gapDetected3;
                    $i$f$debugLog4[i42] = maxInRange-jy6DScQ - i252;
                    if ($this$measure.getLaneInfo().getGaps(length2) == null) {
                    }
                    $i$f$debugLog4 = new int[$this$measure.getLaneCount()];
                    i58 = i138;
                    i20 = -2;
                    i41 = 1;
                    ArrayDeque[] objArr = arr;
                    indexOfMinValue$default = 0;
                    index2 = 0;
                    while (index2 < objArr.length) {
                        initialItemsMeasured4 = 0;
                        index2++;
                    }
                    $this$all$iv3 = 1;
                    if ($this$all$iv3 != 0) {
                        break;
                    }
                    initialItemsMeasured4 = 0;
                    if (objArr[index2].isEmpty() == 0) {
                    } else {
                    }
                    index2++;
                    $this$all$iv3 = 0;
                    it3 = offset2;
                    initialItemsMeasured4 = 0;
                    if (it3 >= i17) {
                    } else {
                    }
                    gapDetected3 = 1;
                    if (gapDetected3 != 0) {
                    } else {
                    }
                    index2++;
                    $this$all$iv3 = 1;
                    if (it3 <= 0) {
                    } else {
                    }
                    gapDetected3 = 0;
                }
                int previousItemIndex4 = 0;
                $i$f$debugLog3 = 0;
                while ($i$f$debugLog3 < arr.length) {
                    length2 = arr[$i$f$debugLog3];
                    offset2 = 1;
                    while (length2.size() > offset2) {
                        if (!(LazyStaggeredGridMeasuredItem)length2.first().isVisible()) {
                        }
                        index2 = length2.removeFirst();
                        if ((LazyStaggeredGridMeasuredItem)index2.getSpan() != offset2) {
                        } else {
                        }
                        offset2 = 0;
                        if (offset2 == null) {
                        } else {
                        }
                        gapDetected3 = offset2[$i$f$debugLog3];
                        laneToCheckForGaps[$i$f$debugLog3] = i223 -= initialItemsMeasured4;
                        offset2 = 1;
                        gapDetected3 = 0;
                        offset2 = measuredItem.getLaneInfo().getGaps(index2.getIndex());
                    }
                    Object firstOrNull = length2.firstOrNull();
                    if ((LazyStaggeredGridMeasuredItem)firstOrNull != null) {
                    } else {
                    }
                    index2 = -1;
                    iArr6[$i$f$debugLog3] = index2;
                    $i$f$debugLog3++;
                    index2 = (LazyStaggeredGridMeasuredItem)firstOrNull.getIndex();
                    if (!(LazyStaggeredGridMeasuredItem)length2.first().isVisible()) {
                    }
                    index2 = length2.removeFirst();
                    if ((LazyStaggeredGridMeasuredItem)index2.getSpan() != offset2) {
                    } else {
                    }
                    offset2 = 0;
                    if (offset2 == null) {
                    } else {
                    }
                    gapDetected3 = offset2[$i$f$debugLog3];
                    laneToCheckForGaps[$i$f$debugLog3] = i223 -= initialItemsMeasured4;
                    gapDetected3 = 0;
                    offset2 = measuredItem.getLaneInfo().getGaps(index2.getIndex());
                }
                int[] laneIndex5 = iArr17;
                int i161 = 0;
                previousItemIndex = 0;
                while (previousItemIndex < laneIndex5.length) {
                    initialItemsMeasured4 = 0;
                    if (laneIndex5[previousItemIndex] == itemCount + -1) {
                    } else {
                    }
                    i47 = 0;
                    previousItemIndex++;
                    initialItemsMeasured = initialItemsMeasured2;
                    i47 = 1;
                }
                initialItemsMeasured2 = initialItemsMeasured;
                initialItemsMeasured3 = 0;
                if (initialItemsMeasured3 != 0) {
                    LazyStaggeredGridMeasureKt.offsetBy(iArr11, -mainAxisSpacing2);
                }
                int i95 = 0;
                int $i$f$debugLog5 = 0;
                int i114 = 0;
                i$iv5 = 0;
                while (i$iv5 < $i$f$debugLog.length) {
                    it3 = 0;
                    if ($i$f$debugLog[i$iv5] < measuredItem.getMainAxisAvailableSize()) {
                    } else {
                    }
                    i78 = 0;
                    i$iv5++;
                    $i$f$debugLog = initialItemsMeasured4;
                    i78 = 1;
                }
                initialItemsMeasured4 = $i$f$debugLog;
                $this$all$iv7 = 1;
                if ($this$all$iv7 != 0) {
                    mainAxisAvailableSize3 -= i170;
                    LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, -measuredItem2);
                    LazyStaggeredGridMeasureKt.offsetBy(iArr11, measuredItem2);
                    gapDetected2 = 0;
                    while (/* condition */) {
                        while (measure$lambda$38$misalignedStart < length13) {
                            l2 = 0;
                            if (iArr5[measure$lambda$38$misalignedStart] < measuredItem.getBeforeContentPadding()) {
                            } else {
                            }
                            i65 = 0;
                            measure$lambda$38$misalignedStart++;
                            indexOfMaxValue = maxOffsetLane;
                            measuredItem2 = $this$all$iv4;
                            i65 = 1;
                        }
                        maxOffsetLane = indexOfMaxValue;
                        $this$all$iv4 = measuredItem2;
                        laneIndex3 = 0;
                        laneIndex3 = LazyStaggeredGridMeasureKt.indexOfMinValue$default(laneToCheckForGaps, 0, 1, 0);
                        measuredItem2 = LazyStaggeredGridMeasureKt.indexOfMaxValue(iArr6);
                        if (laneIndex3 != measuredItem2) {
                        }
                        if (iArr6[laneIndex3] == -1) {
                        } else {
                        }
                        iArr5 = iArr6[laneIndex3];
                        previousItemIndex = LazyStaggeredGridMeasureKt.findPreviousItemIndex(measuredItem, iArr5, laneIndex3);
                        if (previousItemIndex < 0) {
                            break;
                        } else {
                        }
                        initialItemsMeasured4 = measuredItem2;
                        gapDetected3 = gapDetected2;
                        offset2 = iArr6;
                        long spanRange-lOCCd4c4 = measuredItem.getSpanRange-lOCCd4c(measuredItem.getItemProvider(), previousItemIndex, laneIndex3);
                        long l29 = spanRange-lOCCd4c4;
                        int i258 = 0;
                        l5 = l29;
                        i71 = context6;
                        i5 = 0;
                        int i286 = 0;
                        int i289 = 0;
                        int i291 = 0;
                        i72 = i219;
                        i39 = 0;
                        i54 = i220;
                        if (i292 - i216 != 1) {
                        } else {
                        }
                        i52 = 0;
                        if (i52 != 0) {
                        } else {
                        }
                        i71 = i218;
                        i5 = i23;
                        i6 = (int)$i$f$getStartImpl5;
                        measuredItem.getLaneInfo().setLane(previousItemIndex, i6);
                        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem andMeasure-jy6DScQ2 = measuredItem.getMeasuredItemProvider().getAndMeasure-jy6DScQ(previousItemIndex, spanRange-lOCCd4c4);
                        int maxInRange-jy6DScQ4 = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(laneToCheckForGaps, spanRange-lOCCd4c4);
                        long l30 = spanRange-lOCCd4c4;
                        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context4 = $this$measure;
                        int i249 = 0;
                        int i259 = 0;
                        int i275 = 0;
                        int i281 = 0;
                        int i280 = 0;
                        i50 = i183;
                        if (i282 - i174 != 1) {
                        } else {
                        }
                        i76 = 0;
                        if (i76 != 0) {
                        } else {
                        }
                        gaps2 = 0;
                        int i221 = 0;
                        l12 = index$iv2;
                        int i250 = 0;
                        l2 = gaps2;
                        index$iv3 = i185;
                        it3 = 0;
                        i30 = i186;
                        i$iv5 = i61;
                        while (i$iv5 < (int)i$iv9) {
                            it3 = i$iv5;
                            i61 = 0;
                            if (laneToCheckForGaps[it3] != maxInRange-jy6DScQ4) {
                            }
                            arr[it3].addFirst(andMeasure-jy6DScQ2);
                            offset2[it3] = previousItemIndex;
                            if (l2 == 0) {
                            } else {
                            }
                            i68 = l2[it3];
                            laneToCheckForGaps[it3] = i278 += i68;
                            i$iv5++;
                            laneIndex3 = l12;
                            i68 = 0;
                            gapDetected3 = 1;
                        }
                        laneIndex = laneIndex3;
                        scrollDelta5 = initialLaneToMeasure7;
                        iArr6 = offset2;
                        gapDetected2 = gapDetected3;
                        indexOfMaxValue = maxOffsetLane;
                        measuredItem2 = $this$all$iv4;
                        i17 = i62;
                        initialLaneToMeasure2 = i26;
                        iArr5 = laneToCheckForGaps;
                        previousItemIndex = 0;
                        measure$lambda$38$misalignedStart = 0;
                        it3 = i$iv5;
                        i61 = 0;
                        if (laneToCheckForGaps[it3] != maxInRange-jy6DScQ4) {
                        }
                        arr[it3].addFirst(andMeasure-jy6DScQ2);
                        offset2[it3] = previousItemIndex;
                        if (l2 == 0) {
                        } else {
                        }
                        i68 = l2[it3];
                        laneToCheckForGaps[it3] = i278 += i68;
                        i$iv5++;
                        laneIndex3 = l12;
                        i68 = 0;
                        gapDetected3 = 1;
                        gaps2 = measuredItem.getLaneInfo().getGaps(previousItemIndex);
                        i76 = 1;
                        i6 = -2;
                        i52 = 1;
                        iArr5 = itemCount;
                        if (laneToCheckForGaps[laneIndex3] == laneToCheckForGaps[measuredItem2]) {
                        } else {
                        }
                        gapDetected2 = 1;
                        laneIndex3 = measuredItem2;
                        l2 = 0;
                        if (iArr5[measure$lambda$38$misalignedStart] < measuredItem.getBeforeContentPadding()) {
                        } else {
                        }
                        i65 = 0;
                        if (i65 != 0) {
                        } else {
                        }
                        measure$lambda$38$misalignedStart++;
                        indexOfMaxValue = maxOffsetLane;
                        measuredItem2 = $this$all$iv4;
                        laneIndex3 = 1;
                        i65 = 1;
                    }
                    initialLaneToMeasure4 = initialLaneToMeasure2;
                    i32 = i17;
                    initialLaneToMeasure = scrollDelta5;
                    beforeVisibleBounds$iv2 = iArr6;
                    if (gapDetected2 != 0 && canRestartMeasure) {
                        if (canRestartMeasure) {
                            measuredItem.getLaneInfo().reset();
                            return LazyStaggeredGridMeasureKt.measure(measuredItem, initialLaneToMeasure, beforeVisibleBounds$iv2, laneToCheckForGaps, false);
                        }
                    }
                    $this$all$iv7 = LazyStaggeredGridMeasureKt.indexOfMinValue$default(laneToCheckForGaps, 0, 1, 0);
                    if (laneToCheckForGaps[$this$all$iv7] < 0) {
                        initialLaneToMeasure3 = laneToCheckForGaps[$this$all$iv7];
                        scrollDelta4 += initialLaneToMeasure3;
                        LazyStaggeredGridMeasureKt.offsetBy(iArr11, initialLaneToMeasure3);
                        LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, -initialLaneToMeasure3);
                    }
                } else {
                    initialLaneToMeasure4 = initialLaneToMeasure2;
                    i32 = i17;
                    beforeVisibleBounds$iv2 = iArr6;
                    scrollDelta4 = initialLaneToMeasure3;
                }
                int i96 = 0;
                int $i$f$debugLog6 = 0;
                int i141 = 0;
                int i146 = 0;
                if (MathKt.getSign(Math.round(measuredItem.getState().getScrollToBeConsumed$foundation_release())) == MathKt.getSign(scrollDelta4) && Math.abs(Math.round(measuredItem.getState().getScrollToBeConsumed$foundation_release())) >= Math.abs(scrollDelta4)) {
                    i146 = 0;
                    if (Math.abs(Math.round(measuredItem.getState().getScrollToBeConsumed$foundation_release())) >= Math.abs(scrollDelta4)) {
                        f2 = scrollToBeConsumed$foundation_release;
                    } else {
                        f2 = scrollToBeConsumed$foundation_release;
                    }
                } else {
                }
                f = f2;
                int[] copyOf = Arrays.copyOf(laneToCheckForGaps, laneToCheckForGaps.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, str);
                int i162 = 0;
                i$iv4 = 0;
                while (i$iv4 < copyOf.length) {
                    it3 = 0;
                    copyOf[i$iv4] = -i213;
                    i$iv4++;
                }
                int i163 = 0;
                if (measuredItem.getBeforeContentPadding() > measuredItem.getMainAxisSpacing()) {
                    laneIndex2 = 0;
                    while (laneIndex2 < arr.length) {
                        length = arr[laneIndex2];
                        i17 = 0;
                        while (i17 < length.size()) {
                            i59 = length.get(i17);
                            l11 = laneIndex2;
                            int[] gaps3 = measuredItem.getLaneInfo().getGaps((LazyStaggeredGridMeasuredItem)i59.getIndex());
                            if (gaps3 == null) {
                            } else {
                            }
                            i69 = gaps3[l11];
                            mainAxisSizeWithSpacings2 += i69;
                            i11 = gaps3;
                            laneToCheckForGaps[l11] = i117 -= laneIndex2;
                            beforeVisibleBounds$iv2[l11] = (LazyStaggeredGridMeasuredItem)length.get(i17 + 1).getIndex();
                            i17++;
                            scrollDelta4 = scrollDelta6;
                            laneIndex2 = l11;
                            i69 = 0;
                        }
                        scrollDelta6 = scrollDelta4;
                        l11 = laneIndex2;
                        laneIndex2 = l11 + 1;
                        scrollDelta4 = scrollDelta6;
                        i59 = length.get(i17);
                        l11 = laneIndex2;
                        gaps3 = measuredItem.getLaneInfo().getGaps((LazyStaggeredGridMeasuredItem)i59.getIndex());
                        if (gaps3 == null) {
                        } else {
                        }
                        i69 = gaps3[l11];
                        mainAxisSizeWithSpacings2 += i69;
                        i11 = gaps3;
                        if (i17 != CollectionsKt.getLastIndex((List)length)) {
                        } else {
                        }
                        if (laneToCheckForGaps[l11] != 0) {
                        } else {
                        }
                        if (laneToCheckForGaps[l11] >= laneIndex2) {
                        } else {
                        }
                        laneToCheckForGaps[l11] = i117 -= laneIndex2;
                        beforeVisibleBounds$iv2[l11] = (LazyStaggeredGridMeasuredItem)length.get(i17 + 1).getIndex();
                        i17++;
                        scrollDelta4 = scrollDelta6;
                        laneIndex2 = l11;
                        i69 = 0;
                    }
                    scrollDelta7 = scrollDelta4;
                    l11 = laneIndex2;
                } else {
                    scrollDelta7 = scrollDelta4;
                }
                int scrollDelta10 = 0;
                beforeContentPadding4 += afterContentPadding2;
                if (measuredItem.isVertical()) {
                    constrainWidth-K40F9xA = Constraints.getMaxWidth-impl(measuredItem.getConstraints-msEJaDk());
                } else {
                    constrainWidth-K40F9xA = ConstraintsKt.constrainWidth-K40F9xA(measuredItem.getConstraints-msEJaDk(), mainAxisSpacing);
                }
                i55 = constrainWidth-K40F9xA;
                if (measuredItem.isVertical()) {
                    i28 = constrainHeight-K40F9xA;
                } else {
                    i28 = constrainHeight-K40F9xA;
                }
                i57 = measuredItem.isVertical() ? i28 : i55;
                int i181 = 0;
                i189 += afterContentPadding3;
                int i165 = 0;
                extraItemOffset = copyOf[0];
                $this$calculateExtraItems$iv = $this$measure;
                result$iv = 0;
                int i232 = 0;
                $this$fastForEachReversed$iv$iv$iv = pinnedItems2;
                int i246 = 0;
                i38 = -1;
                if (size2-- >= 0) {
                } else {
                    contentPadding = index$iv4;
                    l8 = $this$calculateExtraItems$iv;
                    laneIndex = laneToCheckForGaps;
                    iArr6 = beforeVisibleBounds$iv2;
                    i30 = spanRange-lOCCd4c;
                    $this$all$iv4 = i48;
                    maxOffsetLane = $this$fastForEachReversed$iv$iv$iv;
                }
                if (result$iv == 0) {
                    result$iv = index$iv4;
                }
                List visibleItems = LazyStaggeredGridMeasureKt.calculateVisibleItems(measuredItem, arr, copyOf, i190);
                int i239 = 0;
                i3 = i239;
                $i$f$calculateExtraItems = 0;
                size = 0;
                $this$all$iv2 = 0;
                emptyList = $this$measure.getPinnedItems().size();
                final int[] iArr18 = copyOf;
                itemScrollOffsets = i235;
                index$iv$iv$iv2 = i201;
                result$iv2 = i14;
                while (itemScrollOffsets < emptyList) {
                    List list2 = list;
                    index$iv = (Number)list2.get(itemScrollOffsets).intValue();
                    i38 = 0;
                    l2 = 0;
                    index$iv$iv$iv = i254;
                    if (index$iv$iv$iv >= itemCount) {
                    } else {
                    }
                    if (/* condition */) {
                    } else {
                    }
                    $this$all$iv4 = $i$f$calculateExtraItems;
                    if (iArr17[lane4] < index$iv$iv$iv) {
                    } else {
                    }
                    beforeVisibleBounds$iv = 0;
                    if (beforeVisibleBounds$iv != 0) {
                    } else {
                    }
                    index$iv2 = index$iv;
                    i34 = mainAxisSizeWithSpacings;
                    i53 = spanRange;
                    l8 = itemCount;
                    itemScrollOffsets = maxOffsetLane + 1;
                    spanRange = i53;
                    emptyList = i14;
                    list = i74;
                    i3 = f2;
                    $i$f$calculateExtraItems = $this$all$iv4;
                    mainAxisSizeWithSpacings = i34;
                    itemCount = l8;
                    i53 = spanRange;
                    l8 = itemCount;
                    if (index$iv$iv$iv2 == 0) {
                    } else {
                    }
                    index$iv$iv$iv = index$iv$iv$iv2;
                    beforeVisibleBounds$iv = mainAxisSizeWithSpacings.getMeasuredItemProvider().getAndMeasure-jy6DScQ(index$iv, mainAxisSizeWithSpacings.getSpanRange-lOCCd4c(mainAxisSizeWithSpacings.getItemProvider(), index$iv, 0));
                    l2 = 0;
                    index$iv2 = index$iv;
                    i34 = mainAxisSizeWithSpacings;
                    index$iv = lazyStaggeredGridMeasuredItem2;
                    index$iv.position(result$iv2, 0, i190);
                    result$iv2 += mainAxisSizeWithSpacings;
                    index$iv$iv$iv.add(beforeVisibleBounds$iv);
                    index$iv$iv$iv2 = index$iv$iv$iv;
                    ArrayList arrayList3 = new ArrayList();
                    index$iv$iv$iv = index$iv$iv$iv2;
                    beforeVisibleBounds$iv = 1;
                    index$iv2 = 0;
                    i34 = lane4;
                    int[] lane5 = $i$f$calculateExtraItems3;
                    $this$all$iv4 = $i$f$calculateExtraItems;
                    $this$all$iv5 = 0;
                    while ($this$all$iv5 < lane5.length) {
                        l = 0;
                        if (lane5[$this$all$iv5] < index$iv$iv$iv) {
                        } else {
                        }
                        it2 = 0;
                        $this$all$iv5 = i37 + 1;
                        it2 = 1;
                    }
                    beforeVisibleBounds$iv = 1;
                    l = 0;
                    if (l8[$this$all$iv5] < index$iv$iv$iv) {
                    } else {
                    }
                    it2 = 0;
                    if (it2 == 0) {
                    } else {
                    }
                    $this$all$iv5 = i37 + 1;
                    beforeVisibleBounds$iv = 0;
                    it2 = 1;
                    f2 = i3;
                    $this$all$iv4 = $i$f$calculateExtraItems;
                    beforeVisibleBounds$iv = 0;
                }
                int i264 = itemScrollOffsets;
                int i255 = i3;
                androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context10 = mainAxisSizeWithSpacings;
                int i267 = $i$f$calculateExtraItems;
                int $i$f$calculateExtraItems2 = spanRange;
                int i277 = itemCount;
                List list5 = list;
                if (index$iv$iv$iv2 == 0) {
                    index$iv$iv$iv2 = emptyList;
                }
                ArrayList arrayList2 = new ArrayList();
                (List)arrayList2.addAll((Collection)result$iv);
                arrayList2.addAll((Collection)visibleItems);
                arrayList2.addAll((Collection)index$iv$iv$iv2);
                int i144 = 0;
                ArrayList list6 = arrayList2;
                measuredItem.getState().getItemAnimator$foundation_release().onMeasured((int)f, i55, i28, list6, measuredItem.getMeasuredItemProvider().getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItem.getMeasuredItemProvider(), measuredItem.isVertical(), false, measuredItem.getLaneCount(), false, ArraysKt.minOrThrow(laneIndex), maxOrThrow + contentPadding, measuredItem.getCoroutineScope(), measuredItem.getGraphicsContext());
                i35 = i55;
                i64 = i28;
                ArrayList list4 = list6;
                long minSizeToFitDisappearingItems-YbymL2g2 = measuredItem.getState().getItemAnimator$foundation_release().getMinSizeToFitDisappearingItems-YbymL2g();
                if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g2, itemCount)) {
                    i15 = measuredItem.isVertical() ? i64 : i35;
                    consumedScroll = f;
                    i55 = constrainWidth-K40F9xA2;
                    i28 = constrainHeight-K40F9xA2;
                    f = measuredItem.isVertical() ? i28 : i55;
                    if (f != i15) {
                        i35 = 0;
                        index$iv5 = 0;
                        while (index$iv5 < list4.size()) {
                            i14 = 0;
                            (LazyStaggeredGridMeasuredItem)i64.get(index$iv5).updateMainAxisLayoutSize(f);
                            index$iv5++;
                            i64 = $this$all$iv2;
                        }
                        $this$all$iv2 = i64;
                    }
                    i29 = i55;
                    i66 = i28;
                } else {
                    consumedScroll = f;
                    i66 = i64;
                    i29 = i35;
                }
                i8 = 0;
                i13 = 0;
                while (i13 < iArr3.length) {
                    list = null;
                    if (iArr3[i13] > measuredItem.getMainAxisAvailableSize()) {
                    } else {
                    }
                    i40 = 0;
                    i13++;
                    iArr3 = $this$all$iv2;
                    i40 = 1;
                }
                $this$all$iv2 = iArr3;
                $this$all$iv = 0;
                if ($this$all$iv == 0) {
                    i8 = 0;
                    i13 = 0;
                    while (i13 < iArr.length) {
                        list = null;
                        if (iArr[i13] < i277 + -1) {
                        } else {
                        }
                        i33 = 0;
                        i13++;
                        iArr = $this$all$iv2;
                        i33 = 1;
                    }
                    $this$all$iv2 = iArr;
                    $this$all$iv = 1;
                    if ($this$all$iv != 0) {
                        i63 = 1;
                    } else {
                        i63 = 0;
                    }
                } else {
                }
            }
            LazyStaggeredGridMeasureKt.measure.1.30 anon = new LazyStaggeredGridMeasureKt.measure.1.30(list4, measuredItem);
            int[] iArr14 = iArr6;
            LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult2 = new LazyStaggeredGridMeasureResult(iArr14, laneIndex, consumedScroll, MeasureScope.layout$default((MeasureScope)lazyLayoutMeasureScope3, i29, i66, 0, (Function1)anon, 4, 0), i63, measuredItem.isVertical(), remeasureNeeded2, measuredItem.getResolvedSlots(), measuredItem.getItemProvider().getSpanProvider(), (Density)lazyLayoutMeasureScope3, i277, visibleItems, IntSizeKt.IntSize(i29, i66), i50, i83, i32, measuredItem.getBeforeContentPadding(), measuredItem.getAfterContentPadding(), measuredItem.getMainAxisSpacing(), measuredItem.getCoroutineScope(), 0);
            int[] iArr16 = iArr14;
            return lazyStaggeredGridMeasureResult2;
        }
        itemCount2 = itemCount;
    }

    private static final boolean measure$lambda$38$hasSpaceBeforeFirst(int[] firstItemIndices, int[] firstItemOffsets, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext $this_measure) {
        int lane;
        int i2;
        int i;
        int i3;
        int i4;
        lane = 0;
        int i6 = 0;
        while (lane < firstItemIndices.length) {
            lane++;
            i6 = 0;
        }
        return i6;
    }

    private static final boolean measure$lambda$38$misalignedStart(int[] firstItemIndices, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext $this_measure, int[] firstItemOffsets, int referenceLane) {
        int lane2;
        int lane;
        int length;
        int i3;
        int i2;
        int i4;
        int previousItemIndex2;
        int previousItemIndex;
        int i;
        lane2 = 0;
        i3 = -1;
        i2 = 0;
        i4 = 1;
        while (lane2 < firstItemIndices.length) {
            if (LazyStaggeredGridMeasureKt.findPreviousItemIndex($this_measure, firstItemIndices[lane2], lane2) == i3 && firstItemOffsets[lane2] != firstItemOffsets[referenceLane]) {
            } else {
            }
            lane2++;
            i3 = -1;
            i2 = 0;
            i4 = 1;
            if (firstItemOffsets[lane2] != firstItemOffsets[referenceLane]) {
            } else {
            }
            i2 = i4;
        }
        lane = 0;
        while (lane < firstItemIndices.length) {
            if (LazyStaggeredGridMeasureKt.findPreviousItemIndex($this_measure, firstItemIndices[lane], lane) != i3 && firstItemOffsets[lane] >= firstItemOffsets[referenceLane]) {
            } else {
            }
            previousItemIndex2 = i2;
            lane++;
            if (firstItemOffsets[lane] >= firstItemOffsets[referenceLane]) {
            } else {
            }
            previousItemIndex2 = i4;
        }
        int lane3 = $this_measure.getLaneInfo().getLane(i2);
        if (lane3 != 0 && lane3 != i3 && lane3 != -2) {
            if (lane3 != i3) {
                if (lane3 != -2) {
                    i2 = i4;
                }
            }
        }
        return i2;
    }

    public static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult measureStaggeredGrid-XtK8cYQ(LazyLayoutMeasureScope $this$measureStaggeredGrid_u2dXtK8cYQ, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state, List<Integer> pinnedItems, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider itemProvider, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots resolvedSlots, long constraints, boolean isVertical, boolean reverseLayout, long contentOffset, int mainAxisAvailableSize, int mainAxisSpacing, int beforeContentPadding, int afterContentPadding, CoroutineScope coroutineScope, GraphicsContext graphicsContext) {
        int[] iArr2;
        int[] iArr;
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
            iArr = scrollPositionIfTheFirstItemWasMoved$foundation_release;
        } else {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            laneCount2 = iArr;
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
            iArr2 = scrollOffsets;
        } else {
            laneCount = iArr2;
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
        return LazyStaggeredGridMeasureKt.measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState2.getScrollToBeConsumed$foundation_release()), iArr, iArr2, i8);
    }

    private static final void offsetBy(int[] $this$offsetBy, int delta) {
        int i2;
        int i;
        i2 = 0;
        while (i2 < $this$offsetBy.length) {
            $this$offsetBy[i2] = i3 += delta;
            i2++;
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
