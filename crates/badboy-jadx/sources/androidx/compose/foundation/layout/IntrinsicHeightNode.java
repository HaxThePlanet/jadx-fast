package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001c\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u001c\u0010\u001c\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"Landroidx/compose/foundation/layout/IntrinsicHeightNode;", "Landroidx/compose/foundation/layout/IntrinsicSizeModifier;", "height", "Landroidx/compose/foundation/layout/IntrinsicSize;", "enforceIncoming", "", "(Landroidx/compose/foundation/layout/IntrinsicSize;Z)V", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "getHeight", "()Landroidx/compose/foundation/layout/IntrinsicSize;", "setHeight", "(Landroidx/compose/foundation/layout/IntrinsicSize;)V", "calculateContentConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "calculateContentConstraints-l58MMJ0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicHeight", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class IntrinsicHeightNode extends androidx.compose.foundation.layout.IntrinsicSizeModifier {

    private boolean enforceIncoming;
    private androidx.compose.foundation.layout.IntrinsicSize height;
    public IntrinsicHeightNode(androidx.compose.foundation.layout.IntrinsicSize height, boolean enforceIncoming) {
        super();
        this.height = height;
        this.enforceIncoming = enforceIncoming;
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    public long calculateContentConstraints-l58MMJ0(MeasureScope $this$calculateContentConstraints_u2dl58MMJ0, Measurable measurable, long constraints) {
        int measuredHeight;
        if (this.height == IntrinsicSize.Min) {
            measuredHeight = measurable.minIntrinsicHeight(Constraints.getMaxWidth-impl(constraints));
        } else {
            measuredHeight = measurable.maxIntrinsicHeight(Constraints.getMaxWidth-impl(constraints));
        }
        if (measuredHeight < 0) {
            measuredHeight = 0;
        }
        return Constraints.Companion.fixedHeight-OenEA2s(measuredHeight);
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    public boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    public final androidx.compose.foundation.layout.IntrinsicSize getHeight() {
        return this.height;
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        int minIntrinsicHeight;
        if (this.height == IntrinsicSize.Min) {
            minIntrinsicHeight = measurable.minIntrinsicHeight(width);
        } else {
            minIntrinsicHeight = measurable.maxIntrinsicHeight(width);
        }
        return minIntrinsicHeight;
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        int minIntrinsicHeight;
        if (this.height == IntrinsicSize.Min) {
            minIntrinsicHeight = measurable.minIntrinsicHeight(width);
        } else {
            minIntrinsicHeight = measurable.maxIntrinsicHeight(width);
        }
        return minIntrinsicHeight;
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    public void setEnforceIncoming(boolean <set-?>) {
        this.enforceIncoming = <set-?>;
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    public final void setHeight(androidx.compose.foundation.layout.IntrinsicSize <set-?>) {
        this.height = <set-?>;
    }
}
