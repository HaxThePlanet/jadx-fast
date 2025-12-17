package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0099\u0001\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001e\u0010\u000c\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u000f\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J!\u00101\u001a\u001a\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0008\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J!\u00102\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0008\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J!\u00103\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0008\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\u000f\u00106\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\t\u00107\u001a\u00020\u0015HÆ\u0003J­\u0001\u00108\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042 \u0008\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0008\u0012\u0004\u0012\u00020\u00050\u00042 \u0008\u0002\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0008\u0012\u0004\u0012\u00020\u00050\u00042 \u0008\u0002\u0010\u000c\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u000e\u0008\u0002\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u00122\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0008\u00109\u001a\u00020\u0002H\u0016J\u0013\u0010:\u001a\u00020\u00132\u0008\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020@HÖ\u0001J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0002H\u0016J\u000c\u0010D\u001a\u00020B*\u00020EH\u0016R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"R \u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010#\"\u0004\u0008$\u0010%R2\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010'\"\u0004\u0008(\u0010)R2\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008*\u0010'\"\u0004\u0008+\u0010)R2\u0010\u000c\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008,\u0010'\"\u0004\u0008-\u0010)R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/¨\u0006F", d2 = {"Landroidx/compose/animation/EnterExitTransitionElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/EnterExitTransitionModifierNode;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "slideAnimation", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "isEnabled", "Lkotlin/Function0;", "", "graphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "getGraphicsLayerBlock", "()Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "setGraphicsLayerBlock", "(Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "getOffsetAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setOffsetAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getSizeAnimation", "setSizeAnimation", "getSlideAnimation", "setSlideAnimation", "getTransition", "()Landroidx/compose/animation/core/Transition;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class EnterExitTransitionElement extends ModifierNodeElement<androidx.compose.animation.EnterExitTransitionModifierNode> {

    private androidx.compose.animation.EnterTransition enter;
    private androidx.compose.animation.ExitTransition exit;
    private androidx.compose.animation.GraphicsLayerBlockForEnterExit graphicsLayerBlock;
    private Function0<Boolean> isEnabled;
    private Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> offsetAnimation;
    private Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntSize, AnimationVector2D> sizeAnimation;
    private Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> slideAnimation;
    private final Transition<androidx.compose.animation.EnterExitState> transition;
    public EnterExitTransitionElement(Transition<androidx.compose.animation.EnterExitState> transition, Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntSize, AnimationVector2D> sizeAnimation, Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> offsetAnimation, Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> slideAnimation, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, Function0<Boolean> isEnabled, androidx.compose.animation.GraphicsLayerBlockForEnterExit graphicsLayerBlock) {
        super();
        this.transition = transition;
        this.sizeAnimation = sizeAnimation;
        this.offsetAnimation = offsetAnimation;
        this.slideAnimation = slideAnimation;
        this.enter = enter;
        this.exit = exit;
        this.isEnabled = isEnabled;
        this.graphicsLayerBlock = graphicsLayerBlock;
    }

    public static androidx.compose.animation.EnterExitTransitionElement copy$default(androidx.compose.animation.EnterExitTransitionElement enterExitTransitionElement, Transition transition2, Transition.DeferredAnimation transition$DeferredAnimation3, Transition.DeferredAnimation transition$DeferredAnimation4, Transition.DeferredAnimation transition$DeferredAnimation5, androidx.compose.animation.EnterTransition enterTransition6, androidx.compose.animation.ExitTransition exitTransition7, Function0 function08, androidx.compose.animation.GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit9, int i10, Object object11) {
        Transition obj1;
        Transition.DeferredAnimation obj2;
        Transition.DeferredAnimation obj3;
        Transition.DeferredAnimation obj4;
        androidx.compose.animation.EnterTransition obj5;
        androidx.compose.animation.ExitTransition obj6;
        Function0 obj7;
        androidx.compose.animation.GraphicsLayerBlockForEnterExit obj8;
        if (i10 & 1 != 0) {
            obj1 = enterExitTransitionElement.transition;
        }
        if (i10 & 2 != 0) {
            obj2 = enterExitTransitionElement.sizeAnimation;
        }
        if (i10 & 4 != 0) {
            obj3 = enterExitTransitionElement.offsetAnimation;
        }
        if (i10 & 8 != 0) {
            obj4 = enterExitTransitionElement.slideAnimation;
        }
        if (i10 & 16 != 0) {
            obj5 = enterExitTransitionElement.enter;
        }
        if (i10 & 32 != 0) {
            obj6 = enterExitTransitionElement.exit;
        }
        if (i10 & 64 != 0) {
            obj7 = enterExitTransitionElement.isEnabled;
        }
        if (i10 &= 128 != 0) {
            obj8 = enterExitTransitionElement.graphicsLayerBlock;
        }
        return enterExitTransitionElement.copy(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    public final Transition<androidx.compose.animation.EnterExitState> component1() {
        return this.transition;
    }

    public final Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntSize, AnimationVector2D> component2() {
        return this.sizeAnimation;
    }

    public final Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> component3() {
        return this.offsetAnimation;
    }

    public final Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> component4() {
        return this.slideAnimation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.EnterTransition component5() {
        return this.enter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.ExitTransition component6() {
        return this.exit;
    }

    public final Function0<Boolean> component7() {
        return this.isEnabled;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.GraphicsLayerBlockForEnterExit component8() {
        return this.graphicsLayerBlock;
    }

    public final androidx.compose.animation.EnterExitTransitionElement copy(Transition<androidx.compose.animation.EnterExitState> transition, Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntSize, AnimationVector2D> transition.DeferredAnimation2, Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> transition.DeferredAnimation3, Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> transition.DeferredAnimation4, androidx.compose.animation.EnterTransition enterTransition5, androidx.compose.animation.ExitTransition exitTransition6, Function0<Boolean> function07, androidx.compose.animation.GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExit8) {
        EnterExitTransitionElement enterExitTransitionElement = new EnterExitTransitionElement(transition, transition.DeferredAnimation2, transition.DeferredAnimation3, transition.DeferredAnimation4, enterTransition5, exitTransition6, function07, graphicsLayerBlockForEnterExit8);
        return enterExitTransitionElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.animation.EnterExitTransitionModifierNode create() {
        EnterExitTransitionModifierNode enterExitTransitionModifierNode = new EnterExitTransitionModifierNode(this.transition, this.sizeAnimation, this.offsetAnimation, this.slideAnimation, this.enter, this.exit, this.isEnabled, this.graphicsLayerBlock);
        return enterExitTransitionModifierNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof EnterExitTransitionElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.transition, obj.transition)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.sizeAnimation, obj.sizeAnimation)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.offsetAnimation, obj.offsetAnimation)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.slideAnimation, obj.slideAnimation)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.enter, obj.enter)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.exit, obj.exit)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.isEnabled, obj.isEnabled)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.graphicsLayerBlock, obj.graphicsLayerBlock)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.EnterTransition getEnter() {
        return this.enter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.ExitTransition getExit() {
        return this.exit;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.GraphicsLayerBlockForEnterExit getGraphicsLayerBlock() {
        return this.graphicsLayerBlock;
    }

    public final Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    public final Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    public final Transition.DeferredAnimation<androidx.compose.animation.EnterExitState, IntOffset, AnimationVector2D> getSlideAnimation() {
        return this.slideAnimation;
    }

    public final Transition<androidx.compose.animation.EnterExitState> getTransition() {
        return this.transition;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i2;
        int i3;
        Transition.DeferredAnimation slideAnimation;
        int i;
        i = 0;
        if (this.sizeAnimation == null) {
            i2 = i;
        } else {
            i2 = this.sizeAnimation.hashCode();
        }
        if (this.offsetAnimation == null) {
            i3 = i;
        } else {
            i3 = this.offsetAnimation.hashCode();
        }
        if (this.slideAnimation == null) {
        } else {
            i = this.slideAnimation.hashCode();
        }
        return i17 += i22;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("enterExitTransition");
        $this$inspectableProperties.getProperties().set("transition", this.transition);
        $this$inspectableProperties.getProperties().set("sizeAnimation", this.sizeAnimation);
        $this$inspectableProperties.getProperties().set("offsetAnimation", this.offsetAnimation);
        $this$inspectableProperties.getProperties().set("slideAnimation", this.slideAnimation);
        $this$inspectableProperties.getProperties().set("enter", this.enter);
        $this$inspectableProperties.getProperties().set("exit", this.exit);
        $this$inspectableProperties.getProperties().set("graphicsLayerBlock", this.graphicsLayerBlock);
    }

    public final Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(Function0<Boolean> <set-?>) {
        this.isEnabled = <set-?>;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void setEnter(androidx.compose.animation.EnterTransition <set-?>) {
        this.enter = <set-?>;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void setExit(androidx.compose.animation.ExitTransition <set-?>) {
        this.exit = <set-?>;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
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

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("EnterExitTransitionElement(transition=").append(this.transition).append(", sizeAnimation=").append(this.sizeAnimation).append(", offsetAnimation=").append(this.offsetAnimation).append(", slideAnimation=").append(this.slideAnimation).append(", enter=").append(this.enter).append(", exit=").append(this.exit).append(", isEnabled=").append(this.isEnabled).append(", graphicsLayerBlock=").append(this.graphicsLayerBlock).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.animation.EnterExitTransitionModifierNode node) {
        node.setTransition(this.transition);
        node.setSizeAnimation(this.sizeAnimation);
        node.setOffsetAnimation(this.offsetAnimation);
        node.setSlideAnimation(this.slideAnimation);
        node.setEnter(this.enter);
        node.setExit(this.exit);
        node.setEnabled(this.isEnabled);
        node.setGraphicsLayerBlock(this.graphicsLayerBlock);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((EnterExitTransitionModifierNode)node);
    }
}
