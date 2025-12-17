package androidx.compose.ui.node;

import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u000b", d2 = {"Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "Landroidx/compose/ui/node/OwnerScope;", "observerNode", "Landroidx/compose/ui/node/ObserverModifierNode;", "(Landroidx/compose/ui/node/ObserverModifierNode;)V", "isValidOwnerScope", "", "()Z", "getObserverNode$ui_release", "()Landroidx/compose/ui/node/ObserverModifierNode;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ObserverNodeOwnerScope implements androidx.compose.ui.node.OwnerScope {

    public static final int $stable = 8;
    public static final androidx.compose.ui.node.ObserverNodeOwnerScope.Companion Companion;
    private static final Function1<androidx.compose.ui.node.ObserverNodeOwnerScope, Unit> OnObserveReadsChanged = 8;
    private final androidx.compose.ui.node.ObserverModifierNode observerNode;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Landroidx/compose/ui/node/ObserverNodeOwnerScope$Companion;", "", "()V", "OnObserveReadsChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "", "getOnObserveReadsChanged$ui_release", "()Lkotlin/jvm/functions/Function1;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Function1<androidx.compose.ui.node.ObserverNodeOwnerScope, Unit> getOnObserveReadsChanged$ui_release() {
            return ObserverNodeOwnerScope.access$getOnObserveReadsChanged$cp();
        }
    }
    static {
        ObserverNodeOwnerScope.Companion companion = new ObserverNodeOwnerScope.Companion(0);
        ObserverNodeOwnerScope.Companion = companion;
        int i = 8;
        androidx.compose.ui.node.ObserverNodeOwnerScope.Companion.OnObserveReadsChanged.1 iNSTANCE = ObserverNodeOwnerScope.Companion.OnObserveReadsChanged.1.INSTANCE;
    }

    public ObserverNodeOwnerScope(androidx.compose.ui.node.ObserverModifierNode observerNode) {
        super();
        this.observerNode = observerNode;
    }

    public static final Function1 access$getOnObserveReadsChanged$cp() {
        return ObserverNodeOwnerScope.OnObserveReadsChanged;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final androidx.compose.ui.node.ObserverModifierNode getObserverNode$ui_release() {
        return this.observerNode;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return this.observerNode.getNode().isAttached();
    }
}
