package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007", d2 = {"getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getTextAfterSelection", "maxChars", "", "getTextBeforeSelection", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldValueKt {
    public static final AnnotatedString getSelectedText(androidx.compose.ui.text.input.TextFieldValue $this$getSelectedText) {
        return $this$getSelectedText.getAnnotatedString().subSequence-5zc-tL8($this$getSelectedText.getSelection-d9O1mEE());
    }

    public static final AnnotatedString getTextAfterSelection(androidx.compose.ui.text.input.TextFieldValue $this$getTextAfterSelection, int maxChars) {
        return $this$getTextAfterSelection.getAnnotatedString().subSequence(TextRange.getMax-impl($this$getTextAfterSelection.getSelection-d9O1mEE()), Math.min(max-impl2 += maxChars, $this$getTextAfterSelection.getText().length()));
    }

    public static final AnnotatedString getTextBeforeSelection(androidx.compose.ui.text.input.TextFieldValue $this$getTextBeforeSelection, int maxChars) {
        return $this$getTextBeforeSelection.getAnnotatedString().subSequence(Math.max(0, min-impl -= maxChars), TextRange.getMin-impl($this$getTextBeforeSelection.getSelection-d9O1mEE()));
    }
}
