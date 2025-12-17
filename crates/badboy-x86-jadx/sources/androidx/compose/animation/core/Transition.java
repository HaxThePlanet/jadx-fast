package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.LongState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010 \n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008 \n\u0002\u0010\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0008\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001B!\u0008\u0011\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u0019\u0008\u0010\u0012\u0006\u0010\u0008\u001a\u00028\u0000\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tB!\u0008\u0011\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bB/\u0008\u0000\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0000\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ'\u0010S\u001a\u00020#2\u0018\u0010T\u001a\u0014\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0010R\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\u0008UJ\u0019\u0010V\u001a\u00020#2\n\u0010W\u001a\u0006\u0012\u0002\u0008\u00030\u0000H\u0000¢\u0006\u0002\u0008XJ\u0017\u0010Y\u001a\u00020Z2\u0006\u0010D\u001a\u00028\u0000H\u0001¢\u0006\u0004\u0008[\u0010\\J\u0008\u0010]\u001a\u00020\u0012H\u0002J\r\u0010^\u001a\u00020ZH\u0000¢\u0006\u0002\u0008_J\u0008\u0010`\u001a\u00020ZH\u0002J\r\u0010a\u001a\u00020ZH\u0000¢\u0006\u0002\u0008bJ\u001d\u0010c\u001a\u00020Z2\u0006\u0010d\u001a\u00020\u00122\u0006\u0010e\u001a\u00020#H\u0000¢\u0006\u0002\u0008fJ\u001d\u0010c\u001a\u00020Z2\u0006\u0010g\u001a\u00020\u00122\u0006\u0010h\u001a\u00020iH\u0000¢\u0006\u0002\u0008fJ\r\u0010j\u001a\u00020ZH\u0000¢\u0006\u0002\u0008kJ\u0015\u0010l\u001a\u00020Z2\u0006\u0010g\u001a\u00020\u0012H\u0000¢\u0006\u0002\u0008mJ'\u0010n\u001a\u00020Z2\u0018\u0010o\u001a\u0014\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030pR\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\u0008qJ'\u0010n\u001a\u00020Z2\u0018\u0010T\u001a\u0014\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0010R\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\u0008qJ\u0019\u0010r\u001a\u00020#2\n\u0010W\u001a\u0006\u0012\u0002\u0008\u00030\u0000H\u0000¢\u0006\u0002\u0008sJ\u0015\u0010t\u001a\u00020Z2\u0006\u0010u\u001a\u00020iH\u0000¢\u0006\u0002\u0008vJ\u0008\u0010w\u001a\u00020ZH\u0002J\u0015\u0010x\u001a\u00020Z2\u0006\u00106\u001a\u00020\u0012H\u0000¢\u0006\u0002\u0008yJ\u0015\u0010z\u001a\u00020Z2\u0006\u0010{\u001a\u00020|H\u0000¢\u0006\u0002\u0008}J(\u0010~\u001a\u00020Z2\u0006\u0010\u0008\u001a\u00028\u00002\u0006\u0010D\u001a\u00028\u00002\u0006\u00106\u001a\u00020\u0012H\u0007¢\u0006\u0005\u0008\u007f\u0010\u0080\u0001J\t\u0010\u0081\u0001\u001a\u00020\u0006H\u0016J\u000f\u0010\u0082\u0001\u001a\u00020ZH\u0000¢\u0006\u0003\u0008\u0083\u0001J\u0019\u0010\u0084\u0001\u001a\u00020Z2\u0006\u0010D\u001a\u00028\u0000H\u0000¢\u0006\u0005\u0008\u0085\u0001\u0010GR&\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0010R\u0008\u0012\u0004\u0012\u00028\u00000\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0018\u0010\u0019\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u001b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0010R\u0008\u0012\u0004\u0012\u00028\u00000\u00000\u001c8F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\u0008 \u0010!R\u001a\u0010\"\u001a\u00020#8GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008$\u0010%\u001a\u0004\u0008&\u0010'R\u0011\u0010(\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\u0008(\u0010'R+\u0010)\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020#8G@AX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008,\u0010-\u001a\u0004\u0008)\u0010'\"\u0004\u0008*\u0010+R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u001a\u00100\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u0010\u0015\"\u0004\u00082\u0010\u0017R\u0019\u0010\u000c\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00008\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u00104R$\u00106\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\u000c\u001a\u0004\u00087\u0010\u0015\"\u0004\u00088\u0010\u0017R7\u0010:\u001a\u0008\u0012\u0004\u0012\u00028\u0000092\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u0000098F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008?\u0010-\u001a\u0004\u0008;\u0010<\"\u0004\u0008=\u0010>R+\u0010@\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008C\u0010\u0019\u001a\u0004\u0008A\u0010\u0015\"\u0004\u0008B\u0010\u0017R+\u0010D\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00008F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008H\u0010-\u001a\u0004\u0008E\u0010!\"\u0004\u0008F\u0010GR\u001b\u0010I\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008K\u0010L\u001a\u0004\u0008J\u0010\u0015R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010M\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00000\u001c8F¢\u0006\u0006\u001a\u0004\u0008N\u0010\u001eR+\u0010O\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020#8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008R\u0010-\u001a\u0004\u0008P\u0010'\"\u0004\u0008Q\u0010+¨\u0006\u008a\u0001", d2 = {"Landroidx/compose/animation/core/Transition;", "S", "", "transitionState", "Landroidx/compose/animation/core/TransitionState;", "label", "", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;)V", "initialState", "(Ljava/lang/Object;Ljava/lang/String;)V", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;)V", "parentTransition", "(Landroidx/compose/animation/core/TransitionState;Landroidx/compose/animation/core/Transition;Ljava/lang/String;)V", "_animations", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "<set-?>", "", "_playTimeNanos", "get_playTimeNanos", "()J", "set_playTimeNanos", "(J)V", "_playTimeNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "_transitions", "animations", "", "getAnimations", "()Ljava/util/List;", "currentState", "getCurrentState", "()Ljava/lang/Object;", "hasInitialValueAnimations", "", "getHasInitialValueAnimations$annotations", "()V", "getHasInitialValueAnimations", "()Z", "isRunning", "isSeeking", "setSeeking$animation_core_release", "(Z)V", "isSeeking$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "lastSeekedTimeNanos", "getLastSeekedTimeNanos$animation_core_release", "setLastSeekedTimeNanos$animation_core_release", "getParentTransition", "()Landroidx/compose/animation/core/Transition;", "value", "playTimeNanos", "getPlayTimeNanos", "setPlayTimeNanos", "Landroidx/compose/animation/core/Transition$Segment;", "segment", "getSegment", "()Landroidx/compose/animation/core/Transition$Segment;", "setSegment", "(Landroidx/compose/animation/core/Transition$Segment;)V", "segment$delegate", "startTimeNanos", "getStartTimeNanos$animation_core_release", "setStartTimeNanos$animation_core_release", "startTimeNanos$delegate", "targetState", "getTargetState", "setTargetState$animation_core_release", "(Ljava/lang/Object;)V", "targetState$delegate", "totalDurationNanos", "getTotalDurationNanos", "totalDurationNanos$delegate", "Landroidx/compose/runtime/State;", "transitions", "getTransitions", "updateChildrenNeeded", "getUpdateChildrenNeeded", "setUpdateChildrenNeeded", "updateChildrenNeeded$delegate", "addAnimation", "animation", "addAnimation$animation_core_release", "addTransition", "transition", "addTransition$animation_core_release", "animateTo", "", "animateTo$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "calculateTotalDurationNanos", "clearInitialAnimations", "clearInitialAnimations$animation_core_release", "onChildAnimationUpdated", "onDisposed", "onDisposed$animation_core_release", "onFrame", "scaledPlayTimeNanos", "scaleToEnd", "onFrame$animation_core_release", "frameTimeNanos", "durationScale", "", "onTransitionEnd", "onTransitionEnd$animation_core_release", "onTransitionStart", "onTransitionStart$animation_core_release", "removeAnimation", "deferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "removeAnimation$animation_core_release", "removeTransition", "removeTransition$animation_core_release", "resetAnimationFraction", "fraction", "resetAnimationFraction$animation_core_release", "resetAnimations", "seekAnimations", "seekAnimations$animation_core_release", "setInitialAnimations", "animationState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialAnimations$animation_core_release", "setPlaytimeAfterInitialAndTargetStateEstablished", "seek", "(Ljava/lang/Object;Ljava/lang/Object;J)V", "toString", "updateInitialValues", "updateInitialValues$animation_core_release", "updateTarget", "updateTarget$animation_core_release", "DeferredAnimation", "Segment", "SegmentImpl", "TransitionAnimationState", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Transition<S>  {

    public static final int $stable;
    private final SnapshotStateList<androidx.compose.animation.core.Transition.TransitionAnimationState<S, ?, ?>> _animations;
    private final MutableLongState _playTimeNanos$delegate;
    private final SnapshotStateList<androidx.compose.animation.core.Transition<?>> _transitions;
    private final MutableState isSeeking$delegate;
    private final String label;
    private long lastSeekedTimeNanos;
    private final androidx.compose.animation.core.Transition<?> parentTransition;
    private final MutableState segment$delegate;
    private final MutableLongState startTimeNanos$delegate;
    private final MutableState targetState$delegate;
    private final State totalDurationNanos$delegate;
    private final androidx.compose.animation.core.TransitionState<S> transitionState;
    private final MutableState updateChildrenNeeded$delegate;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008f\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u00020\u0002J\u001a\u0010\u0008\u001a\u00020\t*\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0001H\u0096\u0004¢\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0003", d2 = {"Landroidx/compose/animation/core/Transition$Segment;", "S", "", "initialState", "getInitialState", "()Ljava/lang/Object;", "targetState", "getTargetState", "isTransitioningTo", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Segment {
        public static boolean access$isTransitioningTo$jd(androidx.compose.animation.core.Transition.Segment $this, Object $receiver, Object targetState) {
            return super.isTransitioningTo($receiver, targetState);
        }

        public abstract S getInitialState();

        public abstract S getTargetState();

        public boolean isTransitioningTo(S $this$isTransitioningTo, S targetState) {
            boolean equal;
            int i;
            if (Intrinsics.areEqual($this$isTransitioningTo, getInitialState()) && Intrinsics.areEqual(targetState, getTargetState())) {
                i = Intrinsics.areEqual(targetState, getTargetState()) ? 1 : 0;
            } else {
            }
            return i;
        }
    }

    @Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0087\u0004\u0018\u0000*\u0004\u0008\u0001\u0010\u0001*\u0008\u0008\u0002\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001&B#\u0008\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJT\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00192#\u0010\u001a\u001a\u001f\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u001c\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00010\u001d0\u001b¢\u0006\u0002\u0008\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008 \u0012\u0008\u0008!\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u00028\u00010\u001bJ\r\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\u0008%R{\u0010\r\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000bR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\u0008\u0012\u0004\u0012\u00028\u00000\u000c2.\u0010\n\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000bR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\u0008\u0012\u0004\u0012\u00028\u00000\u000c8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017¨\u0006'", d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "Landroidx/compose/animation/core/Transition;", "data", "getData$animation_core_release", "()Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "setData$animation_core_release", "(Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;)V", "data$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "animate", "Landroidx/compose/runtime/State;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "setupSeeking", "", "setupSeeking$animation_core_release", "DeferredAnimationData", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class DeferredAnimation {

        private final MutableState data$delegate;
        private final String label;
        final androidx.compose.animation.core.Transition<S> this$0;
        private final androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter;
        public DeferredAnimation(androidx.compose.animation.core.Transition this$0, androidx.compose.animation.core.TwoWayConverter typeConverter, String label) {
            this.this$0 = this$0;
            super();
            this.typeConverter = typeConverter;
            this.label = label;
            int i = 0;
            this.data$delegate = SnapshotStateKt.mutableStateOf$default(i, i, 2, i);
        }

        public final State<T> animate(Function1<? super androidx.compose.animation.core.Transition.Segment<S>, ? extends androidx.compose.animation.core.FiniteAnimationSpec<T>> transitionSpec, Function1<? super S, ? extends T> targetValueByState) {
            androidx.compose.animation.core.Transition.DeferredAnimation.DeferredAnimationData deferredAnimationData;
            androidx.compose.animation.core.Transition this$0;
            androidx.compose.animation.core.Transition.DeferredAnimation.DeferredAnimationData deferredAnimationData2;
            int i;
            androidx.compose.animation.core.Transition.TransitionAnimationState animation;
            androidx.compose.animation.core.TwoWayConverter typeConverter;
            String label;
            if (getData$animation_core_release() == null) {
                Transition.TransitionAnimationState transitionAnimationState = new Transition.TransitionAnimationState(this.this$0, targetValueByState.invoke(this.this$0.getCurrentState()), AnimationStateKt.createZeroVectorFrom(this.typeConverter, targetValueByState.invoke(this.this$0.getCurrentState())), this.typeConverter, this.label);
                deferredAnimationData = new Transition.DeferredAnimation.DeferredAnimationData(this, transitionAnimationState, transitionSpec, targetValueByState);
                deferredAnimationData2 = deferredAnimationData;
                i = 0;
                setData$animation_core_release(deferredAnimationData2);
                this.this$0.addAnimation$animation_core_release(deferredAnimationData2.getAnimation());
            }
            androidx.compose.animation.core.Transition.DeferredAnimation.DeferredAnimationData deferredAnimationData4 = deferredAnimationData;
            int i2 = 0;
            deferredAnimationData4.setTargetValueByState(targetValueByState);
            deferredAnimationData4.setTransitionSpec(transitionSpec);
            deferredAnimationData4.updateAnimationStates(this.this$0.getSegment());
            return (State)deferredAnimationData;
        }

        public final androidx.compose.animation.core.Transition.DeferredAnimation.DeferredAnimationData<S, T, V, T, V> getData$animation_core_release() {
            final int i = 0;
            final int i2 = 0;
            return (Transition.DeferredAnimation.DeferredAnimationData)(State)this.data$delegate.getValue();
        }

        public final String getLabel() {
            return this.label;
        }

        public final androidx.compose.animation.core.TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final void setData$animation_core_release(androidx.compose.animation.core.Transition.DeferredAnimation.DeferredAnimationData<S, T, V, T, V> <set-?>) {
            final int i = 0;
            final int i2 = 0;
            this.data$delegate.setValue(<set-?>);
        }

        public final void setupSeeking$animation_core_release() {
            Object invoke;
            int i;
            androidx.compose.animation.core.Transition.TransitionAnimationState animation;
            Object invoke2;
            Object invoke3;
            Function1 transitionSpec;
            final androidx.compose.animation.core.Transition.DeferredAnimation.DeferredAnimationData data$animation_core_release = getData$animation_core_release();
            if (data$animation_core_release != null) {
                androidx.compose.animation.core.Transition this$0 = this.this$0;
                i = 0;
                data$animation_core_release.getAnimation().updateInitialAndTargetValue$animation_core_release(data$animation_core_release.getTargetValueByState().invoke(this$0.getSegment().getInitialState()), data$animation_core_release.getTargetValueByState().invoke(this$0.getSegment().getTargetState()), (FiniteAnimationSpec)data$animation_core_release.getTransitionSpec().invoke(this$0.getSegment()));
            }
        }
    }

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0096\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0003\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\t\u0010\u0007¨\u0006\u0010", d2 = {"Landroidx/compose/animation/core/Transition$SegmentImpl;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "initialState", "targetState", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getInitialState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTargetState", "equals", "", "other", "", "hashCode", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SegmentImpl implements androidx.compose.animation.core.Transition.Segment<S> {

        private final S initialState;
        private final S targetState;
        public SegmentImpl(S initialState, S targetState) {
            super();
            this.initialState = initialState;
            this.targetState = targetState;
        }

        @Override // androidx.compose.animation.core.Transition$Segment
        public boolean equals(Object other) {
            int i;
            boolean equal;
            Object initialState;
            if (other instanceof Transition.Segment && Intrinsics.areEqual(getInitialState(), (Transition.Segment)other.getInitialState()) && Intrinsics.areEqual(getTargetState(), (Transition.Segment)other.getTargetState())) {
                if (Intrinsics.areEqual(getInitialState(), (Transition.Segment)other.getInitialState())) {
                    i = Intrinsics.areEqual(getTargetState(), (Transition.Segment)other.getTargetState()) ? 1 : 0;
                } else {
                }
            } else {
            }
            return i;
        }

        public S getInitialState() {
            return this.initialState;
        }

        public S getTargetState() {
            return this.targetState;
        }

        @Override // androidx.compose.animation.core.Transition$Segment
        public int hashCode() {
            int i2;
            int i;
            Object initialState = getInitialState();
            if (initialState != null) {
                i2 = initialState.hashCode();
            } else {
                i2 = i;
            }
            final Object targetState = getTargetState();
            if (targetState != null) {
                i = targetState.hashCode();
            }
            return i3 += i;
        }
    }

    @Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0007\n\u0002\u0008\u0017\n\u0002\u0010\u0002\n\u0002\u0008\u001c\u0008\u0087\u0004\u0018\u0000*\u0004\u0008\u0001\u0010\u0001*\u0008\u0008\u0002\u0010\u0002*\u00020\u00032\u0008\u0012\u0004\u0012\u0002H\u00010\u0004B3\u0008\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\r\u0010O\u001a\u00020PH\u0000¢\u0006\u0002\u0008QJ\u001d\u0010R\u001a\u00020P2\u0006\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020.H\u0000¢\u0006\u0002\u0008UJ\r\u0010V\u001a\u00020PH\u0000¢\u0006\u0002\u0008WJ\u0015\u0010X\u001a\u00020P2\u0006\u0010Y\u001a\u000208H\u0000¢\u0006\u0002\u0008ZJ\u0015\u0010[\u001a\u00020P2\u0006\u0010S\u001a\u00020\u001eH\u0000¢\u0006\u0002\u0008\\J\u0015\u0010]\u001a\u00020P2\u0006\u0010^\u001a\u00020(H\u0000¢\u0006\u0002\u0008_J\u0008\u0010`\u001a\u00020\nH\u0016J!\u0010a\u001a\u00020P2\u0008\u0008\u0002\u0010\u0005\u001a\u00028\u00012\u0008\u0008\u0002\u0010b\u001a\u00020.H\u0002¢\u0006\u0002\u0010cJ-\u0010d\u001a\u00020P2\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010@\u001a\u00028\u00012\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0015H\u0000¢\u0006\u0004\u0008e\u0010fJ\r\u0010g\u001a\u00020PH\u0000¢\u0006\u0002\u0008hJ%\u0010i\u001a\u00020P2\u0006\u0010@\u001a\u00028\u00012\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0015H\u0000¢\u0006\u0004\u0008j\u0010kRC\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r2\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R7\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00152\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00158F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001b\u0010\u0014\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000c\u001a\u00020\u001e8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008$\u0010%\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R\u001c\u0010&\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008)\u0010*\"\u0004\u0008+\u0010,R\u0014\u0010-\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010/\u001a\u00020.2\u0006\u0010\u000c\u001a\u00020.8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u00084\u0010\u0014\u001a\u0004\u00080\u00101\"\u0004\u00082\u00103R\u000e\u00105\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u00107R+\u00109\u001a\u0002082\u0006\u0010\u000c\u001a\u0002088@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008>\u0010?\u001a\u0004\u0008:\u0010;\"\u0004\u0008<\u0010=R+\u0010@\u001a\u00028\u00012\u0006\u0010\u000c\u001a\u00028\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008E\u0010\u0014\u001a\u0004\u0008A\u0010B\"\u0004\u0008C\u0010DR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008F\u0010GR\u000e\u0010H\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010I\u001a\u00028\u00012\u0006\u0010\u000c\u001a\u00028\u00018V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008L\u0010\u0014\u001a\u0004\u0008J\u0010B\"\u0004\u0008K\u0010DR\u0010\u0010M\u001a\u00028\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010N¨\u0006l", d2 = {"Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "initialVelocityVector", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "animation$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animationSpec$delegate", "defaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "", "durationNanos", "getDurationNanos$animation_core_release", "()J", "setDurationNanos$animation_core_release", "(J)V", "durationNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "initialValueAnimation", "initialValueState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "getInitialValueState$animation_core_release", "()Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialValueState$animation_core_release", "(Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;)V", "interruptionSpec", "", "isFinished", "isFinished$animation_core_release", "()Z", "setFinished$animation_core_release", "(Z)V", "isFinished$delegate", "isSeeking", "getLabel", "()Ljava/lang/String;", "", "resetSnapValue", "getResetSnapValue$animation_core_release", "()F", "setResetSnapValue$animation_core_release", "(F)V", "resetSnapValue$delegate", "Landroidx/compose/runtime/MutableFloatState;", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "useOnlyInitialValue", "value", "getValue", "setValue$animation_core_release", "value$delegate", "velocityVector", "Landroidx/compose/animation/core/AnimationVector;", "clearInitialAnimation", "", "clearInitialAnimation$animation_core_release", "onPlayTimeChanged", "playTimeNanos", "scaleToEnd", "onPlayTimeChanged$animation_core_release", "resetAnimation", "resetAnimation$animation_core_release", "resetAnimationValue", "fraction", "resetAnimationValue$animation_core_release", "seekTo", "seekTo$animation_core_release", "setInitialValueAnimation", "animationState", "setInitialValueAnimation$animation_core_release", "toString", "updateAnimation", "isInterrupted", "(Ljava/lang/Object;Z)V", "updateInitialAndTargetValue", "updateInitialAndTargetValue$animation_core_release", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "updateInitialValue", "updateInitialValue$animation_core_release", "updateTargetValue", "updateTargetValue$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class TransitionAnimationState implements State<T> {

        private final MutableState animation$delegate;
        private final MutableState animationSpec$delegate;
        private final androidx.compose.animation.core.SpringSpec<T> defaultSpring;
        private final MutableLongState durationNanos$delegate;
        private androidx.compose.animation.core.TargetBasedAnimation<T, V> initialValueAnimation;
        private androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState initialValueState;
        private final androidx.compose.animation.core.FiniteAnimationSpec<T> interruptionSpec;
        private final MutableState isFinished$delegate;
        private boolean isSeeking;
        private final String label;
        private final MutableFloatState resetSnapValue$delegate;
        private final MutableState targetValue$delegate;
        final androidx.compose.animation.core.Transition<S> this$0;
        private final androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter;
        private boolean useOnlyInitialValue;
        private final MutableState value$delegate;
        private V velocityVector;
        public TransitionAnimationState(androidx.compose.animation.core.Transition this$0, Object initialValue, androidx.compose.animation.core.AnimationVector initialVelocityVector, androidx.compose.animation.core.TwoWayConverter typeConverter, String label) {
            int invoke;
            int id;
            Object convertFromVector;
            androidx.compose.animation.core.TargetBasedAnimation targetBasedAnimation;
            int obj12;
            androidx.compose.animation.core.TwoWayConverter obj13;
            this.this$0 = this$0;
            super();
            this.typeConverter = typeConverter;
            this.label = label;
            final int i = 0;
            invoke = 2;
            this.targetValue$delegate = SnapshotStateKt.mutableStateOf$default(initialValue, i, invoke, i);
            final int i3 = 0;
            this.defaultSpring = AnimationSpecKt.spring$default(i3, i3, i, 7, i);
            this.animationSpec$delegate = SnapshotStateKt.mutableStateOf$default(this.defaultSpring, i, invoke, i);
            final Object obj = initialValue;
            final androidx.compose.animation.core.AnimationVector animationVector = initialVelocityVector;
            targetBasedAnimation = new TargetBasedAnimation((AnimationSpec)getAnimationSpec(), this.typeConverter, obj, getTargetValue(), animationVector);
            this.animation$delegate = SnapshotStateKt.mutableStateOf$default(targetBasedAnimation, i, invoke, i);
            this.isFinished$delegate = SnapshotStateKt.mutableStateOf$default(true, i, invoke, i);
            this.resetSnapValue$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(-1082130432);
            this.value$delegate = SnapshotStateKt.mutableStateOf$default(obj, i, invoke, i);
            this.velocityVector = animationVector;
            this.durationNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(getAnimation().getDurationNanos());
            obj12 = VisibilityThresholdsKt.getVisibilityThresholdMap().get(this.typeConverter);
            if ((Float)obj12 != null) {
                obj13 = 0;
                invoke = this.typeConverter.getConvertToVector().invoke(obj);
                id = 0;
                while (id < (AnimationVector)invoke.getSize$animation_core_release()) {
                    invoke.set$animation_core_release(id, (Number)(Float)obj12.floatValue());
                    id++;
                }
                obj12 = this.typeConverter.getConvertFromVector().invoke(invoke);
            } else {
                obj12 = i;
            }
            this.interruptionSpec = (FiniteAnimationSpec)AnimationSpecKt.spring$default(i3, i3, obj12, 3, i);
        }

        private final T getTargetValue() {
            final int i = 0;
            final int i2 = 0;
            return (State)this.targetValue$delegate.getValue();
        }

        private final void setAnimation(androidx.compose.animation.core.TargetBasedAnimation<T, V> <set-?>) {
            final int i = 0;
            final int i2 = 0;
            this.animation$delegate.setValue(<set-?>);
        }

        private final void setAnimationSpec(androidx.compose.animation.core.FiniteAnimationSpec<T> <set-?>) {
            final int i = 0;
            final int i2 = 0;
            this.animationSpec$delegate.setValue(<set-?>);
        }

        private final void setTargetValue(T <set-?>) {
            final int i = 0;
            final int i2 = 0;
            this.targetValue$delegate.setValue(<set-?>);
        }

        private final void updateAnimation(T initialValue, boolean isInterrupted) {
            Object targetValue;
            androidx.compose.animation.core.AnimationSpec delayed;
            Object playTimeNanos;
            androidx.compose.animation.core.AnimationSpec animationSpec;
            androidx.compose.animation.core.FiniteAnimationSpec obj14;
            androidx.compose.animation.core.TargetBasedAnimation initialValueAnimation = this.initialValueAnimation;
            if (initialValueAnimation != null) {
                targetValue = initialValueAnimation.getTargetValue();
            } else {
                targetValue = 0;
            }
            if (Intrinsics.areEqual(targetValue, getTargetValue())) {
                TargetBasedAnimation targetBasedAnimation = new TargetBasedAnimation((AnimationSpec)this.interruptionSpec, this.typeConverter, initialValue, initialValue, AnimationVectorsKt.newInstance(this.velocityVector));
                setAnimation(targetBasedAnimation);
                this.useOnlyInitialValue = true;
                setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            }
            if (isInterrupted && !this.isSeeking) {
                if (!this.isSeeking) {
                    if (obj14 instanceof SpringSpec) {
                        obj14 = getAnimationSpec();
                    } else {
                        obj14 = this.interruptionSpec;
                    }
                } else {
                    obj14 = getAnimationSpec();
                }
            } else {
            }
            int i2 = 0;
            if (Long.compare(playTimeNanos2, i2) <= 0) {
                animationSpec = delayed;
            } else {
                animationSpec = delayed;
            }
            TargetBasedAnimation targetBasedAnimation2 = new TargetBasedAnimation(animationSpec, this.typeConverter, initialValue, getTargetValue(), this.velocityVector);
            setAnimation(targetBasedAnimation2);
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = false;
            Transition.access$onChildAnimationUpdated(this.this$0);
        }

        static void updateAnimation$default(androidx.compose.animation.core.Transition.TransitionAnimationState transition$TransitionAnimationState, Object object2, boolean z3, int i4, Object object5) {
            Object obj1;
            int obj2;
            if (i4 & 1 != 0) {
                obj1 = transitionAnimationState.getValue();
            }
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            transitionAnimationState.updateAnimation(obj1, obj2);
        }

        @Override // androidx.compose.runtime.State
        public final void clearInitialAnimation$animation_core_release() {
            int i = 0;
            this.initialValueAnimation = i;
            this.initialValueState = i;
            this.useOnlyInitialValue = false;
        }

        public final androidx.compose.animation.core.TargetBasedAnimation<T, V> getAnimation() {
            final int i = 0;
            final int i2 = 0;
            return (TargetBasedAnimation)(State)this.animation$delegate.getValue();
        }

        public final androidx.compose.animation.core.FiniteAnimationSpec<T> getAnimationSpec() {
            final int i = 0;
            final int i2 = 0;
            return (FiniteAnimationSpec)(State)this.animationSpec$delegate.getValue();
        }

        @Override // androidx.compose.runtime.State
        public final long getDurationNanos$animation_core_release() {
            final int i = 0;
            final int i2 = 0;
            return (LongState)this.durationNanos$delegate.getLongValue();
        }

        @Override // androidx.compose.runtime.State
        public final androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState getInitialValueState$animation_core_release() {
            return this.initialValueState;
        }

        @Override // androidx.compose.runtime.State
        public final String getLabel() {
            return this.label;
        }

        @Override // androidx.compose.runtime.State
        public final float getResetSnapValue$animation_core_release() {
            final int i = 0;
            final int i2 = 0;
            return (FloatState)this.resetSnapValue$delegate.getFloatValue();
        }

        public final androidx.compose.animation.core.TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public T getValue() {
            final int i = 0;
            final int i2 = 0;
            return (State)this.value$delegate.getValue();
        }

        @Override // androidx.compose.runtime.State
        public final boolean isFinished$animation_core_release() {
            final int i = 0;
            final int i2 = 0;
            return (Boolean)(State)this.isFinished$delegate.getValue().booleanValue();
        }

        @Override // androidx.compose.runtime.State
        public final void onPlayTimeChanged$animation_core_release(long playTimeNanos, boolean scaleToEnd) {
            long durationNanos;
            boolean finishedFromNanos;
            if (obj6 != null) {
                durationNanos = getAnimation().getDurationNanos();
            } else {
                durationNanos = playTimeNanos;
            }
            setValue$animation_core_release(getAnimation().getValueFromNanos(durationNanos));
            this.velocityVector = getAnimation().getVelocityVectorFromNanos(durationNanos);
            if (getAnimation().isFinishedFromNanos(durationNanos)) {
                setFinished$animation_core_release(true);
            }
        }

        @Override // androidx.compose.runtime.State
        public final void resetAnimation$animation_core_release() {
            setResetSnapValue$animation_core_release(-1073741824);
        }

        @Override // androidx.compose.runtime.State
        public final void resetAnimationValue$animation_core_release(float fraction) {
            Object initialValue;
            int initialValueAnimation;
            int durationNanos;
            int i;
            Object targetValue;
            initialValue = -1065353216;
            durationNanos = 1;
            final int i3 = 0;
            initialValueAnimation = Float.compare(fraction, initialValue) == 0 ? durationNanos : i3;
            if (initialValueAnimation == 0) {
                initialValueAnimation = Float.compare(fraction, i2) == 0 ? durationNanos : i3;
                if (initialValueAnimation != 0) {
                    initialValueAnimation = this.initialValueAnimation;
                    if (initialValueAnimation != null) {
                        getAnimation().setMutableInitialValue$animation_core_release(initialValueAnimation.getTargetValue());
                        i = 0;
                        this.initialValueState = i;
                        this.initialValueAnimation = i;
                    }
                    if (Float.compare(fraction, initialValue) == 0) {
                    } else {
                        durationNanos = i3;
                    }
                    if (durationNanos != 0) {
                        initialValue = getAnimation().getInitialValue();
                    } else {
                        initialValue = getAnimation().getTargetValue();
                    }
                    getAnimation().setMutableInitialValue$animation_core_release(initialValue);
                    getAnimation().setMutableTargetValue$animation_core_release(initialValue);
                    setValue$animation_core_release(initialValue);
                    setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
                } else {
                    setResetSnapValue$animation_core_release(fraction);
                }
            } else {
            }
        }

        @Override // androidx.compose.runtime.State
        public final void seekTo$animation_core_release(long playTimeNanos) {
            int i;
            Object velocityVectorFromNanos;
            int i3 = 1;
            i = Float.compare(resetSnapValue$animation_core_release, i2) == 0 ? i3 : 0;
            if (i == 0) {
            }
            this.isSeeking = i3;
            if (Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue())) {
                setValue$animation_core_release(getAnimation().getTargetValue());
            } else {
                setValue$animation_core_release(getAnimation().getValueFromNanos(playTimeNanos));
                this.velocityVector = getAnimation().getVelocityVectorFromNanos(playTimeNanos);
            }
        }

        @Override // androidx.compose.runtime.State
        public final void setDurationNanos$animation_core_release(long <set-?>) {
            final int i = 0;
            final int i2 = 0;
            this.durationNanos$delegate.setLongValue(<set-?>);
        }

        @Override // androidx.compose.runtime.State
        public final void setFinished$animation_core_release(boolean <set-?>) {
            final int i = 0;
            final int i2 = 0;
            this.isFinished$delegate.setValue(Boolean.valueOf(<set-?>));
        }

        @Override // androidx.compose.runtime.State
        public final void setInitialValueAnimation$animation_core_release(androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState animationState) {
            boolean animation;
            if (!Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue())) {
                this.initialValueAnimation = getAnimation();
                this.initialValueState = animationState;
            }
            TargetBasedAnimation targetBasedAnimation = new TargetBasedAnimation((AnimationSpec)this.interruptionSpec, this.typeConverter, getValue(), getValue(), AnimationVectorsKt.newInstance(this.velocityVector));
            setAnimation(targetBasedAnimation);
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = true;
        }

        @Override // androidx.compose.runtime.State
        public final void setInitialValueState$animation_core_release(androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState <set-?>) {
            this.initialValueState = <set-?>;
        }

        @Override // androidx.compose.runtime.State
        public final void setResetSnapValue$animation_core_release(float <set-?>) {
            final int i = 0;
            final int i2 = 0;
            this.resetSnapValue$delegate.setFloatValue(<set-?>);
        }

        public void setValue$animation_core_release(T <set-?>) {
            final int i = 0;
            final int i2 = 0;
            this.value$delegate.setValue(<set-?>);
        }

        @Override // androidx.compose.runtime.State
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("current value: ").append(getValue()).append(", target: ").append(getTargetValue()).append(", spec: ").append(getAnimationSpec()).toString();
        }

        public final void updateInitialAndTargetValue$animation_core_release(T initialValue, T targetValue, androidx.compose.animation.core.FiniteAnimationSpec<T> animationSpec) {
            boolean equal;
            setTargetValue(targetValue);
            setAnimationSpec(animationSpec);
            if (Intrinsics.areEqual(getAnimation().getInitialValue(), initialValue) && Intrinsics.areEqual(getAnimation().getTargetValue(), targetValue)) {
                if (Intrinsics.areEqual(getAnimation().getTargetValue(), targetValue)) {
                }
            }
            Transition.TransitionAnimationState.updateAnimation$default(this, initialValue, false, 2, 0);
        }

        @Override // androidx.compose.runtime.State
        public final void updateInitialValue$animation_core_release() {
            boolean useOnlyInitialValue2;
            int useOnlyInitialValue;
            int cmp;
            long playTimeNanos;
            final androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState initialValueState = this.initialValueState;
            if (initialValueState == null) {
            }
            final androidx.compose.animation.core.TargetBasedAnimation initialValueAnimation = this.initialValueAnimation;
            if (initialValueAnimation == null) {
            }
            long roundToLong = MathKt.roundToLong(d *= d2);
            Object valueFromNanos = initialValueAnimation.getValueFromNanos(roundToLong);
            if (this.useOnlyInitialValue) {
                getAnimation().setMutableTargetValue$animation_core_release(valueFromNanos);
            }
            getAnimation().setMutableInitialValue$animation_core_release(valueFromNanos);
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            int i3 = 0;
            useOnlyInitialValue = Float.compare(resetSnapValue$animation_core_release, i2) == 0 ? 1 : i3;
            if (useOnlyInitialValue == 0) {
                if (this.useOnlyInitialValue) {
                    setValue$animation_core_release(valueFromNanos);
                } else {
                    seekTo$animation_core_release(this.this$0.getPlayTimeNanos());
                }
            } else {
            }
            if (Long.compare(roundToLong, durationNanos3) >= 0) {
                cmp = 0;
                this.initialValueState = cmp;
                this.initialValueAnimation = cmp;
            } else {
                initialValueState.setComplete(i3);
            }
        }

        public final void updateTargetValue$animation_core_release(T targetValue, androidx.compose.animation.core.FiniteAnimationSpec<T> animationSpec) {
            boolean useOnlyInitialValue;
            boolean equal;
            int i2;
            Object value;
            int targetValue2;
            Object valueFromNanos;
            long durationNanos;
            int i;
            int resetSnapValue$animation_core_release2;
            long i3;
            float resetSnapValue$animation_core_release;
            if (this.useOnlyInitialValue) {
                androidx.compose.animation.core.TargetBasedAnimation initialValueAnimation = this.initialValueAnimation;
                if (initialValueAnimation != null) {
                    targetValue2 = initialValueAnimation.getTargetValue();
                } else {
                    targetValue2 = 0;
                }
                if (Intrinsics.areEqual(targetValue, targetValue2)) {
                }
            }
            final int i4 = -1082130432;
            valueFromNanos = 1;
            final int i5 = 0;
            if (Intrinsics.areEqual(getTargetValue(), targetValue)) {
                equal = Float.compare(resetSnapValue$animation_core_release4, i4) == 0 ? valueFromNanos : i5;
                if (equal != 0) {
                }
            }
            setTargetValue(targetValue);
            setAnimationSpec(animationSpec);
            int i6 = -1069547520;
            i2 = Float.compare(resetSnapValue$animation_core_release3, i6) == 0 ? valueFromNanos : i5;
            if (i2 != 0) {
                value = targetValue;
            } else {
                value = getValue();
            }
            updateAnimation(value, finished$animation_core_release ^= valueFromNanos);
            i = Float.compare(resetSnapValue$animation_core_release5, i6) == 0 ? valueFromNanos : i5;
            setFinished$animation_core_release(i);
            if (Float.compare(resetSnapValue$animation_core_release6, i3) >= 0) {
                resetSnapValue$animation_core_release = getResetSnapValue$animation_core_release();
                setValue$animation_core_release(getAnimation().getValueFromNanos((long)i8));
            } else {
                if (Float.compare(resetSnapValue$animation_core_release2, i6) == 0) {
                } else {
                    valueFromNanos = i5;
                }
                if (valueFromNanos != 0) {
                    setValue$animation_core_release(targetValue);
                }
            }
            this.useOnlyInitialValue = i5;
            setResetSnapValue$animation_core_release(i4);
        }
    }
    static {
    }

    public Transition(androidx.compose.animation.core.MutableTransitionState<S> transitionState, String label) {
        Intrinsics.checkNotNull(transitionState, "null cannot be cast to non-null type androidx.compose.animation.core.TransitionState<S of androidx.compose.animation.core.Transition>");
        super((TransitionState)transitionState, 0, label);
    }

    public Transition(androidx.compose.animation.core.MutableTransitionState mutableTransitionState, String string2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(mutableTransitionState, obj2);
    }

    public Transition(androidx.compose.animation.core.TransitionState<S> transitionState, androidx.compose.animation.core.Transition<?> parentTransition, String label) {
        super();
        this.transitionState = transitionState;
        this.parentTransition = parentTransition;
        this.label = label;
        final int i2 = 0;
        final int i3 = 2;
        this.targetState$delegate = SnapshotStateKt.mutableStateOf$default(getCurrentState(), i2, i3, i2);
        final Object currentState3 = getCurrentState();
        Transition.SegmentImpl segmentImpl = new Transition.SegmentImpl(getCurrentState(), currentState3);
        this.segment$delegate = SnapshotStateKt.mutableStateOf$default(segmentImpl, i2, i3, i2);
        this._playTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(0);
        this.startTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(Long.MIN_VALUE);
        Boolean valueOf = false;
        this.updateChildrenNeeded$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i2, i3, i2);
        this._animations = SnapshotStateKt.mutableStateListOf();
        this._transitions = SnapshotStateKt.mutableStateListOf();
        this.isSeeking$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i2, i3, i2);
        Transition.totalDurationNanos.2 anon = new Transition.totalDurationNanos.2(this);
        this.totalDurationNanos$delegate = SnapshotStateKt.derivedStateOf((Function0)anon);
        this.transitionState.transitionConfigured$animation_core_release(this);
    }

    public Transition(androidx.compose.animation.core.TransitionState transitionState, androidx.compose.animation.core.Transition transition2, String string3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(transitionState, transition2, obj3);
    }

    public Transition(androidx.compose.animation.core.TransitionState<S> transitionState, String label) {
        super(transitionState, 0, label);
    }

    public Transition(androidx.compose.animation.core.TransitionState transitionState, String string2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(transitionState, obj2);
    }

    public Transition(S initialState, String label) {
        MutableTransitionState mutableTransitionState = new MutableTransitionState(initialState);
        super((TransitionState)mutableTransitionState, 0, label);
    }

    public static final long access$calculateTotalDurationNanos(androidx.compose.animation.core.Transition $this) {
        return $this.calculateTotalDurationNanos();
    }

    public static final void access$onChildAnimationUpdated(androidx.compose.animation.core.Transition $this) {
        $this.onChildAnimationUpdated();
    }

    private final long calculateTotalDurationNanos() {
        int maxDurationNanos;
        int index$iv2;
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        long durationNanos$animation_core_release;
        maxDurationNanos = 0;
        SnapshotStateList _animations = this._animations;
        int i2 = 0;
        index$iv2 = 0;
        while (index$iv2 < (List)_animations.size()) {
            i = 0;
            maxDurationNanos = Math.max(maxDurationNanos, obj1);
            index$iv2++;
        }
        SnapshotStateList $this$fastForEach$iv = this._transitions;
        int i3 = 0;
        index$iv = 0;
        while (index$iv < (List)$this$fastForEach$iv.size()) {
            i = 0;
            maxDurationNanos = durationNanos$animation_core_release;
            index$iv++;
        }
        return maxDurationNanos;
    }

    public static void getHasInitialValueAnimations$annotations() {
    }

    private final boolean getUpdateChildrenNeeded() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.updateChildrenNeeded$delegate.getValue().booleanValue();
    }

    private final long get_playTimeNanos() {
        final int i = 0;
        final int i2 = 0;
        return (LongState)this._playTimeNanos$delegate.getLongValue();
    }

    private final void onChildAnimationUpdated() {
        boolean maxDurationNanos;
        int $this$fastForEach$iv;
        int i2;
        int index$iv;
        int size;
        Object obj2;
        Object obj;
        int i;
        long lastSeekedTimeNanos;
        setUpdateChildrenNeeded(true);
        if (isSeeking()) {
            maxDurationNanos = 0;
            SnapshotStateList _animations = this._animations;
            i2 = 0;
            index$iv = 0;
            while (index$iv < (List)_animations.size()) {
                obj = obj2;
                i = 0;
                maxDurationNanos = Math.max(maxDurationNanos, obj1);
                obj.seekTo$animation_core_release(this.lastSeekedTimeNanos);
                index$iv++;
            }
            setUpdateChildrenNeeded(false);
        }
    }

    private final void resetAnimations() {
        int index$iv;
        int index$iv2;
        Object obj2;
        Object obj;
        int i;
        SnapshotStateList _animations = this._animations;
        int i2 = 0;
        index$iv = 0;
        while (index$iv < (List)_animations.size()) {
            i = 0;
            (Transition.TransitionAnimationState)_animations.get(index$iv).resetAnimation$animation_core_release();
            index$iv++;
        }
        SnapshotStateList $this$fastForEach$iv = this._transitions;
        int i3 = 0;
        index$iv2 = 0;
        while (index$iv2 < (List)$this$fastForEach$iv.size()) {
            i = 0;
            (Transition)$this$fastForEach$iv.get(index$iv2).resetAnimations();
            index$iv2++;
        }
    }

    private final void setSegment(androidx.compose.animation.core.Transition.Segment<S> <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.segment$delegate.setValue(<set-?>);
    }

    private final void setUpdateChildrenNeeded(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.updateChildrenNeeded$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void set_playTimeNanos(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this._playTimeNanos$delegate.setLongValue(<set-?>);
    }

    public final boolean addAnimation$animation_core_release(androidx.compose.animation.core.Transition.TransitionAnimationState<S, ?, ?> animation) {
        return this._animations.add(animation);
    }

    public final boolean addTransition$animation_core_release(androidx.compose.animation.core.Transition<?> transition) {
        return this._transitions.add(transition);
    }

    public final void animateTo$animation_core_release(S targetState, Composer $composer, int $changed) {
        int i;
        boolean updateChildrenNeeded;
        int compositionCoroutineScope;
        int traceInProgress2;
        int $dirty;
        int i4;
        int i2;
        int traceInProgress;
        int i6;
        boolean changedInstance;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        Object compositionScopedCoroutineScopeCanceller;
        int str;
        Object rememberedValue;
        int i5;
        Object empty;
        Object anon;
        Object rememberedValue2;
        int i3;
        Object empty2;
        EmptyCoroutineContext iNSTANCE;
        final Object obj = this;
        final Object obj2 = targetState;
        final int i7 = $changed;
        traceInProgress2 = -1493585151;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(animateTo):Transition.kt#pdpnli");
        if (i7 & 6 == 0) {
            if (i7 & 8 == 0) {
                changedInstance = restartGroup.changed(obj2);
            } else {
                changedInstance = restartGroup.changedInstance(obj2);
            }
            i4 = changedInstance != null ? 4 : 2;
            $dirty |= i4;
        }
        if (i7 & 48 == 0) {
            i2 = restartGroup.changed(obj) ? 32 : 16;
            $dirty |= i2;
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.animation.core.Transition.animateTo (Transition.kt:1209)");
                }
                if (!obj.isSeeking()) {
                    restartGroup.startReplaceGroup(1822376658);
                    ComposerKt.sourceInformation(restartGroup, "");
                    updateTarget$animation_core_release(targetState);
                    if (Intrinsics.areEqual(obj2, obj.getCurrentState()) && !obj.isRunning()) {
                        if (!obj.isRunning()) {
                            if (obj.getUpdateChildrenNeeded()) {
                                restartGroup.startReplaceGroup(1822607949);
                                ComposerKt.sourceInformation(restartGroup, "1217@49699L24,1218@49779L1012,1218@49740L1051");
                                int i12 = compositionCoroutineScope;
                                int i15 = 0;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                                int i19 = 0;
                                empty = restartGroup;
                                int i20 = 0;
                                rememberedValue2 = empty.rememberedValue();
                                i3 = 0;
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    empty2 = 0;
                                    int i21 = 0;
                                    compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, restartGroup));
                                    empty.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                } else {
                                    compositionScopedCoroutineScopeCanceller = rememberedValue2;
                                }
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                coroutineScope = (CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope();
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 335896763, "CC(remember):Transition.kt#9igjgp");
                                i6 = $dirty & 112 == 32 ? 1 : 0;
                                traceInProgress = restartGroup;
                                str = 0;
                                rememberedValue = traceInProgress.rememberedValue();
                                i5 = 0;
                                if (changedInstance2 |= i6 == 0) {
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                        empty = 0;
                                        anon = new Transition.animateTo.1.1(coroutineScope, obj);
                                        traceInProgress.updateRememberedValue((Function1)anon);
                                    } else {
                                        anon = rememberedValue;
                                    }
                                } else {
                                }
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                EffectsKt.DisposableEffect(coroutineScope, obj, (Function1)anon, restartGroup, $dirty & 112);
                                restartGroup.endReplaceGroup();
                            } else {
                                restartGroup.startReplaceGroup(1823851483);
                                restartGroup.endReplaceGroup();
                            }
                        } else {
                        }
                    } else {
                    }
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(1823861403);
                    restartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new Transition.animateTo.2(obj, obj2, i7);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public final void clearInitialAnimations$animation_core_release() {
        int index$iv;
        int index$iv2;
        Object obj;
        Object obj2;
        int i;
        SnapshotStateList _animations = this._animations;
        int i2 = 0;
        index$iv = 0;
        while (index$iv < (List)_animations.size()) {
            i = 0;
            (Transition.TransitionAnimationState)_animations.get(index$iv).clearInitialAnimation$animation_core_release();
            index$iv++;
        }
        SnapshotStateList $this$fastForEach$iv = this._transitions;
        int i3 = 0;
        index$iv2 = 0;
        while (index$iv2 < (List)$this$fastForEach$iv.size()) {
            i = 0;
            (Transition)$this$fastForEach$iv.get(index$iv2).clearInitialAnimations$animation_core_release();
            index$iv2++;
        }
    }

    public final List<androidx.compose.animation.core.Transition.TransitionAnimationState<S, ?, ?>> getAnimations() {
        return (List)this._animations;
    }

    public final S getCurrentState() {
        return this.transitionState.getCurrentState();
    }

    public final boolean getHasInitialValueAnimations() {
        int $this$fastAny$iv;
        int i5;
        SnapshotStateList list;
        int i;
        int index$iv$iv;
        int size;
        int i2;
        int i6;
        Object obj;
        Object obj2;
        int i3;
        int it;
        int i4;
        androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState initialValueState$animation_core_release;
        i5 = 0;
        list = _animations;
        i = 0;
        index$iv$iv = 0;
        i2 = 0;
        i6 = 1;
        while (index$iv$iv < list.size()) {
            i3 = 0;
            i4 = 0;
            if ((Transition.TransitionAnimationState)list.get(index$iv$iv).getInitialValueState$animation_core_release() != null) {
            } else {
            }
            it = i2;
            index$iv$iv++;
            i2 = 0;
            i6 = 1;
            it = i6;
        }
        $this$fastAny$iv = i2;
        if ($this$fastAny$iv == 0) {
            i5 = 0;
            list = _transitions;
            i = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list.size()) {
                i3 = 0;
                i4 = 0;
                index$iv$iv++;
            }
            $this$fastAny$iv = i2;
            if ($this$fastAny$iv != 0) {
                i2 = i6;
            }
        } else {
        }
        return i2;
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getLastSeekedTimeNanos$animation_core_release() {
        return this.lastSeekedTimeNanos;
    }

    public final androidx.compose.animation.core.Transition<?> getParentTransition() {
        return this.parentTransition;
    }

    public final long getPlayTimeNanos() {
        long playTimeNanos;
        androidx.compose.animation.core.Transition parentTransition = this.parentTransition;
        if (parentTransition != null) {
            playTimeNanos = parentTransition.getPlayTimeNanos();
        } else {
            playTimeNanos = get_playTimeNanos();
        }
        return playTimeNanos;
    }

    public final androidx.compose.animation.core.Transition.Segment<S> getSegment() {
        final int i = 0;
        final int i2 = 0;
        return (Transition.Segment)(State)this.segment$delegate.getValue();
    }

    public final long getStartTimeNanos$animation_core_release() {
        final int i = 0;
        final int i2 = 0;
        return (LongState)this.startTimeNanos$delegate.getLongValue();
    }

    public final S getTargetState() {
        final int i = 0;
        final int i2 = 0;
        return (State)this.targetState$delegate.getValue();
    }

    public final long getTotalDurationNanos() {
        final int i = 0;
        final int i2 = 0;
        return (Number)this.totalDurationNanos$delegate.getValue().longValue();
    }

    public final List<androidx.compose.animation.core.Transition<?>> getTransitions() {
        return (List)this._transitions;
    }

    public final boolean isRunning() {
        int i;
        i = Long.compare(startTimeNanos$animation_core_release, l) != 0 ? 1 : 0;
        return i;
    }

    public final boolean isSeeking() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isSeeking$delegate.getValue().booleanValue();
    }

    public final void onDisposed$animation_core_release() {
        onTransitionEnd$animation_core_release();
        this.transitionState.transitionRemoved$animation_core_release();
    }

    public final void onFrame$animation_core_release(long frameTimeNanos, float durationScale) {
        int i;
        int i2;
        long roundToLong;
        double d;
        if (Long.compare(startTimeNanos$animation_core_release, l) == 0) {
            onTransitionStart$animation_core_release(frameTimeNanos);
        }
        int i3 = frameTimeNanos - startTimeNanos$animation_core_release2;
        int i4 = 0;
        final int i5 = 0;
        i = Float.compare(obj13, i4) == 0 ? i2 : i5;
        if (i != 0) {
            roundToLong = i3;
        } else {
            roundToLong = MathKt.roundToLong(d2 /= d);
        }
        setPlayTimeNanos(roundToLong);
        if (Float.compare(obj13, i4) == 0) {
        } else {
            i2 = i5;
        }
        onFrame$animation_core_release(roundToLong, obj7);
    }

    public final void onFrame$animation_core_release(long scaledPlayTimeNanos, boolean scaleToEnd) {
        int running$animation_core_release;
        int allFinished;
        int i;
        int index$iv2;
        int index$iv;
        Object obj2;
        Object obj;
        int i2;
        boolean finished$animation_core_release;
        Object currentState;
        if (Long.compare(startTimeNanos$animation_core_release, l) == 0) {
            onTransitionStart$animation_core_release(scaledPlayTimeNanos);
        } else {
            if (!this.transitionState.isRunning$animation_core_release()) {
                this.transitionState.setRunning$animation_core_release(true);
            }
        }
        setUpdateChildrenNeeded(false);
        int i4 = 0;
        allFinished = 1;
        SnapshotStateList _animations = this._animations;
        int i5 = 0;
        index$iv2 = 0;
        while (index$iv2 < (List)_animations.size()) {
            obj = obj2;
            i2 = 0;
            if (!(Transition.TransitionAnimationState)obj.isFinished$animation_core_release()) {
            }
            if (!obj.isFinished$animation_core_release()) {
            }
            index$iv2++;
            allFinished = 0;
            obj.onPlayTimeChanged$animation_core_release(scaledPlayTimeNanos, scaleToEnd);
        }
        SnapshotStateList $this$fastForEach$iv = this._transitions;
        int i6 = 0;
        index$iv = 0;
        while (index$iv < (List)$this$fastForEach$iv.size()) {
            obj = obj2;
            i2 = 0;
            if (!Intrinsics.areEqual((Transition)obj.getTargetState(), obj.getCurrentState())) {
            }
            if (!Intrinsics.areEqual(obj.getTargetState(), obj.getCurrentState())) {
            }
            index$iv++;
            allFinished = 0;
            obj.onFrame$animation_core_release(scaledPlayTimeNanos, scaleToEnd);
        }
        if (allFinished != 0) {
            onTransitionEnd$animation_core_release();
        }
    }

    public final void onTransitionEnd$animation_core_release() {
        boolean transitionState;
        Object targetState;
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        setStartTimeNanos$animation_core_release(Long.MIN_VALUE);
        if (transitionState2 instanceof MutableTransitionState) {
            this.transitionState.setCurrentState$animation_core_release(getTargetState());
        }
        setPlayTimeNanos(0);
        this.transitionState.setRunning$animation_core_release(false);
        SnapshotStateList _transitions = this._transitions;
        int i4 = 0;
        index$iv = 0;
        while (index$iv < (List)_transitions.size()) {
            i = 0;
            (Transition)_transitions.get(index$iv).onTransitionEnd$animation_core_release();
            index$iv++;
        }
    }

    public final void onTransitionStart$animation_core_release(long frameTimeNanos) {
        setStartTimeNanos$animation_core_release(frameTimeNanos);
        this.transitionState.setRunning$animation_core_release(true);
    }

    public final void removeAnimation$animation_core_release(androidx.compose.animation.core.Transition.DeferredAnimation<S, ?, ?> deferredAnimation) {
        Object data$animation_core_release;
        int i;
        data$animation_core_release = deferredAnimation.getData$animation_core_release();
        data$animation_core_release = data$animation_core_release.getAnimation();
        if (data$animation_core_release != null && data$animation_core_release != null) {
            data$animation_core_release = data$animation_core_release.getAnimation();
            if (data$animation_core_release != null) {
                i = 0;
                removeAnimation$animation_core_release(data$animation_core_release);
            }
        }
    }

    public final void removeAnimation$animation_core_release(androidx.compose.animation.core.Transition.TransitionAnimationState<S, ?, ?> animation) {
        this._animations.remove(animation);
    }

    public final boolean removeTransition$animation_core_release(androidx.compose.animation.core.Transition<?> transition) {
        return this._transitions.remove(transition);
    }

    public final void resetAnimationFraction$animation_core_release(float fraction) {
        int index$iv2;
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        SnapshotStateList _animations = this._animations;
        int i2 = 0;
        index$iv2 = 0;
        while (index$iv2 < (List)_animations.size()) {
            i = 0;
            (Transition.TransitionAnimationState)_animations.get(index$iv2).resetAnimationValue$animation_core_release(fraction);
            index$iv2++;
        }
        SnapshotStateList $this$fastForEach$iv = this._transitions;
        int i3 = 0;
        index$iv = 0;
        while (index$iv < (List)$this$fastForEach$iv.size()) {
            i = 0;
            (Transition)$this$fastForEach$iv.get(index$iv).resetAnimationFraction$animation_core_release(fraction);
            index$iv++;
        }
    }

    public final void seek(S initialState, S targetState, long playTimeNanos) {
        boolean segmentImpl;
        boolean transitionState;
        int index$iv2;
        int index$iv;
        Object obj2;
        Object obj3;
        int i;
        Object obj;
        int i2;
        boolean currentState;
        Object targetState2;
        setStartTimeNanos$animation_core_release(Long.MIN_VALUE);
        this.transitionState.setRunning$animation_core_release(false);
        if (isSeeking() && Intrinsics.areEqual(getCurrentState(), initialState)) {
            if (Intrinsics.areEqual(getCurrentState(), initialState)) {
                if (!Intrinsics.areEqual(getTargetState(), targetState) && !Intrinsics.areEqual(getCurrentState(), initialState) && transitionState3 instanceof MutableTransitionState) {
                    if (!Intrinsics.areEqual(getCurrentState(), initialState)) {
                        if (transitionState3 instanceof MutableTransitionState) {
                            this.transitionState.setCurrentState$animation_core_release(initialState);
                        }
                    }
                    setTargetState$animation_core_release(targetState);
                    setSeeking$animation_core_release(true);
                    segmentImpl = new Transition.SegmentImpl(initialState, targetState);
                    setSegment((Transition.Segment)segmentImpl);
                }
            } else {
            }
        } else {
        }
        SnapshotStateList _transitions = this._transitions;
        int i5 = 0;
        index$iv2 = 0;
        while (index$iv2 < (List)_transitions.size()) {
            obj3 = obj2;
            i = 0;
            Intrinsics.checkNotNull((Transition)obj3, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            obj = obj3;
            i2 = 0;
            if (obj.isSeeking()) {
            }
            index$iv2++;
            obj.seek(obj.getCurrentState(), obj.getTargetState(), playTimeNanos);
        }
        SnapshotStateList $this$fastForEach$iv = this._animations;
        int i6 = 0;
        index$iv = 0;
        while (index$iv < (List)$this$fastForEach$iv.size()) {
            i = 0;
            (Transition.TransitionAnimationState)$this$fastForEach$iv.get(index$iv).seekTo$animation_core_release(playTimeNanos);
            index$iv++;
        }
        this.lastSeekedTimeNanos = playTimeNanos;
    }

    public final void seekAnimations$animation_core_release(long playTimeNanos) {
        int index$iv2;
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        boolean equal;
        Object currentState;
        if (Long.compare(startTimeNanos$animation_core_release, l) == 0) {
            setStartTimeNanos$animation_core_release(playTimeNanos);
        }
        setPlayTimeNanos(playTimeNanos);
        setUpdateChildrenNeeded(false);
        SnapshotStateList _animations = this._animations;
        int i3 = 0;
        index$iv2 = 0;
        while (index$iv2 < (List)_animations.size()) {
            i = 0;
            (Transition.TransitionAnimationState)_animations.get(index$iv2).seekTo$animation_core_release(playTimeNanos);
            index$iv2++;
        }
        SnapshotStateList $this$fastForEach$iv = this._transitions;
        int i4 = 0;
        index$iv = 0;
        while (index$iv < (List)$this$fastForEach$iv.size()) {
            obj = obj2;
            i = 0;
            if (!Intrinsics.areEqual((Transition)obj.getTargetState(), obj.getCurrentState())) {
            }
            index$iv++;
            obj.seekAnimations$animation_core_release(playTimeNanos);
        }
    }

    public final void setInitialAnimations$animation_core_release(androidx.compose.animation.core.SeekableTransitionState.SeekingAnimationState animationState) {
        int index$iv;
        int index$iv2;
        Object obj2;
        Object obj;
        int i;
        SnapshotStateList _animations = this._animations;
        int i2 = 0;
        index$iv = 0;
        while (index$iv < (List)_animations.size()) {
            i = 0;
            (Transition.TransitionAnimationState)_animations.get(index$iv).setInitialValueAnimation$animation_core_release(animationState);
            index$iv++;
        }
        SnapshotStateList $this$fastForEach$iv = this._transitions;
        int i3 = 0;
        index$iv2 = 0;
        while (index$iv2 < (List)$this$fastForEach$iv.size()) {
            i = 0;
            (Transition)$this$fastForEach$iv.get(index$iv2).setInitialAnimations$animation_core_release(animationState);
            index$iv2++;
        }
    }

    public final void setLastSeekedTimeNanos$animation_core_release(long <set-?>) {
        this.lastSeekedTimeNanos = <set-?>;
    }

    public final void setPlayTimeNanos(long value) {
        if (this.parentTransition == null) {
            set_playTimeNanos(value);
        }
    }

    public final void setSeeking$animation_core_release(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isSeeking$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setStartTimeNanos$animation_core_release(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.startTimeNanos$delegate.setLongValue(<set-?>);
    }

    public final void setTargetState$animation_core_release(S <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.targetState$delegate.setValue(<set-?>);
    }

    public String toString() {
        String accumulator$iv;
        int index$iv$iv;
        Object obj;
        Object obj2;
        int i;
        String anim;
        String str2;
        int i2;
        StringBuilder append;
        String str;
        final int i3 = 0;
        int i4 = 0;
        accumulator$iv = str3;
        final List list = animations;
        final int i5 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i = 0;
            i2 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            accumulator$iv = anim;
            index$iv$iv++;
        }
        return accumulator$iv;
    }

    public final void updateInitialValues$animation_core_release() {
        int index$iv;
        int index$iv2;
        Object obj2;
        Object obj;
        int i;
        SnapshotStateList _animations = this._animations;
        int i2 = 0;
        index$iv = 0;
        while (index$iv < (List)_animations.size()) {
            i = 0;
            (Transition.TransitionAnimationState)_animations.get(index$iv).updateInitialValue$animation_core_release();
            index$iv++;
        }
        SnapshotStateList $this$fastForEach$iv = this._transitions;
        int i3 = 0;
        index$iv2 = 0;
        while (index$iv2 < (List)$this$fastForEach$iv.size()) {
            i = 0;
            (Transition)$this$fastForEach$iv.get(index$iv2).updateInitialValues$animation_core_release();
            index$iv2++;
        }
    }

    public final void updateTarget$animation_core_release(S targetState) {
        boolean transitionState;
        boolean running;
        Object targetState2;
        Transition.SegmentImpl segmentImpl = new Transition.SegmentImpl(getTargetState(), targetState);
        setSegment((Transition.Segment)segmentImpl);
        if (!Intrinsics.areEqual(getTargetState(), targetState) && !Intrinsics.areEqual(getCurrentState(), getTargetState())) {
            segmentImpl = new Transition.SegmentImpl(getTargetState(), targetState);
            setSegment((Transition.Segment)segmentImpl);
            if (!Intrinsics.areEqual(getCurrentState(), getTargetState())) {
                this.transitionState.setCurrentState$animation_core_release(getTargetState());
            }
            setTargetState$animation_core_release(targetState);
            if (!isRunning()) {
                setUpdateChildrenNeeded(true);
            }
            resetAnimations();
        }
    }
}
