package kotlin.y;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.f;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008À\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u000f\u001a\u00020\r2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\u00020\r2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\u0008\u0010\u0015\u001a\u00020\tH\u0016J\u0008\u0010\u0016\u001a\u00020\rH\u0016J\u000f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0002J\u0008\u0010\u0019\u001a\u00020\u0014H\u0002J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001c", d2 = {"Lkotlin/collections/EmptySet;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "hashCode", "isEmpty", "iterator", "", "readResolve", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class d0 implements Set, Serializable, a {

    public static final kotlin.y.d0 a = null;
    private static final long serialVersionUID = 3406603774387020532L;
    static {
        d0 d0Var = new d0();
        d0.a = d0Var;
    }

    private final Object readResolve() {
        return d0.a;
    }

    @Override // java.util.Set
    public boolean add(Object object) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.Set
    public boolean addAll(Collection collection) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.Set
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Set
    public final boolean contains(Object object) {
        if (object instanceof Void) {
            return d((Void)object);
        }
        return 0;
    }

    @Override // java.util.Set
    public boolean containsAll(Collection collection) {
        n.f(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.Set
    public boolean d(Void void) {
        n.f(void, "element");
        return 0;
    }

    @Override // java.util.Set
    public boolean equals(Object object) {
        Object obj2;
        if (object instanceof Set != null && (Set)object.isEmpty()) {
            obj2 = (Set)object.isEmpty() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // java.util.Set
    public int g() {
        return 0;
    }

    @Override // java.util.Set
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Set
    public boolean isEmpty() {
        return 1;
    }

    @Override // java.util.Set
    public Iterator iterator() {
        return a0.a;
    }

    @Override // java.util.Set
    public boolean remove(Object object) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.Set
    public boolean removeAll(Collection collection) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.Set
    public boolean retainAll(Collection collection) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.Set
    public final int size() {
        return g();
    }

    @Override // java.util.Set
    public Object[] toArray() {
        return f.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return f.b(this, tArr);
    }

    @Override // java.util.Set
    public String toString() {
        return "[]";
    }
}
