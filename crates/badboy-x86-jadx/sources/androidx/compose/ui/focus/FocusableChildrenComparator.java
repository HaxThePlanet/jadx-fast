package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Â\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\u0008\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000c\u001a\u00020\u000bH\u0002¨\u0006\r", d2 = {"Landroidx/compose/ui/focus/FocusableChildrenComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/focus/FocusTargetNode;", "Lkotlin/Comparator;", "()V", "compare", "", "focusTarget1", "focusTarget2", "pathFromRoot", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FocusableChildrenComparator implements Comparator<androidx.compose.ui.focus.FocusTargetNode> {

    public static final androidx.compose.ui.focus.FocusableChildrenComparator INSTANCE;
    static {
        FocusableChildrenComparator focusableChildrenComparator = new FocusableChildrenComparator();
        FocusableChildrenComparator.INSTANCE = focusableChildrenComparator;
    }

    private final MutableVector<LayoutNode> pathFromRoot(LayoutNode layoutNode) {
        Object current;
        int i = 0;
        final int i3 = 0;
        final int i4 = 0;
        MutableVector mutableVector = new MutableVector(new LayoutNode[16], i4);
        current = layoutNode;
        while (current != null) {
            mutableVector.add(i4, current);
            current = current.getParent$ui_release();
        }
        return mutableVector;
    }

    @Override // java.util.Comparator
    public int compare(androidx.compose.ui.focus.FocusTargetNode focusTarget1, androidx.compose.ui.focus.FocusTargetNode focusTarget2) {
        boolean eligibleForFocusSearch;
        int depth;
        MutableVector this_$iv2;
        int this_$iv;
        int i;
        int content;
        String str = "compare requires non-null focus targets";
        if (focusTarget1 == null) {
        } else {
            if (focusTarget2 == null) {
            } else {
                int i4 = 0;
                int i6 = 1;
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTarget1)) {
                    if (!FocusTraversalKt.isEligibleForFocusSearch(focusTarget2)) {
                    } else {
                        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode((DelegatableNode)focusTarget1);
                        LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode((DelegatableNode)focusTarget2);
                        if (Intrinsics.areEqual(requireLayoutNode, requireLayoutNode2)) {
                            return i4;
                        }
                        MutableVector pathFromRoot = pathFromRoot(requireLayoutNode);
                        MutableVector pathFromRoot2 = pathFromRoot(requireLayoutNode2);
                        int i9 = 0;
                        this_$iv = 0;
                        int i7 = Math.min(size -= i6, size2 -= i6);
                        if (0 > i7) {
                        }
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.".toString());
                    throw illegalStateException;
                }
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTarget1)) {
                    return -1;
                }
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTarget2)) {
                    return i6;
                }
                return i4;
            }
            int i3 = 0;
            IllegalArgumentException $i$a$RequireNotNullFocusableChildrenComparator$compare$2 = new IllegalArgumentException(str.toString());
            throw $i$a$RequireNotNullFocusableChildrenComparator$compare$2;
        }
        int i5 = 0;
        IllegalArgumentException $i$a$RequireNotNullFocusableChildrenComparator$compare$1 = new IllegalArgumentException(str.toString());
        throw $i$a$RequireNotNullFocusableChildrenComparator$compare$1;
    }

    @Override // java.util.Comparator
    public int compare(Object p0, Object p1) {
        return compare((FocusTargetNode)p0, (FocusTargetNode)p1);
    }
}
