package kotlin.y.u0;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.j0.e;
import kotlin.d0.d.n;
import kotlin.y.f;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010)\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0008\u0000\u0012\u0010\u0010\u0004\u001a\u000c\u0012\u0004\u0012\u00028\u0000\u0012\u0002\u0008\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u000c2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0008\u0010\u0015\u001a\u00020\u000cH\u0016J\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0017H\u0096\u0002J\u0015\u0010\u0018\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0019\u001a\u00020\u000c2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u0016\u0010\u001a\u001a\u00020\u000c2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0011H\u0016R\u0018\u0010\u0004\u001a\u000c\u0012\u0004\u0012\u00028\u0000\u0012\u0002\u0008\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006\u001b", d2 = {"Lkotlin/collections/builders/MapBuilderKeys;", "E", "", "Lkotlin/collections/AbstractMutableSet;", "backing", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class e<E>  extends f<E> implements Set<E>, e {

    private final kotlin.y.u0.c<E, ?> a;
    public e(kotlin.y.u0.c<E, ?> c) {
        n.f(c, "backing");
        super();
        this.a = c;
    }

    public boolean add(E e) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    public boolean addAll(Collection<? extends E> collection) {
        n.f(collection, "elements");
        UnsupportedOperationException obj2 = new UnsupportedOperationException();
        throw obj2;
    }

    @Override // kotlin.y.f
    public void clear() {
        this.a.clear();
    }

    @Override // kotlin.y.f
    public boolean contains(Object object) {
        return this.a.containsKey(object);
    }

    @Override // kotlin.y.f
    public int d() {
        return this.a.size();
    }

    @Override // kotlin.y.f
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.a.C();
    }

    @Override // kotlin.y.f
    public boolean remove(Object object) {
        int obj2;
        obj2 = this.a.J(object) >= 0 ? 1 : 0;
        return obj2;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        n.f(collection, "elements");
        this.a.k();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        n.f(collection, "elements");
        this.a.k();
        return super.retainAll(collection);
    }
}
