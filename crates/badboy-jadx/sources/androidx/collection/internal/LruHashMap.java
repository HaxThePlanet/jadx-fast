package androidx.collection.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u001d\u0008\u0016\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0002\u0010\u0005B\u0019\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0017\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0018J\u001d\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u0001¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0017\u001a\u00028\u0000¢\u0006\u0002\u0010\u0018R#\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0012R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Landroidx/collection/internal/LruHashMap;", "K", "", "V", "original", "(Landroidx/collection/internal/LruHashMap;)V", "initialCapacity", "", "loadFactor", "", "(IF)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "isEmpty", "", "()Z", "map", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LruHashMap<K, V>  {

    private final LinkedHashMap<K, V> map;
    public LruHashMap() {
        super(0, 0, 3, 0);
    }

    public LruHashMap(int initialCapacity, float loadFactor) {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap(initialCapacity, loadFactor, 1);
        this.map = linkedHashMap;
    }

    public LruHashMap(int i, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj1;
        int obj2;
        obj1 = i3 & 1 != 0 ? 16 : obj1;
        obj2 = i3 &= 2 != 0 ? 1061158912 : obj2;
        super(obj1, obj2);
    }

    public LruHashMap(androidx.collection.internal.LruHashMap<? extends K, V> original) {
        int value;
        int key;
        Intrinsics.checkNotNullParameter(original, "original");
        super(0, 0, 3, 0);
        Iterator iterator = original.getEntries().iterator();
        for (Map.Entry next2 : iterator) {
            put(next2.getKey(), next2.getValue());
        }
    }

    public final V get(K key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.map.get(key);
    }

    public final Set<Map.Entry<K, V>> getEntries() {
        Set entrySet = this.map.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "map.entries");
        return entrySet;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final V put(K key, V value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.map.put(key, value);
    }

    public final V remove(K key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.map.remove(key);
    }
}
