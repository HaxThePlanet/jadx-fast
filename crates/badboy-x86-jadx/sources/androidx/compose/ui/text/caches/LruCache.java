package androidx.compose.ui.text.caches;

import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u00020\u0003B\u000f\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0019J\u0006\u0010\u0007\u001a\u00020\u0005J/\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u00012\u0008\u0010\u001f\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010\u0008\u001a\u00020\u0005J\u0015\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u001d\u0010#\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001¢\u0006\u0002\u0010%J\u0006\u0010\u0013\u001a\u00020\u0005J\u0015\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010(\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010)J\u001d\u0010*\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010)J\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,J$\u0010-\u001a\u0002H.\"\u0004\u0008\u0002\u0010.2\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u0002H.00H\u0080\u0008¢\u0006\u0004\u00081\u00102J\u0008\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\u0008\u0012\u0004\u0012\u00028\u0000`\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000ej\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058G@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u00066", d2 = {"Landroidx/compose/ui/text/caches/LruCache;", "K", "V", "", "maxSize", "", "(I)V", "createCount", "evictionCount", "hitCount", "keySet", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "missCount", "monitor", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "putCount", "<set-?>", "size", "()I", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "evictAll", "get", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "resize", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "sizeOf", "snapshot", "", "synchronizedValue", "R", "block", "Lkotlin/Function0;", "synchronizedValue$ui_text_release", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toString", "", "trimToSize", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class LruCache<K, V>  {

    public static final int $stable = 8;
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashSet<K> keySet;
    private final HashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private final SynchronizedObject monitor;
    private int putCount;
    private int size;
    static {
        final int i = 8;
    }

    public LruCache(int maxSize) {
        int i;
        super();
        this.monitor = Synchronization_jvmKt.createSynchronizedObject();
        int i2 = 0;
        i = maxSize > 0 ? 1 : i2;
        if (i == 0) {
        } else {
            this.maxSize = maxSize;
            HashMap hashMap = new HashMap(i2, 1061158912);
            this.map = hashMap;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            this.keySet = linkedHashSet;
        }
        int i3 = 0;
        IllegalArgumentException $i$a$RequireLruCache$1 = new IllegalArgumentException("maxSize <= 0".toString());
        throw $i$a$RequireLruCache$1;
    }

    public static final SynchronizedObject access$getMonitor$p(androidx.compose.ui.text.caches.LruCache $this) {
        return $this.monitor;
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
        return 0;
    }

    public final int createCount() {
        final int i = 0;
        final SynchronizedObject synchronizedObject = LruCache.access$getMonitor$p(this);
        final int i2 = 0;
        final int i3 = 0;
        return this.createCount;
        synchronized (synchronizedObject) {
            i = 0;
            synchronizedObject = LruCache.access$getMonitor$p(this);
            i2 = 0;
            i3 = 0;
            return this.createCount;
        }
    }

    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        final int i = 0;
        final SynchronizedObject synchronizedObject = LruCache.access$getMonitor$p(this);
        final int i2 = 0;
        final int i3 = 0;
        return this.evictionCount;
        synchronized (synchronizedObject) {
            i = 0;
            synchronizedObject = LruCache.access$getMonitor$p(this);
            i2 = 0;
            i3 = 0;
            return this.evictionCount;
        }
    }

    public final V get(K key) {
        Object mapValue;
        int map;
        int safeSizeOf;
        int i = 0;
        SynchronizedObject monitor = this.monitor;
        int i2 = 0;
        int i5 = 0;
        mapValue = obj;
        synchronized (monitor) {
            this.keySet.remove(key);
            this.keySet.add(key);
            this.hitCount = hitCount++;
            return mapValue;
        }
        return 0;
    }

    public final int hitCount() {
        final int i = 0;
        final SynchronizedObject synchronizedObject = LruCache.access$getMonitor$p(this);
        final int i2 = 0;
        final int i3 = 0;
        return this.hitCount;
        synchronized (synchronizedObject) {
            i = 0;
            synchronizedObject = LruCache.access$getMonitor$p(this);
            i2 = 0;
            i3 = 0;
            return this.hitCount;
        }
    }

    public final int maxSize() {
        final int i = 0;
        final SynchronizedObject synchronizedObject = LruCache.access$getMonitor$p(this);
        final int i2 = 0;
        final int i3 = 0;
        return this.maxSize;
        synchronized (synchronizedObject) {
            i = 0;
            synchronizedObject = LruCache.access$getMonitor$p(this);
            i2 = 0;
            i3 = 0;
            return this.maxSize;
        }
    }

    public final int missCount() {
        final int i = 0;
        final SynchronizedObject synchronizedObject = LruCache.access$getMonitor$p(this);
        final int i2 = 0;
        final int i3 = 0;
        return this.missCount;
        synchronized (synchronizedObject) {
            i = 0;
            synchronizedObject = LruCache.access$getMonitor$p(this);
            i2 = 0;
            i3 = 0;
            return this.missCount;
        }
    }

    public final V put(K key, V value) {
        SynchronizedObject monitor;
        Object obj;
        boolean keySet;
        int safeSizeOf;
        if (key == null) {
        } else {
            if (value == null) {
            } else {
                int i = 0;
                monitor = this.monitor;
                final int i2 = 0;
                final int i3 = 0;
                this.putCount = putCount++;
                this.size = size += safeSizeOf;
                Object previous2 = obj;
                synchronized (monitor) {
                    this.size = size2 -= safeSizeOf;
                    if (this.keySet.contains(key)) {
                        this.keySet.remove(key);
                    }
                    this.keySet.add(key);
                    if (previous2 != null) {
                    }
                    trimToSize(this.maxSize);
                    return previous2;
                }
                entryRemoved(false, key, previous2, value);
            }
        }
        try {
            NullPointerException previous = new NullPointerException();
            throw previous;
        }
    }

    public final int putCount() {
        final int i = 0;
        final SynchronizedObject synchronizedObject = LruCache.access$getMonitor$p(this);
        final int i2 = 0;
        final int i3 = 0;
        return this.putCount;
        synchronized (synchronizedObject) {
            i = 0;
            synchronizedObject = LruCache.access$getMonitor$p(this);
            i2 = 0;
            i3 = 0;
            return this.putCount;
        }
    }

    public final V remove(K key) {
        SynchronizedObject monitor;
        int i;
        LinkedHashSet keySet;
        int safeSizeOf;
        if (key == null) {
        } else {
            int i2 = 0;
            monitor = this.monitor;
            i = 0;
            int i3 = 0;
            Object previous2 = remove;
            this.keySet.remove(key);
            synchronized (monitor) {
                this.size = size -= safeSizeOf;
                Unit $i$a$SynchronizedLruCache$remove$1 = Unit.INSTANCE;
                if (previous2 != null) {
                }
                return previous2;
            }
            entryRemoved(false, key, previous2, 0);
        }
        NullPointerException previous = new NullPointerException();
        throw previous;
    }

    public void resize(int maxSize) {
        int i;
        i = maxSize > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            SynchronizedObject monitor = this.monitor;
            int i2 = 0;
            int i3 = 0;
            this.maxSize = maxSize;
            Unit $i$a$SynchronizedLruCache$resize$2 = Unit.INSTANCE;
            trimToSize(maxSize);
            return;
            synchronized (monitor) {
                monitor = this.monitor;
                i2 = 0;
                i3 = 0;
                this.maxSize = maxSize;
                $i$a$SynchronizedLruCache$resize$2 = Unit.INSTANCE;
                trimToSize(maxSize);
            }
        }
        int lock$iv = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0".toString());
        throw illegalArgumentException;
    }

    public final int size() {
        final int i = 0;
        final SynchronizedObject synchronizedObject = LruCache.access$getMonitor$p(this);
        final int i2 = 0;
        final int i3 = 0;
        return this.size;
        synchronized (synchronizedObject) {
            i = 0;
            synchronizedObject = LruCache.access$getMonitor$p(this);
            i2 = 0;
            i3 = 0;
            return this.size;
        }
    }

    protected int sizeOf(K key, V value) {
        return 1;
    }

    public final Map<K, V> snapshot() {
        Object next;
        Object obj;
        final SynchronizedObject monitor = this.monitor;
        final int i = 0;
        final int i2 = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = this.keySet.iterator();
        synchronized (monitor) {
            for (Object next : iterator) {
                obj = this.map.get(next);
                Intrinsics.checkNotNull(obj);
                linkedHashMap.put(next, obj);
            }
            return (Map)linkedHashMap;
        }
    }

    public final <R> R synchronizedValue$ui_text_release(Function0<? extends R> block) {
        final int i = 0;
        final SynchronizedObject synchronizedObject = LruCache.access$getMonitor$p(this);
        final int i2 = 0;
        return block.invoke();
        synchronized (synchronizedObject) {
            i = 0;
            synchronizedObject = LruCache.access$getMonitor$p(this);
            i2 = 0;
            return block.invoke();
        }
    }

    public String toString() {
        int i;
        final SynchronizedObject monitor = this.monitor;
        final int i2 = 0;
        final int i3 = 0;
        hitCount += missCount;
        synchronized (monitor) {
            i5 /= i4;
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("LruCache[maxSize=").append(this.maxSize).append(",hits=").append(this.hitCount).append(",misses=").append(this.missCount).append(",hitRate=").append(i).append("%]").toString();
        }
    }

    public void trimToSize(int maxSize) {
        int key;
        int value;
        int i2;
        int i;
        Object $i$a$SynchronizedLruCache$trimToSize$1;
        int empty3;
        int empty;
        int empty2;
        int safeSizeOf;
        key = 0;
        value = 0;
        SynchronizedObject monitor = this.monitor;
        i = 0;
        int i3 = 0;
        synchronized (monitor) {
            if (this.map.isEmpty()) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("map/keySet size inconsistency");
            throw illegalStateException;
        }
        if (value == null) {
        } else {
        }
    }
}
