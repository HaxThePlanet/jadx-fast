package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.AbstractApplier;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u0008H\u0016J\u0008\u0010\u000f\u001a\u00020\u0006H\u0014J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u0008H\u0016J\u000c\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0002¨\u0006\u0013", d2 = {"Landroidx/compose/ui/graphics/vector/VectorApplier;", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/compose/ui/graphics/vector/VNode;", "root", "(Landroidx/compose/ui/graphics/vector/VNode;)V", "insertBottomUp", "", "index", "", "instance", "insertTopDown", "move", "from", "to", "count", "onClear", "remove", "asGroup", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorApplier extends AbstractApplier<androidx.compose.ui.graphics.vector.VNode> {

    public static final int $stable;
    static {
    }

    public VectorApplier(androidx.compose.ui.graphics.vector.VNode root) {
        super(root);
    }

    private final androidx.compose.ui.graphics.vector.GroupComponent asGroup(androidx.compose.ui.graphics.vector.VNode $this$asGroup) {
        if (!$this$asGroup instanceof GroupComponent) {
        } else {
            return (GroupComponent)$this$asGroup;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot only insert VNode into Group".toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void insertBottomUp(int index, androidx.compose.ui.graphics.vector.VNode instance) {
        asGroup((VNode)getCurrent()).insertAt(index, instance);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void insertBottomUp(int index, Object instance) {
        insertBottomUp(index, (VNode)instance);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void insertTopDown(int index, androidx.compose.ui.graphics.vector.VNode instance) {
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void insertTopDown(int index, Object instance) {
        insertTopDown(index, (VNode)instance);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void move(int from, int to, int count) {
        asGroup((VNode)getCurrent()).move(from, to, count);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    protected void onClear() {
        androidx.compose.ui.graphics.vector.GroupComponent group = asGroup((VNode)getRoot());
        final int i = 0;
        group.remove(0, group.getNumChildren());
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void remove(int index, int count) {
        asGroup((VNode)getCurrent()).remove(index, count);
    }
}
