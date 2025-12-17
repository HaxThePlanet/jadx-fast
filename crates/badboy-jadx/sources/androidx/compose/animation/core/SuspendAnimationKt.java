package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000f\u001a\u0096\u0001\u0010\u0005\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007\"\u0008\u0008\u0001\u0010\u0008*\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u000b2\u0006\u0010\u000c\u001a\u0002H\u00072\u0006\u0010\r\u001a\u0002H\u00072\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u0001H\u00072\u000e\u0008\u0002\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u0011H\u0007¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0013\u0012\u0011H\u0007¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H\u0086@¢\u0006\u0002\u0010\u0017\u001ap\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00012\u000e\u0008\u0002\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H\u0086@¢\u0006\u0002\u0010\u0018\u001a^\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u001a26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H\u0086@¢\u0006\u0002\u0010\u001b\u001as\u0010\u0005\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007\"\u0008\u0008\u0001\u0010\u0008*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2%\u0008\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\u0008#H\u0080@¢\u0006\u0002\u0010$\u001am\u0010\u0019\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007\"\u0008\u0008\u0001\u0010\u0008*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u001c2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00070%2\u0008\u0008\u0002\u0010&\u001a\u00020'2%\u0008\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\u0008#H\u0086@¢\u0006\u0002\u0010(\u001aw\u0010)\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007\"\u0008\u0008\u0001\u0010\u0008*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u001c2\u0006\u0010\r\u001a\u0002H\u00072\u000e\u0008\u0002\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u00102\u0008\u0008\u0002\u0010&\u001a\u00020'2%\u0008\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\u0008#H\u0086@¢\u0006\u0002\u0010*\u001aW\u0010+\u001a\u0002H,\"\u0004\u0008\u0000\u0010,\"\u0004\u0008\u0001\u0010\u0007\"\u0008\u0008\u0002\u0010\u0008*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u001e2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(.\u0012\u0004\u0012\u0002H,0!H\u0082@¢\u0006\u0002\u0010/\u001a\u0085\u0001\u00100\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007\"\u0008\u0008\u0001\u0010\u0008*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\"2\u0006\u0010.\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\u0008#H\u0002\u001a\u0085\u0001\u00104\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007\"\u0008\u0008\u0001\u0010\u0008*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\"2\u0006\u0010.\u001a\u00020 2\u0006\u0010\u0000\u001a\u00020\u00012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\u0008#H\u0002\u001a<\u00105\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007\"\u0008\u0008\u0001\u0010\u0008*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\"2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u001cH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u00066", d2 = {"durationScale", "", "Lkotlin/coroutines/CoroutineContext;", "getDurationScale", "(Lkotlin/coroutines/CoroutineContext;)F", "animate", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "velocity", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(FFFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(FFLandroidx/compose/animation/core/FloatDecayAnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/AnimationState;", "animation", "Landroidx/compose/animation/core/Animation;", "startTimeNanos", "", "Lkotlin/Function1;", "Landroidx/compose/animation/core/AnimationScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/Animation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "sequentialAnimation", "", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callWithFrameNanos", "R", "onFrame", "frameTimeNanos", "(Landroidx/compose/animation/core/Animation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doAnimationFrame", "playTimeNanos", "anim", "state", "doAnimationFrameWithScale", "updateState", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SuspendAnimationKt {
    public static final Object access$callWithFrameNanos(androidx.compose.animation.core.Animation $receiver, Function1 onFrame, Continuation $completion) {
        return SuspendAnimationKt.callWithFrameNanos($receiver, onFrame, $completion);
    }

    public static final void access$doAnimationFrameWithScale(androidx.compose.animation.core.AnimationScope $receiver, long frameTimeNanos, float durationScale, androidx.compose.animation.core.Animation anim, androidx.compose.animation.core.AnimationState state, Function1 block) {
        SuspendAnimationKt.doAnimationFrameWithScale($receiver, frameTimeNanos, durationScale, anim, state, block);
    }

    public static final Object animate(float initialValue, float targetValue, float initialVelocity, androidx.compose.animation.core.AnimationSpec<Float> animationSpec, Function2<? super Float, ? super Float, Unit> block, Continuation<? super Unit> $completion) {
        Object obj11 = SuspendAnimationKt.animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(initialValue), Boxing.boxFloat(targetValue), Boxing.boxFloat(initialVelocity), animationSpec, block, $completion);
        if (obj11 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj11;
        }
        return Unit.INSTANCE;
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> Object animate(androidx.compose.animation.core.AnimationState<T, V> animationState, androidx.compose.animation.core.Animation<T, V> animation2, long l3, Function1<? super androidx.compose.animation.core.AnimationScope<T, V>, Unit> function14, Continuation<? super Unit> continuation5) {
        Object obj;
        boolean anon;
        int i2;
        Ref.ObjectRef cmp;
        Object lateInitScope;
        int i3;
        Object element;
        Object l$2;
        Object l$1;
        androidx.compose.animation.core.AnimationState animationState2;
        Object l$0;
        androidx.compose.animation.core.SuspendAnimationKt.animate.6 lastFrameTimeNanos;
        Object obj2;
        Ref.ObjectRef objectRef;
        Object lastFrameTimeNanos2;
        Object obj6;
        androidx.compose.animation.core.Animation animation;
        Object velocityVectorFromNanos;
        Object obj5;
        Object obj3;
        float block;
        Object obj4;
        androidx.compose.animation.core.TwoWayConverter typeConverter;
        androidx.compose.animation.core.AnimationVector animationVector;
        long l;
        Object targetValue;
        long l2;
        int i;
        androidx.compose.animation.core.SuspendAnimationKt.animate.7 anon2;
        Object obj25;
        Ref.ObjectRef obj26;
        float obj27;
        androidx.compose.animation.core.Animation obj28;
        androidx.compose.animation.core.AnimationState obj29;
        Object obj30;
        obj = obj30;
        anon = obj;
        cmp = Integer.MIN_VALUE;
        if (obj instanceof SuspendAnimationKt.animate.4 && label2 &= cmp != 0) {
            anon = obj;
            cmp = Integer.MIN_VALUE;
            if (label2 &= cmp != 0) {
                anon.label = label -= cmp;
            } else {
                anon = new SuspendAnimationKt.animate.4(obj);
            }
        } else {
        }
        Object result = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(result);
                obj5 = animationState;
                l = l3;
                androidx.compose.animation.core.AnimationState animationState3 = continuation5;
                animation = animation2;
                int i5 = 0;
                lastFrameTimeNanos2 = animation.getValueFromNanos(i5);
                velocityVectorFromNanos = animation.getVelocityVectorFromNanos(i5);
                objectRef = new Ref.ObjectRef();
                obj4 = animationState3;
                lastFrameTimeNanos = new SuspendAnimationKt.animate.6(objectRef, lastFrameTimeNanos2, animation, velocityVectorFromNanos, obj5, SuspendAnimationKt.getDurationScale(anon.getContext()), obj4);
                anon.L$0 = obj5;
                anon.L$1 = animation;
                anon.L$2 = obj4;
                anon.L$3 = objectRef;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                l$1 = animation;
                l$0 = obj5;
                lateInitScope = objectRef;
                SuspendAnimationKt.animate.7 anon4 = new SuspendAnimationKt.animate.7(obj5);
                AnimationScope block2 = new AnimationScope(lastFrameTimeNanos2, animation.getTypeConverter(), velocityVectorFromNanos, l, obj19, animation.getTargetValue(), l, obj22, 1, (Function0)anon4);
                l$1 = block2;
                l$0 = 0;
                velocityVectorFromNanos = animation;
                SuspendAnimationKt.doAnimationFrameWithScale(l$1, l, lastFrameTimeNanos2, SuspendAnimationKt.getDurationScale(anon.getContext()), velocityVectorFromNanos, obj5);
                obj6 = velocityVectorFromNanos;
                lateInitScope.element = l$1;
                obj2 = lateInitScope;
                Object lateInitScope2 = obj2.element;
                Intrinsics.checkNotNull(lateInitScope2);
                obj27 = durationScale2;
                obj25 = anon3;
                obj26 = obj2;
                obj28 = obj6;
                obj29 = obj5;
                obj30 = obj3;
                super(obj26, obj27, obj28, obj29, obj30);
                lateInitScope = obj26;
                lastFrameTimeNanos = obj27;
                l$1 = obj28;
                l$0 = obj29;
                l$2 = obj30;
                anon.L$0 = l$0;
                anon.L$1 = l$1;
                anon.L$2 = l$2;
                anon.L$3 = lateInitScope;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                obj2 = lateInitScope;
                obj3 = l$2;
                obj6 = l$1;
                obj5 = l$0;
                return Unit.INSTANCE;
            case 1:
                lateInitScope = anon.L$3;
                l$2 = anon.L$2;
                l$1 = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(result);
                break;
            case 2:
                ResultKt.throwOnFailure(result);
                obj2 = lateInitScope;
                obj3 = l$2;
                obj6 = l$1;
                obj5 = l$0;
                lateInitScope2 = obj2.element;
                Intrinsics.checkNotNull(lateInitScope2);
                obj27 = durationScale2;
                obj25 = anon3;
                obj26 = obj2;
                obj28 = obj6;
                obj29 = obj5;
                obj30 = obj3;
                super(obj26, obj27, obj28, obj29, obj30);
                lateInitScope = obj26;
                lastFrameTimeNanos = obj27;
                l$1 = obj28;
                l$0 = obj29;
                l$2 = obj30;
                anon.L$0 = l$0;
                anon.L$1 = l$1;
                anon.L$2 = l$2;
                anon.L$3 = lateInitScope;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                obj2 = lateInitScope;
                obj3 = l$2;
                obj6 = l$1;
                obj5 = l$0;
                return Unit.INSTANCE;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
        }
        obj2 = lateInitScope;
        obj3 = l$2;
        obj6 = l$1;
        obj5 = l$0;
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> Object animate(androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, T initialValue, T targetValue, T initialVelocity, androidx.compose.animation.core.AnimationSpec<T> animationSpec, Function2<? super T, ? super T, Unit> block, Continuation<? super Unit> $completion) {
        Object invoke;
        int i;
        Object instance;
        Object obj;
        if (initialVelocity != null) {
            i = 0;
            instance = typeConverter.getConvertToVector().invoke(initialVelocity);
            if ((AnimationVector)instance == null) {
                obj = instance;
            } else {
                obj = instance;
            }
        } else {
        }
        Object obj5 = obj;
        TargetBasedAnimation targetBasedAnimation2 = new TargetBasedAnimation(animationSpec, typeConverter, initialValue, targetValue, obj5);
        final int i3 = 0;
        AnimationState animationState = new AnimationState(typeConverter, initialValue, obj5, 0, obj5, i3, obj8, 0, 56, 0);
        SuspendAnimationKt.animate.3 anon = new SuspendAnimationKt.animate.3(block, typeConverter);
        Object animate$default = SuspendAnimationKt.animate$default(animationState, (Animation)targetBasedAnimation2, i3, obj8, (Function1)anon, $completion, 2);
        if (animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return animate$default;
        }
        return Unit.INSTANCE;
    }

    public static Object animate$default(float f, float f2, float f3, androidx.compose.animation.core.AnimationSpec animationSpec4, Function2 function25, Continuation continuation6, int i7, Object object8) {
        int obj3;
        androidx.compose.animation.core.SpringSpec obj4;
        int obj7;
        final int i = 0;
        if (i7 & 4 != 0) {
            obj3 = i;
        }
        if (i7 &= 8 != 0) {
            obj7 = 0;
            obj4 = AnimationSpecKt.spring$default(i, i, obj7, 7, obj7);
        }
        return SuspendAnimationKt.animate(f, f2, obj3, obj4, function25, continuation6);
    }

    public static Object animate$default(androidx.compose.animation.core.AnimationState animationState, androidx.compose.animation.core.Animation animation2, long l3, Function1 function14, Continuation continuation5, int i6, Object object7) {
        long l;
        androidx.compose.animation.core.SuspendAnimationKt.animate.5 anon;
        long obj8;
        androidx.compose.animation.core.SuspendAnimationKt.animate.5 obj10;
        l = object7 & 2 != 0 ? obj8 : l3;
        if (object7 & 4 != 0) {
            anon = obj10;
        } else {
            anon = continuation5;
        }
        return SuspendAnimationKt.animate(animationState, animation2, l, obj3, anon);
    }

    public static Object animate$default(androidx.compose.animation.core.TwoWayConverter twoWayConverter, Object object2, Object object3, Object object4, androidx.compose.animation.core.AnimationSpec animationSpec5, Function2 function26, Continuation continuation7, int i8, Object object9) {
        int obj4;
        androidx.compose.animation.core.SpringSpec obj5;
        int obj8;
        final int i = 0;
        if (i8 & 8 != 0) {
            obj4 = i;
        }
        if (i8 &= 16 != 0) {
            obj8 = 0;
            obj5 = AnimationSpecKt.spring$default(obj8, obj8, i, 7, i);
        }
        return SuspendAnimationKt.animate(twoWayConverter, object2, object3, obj4, obj5, function26, continuation7);
    }

    public static final Object animateDecay(float initialValue, float initialVelocity, androidx.compose.animation.core.FloatDecayAnimationSpec animationSpec, Function2<? super Float, ? super Float, Unit> block, Continuation<? super Unit> $completion) {
        float f = initialValue;
        float f2 = initialVelocity;
        SuspendAnimationKt.animateDecay.2 anon = new SuspendAnimationKt.animateDecay.2(block);
        Object animate$default = SuspendAnimationKt.animate$default(AnimationStateKt.AnimationState$default(f, f2, 0, obj3, false, obj5, 0), (Animation)AnimationKt.DecayAnimation(animationSpec, f, f2), 0, obj14, (Function1)anon, $completion, 2);
        if (animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return animate$default;
        }
        return Unit.INSTANCE;
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> Object animateDecay(androidx.compose.animation.core.AnimationState<T, V> $this$animateDecay, androidx.compose.animation.core.DecayAnimationSpec<T> animationSpec, boolean sequentialAnimation, Function1<? super androidx.compose.animation.core.AnimationScope<T, V>, Unit> block, Continuation<? super Unit> $completion) {
        long lastFrameTimeNanos;
        DecayAnimation decayAnimation = new DecayAnimation(animationSpec, $this$animateDecay.getTypeConverter(), $this$animateDecay.getValue(), $this$animateDecay.getVelocityVector());
        if (sequentialAnimation) {
            lastFrameTimeNanos = $this$animateDecay.getLastFrameTimeNanos();
        } else {
            lastFrameTimeNanos = Long.MIN_VALUE;
        }
        Object obj10 = SuspendAnimationKt.animate($this$animateDecay, (Animation)decayAnimation, lastFrameTimeNanos, obj7, block);
        if (obj10 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj10;
        }
        return Unit.INSTANCE;
    }

    public static Object animateDecay$default(androidx.compose.animation.core.AnimationState animationState, androidx.compose.animation.core.DecayAnimationSpec decayAnimationSpec2, boolean z3, Function1 function14, Continuation continuation5, int i6, Object object7) {
        int obj2;
        androidx.compose.animation.core.SuspendAnimationKt.animateDecay.4 obj3;
        if (i6 & 2 != 0) {
            obj2 = 0;
        }
        if (i6 &= 4 != 0) {
            obj3 = SuspendAnimationKt.animateDecay.4.INSTANCE;
        }
        return SuspendAnimationKt.animateDecay(animationState, decayAnimationSpec2, obj2, obj3, continuation5);
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> Object animateTo(androidx.compose.animation.core.AnimationState<T, V> $this$animateTo, T targetValue, androidx.compose.animation.core.AnimationSpec<T> animationSpec, boolean sequentialAnimation, Function1<? super androidx.compose.animation.core.AnimationScope<T, V>, Unit> block, Continuation<? super Unit> $completion) {
        long lastFrameTimeNanos;
        final Object obj2 = targetValue;
        TargetBasedAnimation targetBasedAnimation = new TargetBasedAnimation(animationSpec, $this$animateTo.getTypeConverter(), $this$animateTo.getValue(), obj2, $this$animateTo.getVelocityVector());
        if (sequentialAnimation) {
            lastFrameTimeNanos = $this$animateTo.getLastFrameTimeNanos();
        } else {
            lastFrameTimeNanos = Long.MIN_VALUE;
        }
        Object animate = SuspendAnimationKt.animate($this$animateTo, (Animation)targetBasedAnimation, lastFrameTimeNanos, obj2, block);
        if (animate == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return animate;
        }
        return Unit.INSTANCE;
    }

    public static Object animateTo$default(androidx.compose.animation.core.AnimationState animationState, Object object2, androidx.compose.animation.core.AnimationSpec animationSpec3, boolean z4, Function1 function15, Continuation continuation6, int i7, Object object8) {
        int i2;
        androidx.compose.animation.core.SpringSpec springSpec;
        int i;
        androidx.compose.animation.core.SuspendAnimationKt.animateTo.2 anon;
        androidx.compose.animation.core.SpringSpec obj8;
        int obj9;
        androidx.compose.animation.core.SuspendAnimationKt.animateTo.2 obj10;
        int obj13;
        if (i7 & 2 != 0) {
            obj13 = 0;
            i2 = 0;
            springSpec = obj8;
        } else {
            springSpec = animationSpec3;
        }
        i = i7 & 4 != 0 ? obj9 : z4;
        if (i7 & 8 != 0) {
            anon = obj10;
        } else {
            anon = function15;
        }
        return SuspendAnimationKt.animateTo(animationState, object2, springSpec, i, anon, continuation6);
    }

    private static final <R, T, V extends androidx.compose.animation.core.AnimationVector> Object callWithFrameNanos(androidx.compose.animation.core.Animation<T, V> $this$callWithFrameNanos, Function1<? super Long, ? extends R> onFrame, Continuation<? super R> $completion) {
        Object infiniteAnimationFrameNanos;
        if ($this$callWithFrameNanos.isInfinite()) {
            infiniteAnimationFrameNanos = InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(onFrame, $completion);
        } else {
            SuspendAnimationKt.callWithFrameNanos.2 anon = new SuspendAnimationKt.callWithFrameNanos.2(onFrame);
            infiniteAnimationFrameNanos = MonotonicFrameClockKt.withFrameNanos((Function1)anon, $completion);
        }
        return infiniteAnimationFrameNanos;
    }

    private static final <T, V extends androidx.compose.animation.core.AnimationVector> void doAnimationFrame(androidx.compose.animation.core.AnimationScope<T, V> $this$doAnimationFrame, long frameTimeNanos, long playTimeNanos, androidx.compose.animation.core.Animation<T, V> anim, androidx.compose.animation.core.AnimationState<T, V> state, Function1<? super androidx.compose.animation.core.AnimationScope<T, V>, Unit> block) {
        int i;
        $this$doAnimationFrame.setLastFrameTimeNanos$animation_core_release(frameTimeNanos);
        $this$doAnimationFrame.setValue$animation_core_release(block.getValueFromNanos(anim));
        $this$doAnimationFrame.setVelocityVector$animation_core_release(block.getVelocityVectorFromNanos(anim));
        if (block.isFinishedFromNanos(anim)) {
            $this$doAnimationFrame.setFinishedTimeNanos$animation_core_release($this$doAnimationFrame.getLastFrameTimeNanos());
            $this$doAnimationFrame.setRunning$animation_core_release(false);
        }
        SuspendAnimationKt.updateState($this$doAnimationFrame, obj9);
        obj10.invoke($this$doAnimationFrame);
    }

    private static final <T, V extends androidx.compose.animation.core.AnimationVector> void doAnimationFrameWithScale(androidx.compose.animation.core.AnimationScope<T, V> $this$doAnimationFrameWithScale, long frameTimeNanos, float durationScale, androidx.compose.animation.core.Animation<T, V> anim, androidx.compose.animation.core.AnimationState<T, V> state, Function1<? super androidx.compose.animation.core.AnimationScope<T, V>, Unit> block) {
        int i;
        long durationNanos;
        i = Float.compare(anim, i2) == 0 ? 1 : 0;
        if (i != 0) {
            durationNanos = state.getDurationNanos();
        } else {
            durationNanos = (long)i4;
        }
        SuspendAnimationKt.doAnimationFrame($this$doAnimationFrameWithScale, frameTimeNanos, obj4, durationNanos, obj6, state);
    }

    public static final float getDurationScale(CoroutineContext $this$durationScale) {
        int scaleFactor;
        int i;
        String $i$a$CheckPreconditionSuspendAnimationKt$durationScale$1;
        kotlin.coroutines.CoroutineContext.Element context = $this$durationScale.get((CoroutineContext.Key)MotionDurationScale.Key);
        if ((MotionDurationScale)context != null) {
            scaleFactor = (MotionDurationScale)context.getScaleFactor();
        } else {
            scaleFactor = 1065353216;
        }
        i = Float.compare(scaleFactor, i2) >= 0 ? 1 : 0;
        final int i3 = 0;
        if (i == 0) {
            int i4 = 0;
            PreconditionsKt.throwIllegalStateException("negative scale factor");
        }
        return scaleFactor;
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> void updateState(androidx.compose.animation.core.AnimationScope<T, V> $this$updateState, androidx.compose.animation.core.AnimationState<T, V> state) {
        state.setValue$animation_core_release($this$updateState.getValue());
        final androidx.compose.animation.core.AnimationVector velocityVector2 = $this$updateState.getVelocityVector();
        AnimationVectorsKt.copyFrom(state.getVelocityVector(), velocityVector2);
        state.setFinishedTimeNanos$animation_core_release($this$updateState.getFinishedTimeNanos());
        state.setLastFrameTimeNanos$animation_core_release($this$updateState.getLastFrameTimeNanos());
        state.setRunning$animation_core_release($this$updateState.isRunning());
    }
}
