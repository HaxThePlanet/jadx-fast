package androidx.compose.ui.text.input;

import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003", d2 = {"toExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroidx/compose/ui/text/input/TextFieldValue;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InputState_androidKt {
    public static final ExtractedText toExtractedText(androidx.compose.ui.text.input.TextFieldValue $this$toExtractedText) {
        ExtractedText extractedText = new ExtractedText();
        extractedText.text = (CharSequence)$this$toExtractedText.getText();
        int i = 0;
        extractedText.startOffset = i;
        extractedText.partialEndOffset = $this$toExtractedText.getText().length();
        extractedText.partialStartOffset = -1;
        extractedText.selectionStart = TextRange.getMin-impl($this$toExtractedText.getSelection-d9O1mEE());
        extractedText.selectionEnd = TextRange.getMax-impl($this$toExtractedText.getSelection-d9O1mEE());
        extractedText.flags = contains$default ^= 1;
        return extractedText;
    }
}
