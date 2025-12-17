package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"DEBUG", "", "DEBUG_CLASS", "", "TAG", "toExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroidx/compose/ui/text/input/TextFieldValue;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RecordingInputConnection_androidKt {

    public static final boolean DEBUG = false;
    private static final String DEBUG_CLASS = "RecordingInputConnection";
    public static final String TAG = "RecordingIC";
    public static final ExtractedText access$toExtractedText(TextFieldValue $receiver) {
        return RecordingInputConnection_androidKt.toExtractedText($receiver);
    }

    private static final ExtractedText toExtractedText(TextFieldValue $this$toExtractedText) {
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
