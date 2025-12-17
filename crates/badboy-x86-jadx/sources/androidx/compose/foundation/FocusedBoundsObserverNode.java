package androidx.compose.foundation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0006\u0008\u0000\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u001b\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0005R(\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u000cX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/FocusedBoundsObserverNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "onPositioned", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "(Lkotlin/jvm/functions/Function1;)V", "getOnPositioned", "()Lkotlin/jvm/functions/Function1;", "setOnPositioned", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "onFocusBoundsChanged", "focusedBounds", "TraverseKey", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusedBoundsObserverNode extends Modifier.Node implements TraversableNode {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.FocusedBoundsObserverNode.TraverseKey TraverseKey;
    private Function1<? super LayoutCoordinates, Unit> onPositioned;
    private final Object traverseKey;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/foundation/FocusedBoundsObserverNode$TraverseKey;", "", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TraverseKey {
        public TraverseKey(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        FocusedBoundsObserverNode.TraverseKey traverseKey = new FocusedBoundsObserverNode.TraverseKey(0);
        FocusedBoundsObserverNode.TraverseKey = traverseKey;
        int i = 8;
    }

    public FocusedBoundsObserverNode(Function1<? super LayoutCoordinates, Unit> onPositioned) {
        super();
        this.onPositioned = onPositioned;
        this.traverseKey = FocusedBoundsObserverNode.TraverseKey;
    }

    public final Function1<LayoutCoordinates, Unit> getOnPositioned() {
        return this.onPositioned;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void onFocusBoundsChanged(LayoutCoordinates focusedBounds) {
        this.onPositioned.invoke(focusedBounds);
        TraversableNode nearestAncestor = TraversableNodeKt.findNearestAncestor((TraversableNode)this);
        if ((FocusedBoundsObserverNode)nearestAncestor != null) {
            (FocusedBoundsObserverNode)nearestAncestor.onFocusBoundsChanged(focusedBounds);
        }
    }

    public final void setOnPositioned(Function1<? super LayoutCoordinates, Unit> <set-?>) {
        this.onPositioned = <set-?>;
    }
}
