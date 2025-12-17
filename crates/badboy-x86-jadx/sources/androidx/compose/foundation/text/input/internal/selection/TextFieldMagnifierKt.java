package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000c", d2 = {"calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-hUlJWOE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldMagnifierKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[Handle.Cursor.ordinal()] = 1;
            iArr[Handle.SelectionStart.ordinal()] = 2;
            iArr[Handle.SelectionEnd.ordinal()] = 3;
            TextFieldMagnifierKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final long calculateSelectionMagnifierCenterAndroid-hUlJWOE(TransformedTextFieldState textFieldState, androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState selectionState, TextLayoutState textLayoutState, long magnifierSize) {
        int visibleBounds;
        float localDragPosition;
        long offset;
        int unspecified-k-4lQ0M;
        LayoutCoordinates textLayoutNodeCoordinates;
        int i2;
        int start-impl;
        int[] $EnumSwitchMapping$0;
        boolean cmp;
        float f;
        long l;
        int width-impl;
        int it;
        int i;
        int centerY;
        long handleDragPosition-F1C5BW0 = selectionState.getHandleDragPosition-F1C5BW0();
        if (!OffsetKt.isUnspecified-k-4lQ0M(handleDragPosition-F1C5BW0)) {
            unspecified-k-4lQ0M = (CharSequence)textFieldState.getVisualText().length() == 0 ? 1 : 0;
            if (unspecified-k-4lQ0M != 0) {
                l = handleDragPosition-F1C5BW0;
                localDragPosition = textLayoutState;
                return Offset.Companion.getUnspecified-F1C5BW0();
            } else {
                long selection-d9O1mEE = textFieldState.getVisualText().getSelection-d9O1mEE();
                Handle draggingHandle = selectionState.getDraggingHandle();
                if (draggingHandle == null) {
                    i2 = -1;
                } else {
                    i2 = TextFieldMagnifierKt.WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
                }
                switch (i2) {
                    case -1:
                        return Offset.Companion.getUnspecified-F1C5BW0();
                    case 0:
                        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException;
                    case 1:
                        start-impl = TextRange.getStart-impl(selection-d9O1mEE);
                        break;
                    default:
                        start-impl = TextRange.getEnd-impl(selection-d9O1mEE);
                }
                TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
                if (layoutResult == null) {
                    return Offset.Companion.getUnspecified-F1C5BW0();
                }
                final float x-impl = Offset.getX-impl(handleDragPosition-F1C5BW0);
                final int lineForOffset = layoutResult.getLineForOffset(start-impl);
                final float lineLeft = layoutResult.getLineLeft(lineForOffset);
                final float lineRight = layoutResult.getLineRight(lineForOffset);
                final float coerceIn = RangesKt.coerceIn(x-impl, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
                long l2 = handleDragPosition-F1C5BW0;
                float localDragPosition2 = magnifierSize;
                if (!IntSize.equals-impl0(localDragPosition2, obj1)) {
                    i = 2;
                    if (Float.compare(f6, f) > 0) {
                        return Offset.Companion.getUnspecified-F1C5BW0();
                    }
                } else {
                    i = 2;
                }
                float lineTop = layoutResult.getLineTop(lineForOffset);
                visibleBounds = i7 + lineTop;
                it = 0;
                final long l3 = selection-d9O1mEE;
                textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
                if (textLayoutNodeCoordinates != null) {
                    i = 0;
                    if (textLayoutNodeCoordinates.isAttached()) {
                    } else {
                        textLayoutNodeCoordinates = 0;
                    }
                    if (textLayoutNodeCoordinates != 0) {
                        it = 0;
                        centerY = visibleBounds;
                        offset = TextLayoutStateKt.coerceIn-3MmeM6k(OffsetKt.Offset(coerceIn, visibleBounds), selection-d9O1mEE);
                    } else {
                        centerY = visibleBounds;
                    }
                } else {
                }
            }
            return TextLayoutStateKt.fromTextLayoutToCore-Uv8p0NA(textLayoutState, offset);
        }
        l = handleDragPosition-F1C5BW0;
        localDragPosition = textLayoutState;
    }
}
