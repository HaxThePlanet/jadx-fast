package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0014\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J,\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006 ", d2 = {"Landroidx/compose/animation/AnimatedEnterExitMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "scope", "Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "(Landroidx/compose/animation/AnimatedVisibilityScopeImpl;)V", "hasLookaheadOccurred", "", "getHasLookaheadOccurred", "()Z", "setHasLookaheadOccurred", "(Z)V", "getScope", "()Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {

    private boolean hasLookaheadOccurred;
    private final androidx.compose.animation.AnimatedVisibilityScopeImpl scope;
    public AnimatedEnterExitMeasurePolicy(androidx.compose.animation.AnimatedVisibilityScopeImpl scope) {
        super();
        this.scope = scope;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final boolean getHasLookaheadOccurred() {
        return this.hasLookaheadOccurred;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final androidx.compose.animation.AnimatedVisibilityScopeImpl getScope() {
        return this.scope;
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
        int width;
        MutableState targetSize$animation_release;
        IntSize box-impl;
        Object maxElem$iv2;
        boolean maxElem$iv3;
        Object maxElem$iv;
        int maxValue$iv;
        int it4;
        int index$iv$iv;
        int height;
        int it2;
        int i$iv;
        int lastIndex;
        Object obj;
        int it3;
        int it;
        int i2;
        long l;
        int i;
        final Object obj2 = this;
        Object obj3 = measurables;
        int i3 = 0;
        ArrayList arrayList = new ArrayList(obj3.size());
        Object obj4 = obj3;
        int i6 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < obj4.size()) {
            obj = 0;
            i2 = 0;
            (Collection)arrayList.add((Measurable)obj4.get(index$iv$iv).measure-BRTryo0(constraints));
            index$iv$iv++;
        }
        long l4 = constraints;
        ArrayList $this$fastMap$iv = arrayList;
        ArrayList list = $this$fastMap$iv;
        int i5 = 0;
        height = 0;
        if (list.isEmpty()) {
            maxElem$iv2 = maxValue$iv;
        } else {
            int i8 = 0;
            it2 = (Placeable)list.get(height).getWidth();
            lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
            }
        }
        if ((Placeable)maxElem$iv2 != null) {
            width = (Placeable)maxElem$iv2.getWidth();
        } else {
            width = height;
        }
        int i9 = width;
        ArrayList list2 = $this$fastMap$iv;
        box-impl = 0;
        if (list2.isEmpty()) {
        } else {
            int i7 = 0;
            it4 = (Placeable)list2.get(height).getHeight();
            lastIndex = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex) {
            }
            maxValue$iv = maxElem$iv;
            maxElem$iv3 = i;
        }
        if ((Placeable)maxValue$iv != 0) {
            height = (Placeable)maxValue$iv.getHeight();
        }
        int i10 = height;
        if ($this$measure_u2d3p2s80s.isLookingAhead()) {
            obj2.hasLookaheadOccurred = true;
            obj2.scope.getTargetSize$animation_release().setValue(IntSize.box-impl(IntSizeKt.IntSize(i9, i10)));
        } else {
            if (!obj2.hasLookaheadOccurred) {
                obj2.scope.getTargetSize$animation_release().setValue(IntSize.box-impl(IntSizeKt.IntSize(i9, i10)));
            }
        }
        AnimatedEnterExitMeasurePolicy.measure.1 anon = new AnimatedEnterExitMeasurePolicy.measure.1((List)$this$fastMap$iv);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, i9, i10, 0, (Function1)anon, 4, 0);
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

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final void setHasLookaheadOccurred(boolean <set-?>) {
        this.hasLookaheadOccurred = <set-?>;
    }
}
