package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0008\u0000\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\u000e\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000bJ\r\u0010\u000c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0088\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\r", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/BufferIterator;", "T", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "buffer", "", "index", "", "size", "([Ljava/lang/Object;II)V", "[Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "previous", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BufferIterator<T>  extends androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator<T> {

    public static final int $stable = 8;
    private final T[] buffer;
    static {
        final int i = 8;
    }

    public BufferIterator(T[] buffer, int index, int size) {
        super(index, size);
        this.buffer = buffer;
    }

    public T next() {
        if (!hasNext()) {
        } else {
            final int index = getIndex();
            setIndex(index + 1);
            return this.buffer[index];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public T previous() {
        if (!hasPrevious()) {
        } else {
            setIndex(index--);
            return this.buffer[getIndex()];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}
