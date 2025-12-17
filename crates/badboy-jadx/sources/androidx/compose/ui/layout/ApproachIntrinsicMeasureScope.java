package androidx.compose.ui.layout;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008v\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0005\u0082\u0001\u0002\t\nø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/ApproachIntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-msEJaDk", "()J", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "getLookaheadSize-YbymL2g", "Landroidx/compose/ui/layout/ApproachIntrinsicsMeasureScope;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ApproachIntrinsicMeasureScope extends androidx.compose.ui.layout.IntrinsicMeasureScope {
    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public abstract long getLookaheadConstraints-msEJaDk();

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public abstract long getLookaheadSize-YbymL2g();
}
