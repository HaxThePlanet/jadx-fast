package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0080@¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0080@¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\u0008\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0005¨\u0006\t", d2 = {"detectDownAndDragGesturesWithObserver", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "observer", "Landroidx/compose/foundation/text/TextDragObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPressWithObserver", "detectDragGesturesWithObserver", "detectPreDragGesturesWithObserver", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LongPressTextDragObserverKt {
    public static final Object access$detectDragGesturesWithObserver(PointerInputScope $receiver, androidx.compose.foundation.text.TextDragObserver observer, Continuation $completion) {
        return LongPressTextDragObserverKt.detectDragGesturesWithObserver($receiver, observer, $completion);
    }

    public static final Object access$detectPreDragGesturesWithObserver(PointerInputScope $receiver, androidx.compose.foundation.text.TextDragObserver observer, Continuation $completion) {
        return LongPressTextDragObserverKt.detectPreDragGesturesWithObserver($receiver, observer, $completion);
    }

    public static final Object detectDownAndDragGesturesWithObserver(PointerInputScope $this$detectDownAndDragGesturesWithObserver, androidx.compose.foundation.text.TextDragObserver observer, Continuation<? super Unit> $completion) {
        LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver.2 anon = new LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver.2($this$detectDownAndDragGesturesWithObserver, observer, 0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    public static final Object detectDragGesturesAfterLongPressWithObserver(PointerInputScope $this$detectDragGesturesAfterLongPressWithObserver, androidx.compose.foundation.text.TextDragObserver observer, Continuation<? super Unit> $completion) {
        LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver.2 anon = new LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver.2(observer);
        LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver.3 anon2 = new LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver.3(observer);
        LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver.4 anon3 = new LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver.4(observer);
        LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver.5 anon4 = new LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver.5(observer);
        Object obj7 = DragGestureDetectorKt.detectDragGesturesAfterLongPress($this$detectDragGesturesAfterLongPressWithObserver, (Function1)anon, (Function0)anon2, (Function0)anon3, (Function2)anon4, $completion);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    private static final Object detectDragGesturesWithObserver(PointerInputScope $this$detectDragGesturesWithObserver, androidx.compose.foundation.text.TextDragObserver observer, Continuation<? super Unit> $completion) {
        LongPressTextDragObserverKt.detectDragGesturesWithObserver.2 anon = new LongPressTextDragObserverKt.detectDragGesturesWithObserver.2(observer);
        LongPressTextDragObserverKt.detectDragGesturesWithObserver.3 anon2 = new LongPressTextDragObserverKt.detectDragGesturesWithObserver.3(observer);
        LongPressTextDragObserverKt.detectDragGesturesWithObserver.4 anon3 = new LongPressTextDragObserverKt.detectDragGesturesWithObserver.4(observer);
        LongPressTextDragObserverKt.detectDragGesturesWithObserver.5 anon4 = new LongPressTextDragObserverKt.detectDragGesturesWithObserver.5(observer);
        Object obj7 = DragGestureDetectorKt.detectDragGestures($this$detectDragGesturesWithObserver, (Function1)anon, (Function0)anon2, (Function0)anon3, (Function2)anon4, $completion);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    private static final Object detectPreDragGesturesWithObserver(PointerInputScope $this$detectPreDragGesturesWithObserver, androidx.compose.foundation.text.TextDragObserver observer, Continuation<? super Unit> $completion) {
        LongPressTextDragObserverKt.detectPreDragGesturesWithObserver.2 anon = new LongPressTextDragObserverKt.detectPreDragGesturesWithObserver.2(observer, 0);
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectPreDragGesturesWithObserver, (Function2)anon, $completion);
        if (awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return awaitEachGesture;
        }
        return Unit.INSTANCE;
    }
}
