package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u000c\u0008\u0000\u0018\u00002\u00020\u0001B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B\u0011\u0008\u0016\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0004B\u0019\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00002\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0012\u001a\u00020\u00002\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000e¨\u0006\u0014", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "", "()V", "previous", "(Ljava/lang/Object;)V", "next", "(Ljava/lang/Object;Ljava/lang/Object;)V", "hasNext", "", "getHasNext", "()Z", "hasPrevious", "getHasPrevious", "getNext", "()Ljava/lang/Object;", "getPrevious", "withNext", "newNext", "withPrevious", "newPrevious", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Links {

    public static final int $stable = 8;
    private final Object next;
    private final Object previous;
    static {
        final int i = 8;
    }

    public Links() {
        super(EndOfChain.INSTANCE, EndOfChain.INSTANCE);
    }

    public Links(Object previous) {
        super(previous, EndOfChain.INSTANCE);
    }

    public Links(Object previous, Object next) {
        super();
        this.previous = previous;
        this.next = next;
    }

    public final boolean getHasNext() {
        int i;
        i = this.next != EndOfChain.INSTANCE ? 1 : 0;
        return i;
    }

    public final boolean getHasPrevious() {
        int i;
        i = this.previous != EndOfChain.INSTANCE ? 1 : 0;
        return i;
    }

    public final Object getNext() {
        return this.next;
    }

    public final Object getPrevious() {
        return this.previous;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links withNext(Object newNext) {
        Links links = new Links(this.previous, newNext);
        return links;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links withPrevious(Object newPrevious) {
        Links links = new Links(newPrevious, this.next);
        return links;
    }
}
