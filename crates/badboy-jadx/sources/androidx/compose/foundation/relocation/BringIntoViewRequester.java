package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008w\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0006\u0082\u0001\u0001\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0008À\u0006\u0001", d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BringIntoViewRequester {
    public static Object bringIntoView$default(androidx.compose.foundation.relocation.BringIntoViewRequester bringIntoViewRequester, Rect rect2, Continuation continuation3, int i4, Object object5) {
        int obj1;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj1 = 0;
            }
            return bringIntoViewRequester.bringIntoView(obj1, continuation3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bringIntoView");
        throw obj0;
    }

    public abstract Object bringIntoView(Rect rect, Continuation<? super Unit> continuation2);
}
