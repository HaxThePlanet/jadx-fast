package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.animation.core.Transition.Segment;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001a\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002UVB%\u0008\u0000\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\"\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u000c2\u0006\u0010\u0015\u001a\u00020\u000cH\u0002ø\u0001\u0000¢\u0006\u0004\u00088\u00109J\u0017\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0004\u0008>\u0010?JK\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u0002002\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u0002060D2!\u0010E\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\u000c\u0008H\u0012\u0008\u0008I\u0012\u0004\u0008\u0008(J\u0012\u0004\u0012\u00020G0FH\u0016ø\u0001\u0000¢\u0006\u0004\u0008K\u0010LJK\u0010M\u001a\u00020N2\u0006\u0010B\u001a\u0002002\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u0002060D2!\u0010O\u001a\u001d\u0012\u0013\u0012\u00110G¢\u0006\u000c\u0008H\u0012\u0008\u0008I\u0012\u0004\u0008\u0008(J\u0012\u0004\u0012\u00020G0FH\u0016ø\u0001\u0000¢\u0006\u0004\u0008P\u0010QJ\u0017\u0010R\u001a\u00020=*\u00020=2\u0008\u0010S\u001a\u0004\u0018\u00010TH\u0096\u0004R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000c8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u0008X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR1\u0010 \u001a\u00020\u000c2\u0006\u0010\u001f\u001a\u00020\u000c8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008$\u0010%\u001a\u0004\u0008!\u0010\u0017\"\u0004\u0008\"\u0010#R&\u0010&\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0'X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0014\u0010*\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008+\u0010\u001aR\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010-R\u0018\u0010.\u001a\u00020/*\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00081\u00102R\u0018\u00103\u001a\u00020/*\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00084\u00102\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006W²\u0006\u0010\u0010X\u001a\u00020/\"\u0004\u0008\u0000\u0010\u0001X\u008a\u008e\u0002", d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "S", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "transition", "Landroidx/compose/animation/core/Transition;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/unit/LayoutDirection;)V", "animatedSize", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/IntSize;", "getAnimatedSize$animation_release", "()Landroidx/compose/runtime/State;", "setAnimatedSize$animation_release", "(Landroidx/compose/runtime/State;)V", "getContentAlignment", "()Landroidx/compose/ui/Alignment;", "setContentAlignment", "(Landroidx/compose/ui/Alignment;)V", "currentSize", "getCurrentSize-YbymL2g", "()J", "initialState", "getInitialState", "()Ljava/lang/Object;", "getLayoutDirection$animation_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection$animation_release", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "<set-?>", "measuredSize", "getMeasuredSize-YbymL2g$animation_release", "setMeasuredSize-ozmzZPI$animation_release", "(J)V", "measuredSize$delegate", "Landroidx/compose/runtime/MutableState;", "targetSizeMap", "Landroidx/collection/MutableScatterMap;", "getTargetSizeMap$animation_release", "()Landroidx/collection/MutableScatterMap;", "targetState", "getTargetState", "getTransition$animation_release", "()Landroidx/compose/animation/core/Transition;", "isLeft", "", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "isLeft-gWo6LJ4", "(I)Z", "isRight", "isRight-gWo6LJ4", "calculateOffset", "Landroidx/compose/ui/unit/IntOffset;", "fullSize", "calculateOffset-emnUabE", "(JJ)J", "createSizeAnimationModifier", "Landroidx/compose/ui/Modifier;", "contentTransform", "Landroidx/compose/animation/ContentTransform;", "createSizeAnimationModifier$animation_release", "(Landroidx/compose/animation/ContentTransform;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "slideIntoContainer", "Landroidx/compose/animation/EnterTransition;", "towards", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "initialOffset", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "offsetForFullSlide", "slideIntoContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "slideOutOfContainer", "Landroidx/compose/animation/ExitTransition;", "targetOffset", "slideOutOfContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "using", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "ChildData", "SizeModifier", "animation_release", "shouldAnimateSize"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnimatedContentTransitionScopeImpl<S>  implements androidx.compose.animation.AnimatedContentTransitionScope<S> {

    public static final int $stable = 8;
    private State<IntSize> animatedSize;
    private Alignment contentAlignment;
    private LayoutDirection layoutDirection;
    private final MutableState measuredSize$delegate;
    private final MutableScatterMap<S, State<IntSize>> targetSizeMap;
    private final Transition<S> transition;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b*\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\u0002\u0010\u0006\"\u0004\u0008\u0007\u0010\u0004¨\u0006\u000e", d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$ChildData;", "Landroidx/compose/ui/layout/ParentDataModifier;", "isTarget", "", "(Z)V", "<set-?>", "()Z", "setTarget", "isTarget$delegate", "Landroidx/compose/runtime/MutableState;", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ChildData implements ParentDataModifier {

        public static final int $stable;
        private final MutableState isTarget$delegate;
        static {
        }

        public ChildData(boolean isTarget) {
            super();
            final int i = 0;
            this.isTarget$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(isTarget), i, 2, i);
        }

        @Override // androidx.compose.ui.layout.ParentDataModifier
        public final boolean isTarget() {
            final int i = 0;
            final int i2 = 0;
            return (Boolean)(State)this.isTarget$delegate.getValue().booleanValue();
        }

        @Override // androidx.compose.ui.layout.ParentDataModifier
        public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
            return this;
        }

        @Override // androidx.compose.ui.layout.ParentDataModifier
        public final void setTarget(boolean <set-?>) {
            final int i = 0;
            final int i2 = 0;
            this.isTarget$delegate.setValue(Boolean.valueOf(<set-?>));
        }
    }

    @Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0082\u0004\u0018\u00002\u00020\u0001B3\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0008¢\u0006\u0002\u0010\nJ&\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017R'\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\u0008\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0018", d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifier;", "Landroidx/compose/animation/LayoutModifierWithPassThroughIntrinsics;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "sizeTransform", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/SizeTransform;", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;)V", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getSizeTransform", "()Landroidx/compose/runtime/State;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SizeModifier extends androidx.compose.animation.LayoutModifierWithPassThroughIntrinsics {

        private final Transition.DeferredAnimation<S, IntSize, AnimationVector2D> sizeAnimation;
        private final State<androidx.compose.animation.SizeTransform> sizeTransform;
        final androidx.compose.animation.AnimatedContentTransitionScopeImpl<S> this$0;
        public SizeModifier(androidx.compose.animation.AnimatedContentTransitionScopeImpl this$0, Transition.DeferredAnimation sizeAnimation, State sizeTransform) {
            this.this$0 = this$0;
            super();
            this.sizeAnimation = sizeAnimation;
            this.sizeTransform = sizeTransform;
        }

        public final Transition.DeferredAnimation<S, IntSize, AnimationVector2D> getSizeAnimation() {
            return this.sizeAnimation;
        }

        public final State<androidx.compose.animation.SizeTransform> getSizeTransform() {
            return this.sizeTransform;
        }

        @Override // androidx.compose.animation.LayoutModifierWithPassThroughIntrinsics
        public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
            long measuredSize;
            int width;
            int height;
            final Placeable measure-BRTryo0 = measurable.measure-BRTryo0(constraints);
            AnimatedContentTransitionScopeImpl.SizeModifier.measure.size.1 anon = new AnimatedContentTransitionScopeImpl.SizeModifier.measure.size.1(this.this$0, this);
            AnimatedContentTransitionScopeImpl.SizeModifier.measure.size.2 anon2 = new AnimatedContentTransitionScopeImpl.SizeModifier.measure.size.2(this.this$0);
            State animate = this.sizeAnimation.animate((Function1)anon, (Function1)anon2);
            this.this$0.setAnimatedSize$animation_release(animate);
            int i = 0;
            if ($this$measure_u2d3p2s80s.isLookingAhead()) {
                measuredSize = IntSizeKt.IntSize(measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight());
            } else {
                measuredSize = (IntSize)animate.getValue().unbox-impl();
            }
            AnimatedContentTransitionScopeImpl.SizeModifier.measure.1 anon3 = new AnimatedContentTransitionScopeImpl.SizeModifier.measure.1(this.this$0, measure-BRTryo0, measuredSize, anon2);
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, IntSize.getWidth-impl(measuredSize), IntSize.getHeight-impl(measuredSize), 0, (Function1)anon3, 4, 0);
        }
    }
    static {
        final int i = 8;
    }

    public AnimatedContentTransitionScopeImpl(Transition<S> transition, Alignment contentAlignment, LayoutDirection layoutDirection) {
        super();
        this.transition = transition;
        this.contentAlignment = contentAlignment;
        this.layoutDirection = layoutDirection;
        final int i = 0;
        this.measuredSize$delegate = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), i, 2, i);
        this.targetSizeMap = ScatterMapKt.mutableScatterMapOf();
    }

    public static final long access$calculateOffset-emnUabE(androidx.compose.animation.AnimatedContentTransitionScopeImpl $this, long fullSize, long currentSize) {
        return $this.calculateOffset-emnUabE(fullSize, currentSize);
    }

    public static final long access$getCurrentSize-YbymL2g(androidx.compose.animation.AnimatedContentTransitionScopeImpl $this) {
        return $this.getCurrentSize-YbymL2g();
    }

    private final long calculateOffset-emnUabE(long fullSize, long currentSize) {
        return getContentAlignment().align-KFBX0sM(fullSize, obj2, obj9);
    }

    private static final boolean createSizeAnimationModifier$lambda$2(MutableState<Boolean> $shouldAnimateSize$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)(State)$shouldAnimateSize$delegate.getValue().booleanValue();
    }

    private static final void createSizeAnimationModifier$lambda$3(MutableState<Boolean> $shouldAnimateSize$delegate, boolean value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $shouldAnimateSize$delegate.setValue(Boolean.valueOf(value));
    }

    private final long getCurrentSize-YbymL2g() {
        long measuredSize-YbymL2g$animation_release;
        State animatedSize = this.animatedSize;
        if (animatedSize != null) {
            measuredSize-YbymL2g$animation_release = (IntSize)animatedSize.getValue().unbox-impl();
        } else {
            measuredSize-YbymL2g$animation_release = getMeasuredSize-YbymL2g$animation_release();
        }
        return measuredSize-YbymL2g$animation_release;
    }

    private final boolean isLeft-gWo6LJ4(int $this$isLeft) {
        boolean layoutDirection;
        int i;
        LayoutDirection rtl;
        if (!AnimatedContentTransitionScope.SlideDirection.equals-impl0($this$isLeft, AnimatedContentTransitionScope.SlideDirection.Companion.getLeft-DKzdypw())) {
            if (AnimatedContentTransitionScope.SlideDirection.equals-impl0($this$isLeft, AnimatedContentTransitionScope.SlideDirection.Companion.getStart-DKzdypw())) {
                if (this.layoutDirection != LayoutDirection.Ltr) {
                    if (AnimatedContentTransitionScope.SlideDirection.equals-impl0($this$isLeft, AnimatedContentTransitionScope.SlideDirection.Companion.getEnd-DKzdypw()) && this.layoutDirection == LayoutDirection.Rtl) {
                        if (this.layoutDirection == LayoutDirection.Rtl) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final boolean isRight-gWo6LJ4(int $this$isRight) {
        boolean layoutDirection;
        int i;
        LayoutDirection ltr;
        if (!AnimatedContentTransitionScope.SlideDirection.equals-impl0($this$isRight, AnimatedContentTransitionScope.SlideDirection.Companion.getRight-DKzdypw())) {
            if (AnimatedContentTransitionScope.SlideDirection.equals-impl0($this$isRight, AnimatedContentTransitionScope.SlideDirection.Companion.getStart-DKzdypw())) {
                if (this.layoutDirection != LayoutDirection.Rtl) {
                    if (AnimatedContentTransitionScope.SlideDirection.equals-impl0($this$isRight, AnimatedContentTransitionScope.SlideDirection.Companion.getEnd-DKzdypw()) && this.layoutDirection == LayoutDirection.Ltr) {
                        if (this.layoutDirection == LayoutDirection.Ltr) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public final Modifier createSizeAnimationModifier$animation_release(androidx.compose.animation.ContentTransform contentTransform, Composer $composer, int $changed) {
        boolean equal;
        Object deferredAnimation;
        boolean traceInProgress;
        Object targetState;
        String str2;
        int i3;
        Object rememberedValue;
        int rememberedValue2;
        int i;
        String str;
        Object $i$a$CacheAnimatedContentTransitionScopeImpl$createSizeAnimationModifier$1;
        int empty2;
        int clipToBounds;
        Object $i$a$CacheAnimatedContentTransitionScopeImpl$createSizeAnimationModifier$shouldAnimateSize$2;
        Object empty;
        Boolean valueOf;
        int i2;
        int sizeModifier;
        Object value;
        final Composer composer2 = $composer;
        int i4 = 93755870;
        ComposerKt.sourceInformationMarkerStart(composer2, i4, "C(createSizeAnimationModifier)574@27302L40,575@27371L52:AnimatedContent.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.animation.AnimatedContentTransitionScopeImpl.createSizeAnimationModifier (AnimatedContent.kt:573)");
        } else {
            i = $changed;
        }
        str = "CC(remember):AnimatedContent.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer2, -546171924, str);
        Composer composer = $composer;
        i3 = 0;
        rememberedValue = composer.rememberedValue();
        rememberedValue2 = 0;
        empty2 = 0;
        clipToBounds = 0;
        if (!composer2.changed(this)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i13 = 0;
                composer.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(clipToBounds), empty2, 2, empty2));
            } else {
                $i$a$CacheAnimatedContentTransitionScopeImpl$createSizeAnimationModifier$shouldAnimateSize$2 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(contentTransform.getSizeTransform(), composer2, clipToBounds);
        sizeModifier = 1;
        if (Intrinsics.areEqual(this.transition.getCurrentState(), this.transition.getTargetState())) {
            AnimatedContentTransitionScopeImpl.createSizeAnimationModifier$lambda$3((MutableState)$i$a$CacheAnimatedContentTransitionScopeImpl$createSizeAnimationModifier$shouldAnimateSize$2, clipToBounds);
        } else {
            if (rememberUpdatedState.getValue() != null) {
                AnimatedContentTransitionScopeImpl.createSizeAnimationModifier$lambda$3($i$a$CacheAnimatedContentTransitionScopeImpl$createSizeAnimationModifier$shouldAnimateSize$2, sizeModifier);
            }
        }
        if (AnimatedContentTransitionScopeImpl.createSizeAnimationModifier$lambda$2($i$a$CacheAnimatedContentTransitionScopeImpl$createSizeAnimationModifier$shouldAnimateSize$2)) {
            composer2.startReplaceGroup(249037309);
            ComposerKt.sourceInformation(composer2, "585@27840L48,586@27901L205");
            deferredAnimation = TransitionKt.createDeferredAnimation(this.transition, VectorConvertersKt.getVectorConverter(IntSize.Companion), 0, composer2, 0, 2);
            ComposerKt.sourceInformationMarkerStart(composer2, -546152591, str);
            i3 = $composer;
            rememberedValue = 0;
            rememberedValue2 = i3.rememberedValue();
            str = 0;
            if (!composer2.changed(deferredAnimation)) {
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int i12 = 0;
                    value = rememberUpdatedState.getValue();
                    if (value != null && !(SizeTransform)value.getClip()) {
                        if (!value.getClip()) {
                            clipToBounds = sizeModifier;
                        }
                    }
                    if (clipToBounds != 0) {
                        clipToBounds = Modifier.Companion;
                    } else {
                        clipToBounds = ClipKt.clipToBounds((Modifier)Modifier.Companion);
                    }
                    sizeModifier = new AnimatedContentTransitionScopeImpl.SizeModifier(this, deferredAnimation, rememberUpdatedState);
                    i3.updateRememberedValue(clipToBounds.then((Modifier)sizeModifier));
                } else {
                    $i$a$CacheAnimatedContentTransitionScopeImpl$createSizeAnimationModifier$1 = rememberedValue2;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(249353726);
            composer2.endReplaceGroup();
            this.animatedSize = empty2;
            $i$a$CacheAnimatedContentTransitionScopeImpl$createSizeAnimationModifier$1 = deferredAnimation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return $i$a$CacheAnimatedContentTransitionScopeImpl$createSizeAnimationModifier$1;
    }

    public final State<IntSize> getAnimatedSize$animation_release() {
        return this.animatedSize;
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public Alignment getContentAlignment() {
        return this.contentAlignment;
    }

    public S getInitialState() {
        return this.transition.getSegment().getInitialState();
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public final LayoutDirection getLayoutDirection$animation_release() {
        return this.layoutDirection;
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public final long getMeasuredSize-YbymL2g$animation_release() {
        final int i = 0;
        final int i2 = 0;
        return (IntSize)(State)this.measuredSize$delegate.getValue().unbox-impl();
    }

    public final MutableScatterMap<S, State<IntSize>> getTargetSizeMap$animation_release() {
        return this.targetSizeMap;
    }

    public S getTargetState() {
        return this.transition.getSegment().getTargetState();
    }

    public final Transition<S> getTransition$animation_release() {
        return this.transition;
    }

    public final void setAnimatedSize$animation_release(State<IntSize> <set-?>) {
        this.animatedSize = <set-?>;
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public void setContentAlignment(Alignment <set-?>) {
        this.contentAlignment = <set-?>;
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public final void setLayoutDirection$animation_release(LayoutDirection <set-?>) {
        this.layoutDirection = <set-?>;
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public final void setMeasuredSize-ozmzZPI$animation_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.measuredSize$delegate.setValue(IntSize.box-impl(<set-?>));
    }

    public androidx.compose.animation.EnterTransition slideIntoContainer-mOhB8PU(int towards, FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> initialOffset) {
        androidx.compose.animation.EnterTransition slideInHorizontally;
        if (isLeft-gWo6LJ4(towards)) {
            AnimatedContentTransitionScopeImpl.slideIntoContainer.1 anon4 = new AnimatedContentTransitionScopeImpl.slideIntoContainer.1(initialOffset, this);
            slideInHorizontally = EnterExitTransitionKt.slideInHorizontally(animationSpec, (Function1)anon4);
        } else {
            if (isRight-gWo6LJ4(towards)) {
                AnimatedContentTransitionScopeImpl.slideIntoContainer.2 anon = new AnimatedContentTransitionScopeImpl.slideIntoContainer.2(initialOffset, this);
                slideInHorizontally = EnterExitTransitionKt.slideInHorizontally(animationSpec, (Function1)anon);
            } else {
                if (AnimatedContentTransitionScope.SlideDirection.equals-impl0(towards, AnimatedContentTransitionScope.SlideDirection.Companion.getUp-DKzdypw())) {
                    AnimatedContentTransitionScopeImpl.slideIntoContainer.3 anon3 = new AnimatedContentTransitionScopeImpl.slideIntoContainer.3(initialOffset, this);
                    slideInHorizontally = EnterExitTransitionKt.slideInVertically(animationSpec, (Function1)anon3);
                } else {
                    if (AnimatedContentTransitionScope.SlideDirection.equals-impl0(towards, AnimatedContentTransitionScope.SlideDirection.Companion.getDown-DKzdypw())) {
                        AnimatedContentTransitionScopeImpl.slideIntoContainer.4 anon2 = new AnimatedContentTransitionScopeImpl.slideIntoContainer.4(initialOffset, this);
                        slideInHorizontally = EnterExitTransitionKt.slideInVertically(animationSpec, (Function1)anon2);
                    } else {
                        slideInHorizontally = EnterTransition.Companion.getNone();
                    }
                }
            }
        }
        return slideInHorizontally;
    }

    public androidx.compose.animation.ExitTransition slideOutOfContainer-mOhB8PU(int towards, FiniteAnimationSpec<IntOffset> animationSpec, Function1<? super Integer, Integer> targetOffset) {
        androidx.compose.animation.ExitTransition slideOutHorizontally;
        if (isLeft-gWo6LJ4(towards)) {
            AnimatedContentTransitionScopeImpl.slideOutOfContainer.1 anon4 = new AnimatedContentTransitionScopeImpl.slideOutOfContainer.1(this, targetOffset);
            slideOutHorizontally = EnterExitTransitionKt.slideOutHorizontally(animationSpec, (Function1)anon4);
        } else {
            if (isRight-gWo6LJ4(towards)) {
                AnimatedContentTransitionScopeImpl.slideOutOfContainer.2 anon = new AnimatedContentTransitionScopeImpl.slideOutOfContainer.2(this, targetOffset);
                slideOutHorizontally = EnterExitTransitionKt.slideOutHorizontally(animationSpec, (Function1)anon);
            } else {
                if (AnimatedContentTransitionScope.SlideDirection.equals-impl0(towards, AnimatedContentTransitionScope.SlideDirection.Companion.getUp-DKzdypw())) {
                    AnimatedContentTransitionScopeImpl.slideOutOfContainer.3 anon3 = new AnimatedContentTransitionScopeImpl.slideOutOfContainer.3(this, targetOffset);
                    slideOutHorizontally = EnterExitTransitionKt.slideOutVertically(animationSpec, (Function1)anon3);
                } else {
                    if (AnimatedContentTransitionScope.SlideDirection.equals-impl0(towards, AnimatedContentTransitionScope.SlideDirection.Companion.getDown-DKzdypw())) {
                        AnimatedContentTransitionScopeImpl.slideOutOfContainer.4 anon2 = new AnimatedContentTransitionScopeImpl.slideOutOfContainer.4(this, targetOffset);
                        slideOutHorizontally = EnterExitTransitionKt.slideOutVertically(animationSpec, (Function1)anon2);
                    } else {
                        slideOutHorizontally = ExitTransition.Companion.getNone();
                    }
                }
            }
        }
        return slideOutHorizontally;
    }

    @Override // androidx.compose.animation.AnimatedContentTransitionScope
    public androidx.compose.animation.ContentTransform using(androidx.compose.animation.ContentTransform $this$using, androidx.compose.animation.SizeTransform sizeTransform) {
        final int i = 0;
        $this$using.setSizeTransform$animation_release(sizeTransform);
        return $this$using;
    }
}
