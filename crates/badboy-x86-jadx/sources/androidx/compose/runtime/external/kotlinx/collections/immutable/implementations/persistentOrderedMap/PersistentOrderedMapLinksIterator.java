package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B)\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00010\u00040\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0002J\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00010\u00040\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013¨\u0006\u0017", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapLinksIterator;", "K", "V", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "nextKey", "", "hashMap", "", "(Ljava/lang/Object;Ljava/util/Map;)V", "index", "", "getIndex$runtime_release", "()I", "setIndex$runtime_release", "(I)V", "getNextKey$runtime_release", "()Ljava/lang/Object;", "setNextKey$runtime_release", "(Ljava/lang/Object;)V", "hasNext", "", "next", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class PersistentOrderedMapLinksIterator<K, V>  implements Iterator<androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue<V>>, KMappedMarker {

    public static final int $stable = 8;
    private final Map<K, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue<V>> hashMap;
    private int index;
    private Object nextKey;
    static {
        final int i = 8;
    }

    public PersistentOrderedMapLinksIterator(Object nextKey, Map<K, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue<V>> hashMap) {
        super();
        this.nextKey = nextKey;
        this.hashMap = hashMap;
    }

    @Override // java.util.Iterator
    public final int getIndex$runtime_release() {
        return this.index;
    }

    @Override // java.util.Iterator
    public final Object getNextKey$runtime_release() {
        return this.nextKey;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        i = this.index < this.hashMap.size() ? 1 : 0;
        return i;
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue<V> next() {
        if (!hasNext()) {
        } else {
            Object obj = this.hashMap.get(this.nextKey);
            if (obj == null) {
            } else {
                this.index = index++;
                this.nextKey = (LinkedValue)obj.getNext();
                return obj;
            }
            int result = 0;
            StringBuilder stringBuilder = new StringBuilder();
            ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException(stringBuilder.append("Hash code of a key (").append(this.nextKey).append(") has changed after it was added to the persistent map.").toString());
            throw concurrentModificationException;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    @Override // java.util.Iterator
    public Object next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Iterator
    public final void setIndex$runtime_release(int <set-?>) {
        this.index = <set-?>;
    }

    @Override // java.util.Iterator
    public final void setNextKey$runtime_release(Object <set-?>) {
        this.nextKey = <set-?>;
    }
}
