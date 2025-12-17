package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.IntOffset;
import java.util.Map;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005", d2 = {"calculateAlignmentAndPlaceChildAsNeeded", "", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayoutModifierNodeCoordinatorKt {
    public static final int access$calculateAlignmentAndPlaceChildAsNeeded(androidx.compose.ui.node.LookaheadCapablePlaceable $receiver, AlignmentLine alignmentLine) {
        return LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded($receiver, alignmentLine);
    }

    private static final int calculateAlignmentAndPlaceChildAsNeeded(androidx.compose.ui.node.LookaheadCapablePlaceable $this$calculateAlignmentAndPlaceChildAsNeeded, AlignmentLine alignmentLine) {
        int i2;
        int i;
        int intValue;
        String string;
        StringBuilder append;
        String str;
        final androidx.compose.ui.node.LookaheadCapablePlaceable child = $this$calculateAlignmentAndPlaceChildAsNeeded.getChild();
        int i3 = 1;
        final int i4 = 0;
        i = child != null ? i3 : i4;
        int i6 = 0;
        if (i == 0) {
            int i7 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalStateException(stringBuilder.append("Child of ").append($this$calculateAlignmentAndPlaceChildAsNeeded).append(" cannot be null when calculating alignment line").toString());
        }
        intValue = Integer.MIN_VALUE;
        Object obj = $this$calculateAlignmentAndPlaceChildAsNeeded.getMeasureResult$ui_release().getAlignmentLines().get(alignmentLine);
        if ($this$calculateAlignmentAndPlaceChildAsNeeded.getMeasureResult$ui_release().getAlignmentLines().containsKey(alignmentLine) && (Integer)obj != null) {
            obj = $this$calculateAlignmentAndPlaceChildAsNeeded.getMeasureResult$ui_release().getAlignmentLines().get(alignmentLine);
            if ((Integer)(Integer)obj != null) {
                intValue = (Integer)(Integer)obj.intValue();
            }
            return intValue;
        }
        int i5 = child.get(alignmentLine);
        if (i5 == intValue) {
            return intValue;
        }
        child.setShallowPlacing$ui_release(i3);
        $this$calculateAlignmentAndPlaceChildAsNeeded.setPlacingForAlignment$ui_release(i3);
        $this$calculateAlignmentAndPlaceChildAsNeeded.replace$ui_release();
        child.setShallowPlacing$ui_release(i4);
        $this$calculateAlignmentAndPlaceChildAsNeeded.setPlacingForAlignment$ui_release(i4);
        if (alignmentLine instanceof HorizontalAlignmentLine) {
            y-impl += i5;
        } else {
            x-impl += i5;
        }
        return i2;
    }
}
