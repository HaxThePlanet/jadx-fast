package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005JJ\u0010\u0013\u001a\u00020\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u00140\u00162\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u001bH\u0086@\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/animation/core/AnimationSpec;)V", "isRunning", "", "lastFrameTime", "", "lastVelocity", "Landroidx/compose/animation/core/AnimationVector1D;", "value", "getValue", "()F", "setValue", "(F)V", "vectorizedSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "animateToZero", "", "beforeFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "valueDelta", "afterFrame", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UpdatableAnimationState {

    public static final int $stable = 0;
    private static final androidx.compose.foundation.gestures.UpdatableAnimationState.Companion Companion = null;
    @Deprecated
    public static final float VisibilityThreshold = 0.01f;
    private static final AnimationVector1D ZeroVector;
    private boolean isRunning;
    private long lastFrameTime = Long.MIN_VALUE;
    private AnimationVector1D lastVelocity = Long.MIN_VALUE;
    private float value;
    private final VectorizedAnimationSpec<AnimationVector1D> vectorizedSpec;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u00020\n*\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u000b", d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState$Companion;", "", "()V", "VisibilityThreshold", "", "ZeroVector", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVector", "()Landroidx/compose/animation/core/AnimationVector1D;", "isZeroish", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.access$getZeroVector$cp();
        }

        public final boolean isZeroish(float $this$isZeroish) {
            int i;
            i = Float.compare(f, i2) < 0 ? 1 : 0;
            return i;
        }
    }
    static {
        UpdatableAnimationState.Companion companion = new UpdatableAnimationState.Companion(0);
        UpdatableAnimationState.Companion = companion;
        UpdatableAnimationState.$stable = 8;
        AnimationVector1D animationVector1D = new AnimationVector1D(0);
        UpdatableAnimationState.ZeroVector = animationVector1D;
    }

    public UpdatableAnimationState(AnimationSpec<Float> animationSpec) {
        super();
        this.vectorizedSpec = animationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
        long l = Long.MIN_VALUE;
        AnimationVector1D zeroVector = UpdatableAnimationState.ZeroVector;
    }

    public static final androidx.compose.foundation.gestures.UpdatableAnimationState.Companion access$getCompanion$p() {
        return UpdatableAnimationState.Companion;
    }

    public static final long access$getLastFrameTime$p(androidx.compose.foundation.gestures.UpdatableAnimationState $this) {
        return $this.lastFrameTime;
    }

    public static final AnimationVector1D access$getLastVelocity$p(androidx.compose.foundation.gestures.UpdatableAnimationState $this) {
        return $this.lastVelocity;
    }

    public static final VectorizedAnimationSpec access$getVectorizedSpec$p(androidx.compose.foundation.gestures.UpdatableAnimationState $this) {
        return $this.vectorizedSpec;
    }

    public static final AnimationVector1D access$getZeroVector$cp() {
        return UpdatableAnimationState.ZeroVector;
    }

    public static final void access$setLastFrameTime$p(androidx.compose.foundation.gestures.UpdatableAnimationState $this, long <set-?>) {
        $this.lastFrameTime = <set-?>;
    }

    public static final void access$setLastVelocity$p(androidx.compose.foundation.gestures.UpdatableAnimationState $this, AnimationVector1D <set-?>) {
        $this.lastVelocity = <set-?>;
    }

    public final Object animateToZero(Function1<? super Float, Unit> function1, Function0<Unit> function02, Continuation<? super Unit> continuation3) {
        boolean $result;
        Object $continuation;
        int zeroVector;
        androidx.compose.foundation.gestures.UpdatableAnimationState.animateToZero.1 anon;
        Object cOROUTINE_SUSPENDED;
        int i2;
        Object beforeFrame;
        int i3;
        int i;
        Object _this;
        float scaleFactor;
        boolean frameNanos;
        float value;
        Object obj;
        Object obj13;
        Object obj14;
        Object obj15;
        $result = continuation3;
        i2 = Integer.MIN_VALUE;
        if (continuation3 instanceof UpdatableAnimationState.animateToZero.1 && label &= i2 != 0) {
            $result = continuation3;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                $result.label = obj15 -= i2;
            } else {
                $result = new UpdatableAnimationState.animateToZero.1(this, continuation3);
            }
        } else {
        }
        obj15 = $result.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = 0;
        i = 1;
        final int i5 = 0;
        switch (beforeFrame) {
            case 0:
                ResultKt.throwOnFailure(obj15);
                androidx.compose.foundation.gestures.UpdatableAnimationState updatableAnimationState = this;
                kotlin.coroutines.CoroutineContext.Element context2 = $result.getContext().get((CoroutineContext.Key)MotionDurationScale.Key);
                scaleFactor = (MotionDurationScale)context2.getScaleFactor();
                scaleFactor = 1065353216;
                updatableAnimationState.isRunning = i;
                _this = function1;
                obj13 = f2;
                obj15 = function02;
                obj14 = updatableAnimationState;
                beforeFrame = cOROUTINE_SUSPENDED;
                anon = $result;
                $continuation = obj;
                obj13 = 0;
                obj13 = new IllegalStateException("animateToZero called while previous animation is running".toString());
                throw obj13;
            case 1:
                obj13 = $result.F$0;
                ResultKt.throwOnFailure(obj15);
                obj15 = obj14;
                obj14 = l$0;
                _this = l$1;
                beforeFrame = cOROUTINE_SUSPENDED;
                anon = $result;
                $continuation = obj;
                obj15.invoke();
                frameNanos = i;
                frameNanos = i5;
                obj13 = obj15;
                obj15 = $continuation;
                $result = anon;
                i = i5;
                UpdatableAnimationState.animateToZero.5 anon2 = new UpdatableAnimationState.animateToZero.5(obj14, _this);
                $result.L$0 = obj14;
                $result.L$1 = obj13;
                $result.L$2 = 0;
                $result.label = 2;
                return beforeFrame;
                obj13.invoke();
                obj14.lastFrameTime = Long.MIN_VALUE;
                obj14.lastVelocity = UpdatableAnimationState.ZeroVector;
                obj14.isRunning = i5;
                return Unit.INSTANCE;
            case 2:
                obj13 = $result.L$1;
                obj14 = $result.L$0;
                ResultKt.throwOnFailure(obj15);
                obj13.invoke();
                obj14.lastFrameTime = l;
                obj14.lastVelocity = UpdatableAnimationState.ZeroVector;
                obj14.isRunning = i5;
                return Unit.INSTANCE;
            default:
                obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj13;
        }
        if (!UpdatableAnimationState.Companion.isZeroish(obj14.value)) {
            UpdatableAnimationState.animateToZero.4 anon3 = new UpdatableAnimationState.animateToZero.4(obj14, obj13, _this);
            anon.L$0 = obj14;
            anon.L$1 = _this;
            anon.L$2 = obj15;
            anon.F$0 = obj13;
            anon.label = i;
            if (MonotonicFrameClockKt.withFrameNanos((Function1)anon3, anon) == beforeFrame) {
                return beforeFrame;
            } else {
            }
        } else {
            obj13 = obj15;
            obj15 = $continuation;
            $result = anon;
        }
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float <set-?>) {
        this.value = <set-?>;
    }
}
