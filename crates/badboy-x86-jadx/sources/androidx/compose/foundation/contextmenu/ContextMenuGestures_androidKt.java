package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a&\u0010\u0008\u001a\u00020\t*\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u000cH\u0081@¢\u0006\u0002\u0010\u000e¨\u0006\u000f", d2 = {"awaitFirstRightClickDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contextMenuGestures", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "onRightClickDown", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDown", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContextMenuGestures_androidKt {
    public static final Object access$awaitFirstRightClickDown(AwaitPointerEventScope $receiver, Continuation $completion) {
        return ContextMenuGestures_androidKt.awaitFirstRightClickDown($receiver, $completion);
    }

    private static final Object awaitFirstRightClickDown(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation2) {
        Object obj3;
        Object event;
        boolean $result;
        Object $continuation;
        int i7;
        androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt.awaitFirstRightClickDown.1 context2;
        Object $continuation2;
        int i4;
        Object $this$awaitFirstRightClickDown;
        Object obj;
        Object obj2;
        boolean $this$fastForEach$iv$iv;
        int i2;
        int i;
        int index$iv$iv;
        int size;
        int i6;
        Object obj4;
        Object obj5;
        int i3;
        boolean it;
        int i5;
        androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt.awaitFirstRightClickDown.1 context;
        obj3 = continuation2;
        $result = obj3;
        i4 = Integer.MIN_VALUE;
        if (obj3 instanceof ContextMenuGestures_androidKt.awaitFirstRightClickDown.1 && label2 &= i4 != 0) {
            $result = obj3;
            i4 = Integer.MIN_VALUE;
            if (label2 &= i4 != 0) {
                $result.label = label -= i4;
            } else {
                $result = new ContextMenuGestures_androidKt.awaitFirstRightClickDown.1(obj3);
            }
        } else {
        }
        event = $result.result;
        final int i9 = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(event);
                obj = awaitPointerEventScope;
                break;
            case 1:
                ResultKt.throwOnFailure(event);
                obj2 = l$0;
                $this$awaitFirstRightClickDown = $continuation2;
                context2 = $result;
                $continuation = event;
                List changes2 = event.getChanges();
                i2 = 0;
                i = 0;
                index$iv$iv = 0;
                i6 = 0;
                i3 = 0;
                i5 = 0;
                $this$fastForEach$iv$iv = i6;
                index$iv$iv++;
                $this$fastForEach$iv$iv = i9;
                return event.getChanges().get(i6);
                event = $continuation;
                $result = context2;
                $continuation2 = $this$awaitFirstRightClickDown;
                obj = obj2;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        $result.L$0 = obj;
        $result.label = i9;
        int i10 = 0;
        Object awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(obj, i10, $result, i9, i10);
        if (awaitPointerEvent$default != $continuation2) {
            $continuation = event;
            event = awaitPointerEvent$default;
            obj2 = obj;
            $this$awaitFirstRightClickDown = $continuation2;
            context2 = context;
        }
        return $continuation2;
    }

    public static final Modifier contextMenuGestures(Modifier $this$contextMenuGestures, androidx.compose.foundation.contextmenu.ContextMenuState state) {
        ContextMenuGestures_androidKt.contextMenuGestures.1 anon = new ContextMenuGestures_androidKt.contextMenuGestures.1(state, 0);
        return SuspendingPointerInputFilterKt.pointerInput($this$contextMenuGestures, ContextMenuKey.INSTANCE, (Function2)anon);
    }

    public static final Object onRightClickDown(PointerInputScope $this$onRightClickDown, Function1<? super Offset, Unit> onDown, Continuation<? super Unit> $completion) {
        ContextMenuGestures_androidKt.onRightClickDown.2 anon = new ContextMenuGestures_androidKt.onRightClickDown.2(onDown, 0);
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$onRightClickDown, (Function2)anon, $completion);
        if (awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return awaitEachGesture;
        }
        return Unit.INSTANCE;
    }
}
