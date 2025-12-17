package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\r\u001a\u00020\u000eH\u0002J\u0008\u0010\u000f\u001a\u00020\u000eH\u0002J\u0014\u0010\u0010\u001a\u00020\u000c2\n\u0010\u0011\u001a\u0006\u0012\u0002\u0008\u00030\u0012H\u0002J\u000e\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0008\u0010\u0015\u001a\u00020\u000eH\u0016J1\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00082\n\u0010\u0011\u001a\u0006\u0012\u0002\u0008\u00030\u00122\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0008H\u0002¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetMutableIterator;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetIterator;", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)V", "expectedModCount", "", "lastIteratedElement", "Ljava/lang/Object;", "nextWasInvoked", "", "checkForComodification", "", "checkNextWasInvoked", "isCollision", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "next", "()Ljava/lang/Object;", "remove", "resetPath", "hashCode", "element", "pathIndex", "(ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;Ljava/lang/Object;I)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentHashSetMutableIterator<E>  extends androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetIterator<E> implements Iterator<E>, KMutableIterator {

    public static final int $stable = 8;
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<E> builder;
    private int expectedModCount;
    private E lastIteratedElement;
    private boolean nextWasInvoked;
    static {
        final int i = 8;
    }

    public PersistentHashSetMutableIterator(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<E> builder) {
        super(builder.getNode$runtime_release());
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

    private final boolean isCollision(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<?> node) {
        int i;
        i = node.getBitmap() == 0 ? 1 : 0;
        return i;
    }

    private final void resetPath(int hashCode, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<?> node, E element, int pathIndex) {
        int i;
        boolean obj;
        int i2;
        if (isCollision(node)) {
            int indexOf = ArraysKt.indexOf(node.getBuffer(), element);
            if (indexOf != -1) {
            } else {
                i = 0;
            }
            CommonFunctionsKt.assert(i);
            (TrieNodeIterator)getPath().get(pathIndex).reset(node.getBuffer(), indexOf);
            setPathLastIndex(pathIndex);
        }
        int indexOfCellAt$runtime_release = node.indexOfCellAt$runtime_release(i << indexSegment);
        (TrieNodeIterator)getPath().get(pathIndex).reset(node.getBuffer(), indexOfCellAt$runtime_release);
        Object obj4 = node.getBuffer()[indexOfCellAt$runtime_release];
        if (obj4 instanceof TrieNode) {
            resetPath(hashCode, (TrieNode)obj4, element, pathIndex + 1);
        } else {
            setPathLastIndex(pathIndex);
        }
    }

    public E next() {
        checkForComodification();
        final Object next = super.next();
        this.lastIteratedElement = next;
        this.nextWasInvoked = true;
        return next;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetIterator
    public void remove() {
        Object mutableCollection;
        int lastIteratedElement;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode node$runtime_release;
        checkNextWasInvoked();
        final int i2 = 0;
        if (hasNext()) {
            mutableCollection = currentElement();
            TypeIntrinsics.asMutableCollection((Collection)this.builder).remove(this.lastIteratedElement);
            if (mutableCollection != null) {
                lastIteratedElement = mutableCollection.hashCode();
            } else {
                lastIteratedElement = i2;
            }
            resetPath(lastIteratedElement, this.builder.getNode$runtime_release(), mutableCollection, i2);
        } else {
            TypeIntrinsics.asMutableCollection((Collection)this.builder).remove(this.lastIteratedElement);
        }
        this.lastIteratedElement = 0;
        this.nextWasInvoked = i2;
        this.expectedModCount = this.builder.getModCount$runtime_release();
    }
}
