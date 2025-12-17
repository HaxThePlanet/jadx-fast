package kotlinx.serialization.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0005\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016J\u0014\u0010\u0010\u001a\u00020\u00112\n\u0010\u000e\u001a\u0006\u0012\u0002\u0008\u00030\u0005H\u0016R&\u0010\u0003\u001a\u001a\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0005\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u0018\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000b\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000c0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lkotlinx/serialization/internal/ConcurrentHashMapCache;", "T", "Lkotlinx/serialization/internal/SerializerCache;", "compute", "Lkotlin/Function1;", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lkotlinx/serialization/internal/CacheEntry;", "get", "key", "", "isStored", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ConcurrentHashMapCache<T>  implements kotlinx.serialization.internal.SerializerCache<T> {

    private final ConcurrentHashMap<Class<?>, kotlinx.serialization.internal.CacheEntry<T>> cache;
    private final Function1<KClass<?>, KSerializer<T>> compute;
    public ConcurrentHashMapCache(Function1<? super KClass<?>, ? extends KSerializer<T>> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        super();
        this.compute = compute;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.cache = concurrentHashMap;
    }

    public KSerializer<T> get(KClass<Object> key) {
        Object $i$a$LetMapsKt__MapsJVMKt$getOrPut$1$iv;
        kotlinx.serialization.internal.CacheEntry cacheEntry;
        Object ifAbsent;
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrentHashMap cache = this.cache;
        final Class javaClass = JvmClassMappingKt.getJavaClass(key);
        final int i = 0;
        if ((ConcurrentMap)cache.get(javaClass) == null) {
            int i2 = 0;
            cacheEntry = new CacheEntry((KSerializer)this.compute.invoke(key));
            int i3 = 0;
            ifAbsent = cache.putIfAbsent(javaClass, cacheEntry);
            $i$a$LetMapsKt__MapsJVMKt$getOrPut$1$iv = ifAbsent == null ? cacheEntry : ifAbsent;
        }
        return $i$a$LetMapsKt__MapsJVMKt$getOrPut$1$iv.serializer;
    }

    public boolean isStored(KClass<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.cache.containsKey(JvmClassMappingKt.getJavaClass(key));
    }
}
