package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.FloatIterator;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlin/jvm/internal/ArrayFloatIterator;", "Lkotlin/collections/FloatIterator;", "array", "", "([F)V", "index", "", "hasNext", "", "nextFloat", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ArrayFloatIterator extends FloatIterator {

    private final float[] array;
    private int index;
    public ArrayFloatIterator(float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        super();
        this.array = array;
    }

    @Override // kotlin.collections.FloatIterator
    public boolean hasNext() {
        int i;
        i = this.index < array.length ? 1 : 0;
        return i;
    }

    @Override // kotlin.collections.FloatIterator
    public float nextFloat() {
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
