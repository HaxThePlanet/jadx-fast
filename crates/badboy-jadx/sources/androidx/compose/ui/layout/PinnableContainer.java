package androidx.compose.ui.layout;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001:\u0001\u0004J\u0008\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0005À\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/PinnableContainer;", "", "pin", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "PinnedHandle", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PinnableContainer {

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0004À\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "", "release", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PinnedHandle {
        public abstract void release();
    }
    public abstract androidx.compose.ui.layout.PinnableContainer.PinnedHandle pin();
}
