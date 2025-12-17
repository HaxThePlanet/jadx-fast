package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0001¨\u0006\t", d2 = {"calculateAdjacentCursorPosition", "", "transformedText", "", "cursor", "forward", "", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextPreparedSelectionKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal4;
            int ordinal3;
            int ordinal2;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            iArr[IndexTransformationType.Replacement.ordinal()] = 3;
            iArr[IndexTransformationType.Insertion.ordinal()] = 4;
            TextPreparedSelectionKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final int calculateAdjacentCursorPosition(String transformedText, int cursor, boolean forward, TransformedTextFieldState state) {
        int precedingBreak;
        IndexTransformationType untransformed;
        boolean collapsed-impl;
        boolean collapsed-impl2;
        boolean collapsed-impl3;
        int start-impl;
        int ordinal;
        final Object obj2 = state;
        if (forward) {
            precedingBreak = StringHelpers_androidKt.findFollowingBreak(transformedText, cursor);
        } else {
            precedingBreak = StringHelpers_androidKt.findPrecedingBreak(transformedText, cursor);
        }
        if (precedingBreak == -1) {
            return cursor;
        }
        Object obj3 = state;
        final int i2 = 0;
        final long mapFromTransformed--jx7JFs = obj3.mapFromTransformed--jx7JFs(precedingBreak);
        final long mapToTransformed-GEjPoXI = obj3.mapToTransformed-GEjPoXI(mapFromTransformed--jx7JFs);
        if (TextRange.getCollapsed-impl(mapFromTransformed--jx7JFs) && TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
            if (TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
                untransformed = IndexTransformationType.Untransformed;
            } else {
                if (!TextRange.getCollapsed-impl(mapFromTransformed--jx7JFs) && !TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
                    if (!TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
                        untransformed = IndexTransformationType.Replacement;
                    } else {
                        if (TextRange.getCollapsed-impl(mapFromTransformed--jx7JFs) && !TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
                            untransformed = !TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI) ? IndexTransformationType.Insertion : IndexTransformationType.Deletion;
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        final long l = mapToTransformed-GEjPoXI;
        final int i3 = 0;
        switch (i4) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                start-impl = TextRange.getEnd-impl(l);
                start-impl = TextRange.getStart-impl(l);
                return start-impl;
            case 4:
                SelectionWedgeAffinity selectionWedgeAffinity2 = new SelectionWedgeAffinity(WedgeAffinity.Start);
                obj2.setSelectionWedgeAffinity(selectionWedgeAffinity2);
                return precedingBreak;
                SelectionWedgeAffinity selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.End);
                obj2.setSelectionWedgeAffinity(selectionWedgeAffinity);
                start-impl = cursor;
                SelectionWedgeAffinity selectionWedgeAffinity3 = new SelectionWedgeAffinity(WedgeAffinity.End);
                obj2.setSelectionWedgeAffinity(selectionWedgeAffinity3);
                return precedingBreak;
                SelectionWedgeAffinity selectionWedgeAffinity4 = new SelectionWedgeAffinity(WedgeAffinity.Start);
                obj2.setSelectionWedgeAffinity(selectionWedgeAffinity4);
                return cursor;
                return start-impl;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        start-impl = precedingBreak;
    }
}
