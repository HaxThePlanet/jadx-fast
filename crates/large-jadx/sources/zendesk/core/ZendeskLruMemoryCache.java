package zendesk.core;

import android.util.LruCache;

/* loaded from: classes3.dex */
class ZendeskLruMemoryCache implements zendesk.core.MemoryCache {

    public final LruCache<String, Object> cache;
    public ZendeskLruMemoryCache() {
        LruCache lruCache = new LruCache(50);
        super(lruCache);
    }

    ZendeskLruMemoryCache(LruCache<String, Object> lruCache) {
        super();
        this.cache = lruCache;
    }

    @Override // zendesk.core.MemoryCache
    public void clear() {
        this.cache.evictAll();
    }

    @Override // zendesk.core.MemoryCache
    public boolean contains(String string) {
        int obj2;
        synchronized (this) {
            try {
                obj2 = 1;
                obj2 = 0;
                return obj2;
                throw string;
            }
        }
    }

    public <T> T get(String string) {
        return this.cache.get(string);
        synchronized (this) {
            return this.cache.get(string);
        }
    }

    public <T> T getOrDefault(String string, T t2) {
        final Object obj1 = get(string);
        if (obj1 != null) {
            return obj1;
        }
        return t2;
    }

    @Override // zendesk.core.MemoryCache
    public void put(String string, Object object2) {
        this.cache.put(string, object2);
        return;
        synchronized (this) {
            this.cache.put(string, object2);
        }
    }

    @Override // zendesk.core.MemoryCache
    public void remove(String string) {
        this.cache.remove(string);
        return;
        synchronized (this) {
            this.cache.remove(string);
        }
    }
}
