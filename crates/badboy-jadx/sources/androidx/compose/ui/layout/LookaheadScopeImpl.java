package androidx.compose.ui.layout;

import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000c\u0010\r\u001a\u00020\u0004*\u00020\u0004H\u0016R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\u0005R\u0018\u0010\t\u001a\u00020\u0004*\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u000e", d2 = {"Landroidx/compose/ui/layout/LookaheadScopeImpl;", "Landroidx/compose/ui/layout/LookaheadScope;", "scopeCoordinates", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Lkotlin/jvm/functions/Function0;)V", "getScopeCoordinates", "()Lkotlin/jvm/functions/Function0;", "setScopeCoordinates", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "toLookaheadCoordinates", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LookaheadScopeImpl implements androidx.compose.ui.layout.LookaheadScope {

    public static final int $stable = 8;
    private Function0<? extends androidx.compose.ui.layout.LayoutCoordinates> scopeCoordinates;
    static {
        final int i = 8;
    }

    public LookaheadScopeImpl() {
        final int i = 0;
        super(i, 1, i);
    }

    public LookaheadScopeImpl(Function0<? extends androidx.compose.ui.layout.LayoutCoordinates> scopeCoordinates) {
        super();
        this.scopeCoordinates = scopeCoordinates;
    }

    public LookaheadScopeImpl(Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public androidx.compose.ui.layout.LayoutCoordinates getLookaheadScopeCoordinates(androidx.compose.ui.layout.Placeable.PlacementScope $this$lookaheadScopeCoordinates) {
        Function0 scopeCoordinates = this.scopeCoordinates;
        Intrinsics.checkNotNull(scopeCoordinates);
        return (LayoutCoordinates)scopeCoordinates.invoke();
    }

    public final Function0<androidx.compose.ui.layout.LayoutCoordinates> getScopeCoordinates() {
        return this.scopeCoordinates;
    }

    public final void setScopeCoordinates(Function0<? extends androidx.compose.ui.layout.LayoutCoordinates> <set-?>) {
        this.scopeCoordinates = <set-?>;
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public androidx.compose.ui.layout.LayoutCoordinates toLookaheadCoordinates(androidx.compose.ui.layout.LayoutCoordinates $this$toLookaheadCoordinates) {
        int it;
        int i;
        Object lookaheadLayoutCoordinates;
        if ($this$toLookaheadCoordinates instanceof LookaheadLayoutCoordinates) {
            it = $this$toLookaheadCoordinates;
        } else {
            it = 0;
        }
        if (it != 0) {
        } else {
            Intrinsics.checkNotNull($this$toLookaheadCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
            Object obj = $this$toLookaheadCoordinates;
            i = 0;
            lookaheadLayoutCoordinates = (NodeCoordinator)obj.getLookaheadDelegate();
            if (lookaheadLayoutCoordinates != null && lookaheadLayoutCoordinates.getLookaheadLayoutCoordinates() != null) {
                if (lookaheadLayoutCoordinates.getLookaheadLayoutCoordinates() != null) {
                } else {
                    lookaheadLayoutCoordinates = obj;
                }
            } else {
            }
            it = lookaheadLayoutCoordinates;
        }
        return it;
    }
}
