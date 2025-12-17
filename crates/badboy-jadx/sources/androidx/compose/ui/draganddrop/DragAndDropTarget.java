package androidx.compose.ui.draganddrop;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\rÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "", "onChanged", "", "event", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "onDrop", "", "onEnded", "onEntered", "onExited", "onMoved", "onStarted", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DragAndDropTarget {
    public void onChanged(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
    }

    public abstract boolean onDrop(androidx.compose.ui.draganddrop.DragAndDropEvent dragAndDropEvent);

    public void onEnded(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
    }

    public void onEntered(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
    }

    public void onExited(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
    }

    public void onMoved(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
    }

    public void onStarted(androidx.compose.ui.draganddrop.DragAndDropEvent event) {
    }
}
