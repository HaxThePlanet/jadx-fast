package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\u0008\u0010\u0012\u001a\u00020\u0011H\u0016J\u0008\u0010\u0013\u001a\u00020\u0011H\u0016J\u0008\u0010\u0014\u001a\u00020\u0011H\u0002J\u0008\u0010\u0015\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\u00020\tX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/material/DelegatingThemeAwareRippleNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "rippleNode", "Landroidx/compose/ui/node/DelegatableNode;", "attachNewRipple", "", "onAttach", "onObservedReadsChanged", "removeRipple", "updateConfiguration", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DelegatingThemeAwareRippleNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, ObserverModifierNode {

    private final boolean bounded;
    private final ColorProducer color;
    private final InteractionSource interactionSource;
    private final float radius;
    private DelegatableNode rippleNode;
    private DelegatingThemeAwareRippleNode(InteractionSource interactionSource, boolean bounded, float radius, ColorProducer color) {
        super();
        this.interactionSource = interactionSource;
        this.bounded = bounded;
        this.radius = radius;
        this.color = color;
    }

    public DelegatingThemeAwareRippleNode(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(interactionSource, z2, f3, colorProducer4);
    }

    public static final void access$attachNewRipple(androidx.compose.material.DelegatingThemeAwareRippleNode $this) {
        $this.attachNewRipple();
    }

    public static final ColorProducer access$getColor$p(androidx.compose.material.DelegatingThemeAwareRippleNode $this) {
        return $this.color;
    }

    public static final DelegatableNode access$getRippleNode$p(androidx.compose.material.DelegatingThemeAwareRippleNode $this) {
        return $this.rippleNode;
    }

    public static final void access$removeRipple(androidx.compose.material.DelegatingThemeAwareRippleNode $this) {
        $this.removeRipple();
    }

    private final void attachNewRipple() {
        DelegatingThemeAwareRippleNode.attachNewRipple.calculateColor.1 anon = new DelegatingThemeAwareRippleNode.attachNewRipple.calculateColor.1(this);
        DelegatingThemeAwareRippleNode.attachNewRipple.calculateRippleAlpha.1 anon2 = new DelegatingThemeAwareRippleNode.attachNewRipple.calculateRippleAlpha.1(this);
        this.rippleNode = delegate(RippleKt.createRippleModifierNode-TDGSqEk(this.interactionSource, this.bounded, this.radius, (ColorProducer)anon, (Function0)anon2));
    }

    private final void removeRipple() {
        int i;
        final DelegatableNode rippleNode = this.rippleNode;
        if (rippleNode != null) {
            i = 0;
            undelegate(rippleNode);
        }
    }

    private final void updateConfiguration() {
        DelegatingThemeAwareRippleNode.updateConfiguration.1 anon = new DelegatingThemeAwareRippleNode.updateConfiguration.1(this);
        ObserverModifierNodeKt.observeReads((Modifier.Node)this, (Function0)anon);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onAttach() {
        updateConfiguration();
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onObservedReadsChanged() {
        updateConfiguration();
    }
}
