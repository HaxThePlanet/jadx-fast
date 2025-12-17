package kotlin.sequences;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008`\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002J\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007", d2 = {"Lkotlin/sequences/DropTakeSequence;", "T", "Lkotlin/sequences/Sequence;", "drop", "n", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface DropTakeSequence<T>  extends kotlin.sequences.Sequence<T> {
    public abstract kotlin.sequences.Sequence<T> drop(int i);

    public abstract kotlin.sequences.Sequence<T> take(int i);
}
