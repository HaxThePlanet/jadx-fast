package kotlin.y.u0;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.j0.b;
import kotlin.d0.d.n;
import kotlin.y.c;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010)\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0008\u0000\u0012\u0010\u0010\u0004\u001a\u000c\u0012\u0002\u0008\u0003\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0010J\u0008\u0010\u0017\u001a\u00020\u000eH\u0016J\u000f\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019H\u0096\u0002J\u0015\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0016\u0010\u001b\u001a\u00020\u000e2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0013H\u0016J\u0016\u0010\u001c\u001a\u00020\u000e2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0013H\u0016R\u001b\u0010\u0004\u001a\u000c\u0012\u0002\u0008\u0003\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001d", d2 = {"Lkotlin/collections/builders/MapBuilderValues;", "V", "", "Lkotlin/collections/AbstractMutableCollection;", "backing", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "getBacking", "()Lkotlin/collections/builders/MapBuilder;", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class f<V>  extends c<V> implements Collection<V>, b {

    private final kotlin.y.u0.c<?, V> a;
    public f(kotlin.y.u0.c<?, V> c) {
        n.f(c, "backing");
        super();
        this.a = c;
    }

    public boolean add(V v) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    public boolean addAll(Collection<? extends V> collection) {
        n.f(collection, "elements");
        UnsupportedOperationException obj2 = new UnsupportedOperationException();
        throw obj2;
    }

    @Override // kotlin.y.c
    public void clear() {
        this.a.clear();
    }

    @Override // kotlin.y.c
    public boolean contains(Object object) {
        return this.a.containsValue(object);
    }

    @Override // kotlin.y.c
    public int d() {
        return this.a.size();
    }

    @Override // kotlin.y.c
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator<V> iterator() {
        return this.a.M();
    }

    @Override // kotlin.y.c
    public boolean remove(Object object) {
        return this.a.L(object);
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
