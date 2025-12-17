package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003", d2 = {"hasLinks", "", "Landroidx/compose/ui/text/AnnotatedString;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextAnnotatedStringNodeKt {
    public static final boolean hasLinks(AnnotatedString $this$hasLinks) {
        return $this$hasLinks.hasLinkAnnotations(0, $this$hasLinks.length());
    }
}
