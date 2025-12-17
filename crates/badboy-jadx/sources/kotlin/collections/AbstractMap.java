package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\u0008\u0008\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008'\u0018\u0000 )*\u0004\u0008\u0000\u0010\u0001*\u0006\u0008\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001)B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0015\u001a\u000c\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u0003\u0018\u00010\u0016H\u0000¢\u0006\u0002\u0008\u0017J\u0015\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u00142\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\u0018\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010!J\u0008\u0010\"\u001a\u00020\rH\u0016J#\u0010#\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J\u0008\u0010%\u001a\u00020\u0014H\u0016J\u0008\u0010&\u001a\u00020'H\u0016J\u0012\u0010&\u001a\u00020'2\u0008\u0010(\u001a\u0004\u0018\u00010\u001fH\u0002J\u001c\u0010&\u001a\u00020'2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016H\u0008R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0008X\u0088\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006*", d2 = {"Lkotlin/collections/AbstractMap;", "K", "V", "", "()V", "_keys", "", "_values", "", "keys", "getKeys", "()Ljava/util/Set;", "size", "", "getSize", "()I", "values", "getValues", "()Ljava/util/Collection;", "containsEntry", "", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "isEmpty", "toString", "", "o", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractMap<K, V>  implements Map<K, V>, KMappedMarker {

    public static final kotlin.collections.AbstractMap.Companion Companion;
    private volatile Set<? extends K> _keys;
    private volatile Collection<? extends V> _values;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\u0008\u0008J\u001d\u0010\t\u001a\u00020\n2\u000e\u0010\u0005\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0006H\u0000¢\u0006\u0002\u0008\u000bJ\u001d\u0010\u000c\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0006H\u0000¢\u0006\u0002\u0008\u000e¨\u0006\u000f", d2 = {"Lkotlin/collections/AbstractMap$Companion;", "", "()V", "entryEquals", "", "e", "", "other", "entryEquals$kotlin_stdlib", "entryHashCode", "", "entryHashCode$kotlin_stdlib", "entryToString", "", "entryToString$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final boolean entryEquals$kotlin_stdlib(Map.Entry<?, ?> e, Object other) {
            boolean equal;
            int i;
            Object value;
            Intrinsics.checkNotNullParameter(e, "e");
            if (!other instanceof Map.Entry) {
                return 0;
            }
            if (Intrinsics.areEqual(e.getKey(), (Map.Entry)other.getKey()) && Intrinsics.areEqual(e.getValue(), (Map.Entry)other.getValue())) {
                if (Intrinsics.areEqual(e.getValue(), (Map.Entry)other.getValue())) {
                    i = 1;
                }
            }
            return i;
        }

        public final int entryHashCode$kotlin_stdlib(Map.Entry<?, ?> e) {
            int i;
            int i2;
            Intrinsics.checkNotNullParameter(e, "e");
            Object obj = e;
            final int i3 = 0;
            Object key = obj.getKey();
            if (key != null) {
                i = key.hashCode();
            } else {
                i = i2;
            }
            final Object value = obj.getValue();
            if (value != null) {
                i2 = value.hashCode();
            }
            return i ^ i2;
        }

        public final String entryToString$kotlin_stdlib(Map.Entry<?, ?> e) {
            Intrinsics.checkNotNullParameter(e, "e");
            Object obj = e;
            final int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append(obj.getKey()).append('=').append(obj.getValue()).toString();
        }
    }
    static {
        AbstractMap.Companion companion = new AbstractMap.Companion(0);
        AbstractMap.Companion = companion;
    }

    public static final String access$toString(kotlin.collections.AbstractMap $this, Map.Entry entry) {
        return $this.toString(entry);
    }

    private final Map.Entry<K, V> implFindEntry(K key) {
        Object element$iv;
        boolean it;
        int i;
        Object key2;
        final int i2 = 0;
        final Iterator iterator = (Iterable)entrySet().iterator();
        for (Object element$iv : iterator) {
            i = 0;
        }
        element$iv = 0;
        return (Map.Entry)element$iv;
    }

    private final String toString(Object o) {
        String valueOf;
        if (o == this) {
            valueOf = "(this Map)";
        } else {
            valueOf = String.valueOf(o);
        }
        return valueOf;
    }

    private final String toString(Map.Entry<? extends K, ? extends V> entry) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(toString(entry.getKey())).append('=').append(toString(entry.getValue())).toString();
    }

    @Override // java.util.Map
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<?, ?> entry) {
        boolean equal;
        String str;
        int i = 0;
        if (entry == null) {
            return i;
        }
        final Object key = entry.getKey();
        Object obj = this;
        Intrinsics.checkNotNull((Map)obj, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Object obj2 = obj.get(key);
        if (!Intrinsics.areEqual(entry.getValue(), obj2)) {
            return i;
        }
        Object obj3 = this;
        Intrinsics.checkNotNull((Map)obj3, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
        if (obj2 == null && !obj3.containsKey(key)) {
            obj3 = this;
            Intrinsics.checkNotNull((Map)obj3, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
            if (!obj3.containsKey(key)) {
                return i;
            }
        }
        return 1;
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        int i;
        i = implFindEntry(key) != null ? 1 : 0;
        return i;
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        boolean iterator;
        int i;
        boolean next;
        boolean it;
        int i2;
        Object value2;
        final Set entrySet = entrySet();
        final int i3 = 0;
        i = 0;
        if (entrySet instanceof Collection != null && (Collection)(Iterable)entrySet.isEmpty()) {
            if ((Collection)entrySet.isEmpty()) {
            } else {
                iterator = entrySet.iterator();
                for (Object next : iterator) {
                    i2 = 0;
                }
            }
        } else {
        }
        return i;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        int i;
        Iterator iterator;
        Object next;
        boolean it;
        int i2;
        if (other == this) {
            return 1;
        }
        final int i3 = 0;
        if (other instanceof Map == null) {
            return i3;
        }
        if (size() != (Map)other.size()) {
            return i3;
        }
        Set entrySet = (Map)other.entrySet();
        int i4 = 0;
        if (entrySet instanceof Collection != null && (Collection)(Iterable)entrySet.isEmpty()) {
            if ((Collection)entrySet.isEmpty()) {
            } else {
                iterator = entrySet.iterator();
                for (Object next : iterator) {
                    i2 = 0;
                }
            }
        } else {
        }
        return i;
    }

    public V get(Object key) {
        Object value;
        Map.Entry implFindEntry = implFindEntry(key);
        if (implFindEntry != null) {
            value = implFindEntry.getValue();
        } else {
            value = 0;
        }
        return value;
    }

    @Override // java.util.Map
    public abstract Set getEntries();

    public Set<K> getKeys() {
        Set _keys;
        if (this._keys == null) {
            _keys = new AbstractMap.keys.1(this);
            this._keys = (Set)_keys;
        }
        Set _keys2 = this._keys;
        Intrinsics.checkNotNull(_keys2);
        return _keys2;
    }

    @Override // java.util.Map
    public int getSize() {
        return entrySet().size();
    }

    public Collection<V> getValues() {
        Collection _values;
        if (this._values == null) {
            _values = new AbstractMap.values.1(this);
            this._values = (Collection)_values;
        }
        Collection _values2 = this._values;
        Intrinsics.checkNotNull(_values2);
        return _values2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
    }

    public final Set<K> keySet() {
        return getKeys();
    }

    public V put(K k, V v2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public V remove(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Map
    public final int size() {
        return getSize();
    }

    @Override // java.util.Map
    public String toString() {
        AbstractMap.toString.1 anon = new AbstractMap.toString.1(this);
        return CollectionsKt.joinToString$default((Iterable)entrySet(), (CharSequence)", ", (CharSequence)"{", (CharSequence)"}", 0, 0, (Function1)anon, 24, 0);
    }

    public final Collection<V> values() {
        return getValues();
    }
}
