package androidx.compose.foundation.text.input.internal;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.os.Bundle;
import android.view.inputmethod.ExtractedText;
import androidx.compose.foundation.content.PlatformTransferableContent;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent.Source;
import androidx.compose.foundation.content.TransferableContent.Source.Companion;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\u0008\u001a\u00020\t*\u00020\nH\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u000c*\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"DEBUG_CLASS", "", "EXTRA_INPUT_CONTENT_INFO", "SIC_DEBUG", "", "getSIC_DEBUG$annotations", "()V", "STATELESS_TAG", "toExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "toTransferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "Landroidx/core/view/inputmethod/InputContentInfoCompat;", "extras", "Landroid/os/Bundle;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StatelessInputConnection_androidKt {

    private static final String DEBUG_CLASS = "StatelessInputConnection";
    private static final String EXTRA_INPUT_CONTENT_INFO = "EXTRA_INPUT_CONTENT_INFO";
    public static final boolean SIC_DEBUG = false;
    private static final String STATELESS_TAG = "StatelessIC";
    public static final ExtractedText access$toExtractedText(TextFieldCharSequence $receiver) {
        return StatelessInputConnection_androidKt.toExtractedText($receiver);
    }

    public static void getSIC_DEBUG$annotations() {
    }

    private static final ExtractedText toExtractedText(TextFieldCharSequence $this$toExtractedText) {
        ExtractedText extractedText = new ExtractedText();
        extractedText.text = (CharSequence)$this$toExtractedText;
        int i = 0;
        extractedText.startOffset = i;
        extractedText.partialEndOffset = $this$toExtractedText.length();
        extractedText.partialStartOffset = -1;
        extractedText.selectionStart = TextRange.getMin-impl($this$toExtractedText.getSelection-d9O1mEE());
        extractedText.selectionEnd = TextRange.getMax-impl($this$toExtractedText.getSelection-d9O1mEE());
        extractedText.flags = contains$default ^= 1;
        return extractedText;
    }

    public static final TransferableContent toTransferableContent(InputContentInfoCompat $this$toTransferableContent, Bundle extras) {
        Bundle eMPTY;
        ClipData.Item item = new ClipData.Item($this$toTransferableContent.getContentUri());
        ClipData clipData = new ClipData($this$toTransferableContent.getDescription(), item);
        eMPTY = extras == null ? Bundle.EMPTY : extras;
        PlatformTransferableContent platformTransferableContent = new PlatformTransferableContent($this$toTransferableContent.getLinkUri(), eMPTY);
        TransferableContent transferableContent = new TransferableContent(AndroidClipboardManager_androidKt.toClipEntry(clipData), AndroidClipboardManager_androidKt.toClipMetadata($this$toTransferableContent.getDescription()), TransferableContent.Source.Companion.getKeyboard-kB6V9T0(), platformTransferableContent, 0);
        return transferableContent;
    }
}
