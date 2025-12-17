package androidx.compose.ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001B-\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0008\u0010\u0012\u001a\u00020\u0005H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000cJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eJ%\u0010\u0013\u001a\u00020\u0005\"\u0004\u0008\u0000\u0010\u0015*\u0008\u0012\u0004\u0012\u0002H\u00150\t2\u0006\u0010\u0014\u001a\u0002H\u0015H\u0002¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "invalidateOwnerFocusState", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "focusEventNodes", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "focusPropertiesNodes", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "focusTargetNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusTargetsWithInvalidatedFocusEvents", "hasPendingInvalidation", "", "invalidateNodes", "scheduleInvalidation", "node", "T", "(Landroidx/collection/MutableScatterSet;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusInvalidationManager {

    public static final int $stable = 8;
    private final MutableScatterSet<androidx.compose.ui.focus.FocusEventModifierNode> focusEventNodes;
    private final MutableScatterSet<androidx.compose.ui.focus.FocusPropertiesModifierNode> focusPropertiesNodes;
    private final MutableScatterSet<androidx.compose.ui.focus.FocusTargetNode> focusTargetNodes;
    private final MutableScatterSet<androidx.compose.ui.focus.FocusTargetNode> focusTargetsWithInvalidatedFocusEvents;
    private final Function0<Unit> invalidateOwnerFocusState;
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;
    static {
        final int i = 8;
    }

    public FocusInvalidationManager(Function1<? super Function0<Unit>, Unit> onRequestApplyChangesListener, Function0<Unit> invalidateOwnerFocusState) {
        super();
        this.onRequestApplyChangesListener = onRequestApplyChangesListener;
        this.invalidateOwnerFocusState = invalidateOwnerFocusState;
        this.focusTargetNodes = ScatterSetKt.mutableScatterSetOf();
        this.focusEventNodes = ScatterSetKt.mutableScatterSetOf();
        this.focusPropertiesNodes = ScatterSetKt.mutableScatterSetOf();
        this.focusTargetsWithInvalidatedFocusEvents = ScatterSetKt.mutableScatterSetOf();
    }

    public static final void access$invalidateNodes(androidx.compose.ui.focus.FocusInvalidationManager $this) {
        $this.invalidateNodes();
    }

    private final void invalidateNodes() {
        MutableScatterSet this_$iv;
        MutableScatterSet focusEventNodes;
        MutableScatterSet this_$iv4;
        Object branches$iv$iv;
        int node$iv$iv3;
        Modifier.Node theNode$iv$iv;
        int count$iv$iv4;
        int count$iv$iv2;
        int j$iv$iv3;
        int j$iv$iv;
        int focusState;
        int count$iv$iv3;
        int count$iv$iv7;
        Object[] k$iv;
        int k$iv5;
        Object[] elements;
        int k$iv3;
        Modifier.Node requiresUpdate;
        int node$iv$iv6;
        int node$iv$iv13;
        Modifier.Node child$iv$iv2;
        Object child$iv$iv4;
        Modifier.Node node$iv$iv12;
        int capacity$iv$iv$iv$iv;
        int node$iv$iv8;
        int child$iv$iv3;
        int $i$f$visitChildren2;
        int this_$iv$iv$iv6;
        int node$iv$iv4;
        Modifier.Node k$iv2;
        MutableScatterSet count$iv$iv9;
        int this_$iv$iv$iv7;
        int count$iv$iv10;
        int count$iv$iv6;
        int count$iv$iv5;
        Object[] focusState2;
        int notEmpty;
        Modifier.Node node$iv$iv11;
        Modifier.Node this_$iv$iv$iv5;
        Object $i$f$visitChildren;
        Object this_$iv$iv$iv;
        int i$iv$iv2;
        int i$iv$iv3;
        int i$iv$iv;
        int slot$iv$iv;
        int j$iv$iv4;
        int value$iv$iv$iv2;
        long value$iv$iv$iv;
        int i7;
        int this_$iv2;
        Modifier.Node node$iv$iv7;
        int cmp;
        long this_$iv3;
        int $i$f$forEach;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i5;
        int j$iv$iv2;
        int i6;
        int aggregatedNode;
        int k$iv4;
        boolean focusTarget;
        int $i$f$getFocusTargetOLwlOKw;
        int $i$f$getFocusTargetOLwlOKw2;
        int i4;
        int node$iv$iv5;
        Object obj4;
        int i8;
        int node$iv$iv;
        int i3;
        int size;
        int theNode$iv$iv2;
        Modifier.Node theNode$iv$iv3;
        MutableScatterSet node$iv$iv9;
        Modifier.Node this_$iv$iv;
        Object obj2;
        int $i$f$forEachIndex;
        Object theNode$iv$iv4;
        int node$iv$iv$iv;
        int this_$iv$iv$iv2;
        MutableVector branches$iv$iv2;
        Modifier.Node child$iv$iv;
        int i;
        int this_$iv$iv$iv8;
        Object[] objArr;
        int node$iv$iv2;
        Modifier.Node count$iv$iv;
        Modifier.Node node;
        int branch$iv$iv;
        Object node$iv$iv$iv2;
        int this_$iv$iv$iv3;
        int i2;
        int i10;
        int node$iv$iv10;
        int this_$iv$iv$iv4;
        Object obj;
        int i9;
        int count$iv$iv8;
        Object obj3;
        int i11;
        Modifier.Node node2;
        final Object obj5 = this;
        this_$iv = obj5.focusPropertiesNodes;
        int i37 = 0;
        long[] metadata = set.metadata;
        length += -2;
        String str = "visitChildren called on an unattached node";
        final long l = -9187201950435737472L;
        cmp = 1024;
        final int i58 = 128;
        if (0 <= i41) {
        } else {
            node$iv$iv9 = this_$iv;
            node$iv$iv$iv = count$iv$iv2;
            objArr = k$iv;
            node$iv$iv = this_$iv2;
            i6 = 255;
        }
        obj5.focusPropertiesNodes.clear();
        focusEventNodes = obj5.focusEventNodes;
        count$iv$iv9 = focusEventNodes;
        long[] metadata2 = count$iv$iv9.metadata;
        length2 += -2;
        if (0 <= i42) {
        } else {
            this_$iv2 = focusEventNodes;
            this_$iv3 = j$iv$iv3;
            k$iv4 = elements;
            this_$iv$iv = count$iv$iv9;
            $i$f$forEachIndex = notEmpty;
            k$iv5 = 1;
        }
        obj5.focusEventNodes.clear();
        this_$iv4 = obj5.focusTargetNodes;
        int i40 = 0;
        long[] metadata3 = set2.metadata;
        length3 += -2;
        if (0 <= i43) {
        } else {
            this_$iv3 = this_$iv4;
            $i$f$forEach = focusState;
            this_$iv2 = focusState2;
        }
        obj5.focusTargetNodes.clear();
        obj5.focusTargetsWithInvalidatedFocusEvents.clear();
        obj5.invalidateOwnerFocusState.invoke();
        int i19 = 0;
        if (!obj5.focusPropertiesNodes.isEmpty()) {
            int i27 = 0;
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusProperties nodes");
        }
        int i20 = 0;
        if (!obj5.focusEventNodes.isEmpty()) {
            int i26 = 0;
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusEvent nodes");
        }
        int i21 = 0;
        if (!obj5.focusTargetNodes.isEmpty()) {
            int i25 = 0;
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusTarget nodes");
        }
    }

    private final <T> void scheduleInvalidation(MutableScatterSet<T> $this$scheduleInvalidation, T node) {
        boolean onRequestApplyChangesListener;
        int anon;
        if ($this$scheduleInvalidation.add(node) && i += size3 == 1) {
            if (i += size3 == 1) {
                anon = new FocusInvalidationManager.scheduleInvalidation.1(this);
                this.onRequestApplyChangesListener.invoke(anon);
            }
        }
    }

    public final boolean hasPendingInvalidation() {
        boolean notEmpty;
        int i;
        if (!this.focusTargetNodes.isNotEmpty() && !this.focusPropertiesNodes.isNotEmpty()) {
            if (!this.focusPropertiesNodes.isNotEmpty()) {
                if (this.focusEventNodes.isNotEmpty()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final void scheduleInvalidation(androidx.compose.ui.focus.FocusEventModifierNode node) {
        scheduleInvalidation(this.focusEventNodes, node);
    }

    public final void scheduleInvalidation(androidx.compose.ui.focus.FocusPropertiesModifierNode node) {
        scheduleInvalidation(this.focusPropertiesNodes, node);
    }

    public final void scheduleInvalidation(androidx.compose.ui.focus.FocusTargetNode node) {
        scheduleInvalidation(this.focusTargetNodes, node);
    }
}
