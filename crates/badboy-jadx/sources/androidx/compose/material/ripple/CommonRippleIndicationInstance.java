package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction.Press;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Deprecated(message = "Replaced by the new RippleNode implementation")
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008\u0012\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008¢\u0006\u0002\u0010\u000cJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u0010\u0019\u001a\u00020\u0015H\u0016J\u0008\u0010\u001a\u001a\u00020\u0015H\u0016J\u0008\u0010\u001b\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u000c\u0010\u001d\u001a\u00020\u0015*\u00020\u001eH\u0016J\u001e\u0010\u001f\u001a\u00020\u0015*\u00020 2\u0006\u0010\u0007\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u0006X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006#", d2 = {"Landroidx/compose/material/ripple/CommonRippleIndicationInstance;", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/runtime/RememberObserver;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "ripples", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/material/ripple/RippleAnimation;", "targetRadius", "", "addRipple", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onAbandoned", "onForgotten", "onRemembered", "removeRipple", "drawIndication", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawRipples-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CommonRippleIndicationInstance extends androidx.compose.material.ripple.RippleIndicationInstance implements RememberObserver {

    private final boolean bounded;
    private final State<Color> color;
    private final float radius;
    private final State<androidx.compose.material.ripple.RippleAlpha> rippleAlpha;
    private final SnapshotStateMap<PressInteraction.Press, androidx.compose.material.ripple.RippleAnimation> ripples;
    private float targetRadius;
    private CommonRippleIndicationInstance(boolean bounded, float radius, State<Color> color, State<androidx.compose.material.ripple.RippleAlpha> rippleAlpha) {
        super(bounded, rippleAlpha);
        this.bounded = bounded;
        this.radius = radius;
        this.color = color;
        this.rippleAlpha = rippleAlpha;
        this.ripples = SnapshotStateKt.mutableStateMapOf();
        this.targetRadius = 2143289344;
    }

    public CommonRippleIndicationInstance(boolean z, float f2, State state3, State state4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(z, f2, state3, state4);
    }

    public static final SnapshotStateMap access$getRipples$p(androidx.compose.material.ripple.CommonRippleIndicationInstance $this) {
        return $this.ripples;
    }

    private final void drawRipples-4WTKRHQ(DrawScope $this$drawRipples_u2d4WTKRHQ, long color) {
        Object next;
        int i;
        Object value;
        Object obj;
        int i3;
        DrawScope drawScope;
        int i5;
        Object obj3;
        float pressedAlpha;
        long copy-wmQWz5c$default;
        int i4;
        int i2;
        int i7;
        int i6;
        final Object obj2 = this;
        final int i8 = 0;
        Iterator iterator = (Map)obj2.ripples.entrySet().iterator();
        while (iterator.hasNext()) {
            i = 0;
            i3 = 0;
            pressedAlpha = (RippleAlpha)obj2.rippleAlpha.getValue().getPressedAlpha();
            if (Float.compare(pressedAlpha, i9) == 0) {
            } else {
            }
            i5 = 0;
            if (i5 == 0) {
            } else {
            }
            drawScope = $this$drawRipples_u2d4WTKRHQ;
            i4 = 0;
            (RippleAnimation)(Map.Entry)iterator.next().getValue().draw-4WTKRHQ($this$drawRipples_u2d4WTKRHQ, Color.copy-wmQWz5c$default(color, obj11, pressedAlpha, 0, i4, 0, 14));
            i5 = 1;
        }
        DrawScope drawScope2 = $this$drawRipples_u2d4WTKRHQ;
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void addRipple(PressInteraction.Press interaction, CoroutineScope scope) {
        int box-impl;
        Iterator iterator;
        Object next;
        int i;
        Object value;
        int i2 = 0;
        iterator = (Map)this.ripples.entrySet().iterator();
        boolean next2 = iterator.hasNext();
        for (Map.Entry next : iterator) {
            i = 0;
            (RippleAnimation)next.getValue().finish();
            next2 = iterator.hasNext();
        }
        int i3 = 0;
        if (this.bounded) {
            box-impl = Offset.box-impl(interaction.getPressPosition-F1C5BW0());
        } else {
            box-impl = i3;
        }
        RippleAnimation rippleAnimation = new RippleAnimation(box-impl, this.targetRadius, this.bounded, i3);
        (Map)this.ripples.put(interaction, rippleAnimation);
        CommonRippleIndicationInstance.addRipple.2 anon = new CommonRippleIndicationInstance.addRipple.2(rippleAnimation, this, interaction, i3);
        BuildersKt.launch$default(scope, 0, 0, (Function2)anon, 3, 0);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void drawIndication(ContentDrawScope $this$drawIndication) {
        float rippleEndRadius-cSwnlzA;
        boolean bounded;
        long size-NH-jbRc;
        bounded = 0;
        if (Float.isNaN(this.radius)) {
            rippleEndRadius-cSwnlzA = RippleAnimationKt.getRippleEndRadius-cSwnlzA((Density)$this$drawIndication, this.bounded, $this$drawIndication.getSize-NH-jbRc());
        } else {
            rippleEndRadius-cSwnlzA = $this$drawIndication.toPx-0680j_4(this.radius);
        }
        this.targetRadius = rippleEndRadius-cSwnlzA;
        long unbox-impl = (Color)this.color.getValue().unbox-impl();
        $this$drawIndication.drawContent();
        drawStateLayer-H2RKhps((DrawScope)$this$drawIndication, this.radius, unbox-impl);
        drawRipples-4WTKRHQ((DrawScope)$this$drawIndication, unbox-impl);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void onAbandoned() {
        this.ripples.clear();
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void onForgotten() {
        this.ripples.clear();
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void onRemembered() {
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void removeRipple(PressInteraction.Press interaction) {
        Object obj = this.ripples.get(interaction);
        if ((RippleAnimation)obj != null) {
            (RippleAnimation)obj.finish();
        }
    }
}
