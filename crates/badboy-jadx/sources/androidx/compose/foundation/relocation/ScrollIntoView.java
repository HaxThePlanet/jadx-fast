package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
@Metadata(d1 = "androidx/compose/foundation/relocation/ScrollIntoView__ScrollIntoViewRequesterKt", k = 4, mv = {1, 8, 0}, xi = 48)
public final class ScrollIntoView {
    public static final Object scrollIntoView(DelegatableNode $this$scrollIntoView, Rect rect, Continuation<? super Unit> $completion) {
        return ScrollIntoView__ScrollIntoViewRequesterKt.scrollIntoView($this$scrollIntoView, rect, $completion);
    }

    public static Object scrollIntoView$default(DelegatableNode delegatableNode, Rect rect2, Continuation continuation3, int i4, Object object5) {
        return ScrollIntoView__ScrollIntoViewRequesterKt.scrollIntoView$default(delegatableNode, rect2, continuation3, i4, object5);
    }
}
