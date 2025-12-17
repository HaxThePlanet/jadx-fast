package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0015\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\u000e\u0010\u001b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0016R\u0018\u0010\u0006\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0008\u0010\tR \u0010\n\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000c0\u000bX\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014¨\u0006\u001c", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetIterator;", "E", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;)V", "hasNext", "", "getHasNext$annotations", "()V", "path", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNodeIterator;", "getPath", "()Ljava/util/List;", "pathLastIndex", "", "getPathLastIndex", "()I", "setPathLastIndex", "(I)V", "currentElement", "()Ljava/lang/Object;", "ensureNextElementIsReady", "", "moveToNextNodeWithData", "pathIndex", "next", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class PersistentHashSetIterator<E>  implements Iterator<E>, KMappedMarker {

    public static final int $stable = 8;
    private boolean hasNext = true;
    private final List<androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeIterator<E>> path;
    private int pathLastIndex = 0;
    static {
        final int i = 8;
    }

    public PersistentHashSetIterator(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> node) {
        super();
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeIterator[] arr = new TrieNodeIterator[1];
        TrieNodeIterator trieNodeIterator = new TrieNodeIterator();
        final int i3 = 0;
        arr[i3] = trieNodeIterator;
        this.path = CollectionsKt.mutableListOf(arr);
        TrieNodeIterator.reset$default((TrieNodeIterator)this.path.get(i3), node.getBuffer(), i3, 2, 0);
        ensureNextElementIsReady();
    }

    private final void ensureNextElementIsReady() {
        int i;
        int pathLastIndex;
        Object obj;
        int i2;
        int result;
        Object[] nextCell;
        if ((TrieNodeIterator)this.path.get(this.pathLastIndex).hasNextElement()) {
        }
        i = this.pathLastIndex;
        pathLastIndex = 0;
        i2 = -1;
        while (i2 < i) {
            if (moveToNextNodeWithData(i) == i2 && (TrieNodeIterator)this.path.get(i).hasNextCell()) {
            }
            if (i > 0) {
            }
            (TrieNodeIterator)this.path.get(i).reset(TrieNode.Companion.getEMPTY$runtime_release().getBuffer(), pathLastIndex);
            i--;
            pathLastIndex = 0;
            i2 = -1;
            (TrieNodeIterator)this.path.get(i + -1).moveToNextCell();
            if ((TrieNodeIterator)this.path.get(i).hasNextCell()) {
            }
            (TrieNodeIterator)this.path.get(i).moveToNextCell();
            result = moveToNextNodeWithData(i);
        }
        this.hasNext = pathLastIndex;
    }

    private static void getHasNext$annotations() {
    }

    private final int moveToNextNodeWithData(int pathIndex) {
        int path;
        int trieNodeIterator;
        if ((TrieNodeIterator)this.path.get(pathIndex).hasNextElement()) {
            return pathIndex;
        }
        if ((TrieNodeIterator)this.path.get(pathIndex).hasNextNode() && pathIndex + 1 == this.path.size()) {
            if (pathIndex + 1 == this.path.size()) {
                trieNodeIterator = new TrieNodeIterator();
                this.path.add(trieNodeIterator);
            }
            TrieNodeIterator.reset$default((TrieNodeIterator)this.path.get(pathIndex + 1), (TrieNodeIterator)this.path.get(pathIndex).currentNode().getBuffer(), 0, 2, 0);
            return moveToNextNodeWithData(pathIndex + 1);
        }
        return -1;
    }

    protected final E currentElement() {
        CommonFunctionsKt.assert(hasNext());
        return (TrieNodeIterator)this.path.get(this.pathLastIndex).currentElement();
    }

    protected final List<androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeIterator<E>> getPath() {
        return this.path;
    }

    @Override // java.util.Iterator
    protected final int getPathLastIndex() {
        return this.pathLastIndex;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    public E next() {
        if (!this.hasNext) {
        } else {
            ensureNextElementIsReady();
            return (TrieNodeIterator)this.path.get(this.pathLastIndex).nextElement();
        }
        NoSuchElementException result = new NoSuchElementException();
        throw result;
    }

    @Override // java.util.Iterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Iterator
    protected final void setPathLastIndex(int <set-?>) {
        this.pathLastIndex = <set-?>;
    }
}
