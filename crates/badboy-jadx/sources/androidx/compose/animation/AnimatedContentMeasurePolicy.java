package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\u0008*\u00020\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0006\u0010\r\u001a\u00020\u0008H\u0016J\"\u0010\u000e\u001a\u00020\u0008*\u00020\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0006\u0010\u000f\u001a\u00020\u0008H\u0016J,\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\u0008*\u00020\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0006\u0010\r\u001a\u00020\u0008H\u0016J\"\u0010\u0019\u001a\u00020\u0008*\u00020\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0006\u0010\u000f\u001a\u00020\u0008H\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001a", d2 = {"Landroidx/compose/animation/AnimatedContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "rootScope", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "getRootScope", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AnimatedContentMeasurePolicy implements MeasurePolicy {

    private final androidx.compose.animation.AnimatedContentTransitionScopeImpl<?> rootScope;
    public AnimatedContentMeasurePolicy(androidx.compose.animation.AnimatedContentTransitionScopeImpl<?> rootScope) {
        super();
        this.rootScope = rootScope;
    }

    public final androidx.compose.animation.AnimatedContentTransitionScopeImpl<?> getRootScope() {
        return this.rootScope;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Integer maxValue$iv;
        int intValue;
        int i$iv;
        int lastIndex;
        Integer valueOf;
        int compareTo;
        final List list = measurables;
        final int i = 0;
        if (list.isEmpty()) {
            maxValue$iv = 0;
        } else {
            int i2 = 0;
            maxValue$iv = Integer.valueOf((IntrinsicMeasurable)list.get(0).maxIntrinsicHeight(width));
            lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
            }
        }
        if ((Integer)maxValue$iv != null) {
            intValue = (Integer)maxValue$iv.intValue();
        }
        return intValue;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Integer maxValue$iv;
        int intValue;
        int i$iv;
        int lastIndex;
        Integer valueOf;
        int compareTo;
        final List list = measurables;
        final int i = 0;
        if (list.isEmpty()) {
            maxValue$iv = 0;
        } else {
            int i2 = 0;
            maxValue$iv = Integer.valueOf((IntrinsicMeasurable)list.get(0).maxIntrinsicWidth(height));
            lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
            }
        }
        if ((Integer)maxValue$iv != null) {
            intValue = (Integer)maxValue$iv.intValue();
        }
        return intValue;
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        long targetSize;
        int width-impl;
        int height;
        int i3;
        Placeable[] lookingAhead2;
        int index$iv2;
        boolean lookingAhead;
        int i4;
        int lastIndex;
        int index$iv;
        int size;
        int nextInt;
        int nextInt2;
        boolean maxElem$iv;
        int it;
        boolean maxValue$iv;
        Object measure-BRTryo0;
        Object obj;
        int height2;
        int i;
        int i5;
        long l;
        int i2;
        final Object obj2 = this;
        final long l2 = constraints;
        Placeable[] arr = new Placeable[measurables.size()];
        int i6 = 0;
        targetSize = IntSize.Companion.getZero-YbymL2g();
        Object obj4 = measurables;
        int i8 = 0;
        index$iv = 0;
        it = 1;
        while (index$iv < obj4.size()) {
            obj = measure-BRTryo0;
            i = 0;
            i5 = 0;
            if (maxElem$iv instanceof AnimatedContentTransitionScopeImpl.ChildData != null) {
            } else {
            }
            maxElem$iv = 0;
            if (maxElem$iv != 0) {
            } else {
            }
            it = i5;
            if (it != 0) {
            } else {
            }
            l = targetSize;
            index$iv++;
            it = 1;
            maxElem$iv = obj.measure-BRTryo0(l2);
            Placeable placeable3 = maxElem$iv;
            maxValue$iv = 0;
            l = targetSize;
            targetSize = IntSizeKt.IntSize(placeable3.getWidth(), placeable3.getHeight());
            it = Unit.INSTANCE;
            arr[index$iv] = maxElem$iv;
            if (maxElem$iv.isTarget() == it) {
            } else {
            }
            it = i5;
        }
        long l3 = targetSize;
        int i9 = 0;
        Object obj3 = measurables;
        i3 = 0;
        index$iv2 = 0;
        while (index$iv2 < obj3.size()) {
            maxElem$iv = index$iv2;
            maxValue$iv = 0;
            if (arr[maxElem$iv] == null) {
            }
            index$iv2++;
            arr[maxElem$iv] = (Measurable)obj3.get(index$iv2).measure-BRTryo0(l2);
        }
        if ($this$measure_u2d3p2s80s.isLookingAhead()) {
            width-impl = IntSize.getWidth-impl(l3);
        } else {
            Placeable[] objArr = arr;
            i3 = 0;
            i4 = objArr.length == 0 ? it : i9;
            if (i4 != 0) {
                index$iv2 = 0;
            } else {
                lastIndex = ArraysKt.getLastIndex(objArr);
                if (lastIndex == 0) {
                } else {
                    Placeable placeable2 = index$iv2;
                    nextInt2 = 0;
                    if (placeable2 != null) {
                        maxElem$iv = placeable2.getWidth();
                    } else {
                        maxElem$iv = i9;
                    }
                    IntRange intRange2 = new IntRange(it, lastIndex);
                    index$iv = intRange2.iterator();
                    while (index$iv.hasNext()) {
                        maxValue$iv = objArr[index$iv.nextInt()];
                        measure-BRTryo0 = maxValue$iv;
                        obj = 0;
                        if (measure-BRTryo0 != null) {
                        } else {
                        }
                        height2 = i9;
                        if (maxElem$iv < height2) {
                        }
                        index$iv2 = maxValue$iv;
                        maxElem$iv = height2;
                        height2 = measure-BRTryo0.getWidth();
                    }
                }
            }
            if (index$iv2 != 0) {
                width-impl = index$iv2.getWidth();
            } else {
                width-impl = i9;
            }
        }
        if ($this$measure_u2d3p2s80s.isLookingAhead()) {
            i2 = maxValue$iv;
        } else {
            lookingAhead2 = arr;
            index$iv2 = 0;
            lastIndex = lookingAhead2.length == 0 ? it : i9;
            if (lastIndex != 0) {
                maxElem$iv = 0;
            } else {
                lastIndex = ArraysKt.getLastIndex(lookingAhead2);
                if (lastIndex == 0) {
                } else {
                    Placeable placeable = maxElem$iv;
                    nextInt = 0;
                    if (placeable != null) {
                        maxValue$iv = placeable.getHeight();
                    } else {
                        maxValue$iv = i9;
                    }
                    IntRange intRange = new IntRange(it, lastIndex);
                    index$iv = intRange.iterator();
                    while (index$iv.hasNext()) {
                        it = lookingAhead2[index$iv.nextInt()];
                        measure-BRTryo0 = it;
                        obj = 0;
                        if (measure-BRTryo0 != 0) {
                        } else {
                        }
                        height2 = i9;
                        if (maxValue$iv < height2) {
                        }
                        maxElem$iv = it;
                        maxValue$iv = height2;
                        height2 = measure-BRTryo0.getHeight();
                    }
                }
            }
            if (maxElem$iv != null) {
                i2 = maxValue$iv;
            } else {
                i2 = i9;
            }
        }
        int i7 = i2;
        if (!$this$measure_u2d3p2s80s.isLookingAhead()) {
            obj2.rootScope.setMeasuredSize-ozmzZPI$animation_release(IntSizeKt.IntSize(width-impl, i7));
        }
        AnimatedContentMeasurePolicy.measure.3 anon = new AnimatedContentMeasurePolicy.measure.3(arr, obj2, width-impl, i7);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, width-impl, i7, 0, (Function1)anon, 4, 0);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Integer maxValue$iv;
        int intValue;
        int i$iv;
        int lastIndex;
        Integer valueOf;
        int compareTo;
        final List list = measurables;
        final int i = 0;
        if (list.isEmpty()) {
            maxValue$iv = 0;
        } else {
            int i2 = 0;
            maxValue$iv = Integer.valueOf((IntrinsicMeasurable)list.get(0).minIntrinsicHeight(width));
            lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
            }
        }
        if ((Integer)maxValue$iv != null) {
            intValue = (Integer)maxValue$iv.intValue();
        }
        return intValue;
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Integer maxValue$iv;
        int intValue;
        int i$iv;
        int lastIndex;
        Integer valueOf;
        int compareTo;
        final List list = measurables;
        final int i = 0;
        if (list.isEmpty()) {
            maxValue$iv = 0;
        } else {
            int i2 = 0;
            maxValue$iv = Integer.valueOf((IntrinsicMeasurable)list.get(0).minIntrinsicWidth(height));
            lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
            }
        }
        if ((Integer)maxValue$iv != null) {
            intValue = (Integer)maxValue$iv.intValue();
        }
        return intValue;
    }
}
