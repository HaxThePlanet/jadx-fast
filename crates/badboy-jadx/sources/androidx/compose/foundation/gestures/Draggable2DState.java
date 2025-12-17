package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007JA\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\n2'\u0010\u000b\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000c¢\u0006\u0002\u0008\u000fH¦@¢\u0006\u0002\u0010\u0010ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0011À\u0006\u0001", d2 = {"Landroidx/compose/foundation/gestures/Draggable2DState;", "", "dispatchRawDelta", "", "delta", "Landroidx/compose/ui/geometry/Offset;", "dispatchRawDelta-k-4lQ0M", "(J)V", "drag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/Drag2DScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Draggable2DState {
    public static Object drag$default(androidx.compose.foundation.gestures.Draggable2DState draggable2DState, MutatePriority mutatePriority2, Function2 function23, Continuation continuation4, int i5, Object object6) {
        MutatePriority obj1;
        if (object6 != null) {
        } else {
            if (i5 &= 1 != 0) {
                obj1 = MutatePriority.Default;
            }
            return draggable2DState.drag(obj1, function23, continuation4);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drag");
        throw obj0;
    }

    public abstract void dispatchRawDelta-k-4lQ0M(long l);

    public abstract Object drag(MutatePriority mutatePriority, Function2<? super androidx.compose.foundation.gestures.Drag2DScope, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super Unit> continuation3);
}
