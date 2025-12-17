package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aR(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"Landroidx/compose/material3/SegmentedButtonContentMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "animatable", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimatable", "()Landroidx/compose/animation/core/Animatable;", "setAnimatable", "(Landroidx/compose/animation/core/Animatable;)V", "initialOffset", "Ljava/lang/Integer;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SegmentedButtonContentMeasurePolicy implements MultiContentMeasurePolicy {

    public static final int $stable;
    private Animatable<Integer, AnimationVector1D> animatable;
    private Integer initialOffset;
    private final CoroutineScope scope;
    static {
    }

    public SegmentedButtonContentMeasurePolicy(CoroutineScope scope) {
        super();
        this.scope = scope;
    }

    public final Animatable<Integer, AnimationVector1D> getAnimatable() {
        return this.animatable;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final CoroutineScope getScope() {
        return this.scope;
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends List<? extends Measurable>> measurables, long constraints) {
        int i10;
        int i4;
        ArrayList list;
        Object $this$fastMaxBy$iv2;
        int valueOf;
        ArrayList $this$fastMaxBy$iv;
        int i9;
        Object valueOf2;
        Object obj5;
        int width;
        Object obj2;
        int i5;
        boolean it;
        int lastIndex;
        int intValue;
        int i;
        int it3;
        Object obj;
        int maxElem$iv3;
        Object maxElem$iv;
        Object maxElem$iv2;
        int i$iv;
        int i$iv2;
        int lastIndex2;
        int it4;
        Object obj4;
        int i$iv3;
        int it2;
        int $this$fastMaxBy$iv3;
        Object obj6;
        Object $this$fastMap$iv;
        int i7;
        ArrayList list2;
        Object obj3;
        Object animatable;
        Integer num;
        androidx.compose.animation.core.TwoWayConverter vectorConverter;
        int i8;
        int i3;
        int i2;
        int i6;
        Object obj9 = this;
        i10 = $this$measure_u2d3p2s80s;
        final Object obj13 = measurables;
        final long l = constraints;
        obj5 = obj14;
        int i21 = 0;
        ArrayList arrayList = new ArrayList(obj5.size());
        obj = obj5;
        int i30 = 0;
        i$iv = 0;
        while (i$iv < obj.size()) {
            $this$fastMaxBy$iv3 = 0;
            i7 = 0;
            (Collection)arrayList.add((Measurable)obj.get(i$iv).measure-BRTryo0(l));
            i$iv++;
            obj5 = obj6;
            i4 = 0;
        }
        $this$fastMap$iv = obj5;
        ArrayList list5 = list;
        int i22 = 0;
        if (list5.isEmpty()) {
            maxElem$iv2 = 0;
        } else {
            int i32 = 0;
            it3 = (Placeable)list5.get(0).getWidth();
            lastIndex2 = CollectionsKt.getLastIndex(list5);
            if (1 <= lastIndex2) {
            }
        }
        if ((Placeable)maxElem$iv2 != null) {
            width = (Placeable)maxElem$iv2.getWidth();
        } else {
            width = 0;
        }
        int i31 = width;
        obj2 = obj15;
        int i23 = 0;
        ArrayList arrayList2 = new ArrayList(obj2.size());
        Object obj12 = obj2;
        i$iv2 = 0;
        it4 = 0;
        while (it4 < obj12.size()) {
            i7 = 0;
            num = 0;
            (Collection)arrayList2.add((Measurable)obj12.get(it4).measure-BRTryo0(l));
            it4++;
            list = list2;
            obj2 = obj3;
        }
        animatable = obj2;
        $this$fastMaxBy$iv2 = arrayList2;
        int i17 = 0;
        if ($this$fastMaxBy$iv2.isEmpty()) {
            maxElem$iv3 = 0;
        } else {
            int i34 = 0;
            it = (Placeable)$this$fastMaxBy$iv2.get(0).getWidth();
            it4 = CollectionsKt.getLastIndex($this$fastMaxBy$iv2);
            if (1 <= it4) {
            } else {
                $this$fastMaxBy$iv3 = $this$fastMaxBy$iv2;
            }
        }
        if ((Placeable)maxElem$iv3 != 0) {
            valueOf = Integer.valueOf((Placeable)maxElem$iv3.getWidth());
        } else {
            valueOf = 0;
        }
        int i33 = valueOf;
        $this$fastMaxBy$iv = arrayList2;
        int i18 = 0;
        if ($this$fastMaxBy$iv.isEmpty()) {
            maxElem$iv = 0;
        } else {
            int i36 = 0;
            it4 = (Placeable)$this$fastMaxBy$iv.get(0).getHeight();
            lastIndex = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
            if (1 <= lastIndex) {
            } else {
                $this$fastMap$iv = $this$fastMaxBy$iv;
            }
        }
        if ((Placeable)maxElem$iv != null) {
            i5 = $this$fastMaxBy$iv;
        } else {
            i5 = 0;
        }
        if (i33 != 0) {
            intValue = i33.intValue();
        } else {
            intValue = 0;
        }
        if (i31 == 0) {
            i = i9;
        } else {
            i = 0;
        }
        if (obj9.initialOffset == null) {
            obj9.initialOffset = Integer.valueOf(i);
        } else {
            if (obj9.animatable == null) {
                Integer initialOffset2 = obj9.initialOffset;
                Intrinsics.checkNotNull(initialOffset2);
                animatable = new Animatable(initialOffset2, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), 0, 0, 12, 0);
                maxElem$iv = 0;
                obj9.animatable = animatable;
            }
            if ((Number)valueOf2.getTargetValue().intValue() != i) {
                i$iv3 = new SegmentedButtonContentMeasurePolicy.measure.1(valueOf2, i, 0);
                BuildersKt.launch$default(obj9.scope, 0, 0, (Function2)i$iv3, 3, 0);
            }
        }
        int i28 = i5;
        SegmentedButtonContentMeasurePolicy.measure.2 anon = new SegmentedButtonContentMeasurePolicy.measure.2(list, $this$measure_u2d3p2s80s, obj9, i, (List)arrayList2, i28);
        int i37 = i;
        ArrayList list6 = arrayList2;
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, i12 += intValue, i28, 0, (Function1)anon, 4, 0);
    }

    public final void setAnimatable(Animatable<Integer, AnimationVector1D> <set-?>) {
        this.animatable = <set-?>;
    }
}
