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
        MutableScatterSet this_$iv4;
        MutableScatterSet focusEventNodes;
        MutableScatterSet this_$iv3;
        Object branches$iv$iv;
        int node$iv$iv13;
        Modifier.Node theNode$iv$iv;
        int count$iv$iv9;
        int count$iv$iv2;
        int j$iv$iv4;
        int j$iv$iv;
        int focusState2;
        int count$iv$iv5;
        int count$iv$iv8;
        Object[] k$iv3;
        int k$iv;
        Object[] elements;
        int k$iv5;
        Modifier.Node requiresUpdate;
        int node$iv$iv7;
        int node$iv$iv12;
        Modifier.Node child$iv$iv4;
        Object child$iv$iv2;
        Modifier.Node node$iv$iv2;
        int capacity$iv$iv$iv$iv;
        int node$iv$iv6;
        int child$iv$iv3;
        int $i$f$visitChildren;
        int this_$iv$iv$iv7;
        int node$iv$iv8;
        Modifier.Node k$iv4;
        MutableScatterSet count$iv$iv;
        int this_$iv$iv$iv6;
        int count$iv$iv4;
        int count$iv$iv6;
        int count$iv$iv10;
        Object[] focusState;
        int notEmpty;
        Modifier.Node node$iv$iv9;
        Modifier.Node this_$iv$iv$iv;
        Object $i$f$visitChildren2;
        Object this_$iv$iv$iv3;
        int i$iv$iv2;
        int i$iv$iv3;
        int i$iv$iv;
        int slot$iv$iv;
        int j$iv$iv2;
        int value$iv$iv$iv;
        long value$iv$iv$iv2;
        int i5;
        int this_$iv;
        Modifier.Node node$iv$iv3;
        int cmp;
        long this_$iv2;
        int $i$f$forEach;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i9;
        int j$iv$iv3;
        int i8;
        int aggregatedNode;
        int k$iv2;
        boolean focusTarget;
        int $i$f$getFocusTargetOLwlOKw2;
        int $i$f$getFocusTargetOLwlOKw;
        int i7;
        int node$iv$iv10;
        Object obj3;
        int i10;
        int node$iv$iv;
        int i2;
        int size;
        int theNode$iv$iv3;
        Modifier.Node theNode$iv$iv4;
        MutableScatterSet node$iv$iv5;
        Modifier.Node this_$iv$iv;
        Object obj;
        int $i$f$forEachIndex;
        Object theNode$iv$iv2;
        int node$iv$iv$iv2;
        int this_$iv$iv$iv5;
        MutableVector branches$iv$iv2;
        Modifier.Node child$iv$iv;
        int i11;
        int this_$iv$iv$iv8;
        Object[] objArr;
        int node$iv$iv11;
        Modifier.Node count$iv$iv7;
        Modifier.Node node;
        int branch$iv$iv;
        Object node$iv$iv$iv;
        int this_$iv$iv$iv2;
        int i3;
        int i6;
        int node$iv$iv4;
        int this_$iv$iv$iv4;
        Object obj4;
        int i;
        int count$iv$iv3;
        Object obj2;
        int i4;
        Modifier.Node node2;
        final Object obj5 = this;
        this_$iv4 = obj5.focusPropertiesNodes;
        int i37 = 0;
        long[] metadata = set.metadata;
        length += -2;
        String str = "visitChildren called on an unattached node";
        final long l = -9187201950435737472L;
        cmp = 1024;
        final int i58 = 128;
        if (0 <= i41) {
        } else {
            node$iv$iv5 = this_$iv4;
            node$iv$iv$iv2 = count$iv$iv2;
            objArr = k$iv3;
            node$iv$iv = this_$iv;
            i8 = 255;
        }
        obj5.focusPropertiesNodes.clear();
        focusEventNodes = obj5.focusEventNodes;
        count$iv$iv = focusEventNodes;
        long[] metadata2 = count$iv$iv.metadata;
        length2 += -2;
        if (0 <= i42) {
        } else {
            this_$iv = focusEventNodes;
            this_$iv2 = j$iv$iv4;
            k$iv2 = elements;
            this_$iv$iv = count$iv$iv;
            $i$f$forEachIndex = notEmpty;
            k$iv = 1;
        }
        obj5.focusEventNodes.clear();
        this_$iv3 = obj5.focusTargetNodes;
        int i40 = 0;
        long[] metadata3 = set2.metadata;
        length3 += -2;
        if (0 <= i43) {
        } else {
            this_$iv2 = this_$iv3;
            $i$f$forEach = focusState2;
            this_$iv = focusState;
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
