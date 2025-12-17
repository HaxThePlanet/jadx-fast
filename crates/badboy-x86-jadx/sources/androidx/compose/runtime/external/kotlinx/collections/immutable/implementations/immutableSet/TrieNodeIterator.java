package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000b\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u000cJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000b\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ%\u0010\u0014\u001a\u00020\u00122\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\u0015R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNodeIterator;", "E", "", "()V", "buffer", "", "[Ljava/lang/Object;", "index", "", "currentElement", "()Ljava/lang/Object;", "currentNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "hasNextCell", "", "hasNextElement", "hasNextNode", "moveToNextCell", "", "nextElement", "reset", "([Ljava/lang/Object;I)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrieNodeIterator<E>  {

    public static final int $stable = 8;
    private Object[] buffer;
    private int index;
    static {
        final int i = 8;
    }

    public TrieNodeIterator() {
        super();
        this.buffer = TrieNode.Companion.getEMPTY$runtime_release().getBuffer();
    }

    public static void reset$default(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeIterator trieNodeIterator, Object[] object2Arr2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        trieNodeIterator.reset(object2Arr2, obj2);
    }

    public final E currentElement() {
        CommonFunctionsKt.assert(hasNextElement());
        return this.buffer[this.index];
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<? extends E> currentNode() {
        CommonFunctionsKt.assert(hasNextNode());
        Object obj = this.buffer[this.index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeIterator>");
        return (TrieNode)obj;
    }

    public final boolean hasNextCell() {
        int i;
        i = this.index < buffer.length ? 1 : 0;
        return i;
    }

    public final boolean hasNextElement() {
        boolean nextCell;
        int i;
        int index;
        if (hasNextCell() && !obj instanceof TrieNode) {
            i = !obj instanceof TrieNode ? 1 : 0;
        } else {
        }
        return i;
    }

    public final boolean hasNextNode() {
        boolean nextCell;
        int i;
        int index;
        if (hasNextCell() && obj instanceof TrieNode) {
            i = obj instanceof TrieNode ? 1 : 0;
        } else {
        }
        return i;
    }

    public final void moveToNextCell() {
        CommonFunctionsKt.assert(hasNextCell());
        this.index = index++;
    }

    public final E nextElement() {
        CommonFunctionsKt.assert(hasNextElement());
        final int index = this.index;
        this.index = index + 1;
        return this.buffer[index];
    }

    public final void reset(Object[] buffer, int index) {
        this.buffer = buffer;
        this.index = index;
    }
}
