package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u001eB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0096@¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0017H\u0016R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\u0007R\u0014\u0010\r\u001a\u00020\tX\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u001f", d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewResponderNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "responder", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "(Landroidx/compose/foundation/relocation/BringIntoViewResponder;)V", "hasBeenPlaced", "", "getResponder", "()Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "setResponder", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "bringChildIntoView", "", "childCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPlaced", "coordinates", "TraverseKey", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BringIntoViewResponderNode extends Modifier.Node implements androidx.compose.foundation.relocation.BringIntoViewParent, LayoutAwareModifierNode, TraversableNode {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.relocation.BringIntoViewResponderNode.TraverseKey TraverseKey;
    private boolean hasBeenPlaced;
    private androidx.compose.foundation.relocation.BringIntoViewResponder responder;
    private final boolean shouldAutoInvalidate;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewResponderNode$TraverseKey;", "", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TraverseKey {
        public TraverseKey(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        BringIntoViewResponderNode.TraverseKey traverseKey = new BringIntoViewResponderNode.TraverseKey(0);
        BringIntoViewResponderNode.TraverseKey = traverseKey;
        int i = 8;
    }

    public BringIntoViewResponderNode(androidx.compose.foundation.relocation.BringIntoViewResponder responder) {
        super();
        this.responder = responder;
    }

    public static final Rect access$bringChildIntoView$localRect(androidx.compose.foundation.relocation.BringIntoViewResponderNode this$0, LayoutCoordinates $childCoordinates, Function0 $boundsProvider) {
        return BringIntoViewResponderNode.bringChildIntoView$localRect(this$0, $childCoordinates, $boundsProvider);
    }

    private static final Rect bringChildIntoView$localRect(androidx.compose.foundation.relocation.BringIntoViewResponderNode this$0, LayoutCoordinates $childCoordinates, Function0<Rect> $boundsProvider) {
        int i;
        int i2 = 0;
        if (!this$0.isAttached()) {
            return i2;
        }
        if (!this$0.hasBeenPlaced) {
            return i2;
        }
        int i4 = 0;
        i = $childCoordinates.isAttached() ? $childCoordinates : i2;
        if (i == 0) {
            return i2;
        }
        Object invoke = $boundsProvider.invoke();
        if ((Rect)invoke == null) {
            return i2;
        }
        return BringIntoViewRequesterKt__BringIntoViewResponderKt.access$localRectOf(DelegatableNodeKt.requireLayoutCoordinates((DelegatableNode)this$0), i, (Rect)invoke);
    }

    public Object bringChildIntoView(LayoutCoordinates childCoordinates, Function0<Rect> boundsProvider, Continuation<? super Unit> $completion) {
        BringIntoViewResponderNode.bringChildIntoView.parentRect.1 anon = new BringIntoViewResponderNode.bringChildIntoView.parentRect.1(this, childCoordinates, boundsProvider);
        BringIntoViewResponderNode.bringChildIntoView.2 anon2 = new BringIntoViewResponderNode.bringChildIntoView.2(this, childCoordinates, boundsProvider, (Function0)anon, 0);
        Object obj8 = CoroutineScopeKt.coroutineScope((Function2)anon2, $completion);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.foundation.relocation.BringIntoViewResponder getResponder() {
        return this.responder;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object getTraverseKey() {
        return BringIntoViewResponderNode.TraverseKey;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onPlaced(LayoutCoordinates coordinates) {
        this.hasBeenPlaced = true;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setResponder(androidx.compose.foundation.relocation.BringIntoViewResponder <set-?>) {
        this.responder = <set-?>;
    }
}
