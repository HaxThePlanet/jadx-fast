package kotlin.y;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.d0.d.f;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010*\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008À\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u0011\u001a\u00020\u000f2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u000f2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0011\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bH\u0096\u0002J\u0008\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0008\u0010\u001b\u001a\u00020\u000fH\u0016J\u000f\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001dH\u0096\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u000e\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00020 H\u0016J\u0016\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00020 2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0008\u0010!\u001a\u00020\u0016H\u0002J\u001e\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0016J\u0008\u0010%\u001a\u00020&H\u0016R\u000e\u0010\u0008\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\r¨\u0006'", d2 = {"Lkotlin/collections/EmptyList;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "readResolve", "subList", "fromIndex", "toIndex", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class b0 implements List, Serializable, RandomAccess, a {

    public static final kotlin.y.b0 a = null;
    private static final long serialVersionUID = -7390468764508069838L;
    static {
        b0 b0Var = new b0();
        b0.a = b0Var;
    }

    private final Object readResolve() {
        return b0.a;
    }

    @Override // java.util.List
    public void add(int i, Object object2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj1;
    }

    @Override // java.util.List
    public boolean add(Object object) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj1;
    }

    @Override // java.util.List
    public boolean addAll(Collection collection) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.List
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final boolean contains(Object object) {
        if (object instanceof Void) {
            return d((Void)object);
        }
        return 0;
    }

    @Override // java.util.List
    public boolean containsAll(Collection collection) {
        n.f(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.List
    public boolean d(Void void) {
        n.f(void, "element");
        return 0;
    }

    @Override // java.util.List
    public boolean equals(Object object) {
        Object obj2;
        if (object instanceof List != null && (List)object.isEmpty()) {
            obj2 = (List)object.isEmpty() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // java.util.List
    public Void g(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Empty list doesn't contain element at index ");
        stringBuilder.append(i);
        stringBuilder.append('.');
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }

    @Override // java.util.List
    public Object get(int i) {
        g(i);
        throw 0;
    }

    @Override // java.util.List
    public int h() {
        return 0;
    }

    @Override // java.util.List
    public int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public int i(Void void) {
        n.f(void, "element");
        return -1;
    }

    @Override // java.util.List
    public final int indexOf(Object object) {
        if (object instanceof Void) {
            return i((Void)object);
        }
        return -1;
    }

    @Override // java.util.List
    public boolean isEmpty() {
        return 1;
    }

    @Override // java.util.List
    public Iterator iterator() {
        return a0.a;
    }

    @Override // java.util.List
    public int l(Void void) {
        n.f(void, "element");
        return -1;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object object) {
        if (object instanceof Void) {
            return l((Void)object);
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return a0.a;
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        if (i != 0) {
        } else {
            return a0.a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(i);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }

    @Override // java.util.List
    public Object remove(int i) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.List
    public boolean remove(Object object) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.List
    public boolean removeAll(Collection collection) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.List
    public boolean retainAll(Collection collection) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.List
    public Object set(int i, Object object2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj1;
    }

    @Override // java.util.List
    public final int size() {
        return h();
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        if (i != 0) {
        } else {
            if (i2 != 0) {
            } else {
                return this;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fromIndex: ");
        stringBuilder.append(i);
        stringBuilder.append(", toIndex: ");
        stringBuilder.append(i2);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }

    @Override // java.util.List
    public Object[] toArray() {
        return f.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return f.b(this, tArr);
    }

    @Override // java.util.List
    public String toString() {
        return "[]";
    }
}
