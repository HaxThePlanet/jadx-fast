package androidx.compose.animation.core;

import androidx.collection.MutableObjectList;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.Mutex.DefaultImpls;
import kotlinx.coroutines.sync.MutexKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u001a\u0008\u0007\u0018\u0000 X*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002XYB\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010<\u001a\u00020\u0008H\u0082@¢\u0006\u0002\u0010=J*\u0010>\u001a\u00020\u00082\u0008\u0008\u0002\u00101\u001a\u00028\u00002\u0010\u0008\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010@H\u0086@¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\u00020\u0008H\u0082@¢\u0006\u0002\u0010=J\u0008\u0010C\u001a\u00020\u0008H\u0002J\u0008\u0010D\u001a\u00020\u0008H\u0002J\r\u0010E\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0008FJ\r\u0010G\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0008HJ\u0018\u0010I\u001a\u00020\u00082\u0006\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u0007H\u0002J\u000e\u0010L\u001a\u00020\u0008H\u0082@¢\u0006\u0002\u0010=J\"\u0010M\u001a\u00020\u00082\u0008\u0008\u0001\u0010#\u001a\u00020!2\u0008\u0008\u0002\u00101\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010NJ\u0008\u0010O\u001a\u00020\u0008H\u0002J\u0016\u0010P\u001a\u00020\u00082\u0006\u00101\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010QJ\u001b\u0010R\u001a\u00020\u00082\u000c\u0010:\u001a\u0008\u0012\u0004\u0012\u00028\u00000;H\u0010¢\u0006\u0002\u0008SJ\r\u0010T\u001a\u00020\u0008H\u0010¢\u0006\u0002\u0008UJ\u000e\u0010V\u001a\u00020\u0008H\u0082@¢\u0006\u0002\u0010=J\u000e\u0010W\u001a\u00020\u0008H\u0082@¢\u0006\u0002\u0010=R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00028\u0000X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\u0004R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001e\u0010\u001f\u001a\u0004\u0008\u001c\u0010\u000b\"\u0004\u0008\u001d\u0010\u0004R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010#\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020!8G@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008(\u0010)\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R\u0014\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\u00190+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u000800X\u0082\u0004¢\u0006\u0002\n\u0000R+\u00101\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u00084\u0010\u001f\u001a\u0004\u00082\u0010\u000b\"\u0004\u00083\u0010\u0004R\u001a\u00105\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00086\u00107\"\u0004\u00088\u00109R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z", d2 = {"Landroidx/compose/animation/core/SeekableTransitionState;", "S", "Landroidx/compose/animation/core/TransitionState;", "initialState", "(Ljava/lang/Object;)V", "animateOneFrameLambda", "Lkotlin/Function1;", "", "", "composedTargetState", "getComposedTargetState$animation_core_release", "()Ljava/lang/Object;", "setComposedTargetState$animation_core_release", "Ljava/lang/Object;", "compositionContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "getCompositionContinuation$animation_core_release", "()Lkotlinx/coroutines/CancellableContinuation;", "setCompositionContinuation$animation_core_release", "(Lkotlinx/coroutines/CancellableContinuation;)V", "compositionContinuationMutex", "Lkotlinx/coroutines/sync/Mutex;", "getCompositionContinuationMutex$animation_core_release", "()Lkotlinx/coroutines/sync/Mutex;", "currentAnimation", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "<set-?>", "currentState", "getCurrentState", "setCurrentState$animation_core_release", "currentState$delegate", "Landroidx/compose/runtime/MutableState;", "durationScale", "", "firstFrameLambda", "fraction", "getFraction", "()F", "setFraction", "(F)V", "fraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "initialValueAnimations", "Landroidx/collection/MutableObjectList;", "lastFrameTimeNanos", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "recalculateTotalDurationNanos", "Lkotlin/Function0;", "targetState", "getTargetState", "setTargetState$animation_core_release", "targetState$delegate", "totalDurationNanos", "getTotalDurationNanos$animation_core_release", "()J", "setTotalDurationNanos$animation_core_release", "(J)V", "transition", "Landroidx/compose/animation/core/Transition;", "animateOneFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doOneFrame", "endAllAnimations", "moveAnimationToInitialState", "observeTotalDuration", "observeTotalDuration$animation_core_release", "onTotalDurationChanged", "onTotalDurationChanged$animation_core_release", "recalculateAnimationValue", "animation", "deltaPlayTimeNanos", "runAnimations", "seekTo", "(FLjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seekToFraction", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transitionConfigured", "transitionConfigured$animation_core_release", "transitionRemoved", "transitionRemoved$animation_core_release", "waitForComposition", "waitForCompositionAfterTargetStateChange", "Companion", "SeekingAnimationState", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SeekableTransitionState<S>  extends androidx.compose.animation.core.TransitionState<S> {

    public static final int $stable = 8;
    private static final androidx.compose.animation.core.SeekableTransitionState.Companion Companion;
    private static final androidx.compose.animation.core.AnimationVector1D Target1;
    private static final androidx.compose.animation.core.AnimationVector1D ZeroVelocity;
    private final Function1<Long, Unit> animateOneFrameLambda;
    private S composedTargetState;
    private CancellableContinuation<? super S> compositionContinuation;
    private final Mutex compositionContinuationMutex;
    private androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState currentAnimation;
    private final MutableState currentState$delegate;
    private float durationScale;
    private final Function1<Long, Unit> firstFrameLambda;
    private final MutableFloatState fraction$delegate;
    private final MutableObjectList<androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState> initialValueAnimations;
    private long lastFrameTimeNanos = Long.MIN_VALUE;
    private final androidx.compose.animation.core.MutatorMutex mutatorMutex;
    private final Function0<Unit> recalculateTotalDurationNanos;
    private final MutableState targetState$delegate;
    private long totalDurationNanos;
    private androidx.compose.animation.core.Transition<S> transition;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006¨\u0006\t", d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$Companion;", "", "()V", "Target1", "Landroidx/compose/animation/core/AnimationVector1D;", "getTarget1", "()Landroidx/compose/animation/core/AnimationVector1D;", "ZeroVelocity", "getZeroVelocity", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.animation.core.AnimationVector1D getTarget1() {
            return SeekableTransitionState.access$getTarget1$cp();
        }

        public final androidx.compose.animation.core.AnimationVector1D getZeroVelocity() {
            return SeekableTransitionState.access$getZeroVelocity$cp();
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010)\u001a\u00020*H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\r\"\u0004\u0008\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\r\"\u0004\u0008\u001f\u0010\u000fR\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\u0015\"\u0004\u0008\"\u0010\u0017R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010&\"\u0004\u0008'\u0010(¨\u0006+", d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "", "()V", "animationSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;)V", "animationSpecDuration", "", "getAnimationSpecDuration", "()J", "setAnimationSpecDuration", "(J)V", "durationNanos", "getDurationNanos", "setDurationNanos", "initialVelocity", "getInitialVelocity", "()Landroidx/compose/animation/core/AnimationVector1D;", "setInitialVelocity", "(Landroidx/compose/animation/core/AnimationVector1D;)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "progressNanos", "getProgressNanos", "setProgressNanos", "start", "getStart", "setStart", "value", "", "getValue", "()F", "setValue", "(F)V", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SeekingAnimationState {

        public static final int $stable = 8;
        private androidx.compose.animation.core.VectorizedAnimationSpec<androidx.compose.animation.core.AnimationVector1D> animationSpec;
        private long animationSpecDuration;
        private long durationNanos;
        private androidx.compose.animation.core.AnimationVector1D initialVelocity;
        private boolean isComplete;
        private long progressNanos;
        private androidx.compose.animation.core.AnimationVector1D start;
        private float value;
        static {
            final int i = 8;
        }

        public SeekingAnimationState() {
            super();
            AnimationVector1D animationVector1D = new AnimationVector1D(0);
            this.start = animationVector1D;
        }

        public final androidx.compose.animation.core.VectorizedAnimationSpec<androidx.compose.animation.core.AnimationVector1D> getAnimationSpec() {
            return this.animationSpec;
        }

        public final long getAnimationSpecDuration() {
            return this.animationSpecDuration;
        }

        public final long getDurationNanos() {
            return this.durationNanos;
        }

        public final androidx.compose.animation.core.AnimationVector1D getInitialVelocity() {
            return this.initialVelocity;
        }

        public final long getProgressNanos() {
            return this.progressNanos;
        }

        public final androidx.compose.animation.core.AnimationVector1D getStart() {
            return this.start;
        }

        public final float getValue() {
            return this.value;
        }

        public final boolean isComplete() {
            return this.isComplete;
        }

        public final void setAnimationSpec(androidx.compose.animation.core.VectorizedAnimationSpec<androidx.compose.animation.core.AnimationVector1D> <set-?>) {
            this.animationSpec = <set-?>;
        }

        public final void setAnimationSpecDuration(long <set-?>) {
            this.animationSpecDuration = <set-?>;
        }

        public final void setComplete(boolean <set-?>) {
            this.isComplete = <set-?>;
        }

        public final void setDurationNanos(long <set-?>) {
            this.durationNanos = <set-?>;
        }

        public final void setInitialVelocity(androidx.compose.animation.core.AnimationVector1D <set-?>) {
            this.initialVelocity = <set-?>;
        }

        public final void setProgressNanos(long <set-?>) {
            this.progressNanos = <set-?>;
        }

        public final void setStart(androidx.compose.animation.core.AnimationVector1D <set-?>) {
            this.start = <set-?>;
        }

        public final void setValue(float <set-?>) {
            this.value = <set-?>;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("progress nanos: ").append(this.progressNanos).append(", animationSpec: ").append(this.animationSpec).append(", isComplete: ").append(this.isComplete).append(", value: ").append(this.value).append(", start: ").append(this.start).append(", initialVelocity: ").append(this.initialVelocity).append(", durationNanos: ").append(this.durationNanos).append(", animationSpecDuration: ").append(this.animationSpecDuration).toString();
        }
    }
    static {
        SeekableTransitionState.Companion companion = new SeekableTransitionState.Companion(0);
        SeekableTransitionState.Companion = companion;
        int i = 8;
        AnimationVector1D animationVector1D = new AnimationVector1D(0);
        SeekableTransitionState.ZeroVelocity = animationVector1D;
        AnimationVector1D animationVector1D2 = new AnimationVector1D(1065353216);
        SeekableTransitionState.Target1 = animationVector1D2;
    }

    public SeekableTransitionState(S initialState) {
        int i = 0;
        super(i);
        int i2 = 2;
        this.targetState$delegate = SnapshotStateKt.mutableStateOf$default(initialState, i, i2, i);
        this.currentState$delegate = SnapshotStateKt.mutableStateOf$default(initialState, i, i2, i);
        this.composedTargetState = initialState;
        SeekableTransitionState.recalculateTotalDurationNanos.1 anon3 = new SeekableTransitionState.recalculateTotalDurationNanos.1(this);
        this.recalculateTotalDurationNanos = (Function0)anon3;
        this.fraction$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0);
        int i4 = 0;
        int i5 = 1;
        this.compositionContinuationMutex = MutexKt.Mutex$default(i4, i5, i);
        MutatorMutex mutatorMutex = new MutatorMutex();
        this.mutatorMutex = mutatorMutex;
        long l = Long.MIN_VALUE;
        MutableObjectList mutableObjectList = new MutableObjectList(i4, i5, i);
        this.initialValueAnimations = mutableObjectList;
        SeekableTransitionState.firstFrameLambda.1 anon = new SeekableTransitionState.firstFrameLambda.1(this);
        this.firstFrameLambda = (Function1)anon;
        SeekableTransitionState.animateOneFrameLambda.1 anon2 = new SeekableTransitionState.animateOneFrameLambda.1(this);
        this.animateOneFrameLambda = (Function1)anon2;
    }

    public static final Object access$animateOneFrame(androidx.compose.animation.core.SeekableTransitionState $this, Continuation $completion) {
        return $this.animateOneFrame($completion);
    }

    public static final Object access$doOneFrame(androidx.compose.animation.core.SeekableTransitionState $this, Continuation $completion) {
        return $this.doOneFrame($completion);
    }

    public static final void access$endAllAnimations(androidx.compose.animation.core.SeekableTransitionState $this) {
        $this.endAllAnimations();
    }

    public static final androidx.compose.animation.core.SeekableTransitionState.Companion access$getCompanion$p() {
        return SeekableTransitionState.Companion;
    }

    public static final androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState access$getCurrentAnimation$p(androidx.compose.animation.core.SeekableTransitionState $this) {
        return $this.currentAnimation;
    }

    public static final float access$getDurationScale$p(androidx.compose.animation.core.SeekableTransitionState $this) {
        return $this.durationScale;
    }

    public static final MutableObjectList access$getInitialValueAnimations$p(androidx.compose.animation.core.SeekableTransitionState $this) {
        return $this.initialValueAnimations;
    }

    public static final long access$getLastFrameTimeNanos$p(androidx.compose.animation.core.SeekableTransitionState $this) {
        return $this.lastFrameTimeNanos;
    }

    public static final androidx.compose.animation.core.AnimationVector1D access$getTarget1$cp() {
        return SeekableTransitionState.Target1;
    }

    public static final androidx.compose.animation.core.Transition access$getTransition$p(androidx.compose.animation.core.SeekableTransitionState $this) {
        return $this.transition;
    }

    public static final androidx.compose.animation.core.AnimationVector1D access$getZeroVelocity$cp() {
        return SeekableTransitionState.ZeroVelocity;
    }

    public static final void access$moveAnimationToInitialState(androidx.compose.animation.core.SeekableTransitionState $this) {
        $this.moveAnimationToInitialState();
    }

    public static final void access$recalculateAnimationValue(androidx.compose.animation.core.SeekableTransitionState $this, androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState animation, long deltaPlayTimeNanos) {
        $this.recalculateAnimationValue(animation, deltaPlayTimeNanos);
    }

    public static final Object access$runAnimations(androidx.compose.animation.core.SeekableTransitionState $this, Continuation $completion) {
        return $this.runAnimations($completion);
    }

    public static final void access$seekToFraction(androidx.compose.animation.core.SeekableTransitionState $this) {
        $this.seekToFraction();
    }

    public static final void access$setCurrentAnimation$p(androidx.compose.animation.core.SeekableTransitionState $this, androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState <set-?>) {
        $this.currentAnimation = <set-?>;
    }

    public static final void access$setFraction(androidx.compose.animation.core.SeekableTransitionState $this, float <set-?>) {
        $this.setFraction(<set-?>);
    }

    public static final void access$setLastFrameTimeNanos$p(androidx.compose.animation.core.SeekableTransitionState $this, long <set-?>) {
        $this.lastFrameTimeNanos = <set-?>;
    }

    public static final Object access$waitForComposition(androidx.compose.animation.core.SeekableTransitionState $this, Continuation $completion) {
        return $this.waitForComposition($completion);
    }

    public static final Object access$waitForCompositionAfterTargetStateChange(androidx.compose.animation.core.SeekableTransitionState $this, Continuation $completion) {
        return $this.waitForCompositionAfterTargetStateChange($completion);
    }

    private final Object animateOneFrame(Continuation<? super Unit> $completion) {
        float durationScale = SuspendAnimationKt.getDurationScale($completion.getContext());
        if (Float.compare(durationScale, i) <= 0) {
            endAllAnimations();
            return Unit.INSTANCE;
        }
        this.durationScale = durationScale;
        Object frameNanos = MonotonicFrameClockKt.withFrameNanos(this.animateOneFrameLambda, $completion);
        if (frameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return frameNanos;
        }
        return Unit.INSTANCE;
    }

    public static Object animateTo$default(androidx.compose.animation.core.SeekableTransitionState seekableTransitionState, Object object2, androidx.compose.animation.core.FiniteAnimationSpec finiteAnimationSpec3, Continuation continuation4, int i5, Object object6) {
        Object obj1;
        int obj2;
        if (i5 & 1 != 0) {
            obj1 = seekableTransitionState.getTargetState();
        }
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return seekableTransitionState.animateTo(obj1, obj2, continuation4);
    }

    private final Object doOneFrame(Continuation<? super Unit> $completion) {
        Unit iNSTANCE;
        Object cOROUTINE_SUSPENDED;
        if (Long.compare(lastFrameTimeNanos, l) == 0) {
            Object frameNanos = MonotonicFrameClockKt.withFrameNanos(this.firstFrameLambda, $completion);
            if (frameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return frameNanos;
            }
            iNSTANCE = Unit.INSTANCE;
        } else {
            Object animateOneFrame = animateOneFrame($completion);
            if (animateOneFrame == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return animateOneFrame;
            } else {
                iNSTANCE = Unit.INSTANCE;
            }
        }
        return iNSTANCE;
    }

    private final void endAllAnimations() {
        int i;
        androidx.compose.animation.core.Transition transition = this.transition;
        if (transition != null) {
            transition.clearInitialAnimations$animation_core_release();
        }
        this.initialValueAnimations.clear();
        if (this.currentAnimation != null) {
            this.currentAnimation = 0;
            setFraction(1065353216);
            seekToFraction();
        }
    }

    private final void moveAnimationToInitialState() {
        int equal;
        androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState seekingAnimationState;
        long initialValueAnimations;
        Object targetState;
        int i2;
        long totalDurationNanos;
        androidx.compose.animation.core.AnimationVector1D start;
        double fraction;
        double d;
        int i;
        final androidx.compose.animation.core.Transition transition = this.transition;
        if (transition == null) {
        }
        final int i3 = 0;
        if (this.currentAnimation == null) {
            if (Long.compare(initialValueAnimations, i2) > 0) {
                initialValueAnimations = 0;
                equal = Float.compare(fraction2, i4) == 0 ? 1 : initialValueAnimations;
                if (equal == 0) {
                    if (Intrinsics.areEqual(getCurrentState(), getTargetState())) {
                        seekingAnimationState = i3;
                    } else {
                        seekingAnimationState = new SeekableTransitionState.SeekingAnimationState();
                        targetState = seekingAnimationState;
                        i2 = 0;
                        targetState.setValue(getFraction());
                        totalDurationNanos = this.totalDurationNanos;
                        targetState.setDurationNanos(totalDurationNanos);
                        targetState.setAnimationSpecDuration(MathKt.roundToLong(d2 *= i));
                        targetState.getStart().set$animation_core_release(initialValueAnimations, getFraction());
                    }
                } else {
                }
            } else {
            }
        }
        if (seekingAnimationState != null) {
            seekingAnimationState.setDurationNanos(this.totalDurationNanos);
            targetState = 0;
            this.initialValueAnimations.add(seekingAnimationState);
            transition.setInitialAnimations$animation_core_release(seekingAnimationState);
        }
        this.currentAnimation = i3;
    }

    private final void recalculateAnimationValue(androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState animation, long deltaPlayTimeNanos) {
        androidx.compose.animation.core.VectorizedAnimationSpec animationSpec;
        float coerceIn;
        int i;
        androidx.compose.animation.core.AnimationVector1D initialVelocity;
        int i2;
        final int i3 = progressNanos + deltaPlayTimeNanos;
        animation.setProgressNanos(i3);
        long animationSpecDuration = animation.getAnimationSpecDuration();
        final int i4 = 1065353216;
        if (Long.compare(i3, animationSpecDuration) >= 0) {
            animation.setValue(i4);
        } else {
            animationSpec = animation.getAnimationSpec();
            i2 = 0;
            if (animationSpec != null) {
                if (animation.getInitialVelocity() == null) {
                    initialVelocity = SeekableTransitionState.ZeroVelocity;
                }
                animation.setValue(RangesKt.coerceIn((AnimationVector1D)animationSpec.getValueFromNanos(i3, obj4, (AnimationVector)animation.getStart(), (AnimationVector)SeekableTransitionState.Target1).get$animation_core_release(i2), 0, i4));
            } else {
                animation.setValue(VectorConvertersKt.lerp(animation.getStart().get$animation_core_release(i2), i4, f3 /= initialVelocity));
            }
        }
    }

    private final Object runAnimations(Continuation<? super Unit> continuation) {
        boolean anon;
        int i;
        int i3;
        Object _this;
        int animateOneFrame;
        boolean currentAnimation2;
        boolean currentAnimation;
        int i2;
        int i4;
        long lastFrameTimeNanos;
        Object obj10;
        anon = continuation;
        i3 = Integer.MIN_VALUE;
        if (continuation instanceof SeekableTransitionState.runAnimations.1 && label &= i3 != 0) {
            anon = continuation;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj10 -= i3;
            } else {
                anon = new SeekableTransitionState.runAnimations.1(this, continuation);
            }
        } else {
        }
        obj10 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final long l = Long.MIN_VALUE;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                _this = this;
                return Unit.INSTANCE;
                i4 = 1;
                i2 = i4;
                i2 = 0;
                _this.endAllAnimations();
                _this.lastFrameTimeNanos = l;
                return Unit.INSTANCE;
                anon.L$0 = _this;
                anon.label = i4;
                return cOROUTINE_SUSPENDED;
                _this.lastFrameTimeNanos = l;
                return Unit.INSTANCE;
                anon.L$0 = _this;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                break;
            case 1:
                _this = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                break;
            case 2:
                _this = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                _this.lastFrameTimeNanos = l;
                return Unit.INSTANCE;
                anon.L$0 = _this;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                break;
            default:
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
        }
    }

    public static Object seekTo$default(androidx.compose.animation.core.SeekableTransitionState seekableTransitionState, float f2, Object object3, Continuation continuation4, int i5, Object object6) {
        Object obj2;
        if (i5 &= 2 != 0) {
            obj2 = seekableTransitionState.getTargetState();
        }
        return seekableTransitionState.seekTo(f2, obj2, continuation4);
    }

    private final void seekToFraction() {
        final androidx.compose.animation.core.Transition transition = this.transition;
        if (transition == null) {
        }
        transition.seekAnimations$animation_core_release(MathKt.roundToLong(d *= d2));
    }

    private final void setFraction(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.fraction$delegate.setFloatValue(<set-?>);
    }

    private final Object waitForComposition(Continuation<? super Unit> continuation) {
        boolean anon2;
        int i2;
        int i3;
        int i5;
        Object expectedState;
        Object _this;
        Object cOROUTINE_SUSPENDED;
        Object expectedState2;
        Object lock$default;
        androidx.compose.animation.core.SeekableTransitionState.waitForComposition.1 anon;
        int i4;
        CancellableContinuationImpl cancellableContinuationImpl2;
        CancellableContinuationImpl cancellableContinuationImpl;
        int i;
        Mutex compositionContinuationMutex$animation_core_release;
        Object obj;
        Object obj15;
        anon2 = continuation;
        i5 = Integer.MIN_VALUE;
        if (continuation instanceof SeekableTransitionState.waitForComposition.1 && label &= i5 != 0) {
            anon2 = continuation;
            i5 = Integer.MIN_VALUE;
            if (label &= i5 != 0) {
                anon2.label = obj15 -= i5;
            } else {
                anon2 = new SeekableTransitionState.waitForComposition.1(this, continuation);
            }
        } else {
        }
        obj15 = anon2.result;
        Object cOROUTINE_SUSPENDED2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = 1;
        cOROUTINE_SUSPENDED = 0;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj15);
                androidx.compose.animation.core.SeekableTransitionState seekableTransitionState = this;
                Object targetState = seekableTransitionState.getTargetState();
                anon2.L$0 = seekableTransitionState;
                anon2.L$1 = targetState;
                anon2.label = i6;
                return cOROUTINE_SUSPENDED2;
                expectedState2 = seekableTransitionState;
                expectedState = obj;
                break;
            case 1:
                expectedState = anon2.L$1;
                expectedState2 = anon2.L$0;
                ResultKt.throwOnFailure(obj15);
                break;
            case 2:
                i3 = 0;
                expectedState = anon2.L$1;
                ResultKt.throwOnFailure(obj15);
                expectedState2 = l$0;
                _this = obj15;
                return Unit.INSTANCE;
                expectedState2.lastFrameTimeNanos = Long.MIN_VALUE;
                CancellationException cancellationException = new CancellationException("targetState while waiting for composition");
                throw cancellationException;
            default:
                obj15 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj15;
        }
        anon2.L$0 = expectedState2;
        anon2.L$1 = expectedState;
        anon2.label = 2;
        i4 = 0;
        cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)anon2), i6);
        cancellableContinuationImpl2.initCancellability();
        i = 0;
        expectedState2.setCompositionContinuation$animation_core_release((CancellableContinuation)cancellableContinuationImpl2);
        Mutex.DefaultImpls.unlock$default(expectedState2.getCompositionContinuationMutex$animation_core_release(), cOROUTINE_SUSPENDED, i6, cOROUTINE_SUSPENDED);
        _this = cancellableContinuationImpl2.getResult();
        if (_this == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended((Continuation)anon2);
        }
        if (_this == cOROUTINE_SUSPENDED2) {
            return cOROUTINE_SUSPENDED2;
        }
        i3 = lock$default;
    }

    private final Object waitForCompositionAfterTargetStateChange(Continuation<? super Unit> continuation) {
        boolean anon;
        int i5;
        int i2;
        Mutex compositionContinuationMutex;
        int i3;
        Object expectedState2;
        Object _this;
        Object cOROUTINE_SUSPENDED;
        Object expectedState;
        Object lock$default;
        androidx.compose.animation.core.SeekableTransitionState.waitForCompositionAfterTargetStateChange.1 anon2;
        int i4;
        CancellableContinuationImpl cancellableContinuationImpl;
        CancellableContinuationImpl cancellableContinuationImpl2;
        int i;
        Mutex compositionContinuationMutex$animation_core_release;
        Object obj;
        Object obj15;
        anon = continuation;
        i3 = Integer.MIN_VALUE;
        if (continuation instanceof SeekableTransitionState.waitForCompositionAfterTargetStateChange.1 && label &= i3 != 0) {
            anon = continuation;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj15 -= i3;
            } else {
                anon = new SeekableTransitionState.waitForCompositionAfterTargetStateChange.1(this, continuation);
            }
        } else {
        }
        obj15 = anon.result;
        Object cOROUTINE_SUSPENDED2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        _this = 1;
        cOROUTINE_SUSPENDED = 0;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj15);
                androidx.compose.animation.core.SeekableTransitionState seekableTransitionState = this;
                Object targetState = seekableTransitionState.getTargetState();
                anon.L$0 = seekableTransitionState;
                anon.L$1 = targetState;
                anon.label = _this;
                return cOROUTINE_SUSPENDED2;
                expectedState = seekableTransitionState;
                expectedState2 = obj;
                break;
            case 1:
                expectedState2 = anon.L$1;
                expectedState = anon.L$0;
                ResultKt.throwOnFailure(obj15);
                break;
            case 2:
                i2 = 0;
                expectedState2 = anon.L$1;
                ResultKt.throwOnFailure(obj15);
                expectedState = l$0;
                _this = obj15;
                return Unit.INSTANCE;
                expectedState.lastFrameTimeNanos = Long.MIN_VALUE;
                StringBuilder stringBuilder = new StringBuilder();
                CancellationException cancellationException = new CancellationException(stringBuilder.append("snapTo() was canceled because state was changed to ").append(_this).append(" instead of ").append(expectedState2).toString());
                throw cancellationException;
            default:
                obj15 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj15;
        }
        if (Intrinsics.areEqual(expectedState2, expectedState.composedTargetState)) {
            Mutex.DefaultImpls.unlock$default(expectedState.compositionContinuationMutex, cOROUTINE_SUSPENDED, _this, cOROUTINE_SUSPENDED);
        } else {
            anon.L$0 = expectedState;
            anon.L$1 = expectedState2;
            anon.label = 2;
            i4 = 0;
            cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)anon), _this);
            cancellableContinuationImpl.initCancellability();
            i = 0;
            expectedState.setCompositionContinuation$animation_core_release((CancellableContinuation)cancellableContinuationImpl);
            Mutex.DefaultImpls.unlock$default(expectedState.getCompositionContinuationMutex$animation_core_release(), cOROUTINE_SUSPENDED, _this, cOROUTINE_SUSPENDED);
            _this = cancellableContinuationImpl.getResult();
            if (_this == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended((Continuation)anon);
            }
            if (_this == cOROUTINE_SUSPENDED2) {
                return cOROUTINE_SUSPENDED2;
            }
            i2 = lock$default;
        }
    }

    public final Object animateTo(S targetState, androidx.compose.animation.core.FiniteAnimationSpec<Float> animationSpec, Continuation<? super Unit> $completion) {
        androidx.compose.animation.core.Transition transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        SeekableTransitionState.animateTo.2 anon = new SeekableTransitionState.animateTo.2(transition, this, targetState, animationSpec, 0);
        Object obj12 = MutatorMutex.mutate$default(this.mutatorMutex, 0, (Function1)anon, $completion, 1, 0);
        if (obj12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj12;
        }
        return Unit.INSTANCE;
    }

    public final S getComposedTargetState$animation_core_release() {
        return this.composedTargetState;
    }

    public final CancellableContinuation<S> getCompositionContinuation$animation_core_release() {
        return this.compositionContinuation;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public final Mutex getCompositionContinuationMutex$animation_core_release() {
        return this.compositionContinuationMutex;
    }

    public S getCurrentState() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.currentState$delegate.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public final float getFraction() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.fraction$delegate.getFloatValue();
    }

    public S getTargetState() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.targetState$delegate.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public final long getTotalDurationNanos$animation_core_release() {
        return this.totalDurationNanos;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public final void observeTotalDuration$animation_core_release() {
        TransitionKt.getSeekableStateObserver().observeReads(this, TransitionKt.access$getSeekableTransitionStateTotalDurationChanged$p(), this.recalculateTotalDurationNanos);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public final void onTotalDurationChanged$animation_core_release() {
        int currentAnimation;
        androidx.compose.animation.core.VectorizedAnimationSpec animationSpec;
        int i;
        int i2;
        observeTotalDuration$animation_core_release();
        if (Long.compare(totalDurationNanos, totalDurationNanos2) != 0) {
            currentAnimation = this.currentAnimation;
            if (currentAnimation != null) {
                currentAnimation.setDurationNanos(this.totalDurationNanos);
                if (currentAnimation.getAnimationSpec() == null) {
                    i = 0;
                    currentAnimation.setAnimationSpecDuration(MathKt.roundToLong(i3 *= d2));
                }
            } else {
                seekToFraction();
            }
        }
    }

    public final Object seekTo(float fraction, S targetState, Continuation<? super Unit> $completion) {
        int cmp;
        int i;
        String $i$a$RequirePreconditionSeekableTransitionState$seekTo$2;
        StringBuilder append;
        String str;
        i = 0;
        if (Float.compare(i2, fraction) <= 0 && Float.compare(fraction, i4) <= 0) {
            if (Float.compare(fraction, i4) <= 0) {
                i = 1;
            }
        }
        int i3 = 0;
        if (i == 0) {
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            PreconditionsKt.throwIllegalArgumentException(stringBuilder.append("Expecting fraction between 0 and 1. Got ").append(fraction).toString());
        }
        androidx.compose.animation.core.Transition $i$f$requirePrecondition = this.transition;
        if ($i$f$requirePrecondition == null) {
            return Unit.INSTANCE;
        }
        final int i7 = 0;
        SeekableTransitionState.seekTo.3 anon = new SeekableTransitionState.seekTo.3(targetState, getTargetState(), this, $i$f$requirePrecondition, fraction, i7);
        Object obj14 = MutatorMutex.mutate$default(this.mutatorMutex, i7, (Function1)anon, $completion, 1, 0);
        if (obj14 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj14;
        }
        return Unit.INSTANCE;
    }

    public final void setComposedTargetState$animation_core_release(S <set-?>) {
        this.composedTargetState = <set-?>;
    }

    public final void setCompositionContinuation$animation_core_release(CancellableContinuation<? super S> <set-?>) {
        this.compositionContinuation = <set-?>;
    }

    public void setCurrentState$animation_core_release(S <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.currentState$delegate.setValue(<set-?>);
    }

    public void setTargetState$animation_core_release(S <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.targetState$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public final void setTotalDurationNanos$animation_core_release(long <set-?>) {
        this.totalDurationNanos = <set-?>;
    }

    public final Object snapTo(S targetState, Continuation<? super Unit> $completion) {
        boolean equal;
        androidx.compose.animation.core.Transition transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(getCurrentState(), targetState) && Intrinsics.areEqual(getTargetState(), targetState)) {
            if (Intrinsics.areEqual(getTargetState(), targetState)) {
                return Unit.INSTANCE;
            }
        }
        final int i = 0;
        SeekableTransitionState.snapTo.2 anon = new SeekableTransitionState.snapTo.2(this, targetState, transition, i);
        Object obj10 = MutatorMutex.mutate$default(this.mutatorMutex, i, (Function1)anon, $completion, 1, 0);
        if (obj10 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj10;
        }
        return Unit.INSTANCE;
    }

    public void transitionConfigured$animation_core_release(androidx.compose.animation.core.Transition<S> transition) {
        int i;
        androidx.compose.animation.core.Transition transition2;
        String $i$a$CheckPreconditionSeekableTransitionState$transitionConfigured$1;
        StringBuilder append;
        String str;
        if (this.transition != null) {
            if (Intrinsics.areEqual(transition, this.transition)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        final int i2 = 0;
        if (i == 0) {
            int i3 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder.append("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: ").append(this.transition).append(", new instance: ").append(transition).toString());
        }
        this.transition = transition;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionRemoved$animation_core_release() {
        this.transition = 0;
        TransitionKt.getSeekableStateObserver().clear(this);
    }
}
