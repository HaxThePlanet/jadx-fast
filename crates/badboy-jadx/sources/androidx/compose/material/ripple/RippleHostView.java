package androidx.compose.material.ripple;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.foundation.interaction.PressInteraction.Press;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0012\u0008\u0000\u0018\u0000 42\u00020\u0001:\u00014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JN\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0006\u0010 \u001a\u00020\rJ\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0016J0\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018H\u0014J\u0018\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0018H\u0014J\u0008\u0010-\u001a\u00020\rH\u0016J\u0006\u0010.\u001a\u00020\rJ(\u0010/\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\u00080\u00101J\u0010\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\u0006H\u0002R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00065", d2 = {"Landroidx/compose/material/ripple/RippleHostView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bounded", "", "Ljava/lang/Boolean;", "lastRippleStateChangeTimeMillis", "", "Ljava/lang/Long;", "onInvalidateRipple", "Lkotlin/Function0;", "", "resetRippleRunnable", "Ljava/lang/Runnable;", "ripple", "Landroidx/compose/material/ripple/UnprojectedRipple;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "Landroidx/compose/ui/geometry/Size;", "radius", "", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "addRipple-KOepWvA", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;ZJIJFLkotlin/jvm/functions/Function0;)V", "createRipple", "disposeRipple", "invalidateDrawable", "who", "Landroid/graphics/drawable/Drawable;", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshDrawableState", "removeRipple", "setRippleProperties", "setRippleProperties-07v42R4", "(JJF)V", "setRippleState", "pressed", "Companion", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RippleHostView extends View {

    public static final int $stable = 0;
    public static final androidx.compose.material.ripple.RippleHostView.Companion Companion = null;
    private static final long MinimumRippleStateChangeTime = 5L;
    private static final int[] PressedState = null;
    private static final long ResetRippleDelayDuration = 50L;
    private static final int[] RestingState;
    private Boolean bounded;
    private Long lastRippleStateChangeTimeMillis;
    private Function0<Unit> onInvalidateRipple;
    private Runnable resetRippleRunnable;
    private androidx.compose.material.ripple.UnprojectedRipple ripple;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Landroidx/compose/material/ripple/RippleHostView$Companion;", "", "()V", "MinimumRippleStateChangeTime", "", "PressedState", "", "ResetRippleDelayDuration", "RestingState", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    public static void $r8$lambda$kwnYusj11673lL3l--Z3fgj8B_w(androidx.compose.material.ripple.RippleHostView rippleHostView) {
        RippleHostView.setRippleState$lambda$2(rippleHostView);
    }

    static {
        RippleHostView.Companion companion = new RippleHostView.Companion(0);
        RippleHostView.Companion = companion;
        RippleHostView.$stable = 8;
        RippleHostView.PressedState = /* result */;
        RippleHostView.RestingState = new int[0];
    }

    public RippleHostView(Context context) {
        super(context);
    }

    private final void createRipple(boolean bounded) {
        UnprojectedRipple unprojectedRipple = new UnprojectedRipple(bounded);
        final int i = 0;
        setBackground((Drawable)unprojectedRipple);
        this.ripple = unprojectedRipple;
    }

    private final void setRippleState(boolean pressed) {
        long longValue;
        int i;
        Runnable resetRippleRunnable;
        int cmp;
        int ripple;
        final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable resetRippleRunnable2 = this.resetRippleRunnable;
        if (resetRippleRunnable2 != null) {
            i = 0;
            removeCallbacks(resetRippleRunnable2);
            resetRippleRunnable2.run();
        }
        Long lastRippleStateChangeTimeMillis = this.lastRippleStateChangeTimeMillis;
        if (lastRippleStateChangeTimeMillis != null) {
            longValue = lastRippleStateChangeTimeMillis.longValue();
        } else {
            longValue = 0;
        }
        if (!pressed && Long.compare(i2, i3) < 0) {
            if (Long.compare(i2, i3) < 0) {
                RippleHostView$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new RippleHostView$$ExternalSyntheticLambda0(this);
                this.resetRippleRunnable = externalSyntheticLambda0;
                postDelayed(this.resetRippleRunnable, 50);
            } else {
                resetRippleRunnable = pressed ? RippleHostView.PressedState : RippleHostView.RestingState;
                ripple = this.ripple;
                if (ripple == null) {
                } else {
                    ripple.setState(resetRippleRunnable);
                }
            }
        } else {
        }
        this.lastRippleStateChangeTimeMillis = Long.valueOf(currentAnimationTimeMillis);
    }

    private static final void setRippleState$lambda$2(androidx.compose.material.ripple.RippleHostView this$0) {
        int[] restingState;
        androidx.compose.material.ripple.UnprojectedRipple ripple = this$0.ripple;
        if (ripple == null) {
        } else {
            ripple.setState(RippleHostView.RestingState);
        }
        this$0.resetRippleRunnable = 0;
    }

    public final void addRipple-KOepWvA(PressInteraction.Press interaction, boolean bounded, long size, int radius, long color, float alpha, Function0<Unit> onInvalidateRipple) {
        boolean valueOf;
        Boolean bounded2;
        float x-impl;
        float y-impl;
        if (this.ripple != null) {
            if (!Intrinsics.areEqual(Boolean.valueOf(bounded), this.bounded)) {
                createRipple(bounded);
                this.bounded = Boolean.valueOf(bounded);
            }
        } else {
        }
        androidx.compose.material.ripple.UnprojectedRipple ripple = this.ripple;
        Intrinsics.checkNotNull(ripple);
        this.onInvalidateRipple = obj17;
        ripple.trySetRadius(color);
        final float f = alpha;
        this.setRippleProperties-07v42R4(size, obj4, f);
        if (bounded) {
            ripple.setHotspot(Offset.getX-impl(interaction.getPressPosition-F1C5BW0()), Offset.getY-impl(interaction.getPressPosition-F1C5BW0()));
        } else {
            ripple.setHotspot((float)centerX, (float)centerY);
        }
        setRippleState(true);
    }

    @Override // android.view.View
    public final void disposeRipple() {
        Object resetRippleRunnable;
        int[] restingState;
        this.onInvalidateRipple = 0;
        if (this.resetRippleRunnable != null) {
            removeCallbacks(this.resetRippleRunnable);
            resetRippleRunnable = this.resetRippleRunnable;
            Intrinsics.checkNotNull(resetRippleRunnable);
            resetRippleRunnable.run();
        } else {
            resetRippleRunnable = this.ripple;
            if (resetRippleRunnable == null) {
            } else {
                resetRippleRunnable.setState(RippleHostView.RestingState);
            }
        }
        androidx.compose.material.ripple.UnprojectedRipple ripple = this.ripple;
        if (ripple == null) {
        }
        int i2 = 0;
        ripple.setVisible(i2, i2);
        unscheduleDrawable((Drawable)ripple);
    }

    @Override // android.view.View
    public void invalidateDrawable(Drawable who) {
        final Function0 onInvalidateRipple = this.onInvalidateRipple;
        if (onInvalidateRipple != null) {
            onInvalidateRipple.invoke();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int i = 0;
        setMeasuredDimension(i, i);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
    }

    @Override // android.view.View
    public final void removeRipple() {
        setRippleState(false);
    }

    @Override // android.view.View
    public final void setRippleProperties-07v42R4(long size, long color, float alpha) {
        final androidx.compose.material.ripple.UnprojectedRipple ripple = this.ripple;
        if (ripple == null) {
        }
        ripple.setColor-DxMtmZc(alpha, obj9);
        final int i = 0;
        Rect rect = new Rect(i, i, MathKt.roundToInt(Size.getWidth-impl(size)), MathKt.roundToInt(Size.getHeight-impl(size)));
        setLeft(rect.left);
        setTop(rect.top);
        setRight(rect.right);
        setBottom(rect.bottom);
        ripple.setBounds(rect);
    }
}
