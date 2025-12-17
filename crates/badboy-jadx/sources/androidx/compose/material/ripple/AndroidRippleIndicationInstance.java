package androidx.compose.material.ripple;

import android.view.ViewGroup;
import androidx.compose.foundation.interaction.PressInteraction.Press;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Deprecated(message = "Replaced by the new RippleNode implementation")
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\u0008\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t\u0012\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\t\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0018\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u0008\u0010/\u001a\u00020\u001aH\u0002J\u0008\u00100\u001a\u00020\u001dH\u0002J\u0008\u00101\u001a\u00020\u001aH\u0016J\u0008\u00102\u001a\u00020\u001aH\u0016J\u0008\u00103\u001a\u00020\u001aH\u0016J\u0008\u00104\u001a\u00020\u001aH\u0016J\u0010\u00105\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0016J\u000c\u00106\u001a\u00020\u001a*\u000207H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u001e8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008$\u0010\u0017\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\u00020(X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00068", d2 = {"Landroidx/compose/material/ripple/AndroidRippleIndicationInstance;", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/runtime/RememberObserver;", "Landroidx/compose/material/ripple/RippleHostKey;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "view", "Landroid/view/ViewGroup;", "(ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroid/view/ViewGroup;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "invalidateTick", "getInvalidateTick", "()Z", "setInvalidateTick", "(Z)V", "invalidateTick$delegate", "Landroidx/compose/runtime/MutableState;", "onInvalidateRipple", "Lkotlin/Function0;", "", "F", "rippleContainer", "Landroidx/compose/material/ripple/RippleContainer;", "Landroidx/compose/material/ripple/RippleHostView;", "rippleHostView", "getRippleHostView", "()Landroidx/compose/material/ripple/RippleHostView;", "setRippleHostView", "(Landroidx/compose/material/ripple/RippleHostView;)V", "rippleHostView$delegate", "rippleRadius", "", "rippleSize", "Landroidx/compose/ui/geometry/Size;", "J", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispose", "getOrCreateRippleContainer", "onAbandoned", "onForgotten", "onRemembered", "onResetRippleHostView", "removeRipple", "drawIndication", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidRippleIndicationInstance extends androidx.compose.material.ripple.RippleIndicationInstance implements RememberObserver, androidx.compose.material.ripple.RippleHostKey {

    public static final int $stable = 8;
    private final boolean bounded;
    private final State<Color> color;
    private final MutableState invalidateTick$delegate;
    private final Function0<Unit> onInvalidateRipple;
    private final float radius;
    private final State<androidx.compose.material.ripple.RippleAlpha> rippleAlpha;
    private androidx.compose.material.ripple.RippleContainer rippleContainer;
    private final MutableState rippleHostView$delegate;
    private int rippleRadius;
    private long rippleSize;
    private final ViewGroup view;
    static {
        final int i = 8;
    }

    private AndroidRippleIndicationInstance(boolean bounded, float radius, State<Color> color, State<androidx.compose.material.ripple.RippleAlpha> rippleAlpha, ViewGroup view) {
        super(bounded, rippleAlpha);
        this.bounded = bounded;
        this.radius = radius;
        this.color = color;
        this.rippleAlpha = rippleAlpha;
        this.view = view;
        int i = 0;
        final int i3 = 2;
        this.rippleHostView$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i3, i);
        this.invalidateTick$delegate = SnapshotStateKt.mutableStateOf$default(true, i, i3, i);
        this.rippleSize = Size.Companion.getZero-NH-jbRc();
        this.rippleRadius = -1;
        AndroidRippleIndicationInstance.onInvalidateRipple.1 anon = new AndroidRippleIndicationInstance.onInvalidateRipple.1(this);
        this.onInvalidateRipple = (Function0)anon;
    }

    public AndroidRippleIndicationInstance(boolean z, float f2, State state3, State state4, ViewGroup viewGroup5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(z, f2, state3, state4, viewGroup5);
    }

    public static final boolean access$getInvalidateTick(androidx.compose.material.ripple.AndroidRippleIndicationInstance $this) {
        return $this.getInvalidateTick();
    }

    public static final void access$setInvalidateTick(androidx.compose.material.ripple.AndroidRippleIndicationInstance $this, boolean <set-?>) {
        $this.setInvalidateTick(<set-?>);
    }

    private final void dispose() {
        int i;
        Object obj;
        final androidx.compose.material.ripple.RippleContainer rippleContainer = this.rippleContainer;
        if (rippleContainer != null) {
            i = 0;
            rippleContainer.disposeRippleIfNeeded((RippleHostKey)this);
        }
    }

    private final boolean getInvalidateTick() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.invalidateTick$delegate.getValue().booleanValue();
    }

    private final androidx.compose.material.ripple.RippleContainer getOrCreateRippleContainer() {
        if (this.rippleContainer != null) {
            androidx.compose.material.ripple.RippleContainer rippleContainer2 = this.rippleContainer;
            Intrinsics.checkNotNull(rippleContainer2);
            return rippleContainer2;
        }
        this.rippleContainer = Ripple_androidKt.access$createAndAttachRippleContainerIfNeeded(this.view);
        androidx.compose.material.ripple.RippleContainer rippleContainer4 = this.rippleContainer;
        Intrinsics.checkNotNull(rippleContainer4);
        return rippleContainer4;
    }

    private final androidx.compose.material.ripple.RippleHostView getRippleHostView() {
        final int i = 0;
        final int i2 = 0;
        return (RippleHostView)(State)this.rippleHostView$delegate.getValue();
    }

    private final void setInvalidateTick(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.invalidateTick$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setRippleHostView(androidx.compose.material.ripple.RippleHostView <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.rippleHostView$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void addRipple(PressInteraction.Press interaction, CoroutineScope scope) {
        final int i = 0;
        androidx.compose.material.ripple.RippleHostView rippleHostView = getOrCreateRippleContainer().getRippleHostView((RippleHostKey)this);
        final int i2 = 0;
        rippleHostView.addRipple-KOepWvA(interaction, this.bounded, this.rippleSize, obj7, this.rippleRadius, (Color)this.color.getValue().unbox-impl(), obj10);
        setRippleHostView(rippleHostView);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void drawIndication(ContentDrawScope $this$drawIndication) {
        int roundToInt;
        boolean bounded;
        long nativeCanvas;
        int i;
        this.rippleSize = $this$drawIndication.getSize-NH-jbRc();
        bounded = 0;
        if (Float.isNaN(this.radius)) {
            roundToInt = MathKt.roundToInt(RippleAnimationKt.getRippleEndRadius-cSwnlzA((Density)$this$drawIndication, this.bounded, $this$drawIndication.getSize-NH-jbRc()));
        } else {
            roundToInt = $this$drawIndication.roundToPx-0680j_4(this.radius);
        }
        this.rippleRadius = roundToInt;
        final long unbox-impl = (Color)this.color.getValue().unbox-impl();
        $this$drawIndication.drawContent();
        drawStateLayer-H2RKhps((DrawScope)$this$drawIndication, this.radius, unbox-impl);
        final int i2 = 0;
        final int i3 = 0;
        getInvalidateTick();
        androidx.compose.material.ripple.RippleHostView rippleHostView = getRippleHostView();
        if (rippleHostView != null) {
            i = 0;
            rippleHostView.setRippleProperties-07v42R4($this$drawIndication.getSize-NH-jbRc(), obj3, unbox-impl);
            rippleHostView.draw(AndroidCanvas_androidKt.getNativeCanvas((DrawScope)$this$drawIndication.getDrawContext().getCanvas()));
        }
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void onAbandoned() {
        dispose();
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void onForgotten() {
        dispose();
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void onRemembered() {
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void onResetRippleHostView() {
        setRippleHostView(0);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void removeRipple(PressInteraction.Press interaction) {
        final androidx.compose.material.ripple.RippleHostView rippleHostView = getRippleHostView();
        if (rippleHostView != null) {
            rippleHostView.removeRipple();
        }
    }
}
