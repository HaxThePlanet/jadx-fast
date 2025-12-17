package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0012\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u00050\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0014\u001a\u00020\nHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0008\u0010\u0016\u001a\u00020\u0002H\u0016J\u0013\u0010\u0017\u001a\u00020\n2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0008HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\u000c\u0010 \u001a\u00020\u001e*\u00020!H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\"", d2 = {"Landroidx/compose/material3/TabIndicatorModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/TabIndicatorOffsetNode;", "tabPositionsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/material3/TabPosition;", "selectedTabIndex", "", "followContentSize", "", "(Landroidx/compose/runtime/State;IZ)V", "getFollowContentSize", "()Z", "getSelectedTabIndex", "()I", "getTabPositionsState", "()Landroidx/compose/runtime/State;", "component1", "component2", "component3", "copy", "create", "equals", "other", "", "hashCode", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabIndicatorModifier extends ModifierNodeElement<androidx.compose.material3.TabIndicatorOffsetNode> {

    public static final int $stable;
    private final boolean followContentSize;
    private final int selectedTabIndex;
    private final State<List<androidx.compose.material3.TabPosition>> tabPositionsState;
    static {
    }

    public TabIndicatorModifier(State<? extends List<androidx.compose.material3.TabPosition>> tabPositionsState, int selectedTabIndex, boolean followContentSize) {
        super();
        this.tabPositionsState = tabPositionsState;
        this.selectedTabIndex = selectedTabIndex;
        this.followContentSize = followContentSize;
    }

    public static androidx.compose.material3.TabIndicatorModifier copy$default(androidx.compose.material3.TabIndicatorModifier tabIndicatorModifier, State state2, int i3, boolean z4, int i5, Object object6) {
        State obj1;
        int obj2;
        boolean obj3;
        if (i5 & 1 != 0) {
            obj1 = tabIndicatorModifier.tabPositionsState;
        }
        if (i5 & 2 != 0) {
            obj2 = tabIndicatorModifier.selectedTabIndex;
        }
        if (i5 &= 4 != 0) {
            obj3 = tabIndicatorModifier.followContentSize;
        }
        return tabIndicatorModifier.copy(obj1, obj2, obj3);
    }

    public final State<List<androidx.compose.material3.TabPosition>> component1() {
        return this.tabPositionsState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int component2() {
        return this.selectedTabIndex;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean component3() {
        return this.followContentSize;
    }

    public final androidx.compose.material3.TabIndicatorModifier copy(State<? extends List<androidx.compose.material3.TabPosition>> state, int i2, boolean z3) {
        TabIndicatorModifier tabIndicatorModifier = new TabIndicatorModifier(state, i2, z3);
        return tabIndicatorModifier;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.material3.TabIndicatorOffsetNode create() {
        TabIndicatorOffsetNode tabIndicatorOffsetNode = new TabIndicatorOffsetNode(this.tabPositionsState, this.selectedTabIndex, this.followContentSize);
        return tabIndicatorOffsetNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TabIndicatorModifier) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.tabPositionsState, obj.tabPositionsState)) {
            return i2;
        }
        if (this.selectedTabIndex != obj.selectedTabIndex) {
            return i2;
        }
        if (this.followContentSize != obj.followContentSize) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getFollowContentSize() {
        return this.followContentSize;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int getSelectedTabIndex() {
        return this.selectedTabIndex;
    }

    public final State<List<androidx.compose.material3.TabPosition>> getTabPositionsState() {
        return this.tabPositionsState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i2 += i7;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TabIndicatorModifier(tabPositionsState=").append(this.tabPositionsState).append(", selectedTabIndex=").append(this.selectedTabIndex).append(", followContentSize=").append(this.followContentSize).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.material3.TabIndicatorOffsetNode node) {
        node.setTabPositionsState(this.tabPositionsState);
        node.setSelectedTabIndex(this.selectedTabIndex);
        node.setFollowContentSize(this.followContentSize);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((TabIndicatorOffsetNode)node);
    }
}
