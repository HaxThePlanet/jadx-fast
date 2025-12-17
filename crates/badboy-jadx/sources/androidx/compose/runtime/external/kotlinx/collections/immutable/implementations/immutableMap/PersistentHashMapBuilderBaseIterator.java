package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u0002*\u0004\u0008\u0002\u0010\u00032\u0008\u0012\u0004\u0012\u0002H\u00030\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B9\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u001e\u0010\u0008\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u0012\u001a\u00020\u0013H\u0002J\u0008\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u0008\u0010\u0017\u001a\u00020\u0013H\u0016J5\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\r2\u000e\u0010\u001a\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u001b2\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0001¢\u0006\u0002\u0010!R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderBaseIterator;", "K", "V", "T", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "path", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "expectedModCount", "", "lastIteratedKey", "Ljava/lang/Object;", "nextWasInvoked", "", "checkForComodification", "", "checkNextWasInvoked", "next", "()Ljava/lang/Object;", "remove", "resetPath", "keyHash", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "key", "pathIndex", "(ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;Ljava/lang/Object;I)V", "setValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class PersistentHashMapBuilderBaseIterator<K, V, T>  extends androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, KMutableIterator {

    public static final int $stable = 8;
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> builder;
    private int expectedModCount;
    private K lastIteratedKey;
    private boolean nextWasInvoked;
    static {
        final int i = 8;
    }

    public PersistentHashMapBuilderBaseIterator(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> builder, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator<K, V, T>[] path) {
        super(builder.getNode$runtime_release(), path);
        this.builder = builder;
        this.expectedModCount = this.builder.getModCount$runtime_release();
    }

    private final void checkForComodification() {
        if (this.builder.getModCount$runtime_release() != this.expectedModCount) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    private final void checkNextWasInvoked() {
        if (!this.nextWasInvoked) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    private final void resetPath(int keyHash, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<?, ?> node, K key, int pathIndex) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator map;
        final int i = pathIndex * 5;
        if (i > 30) {
            getPath()[pathIndex].reset(node.getBuffer$runtime_release(), buffer$runtime_release2.length, 0);
            while (!Intrinsics.areEqual(getPath()[pathIndex].currentKey(), key)) {
                getPath()[pathIndex].moveToNextKey();
            }
            setPathLastIndex(pathIndex);
        }
        int i3 = i4 << indexSegment;
        if (node.hasEntryAt$runtime_release(i3)) {
            getPath()[pathIndex].reset(node.getBuffer$runtime_release(), entryCount$runtime_release *= 2, node.entryKeyIndex$runtime_release(i3));
            setPathLastIndex(pathIndex);
        }
        int nodeIndex$runtime_release = node.nodeIndex$runtime_release(i3);
        getPath()[pathIndex].reset(node.getBuffer$runtime_release(), entryCount$runtime_release2 *= 2, nodeIndex$runtime_release);
        resetPath(keyHash, node.nodeAtIndex$runtime_release(nodeIndex$runtime_release), key, pathIndex + 1);
    }

    public T next() {
        checkForComodification();
        this.lastIteratedKey = currentKey();
        this.nextWasInvoked = true;
        return super.next();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator
    public void remove() {
        Object mutableMap;
        int lastIteratedKey;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode node$runtime_release;
        checkNextWasInvoked();
        final int i2 = 0;
        if (hasNext()) {
            mutableMap = currentKey();
            TypeIntrinsics.asMutableMap((Map)this.builder).remove(this.lastIteratedKey);
            if (mutableMap != null) {
                lastIteratedKey = mutableMap.hashCode();
            } else {
                lastIteratedKey = i2;
            }
            resetPath(lastIteratedKey, this.builder.getNode$runtime_release(), mutableMap, i2);
        } else {
            TypeIntrinsics.asMutableMap((Map)this.builder).remove(this.lastIteratedKey);
        }
        this.lastIteratedKey = 0;
        this.nextWasInvoked = i2;
        this.expectedModCount = this.builder.getModCount$runtime_release();
    }

    public final void setValue(K key, V newValue) {
        Object currentKey;
        int i;
        int i2;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode node$runtime_release;
        if (!this.builder.containsKey(key)) {
        }
        if (hasNext()) {
            currentKey = currentKey();
            (Map)this.builder.put(key, newValue);
            i = 0;
            if (currentKey != null) {
                i2 = currentKey.hashCode();
            } else {
                i2 = i;
            }
            resetPath(i2, this.builder.getNode$runtime_release(), currentKey, i);
        } else {
            (Map)this.builder.put(key, newValue);
        }
        this.expectedModCount = this.builder.getModCount$runtime_release();
    }
}
