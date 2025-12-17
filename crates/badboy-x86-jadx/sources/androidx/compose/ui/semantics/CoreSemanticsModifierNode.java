package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n¢\u0006\u0002\u0010\u000bJ\u000c\u0010\u0019\u001a\u00020\t*\u00020\u0008H\u0016R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u000c\"\u0004\u0008\u0010\u0010\u000eR+\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u000cR\u0014\u0010\u0017\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u000c¨\u0006\u001a", d2 = {"Landroidx/compose/ui/semantics/CoreSemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "mergeDescendants", "", "isClearingSemantics", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "(ZZLkotlin/jvm/functions/Function1;)V", "()Z", "setClearingSemantics", "(Z)V", "getMergeDescendants", "setMergeDescendants", "getProperties", "()Lkotlin/jvm/functions/Function1;", "setProperties", "(Lkotlin/jvm/functions/Function1;)V", "shouldClearDescendantSemantics", "getShouldClearDescendantSemantics", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CoreSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {

    public static final int $stable = 8;
    private boolean isClearingSemantics;
    private boolean mergeDescendants;
    private Function1<? super androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> properties;
    static {
        final int i = 8;
    }

    public CoreSemanticsModifierNode(boolean mergeDescendants, boolean isClearingSemantics, Function1<? super androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> properties) {
        super();
        this.mergeDescendants = mergeDescendants;
        this.isClearingSemantics = isClearingSemantics;
        this.properties = properties;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void applySemantics(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$applySemantics) {
        this.properties.invoke($this$applySemantics);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getMergeDescendants() {
        return this.mergeDescendants;
    }

    public final Function1<androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> getProperties() {
        return this.properties;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldClearDescendantSemantics() {
        return this.isClearingSemantics;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldMergeDescendantSemantics() {
        return this.mergeDescendants;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean isClearingSemantics() {
        return this.isClearingSemantics;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setClearingSemantics(boolean <set-?>) {
        this.isClearingSemantics = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setMergeDescendants(boolean <set-?>) {
        this.mergeDescendants = <set-?>;
    }

    public final void setProperties(Function1<? super androidx.compose.ui.semantics.SemanticsPropertyReceiver, Unit> <set-?>) {
        this.properties = <set-?>;
    }
}
