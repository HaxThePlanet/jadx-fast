package androidx.compose.ui.text.android.selection;

import android.text.TextPaint;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0016J\u0010\u0010\n\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinderApi29;", "Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "text", "", "textPaint", "Landroid/text/TextPaint;", "(Ljava/lang/CharSequence;Landroid/text/TextPaint;)V", "next", "", "offset", "previous", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GraphemeClusterSegmentFinderApi29 extends androidx.compose.ui.text.android.selection.GraphemeClusterSegmentFinder {

    public static final int $stable = 8;
    private final java.lang.CharSequence text;
    private final TextPaint textPaint;
    static {
        final int i = 8;
    }

    public GraphemeClusterSegmentFinderApi29(java.lang.CharSequence text, TextPaint textPaint) {
        super();
        this.text = text;
        this.textPaint = textPaint;
    }

    @Override // androidx.compose.ui.text.android.selection.GraphemeClusterSegmentFinder
    public int next(int offset) {
        return this.textPaint.getTextRunCursor(this.text, 0, this.text.length(), false, offset, 0);
    }

    @Override // androidx.compose.ui.text.android.selection.GraphemeClusterSegmentFinder
    public int previous(int offset) {
        return this.textPaint.getTextRunCursor(this.text, 0, this.text.length(), false, offset, 2);
    }
}
