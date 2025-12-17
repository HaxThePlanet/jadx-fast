package androidx.compose.ui.text.android.selection;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008`\u0018\u0000 \u00082\u00020\u0001:\u0001\u0008J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\tÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/text/android/selection/SegmentFinder;", "", "nextEndBoundary", "", "offset", "nextStartBoundary", "previousEndBoundary", "previousStartBoundary", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SegmentFinder {

    public static final androidx.compose.ui.text.android.selection.SegmentFinder.Companion Companion = null;
    public static final int DONE = -1;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Landroidx/compose/ui/text/android/selection/SegmentFinder$Companion;", "", "()V", "DONE", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.text.android.selection.SegmentFinder.Companion $$INSTANCE = null;
        public static final int DONE = -1;
        static {
            SegmentFinder.Companion companion = new SegmentFinder.Companion();
            SegmentFinder.Companion.$$INSTANCE = companion;
        }
    }
    static {
        SegmentFinder.Companion = SegmentFinder.Companion.$$INSTANCE;
    }

    public abstract int nextEndBoundary(int i);

    public abstract int nextStartBoundary(int i);

    public abstract int previousEndBoundary(int i);

    public abstract int previousStartBoundary(int i);
}
