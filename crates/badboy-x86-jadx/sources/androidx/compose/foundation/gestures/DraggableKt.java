package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u001a\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00080\u0012\u001a!\u0010\u0013\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00080\u0012H\u0007¢\u0006\u0002\u0010\u0014\u001aË\u0001\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001b2>\u0008\u0002\u0010\u001f\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u0006\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001¢\u0006\u0002\u0008\n2>\u0008\u0002\u0010 \u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\r¢\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001¢\u0006\u0002\u0008\n2\u0008\u0008\u0002\u0010!\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\"\u001a\u001e\u0010#\u001a\u00020\r*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%\u001a\u001e\u0010#\u001a\u00020\r*\u00020&2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\u0008'\u0010%\u001a\u0016\u0010(\u001a\u00020&*\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\"F\u0010\u0000\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u0006\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001¢\u0006\u0002\u0008\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b\"F\u0010\u000c\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\r¢\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001¢\u0006\u0002\u0008\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006+", d2 = {"NoOpOnDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "NoOpOnDragStopped", "", "velocity", "DraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "draggable", "Landroidx/compose/ui/Modifier;", "state", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "onDragStopped", "reverseDirection", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "toFloat", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "Landroidx/compose/ui/unit/Velocity;", "toFloat-sF-c-tU", "toValidVelocity", "toValidVelocity-TH1AsA0", "(J)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DraggableKt {

    private static final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> NoOpOnDragStarted;
    private static final Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> NoOpOnDragStopped;
    static {
        final int i = 0;
        DraggableKt.NoOpOnDragStarted.1 anon = new DraggableKt.NoOpOnDragStarted.1(i);
        DraggableKt.NoOpOnDragStarted = (Function3)anon;
        DraggableKt.NoOpOnDragStopped.1 anon2 = new DraggableKt.NoOpOnDragStopped.1(i);
        DraggableKt.NoOpOnDragStopped = (Function3)anon2;
    }

    public static final androidx.compose.foundation.gestures.DraggableState DraggableState(Function1<? super Float, Unit> onDelta) {
        DefaultDraggableState defaultDraggableState = new DefaultDraggableState(onDelta);
        return (DraggableState)defaultDraggableState;
    }

    public static final Function3 access$getNoOpOnDragStarted$p() {
        return DraggableKt.NoOpOnDragStarted;
    }

    public static final Function3 access$getNoOpOnDragStopped$p() {
        return DraggableKt.NoOpOnDragStopped;
    }

    public static final float access$toFloat-3MmeM6k(long $receiver, androidx.compose.foundation.gestures.Orientation orientation) {
        return DraggableKt.toFloat-3MmeM6k($receiver, orientation);
    }

    public static final float access$toFloat-sF-c-tU(long $receiver, androidx.compose.foundation.gestures.Orientation orientation) {
        return DraggableKt.toFloat-sF-c-tU($receiver, orientation);
    }

    public static final long access$toValidVelocity-TH1AsA0(long $receiver) {
        return DraggableKt.toValidVelocity-TH1AsA0($receiver);
    }

    public static final Modifier draggable(Modifier $this$draggable, androidx.compose.foundation.gestures.DraggableState state, androidx.compose.foundation.gestures.Orientation orientation, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean reverseDirection) {
        DraggableElement draggableElement = new DraggableElement(state, orientation, enabled, interactionSource, startDragImmediately, onDragStarted, onDragStopped, reverseDirection);
        return $this$draggable.then((Modifier)draggableElement);
    }

    public static Modifier draggable$default(Modifier modifier, androidx.compose.foundation.gestures.DraggableState draggableState2, androidx.compose.foundation.gestures.Orientation orientation3, boolean z4, MutableInteractionSource mutableInteractionSource5, boolean z6, Function3 function37, Function3 function38, boolean z9, int i10, Object object11) {
        int i;
        int i2;
        int i4;
        Function3 function3;
        Function3 function32;
        int i3;
        int obj12;
        int obj13;
        int i5 = i10;
        i = i5 & 4 != 0 ? obj12 : z4;
        i2 = i5 & 8 != 0 ? obj13 : mutableInteractionSource5;
        obj13 = 0;
        i4 = i5 & 16 != 0 ? obj13 : z6;
        function3 = i5 & 32 != 0 ? obj12 : function37;
        function32 = i5 & 64 != 0 ? obj12 : function38;
        i3 = i5 & 128 != 0 ? obj13 : z9;
        return DraggableKt.draggable(modifier, draggableState2, orientation3, i, i2, i4, function3, function32, i3);
    }

    public static final androidx.compose.foundation.gestures.DraggableState rememberDraggableState(Function1<? super Float, Unit> onDelta, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object $i$a$CacheDraggableKt$rememberDraggableState$1;
        androidx.compose.foundation.gestures.DraggableKt.rememberDraggableState.1.1 anon;
        int i = -183245213;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberDraggableState)137@5893L29,138@5934L61:Draggable.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:136)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1306928920, "CC(remember):Draggable.kt#9igjgp");
        int i4 = 0;
        Composer composer = $composer;
        final int i5 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i6 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i7 = 0;
            anon = new DraggableKt.rememberDraggableState.1.1(SnapshotStateKt.rememberUpdatedState(onDelta, $composer, $changed & 14));
            composer.updateRememberedValue(DraggableKt.DraggableState((Function1)anon));
        } else {
            $i$a$CacheDraggableKt$rememberDraggableState$1 = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (DraggableState)$i$a$CacheDraggableKt$rememberDraggableState$1;
    }

    private static final float toFloat-3MmeM6k(long $this$toFloat_u2d3MmeM6k, androidx.compose.foundation.gestures.Orientation orientation) {
        float y-impl;
        if (obj3 == Orientation.Vertical) {
            y-impl = Offset.getY-impl($this$toFloat_u2d3MmeM6k);
        } else {
            y-impl = Offset.getX-impl($this$toFloat_u2d3MmeM6k);
        }
        return y-impl;
    }

    private static final float toFloat-sF-c-tU(long $this$toFloat_u2dsF_u2dc_u2dtU, androidx.compose.foundation.gestures.Orientation orientation) {
        float y-impl;
        if (obj3 == Orientation.Vertical) {
            y-impl = Velocity.getY-impl($this$toFloat_u2dsF_u2dc_u2dtU);
        } else {
            y-impl = Velocity.getX-impl($this$toFloat_u2dsF_u2dc_u2dtU);
        }
        return y-impl;
    }

    private static final long toValidVelocity-TH1AsA0(long $this$toValidVelocity_u2dTH1AsA0) {
        int x-impl;
        float y-impl;
        if (Float.isNaN(Velocity.getX-impl($this$toValidVelocity_u2dTH1AsA0))) {
            x-impl = y-impl;
        } else {
            x-impl = Velocity.getX-impl($this$toValidVelocity_u2dTH1AsA0);
        }
        if (Float.isNaN(Velocity.getY-impl($this$toValidVelocity_u2dTH1AsA0))) {
        } else {
            y-impl = Velocity.getY-impl($this$toValidVelocity_u2dTH1AsA0);
        }
        return VelocityKt.Velocity(x-impl, y-impl);
    }
}
