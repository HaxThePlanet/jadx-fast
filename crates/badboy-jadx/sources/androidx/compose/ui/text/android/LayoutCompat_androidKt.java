package androidx.compose.ui.text.android;

import android.text.Layout;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0001\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006", d2 = {"getLineForOffset", "", "Landroid/text/Layout;", "offset", "upstream", "", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayoutCompat_androidKt {
    public static final int getLineForOffset(Layout $this$getLineForOffset, int offset, boolean upstream) {
        int i;
        if (offset <= 0) {
            return 0;
        }
        if (offset >= $this$getLineForOffset.getText().length()) {
            return lineCount--;
        }
        int lineForOffset = $this$getLineForOffset.getLineForOffset(offset);
        final int lineStart = $this$getLineForOffset.getLineStart(lineForOffset);
        if (lineStart != offset && $this$getLineForOffset.getLineEnd(lineForOffset) != offset) {
            if ($this$getLineForOffset.getLineEnd(lineForOffset) != offset) {
                return lineForOffset;
            }
        }
        if (lineStart == offset) {
            i = upstream != null ? lineForOffset + -1 : lineForOffset;
        } else {
            if (upstream != null) {
            } else {
                i = lineForOffset + 1;
            }
        }
        return i;
    }
}
