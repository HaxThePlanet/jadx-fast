package androidx.compose.ui.tooling.data;

import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.unit.IntRect;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0007\u0018\u00002\u00020\u0001BK\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0008\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0010\rR\u001a\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u0012", d2 = {"Landroidx/compose/ui/tooling/data/NodeGroup;", "Landroidx/compose/ui/tooling/data/Group;", "key", "", "node", "box", "Landroidx/compose/ui/unit/IntRect;", "data", "", "modifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "children", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/ui/unit/IntRect;Ljava/util/Collection;Ljava/util/List;Ljava/util/Collection;)V", "getModifierInfo", "()Ljava/util/List;", "getNode", "()Ljava/lang/Object;", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NodeGroup extends androidx.compose.ui.tooling.data.Group {

    public static final int $stable = 8;
    private final List<ModifierInfo> modifierInfo;
    private final Object node;
    static {
        final int i = 8;
    }

    public NodeGroup(Object key, Object node, IntRect box, Collection<? extends Object> data, List<ModifierInfo> modifierInfo, Collection<? extends androidx.compose.ui.tooling.data.Group> children) {
        super(key, 0, 0, 0, box, data, children, 0, 0);
        this.node = node;
        this.modifierInfo = modifierInfo;
    }

    public List<ModifierInfo> getModifierInfo() {
        return this.modifierInfo;
    }

    @Override // androidx.compose.ui.tooling.data.Group
    public final Object getNode() {
        return this.node;
    }
}
