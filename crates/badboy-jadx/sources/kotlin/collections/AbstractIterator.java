package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008&\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0008\u001a\u00020\tH$J\u0008\u0010\n\u001a\u00020\tH\u0004J\t\u0010\u000b\u001a\u00020\u000cH\u0096\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0011J\u0008\u0010\u0012\u001a\u00020\u000cH\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lkotlin/collections/AbstractIterator;", "T", "", "()V", "nextValue", "Ljava/lang/Object;", "state", "", "computeNext", "", "done", "hasNext", "", "next", "()Ljava/lang/Object;", "setNext", "value", "(Ljava/lang/Object;)V", "tryToComputeNext", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractIterator<T>  implements Iterator<T>, KMappedMarker {

    private T nextValue;
    private int state;
    private final boolean tryToComputeNext() {
        int i;
        this.state = 3;
        computeNext();
        if (this.state == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // java.util.Iterator
    protected abstract void computeNext();

    @Override // java.util.Iterator
    protected final void done() {
        this.state = 2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int tryToComputeNext;
        switch (state) {
            case 0:
                tryToComputeNext = tryToComputeNext();
                break;
            case 1:
                tryToComputeNext = 1;
                break;
            case 2:
                tryToComputeNext = 0;
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
                throw illegalArgumentException;
        }
        return tryToComputeNext;
    }

    public T next() {
        int tryToComputeNext;
        final int i3 = 0;
        if (this.state == 1) {
            this.state = i3;
            return this.nextValue;
        }
        if (this.state == 2) {
        } else {
            if (!tryToComputeNext()) {
            } else {
                this.state = i3;
                return this.nextValue;
            }
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    @Override // java.util.Iterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    protected final void setNext(T value) {
        this.nextValue = value;
        this.state = 1;
    }
}
