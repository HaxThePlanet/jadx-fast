package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.animation.core.Transition.Segment;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0006R\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0006R\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0006R\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0008\u0010J\u001a\u00020KH\u0016J \u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\u0008O\u0010PJ \u0010Q\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\u0008R\u0010PJ \u0010S\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\u0008T\u0010PJ&\u0010U\u001a\u00020V*\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020.H\u0016ø\u0001\u0000¢\u0006\u0004\u0008[\u0010\\R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u0019\"\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\u000c\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010#\"\u0004\u0008$\u0010%R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010'\"\u0004\u0008(\u0010)R \u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010*\"\u0004\u0008+\u0010,R&\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020.@BX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\"\u0004\u00080\u00101R\u000e\u00103\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\u00020\u0007X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00102R2\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0006R\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00085\u00106\"\u0004\u00087\u00108R2\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0006R\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00089\u00106\"\u0004\u0008:\u00108R.\u0010;\u001a\u001f\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040=\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070>0<¢\u0006\u0002\u0008?¢\u0006\u0008\n\u0000\u001a\u0004\u0008@\u0010AR2\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0006R\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008B\u00106\"\u0004\u0008C\u00108R.\u0010D\u001a\u001f\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040=\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0>0<¢\u0006\u0002\u0008?¢\u0006\u0008\n\u0000\u001a\u0004\u0008E\u0010AR \u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008F\u0010G\"\u0004\u0008H\u0010I\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006]", d2 = {"Landroidx/compose/animation/EnterExitTransitionModifierNode;", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "slideAnimation", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "isEnabled", "Lkotlin/Function0;", "", "graphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "alignment", "Landroidx/compose/ui/Alignment;", "getAlignment", "()Landroidx/compose/ui/Alignment;", "currentAlignment", "getCurrentAlignment", "setCurrentAlignment", "(Landroidx/compose/ui/Alignment;)V", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "getGraphicsLayerBlock", "()Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "setGraphicsLayerBlock", "(Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "value", "Landroidx/compose/ui/unit/Constraints;", "lookaheadConstraints", "setLookaheadConstraints-BRTryo0", "(J)V", "J", "lookaheadConstraintsAvailable", "lookaheadSize", "getOffsetAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setOffsetAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getSizeAnimation", "setSizeAnimation", "sizeTransitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getSizeTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "getSlideAnimation", "setSlideAnimation", "slideSpec", "getSlideSpec", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "(Landroidx/compose/animation/core/Transition;)V", "onAttach", "", "sizeByState", "targetState", "fullSize", "sizeByState-Uzc_VyU", "(Landroidx/compose/animation/EnterExitState;J)J", "slideTargetValueByState", "slideTargetValueByState-oFUgxo0", "targetOffsetByState", "targetOffsetByState-oFUgxo0", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class EnterExitTransitionModifierNode extends androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics {

    private Alignment currentAlignment;
    private androidx.compose.animation.EnterTransition enter;
    private androidx.compose.animation.ExitTransition exit;
    private androidx.compose.animation.GraphicsLayerBlockForEnterExit graphicsLayerBlock;
    private Function0<Boolean> isEnabled;
    private long lookaheadConstraints;
    private boolean lookaheadConstraintsAvailable;
    private long lookaheadSize;
    private Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> offsetAnimation;
    private Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntSize, AnimationVector2D> sizeAnimation;
    private final Function1<Transition.Segment<androidx.compose.animation.EnterExitState>, FiniteAnimationSpec<IntSize>> sizeTransitionSpec;
    private Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> slideAnimation;
    private final Function1<Transition.Segment<androidx.compose.animation.EnterExitState>, FiniteAnimationSpec<IntOffset>> slideSpec;
    private Transition<androidx.compose.animation.EnterExitState> transition;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[EnterExitState.Visible.ordinal()] = 1;
            iArr[EnterExitState.PreEnter.ordinal()] = 2;
            iArr[EnterExitState.PostExit.ordinal()] = 3;
            EnterExitTransitionModifierNode.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public EnterExitTransitionModifierNode(Transition<androidx.compose.animation.EnterExitState> transition, Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntSize, AnimationVector2D> sizeAnimation, Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> offsetAnimation, Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> slideAnimation, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, Function0<Boolean> isEnabled, androidx.compose.animation.GraphicsLayerBlockForEnterExit graphicsLayerBlock) {
        final Object obj = this;
        super();
        obj.transition = transition;
        obj.sizeAnimation = sizeAnimation;
        obj.offsetAnimation = offsetAnimation;
        obj.slideAnimation = slideAnimation;
        obj.enter = enter;
        obj.exit = exit;
        obj.isEnabled = isEnabled;
        obj.graphicsLayerBlock = graphicsLayerBlock;
        obj.lookaheadSize = AnimationModifierKt.getInvalidSize();
        obj.lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, 0);
        EnterExitTransitionModifierNode.sizeTransitionSpec.1 anon = new EnterExitTransitionModifierNode.sizeTransitionSpec.1(obj);
        obj.sizeTransitionSpec = (Function1)anon;
        EnterExitTransitionModifierNode.slideSpec.1 anon2 = new EnterExitTransitionModifierNode.slideSpec.1(obj);
        obj.slideSpec = (Function1)anon2;
    }

    private final void setLookaheadConstraints-BRTryo0(long value) {
        this.lookaheadConstraintsAvailable = true;
        this.lookaheadConstraints = value;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final Alignment getAlignment() {
        Object changeSize;
        int alignment;
        final int i = 0;
        alignment = 0;
        if (this.transition.getSegment().isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
            changeSize = this.enter.getData$animation_release().getChangeSize();
            if (changeSize != null) {
                changeSize = changeSize.getAlignment();
                if (changeSize == null) {
                    changeSize = this.exit.getData$animation_release().getChangeSize();
                    if (changeSize != null) {
                        alignment = changeSize.getAlignment();
                    }
                } else {
                    alignment = changeSize;
                }
            } else {
            }
        } else {
            changeSize = this.exit.getData$animation_release().getChangeSize();
            if (changeSize != null) {
                changeSize = changeSize.getAlignment();
                if (changeSize == null) {
                    changeSize = this.enter.getData$animation_release().getChangeSize();
                    if (changeSize != null) {
                        alignment = changeSize.getAlignment();
                    }
                } else {
                    alignment = changeSize;
                }
            } else {
            }
        }
        return alignment;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final androidx.compose.animation.EnterTransition getEnter() {
        return this.enter;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final androidx.compose.animation.ExitTransition getExit() {
        return this.exit;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final androidx.compose.animation.GraphicsLayerBlockForEnterExit getGraphicsLayerBlock() {
        return this.graphicsLayerBlock;
    }

    public final Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    public final Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    public final Function1<Transition.Segment<androidx.compose.animation.EnterExitState>, FiniteAnimationSpec<IntSize>> getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    public final Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> getSlideAnimation() {
        return this.slideAnimation;
    }

    public final Function1<Transition.Segment<androidx.compose.animation.EnterExitState>, FiniteAnimationSpec<IntOffset>> getSlideSpec() {
        return this.slideSpec;
    }

    public final Transition<androidx.compose.animation.EnterExitState> getTransition() {
        return this.transition;
    }

    public final Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Object currentAlignment;
        int animate;
        Object sizeAnimation;
        Object companion;
        Object companion2;
        Object slideAnimation;
        Object offsetAnimation;
        long lookaheadSize;
        long iNSTANCE;
        long zero-nOcc-ac;
        long zero-nOcc-ac2;
        androidx.compose.animation.EnterExitTransitionModifierNode.measure.offsetDelta.2 anon;
        long l3;
        long l;
        long l2;
        long align-KFBX0sM;
        long currentSize;
        final Object obj = this;
        final long l4 = constraints;
        if (obj.transition.getCurrentState() == obj.transition.getTargetState()) {
            obj.currentAlignment = 0;
        } else {
            if (obj.currentAlignment == null && obj.getAlignment() == null) {
                if (obj.getAlignment() == null) {
                    currentAlignment = Alignment.Companion.getTopStart();
                }
                obj.currentAlignment = currentAlignment;
            }
        }
        if ($this$measure_u2d3p2s80s.isLookingAhead()) {
            Placeable measure-BRTryo02 = measurable.measure-BRTryo0(constraints);
            int height2 = measure-BRTryo02.getHeight();
            long l6 = IntSizeKt.IntSize(measure-BRTryo02.getWidth(), height2);
            obj.lookaheadSize = l6;
            obj.setLookaheadConstraints-BRTryo0(l4);
            EnterExitTransitionModifierNode.measure.1 anon4 = new EnterExitTransitionModifierNode.measure.1(measure-BRTryo02);
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, IntSize.getWidth-impl(l6), IntSize.getHeight-impl(l6), 0, (Function1)anon4, 4, 0);
        }
        if ((Boolean)obj.isEnabled.invoke().booleanValue()) {
            Function1 init = obj.graphicsLayerBlock.init();
            Placeable measure-BRTryo03 = measurable.measure-BRTryo0(constraints);
            long l5 = IntSizeKt.IntSize(measure-BRTryo03.getWidth(), measure-BRTryo03.getHeight());
            lookaheadSize = AnimationModifierKt.isValid-ozmzZPI(obj.lookaheadSize) ? obj.lookaheadSize : l5;
            long l7 = lookaheadSize;
            sizeAnimation = obj.sizeAnimation;
            if (sizeAnimation != null) {
                lookaheadSize = new EnterExitTransitionModifierNode.measure.animSize.1(obj, l7, obj15);
                animate = sizeAnimation.animate(obj.sizeTransitionSpec, (Function1)lookaheadSize);
            }
            if (animate != 0) {
                iNSTANCE = (IntSize)animate.getValue().unbox-impl();
            } else {
                iNSTANCE = l5;
            }
            final long constrain-4WqzIAM = ConstraintsKt.constrain-4WqzIAM(l4, obj2);
            offsetAnimation = obj.offsetAnimation;
            anon = new EnterExitTransitionModifierNode.measure.offsetDelta.2(obj, l7, obj15);
            offsetAnimation = offsetAnimation.animate((Function1)EnterExitTransitionModifierNode.measure.offsetDelta.1.INSTANCE, (Function1)anon);
            if (offsetAnimation != null && offsetAnimation != null) {
                anon = new EnterExitTransitionModifierNode.measure.offsetDelta.2(obj, l7, obj15);
                offsetAnimation = offsetAnimation.animate((Function1)EnterExitTransitionModifierNode.measure.offsetDelta.1.INSTANCE, (Function1)anon);
                if (offsetAnimation != null) {
                    l3 = zero-nOcc-ac;
                } else {
                    l3 = zero-nOcc-ac;
                }
            } else {
            }
            slideAnimation = obj.slideAnimation;
            anon = new EnterExitTransitionModifierNode.measure.slideOffset.1(obj, l7, obj15);
            slideAnimation = slideAnimation.animate(obj.slideSpec, (Function1)anon);
            if (slideAnimation != null && slideAnimation != null) {
                anon = new EnterExitTransitionModifierNode.measure.slideOffset.1(obj, l7, obj15);
                slideAnimation = slideAnimation.animate(obj.slideSpec, (Function1)anon);
                if (slideAnimation != null) {
                    zero-nOcc-ac2 = (IntOffset)slideAnimation.getValue().unbox-impl();
                } else {
                    zero-nOcc-ac2 = IntOffset.Companion.getZero-nOcc-ac();
                }
            } else {
            }
            Alignment currentAlignment2 = obj.currentAlignment;
            if (currentAlignment2 != null) {
                currentSize = constrain-4WqzIAM;
                l2 = l7;
                l = align-KFBX0sM;
            } else {
                currentSize = constrain-4WqzIAM;
                l2 = l7;
                l = align-KFBX0sM;
            }
            final long l8 = zero-nOcc-ac2;
            long slideOffset = plus-qkQi6aY;
            EnterExitTransitionModifierNode.measure.2 anon3 = new EnterExitTransitionModifierNode.measure.2(measure-BRTryo03, slideOffset, anon, l3, obj11, init);
            final long l10 = slideOffset;
            final long l9 = l3;
            Function1 function1 = init;
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, IntSize.getWidth-impl(currentSize), IntSize.getHeight-impl(currentSize), 0, (Function1)anon3, 4, 0);
        }
        Placeable measure-BRTryo0 = measurable.measure-BRTryo0(constraints);
        int i = 0;
        EnterExitTransitionModifierNode.measure.3.1 anon2 = new EnterExitTransitionModifierNode.measure.3.1(measure-BRTryo0);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight(), 0, (Function1)anon2, 4, 0);
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public void onAttach() {
        super.onAttach();
        this.lookaheadConstraintsAvailable = false;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final void setCurrentAlignment(Alignment <set-?>) {
        this.currentAlignment = <set-?>;
    }

    public final void setEnabled(Function0<Boolean> <set-?>) {
        this.isEnabled = <set-?>;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final void setEnter(androidx.compose.animation.EnterTransition <set-?>) {
        this.enter = <set-?>;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final void setExit(androidx.compose.animation.ExitTransition <set-?>) {
        this.exit = <set-?>;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final void setGraphicsLayerBlock(androidx.compose.animation.GraphicsLayerBlockForEnterExit <set-?>) {
        this.graphicsLayerBlock = <set-?>;
    }

    public final void setOffsetAnimation(Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> <set-?>) {
        this.offsetAnimation = <set-?>;
    }

    public final void setSizeAnimation(Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntSize, AnimationVector2D> <set-?>) {
        this.sizeAnimation = <set-?>;
    }

    public final void setSlideAnimation(Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> <set-?>) {
        this.slideAnimation = <set-?>;
    }

    public final void setTransition(Transition<androidx.compose.animation.EnterExitState> <set-?>) {
        this.transition = <set-?>;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final long sizeByState-Uzc_VyU(androidx.compose.animation.EnterExitState targetState, long fullSize) {
        long unbox-impl;
        androidx.compose.animation.ChangeSize changeSize;
        IntSize box-impl;
        switch (changeSize) {
            case 1:
                break;
            case 2:
                changeSize = this.enter.getData$animation_release().getChangeSize();
                changeSize = changeSize.getSize();
                unbox-impl = (IntSize)changeSize.invoke(IntSize.box-impl(fullSize)).unbox-impl();
                return unbox-impl;
            case 3:
                changeSize = this.exit.getData$animation_release().getChangeSize();
                changeSize = changeSize.getSize();
                unbox-impl = (IntSize)changeSize.invoke(IntSize.box-impl(fullSize)).unbox-impl();
                return unbox-impl;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        unbox-impl = fullSize;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final long slideTargetValueByState-oFUgxo0(androidx.compose.animation.EnterExitState targetState, long fullSize) {
        Object slideOffset;
        long zero-nOcc-ac2;
        IntSize box-impl;
        Object slideOffset2;
        long zero-nOcc-ac3;
        IntSize box-impl2;
        long zero-nOcc-ac;
        slideOffset = this.enter.getData$animation_release().getSlide();
        slideOffset = slideOffset.getSlideOffset();
        if (slideOffset != null && slideOffset != null) {
            slideOffset = slideOffset.getSlideOffset();
            if (slideOffset != null) {
                zero-nOcc-ac2 = (IntOffset)slideOffset.invoke(IntSize.box-impl(fullSize)).unbox-impl();
            } else {
                zero-nOcc-ac2 = IntOffset.Companion.getZero-nOcc-ac();
            }
        } else {
        }
        slideOffset2 = this.exit.getData$animation_release().getSlide();
        slideOffset2 = slideOffset2.getSlideOffset();
        if (slideOffset2 != null && slideOffset2 != null) {
            slideOffset2 = slideOffset2.getSlideOffset();
            if (slideOffset2 != null) {
                zero-nOcc-ac3 = (IntOffset)slideOffset2.invoke(IntSize.box-impl(fullSize)).unbox-impl();
            } else {
                zero-nOcc-ac3 = IntOffset.Companion.getZero-nOcc-ac();
            }
        } else {
        }
        switch (i) {
            case 1:
                zero-nOcc-ac = IntOffset.Companion.getZero-nOcc-ac();
                break;
            case 2:
                zero-nOcc-ac = zero-nOcc-ac2;
                break;
            case 3:
                zero-nOcc-ac = zero-nOcc-ac3;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return zero-nOcc-ac;
    }

    @Override // androidx.compose.animation.LayoutModifierNodeWithPassThroughIntrinsics
    public final long targetOffsetByState-oFUgxo0(androidx.compose.animation.EnterExitState targetState, long fullSize) {
        long it;
        int alignment;
        long align-KFBX0sM;
        Alignment currentAlignment;
        long fullSize2;
        long unbox-impl;
        LayoutDirection ltr;
        IntOffset.Companion obj11;
        if (this.currentAlignment == null) {
            it = IntOffset.Companion.getZero-nOcc-ac();
            fullSize2 = fullSize;
            return it;
        } else {
            if (getAlignment() == null) {
                it = IntOffset.Companion.getZero-nOcc-ac();
                fullSize2 = fullSize;
            } else {
                if (Intrinsics.areEqual(this.currentAlignment, getAlignment())) {
                    it = IntOffset.Companion.getZero-nOcc-ac();
                    fullSize2 = fullSize;
                } else {
                    switch (i) {
                        case 1:
                            fullSize2 = fullSize;
                            it = IntOffset.Companion.getZero-nOcc-ac();
                            break;
                        case 2:
                            fullSize2 = fullSize;
                            it = IntOffset.Companion.getZero-nOcc-ac();
                            break;
                        case 3:
                            androidx.compose.animation.ChangeSize changeSize = this.exit.getData$animation_release().getChangeSize();
                            alignment = 0;
                            unbox-impl = (IntSize)changeSize.getSize().invoke(IntSize.box-impl(fullSize)).unbox-impl();
                            Alignment alignment3 = getAlignment();
                            Intrinsics.checkNotNull(alignment3);
                            fullSize2 = fullSize;
                            currentAlignment = this.currentAlignment;
                            Intrinsics.checkNotNull(currentAlignment);
                            it = IntOffset.minus-qkQi6aY(alignment3.align-KFBX0sM(fullSize2, obj5, unbox-impl), obj12);
                            fullSize2 = fullSize;
                            it = IntOffset.Companion.getZero-nOcc-ac();
                            break;
                        default:
                            IntOffset.Companion companion4 = fullSize;
                            obj11 = new NoWhenBranchMatchedException();
                            throw obj11;
                    }
                }
            }
        }
    }
}
