package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u0013\u0010\u000c\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0008\u001a\u00020\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000c\u001a\u00020\u0002X\u0082\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u000f", d2 = {"Lkotlin/ranges/UIntProgressionIterator;", "", "Lkotlin/UInt;", "first", "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", "next", "next-pVg5ArA", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class UIntProgressionIterator implements Iterator<UInt>, KMappedMarker {

    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;
    private UIntProgressionIterator(int first, int last, int step) {
        int i;
        int finalElement;
        super();
        this.finalElement = last;
        i = 1;
        final int compareUnsigned = Integer.compareUnsigned(first, last);
        if (step > 0) {
            if (compareUnsigned <= 0) {
            } else {
                i = i2;
            }
        } else {
            if (compareUnsigned >= 0) {
            } else {
            }
        }
        this.hasNext = i;
        this.step = UInt.constructor-impl(step);
        finalElement = this.hasNext ? first : this.finalElement;
        this.next = finalElement;
    }

    public UIntProgressionIterator(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(i, i2, i3);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public Object next() {
        return UInt.box-impl(next-pVg5ArA());
    }

    @Override // java.util.Iterator
    public int next-pVg5ArA() {
        int constructor-impl;
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
        this.next = UInt.constructor-impl(next2 += step);
    }

    @Override // java.util.Iterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}
