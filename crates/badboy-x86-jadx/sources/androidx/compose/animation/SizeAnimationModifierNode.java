package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u0001:\u0001>BY\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012:\u0008\u0002\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\r\u0018\u00010\u0008¢\u0006\u0002\u0010\u000eJ\u0018\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u0008/\u00100J\u0008\u00101\u001a\u00020\rH\u0016J\u0008\u00102\u001a\u00020\rH\u0016J\u001a\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0004\u00085\u00100J&\u00106\u001a\u000207*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R/\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001a\u0010\u001b\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R \u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fRL\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\r\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R&\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020%@BX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\"\u0004\u0008'\u0010(R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\u00020\u0004X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010)\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006?", d2 = {"Landroidx/compose/animation/SizeAnimationModifierNode;", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "alignment", "Landroidx/compose/ui/Alignment;", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startSize", "endSize", "", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "<set-?>", "Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "animData", "getAnimData", "()Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "setAnimData", "(Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;)V", "animData$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/AnimationSpec;)V", "getListener", "()Lkotlin/jvm/functions/Function2;", "setListener", "(Lkotlin/jvm/functions/Function2;)V", "value", "Landroidx/compose/ui/unit/Constraints;", "lookaheadConstraints", "setLookaheadConstraints-BRTryo0", "(J)V", "J", "lookaheadConstraintsAvailable", "", "lookaheadSize", "animateTo", "targetSize", "animateTo-mzRDjE0", "(J)J", "onAttach", "onReset", "targetConstraints", "default", "targetConstraints-ZezNO4M", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "AnimData", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SizeAnimationModifierNode extends androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics {

    private Alignment alignment;
    private final MutableState animData$delegate;
    private AnimationSpec<IntSize> animationSpec;
    private Function2<? super IntSize, ? super IntSize, Unit> listener;
    private long lookaheadConstraints;
    private boolean lookaheadConstraintsAvailable;
    private long lookaheadSize;

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0016\u0010\u0010\u001a\u00020\u0004HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u000bJ3\u0010\u0012\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\"\u0010\u0006\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\r\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "", "anim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "startSize", "(Landroidx/compose/animation/core/Animatable;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnim", "()Landroidx/compose/animation/core/Animatable;", "getStartSize-YbymL2g", "()J", "setStartSize-ozmzZPI", "(J)V", "J", "component1", "component2", "component2-YbymL2g", "copy", "copy-O0kMr_c", "(Landroidx/compose/animation/core/Animatable;J)Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnimData {

        public static final int $stable = 8;
        private final Animatable<IntSize, AnimationVector2D> anim;
        private long startSize;
        static {
            final int i = 8;
        }

        private AnimData(Animatable<IntSize, AnimationVector2D> anim, long startSize) {
            super();
            this.anim = anim;
            this.startSize = startSize;
        }

        public AnimData(Animatable animatable, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
            super(animatable, l2, defaultConstructorMarker3);
        }

        public static androidx.compose.animation.SizeAnimationModifierNode.AnimData copy-O0kMr_c$default(androidx.compose.animation.SizeAnimationModifierNode.AnimData sizeAnimationModifierNode$AnimData, Animatable animatable2, long l3, int i4, Object object5) {
            Animatable obj1;
            long obj2;
            if (object5 & 1 != 0) {
                obj1 = animData.anim;
            }
            if (object5 &= 2 != 0) {
                obj2 = animData.startSize;
            }
            return animData.copy-O0kMr_c(obj1, obj2);
        }

        public final Animatable<IntSize, AnimationVector2D> component1() {
            return this.anim;
        }

        public final long component2-YbymL2g() {
            return this.startSize;
        }

        public final androidx.compose.animation.SizeAnimationModifierNode.AnimData copy-O0kMr_c(Animatable<IntSize, AnimationVector2D> animatable, long l2) {
            SizeAnimationModifierNode.AnimData animData = new SizeAnimationModifierNode.AnimData(animatable, l2, obj5, 0);
            return animData;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object instanceof SizeAnimationModifierNode.AnimData == null) {
                return i2;
            }
            Object obj = object;
            final Animatable anim2 = obj.anim;
            if (!Intrinsics.areEqual(this.anim, anim2)) {
                return i2;
            }
            if (!IntSize.equals-impl0(this.startSize, anim2)) {
                return i2;
            }
            return i;
        }

        public final Animatable<IntSize, AnimationVector2D> getAnim() {
            return this.anim;
        }

        public final long getStartSize-YbymL2g() {
            return this.startSize;
        }

        public int hashCode() {
            return i2 += i4;
        }

        public final void setStartSize-ozmzZPI(long <set-?>) {
            this.startSize = <set-?>;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("AnimData(anim=").append(this.anim).append(", startSize=").append(IntSize.toString-impl(this.startSize)).append(')').toString();
        }
    }
    public SizeAnimationModifierNode(AnimationSpec<IntSize> animationSpec, Alignment alignment, Function2<? super IntSize, ? super IntSize, Unit> listener) {
        super();
        this.animationSpec = animationSpec;
        this.alignment = alignment;
        this.listener = listener;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
        this.lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, 0);
        int i = 0;
        this.animData$delegate = SnapshotStateKt.mutableStateOf$default(i, i, 2, i);
    }

    public SizeAnimationModifierNode(AnimationSpec animationSpec, Alignment alignment2, Function2 function23, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        Alignment obj2;
        int obj3;
        if (i4 & 2 != 0) {
            obj2 = Alignment.Companion.getTopStart();
        }
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(animationSpec, obj2, obj3);
    }

    private final void setLookaheadConstraints-BRTryo0(long value) {
        this.lookaheadConstraints = value;
        this.lookaheadConstraintsAvailable = true;
    }

    private final long targetConstraints-ZezNO4M(long default) {
        long lookaheadConstraints;
        lookaheadConstraints = this.lookaheadConstraintsAvailable ? this.lookaheadConstraints : default;
        return lookaheadConstraints;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final long animateTo-mzRDjE0(long targetSize) {
        int anon;
        int i2;
        Object companion;
        kotlin.coroutines.Continuation unbox-impl;
        boolean running;
        int i;
        androidx.compose.animation.SizeAnimationModifierNode.AnimData animData;
        Animatable animatable;
        IntSize box-impl;
        Object vectorConverter;
        IntSize box-impl2;
        int i4;
        int i3;
        int i5;
        int i6;
        final long l2 = targetSize;
        animData = getAnimData();
        i2 = 1;
        if (animData != null) {
            companion = animData;
            animatable = 0;
            if (!IntSize.equals-impl0(l2, obj3) && !companion.getAnim().isRunning()) {
                if (!companion.getAnim().isRunning()) {
                } else {
                    i2 = 0;
                }
            } else {
            }
            if (IntSize.equals-impl0(l2, obj3)) {
                if (i2 != 0) {
                    companion.setStartSize-ozmzZPI((IntSize)companion.getAnim().getValue().unbox-impl());
                    anon = new SizeAnimationModifierNode.animateTo.data.1.1(companion, l2, obj3, this, 0);
                    BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)anon, 3, 0);
                }
            } else {
            }
        } else {
            companion = IntSize.Companion;
            animatable = new Animatable(IntSize.box-impl(l2), VectorConvertersKt.getVectorConverter(companion), IntSize.box-impl(IntSizeKt.IntSize(i2, i2)), 0, 8, 0);
            animData = new SizeAnimationModifierNode.AnimData(animatable, l2, obj3, 0);
        }
        setAnimData(animData);
        return (IntSize)animData.getAnim().getValue().unbox-impl();
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final androidx.compose.animation.SizeAnimationModifierNode.AnimData getAnimData() {
        final int i = 0;
        final int i2 = 0;
        return (SizeAnimationModifierNode.AnimData)(State)this.animData$delegate.getValue();
    }

    public final AnimationSpec<IntSize> getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function2<IntSize, IntSize, Unit> getListener() {
        return this.listener;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Placeable measure-BRTryo0;
        int lookingAhead;
        long targetConstraints-ZezNO4M;
        long it;
        long lookaheadSize;
        Placeable placeable;
        Object obj2;
        final Object obj = this;
        final long l2 = constraints;
        if ($this$measure_u2d3p2s80s.isLookingAhead()) {
            obj.setLookaheadConstraints-BRTryo0(l2);
            obj2 = measurable;
            placeable = measure-BRTryo0;
        } else {
            placeable = measure-BRTryo0;
        }
        long l = IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight());
        if ($this$measure_u2d3p2s80s.isLookingAhead()) {
            obj.lookaheadSize = l;
            it = l;
        } else {
            lookaheadSize = AnimationModifierKt.isValid-ozmzZPI(obj.lookaheadSize) ? obj.lookaheadSize : l;
            lookingAhead = 0;
            it = ConstraintsKt.constrain-4WqzIAM(l2, obj9);
        }
        int i = 0;
        final int i5 = $i$f$component1Impl;
        int i2 = 0;
        final int height-impl = IntSize.getHeight-impl(it);
        SizeAnimationModifierNode.measure.2 anon = new SizeAnimationModifierNode.measure.2(obj, l, obj3, i5, height-impl, $this$measure_u2d3p2s80s, placeable);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, i5, height-impl, 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public void onAttach() {
        super.onAttach();
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
        this.lookaheadConstraintsAvailable = false;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public void onReset() {
        super.onReset();
        setAnimData(0);
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final void setAlignment(Alignment <set-?>) {
        this.alignment = <set-?>;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final void setAnimData(androidx.compose.animation.SizeAnimationModifierNode.AnimData <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.animData$delegate.setValue(<set-?>);
    }

    public final void setAnimationSpec(AnimationSpec<IntSize> <set-?>) {
        this.animationSpec = <set-?>;
    }

    public final void setListener(Function2<? super IntSize, ? super IntSize, Unit> <set-?>) {
        this.listener = <set-?>;
    }
}
