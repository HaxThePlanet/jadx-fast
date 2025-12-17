package androidx.compose.ui.text.android.selection;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0008 \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0008\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u000b", d2 = {"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "()V", "next", "", "offset", "nextEndBoundary", "nextStartBoundary", "previous", "previousEndBoundary", "previousStartBoundary", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class GraphemeClusterSegmentFinder implements androidx.compose.ui.text.android.selection.SegmentFinder {

    public static final int $stable;
    static {
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public abstract int next(int i);

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextEndBoundary(int offset) {
        return next(offset);
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextStartBoundary(int offset) {
        int i;
        final int next = next(offset);
        i = -1;
        if (next == i) {
            return i;
        }
        if (next(next) == i) {
        } else {
            i = next;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public abstract int previous(int i);

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousEndBoundary(int offset) {
        int i;
        final int previous = previous(offset);
        i = -1;
        if (previous == i) {
            return i;
        }
        if (previous(previous) == i) {
        } else {
            i = previous;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousStartBoundary(int offset) {
        return previous(offset);
    }
}
