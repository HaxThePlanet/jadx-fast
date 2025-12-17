package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction.Press;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0002\u0010\u000eJ*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0008\u0010 \u001a\u00020\u0010H\u0002J\u0008\u0010!\u001a\u00020\u0017H\u0016J\u0008\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000c\u0010$\u001a\u00020\u0017*\u00020%H\u0016R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012@BX\u0082\u000e¢\u0006\u0008\n\u0000\"\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006&", d2 = {"Landroidx/compose/material/ripple/AndroidRippleNode;", "Landroidx/compose/material/ripple/RippleNode;", "Landroidx/compose/material/ripple/RippleHostKey;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "rippleContainer", "Landroidx/compose/material/ripple/RippleContainer;", "value", "Landroidx/compose/material/ripple/RippleHostView;", "rippleHostView", "setRippleHostView", "(Landroidx/compose/material/ripple/RippleHostView;)V", "addRipple", "", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "Landroidx/compose/ui/geometry/Size;", "targetRadius", "", "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "getOrCreateRippleContainer", "onDetach", "onResetRippleHostView", "removeRipple", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidRippleNode extends androidx.compose.material.ripple.RippleNode implements androidx.compose.material.ripple.RippleHostKey {

    public static final int $stable = 8;
    private androidx.compose.material.ripple.RippleContainer rippleContainer;
    private androidx.compose.material.ripple.RippleHostView rippleHostView;
    static {
        final int i = 8;
    }

    private AndroidRippleNode(InteractionSource interactionSource, boolean bounded, float radius, ColorProducer color, Function0<androidx.compose.material.ripple.RippleAlpha> rippleAlpha) {
        super(interactionSource, bounded, radius, color, rippleAlpha, 0);
    }

    public AndroidRippleNode(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer4, Function0 function05, DefaultConstructorMarker defaultConstructorMarker6) {
        super(interactionSource, z2, f3, colorProducer4, function05);
    }

    private final androidx.compose.material.ripple.RippleContainer getOrCreateRippleContainer() {
        if (this.rippleContainer != null) {
            androidx.compose.material.ripple.RippleContainer rippleContainer2 = this.rippleContainer;
            Intrinsics.checkNotNull(rippleContainer2);
            return rippleContainer2;
        }
        this.rippleContainer = Ripple_androidKt.access$createAndAttachRippleContainerIfNeeded(Ripple_androidKt.access$findNearestViewGroup((View)CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)AndroidCompositionLocals_androidKt.getLocalView())));
        androidx.compose.material.ripple.RippleContainer rippleContainer4 = this.rippleContainer;
        Intrinsics.checkNotNull(rippleContainer4);
        return rippleContainer4;
    }

    private final void setRippleHostView(androidx.compose.material.ripple.RippleHostView value) {
        this.rippleHostView = value;
        DrawModifierNodeKt.invalidateDraw((DrawModifierNode)this);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void addRipple-12SF9DM(PressInteraction.Press interaction, long size, float targetRadius) {
        final int i = 0;
        androidx.compose.material.ripple.RippleHostView rippleHostView = getOrCreateRippleContainer().getRippleHostView((RippleHostKey)this);
        final int i2 = 0;
        AndroidRippleNode.addRipple.1.1.1 anon = new AndroidRippleNode.addRipple.1.1.1(this);
        rippleHostView.addRipple-KOepWvA(interaction, getBounded(), size, obj7, MathKt.roundToInt(obj18), getRippleColor-0d7_KjU(), obj10);
        setRippleHostView(rippleHostView);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void drawRipples(DrawScope $this$drawRipples) {
        androidx.compose.material.ripple.RippleHostView rippleHostView;
        androidx.compose.material.ripple.RippleHostView view;
        android.graphics.Canvas nativeCanvas;
        long rippleColor-0d7_KjU;
        float pressedAlpha;
        final int i = 0;
        final int i2 = 0;
        rippleHostView = this.rippleHostView;
        if (rippleHostView != null) {
            view = rippleHostView;
            rippleHostView = 0;
            view.setRippleProperties-07v42R4(getRippleSize-NH-jbRc(), obj7, getRippleColor-0d7_KjU());
            view.draw(AndroidCanvas_androidKt.getNativeCanvas($this$drawRipples.getDrawContext().getCanvas()));
        }
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void onDetach() {
        int i;
        Object obj;
        final androidx.compose.material.ripple.RippleContainer rippleContainer = this.rippleContainer;
        if (rippleContainer != null) {
            i = 0;
            rippleContainer.disposeRippleIfNeeded((RippleHostKey)this);
        }
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void onResetRippleHostView() {
        setRippleHostView(0);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void removeRipple(PressInteraction.Press interaction) {
        final androidx.compose.material.ripple.RippleHostView rippleHostView = this.rippleHostView;
        if (rippleHostView != null) {
            rippleHostView.removeRipple();
        }
    }
}
