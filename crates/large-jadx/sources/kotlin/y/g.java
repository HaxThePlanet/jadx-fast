package kotlin.y;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.b;
import kotlin.d0.d.f;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0000\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00062\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\u0008\u0010\u0015\u001a\u00020\u0006H\u0016J\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0017H\u0096\u0002J\u0015\u0010\u0018\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00190\u0004¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\u0003\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lkotlin/collections/ArrayAsCollection;", "T", "", "values", "", "isVarargs", "", "([Ljava/lang/Object;Z)V", "()Z", "size", "", "getSize", "()I", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class g<T>  implements Collection<T>, a {

    private final T[] a;
    private final boolean b;
    public g(T[] tArr, boolean z2) {
        n.f(tArr, "values");
        super();
        this.a = tArr;
        this.b = z2;
    }

    public boolean add(T t) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    public boolean addAll(Collection<? extends T> collection) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.Collection
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public boolean contains(Object object) {
        return i.t(this.a, object);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        boolean contains;
        int i;
        Object obj3;
        n.f(collection, "elements");
        i = 1;
        if (collection.isEmpty()) {
        } else {
            obj3 = collection.iterator();
            while (obj3.hasNext()) {
                if (!contains(obj3.next())) {
                    break;
                } else {
                }
            }
        }
        return i;
    }

    @Override // java.util.Collection
    public int d() {
        return objArr.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        int i;
        i = objArr.length == 0 ? 1 : 0;
        return i;
    }

    public Iterator<T> iterator() {
        return b.a(this.a);
    }

    @Override // java.util.Collection
    public boolean remove(Object object) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.Collection
    public final int size() {
        return d();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return q.a(this.a, this.b);
    }

    public <T> T[] toArray(T[] tArr) {
        return f.b(this, tArr);
    }
}
