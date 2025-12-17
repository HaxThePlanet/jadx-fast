package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \u0001\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a3\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\u0008\u0000\u0010\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u00162\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a-\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\u0008\u0000\u0010\u00142\u0006\u0010\u001b\u001a\u0002H\u00142\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010\u001c\u001a3\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\u0008\u0000\u0010\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u001d2\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010\u001e\u001a\u0082\u0001\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020!0 \"\u0004\u0008\u0000\u0010\"*\u0008\u0012\u0004\u0012\u0002H\"0\u00132*\u0008\n\u0010#\u001a$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020!0%0\u000f¢\u0006\u0002\u0008&¢\u0006\u0002\u0008'2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020!0\u000f¢\u0006\u0002\u0008&H\u0087\u0008¢\u0006\u0002\u0010,\u001a\u0082\u0001\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\u00030 \"\u0004\u0008\u0000\u0010\"*\u0008\u0012\u0004\u0012\u0002H\"0\u00132*\u0008\n\u0010#\u001a$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030%0\u000f¢\u0006\u0002\u0008&¢\u0006\u0002\u0008'2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0002\u0008&H\u0087\u0008¢\u0006\u0002\u0010,\u001a\u0082\u0001\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u00010 \"\u0004\u0008\u0000\u0010\"*\u0008\u0012\u0004\u0012\u0002H\"0\u00132*\u0008\n\u0010#\u001a$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010%0\u000f¢\u0006\u0002\u0008&¢\u0006\u0002\u0008'2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0008&H\u0087\u0008¢\u0006\u0002\u0010,\u001a\u0082\u0001\u0010/\u001a\u0008\u0012\u0004\u0012\u0002000 \"\u0004\u0008\u0000\u0010\"*\u0008\u0012\u0004\u0012\u0002H\"0\u00132*\u0008\n\u0010#\u001a$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002000%0\u000f¢\u0006\u0002\u0008&¢\u0006\u0002\u0008'2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u0002000\u000f¢\u0006\u0002\u0008&H\u0087\u0008¢\u0006\u0002\u0010,\u001a\u0082\u0001\u00101\u001a\u0008\u0012\u0004\u0012\u0002020 \"\u0004\u0008\u0000\u0010\"*\u0008\u0012\u0004\u0012\u0002H\"0\u00132*\u0008\n\u0010#\u001a$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002020%0\u000f¢\u0006\u0002\u0008&¢\u0006\u0002\u0008'2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u0002020\u000f¢\u0006\u0002\u0008&H\u0087\u0008¢\u0006\u0002\u0010,\u001a\u0082\u0001\u00103\u001a\u0008\u0012\u0004\u0012\u0002040 \"\u0004\u0008\u0000\u0010\"*\u0008\u0012\u0004\u0012\u0002H\"0\u00132*\u0008\n\u0010#\u001a$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002040%0\u000f¢\u0006\u0002\u0008&¢\u0006\u0002\u0008'2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u0002040\u000f¢\u0006\u0002\u0008&H\u0087\u0008¢\u0006\u0002\u0010,\u001a\u0082\u0001\u00105\u001a\u0008\u0012\u0004\u0012\u0002060 \"\u0004\u0008\u0000\u0010\"*\u0008\u0012\u0004\u0012\u0002H\"0\u00132*\u0008\n\u0010#\u001a$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002060%0\u000f¢\u0006\u0002\u0008&¢\u0006\u0002\u0008'2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u0002060\u000f¢\u0006\u0002\u0008&H\u0087\u0008¢\u0006\u0002\u0010,\u001a\u0082\u0001\u00107\u001a\u0008\u0012\u0004\u0012\u0002080 \"\u0004\u0008\u0000\u0010\"*\u0008\u0012\u0004\u0012\u0002H\"0\u00132*\u0008\n\u0010#\u001a$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002080%0\u000f¢\u0006\u0002\u0008&¢\u0006\u0002\u0008'2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u0002080\u000f¢\u0006\u0002\u0008&H\u0087\u0008¢\u0006\u0002\u0010,\u001a¦\u0001\u00109\u001a\u0008\u0012\u0004\u0012\u0002H\u00140 \"\u0004\u0008\u0000\u0010\"\"\u0004\u0008\u0001\u0010\u0014\"\u0008\u0008\u0002\u0010:*\u00020;*\u0008\u0012\u0004\u0012\u0002H\"0\u00132\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H:0=2*\u0008\n\u0010#\u001a$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00140%0\u000f¢\u0006\u0002\u0008&¢\u0006\u0002\u0008'2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u0002H\u00140\u000f¢\u0006\u0002\u0008&H\u0087\u0008¢\u0006\u0002\u0010>\u001a\\\u0010?\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\u0008\u0000\u0010\"\"\u0004\u0008\u0001\u0010\u0014*\u0008\u0012\u0004\u0012\u0002H\"0\u00132\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182&\u0010@\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(A\u0012\u0004\u0012\u0002H\u00140\u000f¢\u0006\u0002\u0008&H\u0087\u0008¢\u0006\u0002\u0010B\u001aA\u0010C\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\u0008\u0000\u0010\"\"\u0004\u0008\u0001\u0010\u0014*\u0008\u0012\u0004\u0012\u0002H\"0\u00132\u0006\u0010D\u001a\u0002H\u00142\u0006\u0010\u001b\u001a\u0002H\u00142\u0006\u0010E\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010F\u001aa\u0010G\u001a\u0018\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H:0HR\u0008\u0012\u0004\u0012\u0002H\"0\u0013\"\u0004\u0008\u0000\u0010\"\"\u0004\u0008\u0001\u0010\u0014\"\u0008\u0008\u0002\u0010:*\u00020;*\u0008\u0012\u0004\u0012\u0002H\"0\u00132\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H:0=2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010I\u001am\u0010J\u001a\u0008\u0012\u0004\u0012\u0002H\u00140 \"\u0004\u0008\u0000\u0010\"\"\u0004\u0008\u0001\u0010\u0014\"\u0008\u0008\u0002\u0010:*\u00020;*\u0008\u0012\u0004\u0012\u0002H\"0\u00132\u0006\u0010K\u001a\u0002H\u00142\u0006\u0010L\u001a\u0002H\u00142\u000c\u0010M\u001a\u0008\u0012\u0004\u0012\u0002H\u00140%2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H:0=2\u0006\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010N\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0008\u001a\u00020\t8@X\u0080\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\n\u0010\u000b\"\u001e\u0010\u000e\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O", d2 = {"AnimationDebugDurationScale", "", "NoReset", "", "ResetAnimationSnap", "ResetAnimationSnapCurrent", "ResetAnimationSnapTarget", "ResetNoSnap", "SeekableStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getSeekableStateObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SeekableStateObserver$delegate", "Lkotlin/Lazy;", "SeekableTransitionStateTotalDurationChanged", "Lkotlin/Function1;", "Landroidx/compose/animation/core/SeekableTransitionState;", "", "rememberTransition", "Landroidx/compose/animation/core/Transition;", "T", "transitionState", "Landroidx/compose/animation/core/TransitionState;", "label", "", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "updateTransition", "targetState", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "animateDp", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/Dp;", "S", "transitionSpec", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloat", "animateInt", "animateIntOffset", "Landroidx/compose/ui/unit/IntOffset;", "animateIntSize", "Landroidx/compose/ui/unit/IntSize;", "animateOffset", "Landroidx/compose/ui/geometry/Offset;", "animateRect", "Landroidx/compose/ui/geometry/Rect;", "animateSize", "Landroidx/compose/ui/geometry/Size;", "animateValue", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "createChildTransition", "transformToChildState", "parentState", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "createChildTransitionInternal", "initialState", "childLabel", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "createDeferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createTransitionAnimation", "initialValue", "targetValue", "animationSpec", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransitionKt {

    public static final int AnimationDebugDurationScale = 1;
    private static final float NoReset = -1f;
    private static final float ResetAnimationSnap = -3f;
    private static final float ResetAnimationSnapCurrent = -4f;
    private static final float ResetAnimationSnapTarget = -5f;
    private static final float ResetNoSnap = -2f;
    private static final Lazy SeekableStateObserver$delegate;
    private static final Function1<androidx.compose.animation.core.SeekableTransitionState<?>, Unit> SeekableTransitionStateTotalDurationChanged;
    static {
        TransitionKt.SeekableTransitionStateTotalDurationChanged = (Function1)TransitionKt.SeekableTransitionStateTotalDurationChanged.1.INSTANCE;
        TransitionKt.SeekableStateObserver$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)TransitionKt.SeekableStateObserver.2.INSTANCE);
    }

    public static final Function1 access$getSeekableTransitionStateTotalDurationChanged$p() {
        return TransitionKt.SeekableTransitionStateTotalDurationChanged;
    }

    public static final <S> State<Dp> animateDp(androidx.compose.animation.core.Transition<S> $this$animateDp, Function3<? super androidx.compose.animation.core.Transition.Segment<S>, ? super Composer, ? super Integer, ? extends androidx.compose.animation.core.FiniteAnimationSpec<Dp>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Dp> targetValueByState, Composer $composer, int $changed, int i7) {
        androidx.compose.animation.core.TransitionKt.animateDp.1 iNSTANCE;
        int str2;
        String str;
        androidx.compose.animation.core.TransitionKt.animateDp.1 anon;
        final Object obj = targetValueByState;
        final Composer composer = $composer;
        final int i23 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 184732935, "CC(animateDp)P(2)1997@82158L75:Transition.kt#pdpnli");
        if (i7 & 1 != 0) {
            anon = iNSTANCE;
        } else {
            anon = transitionSpec;
        }
        str = i7 & 2 != 0 ? str2 : label;
        int i15 = 57344;
        androidx.compose.animation.core.Transition transition = $this$animateDp;
        final int i24 = i13;
        final int i25 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TransitionKt.createTransitionAnimation(transition, obj.invoke(transition.getCurrentState(), composer, Integer.valueOf(i19 &= 112)), obj.invoke(transition.getTargetState(), composer, Integer.valueOf(i21 &= 112)), (FiniteAnimationSpec)anon.invoke(transition.getSegment(), composer, Integer.valueOf(i26 &= 112)), VectorConvertersKt.getVectorConverter(Dp.Companion), str, composer, i17 |= i30);
    }

    public static final <S> State<Float> animateFloat(androidx.compose.animation.core.Transition<S> $this$animateFloat, Function3<? super androidx.compose.animation.core.Transition.Segment<S>, ? super Composer, ? super Integer, ? extends androidx.compose.animation.core.FiniteAnimationSpec<Float>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Float> targetValueByState, Composer $composer, int $changed, int i7) {
        androidx.compose.animation.core.TransitionKt.animateFloat.1 iNSTANCE;
        int str;
        String str2;
        androidx.compose.animation.core.TransitionKt.animateFloat.1 num;
        final Object obj = targetValueByState;
        final Composer composer = $composer;
        final int i23 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
        if (i7 & 1 != 0) {
            num = iNSTANCE;
        } else {
            num = transitionSpec;
        }
        str2 = i7 & 2 != 0 ? str : label;
        int i15 = 57344;
        androidx.compose.animation.core.Transition transition = $this$animateFloat;
        final int i24 = i13;
        final int i25 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TransitionKt.createTransitionAnimation(transition, obj.invoke(transition.getCurrentState(), composer, Integer.valueOf(i19 &= 112)), obj.invoke(transition.getTargetState(), composer, Integer.valueOf(i21 &= 112)), (FiniteAnimationSpec)num.invoke(transition.getSegment(), composer, Integer.valueOf(i26 &= 112)), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), str2, composer, i17 |= i30);
    }

    public static final <S> State<Integer> animateInt(androidx.compose.animation.core.Transition<S> $this$animateInt, Function3<? super androidx.compose.animation.core.Transition.Segment<S>, ? super Composer, ? super Integer, ? extends androidx.compose.animation.core.FiniteAnimationSpec<Integer>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Integer> targetValueByState, Composer $composer, int $changed, int i7) {
        androidx.compose.animation.core.TransitionKt.animateInt.1 iNSTANCE;
        int str2;
        String str;
        androidx.compose.animation.core.TransitionKt.animateInt.1 anon;
        final Object obj = targetValueByState;
        final Composer composer = $composer;
        final int i23 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 1318902782, "CC(animateInt)P(2)2121@89078L76:Transition.kt#pdpnli");
        if (i7 & 1 != 0) {
            anon = iNSTANCE;
        } else {
            anon = transitionSpec;
        }
        str = i7 & 2 != 0 ? str2 : label;
        int i15 = 57344;
        androidx.compose.animation.core.Transition transition = $this$animateInt;
        final int i24 = i13;
        final int i25 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TransitionKt.createTransitionAnimation(transition, obj.invoke(transition.getCurrentState(), composer, Integer.valueOf(i19 &= 112)), obj.invoke(transition.getTargetState(), composer, Integer.valueOf(i21 &= 112)), (FiniteAnimationSpec)anon.invoke(transition.getSegment(), composer, Integer.valueOf(i26 &= 112)), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), str, composer, i17 |= i30);
    }

    public static final <S> State<IntOffset> animateIntOffset(androidx.compose.animation.core.Transition<S> $this$animateIntOffset, Function3<? super androidx.compose.animation.core.Transition.Segment<S>, ? super Composer, ? super Integer, ? extends androidx.compose.animation.core.FiniteAnimationSpec<IntOffset>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, IntOffset> targetValueByState, Composer $composer, int $changed, int i7) {
        androidx.compose.animation.core.TransitionKt.animateIntOffset.1 iNSTANCE;
        int str2;
        String str;
        androidx.compose.animation.core.TransitionKt.animateIntOffset.1 anon;
        final Object obj = targetValueByState;
        final Composer composer = $composer;
        final int i23 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 776131825, "CC(animateIntOffset)P(2)2090@87375L82:Transition.kt#pdpnli");
        if (i7 & 1 != 0) {
            anon = iNSTANCE;
        } else {
            anon = transitionSpec;
        }
        str = i7 & 2 != 0 ? str2 : label;
        int i15 = 57344;
        androidx.compose.animation.core.Transition transition = $this$animateIntOffset;
        final int i24 = i13;
        final int i25 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TransitionKt.createTransitionAnimation(transition, obj.invoke(transition.getCurrentState(), composer, Integer.valueOf(i19 &= 112)), obj.invoke(transition.getTargetState(), composer, Integer.valueOf(i21 &= 112)), (FiniteAnimationSpec)anon.invoke(transition.getSegment(), composer, Integer.valueOf(i26 &= 112)), VectorConvertersKt.getVectorConverter(IntOffset.Companion), str, composer, i17 |= i30);
    }

    public static final <S> State<IntSize> animateIntSize(androidx.compose.animation.core.Transition<S> $this$animateIntSize, Function3<? super androidx.compose.animation.core.Transition.Segment<S>, ? super Composer, ? super Integer, ? extends androidx.compose.animation.core.FiniteAnimationSpec<IntSize>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, IntSize> targetValueByState, Composer $composer, int $changed, int i7) {
        androidx.compose.animation.core.TransitionKt.animateIntSize.1 iNSTANCE;
        int str2;
        String str;
        androidx.compose.animation.core.TransitionKt.animateIntSize.1 anon;
        final Object obj = targetValueByState;
        final Composer composer = $composer;
        final int i23 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -2104123233, "CC(animateIntSize)P(2)2151@90807L80:Transition.kt#pdpnli");
        if (i7 & 1 != 0) {
            anon = iNSTANCE;
        } else {
            anon = transitionSpec;
        }
        str = i7 & 2 != 0 ? str2 : label;
        int i15 = 57344;
        androidx.compose.animation.core.Transition transition = $this$animateIntSize;
        final int i24 = i13;
        final int i25 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TransitionKt.createTransitionAnimation(transition, obj.invoke(transition.getCurrentState(), composer, Integer.valueOf(i19 &= 112)), obj.invoke(transition.getTargetState(), composer, Integer.valueOf(i21 &= 112)), (FiniteAnimationSpec)anon.invoke(transition.getSegment(), composer, Integer.valueOf(i26 &= 112)), VectorConvertersKt.getVectorConverter(IntSize.Companion), str, composer, i17 |= i30);
    }

    public static final <S> State<Offset> animateOffset(androidx.compose.animation.core.Transition<S> $this$animateOffset, Function3<? super androidx.compose.animation.core.Transition.Segment<S>, ? super Composer, ? super Integer, ? extends androidx.compose.animation.core.FiniteAnimationSpec<Offset>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Offset> targetValueByState, Composer $composer, int $changed, int i7) {
        androidx.compose.animation.core.TransitionKt.animateOffset.1 iNSTANCE;
        int str;
        String str2;
        androidx.compose.animation.core.TransitionKt.animateOffset.1 anon;
        final Object obj = targetValueByState;
        final Composer composer = $composer;
        final int i23 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 2078477582, "CC(animateOffset)P(2)2028@83898L79:Transition.kt#pdpnli");
        if (i7 & 1 != 0) {
            anon = iNSTANCE;
        } else {
            anon = transitionSpec;
        }
        str2 = i7 & 2 != 0 ? str : label;
        int i15 = 57344;
        androidx.compose.animation.core.Transition transition = $this$animateOffset;
        final int i24 = i13;
        final int i25 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TransitionKt.createTransitionAnimation(transition, obj.invoke(transition.getCurrentState(), composer, Integer.valueOf(i19 &= 112)), obj.invoke(transition.getTargetState(), composer, Integer.valueOf(i21 &= 112)), (FiniteAnimationSpec)anon.invoke(transition.getSegment(), composer, Integer.valueOf(i26 &= 112)), VectorConvertersKt.getVectorConverter(Offset.Companion), str2, composer, i17 |= i30);
    }

    public static final <S> State<Rect> animateRect(androidx.compose.animation.core.Transition<S> $this$animateRect, Function3<? super androidx.compose.animation.core.Transition.Segment<S>, ? super Composer, ? super Integer, ? extends androidx.compose.animation.core.FiniteAnimationSpec<Rect>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Rect> targetValueByState, Composer $composer, int $changed, int i7) {
        androidx.compose.animation.core.TransitionKt.animateRect.1 iNSTANCE;
        int str;
        String str2;
        androidx.compose.animation.core.TransitionKt.animateRect.1 anon;
        final Object obj = targetValueByState;
        final Composer composer = $composer;
        final int i23 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 1496278239, "CC(animateRect)P(2)2181@92533L77:Transition.kt#pdpnli");
        if (i7 & 1 != 0) {
            anon = iNSTANCE;
        } else {
            anon = transitionSpec;
        }
        str2 = i7 & 2 != 0 ? str : label;
        int i15 = 57344;
        androidx.compose.animation.core.Transition transition = $this$animateRect;
        final int i24 = i13;
        final int i25 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TransitionKt.createTransitionAnimation(transition, obj.invoke(transition.getCurrentState(), composer, Integer.valueOf(i19 &= 112)), obj.invoke(transition.getTargetState(), composer, Integer.valueOf(i21 &= 112)), (FiniteAnimationSpec)anon.invoke(transition.getSegment(), composer, Integer.valueOf(i26 &= 112)), VectorConvertersKt.getVectorConverter(Rect.Companion), str2, composer, i17 |= i30);
    }

    public static final <S> State<Size> animateSize(androidx.compose.animation.core.Transition<S> $this$animateSize, Function3<? super androidx.compose.animation.core.Transition.Segment<S>, ? super Composer, ? super Integer, ? extends androidx.compose.animation.core.FiniteAnimationSpec<Size>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Size> targetValueByState, Composer $composer, int $changed, int i7) {
        androidx.compose.animation.core.TransitionKt.animateSize.1 iNSTANCE;
        int str;
        String str2;
        androidx.compose.animation.core.TransitionKt.animateSize.1 anon;
        final Object obj = targetValueByState;
        final Composer composer = $composer;
        final int i23 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -802210820, "CC(animateSize)P(2)2059@85627L77:Transition.kt#pdpnli");
        if (i7 & 1 != 0) {
            anon = iNSTANCE;
        } else {
            anon = transitionSpec;
        }
        str2 = i7 & 2 != 0 ? str : label;
        int i15 = 57344;
        androidx.compose.animation.core.Transition transition = $this$animateSize;
        final int i24 = i13;
        final int i25 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TransitionKt.createTransitionAnimation(transition, obj.invoke(transition.getCurrentState(), composer, Integer.valueOf(i19 &= 112)), obj.invoke(transition.getTargetState(), composer, Integer.valueOf(i21 &= 112)), (FiniteAnimationSpec)anon.invoke(transition.getSegment(), composer, Integer.valueOf(i26 &= 112)), VectorConvertersKt.getVectorConverter(Size.Companion), str2, composer, i17 |= i30);
    }

    public static final <S, T, V extends androidx.compose.animation.core.AnimationVector> State<T> animateValue(androidx.compose.animation.core.Transition<S> $this$animateValue, androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, Function3<? super androidx.compose.animation.core.Transition.Segment<S>, ? super Composer, ? super Integer, ? extends androidx.compose.animation.core.FiniteAnimationSpec<T>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, ? extends T> targetValueByState, Composer $composer, int $changed, int i8) {
        int iNSTANCE;
        String str;
        androidx.compose.animation.core.TransitionKt.animateValue.1 obj11;
        String obj12;
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        if (i8 & 2 != 0) {
            obj11 = iNSTANCE;
        }
        str = i8 & 4 != 0 ? obj12 : label;
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TransitionKt.createTransitionAnimation($this$animateValue, targetValueByState.invoke($this$animateValue.getCurrentState(), $composer, Integer.valueOf(i4 &= 112)), targetValueByState.invoke($this$animateValue.getTargetState(), $composer, Integer.valueOf(i6 &= 112)), (FiniteAnimationSpec)obj11.invoke($this$animateValue.getSegment(), $composer, Integer.valueOf(i9 &= 112)), typeConverter, str, $composer, obj12 | i14);
    }

    public static final <S, T> androidx.compose.animation.core.Transition<T> createChildTransition(androidx.compose.animation.core.Transition<S> $this$createChildTransition, String label, Function3<? super S, ? super Composer, ? super Integer, ? extends T> transformToChildState, Composer $composer, int $changed, int i6) {
        int i;
        Object empty;
        Object $i$a$CacheTransitionKt$createChildTransition$initialParentState$1;
        String str;
        String obj9;
        Object obj13;
        final int i2 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 1215497572, "CC(createChildTransition)1811@74006L36,1812@74066L74,1813@74163L39,1814@74214L63:Transition.kt#pdpnli");
        str = i6 &= i != 0 ? obj9 : label;
        ComposerKt.sourceInformationMarkerStart($composer, 272023029, "CC(remember):Transition.kt#9igjgp");
        obj13 = 4;
        if (obj9 ^= 6 > obj13) {
            if (!$composer.changed($this$createChildTransition)) {
                if ($changed & 6 == obj13) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        obj9 = $composer;
        obj13 = 0;
        Object rememberedValue = obj9.rememberedValue();
        int i11 = 0;
        if (i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i12 = 0;
                obj9.updateRememberedValue($this$createChildTransition.getCurrentState());
            } else {
                $i$a$CacheTransitionKt$createChildTransition$initialParentState$1 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if ($this$createChildTransition.isSeeking()) {
            obj13 = $this$createChildTransition.getCurrentState();
        } else {
            obj13 = obj9;
        }
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerEnd(composer);
        return TransitionKt.createChildTransitionInternal($this$createChildTransition, transformToChildState.invoke(obj13, $composer, Integer.valueOf(i4 &= 112)), transformToChildState.invoke($this$createChildTransition.getTargetState(), $composer, Integer.valueOf(i7 &= 112)), str, composer, obj13 | i10);
    }

    public static final <S, T> androidx.compose.animation.core.Transition<T> createChildTransitionInternal(androidx.compose.animation.core.Transition<S> $this$createChildTransitionInternal, T initialState, T targetState, String childLabel, Composer $composer, int $changed) {
        int changed;
        int i;
        boolean traceInProgress;
        int changed2;
        long lastSeekedTimeNanos$animation_core_release;
        String mutableTransitionState;
        int i2;
        int i3;
        String string;
        String str;
        Object rememberedValue;
        Object anon;
        Object empty;
        Object transition;
        final Object obj = $this$createChildTransitionInternal;
        final Object obj2 = initialState;
        final Object obj3 = targetState;
        final Composer composer = $composer;
        final int i4 = $changed;
        int i5 = -198307638;
        ComposerKt.sourceInformationMarkerStart(composer, i5, "C(createChildTransitionInternal)P(1,2)1824@74477L116,1828@74628L112,1828@74599L141:Transition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, i4, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:1823)");
        }
        String str3 = "CC(remember):Transition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, 1039286210, str3);
        int i13 = 4;
        if (i7 ^= 6 > i13) {
            if (!composer.changed(obj)) {
                i = i4 & 6 == i13 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer3 = $composer;
        int i14 = 0;
        rememberedValue = composer3.rememberedValue();
        int i16 = 0;
        if (i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                mutableTransitionState = new MutableTransitionState(obj2);
                StringBuilder stringBuilder = new StringBuilder();
                transition = new Transition((TransitionState)mutableTransitionState, obj, stringBuilder.append(obj.getLabel()).append(" > ").append(childLabel).toString());
                composer3.updateRememberedValue(transition);
            } else {
                str = childLabel;
                transition = rememberedValue;
            }
        } else {
        }
        androidx.compose.animation.core.Transition invalid$iv = transition;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1039291038, str3);
        if (i8 ^= 6 > 4) {
            if (!composer.changed(obj)) {
                i2 = i4 & 6 == 4 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i12 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        int i15 = 0;
        if (changed3 |= i2 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue = 0;
                anon = new TransitionKt.createChildTransitionInternal.1.1(obj, invalid$iv);
                composer2.updateRememberedValue((Function1)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(invalid$iv, (Function1)anon, composer, 0);
        if (obj.isSeeking()) {
            invalid$iv.seek(obj2, obj3, obj.getLastSeekedTimeNanos$animation_core_release());
        } else {
            invalid$iv.updateTarget$animation_core_release(obj3);
            invalid$iv.setSeeking$animation_core_release(false);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return invalid$iv;
    }

    public static final <S, T, V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.Transition.DeferredAnimation<S, T, V> createDeferredAnimation(androidx.compose.animation.core.Transition<S> $this$createDeferredAnimation, androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, String label, Composer $composer, int $changed, int i6) {
        boolean changed;
        String str;
        int i;
        Object rememberedValue;
        Object anon;
        Object empty;
        Object deferredAnimation;
        String obj12;
        boolean obj15;
        int i2 = -1714122528;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(createDeferredAnimation)P(1)1778@72502L58,1779@72592L75,1779@72565L102:Transition.kt#pdpnli");
        if (i6 &= 2 != 0) {
            obj12 = "DeferredAnimation";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:1777)");
        }
        String str2 = "CC(remember):Transition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, -1378238497, str2);
        final int i5 = 0;
        int i7 = 4;
        if (obj15 ^= 6 > i7) {
            if (!$composer.changed($this$createDeferredAnimation)) {
                obj15 = $changed & 6 == i7 ? i : i5;
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i10 = 0;
        rememberedValue = composer2.rememberedValue();
        int i12 = 0;
        if (obj15 == null) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                deferredAnimation = new Transition.DeferredAnimation($this$createDeferredAnimation, typeConverter, obj12);
                composer2.updateRememberedValue(deferredAnimation);
            } else {
                deferredAnimation = rememberedValue;
            }
        } else {
        }
        obj15 = deferredAnimation;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -1378235600, str2);
        if (i3 ^= 6 > i7) {
            if (!$composer.changed($this$createDeferredAnimation)) {
                if ($changed & 6 == i7) {
                } else {
                    i = i5;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i8 = 0;
        Object rememberedValue2 = composer.rememberedValue();
        int i11 = 0;
        if (changedInstance |= i == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue = 0;
                anon = new TransitionKt.createDeferredAnimation.1.1($this$createDeferredAnimation, obj15);
                composer.updateRememberedValue((Function1)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect(obj15, (Function1)anon, $composer, i5);
        if ($this$createDeferredAnimation.isSeeking()) {
            obj15.setupSeeking$animation_core_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return obj15;
    }

    public static final <S, T, V extends androidx.compose.animation.core.AnimationVector> State<T> createTransitionAnimation(androidx.compose.animation.core.Transition<S> $this$createTransitionAnimation, T initialValue, T targetValue, androidx.compose.animation.core.FiniteAnimationSpec<T> animationSpec, androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, String label, Composer $composer, int $changed) {
        int changed;
        int i;
        Object it$iv;
        boolean it$iv2;
        Object obj;
        String zeroVectorFrom;
        int changed2;
        androidx.compose.animation.core.TwoWayConverter twoWayConverter;
        String str;
        int i3;
        Object empty;
        Object anon;
        int i2;
        Object obj2;
        final Object obj3 = $this$createTransitionAnimation;
        final Object obj5 = targetValue;
        final androidx.compose.animation.core.FiniteAnimationSpec finiteAnimationSpec = animationSpec;
        final Composer composer2 = $composer;
        final int i11 = $changed;
        int i4 = -304821198;
        ComposerKt.sourceInformationMarkerStart(composer2, i4, "C(createTransitionAnimation)P(1,3!1,4)1899@77543L499,1922@78426L128,1922@78388L166:Transition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, i11, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:1898)");
        }
        String str3 = "CC(remember):Transition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer2, 1397685378, str3);
        final int i13 = 0;
        empty = 4;
        if (i6 ^= 6 > empty) {
            if (!composer2.changed(obj3)) {
                i = i11 & 6 == empty ? i3 : i13;
            } else {
            }
        } else {
        }
        final Composer composer3 = $composer;
        final int i15 = 0;
        it$iv = composer3.rememberedValue();
        final int i16 = 0;
        if (i == 0) {
            if (it$iv == Composer.Companion.getEmpty()) {
                i2 = 0;
                twoWayConverter = typeConverter;
                obj2 = obj4;
                it$iv = new Transition.TransitionAnimationState(obj3, initialValue, AnimationStateKt.createZeroVectorFrom(twoWayConverter, obj5), twoWayConverter, label);
                composer3.updateRememberedValue(it$iv);
            } else {
                obj2 = it$iv;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (obj3.isSeeking()) {
            (Transition.TransitionAnimationState)it$iv.updateInitialAndTargetValue$animation_core_release(initialValue, obj5, finiteAnimationSpec);
        } else {
            obj = initialValue;
            it$iv.updateTargetValue$animation_core_release(obj5, finiteAnimationSpec);
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 1397713263, str3);
        if (i8 ^= 6 > empty) {
            if (!composer2.changed(obj3)) {
                if (i11 & 6 == empty) {
                } else {
                    i3 = i13;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i10 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (changed3 |= i3 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new TransitionKt.createTransitionAnimation.1.1(obj3, it$iv);
                composer.updateRememberedValue((Function1)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        EffectsKt.DisposableEffect(it$iv, (Function1)anon, composer2, i13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (State)it$iv;
    }

    public static final SnapshotStateObserver getSeekableStateObserver() {
        return (SnapshotStateObserver)TransitionKt.SeekableStateObserver$delegate.getValue();
    }

    public static final <T> androidx.compose.animation.core.Transition<T> rememberTransition(androidx.compose.animation.core.TransitionState<T> transitionState, String label, Composer $composer, int $changed, int i5) {
        boolean changed;
        int i4;
        int label2;
        boolean traceInProgress;
        String str;
        int i2;
        int i;
        Object targetState;
        int i3;
        boolean currentState;
        int targetState2;
        Object rememberedValue2;
        Object anon2;
        int changed2;
        int rememberedValue;
        Object empty;
        Object transition;
        Object anon;
        final Object obj = transitionState;
        final Composer composer = $composer;
        final int i6 = $changed;
        int i7 = 1643203617;
        ComposerKt.sourceInformationMarkerStart(composer, i7, "C(rememberTransition)P(1)819@34163L94,834@34887L190,834@34858L219:Transition.kt#pdpnli");
        label2 = i5 & 2 != 0 ? 0 : label;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i7, i6, -1, "androidx.compose.animation.core.rememberTransition (Transition.kt:818)");
        }
        String str3 = "CC(remember):Transition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, 587419172, str3);
        int i13 = 4;
        if (i9 ^= 6 > i13) {
            if (!composer.changed(obj)) {
                i4 = i6 & 6 == i13 ? i : 0;
            } else {
            }
        } else {
        }
        Composer composer3 = $composer;
        targetState2 = 0;
        rememberedValue2 = composer3.rememberedValue();
        rememberedValue = 0;
        if (i4 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                empty = 0;
                transition = new Transition(obj, label2);
                composer3.updateRememberedValue(transition);
            } else {
                transition = rememberedValue2;
            }
        } else {
        }
        Object invalid$iv = transition;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (obj instanceof SeekableTransitionState) {
            composer.startReplaceGroup(1030282692);
            ComposerKt.sourceInformation(composer, "823@34394L382,823@34320L456");
            ComposerKt.sourceInformationMarkerStart(composer, 587426852, str3);
            if (i19 ^= 6 > i13) {
                if (!composer.changed(obj)) {
                    if (i6 & 6 == i13) {
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
            targetState = $composer;
            rememberedValue2 = 0;
            rememberedValue = targetState.rememberedValue();
            empty = 0;
            if (i == 0) {
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    transition = 0;
                    anon = new TransitionKt.rememberTransition.1.1(obj, 0);
                    targetState.updateRememberedValue((Function2)anon);
                } else {
                    anon = rememberedValue;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(obj.getCurrentState(), obj.getTargetState(), (Function2)anon, composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1030744251);
            ComposerKt.sourceInformation(composer, "832@34809L38");
            (Transition)invalid$iv.animateTo$animation_core_release(obj.getTargetState(), composer, 0);
            composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerStart(composer, 587442436, str3);
        Composer composer2 = $composer;
        int i14 = 0;
        Object rememberedValue3 = composer2.rememberedValue();
        int i16 = 0;
        if (!composer.changed(invalid$iv)) {
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                targetState2 = 0;
                anon2 = new TransitionKt.rememberTransition.2.1(invalid$iv);
                composer2.updateRememberedValue((Function1)anon2);
            } else {
                anon2 = rememberedValue3;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(invalid$iv, (Function1)anon2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return invalid$iv;
    }

    @Deprecated(message = "Use rememberTransition() instead", replaceWith = @ReplaceWith(...))
    public static final <T> androidx.compose.animation.core.Transition<T> updateTransition(androidx.compose.animation.core.MutableTransitionState<T> transitionState, String label, Composer $composer, int $changed, int i5) {
        String str;
        int obj3;
        boolean obj6;
        int i = 882913843;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(updateTransition)P(1)873@36534L32:Transition.kt#pdpnli");
        if (i5 &= 2 != 0) {
            obj3 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:871)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TransitionKt.rememberTransition((TransitionState)transitionState, obj3, $composer, i2 |= i4, 0);
    }

    public static final <T> androidx.compose.animation.core.Transition<T> updateTransition(T targetState, String label, Composer $composer, int $changed, int i5) {
        String str;
        Object empty2;
        Object empty;
        Object transition;
        Object anon;
        int obj8;
        boolean obj11;
        int i = 2029166765;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(updateTransition)P(1)90@3746L51,91@3813L22,92@3869L190,92@3840L219:Transition.kt#pdpnli");
        if (i5 &= 2 != 0) {
            obj8 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:89)");
        }
        String str2 = "CC(remember):Transition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, -659290859, str2);
        obj11 = 0;
        Composer composer = $composer;
        int i9 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty2 = 0;
            transition = new Transition(targetState, obj8);
            composer.updateRememberedValue(transition);
        } else {
            transition = rememberedValue;
        }
        obj11 = transition;
        ComposerKt.sourceInformationMarkerEnd($composer);
        (Transition)obj11.animateTo$animation_core_release(targetState, $composer, i6 |= i10);
        ComposerKt.sourceInformationMarkerStart($composer, -659286784, str2);
        int i2 = 0;
        Composer composer2 = $composer;
        int i11 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        int i13 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            empty = 0;
            anon = new TransitionKt.updateTransition.1.1(obj11);
            composer2.updateRememberedValue((Function1)anon);
        } else {
            anon = rememberedValue2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect(obj11, (Function1)anon, $composer, 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return obj11;
    }
}
