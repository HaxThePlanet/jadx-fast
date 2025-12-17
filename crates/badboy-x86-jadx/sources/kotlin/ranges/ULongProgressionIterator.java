package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u0013\u0010\u000c\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0008\u001a\u00020\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000c\u001a\u00020\u0002X\u0082\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u000f", d2 = {"Lkotlin/ranges/ULongProgressionIterator;", "", "Lkotlin/ULong;", "first", "last", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "J", "hasNext", "", "next", "next-s-VKNKU", "()J", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ULongProgressionIterator implements Iterator<ULong>, KMappedMarker {

    private final long finalElement;
    private boolean hasNext;
    private long next;
    private final long step;
    private ULongProgressionIterator(long first, long last, long step) {
        int compareUnsigned;
        long finalElement;
        int i;
        super();
        this.finalElement = step;
        i = 1;
        if (Long.compare(obj8, i2) > 0) {
            if (Long.compareUnsigned(first, last) <= 0) {
            } else {
                i = i3;
            }
        } else {
            if (Long.compareUnsigned(first, last) >= 0) {
            } else {
            }
        }
        this.hasNext = i;
        this.step = ULong.constructor-impl(obj8);
        finalElement = this.hasNext ? first : this.finalElement;
        this.next = finalElement;
    }

    public ULongProgressionIterator(long l, long l2, long l3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(l, l2, l3, defaultConstructorMarker4, obj5, obj6);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public Object next() {
        return ULong.box-impl(next-s-VKNKU());
    }

    @Override // java.util.Iterator
    public long next-s-VKNKU() {
        int constructor-impl;
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
        this.next = ULong.constructor-impl(next2 += step);
    }

    @Override // java.util.Iterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}
