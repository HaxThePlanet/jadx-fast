package androidx.compose.material3.carousel;

import androidx.collection.FloatList;
import androidx.collection.FloatListKt;
import androidx.collection.MutableFloatList;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010!\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002\u001a.\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000c2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002\u001a\u001e\u0010\u000f\u001a\u00020\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000c2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002\u001a \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0002\u001a.\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000c2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002\u001a\u001e\u0010\u0019\u001a\u00020\u00042\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000c2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002\u001a&\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00042\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002\u001a0\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0002\u001a0\u0010&\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a(\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00080**\u0008\u0012\u0004\u0012\u00020\u00080*2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0002¨\u0006+", d2 = {"createShiftedKeylineListForContentPadding", "Landroidx/compose/material3/carousel/KeylineList;", "from", "carouselMainAxisSize", "", "itemSpacing", "contentPadding", "pivot", "Landroidx/compose/material3/carousel/Keyline;", "pivotIndex", "", "getEndKeylineSteps", "", "defaultKeylines", "afterContentPadding", "getEndShiftDistance", "endKeylineSteps", "getShiftPointRange", "Landroidx/compose/material3/carousel/ShiftPointRange;", "stepsCount", "shiftPoint", "Landroidx/collection/FloatList;", "interpolation", "getStartKeylineSteps", "beforeContentPadding", "getStartShiftDistance", "startKeylineSteps", "getStepInterpolationPoints", "totalShiftDistance", "steps", "isShiftingLeft", "", "lerp", "outputMin", "outputMax", "inputMin", "inputMax", "value", "moveKeylineAndCreateShiftedKeylineList", "srcIndex", "dstIndex", "move", "", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StrategyKt {
    public static final List access$getEndKeylineSteps(androidx.compose.material3.carousel.KeylineList defaultKeylines, float carouselMainAxisSize, float itemSpacing, float afterContentPadding) {
        return StrategyKt.getEndKeylineSteps(defaultKeylines, carouselMainAxisSize, itemSpacing, afterContentPadding);
    }

    public static final float access$getEndShiftDistance(List endKeylineSteps, float afterContentPadding) {
        return StrategyKt.getEndShiftDistance(endKeylineSteps, afterContentPadding);
    }

    public static final androidx.compose.material3.carousel.ShiftPointRange access$getShiftPointRange(int stepsCount, FloatList shiftPoint, float interpolation) {
        return StrategyKt.getShiftPointRange(stepsCount, shiftPoint, interpolation);
    }

    public static final List access$getStartKeylineSteps(androidx.compose.material3.carousel.KeylineList defaultKeylines, float carouselMainAxisSize, float itemSpacing, float beforeContentPadding) {
        return StrategyKt.getStartKeylineSteps(defaultKeylines, carouselMainAxisSize, itemSpacing, beforeContentPadding);
    }

    public static final float access$getStartShiftDistance(List startKeylineSteps, float beforeContentPadding) {
        return StrategyKt.getStartShiftDistance(startKeylineSteps, beforeContentPadding);
    }

    public static final FloatList access$getStepInterpolationPoints(float totalShiftDistance, List steps, boolean isShiftingLeft) {
        return StrategyKt.getStepInterpolationPoints(totalShiftDistance, steps, isShiftingLeft);
    }

    public static final float access$lerp(float outputMin, float outputMax, float inputMin, float inputMax, float value) {
        return StrategyKt.lerp(outputMin, outputMax, inputMin, inputMax, value);
    }

    public static final List access$move(List $receiver, int srcIndex, int dstIndex) {
        return StrategyKt.move($receiver, srcIndex, dstIndex);
    }

    private static final androidx.compose.material3.carousel.KeylineList createShiftedKeylineListForContentPadding(androidx.compose.material3.carousel.KeylineList from, float carouselMainAxisSize, float itemSpacing, float contentPadding, androidx.compose.material3.carousel.Keyline pivot, int pivotIndex) {
        int size;
        int i7;
        int index$iv$iv2;
        Object obj6;
        Object obj4;
        int i16;
        Object obj;
        int i8;
        int index$iv$iv;
        boolean anchor;
        Object obj2;
        int i9;
        Object obj3;
        int i11;
        int i6;
        Object obj5;
        int i12;
        int i14;
        float unadjustedOffset;
        int i13;
        int i10;
        int i15;
        int i4;
        int i;
        int i5;
        int i17;
        int i2;
        int i3;
        final androidx.compose.material3.carousel.KeylineList list = from;
        androidx.compose.material3.carousel.KeylineList list2 = list;
        int i18 = 0;
        ArrayList arrayList = new ArrayList((List)list2.size());
        androidx.compose.material3.carousel.KeylineList list4 = list2;
        int i24 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < list4.size()) {
            obj4 = obj6;
            i16 = 0;
            i8 = 0;
            if (!(Keyline)obj4.isAnchor()) {
            }
            index$iv$iv2++;
            (Collection)arrayList.add(obj4);
        }
        i7 = contentPadding / f;
        StrategyKt.createShiftedKeylineListForContentPadding.newKeylines.1 anon = new StrategyKt.createShiftedKeylineListForContentPadding.newKeylines.1(list, i7);
        androidx.compose.material3.carousel.KeylineList list5 = keylineListOf;
        int i26 = 0;
        ArrayList arrayList2 = new ArrayList((List)list5.size());
        androidx.compose.material3.carousel.KeylineList list6 = list5;
        int i27 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list6.size()) {
            i11 = 0;
            i2 = 0;
            (Collection)arrayList2.add(Keyline.copy$default((Keyline)list6.get(index$iv$iv), 0, 0, list.get(index$iv$iv).getUnadjustedOffset(), false, false, false, 0, 123, 0));
            index$iv$iv++;
            size = i6;
            i7 = i3;
        }
        int numberOfNonAnchorKeylines2 = size;
        int i28 = i7;
        KeylineList keylineList = new KeylineList((List)arrayList2);
        return keylineList;
    }

    private static final List<androidx.compose.material3.carousel.KeylineList> getEndKeylineSteps(androidx.compose.material3.carousel.KeylineList defaultKeylines, float carouselMainAxisSize, float itemSpacing, float afterContentPadding) {
        float f;
        float shiftedKeylineListForContentPadding;
        float f2;
        float i;
        int cmp;
        int shiftedKeylineListForContentPadding2;
        androidx.compose.material3.carousel.Keyline lastFocal;
        int lastFocalIndex2;
        int lastFocalIndex;
        Object obj2;
        int i2;
        int lastIndex2;
        int dstIndex;
        androidx.compose.material3.carousel.KeylineList moveKeylineAndCreateShiftedKeylineList;
        int lastIndex;
        int lastIndexBeforeFocalRangeWithSize;
        Object obj;
        Object obj3 = defaultKeylines;
        final int i4 = afterContentPadding;
        if (obj3.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        final ArrayList list = arrayList;
        (List)list.add(obj3);
        i = 0;
        shiftedKeylineListForContentPadding2 = 0;
        lastFocal = 1;
        if (defaultKeylines.isLastFocalItemAtEndOfContainer(carouselMainAxisSize) && Float.compare(i4, i) == 0) {
            if (Float.compare(i4, i) == 0) {
                shiftedKeylineListForContentPadding2 = lastFocal;
            }
            if (shiftedKeylineListForContentPadding2 == 0) {
                i = itemSpacing;
                obj2 = obj3;
                f = i;
                list.add(StrategyKt.createShiftedKeylineListForContentPadding(obj3, carouselMainAxisSize, i, -i4, obj3.getLastFocal(), obj3.getLastFocalIndex()));
            } else {
                f2 = carouselMainAxisSize;
                obj2 = obj3;
                f = itemSpacing;
            }
            return list;
        }
        float f3 = carouselMainAxisSize;
        Object obj5 = obj3;
        shiftedKeylineListForContentPadding = itemSpacing;
        final int lastNonAnchorIndex = obj5.getLastNonAnchorIndex();
        final int i5 = lastNonAnchorIndex - lastFocalIndex3;
        if (i5 <= 0 && Float.compare(cutoff, i) > 0) {
            if (Float.compare(cutoff, i) > 0) {
                list.add(StrategyKt.moveKeylineAndCreateShiftedKeylineList(obj5, shiftedKeylineListForContentPadding2, shiftedKeylineListForContentPadding2, f3, shiftedKeylineListForContentPadding));
                return list;
            }
        }
        i2 = lastFocalIndex;
        while (i2 < i5) {
            lastFocalIndex = CollectionsKt.last(list);
            lastIndex2 = lastNonAnchorIndex - i2;
            dstIndex = 0;
            if (lastIndex2 < CollectionsKt.getLastIndex((List)obj5)) {
            }
            list.add(StrategyKt.moveKeylineAndCreateShiftedKeylineList((KeylineList)lastFocalIndex, obj5.getLastNonAnchorIndex(), dstIndex, f3, shiftedKeylineListForContentPadding));
            i2++;
            dstIndex = lastIndexBeforeFocalRangeWithSize + 1;
        }
        if (Float.compare(i4, i) == 0) {
            shiftedKeylineListForContentPadding2 = lastFocal;
        }
        if (shiftedKeylineListForContentPadding2 == 0) {
            list.set(CollectionsKt.getLastIndex(list), StrategyKt.createShiftedKeylineListForContentPadding((KeylineList)CollectionsKt.last(list), f3, shiftedKeylineListForContentPadding, -i4, (KeylineList)CollectionsKt.last(list).getLastFocal(), (KeylineList)CollectionsKt.last(list).getLastFocalIndex()));
        }
        return list;
    }

    private static final float getEndShiftDistance(List<androidx.compose.material3.carousel.KeylineList> endKeylineSteps, float afterContentPadding) {
        if (endKeylineSteps.isEmpty()) {
            return 0;
        }
        return Math.max(unadjustedOffset -= unadjustedOffset2, afterContentPadding);
    }

    private static final androidx.compose.material3.carousel.ShiftPointRange getShiftPointRange(int stepsCount, FloatList shiftPoint, float interpolation) {
        float lowerBounds;
        int nextInt;
        int i3;
        int i;
        int i2;
        float f;
        int cmp;
        int i4 = 0;
        int i5 = 0;
        lowerBounds = shiftPoint.get(i5);
        final int i7 = 0;
        Iterator iterator = (Iterable)RangesKt.until(1, stepsCount).iterator();
        i3 = 0;
        while (iterator.hasNext()) {
            i = nextInt;
            i2 = 0;
            f = shiftPoint.get(i);
            lowerBounds = f;
            i3 = 0;
        }
        ShiftPointRange $this$forEach$iv = new ShiftPointRange(i5, i5, i3);
        return $this$forEach$iv;
    }

    private static final List<androidx.compose.material3.carousel.KeylineList> getStartKeylineSteps(androidx.compose.material3.carousel.KeylineList defaultKeylines, float carouselMainAxisSize, float itemSpacing, float beforeContentPadding) {
        float f2;
        float shiftedKeylineListForContentPadding;
        float f;
        float i;
        int cmp;
        int i2;
        androidx.compose.material3.carousel.KeylineList shiftedKeylineListForContentPadding2;
        int firstFocalIndex;
        int firstFocalIndex2;
        Object obj;
        int i3;
        int lastIndex;
        int dstIndex;
        androidx.compose.material3.carousel.KeylineList moveKeylineAndCreateShiftedKeylineList;
        int firstIndexAfterFocalRangeWithSize;
        Object obj2 = defaultKeylines;
        if (obj2.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        final ArrayList list = arrayList;
        (List)list.add(obj2);
        i = 0;
        i2 = 0;
        shiftedKeylineListForContentPadding2 = 1;
        if (obj2.isFirstFocalItemAtStartOfContainer() && Float.compare(beforeContentPadding, i) == 0) {
            if (Float.compare(beforeContentPadding, i) == 0) {
                i2 = shiftedKeylineListForContentPadding2;
            }
            if (i2 == 0) {
                i = itemSpacing;
                obj = obj2;
                f2 = i;
                list.add(StrategyKt.createShiftedKeylineListForContentPadding(obj2, carouselMainAxisSize, i, beforeContentPadding, obj2.getFirstFocal(), obj2.getFirstFocalIndex()));
            } else {
                f = carouselMainAxisSize;
                obj = obj2;
                f2 = itemSpacing;
            }
            return list;
        }
        float f3 = carouselMainAxisSize;
        Object obj5 = obj2;
        shiftedKeylineListForContentPadding = itemSpacing;
        final int firstNonAnchorIndex = obj5.getFirstNonAnchorIndex();
        final int i4 = firstFocalIndex3 - firstNonAnchorIndex;
        if (i4 <= 0 && Float.compare(cutoff, i) > 0) {
            if (Float.compare(cutoff, i) > 0) {
                list.add(StrategyKt.moveKeylineAndCreateShiftedKeylineList(obj5, i2, i2, f3, shiftedKeylineListForContentPadding));
                return list;
            }
        }
        i3 = firstFocalIndex2;
        while (i3 < i4) {
            firstFocalIndex2 = CollectionsKt.last(list);
            lastIndex = firstNonAnchorIndex + i3;
            dstIndex = CollectionsKt.getLastIndex((List)obj5);
            if (lastIndex > 0) {
            }
            list.add(StrategyKt.moveKeylineAndCreateShiftedKeylineList((KeylineList)firstFocalIndex2, obj5.getFirstNonAnchorIndex(), dstIndex, f3, shiftedKeylineListForContentPadding));
            i3++;
            dstIndex = firstIndexAfterFocalRangeWithSize + -1;
        }
        if (Float.compare(beforeContentPadding, i) == 0) {
            i2 = shiftedKeylineListForContentPadding2;
        }
        if (i2 == 0) {
            list.set(CollectionsKt.getLastIndex(list), StrategyKt.createShiftedKeylineListForContentPadding((KeylineList)CollectionsKt.last(list), f3, shiftedKeylineListForContentPadding, beforeContentPadding, (KeylineList)CollectionsKt.last(list).getFirstFocal(), (KeylineList)CollectionsKt.last(list).getFirstFocalIndex()));
        }
        return list;
    }

    private static final float getStartShiftDistance(List<androidx.compose.material3.carousel.KeylineList> startKeylineSteps, float beforeContentPadding) {
        if (startKeylineSteps.isEmpty()) {
            return 0;
        }
        return Math.max(unadjustedOffset -= unadjustedOffset2, beforeContentPadding);
    }

    private static final FloatList getStepInterpolationPoints(float totalShiftDistance, List<androidx.compose.material3.carousel.KeylineList> steps, boolean isShiftingLeft) {
        int empty;
        int nextInt;
        Boolean valueOf;
        int i3;
        Object obj2;
        Object obj;
        int i;
        int i4;
        float unadjustedOffset;
        int i2;
        final List list = steps;
        int i5 = 0;
        final MutableFloatList mutableFloatListOf = FloatListKt.mutableFloatListOf(i5);
        int i6 = 1;
        empty = Float.compare(totalShiftDistance, i5) == 0 ? i6 : 0;
        if (empty == 0) {
            if (list.isEmpty()) {
            } else {
                kotlin.ranges.IntRange until = RangesKt.until(i6, list.size());
                int i7 = 0;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)until, 10));
                final int i9 = 0;
                final Iterator iterator = until.iterator();
                while (iterator.hasNext()) {
                    int i10 = nextInt;
                    i3 = 0;
                    obj2 = list.get(i10 + -1);
                    obj = list.get(i10);
                    if (isShiftingLeft) {
                    } else {
                    }
                    unadjustedOffset3 -= unadjustedOffset;
                    if (i10 == CollectionsKt.getLastIndex(list)) {
                    } else {
                    }
                    f += i4;
                    (Collection)arrayList.add(Boolean.valueOf(mutableFloatListOf.add(i2)));
                    i2 = 1065353216;
                    unadjustedOffset2 -= unadjustedOffset;
                }
            }
            return (FloatList)mutableFloatListOf;
        }
        return (FloatList)mutableFloatListOf;
    }

    private static final float lerp(float outputMin, float outputMax, float inputMin, float inputMax, float value) {
        if (Float.compare(value, inputMin) <= 0) {
            return outputMin;
        }
        if (Float.compare(value, inputMax) >= 0) {
            return outputMax;
        }
        return MathHelpersKt.lerp(outputMin, outputMax, i /= i3);
    }

    private static final List<androidx.compose.material3.carousel.Keyline> move(List<androidx.compose.material3.carousel.Keyline> $this$move, int srcIndex, int dstIndex) {
        $this$move.remove(srcIndex);
        $this$move.add(dstIndex, (Keyline)$this$move.get(srcIndex));
        return $this$move;
    }

    private static final androidx.compose.material3.carousel.KeylineList moveKeylineAndCreateShiftedKeylineList(androidx.compose.material3.carousel.KeylineList from, int srcIndex, int dstIndex, float carouselMainAxisSize, float itemSpacing) {
        int i;
        i = srcIndex > dstIndex ? 1 : -1;
        StrategyKt.moveKeylineAndCreateShiftedKeylineList.1 anon = new StrategyKt.moveKeylineAndCreateShiftedKeylineList.1(from, srcIndex, dstIndex);
        return KeylineListKt.keylineListOf(carouselMainAxisSize, itemSpacing, pivotIndex += i, offset += i4, (Function1)anon);
    }
}
