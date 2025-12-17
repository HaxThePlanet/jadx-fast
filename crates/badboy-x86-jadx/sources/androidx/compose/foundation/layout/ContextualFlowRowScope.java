package androidx.compose.foundation.layout;

import kotlin.Metadata;

/* loaded from: classes.dex */
@LayoutScopeMarker
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008g\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005R\u0018\u0010\u0008\u001a\u00020\tX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0018\u0010\u000c\u001a\u00020\tX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006\u000eÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "Landroidx/compose/foundation/layout/FlowRowScope;", "indexInLine", "", "getIndexInLine", "()I", "lineIndex", "getLineIndex", "maxHeight", "Landroidx/compose/ui/unit/Dp;", "getMaxHeight-D9Ej5fM", "()F", "maxWidthInLine", "getMaxWidthInLine-D9Ej5fM", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ContextualFlowRowScope extends androidx.compose.foundation.layout.FlowRowScope {
    @Override // androidx.compose.foundation.layout.FlowRowScope
    public abstract int getIndexInLine();

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public abstract int getLineIndex();

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public abstract float getMaxHeight-D9Ej5fM();

    @Override // androidx.compose.foundation.layout.FlowRowScope
    public abstract float getMaxWidthInLine-D9Ej5fM();
}
