package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ClipOp.Companion;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000e\u0010 \u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010!J\u000e\u0010#\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010!J\u0006\u0010$\u001a\u00020\u0018J\u001c\u0010%\u001a\u00020\u0018*\u00020&2\u0006\u0010'\u001a\u00020(ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001c\u0010\u0015\u001a\u0004\u0008\u001a\u0010\u0011\"\u0004\u0008\u001b\u0010\u0013R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006+", d2 = {"Landroidx/compose/material/ripple/RippleAnimation;", "", "origin", "Landroidx/compose/ui/geometry/Offset;", "radius", "", "bounded", "", "(Landroidx/compose/ui/geometry/Offset;FZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "animatedCenterPercent", "animatedRadiusPercent", "<set-?>", "finishRequested", "getFinishRequested", "()Z", "setFinishRequested", "(Z)V", "finishRequested$delegate", "Landroidx/compose/runtime/MutableState;", "finishSignalDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "finishedFadingIn", "getFinishedFadingIn", "setFinishedFadingIn", "finishedFadingIn$delegate", "startRadius", "Ljava/lang/Float;", "targetCenter", "animate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fadeIn", "fadeOut", "finish", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "draw-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RippleAnimation {

    public static final int $stable = 8;
    private final Animatable<Float, AnimationVector1D> animatedAlpha;
    private final Animatable<Float, AnimationVector1D> animatedCenterPercent;
    private final Animatable<Float, AnimationVector1D> animatedRadiusPercent;
    private final boolean bounded;
    private final MutableState finishRequested$delegate;
    private final CompletableDeferred<Unit> finishSignalDeferred;
    private final MutableState finishedFadingIn$delegate;
    private Offset origin;
    private final float radius;
    private Float startRadius;
    private Offset targetCenter;
    static {
        final int i = 8;
    }

    private RippleAnimation(Offset origin, float radius, boolean bounded) {
        super();
        this.origin = origin;
        this.radius = radius;
        this.bounded = bounded;
        int i = 0;
        final int i3 = 2;
        final int i4 = 0;
        this.animatedAlpha = AnimatableKt.Animatable$default(i, i, i3, i4);
        this.animatedRadiusPercent = AnimatableKt.Animatable$default(i, i, i3, i4);
        this.animatedCenterPercent = AnimatableKt.Animatable$default(i, i, i3, i4);
        this.finishSignalDeferred = CompletableDeferredKt.CompletableDeferred(i4);
        Boolean valueOf = false;
        this.finishedFadingIn$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i4, i3, i4);
        this.finishRequested$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i4, i3, i4);
    }

    public RippleAnimation(Offset offset, float f2, boolean z3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(offset, f2, z3);
    }

    public static final Object access$fadeIn(androidx.compose.material.ripple.RippleAnimation $this, Continuation $completion) {
        return $this.fadeIn($completion);
    }

    public static final Object access$fadeOut(androidx.compose.material.ripple.RippleAnimation $this, Continuation $completion) {
        return $this.fadeOut($completion);
    }

    public static final Animatable access$getAnimatedAlpha$p(androidx.compose.material.ripple.RippleAnimation $this) {
        return $this.animatedAlpha;
    }

    public static final Animatable access$getAnimatedCenterPercent$p(androidx.compose.material.ripple.RippleAnimation $this) {
        return $this.animatedCenterPercent;
    }

    public static final Animatable access$getAnimatedRadiusPercent$p(androidx.compose.material.ripple.RippleAnimation $this) {
        return $this.animatedRadiusPercent;
    }

    private final Object fadeIn(Continuation<? super Unit> $completion) {
        RippleAnimation.fadeIn.2 anon = new RippleAnimation.fadeIn.2(this, 0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    private final Object fadeOut(Continuation<? super Unit> $completion) {
        RippleAnimation.fadeOut.2 anon = new RippleAnimation.fadeOut.2(this, 0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    private final boolean getFinishRequested() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.finishRequested$delegate.getValue().booleanValue();
    }

    private final boolean getFinishedFadingIn() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.finishedFadingIn$delegate.getValue().booleanValue();
    }

    private final void setFinishRequested(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.finishRequested$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setFinishedFadingIn(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.finishedFadingIn$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final Object animate(Continuation<? super Unit> continuation) {
        boolean anon;
        int i;
        int i2;
        Object _this2;
        int _this;
        int await;
        Object fadeIn;
        Object obj6;
        anon = continuation;
        i2 = Integer.MIN_VALUE;
        if (continuation instanceof RippleAnimation.animate.1 && label &= i2 != 0) {
            anon = continuation;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj6 -= i2;
            } else {
                anon = new RippleAnimation.animate.1(this, continuation);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        await = 1;
        switch (_this) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                _this2 = this;
                anon.L$0 = _this2;
                anon.label = await;
                return cOROUTINE_SUSPENDED;
            case 1:
                _this2 = anon.L$0;
                ResultKt.throwOnFailure(obj6);
                break;
            case 2:
                _this2 = anon.L$0;
                ResultKt.throwOnFailure(obj6);
                anon.L$0 = 0;
                anon.label = 3;
                return cOROUTINE_SUSPENDED;
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure(obj6);
                return Unit.INSTANCE;
            default:
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
        }
        _this2.setFinishedFadingIn(await);
        anon.L$0 = _this2;
        anon.label = 2;
        if (_this2.finishSignalDeferred.await(anon) == cOROUTINE_SUSPENDED) {
            return cOROUTINE_SUSPENDED;
        }
    }

    public final void draw-4WTKRHQ(DrawScope $this$draw_u2d4WTKRHQ, long color) {
        long size-NH-jbRc;
        Float startRadius;
        Offset box-impl;
        Offset targetCenter;
        int floatValue;
        boolean finishedFadingIn;
        long l;
        boolean bounded;
        int i8;
        int lerp;
        float y-impl;
        Canvas canvas;
        int $this$withTransform_u24lambda_u246$iv$iv3;
        DrawContext context2;
        int $this$withTransform_u24lambda_u246$iv$iv2;
        int $this$withTransform_u24lambda_u246$iv$iv;
        int i7;
        int i4;
        int i;
        int i3;
        int alpha;
        int $i$a$WithTransformDrawScopeKt$clipRect$1$iv;
        int i6;
        float f;
        float f2;
        int i2;
        int i5;
        DrawContext context3;
        DrawContext context;
        size-NH-jbRc = this;
        if (size-NH-jbRc.startRadius == null) {
            size-NH-jbRc.startRadius = Float.valueOf(RippleAnimationKt.getRippleStartRadius-uvyYCjk($this$draw_u2d4WTKRHQ.getSize-NH-jbRc()));
        }
        if (size-NH-jbRc.origin == null) {
            size-NH-jbRc.origin = Offset.box-impl($this$draw_u2d4WTKRHQ.getCenter-F1C5BW0());
        }
        if (size-NH-jbRc.targetCenter == null) {
            l = 1073741824;
            size-NH-jbRc.targetCenter = Offset.box-impl(OffsetKt.Offset(width-impl /= l, height-impl /= l));
        }
        if (size-NH-jbRc.getFinishRequested() && !size-NH-jbRc.getFinishedFadingIn()) {
            if (!size-NH-jbRc.getFinishedFadingIn()) {
                floatValue = 1065353216;
            } else {
                floatValue = (Number)size-NH-jbRc.animatedAlpha.getValue().floatValue();
            }
        } else {
        }
        Float startRadius2 = size-NH-jbRc.startRadius;
        Intrinsics.checkNotNull(startRadius2);
        float radius = size-NH-jbRc.radius;
        float floatValue3 = (Number)size-NH-jbRc.animatedRadiusPercent.getValue().floatValue();
        final float lerp3 = MathHelpersKt.lerp(startRadius2.floatValue(), radius, floatValue3);
        Offset origin = size-NH-jbRc.origin;
        Intrinsics.checkNotNull(origin);
        Offset targetCenter2 = size-NH-jbRc.targetCenter;
        Intrinsics.checkNotNull(targetCenter2);
        float floatValue4 = (Number)size-NH-jbRc.animatedCenterPercent.getValue().floatValue();
        Offset origin2 = size-NH-jbRc.origin;
        Intrinsics.checkNotNull(origin2);
        Offset targetCenter3 = size-NH-jbRc.targetCenter;
        Intrinsics.checkNotNull(targetCenter3);
        y-impl = Offset.getY-impl(targetCenter3.unbox-impl());
        final long l3 = OffsetKt.Offset(MathHelpersKt.lerp(Offset.getX-impl(origin.unbox-impl()), Offset.getX-impl(targetCenter2.unbox-impl()), floatValue4), MathHelpersKt.lerp(Offset.getY-impl(origin2.unbox-impl()), y-impl, (Number)size-NH-jbRc.animatedCenterPercent.getValue().floatValue()));
        final long copy-wmQWz5c$default = Color.copy-wmQWz5c$default(color, obj12, alpha-impl * floatValue, 0, 0, 0, 14);
        if (size-NH-jbRc.bounded) {
            bounded = $this$draw_u2d4WTKRHQ;
            int i10 = 0;
            int i12 = 0;
            float width-impl2 = Size.getWidth-impl(bounded.getSize-NH-jbRc());
            float height-impl2 = Size.getHeight-impl(bounded.getSize-NH-jbRc());
            int intersect-rtfAjoo = ClipOp.Companion.getIntersect-rtfAjoo();
            lerp = 0;
            y-impl = bounded;
            i = 0;
            DrawContext drawContext = y-impl.getDrawContext();
            i3 = 0;
            alpha = floatValue;
            drawContext.getCanvas().save();
            int i16 = 0;
            drawContext.getTransform().clipRect-N_I0leg(i10, i12, width-impl2, height-impl2, intersect-rtfAjoo);
            $i$a$WithTransformDrawScopeKt$clipRect$1$iv = i10;
            i6 = i12;
            f = width-impl2;
            f2 = height-impl2;
            i2 = intersect-rtfAjoo;
            i5 = 0;
            context = context3;
            DrawScope.drawCircle-VaOC9Bg$default(y-impl, copy-wmQWz5c$default, obj7, lerp3, l3, obj10, 0, 0, 0, 0);
            context.getCanvas().restore();
            context.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
        } else {
            alpha = floatValue;
            DrawScope.drawCircle-VaOC9Bg$default($this$draw_u2d4WTKRHQ, copy-wmQWz5c$default, obj7, lerp3, l3, obj10, 0, 0, 0, 0);
        }
    }

    public final void finish() {
        setFinishRequested(true);
        this.finishSignalDeferred.complete(Unit.INSTANCE);
    }
}
