package androidx.compose.ui.node;

import androidx.compose.runtime.AbstractApplier;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u0008H\u0016J\u0008\u0010\u000f\u001a\u00020\u0006H\u0014J\u0008\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u0008H\u0016¨\u0006\u0012", d2 = {"Landroidx/compose/ui/node/UiApplier;", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/compose/ui/node/LayoutNode;", "root", "(Landroidx/compose/ui/node/LayoutNode;)V", "insertBottomUp", "", "index", "", "instance", "insertTopDown", "move", "from", "to", "count", "onClear", "onEndChanges", "remove", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UiApplier extends AbstractApplier<androidx.compose.ui.node.LayoutNode> {

    public static final int $stable;
    static {
    }

    public UiApplier(androidx.compose.ui.node.LayoutNode root) {
        super(root);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void insertBottomUp(int index, androidx.compose.ui.node.LayoutNode instance) {
        (LayoutNode)getCurrent().insertAt$ui_release(index, instance);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void insertBottomUp(int index, Object instance) {
        insertBottomUp(index, (LayoutNode)instance);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void insertTopDown(int index, androidx.compose.ui.node.LayoutNode instance) {
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void insertTopDown(int index, Object instance) {
        insertTopDown(index, (LayoutNode)instance);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void move(int from, int to, int count) {
        (LayoutNode)getCurrent().move$ui_release(from, to, count);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    protected void onClear() {
        (LayoutNode)getRoot().removeAll$ui_release();
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void onEndChanges() {
        super.onEndChanges();
        androidx.compose.ui.node.Owner owner$ui_release = (LayoutNode)getRoot().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onEndApplyChanges();
        }
    }

    @Override // androidx.compose.runtime.AbstractApplier
    public void remove(int index, int count) {
        (LayoutNode)getCurrent().removeAt$ui_release(index, count);
    }
}
