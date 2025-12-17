package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0007H\u0002\u001a\u0016\u0010\u0008\u001a\u00020\t*\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000c", d2 = {"DEBUG", "", "DEBUG_TAG", "", "logDebug", "", "text", "Lkotlin/Function0;", "reverse", "Landroidx/compose/ui/text/TextRange;", "reverse-5zc-tL8", "(J)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldSelectionStateKt {

    private static final boolean DEBUG = false;
    private static final String DEBUG_TAG = "TextFieldSelectionState";
    public static final void access$logDebug(Function0 text) {
        TextFieldSelectionStateKt.logDebug(text);
    }

    public static final long access$reverse-5zc-tL8(long $receiver) {
        return TextFieldSelectionStateKt.reverse-5zc-tL8($receiver);
    }

    private static final void logDebug(Function0<String> text) {
    }

    private static final long reverse-5zc-tL8(long $this$reverse_u2d5zc_u2dtL8) {
        return TextRangeKt.TextRange(TextRange.getEnd-impl($this$reverse_u2d5zc_u2dtL8), TextRange.getStart-impl($this$reverse_u2d5zc_u2dtL8));
    }
}
