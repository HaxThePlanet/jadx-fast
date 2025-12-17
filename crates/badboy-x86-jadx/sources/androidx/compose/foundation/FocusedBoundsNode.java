package androidx.compose.foundation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u0000 \u001a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0008H\u0016J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\u0006X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u001b", d2 = {"Landroidx/compose/foundation/FocusedBoundsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "()V", "isFocused", "", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "observer", "Landroidx/compose/foundation/FocusedBoundsObserverNode;", "getObserver", "()Landroidx/compose/foundation/FocusedBoundsObserverNode;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "notifyObserverWhenAttached", "", "onGloballyPositioned", "coordinates", "setFocus", "focused", "TraverseKey", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusedBoundsNode extends Modifier.Node implements TraversableNode, GlobalPositionAwareModifierNode {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.FocusedBoundsNode.TraverseKey TraverseKey;
    private boolean isFocused;
    private LayoutCoordinates layoutCoordinates;
    private final boolean shouldAutoInvalidate;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/foundation/FocusedBoundsNode$TraverseKey;", "", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TraverseKey {
        public TraverseKey(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        FocusedBoundsNode.TraverseKey traverseKey = new FocusedBoundsNode.TraverseKey(0);
        FocusedBoundsNode.TraverseKey = traverseKey;
        int i = 8;
    }

    private final androidx.compose.foundation.FocusedBoundsObserverNode getObserver() {
        boolean nearestAncestor;
        int i;
        boolean z;
        i = 0;
        if (isAttached()) {
            nearestAncestor = TraversableNodeKt.findNearestAncestor((DelegatableNode)this, FocusedBoundsObserverNode.TraverseKey);
            if (nearestAncestor instanceof FocusedBoundsObserverNode) {
                i = nearestAncestor;
            }
        } else {
        }
        return i;
    }

    private final void notifyObserverWhenAttached() {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates layoutCoordinates3 = this.layoutCoordinates;
        Intrinsics.checkNotNull(layoutCoordinates3);
        layoutCoordinates = getObserver();
        if (this.layoutCoordinates != null && layoutCoordinates3.isAttached() && layoutCoordinates != null) {
            layoutCoordinates3 = this.layoutCoordinates;
            Intrinsics.checkNotNull(layoutCoordinates3);
            if (layoutCoordinates3.isAttached()) {
                layoutCoordinates = getObserver();
                if (layoutCoordinates != null) {
                    layoutCoordinates.onFocusBoundsChanged(this.layoutCoordinates);
                }
            }
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object getTraverseKey() {
        return FocusedBoundsNode.TraverseKey;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        boolean attached;
        int i;
        this.layoutCoordinates = coordinates;
        if (!this.isFocused) {
        }
        if (coordinates.isAttached()) {
            notifyObserverWhenAttached();
        } else {
            attached = getObserver();
            if (attached != null) {
                attached.onFocusBoundsChanged(0);
            }
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setFocus(boolean focused) {
        boolean isFocused;
        int i;
        if (focused == this.isFocused) {
        }
        if (!focused) {
            isFocused = getObserver();
            if (isFocused != null) {
                isFocused.onFocusBoundsChanged(0);
            }
        } else {
            notifyObserverWhenAttached();
        }
        this.isFocused = focused;
    }
}
