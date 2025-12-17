package androidx.compose.foundation.gestures;

import androidx.collection.MutableObjectFloatMap;
import androidx.collection.ObjectFloatMap;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.FloatRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a7\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0008\u0008\u0000\u0010\u0007*\u00020\u00082\u001d\u0010\t\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00070\n\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\u0002\u0008\u000cH\u0007\u001a\u0017\u0010\r\u001a\u00020\u000b2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fH\u0082\u0008\u001a\u0014\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0012\"\u0004\u0008\u0000\u0010\u0007H\u0002\u001aF\u0010\u0013\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u000f2\"\u0010\u0016\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0017H\u0082@¢\u0006\u0002\u0010\u0019\u001aT\u0010\u001a\u001a\u00020\u001b\"\u0004\u0008\u0000\u0010\u0007*\u00020\u001b2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00032\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0008\u0002\u0010%\u001a\u00020\u0003H\u0007\u001a\\\u0010\u001a\u001a\u00020\u001b\"\u0004\u0008\u0000\u0010\u0007*\u00020\u001b2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00032\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0008\u0002\u0010%\u001a\u00020\u0003H\u0007\u001a&\u0010'\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010(\u001a\u0002H\u0007H\u0087@¢\u0006\u0002\u0010)\u001aD\u0010'\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u000c\u0010.\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010/\u001a\u0002H\u0007H\u0082@¢\u0006\u0002\u00100\u001a.\u00101\u001a\u00020+\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010(\u001a\u0002H\u00072\u0006\u0010*\u001a\u00020+H\u0087@¢\u0006\u0002\u00102\u001a\u0014\u00103\u001a\u00020+*\u00020+2\u0006\u00104\u001a\u00020+H\u0002\u001a\u0018\u00105\u001a\u00020+\"\u0004\u0008\u0000\u00106*\u0008\u0012\u0004\u0012\u0002H607H\u0002\u001a\u0018\u00108\u001a\u00020+\"\u0004\u0008\u0000\u00106*\u0008\u0012\u0004\u0012\u0002H607H\u0002\u001a&\u00109\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u001d2\u0006\u0010(\u001a\u0002H\u0007H\u0087@¢\u0006\u0002\u0010)\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006:", d2 = {"AlwaysDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "DEBUG", "DraggableAnchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "T", "", "builder", "Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", "", "Lkotlin/ExtensionFunctionType;", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "emptyDraggableAnchors", "Landroidx/compose/foundation/gestures/MapDraggableAnchors;", "restartable", "I", "inputs", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDraggable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "startDragImmediately", "reverseDirection", "animateTo", "targetValue", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "velocity", "", "anchoredDragScope", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "latestTarget", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;FLandroidx/compose/foundation/gestures/AnchoredDragScope;Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToWithDecay", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", "target", "maxValueOrNaN", "K", "Landroidx/collection/ObjectFloatMap;", "minValueOrNaN", "snapTo", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnchoredDraggableKt {

    private static final Function1<PointerInputChange, Boolean> AlwaysDrag = null;
    private static final boolean DEBUG = false;
    static {
        AnchoredDraggableKt.AlwaysDrag = (Function1)AnchoredDraggableKt.AlwaysDrag.1.INSTANCE;
    }

    public static final <T> androidx.compose.foundation.gestures.DraggableAnchors<T> DraggableAnchors(Function1<? super androidx.compose.foundation.gestures.DraggableAnchorsConfig<T>, Unit> builder) {
        DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
        builder.invoke(draggableAnchorsConfig);
        MapDraggableAnchors mapDraggableAnchors = new MapDraggableAnchors((ObjectFloatMap)draggableAnchorsConfig.getAnchors$foundation_release());
        return (DraggableAnchors)mapDraggableAnchors;
    }

    public static final Object access$animateTo(androidx.compose.foundation.gestures.AnchoredDraggableState $receiver, float velocity, androidx.compose.foundation.gestures.AnchoredDragScope anchoredDragScope, androidx.compose.foundation.gestures.DraggableAnchors anchors, Object latestTarget, Continuation $completion) {
        return AnchoredDraggableKt.animateTo($receiver, velocity, anchoredDragScope, anchors, latestTarget, $completion);
    }

    public static final float access$coerceToTarget(float $receiver, float target) {
        return AnchoredDraggableKt.coerceToTarget($receiver, target);
    }

    public static final androidx.compose.foundation.gestures.MapDraggableAnchors access$emptyDraggableAnchors() {
        return AnchoredDraggableKt.emptyDraggableAnchors();
    }

    public static final Function1 access$getAlwaysDrag$p() {
        return AnchoredDraggableKt.AlwaysDrag;
    }

    public static final float access$maxValueOrNaN(ObjectFloatMap $receiver) {
        return AnchoredDraggableKt.maxValueOrNaN($receiver);
    }

    public static final float access$minValueOrNaN(ObjectFloatMap $receiver) {
        return AnchoredDraggableKt.minValueOrNaN($receiver);
    }

    public static final Object access$restartable(Function0 inputs, Function2 block, Continuation $completion) {
        return AnchoredDraggableKt.restartable(inputs, block, $completion);
    }

    public static final <T> Modifier anchoredDraggable(Modifier $this$anchoredDraggable, androidx.compose.foundation.gestures.AnchoredDraggableState<T> state, androidx.compose.foundation.gestures.Orientation orientation, boolean enabled, MutableInteractionSource interactionSource, OverscrollEffect overscrollEffect, boolean startDragImmediately) {
        AnchoredDraggableElement anchoredDraggableElement = new AnchoredDraggableElement(state, orientation, enabled, 0, interactionSource, startDragImmediately, overscrollEffect);
        return $this$anchoredDraggable.then((Modifier)anchoredDraggableElement);
    }

    public static final <T> Modifier anchoredDraggable(Modifier $this$anchoredDraggable, androidx.compose.foundation.gestures.AnchoredDraggableState<T> state, boolean reverseDirection, androidx.compose.foundation.gestures.Orientation orientation, boolean enabled, MutableInteractionSource interactionSource, OverscrollEffect overscrollEffect, boolean startDragImmediately) {
        AnchoredDraggableElement anchoredDraggableElement = new AnchoredDraggableElement(state, orientation, enabled, Boolean.valueOf(reverseDirection), interactionSource, startDragImmediately, overscrollEffect);
        return $this$anchoredDraggable.then((Modifier)anchoredDraggableElement);
    }

    public static Modifier anchoredDraggable$default(Modifier modifier, androidx.compose.foundation.gestures.AnchoredDraggableState anchoredDraggableState2, androidx.compose.foundation.gestures.Orientation orientation3, boolean z4, MutableInteractionSource mutableInteractionSource5, OverscrollEffect overscrollEffect6, boolean z7, int i8, Object object9) {
        int i2;
        int i;
        int i3;
        boolean z;
        int obj10;
        boolean obj13;
        i2 = i8 & 4 != 0 ? obj10 : z4;
        int obj15 = 0;
        i = i8 & 8 != 0 ? obj15 : mutableInteractionSource5;
        i3 = i8 & 16 != 0 ? obj15 : overscrollEffect6;
        if (i8 & 32 != 0) {
            z = obj13;
        } else {
            z = z7;
        }
        return AnchoredDraggableKt.anchoredDraggable(modifier, anchoredDraggableState2, orientation3, i2, i, i3, z);
    }

    public static Modifier anchoredDraggable$default(Modifier modifier, androidx.compose.foundation.gestures.AnchoredDraggableState anchoredDraggableState2, boolean z3, androidx.compose.foundation.gestures.Orientation orientation4, boolean z5, MutableInteractionSource mutableInteractionSource6, OverscrollEffect overscrollEffect7, boolean z8, int i9, Object object10) {
        int i3;
        int i2;
        int i;
        boolean z;
        int obj12;
        i3 = i9 & 8 != 0 ? obj12 : z5;
        int i5 = 0;
        i2 = i9 & 16 != 0 ? i5 : mutableInteractionSource6;
        i = i9 & 32 != 0 ? i5 : overscrollEffect7;
        if (i9 & 64 != 0) {
            z = obj12;
        } else {
            z = z8;
        }
        return AnchoredDraggableKt.anchoredDraggable(modifier, anchoredDraggableState2, z3, orientation4, i3, i2, i, z);
    }

    private static final <T> Object animateTo(androidx.compose.foundation.gestures.AnchoredDraggableState<T> $this$animateTo, float velocity, androidx.compose.foundation.gestures.AnchoredDragScope anchoredDragScope, androidx.compose.foundation.gestures.DraggableAnchors<T> anchors, T latestTarget, Continuation<? super Unit> $completion) {
        float offset;
        boolean $i$f$debugLog;
        float velocity2;
        androidx.compose.animation.core.AnimationSpec snapAnimationSpec;
        androidx.compose.foundation.gestures.AnchoredDraggableKt.animateTo.2.2 anon;
        Continuation continuation;
        Object obj10;
        Object obj14;
        final int i = 0;
        final float positionOf = anchors.positionOf(latestTarget);
        Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef num = floatRef;
        if (Float.isNaN($this$animateTo.getOffset())) {
            offset = 0;
        } else {
            offset = $this$animateTo.getOffset();
        }
        num.element = offset;
        if (!Float.isNaN(positionOf)) {
            $i$f$debugLog = Float.compare(element, positionOf) == 0 ? 1 : 0;
            if ($i$f$debugLog == 0) {
                int i2 = 0;
                AnchoredDraggableKt.animateTo.2.2 anon2 = new AnchoredDraggableKt.animateTo.2.2(anchoredDragScope, num);
                obj10 = SuspendAnimationKt.animate(num.element, positionOf, velocity, $this$animateTo.getSnapAnimationSpec(), (Function2)anon2, $completion);
                if (obj10 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return obj10;
                }
            } else {
                velocity2 = velocity;
                continuation = $completion;
            }
        } else {
        }
        return Unit.INSTANCE;
    }

    public static final <T> Object animateTo(androidx.compose.foundation.gestures.AnchoredDraggableState<T> $this$animateTo, T targetValue, Continuation<? super Unit> $completion) {
        AnchoredDraggableKt.animateTo.4 anon = new AnchoredDraggableKt.animateTo.4($this$animateTo, 0);
        Object obj9 = AnchoredDraggableState.anchoredDrag$default($this$animateTo, targetValue, 0, (Function4)anon, $completion, 2, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    public static final <T> Object animateToWithDecay(androidx.compose.foundation.gestures.AnchoredDraggableState<T> anchoredDraggableState, T t2, float f3, Continuation<? super Float> continuation4) {
        boolean anon;
        int i3;
        androidx.compose.foundation.gestures.AnchoredDraggableState label;
        int i5;
        int i;
        androidx.compose.foundation.gestures.AnchoredDraggableKt.animateToWithDecay.2 anon2;
        int i4;
        int i2;
        float obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        anon = continuation4;
        i5 = Integer.MIN_VALUE;
        if (continuation4 instanceof AnchoredDraggableKt.animateToWithDecay.1 && label2 &= i5 != 0) {
            anon = continuation4;
            i5 = Integer.MIN_VALUE;
            if (label2 &= i5 != 0) {
                anon.label = obj11 -= i5;
            } else {
                anon = new AnchoredDraggableKt.animateToWithDecay.1(continuation4);
            }
        } else {
        }
        final androidx.compose.foundation.gestures.AnchoredDraggableKt.animateToWithDecay.1 anon3 = anon;
        obj11 = anon3.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                label = anchoredDraggableState;
                obj8 = f3;
                obj9 = new Ref.FloatRef();
                obj9.element = obj8;
                i = 0;
                obj10 = new AnchoredDraggableKt.animateToWithDecay.2(label, obj8, obj9, i);
                anon3.L$0 = obj9;
                anon3.F$0 = obj8;
                anon3.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                obj8 = anon3.F$0;
                obj9 = anon3.L$0;
                ResultKt.throwOnFailure(obj11);
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        return Boxing.boxFloat(obj8 - obj10);
    }

    private static final float coerceToTarget(float $this$coerceToTarget, float target) {
        float coerceAtLeast;
        int i;
        int i2 = 0;
        i = Float.compare(target, i2) == 0 ? 1 : 0;
        if (i != 0) {
            return i2;
        }
        if (Float.compare(target, i2) > 0) {
            coerceAtLeast = RangesKt.coerceAtMost($this$coerceToTarget, target);
        } else {
            coerceAtLeast = RangesKt.coerceAtLeast($this$coerceToTarget, target);
        }
        return coerceAtLeast;
    }

    private static final void debugLog(Function0<String> generateMsg) {
        final int i = 0;
    }

    private static final <T> androidx.compose.foundation.gestures.MapDraggableAnchors<T> emptyDraggableAnchors() {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, 0);
        MapDraggableAnchors mapDraggableAnchors = new MapDraggableAnchors((ObjectFloatMap)mutableObjectFloatMap);
        return mapDraggableAnchors;
    }

    private static final <K> float maxValueOrNaN(ObjectFloatMap<K> $this$maxValueOrNaN) {
        int maxValue;
        int cmp;
        Object obj;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i;
        int i2;
        Object this_$iv;
        long l;
        int i3;
        int i4;
        int cmp2;
        if ($this$maxValueOrNaN.getSize() == 1) {
            return 2143289344;
        }
        int i6 = 0;
        maxValue = -8388608;
        obj = $this$maxValueOrNaN;
        final int i14 = 0;
        final int i15 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i16) {
        } else {
            this_$iv = obj;
        }
        return maxValue;
    }

    private static final <K> float minValueOrNaN(ObjectFloatMap<K> $this$minValueOrNaN) {
        int minValue;
        int cmp2;
        Object obj;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i3;
        int i;
        Object this_$iv;
        long l;
        int i2;
        int i4;
        int cmp;
        if ($this$minValueOrNaN.getSize() == 1) {
            return 2143289344;
        }
        int i6 = 0;
        minValue = 2139095040;
        obj = $this$minValueOrNaN;
        final int i14 = 0;
        final int i15 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i16) {
        } else {
            this_$iv = obj;
        }
        return minValue;
    }

    private static final <I> Object restartable(Function0<? extends I> function0, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation3) {
        boolean anon;
        int i3;
        int i2;
        int coroutineScope;
        int i;
        Throwable obj4;
        Object obj6;
        anon = continuation3;
        i2 = Integer.MIN_VALUE;
        if (continuation3 instanceof AnchoredDraggableKt.restartable.1 && label &= i2 != 0) {
            anon = continuation3;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj6 -= i2;
            } else {
                anon = new AnchoredDraggableKt.restartable.1(continuation3);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (coroutineScope) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                AnchoredDraggableKt.restartable.2 anon2 = new AnchoredDraggableKt.restartable.2(function0, function22, 0);
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj6);
                break;
            default:
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
        }
        return Unit.INSTANCE;
    }

    public static final <T> Object snapTo(androidx.compose.foundation.gestures.AnchoredDraggableState<T> $this$snapTo, T targetValue, Continuation<? super Unit> $completion) {
        AnchoredDraggableKt.snapTo.2 anon = new AnchoredDraggableKt.snapTo.2(0);
        Object obj9 = AnchoredDraggableState.anchoredDrag$default($this$snapTo, targetValue, 0, (Function4)anon, $completion, 2, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }
}
