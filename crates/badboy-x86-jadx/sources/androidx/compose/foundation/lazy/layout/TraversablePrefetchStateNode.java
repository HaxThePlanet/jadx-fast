package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\u0005R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\r", d2 = {"Landroidx/compose/foundation/lazy/layout/TraversablePrefetchStateNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;)V", "getPrefetchState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "setPrefetchState", "traverseKey", "", "getTraverseKey", "()Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TraversablePrefetchStateNode extends Modifier.Node implements TraversableNode {

    private androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState prefetchState;
    private final String traverseKey;
    public TraversablePrefetchStateNode(androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState prefetchState) {
        super();
        this.prefetchState = prefetchState;
        this.traverseKey = "androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode";
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object getTraverseKey() {
        return getTraverseKey();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public String getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setPrefetchState(androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState <set-?>) {
        this.prefetchState = <set-?>;
    }
}
