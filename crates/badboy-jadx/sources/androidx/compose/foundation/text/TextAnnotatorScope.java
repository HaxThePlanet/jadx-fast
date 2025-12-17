package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString.Builder;
import androidx.compose.ui.text.SpanStyle;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "builder", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;)V", "replaceStyle", "", "style", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TextAnnotatorScope {

    private final AnnotatedString.Builder builder;
    public TextAnnotatorScope(AnnotatedString.Builder builder) {
        super();
        this.builder = builder;
    }

    public final void replaceStyle(SpanStyle style, int start, int end) {
        this.builder.addStyle(style, start, end);
    }
}
