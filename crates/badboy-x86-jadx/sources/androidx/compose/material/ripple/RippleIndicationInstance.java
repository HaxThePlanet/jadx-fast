package androidx.compose.material.ripple;

import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction.Press;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Deprecated(message = "Replaced by the new RippleNode implementation")
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008!\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH&J\u001d\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\u0008\u0013J$\u0010\u0014\u001a\u00020\u000b*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001c", d2 = {"Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/foundation/IndicationInstance;", "bounded", "", "rippleAlpha", "Landroidx/compose/runtime/State;", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZLandroidx/compose/runtime/State;)V", "stateLayer", "Landroidx/compose/material/ripple/StateLayer;", "addRipple", "", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "removeRipple", "updateStateLayer", "Landroidx/compose/foundation/interaction/Interaction;", "updateStateLayer$material_ripple_release", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-H2RKhps", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class RippleIndicationInstance implements IndicationInstance {

    public static final int $stable = 8;
    private final boolean bounded;
    private final androidx.compose.material.ripple.StateLayer stateLayer;
    static {
        final int i = 8;
    }

    public RippleIndicationInstance(boolean bounded, State<androidx.compose.material.ripple.RippleAlpha> rippleAlpha) {
        super();
        this.bounded = bounded;
        RippleIndicationInstance.stateLayer.1 anon = new RippleIndicationInstance.stateLayer.1(rippleAlpha);
        StateLayer stateLayer = new StateLayer(this.bounded, (Function0)anon);
        this.stateLayer = stateLayer;
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public abstract void addRipple(PressInteraction.Press pressInteraction$Press, CoroutineScope coroutineScope2);

    @Override // androidx.compose.foundation.IndicationInstance
    public final void drawStateLayer-H2RKhps(DrawScope $this$drawStateLayer_u2dH2RKhps, float radius, long color) {
        float rippleEndRadius-cSwnlzA;
        boolean bounded;
        long size-NH-jbRc;
        final int i = 0;
        bounded = 0;
        if (Float.isNaN(radius)) {
            rippleEndRadius-cSwnlzA = RippleAnimationKt.getRippleEndRadius-cSwnlzA((Density)$this$drawStateLayer_u2dH2RKhps, this.bounded, $this$drawStateLayer_u2dH2RKhps.getSize-NH-jbRc());
        } else {
            rippleEndRadius-cSwnlzA = $this$drawStateLayer_u2dH2RKhps.toPx-0680j_4(radius);
        }
        this.stateLayer.drawStateLayer-mxwnekA($this$drawStateLayer_u2dH2RKhps, rippleEndRadius-cSwnlzA, color);
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public abstract void removeRipple(PressInteraction.Press pressInteraction$Press);

    @Override // androidx.compose.foundation.IndicationInstance
    public final void updateStateLayer$material_ripple_release(Interaction interaction, CoroutineScope scope) {
        this.stateLayer.handleInteraction$material_ripple_release(interaction, scope);
    }
}
