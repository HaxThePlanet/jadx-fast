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
        int result;
        int andMeasure-jy6DScQ;
        List index$iv$iv;
        int size;
        int i;
        int intValue;
        Object obj;
        int andMeasure-jy6DScQ2;
        Object itemProvider;
        int i2;
        Object result2;
        int $i$f$calculateExtraItems2;
        int i3;
        final Object obj2 = $this$calculateExtraItems;
        final Object obj3 = position;
        $i$f$calculateExtraItems = 0;
        result = 0;
        final List pinnedItems = obj2.getPinnedItems();
        final int i4 = 0;
        andMeasure-jy6DScQ = 0;
        if (beforeVisibleBounds) {
            index$iv$iv = pinnedItems;
            size = 0;
            if (size2-- >= 0) {
            } else {
                $i$f$calculateExtraItems2 = $i$f$calculateExtraItems;
            }
        } else {
            $i$f$calculateExtraItems2 = $i$f$calculateExtraItems;
            andMeasure-jy6DScQ = 0;
            index$iv$iv = 0;
            while (index$iv$iv < pinnedItems.size()) {
                intValue = (Number)$i$f$calculateExtraItems.get(index$iv$iv).intValue();
                obj = 0;
                if ((Boolean)spanRange-lOCCd4c.invoke(Integer.valueOf(intValue)).booleanValue()) {
                } else {
                }
                result2 = $i$f$calculateExtraItems;
                i2 = 0;
                index$iv$iv++;
                spanRange-lOCCd4c = filter;
                $i$f$calculateExtraItems = result2;
                result2 = $i$f$calculateExtraItems;
                if (result == null) {
                }
                andMeasure-jy6DScQ2 = obj2.getMeasuredItemProvider().getAndMeasure-jy6DScQ(intValue, obj2.getSpanRange-lOCCd4c(obj2.getItemProvider(), intValue, 0));
                obj3.invoke(andMeasure-jy6DScQ2);
                result.add(andMeasure-jy6DScQ2);
                itemProvider = new ArrayList();
                result = itemProvider;
            }
            result2 = $i$f$calculateExtraItems;
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
        int i3;
        int min$iv;
        int i2;
        int i$iv2;
        int length;
        int i5;
        boolean empty;
        int index;
        int i6;
        long l;
        long l3;
        int i7;
        long l2;
        int i;
        int i4;
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
            while (i2 < length3) {
                i5 = 0;
                i2++;
            }
            i3 = 0;
            if (i3 != 0) {
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
            i6 = 0;
            int i14 = 0;
            int i15 = 0;
            i$iv = (int)i10;
            first = 0;
            i7 = 0;
            while (i$iv < (int)i8) {
                first = 0;
                itemScrollOffsets[i$iv] = mainAxisSizeWithSpacings += maxInRange-jy6DScQ;
                i$iv++;
            }
            objArr = measuredItems;
            lArr = itemScrollOffsets;
            Object[] objArr2 = measuredItems;
            int i11 = 0;
            i2 = 0;
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
            i5 = 0;
            if (!(Collection)objArr2[i2].isEmpty()) {
            } else {
            }
            i2++;
            i3 = 1;
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
        int i;
        int i2;
        int previousItemIndex;
        int assignedToLane;
        int i3;
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
        int i2;
        int i;
        result = -1;
        max = Integer.MIN_VALUE;
        i2 = 0;
        while (i2 < $this$indexOfMaxValue.length) {
            if (max < $this$indexOfMaxValue[i2]) {
            }
            i2++;
            max = $this$indexOfMaxValue[i2];
            result = i2;
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
        int i4;
        int i;
        int i2;
        int i3;
        result = -1;
        min = Integer.MAX_VALUE;
        i4 = 0;
        while (i4 < $this$indexOfMinValue.length) {
            i2 = $this$indexOfMinValue[i4];
            i3 = 0;
            if (minBound + 1 <= i2 && i2 < min) {
            }
            if (i3 != 0) {
            }
            i4++;
            min = $this$indexOfMinValue[i4];
            result = i4;
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
        int i64;
        int i19;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider itemProvider;
        int previousItemIndex2;
        int initialItemsMeasured3;
        int i5;
        int i2;
        long i63;
        int maxInRange-jy6DScQ;
        int i39;
        int initialItemsMeasured4;
        int[] $i$f$debugLog4;
        int $this$all$iv5;
        float scrollToBeConsumed$foundation_release;
        float f;
        int[] iArr3;
        int $this$all$iv6;
        int[] iArr2;
        int i8;
        int i9;
        int sign;
        int indexOfMaxValue;
        int laneIndex2;
        int i44;
        int i6;
        int i69;
        int scrollDelta7;
        boolean constraints-msEJaDk;
        int[] i$iv4;
        int scrollDelta5;
        int i$iv5;
        int $i$f$debugLog2;
        int $this$all$iv7;
        int i55;
        int $i$f$debugLog;
        int scrollDelta6;
        int index$iv3;
        int emptyList;
        int index$iv5;
        int i40;
        int i56;
        int measuredItem2;
        int i48;
        int i71;
        int gaps2;
        int i$iv;
        int[] $i$f$forEachNIS5qE8;
        int initialLaneToMeasure3;
        int i54;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo laneInfo;
        int initialLaneToMeasure5;
        int sign2;
        int itemScrollOffsets;
        int index$iv$iv$iv;
        int initialLaneToMeasure;
        int initialLaneToMeasure4;
        int i78;
        int layoutWidth;
        int[] offset2;
        int i42;
        int i47;
        int indexOfMinValue$default2;
        int gapDetected2;
        int laneIndex;
        int constrainWidth-K40F9xA;
        int constrainHeight-K40F9xA;
        int i30;
        int extraItemOffset;
        int i34;
        int i14;
        int $this$all$iv3;
        int it;
        int i28;
        int $this$all$iv4;
        int it3;
        int beforeVisibleBounds$iv2;
        int i11;
        int length3;
        int i21;
        int gaps;
        int gapDetected;
        int layoutHeight;
        String length4;
        int i7;
        int i50;
        int i$iv3;
        int i$iv2;
        int mainAxisSpacing;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem $this$calculateExtraItems$iv;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext mainAxisSizeWithSpacings;
        boolean equals-impl0;
        int i15;
        int i67;
        int iArr6;
        ArrayList height-impl;
        int[] laneToCheckForGaps;
        int $i$f$calculateExtraItems;
        int i53;
        int i16;
        int remeasureNeeded3;
        int remeasureNeeded;
        int index2;
        int previousItemIndex;
        int length;
        int visible;
        int i17;
        int $i$f$debugLog3;
        int[] offset;
        int i41;
        int[] beforeVisibleBounds$iv;
        int result$iv2;
        int i45;
        int measure$lambda$38$hasSpaceBeforeFirst;
        int spanRange;
        int itemCount;
        ArrayDeque spanRange-lOCCd4c2;
        int i43;
        int i24;
        int length2;
        int i70;
        int i52;
        long l8;
        int spanRange-lOCCd4c;
        long index$iv2;
        int i68;
        int i57;
        int i79;
        int it2;
        int i60;
        int size;
        int measure$lambda$38$misalignedStart;
        int i51;
        int index;
        long l11;
        int i33;
        int i18;
        int i61;
        int result$iv;
        int scrollDelta;
        int scrollDelta3;
        long l3;
        List list;
        int i62;
        int $this$all$iv2;
        int i23;
        int i72;
        List $this$fastForEachReversed$iv$iv$iv;
        int index$iv$iv$iv2;
        int i65;
        int scrollDelta4;
        int initialItemsMeasured;
        int i73;
        long l;
        int i12;
        int indexOfMinValue$default;
        int scrollDelta2;
        int i74;
        int i66;
        int gapDetected3;
        int l9;
        float f2;
        float consumedScroll;
        long l15;
        long l10;
        int maxOffsetLane;
        long l2;
        int i46;
        long l12;
        int $this$all$iv;
        int i26;
        int[] i20;
        int i13;
        int remeasureNeeded2;
        int i22;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem index$iv;
        long l6;
        int i25;
        long l7;
        int laneIndex3;
        long l4;
        long l5;
        int itemCount2;
        long l14;
        int index$iv4;
        int i31;
        int i27;
        int i59;
        int i;
        int i36;
        int i3;
        long l13;
        int i49;
        int i75;
        int[] iArr5;
        int[] iArr4;
        String str2;
        String str;
        int i4;
        int i58;
        int[] iArr;
        int initialItemsMeasured2;
        int i76;
        int initialLaneToMeasure2;
        int i77;
        int i32;
        int i35;
        int i29;
        int i37;
        int i38;
        int i10;
        int contentPadding;
        measuredItem = $this$measure;
        i$iv4 = initialItemIndices;
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
                    i16 = layoutWidth;
                    i17 = layoutHeight;
                } else {
                    i16 = layoutWidth;
                    i17 = layoutHeight;
                }
                int i242 = i16;
                int i248 = i17;
                long l23 = l17;
                LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult = new LazyStaggeredGridMeasureResult(initialItemIndices, initialItemOffsets, 0, MeasureScope.layout$default((MeasureScope)lazyLayoutMeasureScope3, i16, i17, 0, (Function1)LazyStaggeredGridMeasureKt.measure.1.1.INSTANCE, 4, 0), 0, $this$measure.isVertical(), 0, $this$measure.getResolvedSlots(), $this$measure.getItemProvider().getSpanProvider(), (Density)lazyLayoutMeasureScope3, itemCount2, CollectionsKt.emptyList(), IntSizeKt.IntSize(Constraints.getMinWidth-impl($this$measure.getConstraints-msEJaDk()), Constraints.getMinHeight-impl($this$measure.getConstraints-msEJaDk())), coroutineScope, -beforeContentPadding3, mainAxisAvailableSize4 + afterContentPadding, $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), $this$measure.getMainAxisSpacing(), $this$measure.getCoroutineScope(), 0);
                return lazyStaggeredGridMeasureResult;
            } else {
                offset2 = Arrays.copyOf(i$iv4, i$iv4.length);
                length4 = "copyOf(this, size)";
                Intrinsics.checkNotNullExpressionValue(offset2, length4);
                laneToCheckForGaps = Arrays.copyOf($i$f$forEachNIS5qE8, $i$f$forEachNIS5qE8.length);
                Intrinsics.checkNotNullExpressionValue(laneToCheckForGaps, length4);
                remeasureNeeded3 = 0;
                LazyStaggeredGridMeasureKt.ensureIndicesInRange(measuredItem, offset2, itemCount);
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
                $i$f$debugLog3 = -1;
                i61 = 32;
                while (LazyStaggeredGridMeasureKt.measure$lambda$38$hasSpaceBeforeFirst(offset2, laneToCheckForGaps, measuredItem)) {
                    measure$lambda$38$hasSpaceBeforeFirst = LazyStaggeredGridMeasureKt.indexOfMaxValue(offset2);
                    l3 = 4294967295L;
                    length2 = laneToCheckForGaps.length;
                    i45 = l11;
                    i65 = 0;
                    while (i45 < length2) {
                        if (offset2[i45] != offset2[measure$lambda$38$hasSpaceBeforeFirst] && laneToCheckForGaps[i45] < laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst]) {
                        }
                        i45++;
                        previousItemIndex2 = scrollDelta4;
                        if (laneToCheckForGaps[i45] < laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst]) {
                        }
                        laneToCheckForGaps[i45] = laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst];
                    }
                    previousItemIndex2 = LazyStaggeredGridMeasureKt.findPreviousItemIndex(measuredItem, offset2[measure$lambda$38$hasSpaceBeforeFirst], measure$lambda$38$hasSpaceBeforeFirst);
                    if (previousItemIndex2 < 0) {
                        break;
                    } else {
                    }
                    spanRange-lOCCd4c2 = measuredItem.getSpanRange-lOCCd4c(measuredItem.getItemProvider(), previousItemIndex2, measure$lambda$38$hasSpaceBeforeFirst);
                    long l21 = spanRange-lOCCd4c2;
                    int i260 = 0;
                    l12 = l21;
                    i22 = context7;
                    int i272 = 0;
                    int i274 = 0;
                    int i276 = 0;
                    int i283 = 0;
                    index$iv4 = 0;
                    i3 = i150;
                    if (i - i125 != 1) {
                    } else {
                    }
                    i48 = i65;
                    if (i48 != 0) {
                    } else {
                    }
                    scrollDelta = i132;
                    i22 = i78;
                    i71 = (int)$i$f$getStartImpl3;
                    measuredItem.getLaneInfo().setLane(previousItemIndex2, i71);
                    long l22 = spanRange-lOCCd4c2;
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context3 = $this$measure;
                    int i230 = 0;
                    int i257 = 0;
                    int i261 = 0;
                    int i268 = 0;
                    $this$all$iv = 0;
                    laneIndex3 = i151;
                    if (i13 - i129 != 1) {
                    } else {
                    }
                    i18 = i65;
                    if (i18 != 0) {
                    } else {
                    }
                    gaps2 = 0;
                    l = spanRange-lOCCd4c2;
                    int i153 = 0;
                    int i205 = 0;
                    int i228 = 0;
                    scrollDelta = gaps2;
                    i45 = 0;
                    gapDetected3 = i131;
                    i$iv = i72;
                    while (i$iv < (int)i$iv7) {
                        i45 = i$iv;
                        l11 = 0L;
                        offset2[i45] = previousItemIndex2;
                        if (scrollDelta == 0) {
                        } else {
                        }
                        i61 = scrollDelta[i45];
                        i231 += i61;
                        laneToCheckForGaps[i45] = l3;
                        if (mainAxisAvailableSize7 += l3 <= 0) {
                        }
                        i$iv++;
                        remeasureNeeded3 = 1;
                        i61 = i65;
                    }
                    i$iv4 = initialItemIndices;
                    $i$f$forEachNIS5qE8 = initialItemOffsets;
                    previousItemIndex2 = scrollDelta4;
                    i61 = 32;
                    i45 = i$iv;
                    l11 = 0L;
                    offset2[i45] = maxOffsetLane;
                    if (scrollDelta == 0) {
                    } else {
                    }
                    i61 = scrollDelta[i45];
                    i231 += i61;
                    laneToCheckForGaps[i45] = l3;
                    if (mainAxisAvailableSize7 += l3 <= 0) {
                    }
                    i$iv++;
                    remeasureNeeded3 = 1;
                    i61 = i65;
                    gaps2 = measuredItem.getLaneInfo().getGaps(previousItemIndex2);
                    i18 = 1;
                    i71 = -2;
                    i48 = 1;
                    if (offset2[i45] != offset2[measure$lambda$38$hasSpaceBeforeFirst] && laneToCheckForGaps[i45] < laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst]) {
                    }
                    i45++;
                    previousItemIndex2 = scrollDelta4;
                    if (laneToCheckForGaps[i45] < laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst]) {
                    }
                    laneToCheckForGaps[i45] = laneToCheckForGaps[measure$lambda$38$hasSpaceBeforeFirst];
                }
                scrollDelta4 = previousItemIndex2;
                l3 = 4294967295L;
                i65 = 0;
                int scrollDelta8 = 0;
                int i83 = -beforeContentPadding;
                if (laneToCheckForGaps[i65] < i83) {
                    i121 += scrollDelta4;
                    LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, i83 - i148);
                    $i$f$forEachNIS5qE8 = 0;
                } else {
                    scrollDelta5 = scrollDelta4;
                }
                LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, measuredItem.getBeforeContentPadding());
                int i134 = -1;
                if ($i$f$debugLog3 == i134) {
                    spanRange = ArraysKt.indexOf(offset2, i65);
                } else {
                    spanRange = $i$f$debugLog3;
                }
                $i$f$debugLog3 = spanRange;
                if (spanRange != i134 && LazyStaggeredGridMeasureKt.measure$lambda$38$misalignedStart(offset2, measuredItem, laneToCheckForGaps, $i$f$debugLog3) && canRestartMeasure) {
                    $i$f$debugLog3 = spanRange;
                    if (LazyStaggeredGridMeasureKt.measure$lambda$38$misalignedStart(offset2, measuredItem, laneToCheckForGaps, $i$f$debugLog3)) {
                        if (canRestartMeasure) {
                            measuredItem.getLaneInfo().reset();
                            int length10 = offset2.length;
                            int[] iArr10 = new int[length10];
                            i43 = 0;
                            while (i43 < length10) {
                                iArr10[i43] = i134;
                                i43++;
                            }
                            int length5 = laneToCheckForGaps.length;
                            int[] iArr9 = new int[length5];
                            i24 = 0;
                            while (i24 < length5) {
                                iArr9[i24] = laneToCheckForGaps[$i$f$debugLog3];
                                i24++;
                            }
                            return LazyStaggeredGridMeasureKt.measure(measuredItem, scrollDelta5, iArr10, iArr9, false);
                        }
                    }
                }
                offset = Arrays.copyOf(offset2, offset2.length);
                Intrinsics.checkNotNullExpressionValue(offset, length4);
                int length14 = laneToCheckForGaps.length;
                int[] iArr11 = new int[length14];
                i70 = 0;
                while (i70 < length14) {
                    iArr11[i70] = -i224;
                    i70++;
                }
                mainAxisSpacing3 += i83;
                it2 = 0;
                i52 = RangesKt.coerceAtLeast(mainAxisAvailableSize6 += afterContentPadding4, it2);
                int i237 = 0;
                remeasureNeeded2 = remeasureNeeded3;
                initialItemsMeasured3 = initialItemsMeasured;
                initialLaneToMeasure3 = indexOfMinValue$default;
                while (initialLaneToMeasure3 != -1) {
                    if (initialItemsMeasured3 < measuredItem.getLaneCount()) {
                    }
                    remeasureNeeded3 = offset[initialLaneToMeasure3];
                    initialLaneToMeasure3 = LazyStaggeredGridMeasureKt.indexOfMinValue(offset, remeasureNeeded3);
                    initialItemsMeasured3++;
                    if (remeasureNeeded3 >= 0) {
                    } else {
                    }
                    initialItemsMeasured = initialItemsMeasured3;
                    indexOfMinValue$default = scrollDelta5;
                    gapDetected3 = initialLaneToMeasure3;
                    iArr5 = offset2;
                    str2 = length4;
                    iArr = offset;
                    indexOfMinValue$default = scrollDelta5;
                    long spanRange-lOCCd4c3 = measuredItem.getSpanRange-lOCCd4c(measuredItem.getItemProvider(), remeasureNeeded3, initialLaneToMeasure3);
                    gapDetected3 = initialLaneToMeasure3;
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem andMeasure-jy6DScQ4 = measuredItem.getMeasuredItemProvider().getAndMeasure-jy6DScQ(remeasureNeeded3, spanRange-lOCCd4c3);
                    iArr = offset;
                    long l26 = spanRange-lOCCd4c3;
                    int i269 = 0;
                    l14 = context8;
                    i31 = 0;
                    i = 0;
                    int i284 = 0;
                    l13 = l7;
                    int i290 = 0;
                    iArr5 = offset2;
                    str2 = length4;
                    int i285 = 0;
                    i4 = i179;
                    if (i75 - i157 != 1) {
                    } else {
                    }
                    i42 = 0;
                    if (i42 != 0) {
                    } else {
                    }
                    l14 = i159;
                    i31 = i7;
                    i47 = (int)$i$f$getStartImpl4;
                    measuredItem.getLaneInfo().setLane(remeasureNeeded3, i47);
                    int maxInRange-jy6DScQ3 = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(iArr11, spanRange-lOCCd4c3);
                    i50 = 0;
                    int i196 = 0;
                    l6 = l10;
                    int i265 = 0;
                    laneIndex3 = spanRange-lOCCd4c3;
                    i41 = 0;
                    int i279 = i104;
                    i5 = (int)i$iv6;
                    i$iv5 = i26;
                    while (i$iv5 < i5) {
                        i41 = i$iv5;
                        i26 = 0;
                        iArr11[i41] = mainAxisSizeWithSpacings6 += maxInRange-jy6DScQ3;
                        iArr[i41] = remeasureNeeded3;
                        arr[i41].addLast(andMeasure-jy6DScQ4);
                        i$iv5++;
                        i5 = l6;
                    }
                    i50 = i89;
                    i41 = i$iv5;
                    if (maxInRange-jy6DScQ3 < i204 && iArr11[(int)$i$f$getStartImpl2] <= i204) {
                    }
                    long l16 = laneIndex3;
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context2 = $this$measure;
                    int i197 = 0;
                    l15 = 0;
                    int i262 = 0;
                    $this$all$iv = 0;
                    index$iv = 0;
                    i3 = i105;
                    if (i25 - i87 != 1) {
                    } else {
                    }
                    i2 = 0;
                    if (i2 != 0) {
                    } else {
                    }
                    initialItemsMeasured3 = initialItemsMeasured;
                    scrollDelta5 = indexOfMinValue$default;
                    initialLaneToMeasure3 = gapDetected3;
                    offset2 = iArr5;
                    length4 = str2;
                    offset = iArr;
                    initialItemsMeasured3 = measuredItem.getLaneCount();
                    scrollDelta5 = indexOfMinValue$default;
                    initialLaneToMeasure3 = gapDetected3;
                    offset2 = iArr5;
                    length4 = str2;
                    offset = iArr;
                    i2 = 1;
                    i50 = i89;
                    i41 = i$iv5;
                    if (iArr11[(int)$i$f$getStartImpl2] <= i204) {
                    }
                    andMeasure-jy6DScQ4.setVisible(false);
                    remeasureNeeded2 = i5;
                    i41 = i$iv5;
                    i26 = 0;
                    iArr11[i41] = mainAxisSizeWithSpacings6 += maxInRange-jy6DScQ3;
                    iArr[i41] = remeasureNeeded3;
                    arr[i41].addLast(andMeasure-jy6DScQ4);
                    i$iv5++;
                    i5 = l6;
                    i47 = -2;
                    i42 = 1;
                }
                scrollDelta2 = scrollDelta5;
                iArr4 = offset2;
                str = length4;
                int[] iArr17 = offset;
                int scrollDelta9 = 0;
                $i$f$debugLog2 = 0;
                while (/* condition */) {
                    while (index2 < length4) {
                        it2 = offset;
                        initialItemsMeasured = 0;
                        if (it2 >= i52) {
                        } else {
                        }
                        gapDetected3 = 1;
                        index2++;
                        if (it2 <= 0) {
                        } else {
                        }
                        gapDetected3 = 0;
                    }
                    $this$all$iv7 = 0;
                    if ($this$all$iv7 != 0) {
                        break;
                    } else {
                    }
                    indexOfMinValue$default2 = LazyStaggeredGridMeasureKt.indexOfMinValue$default(iArr11, 0, 1, 0);
                    $this$all$iv7 = ArraysKt.maxOrThrow(iArr17);
                    length4 = $this$all$iv7 + 1;
                    if (length4 >= itemCount) {
                        break;
                    } else {
                    }
                    initialItemsMeasured2 = initialItemsMeasured3;
                    i76 = initialLaneToMeasure3;
                    l14 = itemCount;
                    l13 = i52;
                    remeasureNeeded = str;
                    int initialItemsMeasured5 = 0;
                    l = -1;
                    int[] scrollDelta11 = laneToCheckForGaps;
                    int firstItemOffsets = spanRange;
                    long spanRange-lOCCd4c5 = measuredItem.getSpanRange-lOCCd4c(measuredItem.getItemProvider(), length4, indexOfMinValue$default2);
                    long l19 = spanRange-lOCCd4c5;
                    int i243 = 0;
                    l9 = l19;
                    l2 = context5;
                    int i266 = 0;
                    int i271 = 0;
                    int i273 = 0;
                    laneIndex3 = 0;
                    i3 = $this$all$iv7;
                    int i108 = 0;
                    index$iv4 = 0;
                    if (i - i81 != 1) {
                    } else {
                    }
                    i64 = 0;
                    if (i64 != 0) {
                    } else {
                    }
                    l9 = 0;
                    l15 = i82;
                    i19 = (int)$i$f$getStartImpl;
                    measuredItem.getLaneInfo().setLane(length4, i19);
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem andMeasure-jy6DScQ = $this$measure.getMeasuredItemProvider().getAndMeasure-jy6DScQ(length4, spanRange-lOCCd4c5);
                    maxInRange-jy6DScQ = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(iArr11, spanRange-lOCCd4c5);
                    int i198 = 0;
                    int i233 = 0;
                    int i244 = 0;
                    long l24 = l20;
                    int i263 = 0;
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context9 = context;
                    $this$all$iv = initialLaneToMeasure6;
                    int i245 = 0;
                    i25 = i137;
                    int i138 = 1;
                    if (maxOffsetLane - i112 != i138) {
                    } else {
                    }
                    i55 = 0;
                    if (i55 != 0) {
                    } else {
                    }
                    $i$f$debugLog2 = 0;
                    int i199 = 0;
                    int i226 = 0;
                    gapDetected3 = l8;
                    int i234 = 0;
                    initialItemsMeasured = indexOfMinValue$default2;
                    i33 = 0;
                    index$iv = i160;
                    i54 = (int)i$iv8;
                    offset2 = i72;
                    while (offset2 < i54) {
                        i33 = offset2;
                        i72 = 0;
                        if ($i$f$debugLog2 != 0) {
                        }
                        iArr17[i33] = length4;
                        iArr11[i33] = mainAxisSizeWithSpacings5 += maxInRange-jy6DScQ;
                        arr[i33].addLast(andMeasure-jy6DScQ);
                        offset2++;
                        i54 = gapDetected3;
                        $i$f$debugLog2[i33] = maxInRange-jy6DScQ - i252;
                    }
                    $this$measure.getLaneInfo().setGaps(length4, $i$f$debugLog2);
                    if (maxInRange-jy6DScQ < i204) {
                    } else {
                    }
                    offset = maxInRange-jy6DScQ;
                    l11 = $i$f$debugLog2;
                    it2 = 0;
                    measuredItem = $this$measure;
                    spanRange = firstItemOffsets;
                    str = remeasureNeeded;
                    laneToCheckForGaps = scrollDelta11;
                    scrollDelta2 = $this$all$iv;
                    itemCount = l14;
                    i52 = l13;
                    initialItemsMeasured3 = initialItemsMeasured2;
                    initialLaneToMeasure3 = i76;
                    int[] $i$f$debugLog7 = iArr11;
                    indexOfMinValue$default2 = 0;
                    index2 = 0;
                    laneInfo = 0;
                    offset2 = null;
                    offset = maxInRange-jy6DScQ;
                    l11 = $i$f$debugLog2;
                    if (iArr11[(int)offset3] <= i204) {
                    } else {
                    }
                    it2 = 0;
                    andMeasure-jy6DScQ.setVisible(false);
                    measuredItem = $this$measure;
                    spanRange = firstItemOffsets;
                    str = remeasureNeeded;
                    laneToCheckForGaps = scrollDelta11;
                    scrollDelta2 = $this$all$iv;
                    itemCount = l14;
                    i52 = l13;
                    initialItemsMeasured3 = initialItemsMeasured2;
                    initialLaneToMeasure3 = i76;
                    i33 = offset2;
                    i72 = 0;
                    if ($i$f$debugLog2 != 0) {
                    }
                    iArr17[i33] = length4;
                    iArr11[i33] = mainAxisSizeWithSpacings5 += maxInRange-jy6DScQ;
                    arr[i33].addLast(andMeasure-jy6DScQ);
                    offset2++;
                    i54 = gapDetected3;
                    $i$f$debugLog2[i33] = maxInRange-jy6DScQ - i252;
                    if ($this$measure.getLaneInfo().getGaps(length4) == null) {
                    }
                    $i$f$debugLog2 = new int[$this$measure.getLaneCount()];
                    i55 = i138;
                    i19 = -2;
                    i64 = 1;
                    ArrayDeque[] objArr = arr;
                    indexOfMinValue$default2 = 0;
                    index2 = 0;
                    while (index2 < objArr.length) {
                        initialItemsMeasured = 0;
                        index2++;
                    }
                    $this$all$iv7 = 1;
                    if ($this$all$iv7 != 0) {
                        break;
                    }
                    initialItemsMeasured = 0;
                    if (objArr[index2].isEmpty() == 0) {
                    } else {
                    }
                    index2++;
                    $this$all$iv7 = 0;
                    it2 = offset;
                    initialItemsMeasured = 0;
                    if (it2 >= i52) {
                    } else {
                    }
                    gapDetected3 = 1;
                    if (gapDetected3 != 0) {
                    } else {
                    }
                    index2++;
                    $this$all$iv7 = 1;
                    if (it2 <= 0) {
                    } else {
                    }
                    gapDetected3 = 0;
                }
                int previousItemIndex4 = 0;
                $i$f$debugLog = 0;
                while ($i$f$debugLog < arr.length) {
                    length4 = arr[$i$f$debugLog];
                    offset = 1;
                    while (length4.size() > offset) {
                        if (!(LazyStaggeredGridMeasuredItem)length4.first().isVisible()) {
                        }
                        index2 = length4.removeFirst();
                        if ((LazyStaggeredGridMeasuredItem)index2.getSpan() != offset) {
                        } else {
                        }
                        offset = 0;
                        if (offset == null) {
                        } else {
                        }
                        gapDetected3 = offset[$i$f$debugLog];
                        laneToCheckForGaps[$i$f$debugLog] = i223 -= initialItemsMeasured;
                        offset = 1;
                        gapDetected3 = 0;
                        offset = measuredItem.getLaneInfo().getGaps(index2.getIndex());
                    }
                    Object firstOrNull = length4.firstOrNull();
                    if ((LazyStaggeredGridMeasuredItem)firstOrNull != null) {
                    } else {
                    }
                    index2 = -1;
                    iArr4[$i$f$debugLog] = index2;
                    $i$f$debugLog++;
                    index2 = (LazyStaggeredGridMeasuredItem)firstOrNull.getIndex();
                    if (!(LazyStaggeredGridMeasuredItem)length4.first().isVisible()) {
                    }
                    index2 = length4.removeFirst();
                    if ((LazyStaggeredGridMeasuredItem)index2.getSpan() != offset) {
                    } else {
                    }
                    offset = 0;
                    if (offset == null) {
                    } else {
                    }
                    gapDetected3 = offset[$i$f$debugLog];
                    laneToCheckForGaps[$i$f$debugLog] = i223 -= initialItemsMeasured;
                    gapDetected3 = 0;
                    offset = measuredItem.getLaneInfo().getGaps(index2.getIndex());
                }
                int[] laneIndex5 = iArr17;
                int i161 = 0;
                previousItemIndex = 0;
                while (previousItemIndex < laneIndex5.length) {
                    initialItemsMeasured = 0;
                    if (laneIndex5[previousItemIndex] == itemCount + -1) {
                    } else {
                    }
                    i39 = 0;
                    previousItemIndex++;
                    initialItemsMeasured3 = initialItemsMeasured2;
                    i39 = 1;
                }
                initialItemsMeasured2 = initialItemsMeasured3;
                initialItemsMeasured4 = 0;
                if (initialItemsMeasured4 != 0) {
                    LazyStaggeredGridMeasureKt.offsetBy(iArr11, -mainAxisSpacing2);
                }
                int i95 = 0;
                int $i$f$debugLog5 = 0;
                int i114 = 0;
                i$iv3 = 0;
                while (i$iv3 < $i$f$debugLog4.length) {
                    it2 = 0;
                    if ($i$f$debugLog4[i$iv3] < measuredItem.getMainAxisAvailableSize()) {
                    } else {
                    }
                    i69 = 0;
                    i$iv3++;
                    $i$f$debugLog4 = initialItemsMeasured;
                    i69 = 1;
                }
                initialItemsMeasured = $i$f$debugLog4;
                $this$all$iv5 = 1;
                if ($this$all$iv5 != 0) {
                    mainAxisAvailableSize3 -= i170;
                    LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, -measuredItem2);
                    LazyStaggeredGridMeasureKt.offsetBy(iArr11, measuredItem2);
                    gapDetected2 = 0;
                    while (/* condition */) {
                        while (measure$lambda$38$misalignedStart < length13) {
                            l15 = 0;
                            if (iArr6[measure$lambda$38$misalignedStart] < measuredItem.getBeforeContentPadding()) {
                            } else {
                            }
                            i6 = 0;
                            measure$lambda$38$misalignedStart++;
                            indexOfMaxValue = maxOffsetLane;
                            measuredItem2 = $this$all$iv;
                            i6 = 1;
                        }
                        maxOffsetLane = indexOfMaxValue;
                        $this$all$iv = measuredItem2;
                        laneIndex2 = 0;
                        laneIndex2 = LazyStaggeredGridMeasureKt.indexOfMinValue$default(laneToCheckForGaps, 0, 1, 0);
                        measuredItem2 = LazyStaggeredGridMeasureKt.indexOfMaxValue(iArr4);
                        if (laneIndex2 != measuredItem2) {
                        }
                        if (iArr4[laneIndex2] == -1) {
                        } else {
                        }
                        iArr6 = iArr4[laneIndex2];
                        previousItemIndex = LazyStaggeredGridMeasureKt.findPreviousItemIndex(measuredItem, iArr6, laneIndex2);
                        if (previousItemIndex < 0) {
                            break;
                        } else {
                        }
                        initialItemsMeasured = measuredItem2;
                        gapDetected3 = gapDetected2;
                        offset = iArr4;
                        long spanRange-lOCCd4c4 = measuredItem.getSpanRange-lOCCd4c(measuredItem.getItemProvider(), previousItemIndex, laneIndex2);
                        long l29 = spanRange-lOCCd4c4;
                        int i258 = 0;
                        l4 = l29;
                        i59 = context6;
                        i36 = 0;
                        int i286 = 0;
                        int i289 = 0;
                        int i291 = 0;
                        i77 = i219;
                        i75 = 0;
                        i32 = i220;
                        if (i292 - i216 != 1) {
                        } else {
                        }
                        i68 = 0;
                        if (i68 != 0) {
                        } else {
                        }
                        i59 = i218;
                        i36 = i51;
                        i57 = (int)$i$f$getStartImpl5;
                        measuredItem.getLaneInfo().setLane(previousItemIndex, i57);
                        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem andMeasure-jy6DScQ2 = measuredItem.getMeasuredItemProvider().getAndMeasure-jy6DScQ(previousItemIndex, spanRange-lOCCd4c4);
                        int maxInRange-jy6DScQ4 = LazyStaggeredGridMeasureKt.maxInRange-jy6DScQ(laneToCheckForGaps, spanRange-lOCCd4c4);
                        long l30 = spanRange-lOCCd4c4;
                        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext context4 = $this$measure;
                        int i249 = 0;
                        int i259 = 0;
                        int i275 = 0;
                        int i281 = 0;
                        int i280 = 0;
                        i3 = i183;
                        if (i282 - i174 != 1) {
                        } else {
                        }
                        i21 = 0;
                        if (i21 != 0) {
                        } else {
                        }
                        gaps = 0;
                        int i221 = 0;
                        l5 = index$iv;
                        int i250 = 0;
                        l15 = gaps;
                        index$iv4 = i185;
                        it2 = 0;
                        i = i186;
                        i$iv3 = i66;
                        while (i$iv3 < (int)i$iv9) {
                            it2 = i$iv3;
                            i66 = 0;
                            if (laneToCheckForGaps[it2] != maxInRange-jy6DScQ4) {
                            }
                            arr[it2].addFirst(andMeasure-jy6DScQ2);
                            offset[it2] = previousItemIndex;
                            if (l15 == 0) {
                            } else {
                            }
                            i44 = l15[it2];
                            laneToCheckForGaps[it2] = i278 += i44;
                            i$iv3++;
                            laneIndex2 = l5;
                            i44 = 0;
                            gapDetected3 = 1;
                        }
                        laneIndex3 = laneIndex2;
                        scrollDelta2 = initialLaneToMeasure7;
                        iArr4 = offset;
                        gapDetected2 = gapDetected3;
                        indexOfMaxValue = maxOffsetLane;
                        measuredItem2 = $this$all$iv;
                        i52 = i4;
                        initialLaneToMeasure3 = i76;
                        iArr6 = laneToCheckForGaps;
                        previousItemIndex = 0;
                        measure$lambda$38$misalignedStart = 0;
                        it2 = i$iv3;
                        i66 = 0;
                        if (laneToCheckForGaps[it2] != maxInRange-jy6DScQ4) {
                        }
                        arr[it2].addFirst(andMeasure-jy6DScQ2);
                        offset[it2] = previousItemIndex;
                        if (l15 == 0) {
                        } else {
                        }
                        i44 = l15[it2];
                        laneToCheckForGaps[it2] = i278 += i44;
                        i$iv3++;
                        laneIndex2 = l5;
                        i44 = 0;
                        gapDetected3 = 1;
                        gaps = measuredItem.getLaneInfo().getGaps(previousItemIndex);
                        i21 = 1;
                        i57 = -2;
                        i68 = 1;
                        iArr6 = itemCount;
                        if (laneToCheckForGaps[laneIndex2] == laneToCheckForGaps[measuredItem2]) {
                        } else {
                        }
                        gapDetected2 = 1;
                        laneIndex2 = measuredItem2;
                        l15 = 0;
                        if (iArr6[measure$lambda$38$misalignedStart] < measuredItem.getBeforeContentPadding()) {
                        } else {
                        }
                        i6 = 0;
                        if (i6 != 0) {
                        } else {
                        }
                        measure$lambda$38$misalignedStart++;
                        indexOfMaxValue = maxOffsetLane;
                        measuredItem2 = $this$all$iv;
                        laneIndex2 = 1;
                        i6 = 1;
                    }
                    initialLaneToMeasure2 = initialLaneToMeasure3;
                    i58 = i52;
                    initialLaneToMeasure = scrollDelta2;
                    beforeVisibleBounds$iv = iArr4;
                    if (gapDetected2 != 0 && canRestartMeasure) {
                        if (canRestartMeasure) {
                            measuredItem.getLaneInfo().reset();
                            return LazyStaggeredGridMeasureKt.measure(measuredItem, initialLaneToMeasure, beforeVisibleBounds$iv, laneToCheckForGaps, false);
                        }
                    }
                    $this$all$iv5 = LazyStaggeredGridMeasureKt.indexOfMinValue$default(laneToCheckForGaps, 0, 1, 0);
                    if (laneToCheckForGaps[$this$all$iv5] < 0) {
                        initialLaneToMeasure5 = laneToCheckForGaps[$this$all$iv5];
                        scrollDelta6 += initialLaneToMeasure5;
                        LazyStaggeredGridMeasureKt.offsetBy(iArr11, initialLaneToMeasure5);
                        LazyStaggeredGridMeasureKt.offsetBy(laneToCheckForGaps, -initialLaneToMeasure5);
                    }
                } else {
                    initialLaneToMeasure2 = initialLaneToMeasure3;
                    i58 = i52;
                    beforeVisibleBounds$iv = iArr4;
                    scrollDelta6 = initialLaneToMeasure5;
                }
                int i96 = 0;
                int $i$f$debugLog6 = 0;
                int i141 = 0;
                int i146 = 0;
                if (MathKt.getSign(Math.round(measuredItem.getState().getScrollToBeConsumed$foundation_release())) == MathKt.getSign(scrollDelta6) && Math.abs(Math.round(measuredItem.getState().getScrollToBeConsumed$foundation_release())) >= Math.abs(scrollDelta6)) {
                    i146 = 0;
                    if (Math.abs(Math.round(measuredItem.getState().getScrollToBeConsumed$foundation_release())) >= Math.abs(scrollDelta6)) {
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
                i$iv2 = 0;
                while (i$iv2 < copyOf.length) {
                    it2 = 0;
                    copyOf[i$iv2] = -i213;
                    i$iv2++;
                }
                int i163 = 0;
                if (measuredItem.getBeforeContentPadding() > measuredItem.getMainAxisSpacing()) {
                    laneIndex = 0;
                    while (laneIndex < arr.length) {
                        length = arr[laneIndex];
                        i52 = 0;
                        while (i52 < length.size()) {
                            i61 = length.get(i52);
                            l3 = laneIndex;
                            int[] gaps3 = measuredItem.getLaneInfo().getGaps((LazyStaggeredGridMeasuredItem)i61.getIndex());
                            if (gaps3 == null) {
                            } else {
                            }
                            i23 = gaps3[l3];
                            mainAxisSizeWithSpacings2 += i23;
                            i72 = gaps3;
                            laneToCheckForGaps[l3] = i117 -= laneIndex;
                            beforeVisibleBounds$iv[l3] = (LazyStaggeredGridMeasuredItem)length.get(i52 + 1).getIndex();
                            i52++;
                            scrollDelta6 = scrollDelta;
                            laneIndex = l3;
                            i23 = 0;
                        }
                        scrollDelta = scrollDelta6;
                        l3 = laneIndex;
                        laneIndex = l3 + 1;
                        scrollDelta6 = scrollDelta;
                        i61 = length.get(i52);
                        l3 = laneIndex;
                        gaps3 = measuredItem.getLaneInfo().getGaps((LazyStaggeredGridMeasuredItem)i61.getIndex());
                        if (gaps3 == null) {
                        } else {
                        }
                        i23 = gaps3[l3];
                        mainAxisSizeWithSpacings2 += i23;
                        i72 = gaps3;
                        if (i52 != CollectionsKt.getLastIndex((List)length)) {
                        } else {
                        }
                        if (laneToCheckForGaps[l3] != 0) {
                        } else {
                        }
                        if (laneToCheckForGaps[l3] >= laneIndex) {
                        } else {
                        }
                        laneToCheckForGaps[l3] = i117 -= laneIndex;
                        beforeVisibleBounds$iv[l3] = (LazyStaggeredGridMeasuredItem)length.get(i52 + 1).getIndex();
                        i52++;
                        scrollDelta6 = scrollDelta;
                        laneIndex = l3;
                        i23 = 0;
                    }
                    scrollDelta3 = scrollDelta6;
                    l3 = laneIndex;
                } else {
                    scrollDelta3 = scrollDelta6;
                }
                int scrollDelta10 = 0;
                beforeContentPadding4 += afterContentPadding2;
                if (measuredItem.isVertical()) {
                    constrainWidth-K40F9xA = Constraints.getMaxWidth-impl(measuredItem.getConstraints-msEJaDk());
                } else {
                    constrainWidth-K40F9xA = ConstraintsKt.constrainWidth-K40F9xA(measuredItem.getConstraints-msEJaDk(), mainAxisSpacing);
                }
                i35 = constrainWidth-K40F9xA;
                if (measuredItem.isVertical()) {
                    i37 = constrainHeight-K40F9xA;
                } else {
                    i37 = constrainHeight-K40F9xA;
                }
                i30 = measuredItem.isVertical() ? i37 : i35;
                int i181 = 0;
                i189 += afterContentPadding3;
                int i165 = 0;
                extraItemOffset = copyOf[0];
                $this$calculateExtraItems$iv = $this$measure;
                result$iv = 0;
                int i232 = 0;
                $this$fastForEachReversed$iv$iv$iv = pinnedItems2;
                int i246 = 0;
                i12 = -1;
                if (size2-- >= 0) {
                } else {
                    contentPadding = index$iv3;
                    l14 = $this$calculateExtraItems$iv;
                    laneIndex3 = laneToCheckForGaps;
                    iArr4 = beforeVisibleBounds$iv;
                    i = spanRange-lOCCd4c;
                    $this$all$iv = i60;
                    maxOffsetLane = $this$fastForEachReversed$iv$iv$iv;
                }
                if (result$iv == 0) {
                    result$iv = index$iv3;
                }
                List visibleItems = LazyStaggeredGridMeasureKt.calculateVisibleItems(measuredItem, arr, copyOf, i190);
                int i239 = 0;
                i28 = i239;
                $i$f$calculateExtraItems = 0;
                size = 0;
                $this$all$iv2 = 0;
                emptyList = $this$measure.getPinnedItems().size();
                final int[] iArr18 = copyOf;
                itemScrollOffsets = i235;
                index$iv$iv$iv2 = i201;
                result$iv2 = i73;
                while (itemScrollOffsets < emptyList) {
                    List list2 = list;
                    index$iv5 = (Number)list2.get(itemScrollOffsets).intValue();
                    i12 = 0;
                    l15 = 0;
                    index$iv$iv$iv = i254;
                    if (index$iv$iv$iv >= itemCount) {
                    } else {
                    }
                    if (/* condition */) {
                    } else {
                    }
                    $this$all$iv = $i$f$calculateExtraItems;
                    if (iArr17[lane4] < index$iv$iv$iv) {
                    } else {
                    }
                    beforeVisibleBounds$iv2 = 0;
                    if (beforeVisibleBounds$iv2 != 0) {
                    } else {
                    }
                    index$iv = index$iv5;
                    i25 = mainAxisSizeWithSpacings;
                    i53 = spanRange;
                    l14 = itemCount;
                    itemScrollOffsets = maxOffsetLane + 1;
                    spanRange = i53;
                    emptyList = i73;
                    list = i74;
                    i28 = f2;
                    $i$f$calculateExtraItems = $this$all$iv;
                    mainAxisSizeWithSpacings = i25;
                    itemCount = l14;
                    i53 = spanRange;
                    l14 = itemCount;
                    if (index$iv$iv$iv2 == 0) {
                    } else {
                    }
                    index$iv$iv$iv = index$iv$iv$iv2;
                    beforeVisibleBounds$iv2 = mainAxisSizeWithSpacings.getMeasuredItemProvider().getAndMeasure-jy6DScQ(index$iv5, mainAxisSizeWithSpacings.getSpanRange-lOCCd4c(mainAxisSizeWithSpacings.getItemProvider(), index$iv5, 0));
                    l15 = 0;
                    index$iv = index$iv5;
                    i25 = mainAxisSizeWithSpacings;
                    index$iv5 = lazyStaggeredGridMeasuredItem2;
                    index$iv5.position(result$iv2, 0, i190);
                    result$iv2 += mainAxisSizeWithSpacings;
                    index$iv$iv$iv.add(beforeVisibleBounds$iv2);
                    index$iv$iv$iv2 = index$iv$iv$iv;
                    ArrayList arrayList3 = new ArrayList();
                    index$iv$iv$iv = index$iv$iv$iv2;
                    beforeVisibleBounds$iv2 = 1;
                    index$iv = 0;
                    i25 = lane4;
                    int[] lane5 = $i$f$calculateExtraItems3;
                    $this$all$iv = $i$f$calculateExtraItems;
                    $this$all$iv4 = 0;
                    while ($this$all$iv4 < lane5.length) {
                        l13 = 0;
                        if (lane5[$this$all$iv4] < index$iv$iv$iv) {
                        } else {
                        }
                        it3 = 0;
                        $this$all$iv4 = i49 + 1;
                        it3 = 1;
                    }
                    beforeVisibleBounds$iv2 = 1;
                    l13 = 0;
                    if (l14[$this$all$iv4] < index$iv$iv$iv) {
                    } else {
                    }
                    it3 = 0;
                    if (it3 == 0) {
                    } else {
                    }
                    $this$all$iv4 = i49 + 1;
                    beforeVisibleBounds$iv2 = 0;
                    it3 = 1;
                    f2 = i28;
                    $this$all$iv = $i$f$calculateExtraItems;
                    beforeVisibleBounds$iv2 = 0;
                }
                int i264 = itemScrollOffsets;
                int i255 = i28;
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
                measuredItem.getState().getItemAnimator$foundation_release().onMeasured((int)f, i35, i37, list6, measuredItem.getMeasuredItemProvider().getKeyIndexMap(), (LazyLayoutMeasuredItemProvider)measuredItem.getMeasuredItemProvider(), measuredItem.isVertical(), false, measuredItem.getLaneCount(), false, ArraysKt.minOrThrow(laneIndex3), maxOrThrow + contentPadding, measuredItem.getCoroutineScope(), measuredItem.getGraphicsContext());
                i11 = i35;
                i40 = i37;
                ArrayList list4 = list6;
                long minSizeToFitDisappearingItems-YbymL2g2 = measuredItem.getState().getItemAnimator$foundation_release().getMinSizeToFitDisappearingItems-YbymL2g();
                if (!IntSize.equals-impl0(minSizeToFitDisappearingItems-YbymL2g2, itemCount)) {
                    i29 = measuredItem.isVertical() ? i40 : i11;
                    consumedScroll = f;
                    i35 = constrainWidth-K40F9xA2;
                    i37 = constrainHeight-K40F9xA2;
                    f = measuredItem.isVertical() ? i37 : i35;
                    if (f != i29) {
                        i11 = 0;
                        index$iv2 = 0;
                        while (index$iv2 < list4.size()) {
                            i73 = 0;
                            (LazyStaggeredGridMeasuredItem)i40.get(index$iv2).updateMainAxisLayoutSize(f);
                            index$iv2++;
                            i40 = $this$all$iv2;
                        }
                        $this$all$iv2 = i40;
                    }
                    i38 = i35;
                    i10 = i37;
                } else {
                    consumedScroll = f;
                    i10 = i40;
                    i38 = i11;
                }
                i56 = 0;
                i15 = 0;
                while (i15 < iArr3.length) {
                    list = null;
                    if (iArr3[i15] > measuredItem.getMainAxisAvailableSize()) {
                    } else {
                    }
                    i9 = 0;
                    i15++;
                    iArr3 = $this$all$iv2;
                    i9 = 1;
                }
                $this$all$iv2 = iArr3;
                $this$all$iv6 = 0;
                if ($this$all$iv6 == 0) {
                    i56 = 0;
                    i15 = 0;
                    while (i15 < iArr2.length) {
                        list = null;
                        if (iArr2[i15] < i277 + -1) {
                        } else {
                        }
                        i8 = 0;
                        i15++;
                        iArr2 = $this$all$iv2;
                        i8 = 1;
                    }
                    $this$all$iv2 = iArr2;
                    $this$all$iv6 = 1;
                    if ($this$all$iv6 != 0) {
                        i46 = 1;
                    } else {
                        i46 = 0;
                    }
                } else {
                }
            }
            LazyStaggeredGridMeasureKt.measure.1.30 anon = new LazyStaggeredGridMeasureKt.measure.1.30(list4, measuredItem);
            int[] iArr14 = iArr4;
            LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult2 = new LazyStaggeredGridMeasureResult(iArr14, laneIndex3, consumedScroll, MeasureScope.layout$default((MeasureScope)lazyLayoutMeasureScope3, i38, i10, 0, (Function1)anon, 4, 0), i46, measuredItem.isVertical(), remeasureNeeded2, measuredItem.getResolvedSlots(), measuredItem.getItemProvider().getSpanProvider(), (Density)lazyLayoutMeasureScope3, i277, visibleItems, IntSizeKt.IntSize(i38, i10), i3, i83, i58, measuredItem.getBeforeContentPadding(), measuredItem.getAfterContentPadding(), measuredItem.getMainAxisSpacing(), measuredItem.getCoroutineScope(), 0);
            int[] iArr16 = iArr14;
            return lazyStaggeredGridMeasureResult2;
        }
        itemCount2 = itemCount;
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
        int lane2;
        int lane;
        int length;
        int i2;
        int i;
        int i3;
        int previousItemIndex;
        int previousItemIndex2;
        int i4;
        lane2 = 0;
        i2 = -1;
        i = 0;
        i3 = 1;
        while (lane2 < firstItemIndices.length) {
            if (LazyStaggeredGridMeasureKt.findPreviousItemIndex($this_measure, firstItemIndices[lane2], lane2) == i2 && firstItemOffsets[lane2] != firstItemOffsets[referenceLane]) {
            } else {
            }
            lane2++;
            i2 = -1;
            i = 0;
            i3 = 1;
            if (firstItemOffsets[lane2] != firstItemOffsets[referenceLane]) {
            } else {
            }
            i = i3;
        }
        lane = 0;
        while (lane < firstItemIndices.length) {
            if (LazyStaggeredGridMeasureKt.findPreviousItemIndex($this_measure, firstItemIndices[lane], lane) != i2 && firstItemOffsets[lane] >= firstItemOffsets[referenceLane]) {
            } else {
            }
            previousItemIndex = i;
            lane++;
            if (firstItemOffsets[lane] >= firstItemOffsets[referenceLane]) {
            } else {
            }
            previousItemIndex = i3;
        }
        int lane3 = $this_measure.getLaneInfo().getLane(i);
        if (lane3 != 0 && lane3 != i2 && lane3 != -2) {
            if (lane3 != i2) {
                if (lane3 != -2) {
                    i = i3;
                }
            }
        }
        return i;
    }

    public static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult measureStaggeredGrid-XtK8cYQ(LazyLayoutMeasureScope $this$measureStaggeredGrid_u2dXtK8cYQ, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state, List<Integer> pinnedItems, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider itemProvider, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots resolvedSlots, long constraints, boolean isVertical, boolean reverseLayout, long contentOffset, int mainAxisAvailableSize, int mainAxisSpacing, int beforeContentPadding, int afterContentPadding, CoroutineScope coroutineScope, GraphicsContext graphicsContext) {
        int[] iArr;
        int[] iArr2;
        int laneCount;
        int[] laneCount2;
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
            laneCount = iArr2;
            i2 = 0;
            lane = 0;
            while (lane < laneCount.length) {
                if (lane < scrollPositionIfTheFirstItemWasMoved$foundation_release.length && scrollPositionIfTheFirstItemWasMoved$foundation_release[lane] != -1) {
                } else {
                }
                if (lane == 0) {
                } else {
                }
                maxInRange-jy6DScQ += i8;
                laneCount[lane] = i;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(laneCount[lane], lane);
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
            laneCount2 = iArr;
            i2 = 0;
            lane = 0;
            while (lane < laneCount2.length) {
                if (lane < scrollOffsets.length) {
                } else {
                }
                if (lane == 0) {
                } else {
                }
                laneInfo = laneCount2[lane + -1];
                laneCount2[lane] = laneInfo;
                lane++;
                laneInfo = i7;
                laneInfo = scrollOffsets[lane];
            }
        }
        int i5 = 0;
        return LazyStaggeredGridMeasureKt.measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState2.getScrollToBeConsumed$foundation_release()), iArr2, iArr, i8);
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
