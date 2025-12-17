package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0010\u0008\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0080@¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"detectPressDownGesture", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDown", "Landroidx/compose/foundation/text/input/internal/selection/TapOnPosition;", "onUp", "Lkotlin/Function0;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/input/internal/selection/TapOnPosition;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PressDownGestureKt {
    public static final Object detectPressDownGesture(PointerInputScope $this$detectPressDownGesture, androidx.compose.foundation.text.input.internal.selection.TapOnPosition onDown, Function0<Unit> onUp, Continuation<? super Unit> $completion) {
        PressDownGestureKt.detectPressDownGesture.2 anon = new PressDownGestureKt.detectPressDownGesture.2(onDown, onUp, 0);
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectPressDownGesture, (Function2)anon, $completion);
        if (awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return awaitEachGesture;
        }
        return Unit.INSTANCE;
    }

    public static Object detectPressDownGesture$default(PointerInputScope pointerInputScope, androidx.compose.foundation.text.input.internal.selection.TapOnPosition tapOnPosition2, Function0 function03, Continuation continuation4, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return PressDownGestureKt.detectPressDownGesture(pointerInputScope, tapOnPosition2, obj2, continuation4);
    }
}
