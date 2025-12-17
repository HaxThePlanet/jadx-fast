package androidx.compose.ui.node;

import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a+\u0010\u0000\u001a\u00020\u0001\"\u000c\u0008\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004*\u0002H\u00022\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"observeReads", "", "T", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier$Node;Lkotlin/jvm/functions/Function0;)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ObserverModifierNodeKt {
    public static final <T extends Modifier.Node & androidx.compose.ui.node.ObserverModifierNode> void observeReads(T $this$observeReads, Function0<Unit> block) {
        androidx.compose.ui.node.ObserverNodeOwnerScope ownerScope$ui_release;
        androidx.compose.ui.node.ObserverNodeOwnerScope observerNodeOwnerScope;
        int i;
        if ($this$observeReads.getOwnerScope$ui_release() == null) {
            ownerScope$ui_release = new ObserverNodeOwnerScope((ObserverModifierNode)$this$observeReads);
            i = 0;
            $this$observeReads.setOwnerScope$ui_release(ownerScope$ui_release);
        }
        DelegatableNodeKt.requireOwner((DelegatableNode)$this$observeReads).getSnapshotObserver().observeReads$ui_release((OwnerScope)ownerScope$ui_release, ObserverNodeOwnerScope.Companion.getOnObserveReadsChanged$ui_release(), block);
    }
}
