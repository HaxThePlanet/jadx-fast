package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u000c\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0008\u0010\u0011\u001a\u00020\u000eH\u0002J\u0008\u0010\u0012\u001a\u00020\u000eH\u0002J\u000e\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0014J\r\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0008\u0010\u0016\u001a\u00020\u000eH\u0016J\u0008\u0010\u0017\u001a\u00020\u000eH\u0002J\u0015\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0008\u0010\u0019\u001a\u00020\u000eH\u0002R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorMutableIterator;", "T", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "index", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;I)V", "expectedModCount", "lastIteratedIndex", "trieIterator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "add", "", "element", "(Ljava/lang/Object;)V", "checkForComodification", "checkHasIterated", "next", "()Ljava/lang/Object;", "previous", "remove", "reset", "set", "setupTrieIterator", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentVectorMutableIterator<T>  extends androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator<T> implements ListIterator<T>, KMutableListIterator {

    public static final int $stable = 8;
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder<T> builder;
    private int expectedModCount;
    private int lastIteratedIndex = -1;
    private androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator<? extends T> trieIterator;
    static {
        final int i = 8;
    }

    public PersistentVectorMutableIterator(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder<T> builder, int index) {
        super(index, builder.size());
        this.builder = builder;
        this.expectedModCount = this.builder.getModCount$runtime_release();
        int i = -1;
        setupTrieIterator();
    }

    private final void checkForComodification() {
        if (this.expectedModCount != this.builder.getModCount$runtime_release()) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    private final void checkHasIterated() {
        if (this.lastIteratedIndex == -1) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    private final void reset() {
        setSize(this.builder.size());
        this.expectedModCount = this.builder.getModCount$runtime_release();
        this.lastIteratedIndex = -1;
        setupTrieIterator();
    }

    private final void setupTrieIterator() {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator trieIterator;
        Object[] root$runtime_release = this.builder.getRoot$runtime_release();
        if (root$runtime_release == null) {
            this.trieIterator = 0;
        }
        int rootSize = UtilsKt.rootSize(this.builder.size());
        int coerceAtMost = RangesKt.coerceAtMost(getIndex(), rootSize);
        i2++;
        if (this.trieIterator == null) {
            trieIterator = new TrieIterator(root$runtime_release, coerceAtMost, rootSize, i3);
            this.trieIterator = trieIterator;
        } else {
            trieIterator = this.trieIterator;
            Intrinsics.checkNotNull(trieIterator);
            trieIterator.reset$runtime_release(root$runtime_release, coerceAtMost, rootSize, i3);
        }
    }

    public void add(T element) {
        checkForComodification();
        this.builder.add(getIndex(), element);
        setIndex(index++);
        reset();
    }

    public T next() {
        checkForComodification();
        checkHasNext$runtime_release();
        this.lastIteratedIndex = getIndex();
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator trieIterator = this.trieIterator;
        if (trieIterator == null) {
            int index2 = getIndex();
            setIndex(index2 + 1);
            return this.builder.getTail$runtime_release()[index2];
        }
        if (trieIterator.hasNext()) {
            setIndex(index3++);
            return trieIterator.next();
        }
        int index4 = getIndex();
        setIndex(index4 + 1);
        return this.builder.getTail$runtime_release()[index4 -= size];
    }

    public T previous() {
        checkForComodification();
        checkHasPrevious$runtime_release();
        this.lastIteratedIndex = index--;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator trieIterator = this.trieIterator;
        if (trieIterator == null) {
            setIndex(index2--);
            return this.builder.getTail$runtime_release()[getIndex()];
        }
        if (getIndex() > trieIterator.getSize()) {
            setIndex(index6--);
            return this.builder.getTail$runtime_release()[index7 -= size2];
        }
        setIndex(index5--);
        return trieIterator.previous();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator
    public void remove() {
        int lastIteratedIndex;
        checkForComodification();
        checkHasIterated();
        this.builder.remove(this.lastIteratedIndex);
        if (this.lastIteratedIndex < getIndex()) {
            setIndex(this.lastIteratedIndex);
        }
        reset();
    }

    public void set(T element) {
        checkForComodification();
        checkHasIterated();
        this.builder.set(this.lastIteratedIndex, element);
        this.expectedModCount = this.builder.getModCount$runtime_release();
        setupTrieIterator();
    }
}
