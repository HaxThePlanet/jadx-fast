package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0001¨\u0006\n", d2 = {"textFieldMagnifierNode", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "visible", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidTextFieldMagnifier_androidKt {
    public static final androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode textFieldMagnifierNode(TransformedTextFieldState textFieldState, androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState textFieldSelectionState, TextLayoutState textLayoutState, boolean visible) {
        androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode anon;
        if (Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, 0)) {
            anon = new TextFieldMagnifierNodeImpl28(textFieldState, textFieldSelectionState, textLayoutState, visible);
        } else {
            anon = new AndroidTextFieldMagnifier_androidKt.textFieldMagnifierNode.1();
        }
        return anon;
    }
}
