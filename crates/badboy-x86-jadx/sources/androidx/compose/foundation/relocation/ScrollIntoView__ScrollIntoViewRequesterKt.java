package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0080@¢\u0006\u0002\u0010\u0005¨\u0006\u0006", d2 = {"scrollIntoView", "", "Landroidx/compose/ui/node/DelegatableNode;", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/foundation/relocation/ScrollIntoView")
final class ScrollIntoView__ScrollIntoViewRequesterKt {
    public static final Object scrollIntoView(DelegatableNode $this$scrollIntoView, Rect rect, Continuation<? super Unit> $completion) {
        if (!$this$scrollIntoView.getNode().isAttached()) {
            return Unit.INSTANCE;
        }
        androidx.compose.ui.layout.LayoutCoordinates requireLayoutCoordinates = DelegatableNodeKt.requireLayoutCoordinates($this$scrollIntoView);
        androidx.compose.foundation.relocation.BringIntoViewParent bringIntoViewParent = BringIntoViewRequesterKt.findBringIntoViewParent($this$scrollIntoView);
        if (bringIntoViewParent == null) {
            return Unit.INSTANCE;
        }
        ScrollIntoView__ScrollIntoViewRequesterKt.scrollIntoView.2 anon = new ScrollIntoView__ScrollIntoViewRequesterKt.scrollIntoView.2(rect, requireLayoutCoordinates);
        Object bringChildIntoView = bringIntoViewParent.bringChildIntoView(requireLayoutCoordinates, (Function0)anon, $completion);
        if (bringChildIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return bringChildIntoView;
        }
        return Unit.INSTANCE;
    }

    public static Object scrollIntoView$default(DelegatableNode delegatableNode, Rect rect2, Continuation continuation3, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        return ScrollIntoView.scrollIntoView(delegatableNode, obj1, continuation3);
    }
}
