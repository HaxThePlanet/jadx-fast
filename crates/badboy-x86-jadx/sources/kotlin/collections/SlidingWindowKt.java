package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u00070\u0006\"\u0004\u0008\u0000\u0010\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u00070\u000e\"\u0004\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH\u0000¨\u0006\u000f", d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", "T", "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SlidingWindowKt {
    public static final void checkWindowSizeStep(int size, int step) {
        int i;
        String string;
        StringBuilder append;
        String str;
        if (size > 0 && step > 0) {
            i = step > 0 ? 1 : 0;
        } else {
        }
        if (i == 0) {
            int i2 = 0;
            String str2 = " must be greater than zero.";
            if (size != step) {
                StringBuilder stringBuilder2 = new StringBuilder();
                string = stringBuilder2.append("Both size ").append(size).append(" and step ").append(step).append(str2).toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                string = stringBuilder.append("size ").append(size).append(str2).toString();
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string.toString());
            throw illegalArgumentException;
        }
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> iterator, int size, int step, boolean partialWindows, boolean reuseBuffer) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        if (!iterator.hasNext()) {
            return (Iterator)EmptyIterator.INSTANCE;
        }
        SlidingWindowKt.windowedIterator.1 anon = new SlidingWindowKt.windowedIterator.1(size, step, iterator, reuseBuffer, partialWindows, 0);
        return SequencesKt.iterator((Function2)anon);
    }

    public static final <T> Sequence<List<T>> windowedSequence(Sequence<? extends T> $this$windowedSequence, int size, int step, boolean partialWindows, boolean reuseBuffer) {
        Intrinsics.checkNotNullParameter($this$windowedSequence, "<this>");
        SlidingWindowKt.checkWindowSizeStep(size, step);
        SlidingWindowKt.windowedSequence$$inlined.Sequence.1 anon = new SlidingWindowKt.windowedSequence$$inlined.Sequence.1($this$windowedSequence, size, step, partialWindows, reuseBuffer);
        return (Sequence)anon;
    }
}
