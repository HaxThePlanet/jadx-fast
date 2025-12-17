package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString.Builder;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"INLINE_CONTENT_TAG", "", "REPLACEMENT_CHAR", "appendInlineContent", "", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "id", "alternateText", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InlineTextContentKt {

    public static final String INLINE_CONTENT_TAG = "androidx.compose.foundation.text.inlineContent";
    private static final String REPLACEMENT_CHAR = "�";
    public static final void appendInlineContent(AnnotatedString.Builder $this$appendInlineContent, String id, String alternateText) {
        int i;
        i = (CharSequence)alternateText.length() > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            $this$appendInlineContent.pushStringAnnotation("androidx.compose.foundation.text.inlineContent", id);
            $this$appendInlineContent.append(alternateText);
            $this$appendInlineContent.pop();
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("alternateText can't be an empty string.".toString());
        throw illegalArgumentException;
    }

    public static void appendInlineContent$default(AnnotatedString.Builder annotatedString$Builder, String string2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = "�";
        }
        InlineTextContentKt.appendInlineContent(builder, string2, obj2);
    }
}
