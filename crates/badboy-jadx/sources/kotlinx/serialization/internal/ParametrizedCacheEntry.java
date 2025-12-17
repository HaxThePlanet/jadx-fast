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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004JE\u0010\u000b\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\t2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u00072\u0014\u0010\u000e\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\u000fH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011R.\u0010\u0005\u001a\"\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0012\u0012\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0012", d2 = {"Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "T", "", "<init>", "()V", "serializers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlinx/serialization/internal/KTypeWrapper;", "Lkotlin/Result;", "Lkotlinx/serialization/KSerializer;", "computeIfAbsent", "types", "Lkotlin/reflect/KType;", "producer", "Lkotlin/Function0;", "computeIfAbsent-gIAlu-s", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ParametrizedCacheEntry<T>  {

    private final ConcurrentHashMap<List<kotlinx.serialization.internal.KTypeWrapper>, Result<KSerializer<T>>> serializers;
    public ParametrizedCacheEntry() {
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.serializers = concurrentHashMap;
    }

    public static final ConcurrentHashMap access$getSerializers$p(kotlinx.serialization.internal.ParametrizedCacheEntry $this) {
        return $this.serializers;
    }

    public final Object computeIfAbsent-gIAlu-s(List<? extends KType> types, Function0<? extends KSerializer<T>> producer) {
        Object $i$a$LetMapsKt__MapsJVMKt$getOrPut$1$iv;
        int box-impl;
        Object constructor-impl;
        Object ifAbsent;
        Object invoke;
        Object next;
        Object obj;
        int i;
        kotlinx.serialization.internal.KTypeWrapper kTypeWrapper;
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(producer, "producer");
        int i2 = 0;
        Object obj2 = types;
        int i3 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)obj2, 10));
        box-impl = 0;
        ifAbsent = obj2.iterator();
        for (Object next : ifAbsent) {
            i = 0;
            kTypeWrapper = new KTypeWrapper((KType)next);
            (Collection)arrayList.add(kTypeWrapper);
        }
        ConcurrentHashMap map = ParametrizedCacheEntry.access$getSerializers$p(this);
        int i4 = 0;
        if ((ConcurrentMap)map.get((List)arrayList) == null) {
            int i6 = 0;
            kotlin.Result.Companion companion = Result.Companion;
            int i8 = 0;
            constructor-impl = Result.constructor-impl((KSerializer)producer.invoke());
            box-impl = Result.box-impl(constructor-impl);
            int i7 = 0;
            ifAbsent = map.putIfAbsent(arrayList, box-impl);
            $i$a$LetMapsKt__MapsJVMKt$getOrPut$1$iv = ifAbsent == null ? box-impl : ifAbsent;
        }
        Intrinsics.checkNotNullExpressionValue($i$a$LetMapsKt__MapsJVMKt$getOrPut$1$iv, "getOrPut(...)");
        return (Result)$i$a$LetMapsKt__MapsJVMKt$getOrPut$1$iv.unbox-impl();
    }
}
