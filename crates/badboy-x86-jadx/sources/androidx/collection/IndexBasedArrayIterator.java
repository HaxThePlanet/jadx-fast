package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008 \u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\u0008\u001a\u00020\u0004H$¢\u0006\u0002\u0010\u000bJ\t\u0010\u000c\u001a\u00020\u0007H\u0096\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0008\u001a\u00020\u0004H$R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Landroidx/collection/IndexBasedArrayIterator;", "T", "", "startingSize", "", "(I)V", "canRemove", "", "index", "size", "elementAt", "(I)Ljava/lang/Object;", "hasNext", "next", "()Ljava/lang/Object;", "remove", "", "removeAt", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class IndexBasedArrayIterator<T>  implements Iterator<T>, KMutableIterator {

    private boolean canRemove;
    private int index;
    private int size;
    public IndexBasedArrayIterator(int startingSize) {
        super();
        this.size = startingSize;
    }

    protected abstract T elementAt(int i);

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        i = this.index < this.size ? 1 : 0;
        return i;
    }

    public T next() {
        if (!hasNext()) {
        } else {
            final int i2 = 1;
            this.index = index2 += i2;
            this.canRemove = i2;
            return elementAt(this.index);
        }
        NoSuchElementException res = new NoSuchElementException();
        throw res;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.canRemove) {
        } else {
            this.index = index--;
            removeAt(this.index);
            this.size = size--;
            this.canRemove = false;
        }
        int i4 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("Call next() before removing an element.".toString());
        throw illegalStateException;
    }

    @Override // java.util.Iterator
    protected abstract void removeAt(int i);
}
