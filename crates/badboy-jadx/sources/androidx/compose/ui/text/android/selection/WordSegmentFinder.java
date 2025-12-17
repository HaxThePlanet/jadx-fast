package androidx.compose.ui.text.android.selection;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0016J\u0010\u0010\n\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0016J\u0010\u0010\u000b\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0016J\u0010\u0010\u000c\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Landroidx/compose/ui/text/android/selection/WordSegmentFinder;", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "text", "", "wordIterator", "Landroidx/compose/ui/text/android/selection/WordIterator;", "(Ljava/lang/CharSequence;Landroidx/compose/ui/text/android/selection/WordIterator;)V", "nextEndBoundary", "", "offset", "nextStartBoundary", "previousEndBoundary", "previousStartBoundary", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WordSegmentFinder implements androidx.compose.ui.text.android.selection.SegmentFinder {

    public static final int $stable = 8;
    private final java.lang.CharSequence text;
    private final androidx.compose.ui.text.android.selection.WordIterator wordIterator;
    static {
        final int i = 8;
    }

    public WordSegmentFinder(java.lang.CharSequence text, androidx.compose.ui.text.android.selection.WordIterator wordIterator) {
        super();
        this.text = text;
        this.wordIterator = wordIterator;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextEndBoundary(int offset) {
        int boundary;
        boolean whitespace;
        int i;
        boundary = offset;
        boundary = this.wordIterator.nextBoundary(boundary);
        int i2 = -1;
        while (boundary == i2) {
            boundary = this.wordIterator.nextBoundary(boundary);
            i2 = -1;
        }
        return i2;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextStartBoundary(int offset) {
        int boundary;
        boolean whitespace;
        int length;
        boundary = offset;
        boundary = this.wordIterator.nextBoundary(boundary);
        int i = -1;
        while (boundary != i) {
            boundary = this.wordIterator.nextBoundary(boundary);
            i = -1;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousEndBoundary(int offset) {
        int boundary;
        boolean whitespace;
        int i;
        boundary = offset;
        while (/* condition */) {
            boundary = this.wordIterator.prevBoundary(boundary);
        }
        return -1;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousStartBoundary(int offset) {
        int boundary;
        boolean whitespace;
        boundary = offset;
        boundary = this.wordIterator.prevBoundary(boundary);
        int i = -1;
        while (boundary == i) {
            boundary = this.wordIterator.prevBoundary(boundary);
            i = -1;
        }
        return i;
    }
}
