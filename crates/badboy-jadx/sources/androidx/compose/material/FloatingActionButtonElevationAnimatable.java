package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u0012J\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014J\u000e\u0010\u0015\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0016J3\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u0003*\u0004\u0018\u00010\rH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001d", d2 = {"Landroidx/compose/material/FloatingActionButtonElevationAnimatable;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "F", "lastTargetInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "targetInteraction", "animateElevation", "", "to", "(Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "snapElevation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateElevation", "updateElevation-lDy3nrA", "(FFFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateTarget", "calculateTarget-u2uoSUM", "(Landroidx/compose/foundation/interaction/Interaction;)F", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FloatingActionButtonElevationAnimatable {

    private final Animatable<Dp, AnimationVector1D> animatable;
    private float defaultElevation;
    private float focusedElevation;
    private float hoveredElevation;
    private Interaction lastTargetInteraction;
    private float pressedElevation;
    private Interaction targetInteraction;
    private FloatingActionButtonElevationAnimatable(float defaultElevation, float pressedElevation, float hoveredElevation, float focusedElevation) {
        super();
        this.defaultElevation = defaultElevation;
        this.pressedElevation = pressedElevation;
        this.hoveredElevation = hoveredElevation;
        this.focusedElevation = focusedElevation;
        Animatable animatable = new Animatable(Dp.box-impl(this.defaultElevation), VectorConvertersKt.getVectorConverter(Dp.Companion), 0, 0, 12, 0);
        this.animatable = animatable;
    }

    public FloatingActionButtonElevationAnimatable(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(f, f2, f3, f4);
    }

    public static final Object access$snapElevation(androidx.compose.material.FloatingActionButtonElevationAnimatable $this, Continuation $completion) {
        return $this.snapElevation($completion);
    }

    private final float calculateTarget-u2uoSUM(Interaction $this$calculateTarget_u2du2uoSUM) {
        float hoveredElevation;
        hoveredElevation = $this$calculateTarget_u2du2uoSUM instanceof PressInteraction.Press ? this.pressedElevation : z2 ? this.hoveredElevation : z3 ? this.focusedElevation : this.defaultElevation;
        return hoveredElevation;
    }

    private final Object snapElevation(Continuation<? super Unit> continuation) {
        boolean anon;
        Throwable th;
        Object cOROUTINE_SUSPENDED;
        Throwable _this;
        int _this2;
        float targetInteraction;
        Object snapTo;
        Dp box-impl;
        int i;
        Throwable th2;
        Object obj9;
        anon = continuation;
        _this = Integer.MIN_VALUE;
        if (continuation instanceof FloatingActionButtonElevationAnimatable.snapElevation.1 && label &= _this != 0) {
            anon = continuation;
            _this = Integer.MIN_VALUE;
            if (label &= _this != 0) {
                anon.label = obj9 -= _this;
            } else {
                anon = new FloatingActionButtonElevationAnimatable.snapElevation.1(this, continuation);
            }
        } else {
        }
        obj9 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (_this2) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                _this2 = this;
                targetInteraction = _this2.calculateTarget-u2uoSUM(_this2.targetInteraction);
                anon.L$0 = _this2;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                cOROUTINE_SUSPENDED = _this2;
                return Unit.INSTANCE;
            case 1:
                cOROUTINE_SUSPENDED = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        cOROUTINE_SUSPENDED.lastTargetInteraction = cOROUTINE_SUSPENDED.targetInteraction;
    }

    public final Object animateElevation(Interaction interaction, Continuation<? super Unit> continuation2) {
        boolean anon;
        Throwable th;
        Object cOROUTINE_SUSPENDED;
        Throwable _this;
        Object _this2;
        Object animateElevation-rAjV9yQ;
        Animatable animatable;
        Interaction lastTargetInteraction;
        int i;
        Throwable th2;
        Object obj9;
        Object obj10;
        anon = continuation2;
        _this = Integer.MIN_VALUE;
        if (continuation2 instanceof FloatingActionButtonElevationAnimatable.animateElevation.1 && label &= _this != 0) {
            anon = continuation2;
            _this = Integer.MIN_VALUE;
            if (label &= _this != 0) {
                anon.label = obj10 -= _this;
            } else {
                anon = new FloatingActionButtonElevationAnimatable.animateElevation.1(this, continuation2);
            }
        } else {
        }
        obj10 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (_this2) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                _this2 = this;
                animateElevation-rAjV9yQ = _this2.calculateTarget-u2uoSUM(interaction);
                _this2.targetInteraction = interaction;
                anon.L$0 = _this2;
                anon.L$1 = interaction;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                cOROUTINE_SUSPENDED = _this2;
                _this2.lastTargetInteraction = obj9;
                return Unit.INSTANCE;
            case 1:
                obj9 = anon.L$1;
                cOROUTINE_SUSPENDED = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        _this2 = cOROUTINE_SUSPENDED;
    }

    public final State<Dp> asState() {
        return this.animatable.asState();
    }

    public final Object updateElevation-lDy3nrA(float defaultElevation, float pressedElevation, float hoveredElevation, float focusedElevation, Continuation<? super Unit> $completion) {
        this.defaultElevation = defaultElevation;
        this.pressedElevation = pressedElevation;
        this.hoveredElevation = hoveredElevation;
        this.focusedElevation = focusedElevation;
        Object snapElevation = snapElevation($completion);
        if (snapElevation == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return snapElevation;
        }
        return Unit.INSTANCE;
    }
}
