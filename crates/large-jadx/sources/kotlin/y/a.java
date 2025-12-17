package kotlin.y;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.f;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008'\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000c\u001a\u00020\t2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\u0008\u0010\u000e\u001a\u00020\tH\u0016J\u000f\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010H¦\u0002J\u0015\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0015¢\u0006\u0002\u0010\u0014J'\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00150\u0012\"\u0004\u0008\u0001\u0010\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00150\u0012H\u0014¢\u0006\u0002\u0010\u0017J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u001a", d2 = {"Lkotlin/collections/AbstractCollection;", "E", "", "()V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public abstract class a<E>  implements Collection<E>, a {

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0004\u0010\u0000\u001a\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002 \u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"<anonymous>", "", "E", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 5, 1})
    static final class a extends p implements l<E, java.lang.CharSequence> {

        final kotlin.y.a this$0;
        a(kotlin.y.a a) {
            this.this$0 = a;
            super(1);
        }

        public final java.lang.CharSequence a(E e) {
            String obj2;
            if (e == this.this$0) {
                obj2 = "(this Collection)";
            } else {
                obj2 = String.valueOf(e);
            }
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a(object);
        }
    }
    public boolean add(E e) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    public boolean addAll(Collection<? extends E> collection) {
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
        boolean iterator;
        int i;
        boolean next;
        i = 0;
        if (isEmpty()) {
        } else {
            iterator = iterator();
            while (iterator.hasNext()) {
                if (n.b(iterator.next(), object)) {
                    break;
                } else {
                }
            }
        }
        return i;
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
    public abstract int d();

    @Override // java.util.Collection
    public boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
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
    public Object[] toArray() {
        return f.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        n.f(tArr, "array");
        final Object[] obj2 = f.b(this, tArr);
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T>");
        return obj2;
    }

    @Override // java.util.Collection
    public String toString() {
        a.a aVar2 = new a.a(this);
        return p.h0(this, ", ", "[", "]", 0, 0, aVar2, 24, 0);
    }
}
