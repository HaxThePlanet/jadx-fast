package androidx.compose.ui.platform;

import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.semantics.ScrollAxisRange;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\r\u0008\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000cR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u001e\u0010\u0008\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\u0008\u001b\u0010\u0017\"\u0004\u0008\u001c\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010\u0010\"\u0004\u0008 \u0010\u0012¨\u0006!", d2 = {"Landroidx/compose/ui/platform/ScrollObservationScope;", "Landroidx/compose/ui/node/OwnerScope;", "semanticsNodeId", "", "allScopes", "", "oldXValue", "", "oldYValue", "horizontalScrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "verticalScrollAxisRange", "(ILjava/util/List;Ljava/lang/Float;Ljava/lang/Float;Landroidx/compose/ui/semantics/ScrollAxisRange;Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "getAllScopes", "()Ljava/util/List;", "getHorizontalScrollAxisRange", "()Landroidx/compose/ui/semantics/ScrollAxisRange;", "setHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "isValidOwnerScope", "", "()Z", "getOldXValue", "()Ljava/lang/Float;", "setOldXValue", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getOldYValue", "setOldYValue", "getSemanticsNodeId", "()I", "getVerticalScrollAxisRange", "setVerticalScrollAxisRange", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScrollObservationScope implements OwnerScope {

    public static final int $stable = 8;
    private final List<androidx.compose.ui.platform.ScrollObservationScope> allScopes;
    private ScrollAxisRange horizontalScrollAxisRange;
    private Float oldXValue;
    private Float oldYValue;
    private final int semanticsNodeId;
    private ScrollAxisRange verticalScrollAxisRange;
    static {
        final int i = 8;
    }

    public ScrollObservationScope(int semanticsNodeId, List<androidx.compose.ui.platform.ScrollObservationScope> allScopes, Float oldXValue, Float oldYValue, ScrollAxisRange horizontalScrollAxisRange, ScrollAxisRange verticalScrollAxisRange) {
        super();
        this.semanticsNodeId = semanticsNodeId;
        this.allScopes = allScopes;
        this.oldXValue = oldXValue;
        this.oldYValue = oldYValue;
        this.horizontalScrollAxisRange = horizontalScrollAxisRange;
        this.verticalScrollAxisRange = verticalScrollAxisRange;
    }

    public final List<androidx.compose.ui.platform.ScrollObservationScope> getAllScopes() {
        return this.allScopes;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final ScrollAxisRange getHorizontalScrollAxisRange() {
        return this.horizontalScrollAxisRange;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final Float getOldXValue() {
        return this.oldXValue;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final Float getOldYValue() {
        return this.oldYValue;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final int getSemanticsNodeId() {
        return this.semanticsNodeId;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final ScrollAxisRange getVerticalScrollAxisRange() {
        return this.verticalScrollAxisRange;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return this.allScopes.contains(this);
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final void setHorizontalScrollAxisRange(ScrollAxisRange <set-?>) {
        this.horizontalScrollAxisRange = <set-?>;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final void setOldXValue(Float <set-?>) {
        this.oldXValue = <set-?>;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final void setOldYValue(Float <set-?>) {
        this.oldYValue = <set-?>;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final void setVerticalScrollAxisRange(ScrollAxisRange <set-?>) {
        this.verticalScrollAxisRange = <set-?>;
    }
}
