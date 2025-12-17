package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010(\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\u0016\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u000f\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0016\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SubSequence<T>  implements kotlin.sequences.Sequence<T>, kotlin.sequences.DropTakeSequence<T> {

    private final int endIndex;
    private final kotlin.sequences.Sequence<T> sequence;
    private final int startIndex;
    public SubSequence(kotlin.sequences.Sequence<? extends T> sequence, int startIndex, int endIndex) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        super();
        this.sequence = sequence;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        i3 = 1;
        int i7 = 0;
        i = this.startIndex >= 0 ? i3 : i7;
        if (i == 0) {
        } else {
            i2 = this.endIndex >= 0 ? i3 : i7;
            if (i2 == 0) {
            } else {
                if (this.endIndex >= this.startIndex) {
                } else {
                    i3 = i7;
                }
                if (i3 == 0) {
                } else {
                }
                int i5 = 0;
                StringBuilder stringBuilder2 = new StringBuilder();
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("endIndex should be not less than startIndex, but was ").append(this.endIndex).append(" < ").append(this.startIndex).toString().toString());
                throw illegalArgumentException2;
            }
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("endIndex should be non-negative, but is ").append(this.endIndex).toString().toString());
            throw illegalArgumentException;
        }
        int i6 = 0;
        StringBuilder stringBuilder3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder3.append("startIndex should be non-negative, but is ").append(this.startIndex).toString().toString());
        throw illegalArgumentException3;
    }

    public static final int access$getEndIndex$p(kotlin.sequences.SubSequence $this) {
        return $this.endIndex;
    }

    public static final kotlin.sequences.Sequence access$getSequence$p(kotlin.sequences.SubSequence $this) {
        return $this.sequence;
    }

    public static final int access$getStartIndex$p(kotlin.sequences.SubSequence $this) {
        return $this.startIndex;
    }

    private final int getCount() {
        return endIndex -= startIndex;
    }

    public kotlin.sequences.Sequence<T> drop(int n) {
        kotlin.sequences.Sequence emptySequence;
        kotlin.sequences.Sequence sequence;
        int i;
        int endIndex;
        if (n >= getCount()) {
            emptySequence = SequencesKt.emptySequence();
        } else {
            emptySequence = new SubSequence(this.sequence, startIndex += n, this.endIndex);
        }
        return emptySequence;
    }

    public Iterator<T> iterator() {
        SubSequence.iterator.1 anon = new SubSequence.iterator.1(this);
        return (Iterator)anon;
    }

    public kotlin.sequences.Sequence<T> take(int n) {
        Object subSequence;
        kotlin.sequences.Sequence sequence;
        int startIndex;
        int i;
        if (n >= getCount()) {
            subSequence = this;
        } else {
            subSequence = new SubSequence(this.sequence, this.startIndex, startIndex2 += n);
        }
        return subSequence;
    }
}
