package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010(\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DropSequence<T>  implements kotlin.sequences.Sequence<T>, kotlin.sequences.DropTakeSequence<T> {

    private final int count;
    private final kotlin.sequences.Sequence<T> sequence;
    public DropSequence(kotlin.sequences.Sequence<? extends T> sequence, int count) {
        int i;
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        super();
        this.sequence = sequence;
        this.count = count;
        i = this.count >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("count must be non-negative, but was ").append(this.count).append('.').toString().toString());
        throw illegalArgumentException;
    }

    public static final int access$getCount$p(kotlin.sequences.DropSequence $this) {
        return $this.count;
    }

    public static final kotlin.sequences.Sequence access$getSequence$p(kotlin.sequences.DropSequence $this) {
        return $this.sequence;
    }

    public kotlin.sequences.Sequence<T> drop(int n) {
        Object sequence;
        count += n;
        final int i2 = 0;
        if (i < 0) {
            DropSequence dropSequence = new DropSequence((Sequence)this, n);
        } else {
            super(this.sequence, i);
        }
        return (Sequence)dropSequence;
    }

    public Iterator<T> iterator() {
        DropSequence.iterator.1 anon = new DropSequence.iterator.1(this);
        return (Iterator)anon;
    }

    public kotlin.sequences.Sequence<T> take(int n) {
        Object takeSequence;
        Object sequence;
        int count;
        count2 += n;
        final int i2 = 0;
        if (i < 0) {
            takeSequence = new TakeSequence((Sequence)this, n);
        } else {
            takeSequence = new SubSequence(this.sequence, this.count, i);
        }
        return (Sequence)(DropTakeSequence)takeSequence;
    }
}
