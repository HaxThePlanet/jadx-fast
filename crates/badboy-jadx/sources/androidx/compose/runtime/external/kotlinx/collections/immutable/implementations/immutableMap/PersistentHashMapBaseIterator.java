package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0008 \u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u0002*\u0004\u0008\u0002\u0010\u00032\u0008\u0012\u0004\u0012\u0002H\u00030\u0004B9\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t0\u0008¢\u0006\u0002\u0010\nJ\u0008\u0010\u0018\u001a\u00020\u0019H\u0002J\r\u0010\u001a\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u001bJ\u0008\u0010\u001c\u001a\u00020\u0019H\u0002J\t\u0010\u000b\u001a\u00020\u000cH\u0096\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013H\u0002J\u000e\u0010\u001f\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u001bR\u0018\u0010\u000b\u001a\u00020\u000c8\u0002@\u0002X\u0083\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\r\u0010\u000eR.\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t0\u0008X\u0084\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017¨\u0006 ", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "K", "V", "T", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "path", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "hasNext", "", "getHasNext$annotations", "()V", "getPath", "()[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "pathLastIndex", "", "getPathLastIndex", "()I", "setPathLastIndex", "(I)V", "checkHasNext", "", "currentKey", "()Ljava/lang/Object;", "ensureNextEntryIsReady", "moveToNextNodeWithData", "pathIndex", "next", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PersistentHashMapBaseIterator<K, V, T>  implements Iterator<T>, KMappedMarker {

    public static final int $stable = 8;
    private boolean hasNext = true;
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator<K, V, T>[] path;
    private int pathLastIndex = 0;
    static {
        final int i = 8;
    }

    public PersistentHashMapBaseIterator(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> node, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator<K, V, T>[] path) {
        super();
        this.path = path;
        int i = 1;
        this.path[0].reset(node.getBuffer$runtime_release(), entryCount$runtime_release *= 2);
        ensureNextEntryIsReady();
    }

    private final void checkHasNext() {
        if (!hasNext()) {
        } else {
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    private final void ensureNextEntryIsReady() {
        int i2;
        int pathLastIndex;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator map;
        int i;
        int result;
        Object[] buffer$runtime_release;
        if (this.path[this.pathLastIndex].hasNextKey()) {
        }
        i2 = this.pathLastIndex;
        pathLastIndex = 0;
        i = -1;
        while (i < i2) {
            if (moveToNextNodeWithData(i2) == i && this.path[i2].hasNextNode()) {
            }
            if (i2 > 0) {
            }
            this.path[i2].reset(TrieNode.Companion.getEMPTY$runtime_release().getBuffer$runtime_release(), pathLastIndex);
            i2--;
            pathLastIndex = 0;
            i = -1;
            this.path[i2 + -1].moveToNextNode();
            if (this.path[i2].hasNextNode()) {
            }
            this.path[i2].moveToNextNode();
            result = moveToNextNodeWithData(i2);
        }
        this.hasNext = pathLastIndex;
    }

    private static void getHasNext$annotations() {
    }

    private final int moveToNextNodeWithData(int pathIndex) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator map;
        Object[] buffer$runtime_release;
        int length;
        if (this.path[pathIndex].hasNextKey()) {
            return pathIndex;
        }
        if (this.path[pathIndex].hasNextNode()) {
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode currentNode = this.path[pathIndex].currentNode();
            if (pathIndex == 6) {
                this.path[pathIndex + 1].reset(currentNode.getBuffer$runtime_release(), buffer$runtime_release2.length);
            } else {
                this.path[pathIndex + 1].reset(currentNode.getBuffer$runtime_release(), entryCount$runtime_release *= 2);
            }
            return moveToNextNodeWithData(pathIndex + 1);
        }
        return -1;
    }

    protected final K currentKey() {
        checkHasNext();
        return this.path[this.pathLastIndex].currentKey();
    }

    protected final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator<K, V, T>[] getPath() {
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

    public T next() {
        checkHasNext();
        ensureNextEntryIsReady();
        return this.path[this.pathLastIndex].next();
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
