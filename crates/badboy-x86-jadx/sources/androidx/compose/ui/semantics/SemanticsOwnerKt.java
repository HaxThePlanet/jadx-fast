package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\"\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u001a,\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\u0008*\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¨\u0006\u000b", d2 = {"getAllSemanticsNodes", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "mergingEnabled", "", "skipDeactivatedNodes", "getAllSemanticsNodesToMap", "", "", "useUnmergedTree", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SemanticsOwnerKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use a new overload instead")
    public static final List getAllSemanticsNodes(androidx.compose.ui.semantics.SemanticsOwner $this$getAllSemanticsNodes, boolean mergingEnabled) {
        return SemanticsOwnerKt.getAllSemanticsNodes($this$getAllSemanticsNodes, mergingEnabled, true);
    }

    public static final List<androidx.compose.ui.semantics.SemanticsNode> getAllSemanticsNodes(androidx.compose.ui.semantics.SemanticsOwner $this$getAllSemanticsNodes, boolean mergingEnabled, boolean skipDeactivatedNodes) {
        return CollectionsKt.toList((Iterable)SemanticsOwnerKt.getAllSemanticsNodesToMap($this$getAllSemanticsNodes, mergingEnabled ^ 1, skipDeactivatedNodes).values());
    }

    public static List getAllSemanticsNodes$default(androidx.compose.ui.semantics.SemanticsOwner semanticsOwner, boolean z2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 1;
        }
        return SemanticsOwnerKt.getAllSemanticsNodes(semanticsOwner, z2, obj2);
    }

    public static final Map<Integer, androidx.compose.ui.semantics.SemanticsNode> getAllSemanticsNodesToMap(androidx.compose.ui.semantics.SemanticsOwner $this$getAllSemanticsNodesToMap, boolean useUnmergedTree, boolean skipDeactivatedNodes) {
        androidx.compose.ui.semantics.SemanticsNode unmergedRootSemanticsNode;
        boolean deactivated;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (useUnmergedTree) {
            unmergedRootSemanticsNode = $this$getAllSemanticsNodesToMap.getUnmergedRootSemanticsNode();
        } else {
            unmergedRootSemanticsNode = $this$getAllSemanticsNodesToMap.getRootSemanticsNode();
        }
        if (skipDeactivatedNodes) {
            if (!unmergedRootSemanticsNode.getLayoutNode$ui_release().isDeactivated()) {
                SemanticsOwnerKt.getAllSemanticsNodesToMap$findAllSemanticNodesRecursive((Map)linkedHashMap, skipDeactivatedNodes, unmergedRootSemanticsNode);
            }
        } else {
        }
        return linkedHashMap;
    }

    public static Map getAllSemanticsNodesToMap$default(androidx.compose.ui.semantics.SemanticsOwner semanticsOwner, boolean z2, boolean z3, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = 1;
        }
        return SemanticsOwnerKt.getAllSemanticsNodesToMap(semanticsOwner, obj1, obj2);
    }

    private static final void getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(Map<Integer, androidx.compose.ui.semantics.SemanticsNode> nodes, boolean $skipDeactivatedNodes, androidx.compose.ui.semantics.SemanticsNode currentNode) {
        int index$iv;
        int i;
        int i2;
        int i3;
        nodes.put(Integer.valueOf(currentNode.getId()), currentNode);
        final List obj9 = SemanticsNode.getChildren$ui_release$default(currentNode, false, false, $skipDeactivatedNodes ^ 1, 3, 0);
        int i4 = 0;
        index$iv = 0;
        while (index$iv < obj9.size()) {
            i3 = 0;
            SemanticsOwnerKt.getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(nodes, $skipDeactivatedNodes, (SemanticsNode)obj9.get(index$iv));
            index$iv++;
        }
    }
}
