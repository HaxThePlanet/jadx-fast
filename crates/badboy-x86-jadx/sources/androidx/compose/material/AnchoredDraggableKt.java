package androidx.compose.material;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a7\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0008\u0008H\u0001\u001a\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\u0008\u0000\u0010\u0002H\u0002\u001aF\u0010\u000b\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u000c2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u000c0\u000e2\"\u0010\u000f\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u000c\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0010H\u0082@¢\u0006\u0002\u0010\u0012\u001aR\u0010\u0013\u001a\u00020\u0014\"\u0004\u0008\u0000\u0010\u0002*\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001a2\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001aH\u0001\u001a0\u0010\u001f\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010 \u001a\u0002H\u00022\u0008\u0008\u0002\u0010!\u001a\u00020\"H\u0081@¢\u0006\u0002\u0010#\u001ar\u0010$\u001a\u00020\u0014\"\u0004\u0008\u0000\u0010\u0002*\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182H\u0010%\u001aD\u0012\u0013\u0012\u00110&¢\u0006\u000c\u0008'\u0012\u0008\u0008(\u0012\u0004\u0008\u0008()\u0012\u0013\u0012\u00110*¢\u0006\u000c\u0008'\u0012\u0008\u0008(\u0012\u0004\u0008\u0008(+\u0012\u0016\u0012\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u0002H\u00020,0\u0010H\u0001\u001a&\u0010-\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010 \u001a\u0002H\u0002H\u0081@¢\u0006\u0002\u0010.¨\u0006/", d2 = {"DraggableAnchors", "Landroidx/compose/material/DraggableAnchors;", "T", "", "builder", "Lkotlin/Function1;", "Landroidx/compose/material/DraggableAnchorsConfig;", "", "Lkotlin/ExtensionFunctionType;", "emptyDraggableAnchors", "Landroidx/compose/material/MapDraggableAnchors;", "restartable", "I", "inputs", "Lkotlin/Function0;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDraggable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "animateTo", "targetValue", "velocity", "", "(Landroidx/compose/material/AnchoredDraggableState;Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "draggableAnchors", "anchors", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "size", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Lkotlin/Pair;", "snapTo", "(Landroidx/compose/material/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnchoredDraggableKt {
    public static final <T> androidx.compose.material.DraggableAnchors<T> DraggableAnchors(Function1<? super androidx.compose.material.DraggableAnchorsConfig<T>, Unit> builder) {
        DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
        builder.invoke(draggableAnchorsConfig);
        MapDraggableAnchors mapDraggableAnchors = new MapDraggableAnchors(draggableAnchorsConfig.getAnchors$material_release());
        return (DraggableAnchors)mapDraggableAnchors;
    }

    public static final androidx.compose.material.MapDraggableAnchors access$emptyDraggableAnchors() {
        return AnchoredDraggableKt.emptyDraggableAnchors();
    }

    public static final Object access$restartable(Function0 inputs, Function2 block, Continuation $completion) {
        return AnchoredDraggableKt.restartable(inputs, block, $completion);
    }

    public static final <T> Modifier anchoredDraggable(Modifier $this$anchoredDraggable, androidx.compose.material.AnchoredDraggableState<T> state, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, boolean startDragImmediately) {
        AnchoredDraggableKt.anchoredDraggable.1 anon = new AnchoredDraggableKt.anchoredDraggable.1(state, 0);
        return DraggableKt.draggable$default($this$anchoredDraggable, state.getDraggableState$material_release(), orientation, enabled, interactionSource, startDragImmediately, 0, (Function3)anon, reverseDirection, 32, 0);
    }

    public static Modifier anchoredDraggable$default(Modifier modifier, androidx.compose.material.AnchoredDraggableState anchoredDraggableState2, Orientation orientation3, boolean z4, boolean z5, MutableInteractionSource mutableInteractionSource6, boolean z7, int i8, Object object9) {
        int i;
        int i3;
        int i2;
        boolean z;
        int obj10;
        int obj11;
        int obj12;
        boolean obj13;
        i = i8 & 4 != 0 ? obj10 : z4;
        i3 = i8 & 8 != 0 ? obj11 : z5;
        i2 = i8 & 16 != 0 ? obj12 : mutableInteractionSource6;
        if (i8 & 32 != 0) {
            z = obj13;
        } else {
            z = z7;
        }
        return AnchoredDraggableKt.anchoredDraggable(modifier, anchoredDraggableState2, orientation3, i, i3, i2, z);
    }

    public static final <T> Object animateTo(androidx.compose.material.AnchoredDraggableState<T> $this$animateTo, T targetValue, float velocity, Continuation<? super Unit> $completion) {
        AnchoredDraggableKt.animateTo.2 anon = new AnchoredDraggableKt.animateTo.2($this$animateTo, velocity, 0);
        Object obj9 = AnchoredDraggableState.anchoredDrag$default($this$animateTo, targetValue, 0, (Function4)anon, $completion, 2, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    public static Object animateTo$default(androidx.compose.material.AnchoredDraggableState anchoredDraggableState, Object object2, float f3, Continuation continuation4, int i5, Object object6) {
        float obj2;
        if (i5 &= 2 != 0) {
            obj2 = anchoredDraggableState.getLastVelocity();
        }
        return AnchoredDraggableKt.animateTo(anchoredDraggableState, object2, obj2, continuation4);
    }

    public static final <T> Modifier draggableAnchors(Modifier $this$draggableAnchors, androidx.compose.material.AnchoredDraggableState<T> state, Orientation orientation, Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends androidx.compose.material.DraggableAnchors<T>, ? extends T>> anchors) {
        DraggableAnchorsElement draggableAnchorsElement = new DraggableAnchorsElement(state, anchors, orientation);
        return $this$draggableAnchors.then((Modifier)draggableAnchorsElement);
    }

    private static final <T> androidx.compose.material.MapDraggableAnchors<T> emptyDraggableAnchors() {
        MapDraggableAnchors mapDraggableAnchors = new MapDraggableAnchors(MapsKt.emptyMap());
        return mapDraggableAnchors;
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

    public static final <T> Object snapTo(androidx.compose.material.AnchoredDraggableState<T> $this$snapTo, T targetValue, Continuation<? super Unit> $completion) {
        AnchoredDraggableKt.snapTo.2 anon = new AnchoredDraggableKt.snapTo.2(0);
        Object obj9 = AnchoredDraggableState.anchoredDrag$default($this$snapTo, targetValue, 0, (Function4)anon, $completion, 2, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }
}
