package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u0008\n\u0002\u0010\r\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0008¨\u0006\t", d2 = {"findParagraphEnd", "", "", "startIndex", "findParagraphStart", "getParagraphBoundary", "Landroidx/compose/ui/text/TextRange;", "index", "(Ljava/lang/CharSequence;I)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StringHelpersKt {
    public static final int findParagraphEnd(java.lang.CharSequence $this$findParagraphEnd, int startIndex) {
        int index;
        char charAt;
        int i;
        index = startIndex;
        while (index < $this$findParagraphEnd.length()) {
            index++;
        }
        return $this$findParagraphEnd.length();
    }

    public static final int findParagraphStart(java.lang.CharSequence $this$findParagraphStart, int startIndex) {
        int index;
        char charAt;
        int i;
        index = startIndex;
        while (index > 0) {
            index--;
        }
        return 0;
    }

    public static final long getParagraphBoundary(java.lang.CharSequence $this$getParagraphBoundary, int index) {
        return TextRangeKt.TextRange(StringHelpersKt.findParagraphStart($this$getParagraphBoundary, index), StringHelpersKt.findParagraphEnd($this$getParagraphBoundary, index));
    }
}
