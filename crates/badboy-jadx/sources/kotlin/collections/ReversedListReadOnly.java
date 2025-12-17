package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010*\n\u0000\u0008\u0012\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u000cJ\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010H\u0016J\u0016\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0011", d2 = {"Lkotlin/collections/ReversedListReadOnly;", "T", "Lkotlin/collections/AbstractList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "iterator", "", "listIterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
class ReversedListReadOnly<T>  extends kotlin.collections.AbstractList<T> {

    private final List<T> delegate;
    public ReversedListReadOnly(List<? extends T> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        super();
        this.delegate = delegate;
    }

    public static final List access$getDelegate$p(kotlin.collections.ReversedListReadOnly $this) {
        return $this.delegate;
    }

    public T get(int index) {
        return this.delegate.get(CollectionsKt__ReversedViewsKt.access$reverseElementIndex((List)this, index));
    }

    @Override // kotlin.collections.AbstractList
    public int getSize() {
        return this.delegate.size();
    }

    public Iterator<T> iterator() {
        return (Iterator)listIterator(0);
    }

    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    public ListIterator<T> listIterator(int index) {
        ReversedListReadOnly.listIterator.1 anon = new ReversedListReadOnly.listIterator.1(this, index);
        return (ListIterator)anon;
    }
}
