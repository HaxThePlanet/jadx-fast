package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.CachingKt;
import kotlinx.serialization.internal.ParametrizedSerializerCache;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.SerializerCache;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u000e\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001aA\u0010\u0014\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000f0\u00152\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00112\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0010\u0019\u001a\u001b\u0010\u001a\u001a\u000c\u0012\u0006\u0008\u0001\u0012\u00020\u0002\u0018\u00010\u001b*\u0006\u0012\u0002\u0008\u00030\u0011H\u0080\u0008\"$\u0010\u0000\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0008\u0010\u0004\"\u001e\u0010\t\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00020\n8\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000b\u0010\u0004\"\u001e\u0010\u000c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\r\u0010\u0004¨\u0006\u001c", d2 = {"SERIALIZERS_CACHE", "Lkotlinx/serialization/internal/SerializerCache;", "", "getSERIALIZERS_CACHE$annotations", "()V", "getSERIALIZERS_CACHE", "()Lkotlinx/serialization/internal/SerializerCache;", "SERIALIZERS_CACHE_NULLABLE", "getSERIALIZERS_CACHE_NULLABLE$annotations", "PARAMETRIZED_SERIALIZERS_CACHE", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "getPARAMETRIZED_SERIALIZERS_CACHE$annotations", "PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE", "getPARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$annotations", "findCachedSerializer", "Lkotlinx/serialization/KSerializer;", "clazz", "Lkotlin/reflect/KClass;", "isNullable", "", "findParametrizedCachedSerializer", "Lkotlin/Result;", "types", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KClass;Ljava/util/List;Z)Ljava/lang/Object;", "polymorphicIfInterface", "Lkotlinx/serialization/PolymorphicSerializer;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SerializersCacheKt {

    private static final ParametrizedSerializerCache<? extends Object> PARAMETRIZED_SERIALIZERS_CACHE;
    private static final ParametrizedSerializerCache<Object> PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE;
    private static final SerializerCache<? extends Object> SERIALIZERS_CACHE;
    private static final SerializerCache<Object> SERIALIZERS_CACHE_NULLABLE;
    public static kotlinx.serialization.KSerializer $r8$lambda$CDUGQm1n7K9pqzo8P9YZwMyhBIA(KClass kClass) {
        return SerializersCacheKt.SERIALIZERS_CACHE$lambda$0(kClass);
    }

    public static kotlinx.serialization.KSerializer $r8$lambda$QZg_00R1naeLOC4iM8Uuy7Sy6lE(KClass kClass) {
        return SerializersCacheKt.SERIALIZERS_CACHE_NULLABLE$lambda$1(kClass);
    }

    public static KClassifier $r8$lambda$RgriahIDvpIX9Fi-pB1KGkZ3RP4(List list) {
        return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE$lambda$3$lambda$2(list);
    }

    public static kotlinx.serialization.KSerializer $r8$lambda$Vh1XFmM2zZY_ELrgM9mGRrme84s(KClass kClass, List list2) {
        return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$5(kClass, list2);
    }

    public static kotlinx.serialization.KSerializer $r8$lambda$m8iQGtVGQd9z9poiRBGYlJY7Ut4(KClass kClass, List list2) {
        return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE$lambda$3(kClass, list2);
    }

    public static KClassifier $r8$lambda$oswNSuimvhVDScFNv8TKCtmTyAI(List list) {
        return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$5$lambda$4(list);
    }

    static {
        SerializersCacheKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SerializersCacheKt$$ExternalSyntheticLambda0();
        SerializersCacheKt.SERIALIZERS_CACHE = CachingKt.createCache(externalSyntheticLambda0);
        SerializersCacheKt$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new SerializersCacheKt$$ExternalSyntheticLambda1();
        SerializersCacheKt.SERIALIZERS_CACHE_NULLABLE = CachingKt.createCache(externalSyntheticLambda1);
        SerializersCacheKt$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new SerializersCacheKt$$ExternalSyntheticLambda2();
        SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE = CachingKt.createParametrizedCache(externalSyntheticLambda2);
        SerializersCacheKt$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new SerializersCacheKt$$ExternalSyntheticLambda3();
        SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE = CachingKt.createParametrizedCache(externalSyntheticLambda3);
    }

    private static final kotlinx.serialization.KSerializer PARAMETRIZED_SERIALIZERS_CACHE$lambda$3(KClass clazz, List types) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        List serializersForParameters = SerializersKt.serializersForParameters(SerializersModuleBuildersKt.EmptySerializersModule(), types, true);
        Intrinsics.checkNotNull(serializersForParameters);
        SerializersCacheKt$$ExternalSyntheticLambda4 externalSyntheticLambda4 = new SerializersCacheKt$$ExternalSyntheticLambda4(types);
        return SerializersKt.parametrizedSerializerOrNull(clazz, serializersForParameters, externalSyntheticLambda4);
    }

    private static final KClassifier PARAMETRIZED_SERIALIZERS_CACHE$lambda$3$lambda$2(List $types) {
        return (KType)$types.get(0).getClassifier();
    }

    private static final kotlinx.serialization.KSerializer PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$5(KClass clazz, List types) {
        kotlinx.serialization.KSerializer parametrizedSerializerOrNull;
        int i;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        List serializersForParameters = SerializersKt.serializersForParameters(SerializersModuleBuildersKt.EmptySerializersModule(), types, true);
        Intrinsics.checkNotNull(serializersForParameters);
        SerializersCacheKt$$ExternalSyntheticLambda5 externalSyntheticLambda5 = new SerializersCacheKt$$ExternalSyntheticLambda5(types);
        parametrizedSerializerOrNull = SerializersKt.parametrizedSerializerOrNull(clazz, serializersForParameters, externalSyntheticLambda5);
        if (parametrizedSerializerOrNull != null && BuiltinSerializersKt.getNullable(parametrizedSerializerOrNull) != null) {
            if (BuiltinSerializersKt.getNullable(parametrizedSerializerOrNull) != null) {
                i = 0;
            } else {
                parametrizedSerializerOrNull = 0;
            }
        } else {
        }
        return parametrizedSerializerOrNull;
    }

    private static final KClassifier PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$5$lambda$4(List $types) {
        return (KType)$types.get(0).getClassifier();
    }

    private static final kotlinx.serialization.KSerializer SERIALIZERS_CACHE$lambda$0(KClass it) {
        kotlinx.serialization.KSerializer $this$polymorphicIfInterface$iv;
        int i;
        int polymorphicSerializer;
        Intrinsics.checkNotNullParameter(it, "it");
        if (SerializersKt.serializerOrNull(it) == null) {
            Object obj = it;
            i = 0;
            if (PlatformKt.isInterface(obj)) {
                polymorphicSerializer = new PolymorphicSerializer(obj);
            } else {
                polymorphicSerializer = 0;
            }
            $this$polymorphicIfInterface$iv = polymorphicSerializer;
        }
        return $this$polymorphicIfInterface$iv;
    }

    private static final kotlinx.serialization.KSerializer SERIALIZERS_CACHE_NULLABLE$lambda$1(KClass it) {
        kotlinx.serialization.KSerializer $this$polymorphicIfInterface$iv;
        int i2;
        int i;
        int polymorphicSerializer;
        Intrinsics.checkNotNullParameter(it, "it");
        if (SerializersKt.serializerOrNull(it) == null) {
            Object obj = it;
            i = 0;
            if (PlatformKt.isInterface(obj)) {
                polymorphicSerializer = new PolymorphicSerializer(obj);
            } else {
                polymorphicSerializer = i2;
            }
            $this$polymorphicIfInterface$iv = polymorphicSerializer;
        }
        $this$polymorphicIfInterface$iv = BuiltinSerializersKt.getNullable($this$polymorphicIfInterface$iv);
        if ($this$polymorphicIfInterface$iv != null && $this$polymorphicIfInterface$iv != null) {
            $this$polymorphicIfInterface$iv = BuiltinSerializersKt.getNullable($this$polymorphicIfInterface$iv);
            if ($this$polymorphicIfInterface$iv != null) {
                i2 = $this$polymorphicIfInterface$iv;
                $this$polymorphicIfInterface$iv = 0;
            }
        }
        return i2;
    }

    public static final kotlinx.serialization.KSerializer<Object> findCachedSerializer(KClass<Object> clazz, boolean isNullable) {
        int kSerializer;
        int i;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (!isNullable) {
            if (SerializersCacheKt.SERIALIZERS_CACHE.get(clazz) != null) {
                i = 0;
            } else {
                kSerializer = 0;
            }
        } else {
            kSerializer = SerializersCacheKt.SERIALIZERS_CACHE_NULLABLE.get(clazz);
        }
        return kSerializer;
    }

    public static final Object findParametrizedCachedSerializer(KClass<Object> clazz, List<? extends KType> types, boolean isNullable) {
        Object obj;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        if (!isNullable) {
            obj = SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE.get-gIAlu-s(clazz, types);
        } else {
            obj = SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE.get-gIAlu-s(clazz, types);
        }
        return obj;
    }

    private static void getPARAMETRIZED_SERIALIZERS_CACHE$annotations() {
    }

    private static void getPARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$annotations() {
    }

    public static final SerializerCache<? extends Object> getSERIALIZERS_CACHE() {
        return SerializersCacheKt.SERIALIZERS_CACHE;
    }

    public static void getSERIALIZERS_CACHE$annotations() {
    }

    private static void getSERIALIZERS_CACHE_NULLABLE$annotations() {
    }

    public static final kotlinx.serialization.PolymorphicSerializer<? extends Object> polymorphicIfInterface(KClass<?> $this$polymorphicIfInterface) {
        kotlinx.serialization.PolymorphicSerializer polymorphicSerializer;
        Intrinsics.checkNotNullParameter($this$polymorphicIfInterface, "<this>");
        int i = 0;
        if (PlatformKt.isInterface($this$polymorphicIfInterface)) {
            polymorphicSerializer = new PolymorphicSerializer($this$polymorphicIfInterface);
        } else {
            polymorphicSerializer = 0;
        }
        return polymorphicSerializer;
    }
}
