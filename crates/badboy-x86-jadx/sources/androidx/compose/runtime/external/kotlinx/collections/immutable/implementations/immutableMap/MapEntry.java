package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010&\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0010\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u0001*\u0006\u0008\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\u0005\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u0013", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MapEntry;", "K", "V", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "equals", "", "other", "", "hashCode", "", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class MapEntry<K, V>  implements Map.Entry<K, V>, KMappedMarker {

    public static final int $stable;
    private final K key;
    private final V value;
    static {
    }

    public MapEntry(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }

    @Override // java.util.Map$Entry
    public boolean equals(Object other) {
        int i3;
        int i2;
        int i;
        boolean equal;
        Object value;
        if (other instanceof Map.Entry) {
            i3 = other;
        } else {
            i3 = 0;
        }
        i2 = 0;
        i = 0;
        if (i3 != 0 && Intrinsics.areEqual(i3.getKey(), getKey()) && Intrinsics.areEqual(i3.getValue(), getValue())) {
            i = 0;
            if (Intrinsics.areEqual(i3.getKey(), getKey())) {
                if (Intrinsics.areEqual(i3.getValue(), getValue())) {
                    i2 = 1;
                }
            }
        }
        return i2;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map$Entry
    public int hashCode() {
        int i;
        int i2;
        Object key = getKey();
        if (key != null) {
            i = key.hashCode();
        } else {
            i = i2;
        }
        final Object value = getValue();
        if (value != null) {
            i2 = value.hashCode();
        }
        return i ^= i2;
    }

    public V setValue(V v) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Map$Entry
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getKey()).append('=').append(getValue()).toString();
    }
}
