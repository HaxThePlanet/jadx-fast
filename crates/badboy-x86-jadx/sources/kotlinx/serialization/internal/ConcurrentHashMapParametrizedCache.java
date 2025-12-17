package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B5\u0012,\u0010\u0003\u001a(\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004¢\u0006\u0004\u0008\n\u0010\u000bJ9\u0010\u0010\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007H\u0016¢\u0006\u0004\u0008\u0014\u0010\u0015R4\u0010\u0003\u001a(\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000c\u001a\u0018\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lkotlinx/serialization/internal/ConcurrentHashMapParametrizedCache;", "T", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "compute", "Lkotlin/Function2;", "Lkotlin/reflect/KClass;", "", "", "Lkotlin/reflect/KType;", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "get", "Lkotlin/Result;", "key", "types", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ConcurrentHashMapParametrizedCache<T>  implements kotlinx.serialization.internal.ParametrizedSerializerCache<T> {

    private final ConcurrentHashMap<Class<?>, kotlinx.serialization.internal.ParametrizedCacheEntry<T>> cache;
    private final Function2<KClass<Object>, List<? extends KType>, KSerializer<T>> compute;
    public ConcurrentHashMapParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        super();
        this.compute = compute;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.cache = concurrentHashMap;
    }

    public Object get-gIAlu-s(KClass<Object> key, List<? extends KType> types) {
        Object obj;
        kotlinx.serialization.internal.ParametrizedCacheEntry parametrizedCacheEntry;
        Object ifAbsent;
        Object obj3;
        int box-impl;
        Object constructor-impl;
        Object ifAbsent2;
        int i;
        Object next;
        boolean invoke;
        Object obj2;
        int i2;
        kotlinx.serialization.internal.KTypeWrapper kTypeWrapper;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(types, "types");
        ConcurrentHashMap cache = this.cache;
        Class javaClass = JvmClassMappingKt.getJavaClass(key);
        int i4 = 0;
        if ((ConcurrentMap)cache.get(javaClass) == null) {
            int i7 = 0;
            parametrizedCacheEntry = new ParametrizedCacheEntry();
            int i8 = 0;
            ifAbsent = cache.putIfAbsent(javaClass, parametrizedCacheEntry);
            obj = ifAbsent == null ? parametrizedCacheEntry : ifAbsent;
        }
        int i3 = 0;
        Object obj4 = types;
        int i5 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)obj4, 10));
        box-impl = 0;
        ifAbsent2 = obj4.iterator();
        for (Object next : ifAbsent2) {
            i2 = 0;
            kTypeWrapper = new KTypeWrapper((KType)next);
            (Collection)arrayList.add(kTypeWrapper);
        }
        ConcurrentHashMap map = ParametrizedCacheEntry.access$getSerializers$p((ParametrizedCacheEntry)obj);
        int i6 = 0;
        if ((ConcurrentMap)map.get((List)arrayList) == null) {
            int i10 = 0;
            kotlin.Result.Companion companion = Result.Companion;
            int i12 = 0;
            i = 0;
            constructor-impl = Result.constructor-impl((KSerializer)this.compute.invoke(key, types));
            box-impl = Result.box-impl(constructor-impl);
            int i11 = 0;
            ifAbsent2 = map.putIfAbsent(arrayList, box-impl);
            obj3 = ifAbsent2 == null ? box-impl : ifAbsent2;
        }
        Intrinsics.checkNotNullExpressionValue(obj3, "getOrPut(...)");
        return (Result)obj3.unbox-impl();
    }
}
