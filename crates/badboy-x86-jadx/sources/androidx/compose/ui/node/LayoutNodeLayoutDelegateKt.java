package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a9\u0010\u0005\u001a\u00020\u0006\"\u0008\u0008\u0000\u0010\u0007*\u00020\u0008*\u00020\u00042\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00070\u000cH\u0082\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"MeasuredTwiceErrorMessage", "", "isOutMostLookaheadRoot", "", "Landroidx/compose/ui/node/LayoutNode;", "updateChildMeasurables", "", "T", "Landroidx/compose/ui/layout/Measurable;", "destination", "Landroidx/compose/runtime/collection/MutableVector;", "transform", "Lkotlin/Function1;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayoutNodeLayoutDelegateKt {

    private static final String MeasuredTwiceErrorMessage = "measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()";
    public static final boolean isOutMostLookaheadRoot(androidx.compose.ui.node.LayoutNode $this$isOutMostLookaheadRoot) {
        androidx.compose.ui.node.LayoutNode lookaheadRoot$ui_release;
        int i;
        if ($this$isOutMostLookaheadRoot.getLookaheadRoot$ui_release() != null) {
            androidx.compose.ui.node.LayoutNode parent$ui_release = $this$isOutMostLookaheadRoot.getParent$ui_release();
            if (parent$ui_release != null) {
                lookaheadRoot$ui_release = parent$ui_release.getLookaheadRoot$ui_release();
            } else {
                lookaheadRoot$ui_release = 0;
            }
            if (lookaheadRoot$ui_release != 0) {
                i = $this$isOutMostLookaheadRoot.getLayoutDelegate$ui_release().getDetachedFromParentLookaheadPass$ui_release() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private static final <T extends androidx.compose.ui.layout.Measurable> void updateChildMeasurables(androidx.compose.ui.node.LayoutNode $this$updateChildMeasurables, MutableVector<T> destination, Function1<? super androidx.compose.ui.node.LayoutNode, ? extends T> transform) {
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        int i2;
        Object invoke;
        final int i3 = 0;
        int i4 = 0;
        final MutableVector mutableVector = $this$updateChildMeasurables.get_children$ui_release();
        final int i5 = 0;
        final int size3 = mutableVector.getSize();
        if (size3 > 0) {
            i$iv$iv = 0;
            obj = mutableVector.getContent()[i$iv$iv];
            i = i$iv$iv;
            i2 = 0;
            do {
                obj = content[i$iv$iv];
                i = i$iv$iv;
                i2 = 0;
                destination.set(i, transform.invoke((LayoutNode)(LayoutNode)obj));
                if (i$iv$iv++ < size3) {
                }
                destination.add(transform.invoke(obj));
            } while (destination.getSize() <= i);
        }
        destination.removeRange($this$updateChildMeasurables.getChildren$ui_release().size(), destination.getSize());
    }
}
