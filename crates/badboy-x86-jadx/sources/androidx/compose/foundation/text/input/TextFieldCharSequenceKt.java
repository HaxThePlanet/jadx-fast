package androidx.compose.foundation.text.input;

import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0007", d2 = {"getSelectedText", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getTextAfterSelection", "maxChars", "", "getTextBeforeSelection", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldCharSequenceKt {
    public static final java.lang.CharSequence getSelectedText(androidx.compose.foundation.text.input.TextFieldCharSequence $this$getSelectedText) {
        return $this$getSelectedText.subSequence(TextRange.getMin-impl($this$getSelectedText.getSelection-d9O1mEE()), TextRange.getMax-impl($this$getSelectedText.getSelection-d9O1mEE()));
    }

    public static final java.lang.CharSequence getTextAfterSelection(androidx.compose.foundation.text.input.TextFieldCharSequence $this$getTextAfterSelection, int maxChars) {
        return $this$getTextAfterSelection.subSequence(TextRange.getMax-impl($this$getTextAfterSelection.getSelection-d9O1mEE()), Math.min(max-impl2 += maxChars, $this$getTextAfterSelection.length()));
    }

    public static final java.lang.CharSequence getTextBeforeSelection(androidx.compose.foundation.text.input.TextFieldCharSequence $this$getTextBeforeSelection, int maxChars) {
        return $this$getTextBeforeSelection.subSequence(Math.max(0, min-impl -= maxChars), TextRange.getMin-impl($this$getTextBeforeSelection.getSelection-d9O1mEE()));
    }
}
