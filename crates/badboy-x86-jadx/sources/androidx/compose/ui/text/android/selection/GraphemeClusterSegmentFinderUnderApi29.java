package androidx.compose.ui.text.android.selection;

import java.text.BreakIterator;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinderUnderApi29;", "Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "text", "", "(Ljava/lang/CharSequence;)V", "breakIterator", "Ljava/text/BreakIterator;", "kotlin.jvm.PlatformType", "next", "", "offset", "previous", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GraphemeClusterSegmentFinderUnderApi29 extends androidx.compose.ui.text.android.selection.GraphemeClusterSegmentFinder {

    public static final int $stable = 8;
    private final BreakIterator breakIterator;
    private final java.lang.CharSequence text;
    static {
        final int i = 8;
    }

    public GraphemeClusterSegmentFinderUnderApi29(java.lang.CharSequence text) {
        super();
        this.text = text;
        final BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        final int i = 0;
        characterInstance.setText(this.text.toString());
        this.breakIterator = characterInstance;
    }

    @Override // androidx.compose.ui.text.android.selection.GraphemeClusterSegmentFinder
    public int next(int offset) {
        return this.breakIterator.following(offset);
    }

    @Override // androidx.compose.ui.text.android.selection.GraphemeClusterSegmentFinder
    public int previous(int offset) {
        return this.breakIterator.preceding(offset);
    }
}
