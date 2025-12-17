package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.DoubleIterator;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlin/jvm/internal/ArrayDoubleIterator;", "Lkotlin/collections/DoubleIterator;", "array", "", "([D)V", "index", "", "hasNext", "", "nextDouble", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ArrayDoubleIterator extends DoubleIterator {

    private final double[] array;
    private int index;
    public ArrayDoubleIterator(double[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        super();
        this.array = array;
    }

    @Override // kotlin.collections.DoubleIterator
    public boolean hasNext() {
        int i;
        i = this.index < array.length ? 1 : 0;
        return i;
    }

    @Override // kotlin.collections.DoubleIterator
    public double nextDouble() {
        try {
            final int index = this.index;
            this.index = index + 1;
            return this.array[index];
            int noSuchElementException = this.index;
            noSuchElementException--;
            this.index = noSuchElementException;
            noSuchElementException = new NoSuchElementException(th.getMessage());
            throw noSuchElementException;
        }
    }
}
