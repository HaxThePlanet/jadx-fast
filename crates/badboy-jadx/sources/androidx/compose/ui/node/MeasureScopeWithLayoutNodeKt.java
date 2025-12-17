package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00020\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u000c\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002¨\u0006\u0008", d2 = {"getChildrenOfVirtualChildren", "", "Landroidx/compose/ui/layout/Measurable;", "scope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "isInLookaheadPass", "", "Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MeasureScopeWithLayoutNodeKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal5;
            int ordinal4;
            int ordinal3;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
            iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 2;
            iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 3;
            iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 4;
            iArr[LayoutNode.LayoutState.Idle.ordinal()] = 5;
            MeasureScopeWithLayoutNodeKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final List<List<Measurable>> getChildrenOfVirtualChildren(IntrinsicMeasureScope scope) {
        int index$iv$iv;
        Object obj2;
        Object obj;
        int i;
        ArrayList list;
        List it;
        int i2;
        List childLookaheadMeasurables$ui_release;
        final Object obj3 = scope;
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type androidx.compose.ui.node.MeasureScopeWithLayoutNode");
        androidx.compose.ui.node.LayoutNode layoutNode = (MeasureScopeWithLayoutNode)obj3.getLayoutNode();
        List foldedChildren$ui_release = layoutNode.getFoldedChildren$ui_release();
        final int i3 = 0;
        ArrayList arrayList = new ArrayList(foldedChildren$ui_release.size());
        List list2 = foldedChildren$ui_release;
        final int i4 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list2.size()) {
            i = 0;
            Object obj5 = obj;
            i2 = 0;
            if (MeasureScopeWithLayoutNodeKt.isInLookaheadPass(layoutNode)) {
            } else {
            }
            childLookaheadMeasurables$ui_release = (LayoutNode)obj5.getChildMeasurables$ui_release();
            (Collection)arrayList.add(childLookaheadMeasurables$ui_release);
            index$iv$iv++;
            childLookaheadMeasurables$ui_release = obj5.getChildLookaheadMeasurables$ui_release();
        }
        return (List)arrayList;
    }

    private static final boolean isInLookaheadPass(androidx.compose.ui.node.LayoutNode $this$isInLookaheadPass) {
        int inLookaheadPass;
        switch (i) {
            case 1:
                inLookaheadPass = 1;
                break;
            case 2:
                inLookaheadPass = 0;
                break;
            case 3:
                androidx.compose.ui.node.LayoutNode parent$ui_release = $this$isInLookaheadPass.getParent$ui_release();
                inLookaheadPass = MeasureScopeWithLayoutNodeKt.isInLookaheadPass(parent$ui_release);
                int i2 = 0;
                IllegalArgumentException $i$a$RequireNotNullMeasureScopeWithLayoutNodeKt$isInLookaheadPass$1 = new IllegalArgumentException("no parent for idle node".toString());
                throw $i$a$RequireNotNullMeasureScopeWithLayoutNodeKt$isInLookaheadPass$1;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return inLookaheadPass;
    }
}
