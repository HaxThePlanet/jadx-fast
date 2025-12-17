package androidx.core.util;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u001aø\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0004\"\u0008\u0008\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\u0008\u0006\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\u00060\u00082%\u0008\u0006\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2d\u0008\u0006\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0012\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086\u0008¨\u0006\u0016", d2 = {"lruCache", "Landroid/util/LruCache;", "K", "V", "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int maxSize, Function2<? super K, ? super V, Integer> sizeOf, Function1<? super K, ? extends V> create, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> onEntryRemoved) {
        final int i = 0;
        LruCacheKt.lruCache.4 anon = new LruCacheKt.lruCache.4(maxSize, sizeOf, create, onEntryRemoved);
        return (LruCache)anon;
    }

    public static LruCache lruCache$default(int maxSize, Function2 sizeOf, Function1 create, Function4 onEntryRemoved, int i5, Object object6) {
        androidx.core.util.LruCacheKt.lruCache.1 obj1;
        androidx.core.util.LruCacheKt.lruCache.2 obj2;
        androidx.core.util.LruCacheKt.lruCache.3 obj3;
        int obj4;
        int obj5;
        if (i5 & 2 != 0) {
            obj1 = obj5;
        }
        if (i5 & 4 != 0) {
            obj2 = obj5;
        }
        if (i5 &= 8 != 0) {
            obj3 = obj4;
        }
        obj4 = 0;
        obj5 = new LruCacheKt.lruCache.4(maxSize, obj1, obj2, obj3);
        return (LruCache)obj5;
    }
}
