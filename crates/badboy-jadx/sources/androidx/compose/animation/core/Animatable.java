package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B/\u0008\u0017\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\tB7\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00018\u0000\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJY\u0010=\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010>2\u0006\u0010?\u001a\u00028\u00002\u000c\u0010@\u001a\u0008\u0012\u0004\u0012\u00028\u00000A2'\u0008\u0002\u0010B\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020D\u0018\u00010C¢\u0006\u0002\u0008EH\u0086@¢\u0006\u0002\u0010FJe\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010>2\u0006\u0010,\u001a\u00028\u00002\u000e\u0008\u0002\u0010@\u001a\u0008\u0012\u0004\u0012\u00028\u00000H2\u0008\u0008\u0002\u0010?\u001a\u00028\u00002'\u0008\u0002\u0010B\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020D\u0018\u00010C¢\u0006\u0002\u0008EH\u0086@¢\u0006\u0002\u0010IJ\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u00028\u00000KJ\u0015\u0010L\u001a\u00028\u00002\u0006\u00106\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010MJ\u0008\u0010N\u001a\u00020DH\u0002J]\u0010O\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010>2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010Q2\u0006\u0010?\u001a\u00028\u00002%\u0010B\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020D\u0018\u00010C¢\u0006\u0002\u0008EH\u0082@¢\u0006\u0002\u0010RJ\u0016\u0010S\u001a\u00020D2\u0006\u0010,\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010TJ\u000e\u0010U\u001a\u00020DH\u0086@¢\u0006\u0002\u0010VJ#\u0010W\u001a\u00020D2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00018\u00002\n\u0008\u0002\u00103\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010XR\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000eX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001b\u0010\u001c\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00018\u00002\u0008\u0010\u0015\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\u0008 \u0010!R\u0010\u0010#\u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\u00028\u0001X\u0082\u0004¢\u0006\n\n\u0002\u0010$\u0012\u0004\u0008(\u0010)R\u0016\u0010*\u001a\u00028\u0001X\u0082\u0004¢\u0006\n\n\u0002\u0010$\u0012\u0004\u0008+\u0010)R+\u0010,\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u00080\u0010\u001c\u001a\u0004\u0008-\u0010!\"\u0004\u0008.\u0010/R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R$\u00103\u001a\u0004\u0018\u00018\u00002\u0008\u0010\u0015\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\u00084\u0010!R\u0010\u00105\u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u0011\u00106\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\u00087\u0010!R\u0011\u00108\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\u00089\u0010!R\u0011\u0010:\u001a\u00028\u00018F¢\u0006\u0006\u001a\u0004\u0008;\u0010<R\u0012\u0010\u0008\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"¨\u0006Y", d2 = {"Landroidx/compose/animation/core/Animatable;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "initialValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "visibilityThreshold", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/String;)V", "defaultSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "getDefaultSpringSpec$animation_core_release", "()Landroidx/compose/animation/core/SpringSpec;", "internalState", "Landroidx/compose/animation/core/AnimationState;", "getInternalState$animation_core_release", "()Landroidx/compose/animation/core/AnimationState;", "<set-?>", "", "isRunning", "()Z", "setRunning", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "lowerBound", "getLowerBound", "()Ljava/lang/Object;", "Ljava/lang/Object;", "lowerBoundVector", "Landroidx/compose/animation/core/AnimationVector;", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "negativeInfinityBounds", "getNegativeInfinityBounds$annotations", "()V", "positiveInfinityBounds", "getPositiveInfinityBounds$annotations", "targetValue", "getTargetValue", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "upperBound", "getUpperBound", "upperBoundVector", "value", "getValue", "velocity", "getVelocity", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "animateDecay", "Landroidx/compose/animation/core/AnimationResult;", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "Landroidx/compose/animation/core/AnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "clampToBounds", "(Ljava/lang/Object;)Ljava/lang/Object;", "endAnimation", "runAnimation", "animation", "Landroidx/compose/animation/core/Animation;", "(Landroidx/compose/animation/core/Animation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBounds", "(Ljava/lang/Object;Ljava/lang/Object;)V", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Animatable<T, V extends androidx.compose.animation.core.AnimationVector>  {

    public static final int $stable = 8;
    private final androidx.compose.animation.core.SpringSpec<T> defaultSpringSpec;
    private final androidx.compose.animation.core.AnimationState<T, V> internalState;
    private final MutableState isRunning$delegate;
    private final String label;
    private T lowerBound;
    private V lowerBoundVector;
    private final androidx.compose.animation.core.MutatorMutex mutatorMutex;
    private final V negativeInfinityBounds;
    private final V positiveInfinityBounds;
    private final MutableState targetValue$delegate;
    private final androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter;
    private T upperBound;
    private V upperBoundVector;
    private final T visibilityThreshold;
    static {
        final int i = 8;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility", replaceWith = @ReplaceWith(...))
    public Animatable(Object initialValue, androidx.compose.animation.core.TwoWayConverter typeConverter, Object visibilityThreshold) {
        super(initialValue, typeConverter, visibilityThreshold, "Animatable");
    }

    public Animatable(Object object, androidx.compose.animation.core.TwoWayConverter twoWayConverter2, Object object3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(object, twoWayConverter2, obj3);
    }

    public Animatable(T initialValue, androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, T visibilityThreshold, String label) {
        boolean z;
        boolean z2;
        androidx.compose.animation.core.AnimationVector obj12;
        super();
        this.typeConverter = typeConverter;
        this.visibilityThreshold = visibilityThreshold;
        this.label = label;
        final Object obj = initialValue;
        AnimationState animationState = new AnimationState(this.typeConverter, obj, 0, 0, obj5, 0, obj7, 0, 60, 0);
        this.internalState = animationState;
        int i = 0;
        int i2 = 2;
        this.isRunning$delegate = SnapshotStateKt.mutableStateOf$default(false, i, i2, i);
        this.targetValue$delegate = SnapshotStateKt.mutableStateOf$default(obj, i, i2, i);
        obj12 = new MutatorMutex();
        this.mutatorMutex = obj12;
        SpringSpec springSpec = new SpringSpec(0, 0, this.visibilityThreshold, 3, 0);
        this.defaultSpringSpec = springSpec;
        obj12 = getVelocityVector();
        if (obj12 instanceof AnimationVector1D) {
            obj12 = AnimatableKt.access$getNegativeInfinityBounds1D$p();
        } else {
            if (obj12 instanceof AnimationVector2D) {
                obj12 = AnimatableKt.access$getNegativeInfinityBounds2D$p();
            } else {
                if (obj12 instanceof AnimationVector3D) {
                    obj12 = AnimatableKt.access$getNegativeInfinityBounds3D$p();
                } else {
                    obj12 = AnimatableKt.access$getNegativeInfinityBounds4D$p();
                }
            }
        }
        String str = "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable";
        Intrinsics.checkNotNull(obj12, str);
        this.negativeInfinityBounds = obj12;
        obj12 = getVelocityVector();
        if (obj12 instanceof AnimationVector1D) {
            obj12 = AnimatableKt.access$getPositiveInfinityBounds1D$p();
        } else {
            if (obj12 instanceof AnimationVector2D) {
                obj12 = AnimatableKt.access$getPositiveInfinityBounds2D$p();
            } else {
                if (obj12 instanceof AnimationVector3D) {
                    obj12 = AnimatableKt.access$getPositiveInfinityBounds3D$p();
                } else {
                    obj12 = AnimatableKt.access$getPositiveInfinityBounds4D$p();
                }
            }
        }
        Intrinsics.checkNotNull(obj12, str);
        this.positiveInfinityBounds = obj12;
        this.lowerBoundVector = this.negativeInfinityBounds;
        this.upperBoundVector = this.positiveInfinityBounds;
    }

    public Animatable(Object object, androidx.compose.animation.core.TwoWayConverter twoWayConverter2, Object object3, String string4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj3;
        String obj4;
        obj3 = i5 & 4 != 0 ? 0 : obj3;
        obj4 = i5 &= 8 != 0 ? "Animatable" : obj4;
        super(object, twoWayConverter2, obj3, obj4);
    }

    public static final Object access$clampToBounds(androidx.compose.animation.core.Animatable $this, Object value) {
        return $this.clampToBounds(value);
    }

    public static final void access$endAnimation(androidx.compose.animation.core.Animatable $this) {
        $this.endAnimation();
    }

    public static final Object access$runAnimation(androidx.compose.animation.core.Animatable $this, androidx.compose.animation.core.Animation animation, Object initialVelocity, Function1 block, Continuation $completion) {
        return $this.runAnimation(animation, initialVelocity, block, $completion);
    }

    public static final void access$setRunning(androidx.compose.animation.core.Animatable $this, boolean <set-?>) {
        $this.setRunning(<set-?>);
    }

    public static final void access$setTargetValue(androidx.compose.animation.core.Animatable $this, Object <set-?>) {
        $this.setTargetValue(<set-?>);
    }

    public static Object animateDecay$default(androidx.compose.animation.core.Animatable animatable, Object object2, androidx.compose.animation.core.DecayAnimationSpec decayAnimationSpec3, Function1 function14, Continuation continuation5, int i6, Object object7) {
        int obj3;
        if (i6 &= 4 != 0) {
            obj3 = 0;
        }
        return animatable.animateDecay(object2, decayAnimationSpec3, obj3, continuation5);
    }

    public static Object animateTo$default(androidx.compose.animation.core.Animatable animatable, Object object2, androidx.compose.animation.core.AnimationSpec animationSpec3, Object object4, Function1 function15, Continuation continuation6, int i7, Object object8) {
        androidx.compose.animation.core.SpringSpec springSpec;
        Object obj;
        int i;
        androidx.compose.animation.core.SpringSpec obj8;
        Object obj9;
        int obj10;
        if (i7 & 2 != 0) {
            springSpec = obj8;
        } else {
            springSpec = animationSpec3;
        }
        if (i7 & 4 != 0) {
            obj = obj9;
        } else {
            obj = object4;
        }
        i = i7 & 8 != 0 ? obj10 : function15;
        return animatable.animateTo(object2, springSpec, obj, i, continuation6);
    }

    private final T clampToBounds(T value) {
        boolean equal;
        androidx.compose.animation.core.AnimationVector negativeInfinityBounds;
        int clamped;
        int i;
        float coerceIn;
        float f2;
        float f;
        if (Intrinsics.areEqual(this.lowerBoundVector, this.negativeInfinityBounds) && Intrinsics.areEqual(this.upperBoundVector, this.positiveInfinityBounds)) {
            if (Intrinsics.areEqual(this.upperBoundVector, this.positiveInfinityBounds)) {
                return value;
            }
        }
        Object invoke = this.typeConverter.getConvertToVector().invoke(value);
        clamped = 0;
        i = 0;
        while (i < (AnimationVector)invoke.getSize$animation_core_release()) {
            if (Float.compare(f3, f2) >= 0) {
            } else {
            }
            clamped = 1;
            invoke.set$animation_core_release(i, RangesKt.coerceIn(invoke.get$animation_core_release(i), this.lowerBoundVector.get$animation_core_release(i), this.upperBoundVector.get$animation_core_release(i)));
            i++;
            if (Float.compare(f5, f2) > 0) {
            }
        }
        if (clamped != 0) {
            return this.typeConverter.getConvertFromVector().invoke(invoke);
        }
        return value;
    }

    private final void endAnimation() {
        androidx.compose.animation.core.AnimationState internalState = this.internalState;
        final int i2 = 0;
        internalState.getVelocityVector().reset$animation_core_release();
        internalState.setLastFrameTimeNanos$animation_core_release(Long.MIN_VALUE);
        setRunning(false);
    }

    private static void getNegativeInfinityBounds$annotations() {
    }

    private static void getPositiveInfinityBounds$annotations() {
    }

    private final Object runAnimation(androidx.compose.animation.core.Animation<T, V> animation, T initialVelocity, Function1<? super androidx.compose.animation.core.Animatable<T, V>, Unit> block, Continuation<? super androidx.compose.animation.core.AnimationResult<T, V>> $completion) {
        final int i = 0;
        Animatable.runAnimation.2 anon = new Animatable.runAnimation.2(this, initialVelocity, animation, this.internalState.getLastFrameTimeNanos(), obj5, block, i);
        return MutatorMutex.mutate$default(this.mutatorMutex, i, (Function1)anon, $completion, 1, 0);
    }

    private final void setRunning(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isRunning$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setTargetValue(T <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.targetValue$delegate.setValue(<set-?>);
    }

    public static void updateBounds$default(androidx.compose.animation.core.Animatable animatable, Object object2, Object object3, int i4, Object object5) {
        Object obj1;
        Object obj2;
        if (i4 & 1 != 0) {
            obj1 = animatable.lowerBound;
        }
        if (i4 &= 2 != 0) {
            obj2 = animatable.upperBound;
        }
        animatable.updateBounds(obj1, obj2);
    }

    public final Object animateDecay(T initialVelocity, androidx.compose.animation.core.DecayAnimationSpec<T> animationSpec, Function1<? super androidx.compose.animation.core.Animatable<T, V>, Unit> block, Continuation<? super androidx.compose.animation.core.AnimationResult<T, V>> $completion) {
        DecayAnimation decayAnimation2 = new DecayAnimation(animationSpec, this.typeConverter, getValue(), (AnimationVector)this.typeConverter.getConvertToVector().invoke(initialVelocity));
        return runAnimation((Animation)decayAnimation2, initialVelocity, block, $completion);
    }

    public final Object animateTo(T targetValue, androidx.compose.animation.core.AnimationSpec<T> animationSpec, T initialVelocity, Function1<? super androidx.compose.animation.core.Animatable<T, V>, Unit> block, Continuation<? super androidx.compose.animation.core.AnimationResult<T, V>> $completion) {
        return runAnimation((Animation)AnimationKt.TargetBasedAnimation(animationSpec, this.typeConverter, getValue(), targetValue, initialVelocity), initialVelocity, block, $completion);
    }

    public final State<T> asState() {
        return (State)this.internalState;
    }

    public final androidx.compose.animation.core.SpringSpec<T> getDefaultSpringSpec$animation_core_release() {
        return this.defaultSpringSpec;
    }

    public final androidx.compose.animation.core.AnimationState<T, V> getInternalState$animation_core_release() {
        return this.internalState;
    }

    public final String getLabel() {
        return this.label;
    }

    public final T getLowerBound() {
        return this.lowerBound;
    }

    public final T getTargetValue() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.targetValue$delegate.getValue();
    }

    public final androidx.compose.animation.core.TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final T getUpperBound() {
        return this.upperBound;
    }

    public final T getValue() {
        return this.internalState.getValue();
    }

    public final T getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(getVelocityVector());
    }

    public final V getVelocityVector() {
        return this.internalState.getVelocityVector();
    }

    public final boolean isRunning() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isRunning$delegate.getValue().booleanValue();
    }

    public final Object snapTo(T targetValue, Continuation<? super Unit> $completion) {
        Animatable.snapTo.2 anon = new Animatable.snapTo.2(this, targetValue, 0);
        Object obj8 = MutatorMutex.mutate$default(this.mutatorMutex, 0, (Function1)anon, $completion, 1, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public final Object stop(Continuation<? super Unit> $completion) {
        Animatable.stop.2 anon = new Animatable.stop.2(this, 0);
        Object obj7 = MutatorMutex.mutate$default(this.mutatorMutex, 0, (Function1)anon, $completion, 1, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final void updateBounds(T lowerBound, T upperBound) {
        Object obj;
        int i4;
        boolean clampToBounds;
        int i;
        int size$animation_core_release;
        Object negativeInfinityBounds;
        Object positiveInfinityBounds;
        int i3;
        int i2;
        String $i$a$CheckPreconditionAnimatable$updateBounds$1;
        StringBuilder append;
        String str;
        if (lowerBound != null) {
            i = 0;
            if ((AnimationVector)this.typeConverter.getConvertToVector().invoke(lowerBound) == null) {
                negativeInfinityBounds = this.negativeInfinityBounds;
            }
        } else {
        }
        if (upperBound != null) {
            i = 0;
            if ((AnimationVector)this.typeConverter.getConvertToVector().invoke(upperBound) == null) {
                positiveInfinityBounds = this.positiveInfinityBounds;
            }
        } else {
        }
        i4 = 0;
        while (i4 < negativeInfinityBounds.getSize$animation_core_release()) {
            if (Float.compare(f, f2) <= 0) {
            } else {
            }
            i3 = 0;
            i2 = 0;
            if (i3 == 0) {
            }
            i4++;
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder.append("Lower bound must be no greater than upper bound on *all* dimensions. The provided lower bound: ").append(negativeInfinityBounds).append(" is greater than upper bound ").append(positiveInfinityBounds).append(" on index ").append(i4).toString());
            i3 = 1;
        }
        this.lowerBoundVector = negativeInfinityBounds;
        this.upperBoundVector = positiveInfinityBounds;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        clampToBounds = clampToBounds(getValue());
        if (!isRunning() && !Intrinsics.areEqual(clampToBounds, getValue())) {
            clampToBounds = clampToBounds(getValue());
            if (!Intrinsics.areEqual(clampToBounds, getValue())) {
                this.internalState.setValue$animation_core_release(clampToBounds);
            }
        }
    }
}
