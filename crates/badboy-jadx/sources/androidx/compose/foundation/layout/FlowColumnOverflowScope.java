package androidx.compose.foundation.layout;

import kotlin.Metadata;

/* loaded from: classes.dex */
@LayoutScopeMarker
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u0008g\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\u00038&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\u0005\u001a\u0004\u0008\n\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/layout/FlowColumnOverflowScope;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "shownItemCount", "", "getShownItemCount$annotations", "()V", "getShownItemCount", "()I", "totalItemCount", "getTotalItemCount$annotations", "getTotalItemCount", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FlowColumnOverflowScope extends androidx.compose.foundation.layout.FlowColumnScope {
    public static void getShownItemCount$annotations() {
    }

    public static void getTotalItemCount$annotations() {
    }

    @Override // androidx.compose.foundation.layout.FlowColumnScope
    public abstract int getShownItemCount();

    @Override // androidx.compose.foundation.layout.FlowColumnScope
    public abstract int getTotalItemCount();
}
