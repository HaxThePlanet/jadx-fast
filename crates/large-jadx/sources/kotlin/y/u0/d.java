package kotlin.y.u0;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010&\n\u0002\u0008\u0002\n\u0002\u0010)\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u001b\u0008\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u0011\u001a\u00020\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0013H\u0016J\u001c\u0010\u0017\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018H\u0016J\u0008\u0010\u0019\u001a\u00020\u000fH\u0016J\u001b\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u001bH\u0096\u0002J\u001c\u0010\u001c\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u001d\u001a\u00020\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0013H\u0016J\"\u0010\u001e\u001a\u00020\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0013H\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001f", d2 = {"Lkotlin/collections/builders/MapBuilderEntries;", "K", "V", "Lkotlin/collections/builders/AbstractMapBuilderEntrySet;", "", "backing", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "getBacking", "()Lkotlin/collections/builders/MapBuilder;", "size", "", "getSize", "()I", "add", "", "element", "addAll", "elements", "", "clear", "", "containsAll", "containsEntry", "", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class d<K, V>  extends kotlin.y.u0.a<Map.Entry<K, V>, K, V> {

    private final kotlin.y.u0.c<K, V> a;
    public d(kotlin.y.u0.c<K, V> c) {
        n.f(c, "backing");
        super();
        this.a = c;
    }

    @Override // kotlin.y.u0.a
    public boolean add(Object object) {
        l((Map.Entry)object);
        throw 0;
    }

    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        n.f(collection, "elements");
        UnsupportedOperationException obj2 = new UnsupportedOperationException();
        throw obj2;
    }

    @Override // kotlin.y.u0.a
    public void clear() {
        this.a.clear();
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        n.f(collection, "elements");
        return this.a.m(collection);
    }

    @Override // kotlin.y.u0.a
    public int d() {
        return this.a.size();
    }

    public boolean h(Map.Entry<? extends K, ? extends V> map$Entry) {
        n.f(entry, "element");
        return this.a.n(entry);
    }

    @Override // kotlin.y.u0.a
    public boolean i(Map.Entry map$Entry) {
        n.f(entry, "element");
        return this.a.H(entry);
    }

    @Override // kotlin.y.u0.a
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return this.a.s();
    }

    public boolean l(Map.Entry<K, V> map$Entry) {
        n.f(entry, "element");
        UnsupportedOperationException obj2 = new UnsupportedOperationException();
        throw obj2;
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
