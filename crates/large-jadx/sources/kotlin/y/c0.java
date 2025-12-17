package kotlin.y;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0000\u0008Â\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00060\u0004j\u0002`\u0005B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\u0013\u0010\u001d\u001a\u00020\u00192\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0008\u0010 \u001a\u00020\u0011H\u0016J\u0008\u0010!\u001a\u00020\u0019H\u0016J\u0008\u0010\"\u001a\u00020\u0002H\u0002J\u0008\u0010#\u001a\u00020$H\u0016R(\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\t0\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u001c\u0010\u000c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017¨\u0006%", d2 = {"Lkotlin/collections/EmptyMap;", "", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "serialVersionUID", "", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "containsValue", "value", "equals", "other", "get", "hashCode", "isEmpty", "readResolve", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class c0 implements Map, Serializable, a {

    public static final kotlin.y.c0 a = null;
    private static final long serialVersionUID = 8246714829545688274L;
    static {
        c0 c0Var = new c0();
        c0.a = c0Var;
    }

    private final Object readResolve() {
        return c0.a;
    }

    @Override // java.util.Map
    public boolean a(Void void) {
        n.f(void, "value");
        return 0;
    }

    @Override // java.util.Map
    public Void c(Object object) {
        return null;
    }

    @Override // java.util.Map
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Map
    public boolean containsKey(Object object) {
        return 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object object) {
        if (object instanceof Void) {
            return a((Void)object);
        }
        return 0;
    }

    public Set<Map.Entry> d() {
        return d0.a;
    }

    public Set<Object> e() {
        return d0.a;
    }

    public final Set<Map.Entry> entrySet() {
        return d();
    }

    @Override // java.util.Map
    public boolean equals(Object object) {
        Object obj2;
        if (object instanceof Map != null && (Map)object.isEmpty()) {
            obj2 = (Map)object.isEmpty() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // java.util.Map
    public int f() {
        return 0;
    }

    @Override // java.util.Map
    public Collection g() {
        return b0.a;
    }

    @Override // java.util.Map
    public final Object get(Object object) {
        return c(object);
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return 1;
    }

    public final Set<Object> keySet() {
        return e();
    }

    @Override // java.util.Map
    public Object put(Object object, Object object2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj1;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.Map
    public Object remove(Object object) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return f();
    }

    @Override // java.util.Map
    public String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final Collection values() {
        return g();
    }
}
