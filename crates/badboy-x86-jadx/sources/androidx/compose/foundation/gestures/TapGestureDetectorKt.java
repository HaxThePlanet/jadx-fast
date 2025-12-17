package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.platform.ViewConfiguration;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0087@¢\u0006\u0002\u0010\u000e\u001a&\u0010\t\u001a\u00020\n*\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u0014\u001a\u0012\u0010\u0015\u001a\u00020\u0005*\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u0016\u001a[\u0010\u0017\u001a\u00020\u0005*\u00020\u00182/\u0008\u0002\u0010\u0019\u001a)\u0008\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\u0008\u00072\u0016\u0008\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH\u0080@¢\u0006\u0002\u0010\u001c\u001a\u008b\u0001\u0010\u001d\u001a\u00020\u0005*\u00020\u00182\u0016\u0008\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u0016\u0008\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2/\u0008\u0002\u0010\u0019\u001a)\u0008\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\u0008\u00072\u0016\u0008\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH\u0086@¢\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0087@¢\u0006\u0002\u0010\u0016\u001a\u001e\u0010!\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\"\"7\u0010\u0000\u001a)\u0008\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\u0008\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0008¨\u0006#", d2 = {"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "awaitFirstDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLandroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onPress", "onTap", "Lkotlin/Function1;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapGestures", "onDoubleTap", "onLongPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForUpOrCancellation", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TapGestureDetectorKt {

    private static final Function3<androidx.compose.foundation.gestures.PressGestureScope, Offset, Continuation<? super Unit>, Object> NoPressGesture;
    static {
        TapGestureDetectorKt.NoPressGesture.1 anon = new TapGestureDetectorKt.NoPressGesture.1(0);
        TapGestureDetectorKt.NoPressGesture = (Function3)anon;
    }

    public static final Object access$awaitSecondDown(AwaitPointerEventScope $receiver, PointerInputChange firstUp, Continuation $completion) {
        return TapGestureDetectorKt.awaitSecondDown($receiver, firstUp, $completion);
    }

    public static final Object access$consumeUntilUp(AwaitPointerEventScope $receiver, Continuation $completion) {
        return TapGestureDetectorKt.consumeUntilUp($receiver, $completion);
    }

    public static final Function3 access$getNoPressGesture$p() {
        return TapGestureDetectorKt.NoPressGesture;
    }

    public static final Object awaitFirstDown(AwaitPointerEventScope awaitPointerEventScope, boolean z2, PointerEventPass pointerEventPass3, Continuation<? super PointerInputChange> continuation4) {
        Object obj;
        Object event;
        boolean $result;
        Object $continuation;
        int i4;
        androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown.2 anon;
        Object $continuation2;
        int i5;
        Object requireUnconsumed2;
        boolean $this$awaitFirstDown2;
        boolean pass2;
        Object requireUnconsumed;
        Object $this$awaitFirstDown;
        Object pass;
        Object obj2;
        int $this$fastForEach$iv$iv;
        int i3;
        int i7;
        int index$iv$iv;
        int size;
        int i2;
        Object obj3;
        int i6;
        int i;
        boolean changedToDownIgnoreConsumed;
        androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown.2 anon2;
        obj = continuation4;
        $result = obj;
        i5 = Integer.MIN_VALUE;
        if (obj instanceof TapGestureDetectorKt.awaitFirstDown.2 && label2 &= i5 != 0) {
            $result = obj;
            i5 = Integer.MIN_VALUE;
            if (label2 &= i5 != 0) {
                $result.label = label -= i5;
            } else {
                $result = new TapGestureDetectorKt.awaitFirstDown.2(obj);
            }
        } else {
        }
        event = $result.result;
        final int i8 = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(event);
                requireUnconsumed = pointerEventPass3;
                pass = obj5;
                $this$awaitFirstDown2 = anon2;
                break;
            case 1:
                ResultKt.throwOnFailure(event);
                obj2 = l$0;
                $this$awaitFirstDown = l$1;
                pass2 = z$0;
                requireUnconsumed2 = $continuation2;
                anon = $result;
                $continuation = event;
                List changes2 = (PointerEvent)event.getChanges();
                i3 = 0;
                i7 = 0;
                index$iv$iv = 0;
                i2 = 0;
                obj3 = changes2.get(index$iv$iv);
                i6 = 0;
                i = 0;
                changedToDownIgnoreConsumed = PointerEventKt.changedToDown((PointerInputChange)obj3);
                changedToDownIgnoreConsumed = PointerEventKt.changedToDownIgnoreConsumed(obj3);
                $this$fastForEach$iv$iv = i2;
                index$iv$iv++;
                $this$fastForEach$iv$iv = i8;
                return event.getChanges().get(i2);
                event = $continuation;
                $result = anon;
                $continuation2 = requireUnconsumed2;
                $this$awaitFirstDown2 = pass2;
                requireUnconsumed = $this$awaitFirstDown;
                pass = obj2;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        $result.L$0 = pass;
        $result.L$1 = requireUnconsumed;
        $result.Z$0 = $this$awaitFirstDown2;
        $result.label = i8;
        Object awaitPointerEvent = pass.awaitPointerEvent(requireUnconsumed, $result);
        if (awaitPointerEvent != $continuation2) {
            $continuation = event;
            event = awaitPointerEvent;
            obj2 = pass;
            $this$awaitFirstDown = requireUnconsumed;
            pass2 = $this$awaitFirstDown2;
            requireUnconsumed2 = $continuation2;
            anon = anon2;
        }
        return $continuation2;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with PointerEventPass instead.")
    public static final Object awaitFirstDown(AwaitPointerEventScope $this$awaitFirstDown, boolean requireUnconsumed, Continuation $completion) {
        return TapGestureDetectorKt.awaitFirstDown($this$awaitFirstDown, requireUnconsumed, PointerEventPass.Main, $completion);
    }

    public static Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z2, PointerEventPass pointerEventPass3, Continuation continuation4, int i5, Object object6) {
        int obj1;
        PointerEventPass obj2;
        if (i5 & 1 != 0) {
            obj1 = 1;
        }
        if (i5 &= 2 != 0) {
            obj2 = PointerEventPass.Main;
        }
        return TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, obj1, obj2, continuation4);
    }

    public static Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z2, Continuation continuation3, int i4, Object object5) {
        int obj1;
        final int obj4 = 1;
        if (i4 &= obj4 != 0) {
            obj1 = obj4;
        }
        return TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, obj1, continuation3);
    }

    private static final Object awaitSecondDown(AwaitPointerEventScope $this$awaitSecondDown, PointerInputChange firstUp, Continuation<? super PointerInputChange> $completion) {
        TapGestureDetectorKt.awaitSecondDown.2 anon = new TapGestureDetectorKt.awaitSecondDown.2(firstUp, 0);
        return $this$awaitSecondDown.withTimeoutOrNull($this$awaitSecondDown.getViewConfiguration().getDoubleTapTimeoutMillis(), obj1, (Function2)anon);
    }

    private static final Object consumeUntilUp(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation2) {
        boolean $result;
        Object $continuation2;
        int i2;
        androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp.1 anon2;
        Object $continuation;
        int i3;
        Object label;
        int i4;
        int i5;
        int index$iv$iv;
        int index$iv;
        int size;
        Object obj2;
        Object obj;
        int i6;
        boolean it;
        int i;
        androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp.1 anon;
        Object obj14;
        Object obj15;
        $result = continuation2;
        i3 = Integer.MIN_VALUE;
        if (continuation2 instanceof TapGestureDetectorKt.consumeUntilUp.1 && label2 &= i3 != 0) {
            $result = continuation2;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                $result.label = obj15 -= i3;
            } else {
                $result = new TapGestureDetectorKt.consumeUntilUp.1(continuation2);
            }
        } else {
        }
        obj15 = $result.result;
        final int i8 = 1;
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj15);
                break;
            case 1:
                obj14 = $result.L$0;
                ResultKt.throwOnFailure(obj15);
                label = $continuation;
                anon2 = $result;
                $continuation2 = obj15;
                List changes = (PointerEvent)obj15.getChanges();
                int i9 = 0;
                index$iv = 0;
                i6 = 0;
                (PointerInputChange)changes.get(index$iv).consume();
                index$iv++;
                obj15 = obj15.getChanges();
                i4 = 0;
                i5 = 0;
                index$iv$iv = 0;
                i6 = 0;
                i = 0;
                obj15 = i8;
                index$iv$iv++;
                obj15 = 0;
                return Unit.INSTANCE;
                obj15 = $continuation2;
                $result = anon2;
                $continuation = label;
                break;
            default:
                obj14 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj14;
        }
        $result.L$0 = obj14;
        $result.label = i8;
        int i7 = 0;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(obj14, i7, $result, i8, i7);
        if (awaitPointerEvent$default != $continuation) {
            $continuation2 = obj15;
            obj15 = awaitPointerEvent$default;
            label = $continuation;
            anon2 = anon;
        }
        return $continuation;
    }

    public static final Object detectTapAndPress(PointerInputScope $this$detectTapAndPress, Function3<? super androidx.compose.foundation.gestures.PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onPress, Function1<? super Offset, Unit> onTap, Continuation<? super Unit> $completion) {
        PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl((Density)$this$detectTapAndPress);
        TapGestureDetectorKt.detectTapAndPress.2 anon = new TapGestureDetectorKt.detectTapAndPress.2($this$detectTapAndPress, onPress, onTap, pressGestureScopeImpl, 0);
        Object obj8 = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    public static Object detectTapAndPress$default(PointerInputScope pointerInputScope, Function3 function32, Function1 function13, Continuation continuation4, int i5, Object object6) {
        Function3 obj1;
        int obj2;
        if (i5 & 1 != 0) {
            obj1 = TapGestureDetectorKt.NoPressGesture;
        }
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return TapGestureDetectorKt.detectTapAndPress(pointerInputScope, obj1, obj2, continuation4);
    }

    public static final Object detectTapGestures(PointerInputScope $this$detectTapGestures, Function1<? super Offset, Unit> onDoubleTap, Function1<? super Offset, Unit> onLongPress, Function3<? super androidx.compose.foundation.gestures.PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onPress, Function1<? super Offset, Unit> onTap, Continuation<? super Unit> $completion) {
        TapGestureDetectorKt.detectTapGestures.2 anon = new TapGestureDetectorKt.detectTapGestures.2($this$detectTapGestures, onPress, onLongPress, onDoubleTap, onTap, 0);
        Object obj7 = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public static Object detectTapGestures$default(PointerInputScope pointerInputScope, Function1 function12, Function1 function13, Function3 function34, Function1 function15, Continuation continuation6, int i7, Object object8) {
        int obj2;
        int obj3;
        Function3 obj4;
        int obj5;
        final int i = 0;
        if (i7 & 1 != 0) {
            obj2 = i;
        }
        if (i7 & 2 != 0) {
            obj3 = i;
        }
        if (i7 & 4 != 0) {
            obj4 = TapGestureDetectorKt.NoPressGesture;
        }
        if (i7 &= 8 != 0) {
            obj5 = i;
        }
        return TapGestureDetectorKt.detectTapGestures(pointerInputScope, obj2, obj3, obj4, obj5, continuation6);
    }

    public static final Object waitForUpOrCancellation(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass2, Continuation<? super PointerInputChange> continuation3) {
        Object obj2;
        Object $result;
        int $this$fastForEach$iv$iv3;
        int $this$fastForEach$iv$iv;
        boolean $result2;
        Object $continuation;
        int i3;
        Object $continuation2;
        androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation.2 anon2;
        int i4;
        Object obj4;
        Object pass2;
        Object outOfBounds-jwHxaWs;
        int i2;
        int extendedTouchPadding-NH-jbRc;
        Object $this$waitForUpOrCancellation;
        Object pass3;
        int index$iv$iv;
        int size2;
        int $this$fastForEach$iv$iv2;
        int i;
        int index$iv$iv3;
        int size;
        int index$iv$iv2;
        int it2;
        Object obj;
        Object obj3;
        int consumed;
        boolean it;
        int pass;
        androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation.2 anon;
        int obj22;
        obj2 = continuation3;
        $result2 = obj2;
        i4 = Integer.MIN_VALUE;
        if (obj2 instanceof TapGestureDetectorKt.waitForUpOrCancellation.2 && label2 &= i4 != 0) {
            $result2 = obj2;
            i4 = Integer.MIN_VALUE;
            if (label2 &= i4 != 0) {
                $result2.label = label -= i4;
            } else {
                $result2 = new TapGestureDetectorKt.waitForUpOrCancellation.2(obj2);
            }
        } else {
        }
        $result = $result2.result;
        $continuation2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = 0;
        extendedTouchPadding-NH-jbRc = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                obj4 = awaitPointerEventScope;
                $this$waitForUpOrCancellation = pointerEventPass2;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                index$iv$iv = l$0;
                $this$waitForUpOrCancellation = pass4;
                pass2 = $continuation2;
                anon2 = $result2;
                $continuation = $result;
                List changes2 = (PointerEvent)$result.getChanges();
                int i10 = 0;
                int i11 = 0;
                index$iv$iv2 = 0;
                consumed = 0;
                pass = 0;
                $this$fastForEach$iv$iv2 = i2;
                index$iv$iv2++;
                $this$fastForEach$iv$iv2 = extendedTouchPadding-NH-jbRc;
                return $result.getChanges().get(i2);
                List event = $result.getChanges();
                size2 = 0;
                i = 0;
                index$iv$iv3 = 0;
                it2 = event.get(index$iv$iv3);
                obj = null;
                obj3 = null;
                obj22 = 0;
                pass = $this$waitForUpOrCancellation;
                outOfBounds-jwHxaWs = 0;
                pass = $this$waitForUpOrCancellation;
                obj22 = 0;
                outOfBounds-jwHxaWs = 1;
                $this$fastForEach$iv$iv3 = 1;
                index$iv$iv3++;
                $this$waitForUpOrCancellation = pass;
                i2 = 0;
                extendedTouchPadding-NH-jbRc = 1;
                pass = $this$waitForUpOrCancellation;
                obj22 = 0;
                $this$fastForEach$iv$iv3 = 0;
                return obj22;
                anon2.L$0 = index$iv$iv;
                int i9 = pass;
                anon2.L$1 = i9;
                anon2.label = 2;
                return pass2;
                outOfBounds-jwHxaWs = i9;
                pass3 = index$iv$iv;
                List consumeCheck = (PointerEvent)$result.getChanges();
                int i7 = 0;
                int i8 = 0;
                index$iv$iv = 0;
                size = 0;
                obj = null;
                $this$fastForEach$iv$iv = 1;
                index$iv$iv++;
                $this$fastForEach$iv$iv = 0;
                return obj22;
                $result = $continuation;
                $result2 = anon2;
                $continuation2 = pass2;
                obj4 = pass3;
                i2 = 0;
                extendedTouchPadding-NH-jbRc = 1;
                $this$waitForUpOrCancellation = outOfBounds-jwHxaWs;
                break;
            case 2:
                pass3 = $result2.L$0;
                ResultKt.throwOnFailure($result);
                outOfBounds-jwHxaWs = l$1;
                obj22 = 0;
                pass2 = $continuation2;
                anon2 = $result2;
                $continuation = $result;
                consumeCheck = (PointerEvent)$result.getChanges();
                i7 = 0;
                i8 = 0;
                index$iv$iv = 0;
                size = 0;
                obj = null;
                $this$fastForEach$iv$iv = 1;
                index$iv$iv++;
                $this$fastForEach$iv$iv = 0;
                return obj22;
                $result = $continuation;
                $result2 = anon2;
                $continuation2 = pass2;
                obj4 = pass3;
                i2 = 0;
                extendedTouchPadding-NH-jbRc = 1;
                $this$waitForUpOrCancellation = outOfBounds-jwHxaWs;
                break;
            default:
                IllegalStateException $result3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result3;
        }
        $result2.L$0 = obj4;
        $result2.L$1 = $this$waitForUpOrCancellation;
        $result2.label = extendedTouchPadding-NH-jbRc;
        Object awaitPointerEvent = obj4.awaitPointerEvent($this$waitForUpOrCancellation, $result2);
        if (awaitPointerEvent != $continuation2) {
            $continuation = $result;
            $result = awaitPointerEvent;
            index$iv$iv = obj4;
            pass2 = $continuation2;
            anon2 = anon;
        }
        return $continuation2;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with PointerEventPass instead.")
    public static final Object waitForUpOrCancellation(AwaitPointerEventScope $this$waitForUpOrCancellation, Continuation $completion) {
        return TapGestureDetectorKt.waitForUpOrCancellation($this$waitForUpOrCancellation, PointerEventPass.Main, $completion);
    }

    public static Object waitForUpOrCancellation$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass2, Continuation continuation3, int i4, Object object5) {
        PointerEventPass obj1;
        if (i4 &= 1 != 0) {
            obj1 = PointerEventPass.Main;
        }
        return TapGestureDetectorKt.waitForUpOrCancellation(awaitPointerEventScope, obj1, continuation3);
    }
}
