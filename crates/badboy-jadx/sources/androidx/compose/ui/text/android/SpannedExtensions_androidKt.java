package androidx.compose.ui.text.android;

import android.text.Spanned;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¨\u0006\u0008", d2 = {"hasSpan", "", "Landroid/text/Spanned;", "clazz", "Ljava/lang/Class;", "startInclusive", "", "endExclusive", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpannedExtensions_androidKt {
    public static final boolean hasSpan(Spanned $this$hasSpan, Class<?> clazz) {
        int i;
        i = $this$hasSpan.nextSpanTransition(-1, $this$hasSpan.length(), clazz) != $this$hasSpan.length() ? 1 : 0;
        return i;
    }

    public static final boolean hasSpan(Spanned $this$hasSpan, Class<?> clazz, int startInclusive, int endExclusive) {
        int i;
        i = $this$hasSpan.nextSpanTransition(startInclusive + -1, endExclusive, clazz) != endExclusive ? 1 : 0;
        return i;
    }
}
