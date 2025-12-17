package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0008\u001a\u00020\tH\u0096\u0002J\u0008\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u000e", d2 = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IntProgressionIterator extends IntIterator {

    private final int finalElement;
    private boolean hasNext = false;
    private int next;
    private final int step;
    public IntProgressionIterator(int first, int last, int step) {
        int finalElement;
        super();
        this.step = step;
        this.finalElement = last;
        int i = 1;
        if (this.step > 0) {
            if (first <= last) {
            }
        } else {
            if (first >= last) {
            }
        }
        int i2 = i3;
        finalElement = this.hasNext ? first : this.finalElement;
        this.next = finalElement;
    }

    @Override // kotlin.collections.IntIterator
    public final int getStep() {
        return this.step;
    }

    @Override // kotlin.collections.IntIterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        int i;
        int step;
        final int next = this.next;
        if (next == this.finalElement) {
            if (!this.hasNext) {
            } else {
                this.hasNext = false;
                return next;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
        this.next = next2 += step;
    }
}
