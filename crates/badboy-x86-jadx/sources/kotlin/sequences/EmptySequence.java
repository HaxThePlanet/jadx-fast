package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.EmptyIterator;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010(\n\u0002\u0008\u0002\u0008Â\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00020\u0003B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00020\tH\u0096\u0002J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b", d2 = {"Lkotlin/sequences/EmptySequence;", "Lkotlin/sequences/Sequence;", "", "Lkotlin/sequences/DropTakeSequence;", "()V", "drop", "n", "", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class EmptySequence implements kotlin.sequences.Sequence, kotlin.sequences.DropTakeSequence {

    public static final kotlin.sequences.EmptySequence INSTANCE;
    static {
        EmptySequence emptySequence = new EmptySequence();
        EmptySequence.INSTANCE = emptySequence;
    }

    @Override // kotlin.sequences.Sequence
    public kotlin.sequences.EmptySequence drop(int n) {
        return EmptySequence.INSTANCE;
    }

    @Override // kotlin.sequences.Sequence
    public kotlin.sequences.Sequence drop(int n) {
        return (Sequence)drop(n);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return (Iterator)EmptyIterator.INSTANCE;
    }

    @Override // kotlin.sequences.Sequence
    public kotlin.sequences.EmptySequence take(int n) {
        return EmptySequence.INSTANCE;
    }

    @Override // kotlin.sequences.Sequence
    public kotlin.sequences.Sequence take(int n) {
        return (Sequence)take(n);
    }
}
