package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010*\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008 \u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\r\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0008\u000fJ\r\u0010\u0010\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0008\u0011J\t\u0010\u0012\u001a\u00020\u0013H\u0096\u0002J\u0008\u0010\u0014\u001a\u00020\u0013H\u0016J\u0008\u0010\u0015\u001a\u00020\u0004H\u0016J\u0008\u0010\u0016\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u0008\"\u0004\u0008\u000c\u0010\n¨\u0006\u0017", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "E", "", "index", "", "size", "(II)V", "getIndex", "()I", "setIndex", "(I)V", "getSize", "setSize", "checkHasNext", "", "checkHasNext$runtime_release", "checkHasPrevious", "checkHasPrevious$runtime_release", "hasNext", "", "hasPrevious", "nextIndex", "previousIndex", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractListIterator<E>  implements ListIterator<E>, KMappedMarker {

    public static final int $stable = 8;
    private int index;
    private int size;
    static {
        final int i = 8;
    }

    public AbstractListIterator(int index, int size) {
        super();
        this.index = index;
        this.size = size;
    }

    public void add(E e) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.ListIterator
    public final void checkHasNext$runtime_release() {
        if (!hasNext()) {
        } else {
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    @Override // java.util.ListIterator
    public final void checkHasPrevious$runtime_release() {
        if (!hasPrevious()) {
        } else {
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    @Override // java.util.ListIterator
    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.ListIterator
    public final int getSize() {
        return this.size;
    }

    @Override // java.util.ListIterator
    public boolean hasNext() {
        int i;
        i = this.index < this.size ? 1 : 0;
        return i;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        int i;
        i = this.index > 0 ? 1 : 0;
        return i;
    }

    public E next() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return index--;
    }

    @Override // java.util.ListIterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public void set(E e) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.ListIterator
    public final void setIndex(int <set-?>) {
        this.index = <set-?>;
    }

    @Override // java.util.ListIterator
    public final void setSize(int <set-?>) {
        this.size = <set-?>;
    }
}
