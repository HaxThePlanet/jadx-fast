package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0008\u001a\u00020\tH\u0096\u0002J\u0008\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u000e", d2 = {"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LongProgressionIterator extends LongIterator {

    private final long finalElement;
    private boolean hasNext = false;
    private long next;
    private final long step;
    public LongProgressionIterator(long first, long last, long step) {
        int cmp;
        long finalElement;
        super();
        this.step = obj9;
        this.finalElement = step;
        int i = 1;
        if (Long.compare(step2, i3) > 0) {
            if (Long.compare(first, step) <= 0) {
            }
        } else {
            if (Long.compare(first, step) >= 0) {
            }
        }
        int i2 = i4;
        finalElement = this.hasNext ? first : this.finalElement;
        this.next = finalElement;
    }

    @Override // kotlin.collections.LongIterator
    public final long getStep() {
        return this.step;
    }

    @Override // kotlin.collections.LongIterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.LongIterator
    public long nextLong() {
        int i;
        long step;
        final long next = this.next;
        if (Long.compare(next, finalElement) == 0) {
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
