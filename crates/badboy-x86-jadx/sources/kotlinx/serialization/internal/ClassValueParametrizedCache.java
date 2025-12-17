package kotlinx.serialization.internal;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B5\u0012,\u0010\u0003\u001a(\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004¢\u0006\u0004\u0008\n\u0010\u000bJ9\u0010\u000f\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007H\u0016¢\u0006\u0004\u0008\u0013\u0010\u0014R4\u0010\u0003\u001a(\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lkotlinx/serialization/internal/ClassValueParametrizedCache;", "T", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "compute", "Lkotlin/Function2;", "Lkotlin/reflect/KClass;", "", "", "Lkotlin/reflect/KType;", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "classValue", "Lkotlinx/serialization/internal/ClassValueReferences;", "Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "get", "Lkotlin/Result;", "key", "types", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ClassValueParametrizedCache<T>  implements kotlinx.serialization.internal.ParametrizedSerializerCache<T> {

    private final kotlinx.serialization.internal.ClassValueReferences<kotlinx.serialization.internal.ParametrizedCacheEntry<T>> classValue;
    private final Function2<KClass<Object>, List<? extends KType>, KSerializer<T>> compute;
    public ClassValueParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        super();
        this.compute = compute;
        ClassValueReferences classValueReferences = new ClassValueReferences();
        this.classValue = classValueReferences;
    }

    public Object get-gIAlu-s(KClass<Object> key, List<? extends KType> types) {
        Object orSetWithLock;
        int i2;
        Object obj;
        Object constructor-impl;
        int box-impl;
        int i;
        Object ifAbsent;
        Object next;
        boolean invoke;
        Object obj2;
        int i3;
        kotlinx.serialization.internal.KTypeWrapper kTypeWrapper;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(types, "types");
        int i5 = 0;
        Object obj4 = this.classValue.get(JvmClassMappingKt.getJavaClass(key));
        Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
        if (obj4.reference.get() != null) {
            i2 = 0;
        } else {
            ClassValueParametrizedCache.get-gIAlu-s$$inlined.getOrSet.1 it$iv = new ClassValueParametrizedCache.get-gIAlu-s$$inlined.getOrSet.1();
            orSetWithLock = (MutableSoftReference)obj4.getOrSetWithLock((Function0)it$iv);
        }
        int i4 = 0;
        Object obj3 = types;
        int i6 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)obj3, 10));
        box-impl = 0;
        ifAbsent = obj3.iterator();
        for (Object next : ifAbsent) {
            i3 = 0;
            kTypeWrapper = new KTypeWrapper((KType)next);
            (Collection)arrayList.add(kTypeWrapper);
        }
        java.util.concurrent.ConcurrentHashMap map = ParametrizedCacheEntry.access$getSerializers$p((ParametrizedCacheEntry)orSetWithLock);
        int i7 = 0;
        if ((ConcurrentMap)map.get((List)arrayList) == null) {
            int i9 = 0;
            kotlin.Result.Companion companion = Result.Companion;
            int i11 = 0;
            i = 0;
            constructor-impl = Result.constructor-impl((KSerializer)this.compute.invoke(key, types));
            box-impl = Result.box-impl(constructor-impl);
            int i10 = 0;
            ifAbsent = map.putIfAbsent(arrayList, box-impl);
            obj = ifAbsent == null ? box-impl : ifAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(obj, "getOrPut(...)");
        return (Result)obj.unbox-impl();
    }
}
