package androidx.collection;

import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0016\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u000f\u0012\u0008\u0008\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0007\u001a\u00020\u0005J/\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00012\u0008\u0010\u0019\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\u0008\u001a\u00020\u0005J\u0018\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0013J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u001d\u0010\u001d\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001¢\u0006\u0002\u0010\u001fJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0015\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0013J\u0012\u0010!\u001a\u00020\u00152\u0008\u0008\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\"\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010#J\u0006\u0010\u0010\u001a\u00020\u0005J\u001d\u0010$\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010#J\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&J\u0008\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*", d2 = {"Landroidx/collection/LruCache;", "K", "", "V", "maxSize", "", "(I)V", "createCount", "evictionCount", "hitCount", "lock", "Landroidx/collection/internal/Lock;", "map", "Landroidx/collection/internal/LruHashMap;", "missCount", "putCount", "size", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "evictAll", "get", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "resize", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "sizeOf", "snapshot", "", "toString", "", "trimToSize", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class LruCache<K, V>  {

    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final Lock lock;
    private final LruHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;
    public LruCache(int maxSize) {
        int i;
        super();
        this.maxSize = maxSize;
        int i3 = 0;
        i = this.maxSize > 0 ? 1 : i3;
        if (i == 0) {
        } else {
            LruHashMap lruHashMap = new LruHashMap(i3, 1061158912);
            this.map = lruHashMap;
            Lock lock = new Lock();
            this.lock = lock;
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequireLruCache$1 = new IllegalArgumentException("maxSize <= 0".toString());
        throw $i$a$RequireLruCache$1;
    }

    private final int safeSizeOf(K key, V value) {
        int i;
        final int sizeOf = sizeOf(key, value);
        i = sizeOf >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            return sizeOf;
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Negative size: ").append(key).append('=').append(value).toString().toString());
        throw illegalStateException;
    }

    protected V create(K key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return 0;
    }

    public final int createCount() {
        final int i = 0;
        final Lock lock2 = lock;
        final int i2 = 0;
        final int i3 = 0;
        return this.createCount;
        synchronized (lock2) {
            i = 0;
            lock2 = lock;
            i2 = 0;
            i3 = 0;
            return this.createCount;
        }
    }

    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        final int i = 0;
        final Lock lock2 = lock;
        final int i2 = 0;
        final int i3 = 0;
        return this.evictionCount;
        synchronized (lock2) {
            i = 0;
            lock2 = lock;
            i2 = 0;
            i3 = 0;
            return this.evictionCount;
        }
    }

    public final V get(K key) {
        Object obj;
        Object iNSTANCE;
        int safeSizeOf;
        Intrinsics.checkNotNullParameter(key, "key");
        int i = 0;
        int i3 = 0;
        Lock lock3 = lock;
        int i6 = 0;
        int i7 = 0;
        Object mapValue = obj2;
        synchronized (lock3) {
            this.hitCount = hitCount++;
            return mapValue;
        }
        return 0;
    }

    public final int hitCount() {
        final int i = 0;
        final Lock lock2 = lock;
        final int i2 = 0;
        final int i3 = 0;
        return this.hitCount;
        synchronized (lock2) {
            i = 0;
            lock2 = lock;
            i2 = 0;
            i3 = 0;
            return this.hitCount;
        }
    }

    public final int maxSize() {
        final int i = 0;
        final Lock lock2 = lock;
        final int i2 = 0;
        final int i3 = 0;
        return this.maxSize;
        synchronized (lock2) {
            i = 0;
            lock2 = lock;
            i2 = 0;
            i3 = 0;
            return this.maxSize;
        }
    }

    public final int missCount() {
        final int i = 0;
        final Lock lock2 = lock;
        final int i2 = 0;
        final int i3 = 0;
        return this.missCount;
        synchronized (lock2) {
            i = 0;
            lock2 = lock;
            i2 = 0;
            i3 = 0;
            return this.missCount;
        }
    }

    public final V put(K key, V value) {
        Lock lock;
        Object obj;
        int safeSizeOf;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        int i = 0;
        final int i2 = 0;
        final Lock lock2 = lock;
        final int i3 = 0;
        int i4 = 0;
        this.putCount = putCount++;
        this.size = size += safeSizeOf;
        Object previous = obj;
        synchronized (lock2) {
            this.size = size2 -= safeSizeOf;
            Unit $i$a$SynchronizedLruCache$put$1 = Unit.INSTANCE;
            if (previous != null) {
            }
            trimToSize(this.maxSize);
            return previous;
        }
        entryRemoved(false, key, previous, value);
    }

    public final int putCount() {
        final int i = 0;
        final Lock lock2 = lock;
        final int i2 = 0;
        final int i3 = 0;
        return this.putCount;
        synchronized (lock2) {
            i = 0;
            lock2 = lock;
            i2 = 0;
            i3 = 0;
            return this.putCount;
        }
    }

    public final V remove(K key) {
        Lock lock;
        int i;
        Object remove;
        int safeSizeOf;
        Intrinsics.checkNotNullParameter(key, "key");
        int i2 = 0;
        i = 0;
        final Lock lock2 = lock;
        final int i3 = 0;
        int i4 = 0;
        Object previous = remove;
        synchronized (lock2) {
            this.size = size -= safeSizeOf;
            Unit $i$a$SynchronizedLruCache$remove$1 = Unit.INSTANCE;
            if (previous != null) {
            }
            return previous;
        }
        entryRemoved(false, key, previous, 0);
    }

    public void resize(int maxSize) {
        int i;
        i = maxSize > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            int i2 = 0;
            final Lock lock2 = lock;
            final int i3 = 0;
            int i4 = 0;
            this.maxSize = maxSize;
            Unit $i$a$SynchronizedLruCache$resize$2 = Unit.INSTANCE;
            trimToSize(maxSize);
            return;
            synchronized (lock2) {
                i2 = 0;
                lock2 = lock;
                i3 = 0;
                i4 = 0;
                this.maxSize = maxSize;
                $i$a$SynchronizedLruCache$resize$2 = Unit.INSTANCE;
                trimToSize(maxSize);
            }
        }
        int $this$synchronized$iv = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0".toString());
        throw illegalArgumentException;
    }

    public final int size() {
        final int i = 0;
        final Lock lock2 = lock;
        final int i2 = 0;
        final int i3 = 0;
        return this.size;
        synchronized (lock2) {
            i = 0;
            lock2 = lock;
            i2 = 0;
            i3 = 0;
            return this.size;
        }
    }

    protected int sizeOf(K key, V value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return 1;
    }

    public final Map<K, V> snapshot() {
        Object next;
        Object value;
        int i;
        Object key;
        LinkedHashMap map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i2 = 0;
        final Lock lock2 = lock;
        final int i3 = 0;
        int i4 = 0;
        final int i5 = 0;
        final Iterator iterator = (Iterable)this.map.getEntries().iterator();
        synchronized (lock2) {
            for (Object next : iterator) {
                Object obj = next;
                i = 0;
                (Map)linkedHashMap.put((Map.Entry)obj.getKey(), obj.getValue());
            }
            Unit $i$a$SynchronizedLruCache$snapshot$1 = Unit.INSTANCE;
            return (Map)linkedHashMap;
        }
    }

    public String toString() {
        int i;
        final int i2 = 0;
        final Lock lock2 = lock;
        final int i3 = 0;
        final int i4 = 0;
        hitCount += missCount;
        synchronized (lock2) {
            i6 /= i5;
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("LruCache[maxSize=").append(this.maxSize).append(",hits=").append(this.hitCount).append(",misses=").append(this.missCount).append(",hitRate=").append(i).append("%]").toString();
        }
    }

    public void trimToSize(int maxSize) {
        Object key;
        Object value;
        int $this$synchronized$iv;
        int i4;
        Lock lock;
        int i3;
        Throwable $i$a$SynchronizedLruCache$trimToSize$1;
        Object firstOrNull;
        int i5;
        int empty2;
        boolean empty;
        int i;
        int i2;
        int safeSizeOf;
        int i6 = 0;
        int i7 = 0;
        i4 = 0;
        lock = lock2;
        i3 = 0;
        $i$a$SynchronizedLruCache$trimToSize$1 = 0;
        i = 1;
        synchronized (lock) {
            if (this.map.isEmpty()) {
                i5 = this.size == 0 ? i : 0;
            } else {
            }
            if (i5 == 0) {
            } else {
            }
            int i8 = 0;
            IllegalStateException $i$a$CheckLruCache$trimToSize$1$1 = new IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!".toString());
            throw $i$a$CheckLruCache$trimToSize$1$1;
        }
    }
}
