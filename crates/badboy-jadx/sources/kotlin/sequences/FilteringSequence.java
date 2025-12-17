package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0000\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\u0008J\u000f\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FilteringSequence<T>  implements kotlin.sequences.Sequence<T> {

    private final Function1<T, Boolean> predicate;
    private final boolean sendWhen;
    private final kotlin.sequences.Sequence<T> sequence;
    public FilteringSequence(kotlin.sequences.Sequence<? extends T> sequence, boolean sendWhen, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        super();
        this.sequence = sequence;
        this.sendWhen = sendWhen;
        this.predicate = predicate;
    }

    public FilteringSequence(kotlin.sequences.Sequence sequence, boolean z2, Function1 function13, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj2;
        obj2 = i4 &= 2 != 0 ? 1 : obj2;
        super(sequence, obj2, function13);
    }

    public static final Function1 access$getPredicate$p(kotlin.sequences.FilteringSequence $this) {
        return $this.predicate;
    }

    public static final boolean access$getSendWhen$p(kotlin.sequences.FilteringSequence $this) {
        return $this.sendWhen;
    }

    public static final kotlin.sequences.Sequence access$getSequence$p(kotlin.sequences.FilteringSequence $this) {
        return $this.sequence;
    }

    public Iterator<T> iterator() {
        FilteringSequence.iterator.1 anon = new FilteringSequence.iterator.1(this);
        return (Iterator)anon;
    }
}
