package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0005H\u0016R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u0007¨\u0006\r", d2 = {"Landroidx/compose/ui/layout/OnPlacedNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "(Lkotlin/jvm/functions/Function1;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "onPlaced", "coordinates", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class OnPlacedNode extends Modifier.Node implements LayoutAwareModifierNode {

    private Function1<? super androidx.compose.ui.layout.LayoutCoordinates, Unit> callback;
    public OnPlacedNode(Function1<? super androidx.compose.ui.layout.LayoutCoordinates, Unit> callback) {
        super();
        this.callback = callback;
    }

    public final Function1<androidx.compose.ui.layout.LayoutCoordinates, Unit> getCallback() {
        return this.callback;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onPlaced(androidx.compose.ui.layout.LayoutCoordinates coordinates) {
        this.callback.invoke(coordinates);
    }

    public final void setCallback(Function1<? super androidx.compose.ui.layout.LayoutCoordinates, Unit> <set-?>) {
        this.callback = <set-?>;
    }
}
