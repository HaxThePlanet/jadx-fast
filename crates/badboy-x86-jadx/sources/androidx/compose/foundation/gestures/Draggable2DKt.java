package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a\u001c\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0001H\u0007\u001a!\u0010\u0015\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0001H\u0007¢\u0006\u0002\u0010\u0016\u001a\u0088\u0001\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001b2#\u0008\u0002\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0005\u0012\u0004\u0012\u00020\u00060\u00012#\u0008\u0002\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00060\u00012\u0008\u0008\u0002\u0010!\u001a\u00020\u001bH\u0007\u001aÃ\u0001\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001b2>\u0008\u0002\u0010\u001f\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0008¢\u0006\u0002\u0008\u000c2>\u0008\u0002\u0010 \u001a8\u0008\u0001\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0008¢\u0006\u0002\u0008\u000c2\u0008\u0008\u0002\u0010!\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\"\")\u0010\u0000\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"F\u0010\u0007\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0008¢\u0006\u0002\u0008\u000cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r\")\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"F\u0010\u0011\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0008¢\u0006\u0002\u0008\u000cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006#", d2 = {"NoOpOnDragStart", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "", "NoOpOnDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "NoOpOnDragStop", "Landroidx/compose/ui/unit/Velocity;", "velocity", "NoOpOnDragStopped", "Draggable2DState", "Landroidx/compose/foundation/gestures/Draggable2DState;", "onDelta", "rememberDraggable2DState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/Draggable2DState;", "draggable2D", "Landroidx/compose/ui/Modifier;", "state", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "onDragStopped", "reverseDirection", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/Draggable2DState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Draggable2DKt {

    private static final Function1<Offset, Unit> NoOpOnDragStart;
    private static final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> NoOpOnDragStarted;
    private static final Function1<Velocity, Unit> NoOpOnDragStop;
    private static final Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> NoOpOnDragStopped;
    static {
        final int i = 0;
        Draggable2DKt.NoOpOnDragStarted.1 anon = new Draggable2DKt.NoOpOnDragStarted.1(i);
        Draggable2DKt.NoOpOnDragStarted = (Function3)anon;
        Draggable2DKt.NoOpOnDragStart = (Function1)Draggable2DKt.NoOpOnDragStart.1.INSTANCE;
        Draggable2DKt.NoOpOnDragStopped.1 anon2 = new Draggable2DKt.NoOpOnDragStopped.1(i);
        Draggable2DKt.NoOpOnDragStopped = (Function3)anon2;
        Draggable2DKt.NoOpOnDragStop = (Function1)Draggable2DKt.NoOpOnDragStop.1.INSTANCE;
    }

    public static final androidx.compose.foundation.gestures.Draggable2DState Draggable2DState(Function1<? super Offset, Unit> onDelta) {
        DefaultDraggable2DState defaultDraggable2DState = new DefaultDraggable2DState(onDelta);
        return (Draggable2DState)defaultDraggable2DState;
    }

    public static final Function1 access$getNoOpOnDragStart$p() {
        return Draggable2DKt.NoOpOnDragStart;
    }

    public static final Function3 access$getNoOpOnDragStarted$p() {
        return Draggable2DKt.NoOpOnDragStarted;
    }

    public static final Function1 access$getNoOpOnDragStop$p() {
        return Draggable2DKt.NoOpOnDragStop;
    }

    public static final Function3 access$getNoOpOnDragStopped$p() {
        return Draggable2DKt.NoOpOnDragStopped;
    }

    public static final Modifier draggable2D(Modifier $this$draggable2D, androidx.compose.foundation.gestures.Draggable2DState state, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, Function1<? super Offset, Unit> onDragStarted, Function1<? super Velocity, Unit> onDragStopped, boolean reverseDirection) {
        Draggable2DElement draggable2DElement = new Draggable2DElement(state, enabled, interactionSource, startDragImmediately, onDragStarted, onDragStopped, reverseDirection);
        return $this$draggable2D.then((Modifier)draggable2DElement);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use overload without the suspend onDragStarted onDragStopped and callbacks")
    public static final Modifier draggable2D(Modifier $this$draggable2D, androidx.compose.foundation.gestures.Draggable2DState state, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, Function3 onDragStarted, Function3 onDragStopped, boolean reverseDirection) {
        Draggable2DCompatElement draggable2DCompatElement = new Draggable2DCompatElement(state, enabled, interactionSource, startDragImmediately, onDragStarted, onDragStopped, reverseDirection);
        return $this$draggable2D.then((Modifier)draggable2DCompatElement);
    }

    public static Modifier draggable2D$default(Modifier modifier, androidx.compose.foundation.gestures.Draggable2DState draggable2DState2, boolean z3, MutableInteractionSource mutableInteractionSource4, boolean z5, Function1 function16, Function1 function17, boolean z8, int i9, Object object10) {
        int i;
        int i3;
        int i2;
        int i4;
        Function1 noOpOnDragStart;
        Function1 noOpOnDragStop;
        i = i9 & 2 != 0 ? 1 : z3;
        i3 = i9 & 4 != 0 ? 0 : mutableInteractionSource4;
        i2 = i9 & 8 != 0 ? i4 : z5;
        noOpOnDragStart = i9 & 16 != 0 ? Draggable2DKt.NoOpOnDragStart : function16;
        noOpOnDragStop = i9 & 32 != 0 ? Draggable2DKt.NoOpOnDragStop : function17;
        if (i9 & 64 != 0) {
        } else {
            i4 = z8;
        }
        return Draggable2DKt.draggable2D(modifier, draggable2DState2, i, i3, i2, noOpOnDragStart, noOpOnDragStop, i4);
    }

    public static Modifier draggable2D$default(Modifier modifier, androidx.compose.foundation.gestures.Draggable2DState draggable2DState2, boolean z3, MutableInteractionSource mutableInteractionSource4, boolean z5, Function3 function36, Function3 function37, boolean z8, int i9, Object object10) {
        int i4;
        int i;
        int i2;
        int i3;
        Function3 noOpOnDragStarted;
        Function3 noOpOnDragStopped;
        i4 = i9 & 2 != 0 ? 1 : z3;
        i = i9 & 4 != 0 ? 0 : mutableInteractionSource4;
        i2 = i9 & 8 != 0 ? i3 : z5;
        noOpOnDragStarted = i9 & 16 != 0 ? Draggable2DKt.NoOpOnDragStarted : function36;
        noOpOnDragStopped = i9 & 32 != 0 ? Draggable2DKt.NoOpOnDragStopped : function37;
        if (i9 & 64 != 0) {
        } else {
            i3 = z8;
        }
        return Draggable2DKt.draggable2D(modifier, draggable2DState2, i4, i, i2, noOpOnDragStarted, noOpOnDragStopped, i3);
    }

    public static final androidx.compose.foundation.gestures.Draggable2DState rememberDraggable2DState(Function1<? super Offset, Unit> onDelta, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object draggable2DState;
        androidx.compose.foundation.gestures.Draggable2DKt.rememberDraggable2DState.1.1 anon;
        int i = -1150277615;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberDraggable2DState)121@4913L29,122@4954L63:Draggable2D.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.gestures.rememberDraggable2DState (Draggable2D.kt:120)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -428493944, "CC(remember):Draggable2D.kt#9igjgp");
        int i4 = 0;
        Composer composer = $composer;
        final int i5 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i6 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i7 = 0;
            anon = new Draggable2DKt.rememberDraggable2DState.1.1(SnapshotStateKt.rememberUpdatedState(onDelta, $composer, $changed & 14));
            composer.updateRememberedValue(Draggable2DKt.Draggable2DState((Function1)anon));
        } else {
            draggable2DState = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Draggable2DState)draggable2DState;
    }
}
