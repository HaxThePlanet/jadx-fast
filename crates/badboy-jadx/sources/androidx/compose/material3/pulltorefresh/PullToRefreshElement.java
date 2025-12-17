package androidx.compose.material3.pulltorefresh;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0008\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\u0016\u0010\u001b\u001a\u00020\u000cHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u0015JK\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cHÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0008\u0010 \u001a\u00020\u0002H\u0016J\u0013\u0010!\u001a\u00020\u00042\u0008\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0002H\u0016J\u000c\u0010*\u001a\u00020\u0007*\u00020+H\u0016R\u0011\u0010\u0008\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u000fR\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0019\u0010\u000b\u001a\u00020\u000cø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006,", d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/pulltorefresh/PullToRefreshModifierNode;", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "", "enabled", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "threshold", "Landroidx/compose/ui/unit/Dp;", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnabled", "()Z", "getOnRefresh", "()Lkotlin/jvm/functions/Function0;", "getState", "()Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "getThreshold-D9Ej5fM", "()F", "F", "component1", "component2", "component3", "component4", "component5", "component5-D9Ej5fM", "copy", "copy-M2VBTUQ", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;F)Landroidx/compose/material3/pulltorefresh/PullToRefreshElement;", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PullToRefreshElement extends ModifierNodeElement<androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode> {

    public static final int $stable;
    private final boolean enabled;
    private final boolean isRefreshing;
    private final Function0<Unit> onRefresh;
    private final androidx.compose.material3.pulltorefresh.PullToRefreshState state;
    private final float threshold;
    static {
    }

    private PullToRefreshElement(boolean isRefreshing, Function0<Unit> onRefresh, boolean enabled, androidx.compose.material3.pulltorefresh.PullToRefreshState state, float threshold) {
        super();
        this.isRefreshing = isRefreshing;
        this.onRefresh = onRefresh;
        this.enabled = enabled;
        this.state = state;
        this.threshold = threshold;
    }

    public PullToRefreshElement(boolean z, Function0 function02, boolean z3, androidx.compose.material3.pulltorefresh.PullToRefreshState pullToRefreshState4, float f5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(z, function02, z3, pullToRefreshState4, f5);
    }

    public static androidx.compose.material3.pulltorefresh.PullToRefreshElement copy-M2VBTUQ$default(androidx.compose.material3.pulltorefresh.PullToRefreshElement pullToRefreshElement, boolean z2, Function0 function03, boolean z4, androidx.compose.material3.pulltorefresh.PullToRefreshState pullToRefreshState5, float f6, int i7, Object object8) {
        boolean obj1;
        Function0 obj2;
        boolean obj3;
        androidx.compose.material3.pulltorefresh.PullToRefreshState obj4;
        float obj5;
        if (i7 & 1 != 0) {
            obj1 = pullToRefreshElement.isRefreshing;
        }
        if (i7 & 2 != 0) {
            obj2 = pullToRefreshElement.onRefresh;
        }
        if (i7 & 4 != 0) {
            obj3 = pullToRefreshElement.enabled;
        }
        if (i7 & 8 != 0) {
            obj4 = pullToRefreshElement.state;
        }
        if (i7 &= 16 != 0) {
            obj5 = pullToRefreshElement.threshold;
        }
        return pullToRefreshElement.copy-M2VBTUQ(obj1, obj2, obj3, obj4, obj5);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean component1() {
        return this.isRefreshing;
    }

    public final Function0<Unit> component2() {
        return this.onRefresh;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean component3() {
        return this.enabled;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.material3.pulltorefresh.PullToRefreshState component4() {
        return this.state;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component5-D9Ej5fM() {
        return this.threshold;
    }

    public final androidx.compose.material3.pulltorefresh.PullToRefreshElement copy-M2VBTUQ(boolean z, Function0<Unit> function02, boolean z3, androidx.compose.material3.pulltorefresh.PullToRefreshState pullToRefreshState4, float f5) {
        PullToRefreshElement pullToRefreshElement = new PullToRefreshElement(z, function02, z3, pullToRefreshState4, f5, 0);
        return pullToRefreshElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode create() {
        PullToRefreshModifierNode pullToRefreshModifierNode = new PullToRefreshModifierNode(this.isRefreshing, this.onRefresh, this.enabled, this.state, this.threshold, 0);
        return pullToRefreshModifierNode;
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
        if (!object instanceof PullToRefreshElement) {
            return i2;
        }
        Object obj = object;
        if (this.isRefreshing != obj.isRefreshing) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onRefresh, obj.onRefresh)) {
            return i2;
        }
        if (this.enabled != obj.enabled) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.state, obj.state)) {
            return i2;
        }
        if (!Dp.equals-impl0(this.threshold, obj.threshold)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function0<Unit> getOnRefresh() {
        return this.onRefresh;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.material3.pulltorefresh.PullToRefreshState getState() {
        return this.state;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getThreshold-D9Ej5fM() {
        return this.threshold;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i4 += i13;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("PullToRefreshModifierNode");
        $this$inspectableProperties.getProperties().set("isRefreshing", Boolean.valueOf(this.isRefreshing));
        $this$inspectableProperties.getProperties().set("onRefresh", this.onRefresh);
        $this$inspectableProperties.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        $this$inspectableProperties.getProperties().set("state", this.state);
        $this$inspectableProperties.getProperties().set("threshold", Dp.box-impl(this.threshold));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("PullToRefreshElement(isRefreshing=").append(this.isRefreshing).append(", onRefresh=").append(this.onRefresh).append(", enabled=").append(this.enabled).append(", state=").append(this.state).append(", threshold=").append(Dp.toString-impl(this.threshold)).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode node) {
        boolean isRefreshing;
        node.setOnRefresh(this.onRefresh);
        node.setEnabled(this.enabled);
        node.setState(this.state);
        node.setThreshold-0680j_4(this.threshold);
        if (node.isRefreshing() != this.isRefreshing) {
            node.setRefreshing(this.isRefreshing);
            node.update();
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((PullToRefreshModifierNode)node);
    }
}
