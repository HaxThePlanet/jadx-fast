package kotlinx.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0003\u001a\u0017\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002\u0018\u0001H\u0086\u0008\u001a\u001b\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\u0008\u001a\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a6\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u00082\u0010\u0010\t\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0007\u001a\u0018\u0010\r\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a:\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001*\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u00082\u0010\u0010\t\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0007\u001a\u001c\u0010\r\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a+\u0010\u000e\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000cH\u0002¢\u0006\u0002\u0008\u0010\u001aG\u0010\u0011\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0001*\u00020\u00032\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00082\u0014\u0010\t\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002¢\u0006\u0002\u0008\u0013\u001a2\u0010\u0014\u001a\u0012\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001\u0018\u00010\n*\u00020\u00032\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000f\u001a\u00020\u000cH\u0000\u001a\"\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0004*\u0008\u0012\u0004\u0012\u0002H\u00020\u0008H\u0007\u001a$\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0004*\u0008\u0012\u0004\u0012\u0002H\u00020\u0008H\u0007\u001aB\u0010\u0016\u001a\u000c\u0012\u0006\u0008\u0001\u0012\u00020\u0004\u0018\u00010\u0001*\u0008\u0012\u0004\u0012\u00020\u00040\u00082\u0014\u0010\u0017\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\n2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0000\u001a7\u0010\u001b\u001a\u000c\u0012\u0006\u0008\u0001\u0012\u00020\u0004\u0018\u00010\u0001*\u0008\u0012\u0004\u0012\u00020\u00040\u00082\u0014\u0010\u0017\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\nH\u0002¢\u0006\u0002\u0008\u001c\u001aG\u0010\u001d\u001a\u000c\u0012\u0006\u0008\u0001\u0012\u00020\u0004\u0018\u00010\u0001*\u0008\u0012\u0004\u0012\u00020\u00040\u00082\u0014\u0010\u0017\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\n2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0002¢\u0006\u0002\u0008\u001e\u001a1\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0004*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010 \u001a\u00020\u000cH\u0002¢\u0006\u0002\u0008!\u001a\u0014\u0010\"\u001a\u0006\u0012\u0002\u0008\u00030\u00012\u0006\u0010#\u001a\u00020$H\u0001\u001a \u0010\"\u001a\u0006\u0012\u0002\u0008\u00030\u00012\u0006\u0010%\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u0008H\u0001\u001a7\u0010\"\u001a\u0006\u0012\u0002\u0008\u00030\u00012\u0006\u0010%\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u00082\u0010\u0010&\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00010'H\u0001¢\u0006\u0002\u0010(\u001a \u0010)\u001a\u0006\u0012\u0002\u0008\u00030\u00012\u0006\u0010%\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u0008H\u0001\u001a7\u0010)\u001a\u0006\u0012\u0002\u0008\u00030\u00012\u0006\u0010%\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u00082\u0010\u0010&\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00010'H\u0001¢\u0006\u0002\u0010(¨\u0006*", d2 = {"serializer", "Lkotlinx/serialization/KSerializer;", "T", "Lkotlinx/serialization/modules/SerializersModule;", "", "type", "Lkotlin/reflect/KType;", "kClass", "Lkotlin/reflect/KClass;", "typeArgumentsSerializers", "", "isNullable", "", "serializerOrNull", "serializerByKTypeImpl", "failOnMissingTypeArgSerializer", "serializerByKTypeImpl$SerializersKt__SerializersKt", "serializerByKClassImpl", "rootClass", "serializerByKClassImpl$SerializersKt__SerializersKt", "serializersForParameters", "typeArguments", "parametrizedSerializerOrNull", "serializers", "elementClassifierIfArray", "Lkotlin/Function0;", "Lkotlin/reflect/KClassifier;", "compiledParametrizedSerializer", "compiledParametrizedSerializer$SerializersKt__SerializersKt", "builtinParametrizedSerializer", "builtinParametrizedSerializer$SerializersKt__SerializersKt", "nullable", "shouldBeNullable", "nullable$SerializersKt__SerializersKt", "noCompiledSerializer", "forClass", "", "module", "argSerializers", "", "(Lkotlinx/serialization/modules/SerializersModule;Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "moduleThenPolymorphic", "kotlinx-serialization-core"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "kotlinx/serialization/SerializersKt")
final class SerializersKt__SerializersKt {
    public static KClassifier $r8$lambda$kySqFMIAiKMq9XadqaNh2wiOkNo() {
        return SerializersKt__SerializersKt.serializerByKClassImpl$lambda$1$SerializersKt__SerializersKt();
    }

    public static KClassifier $r8$lambda$u_x7BEkvLYF9XQ9RRlbMZi_QcQ0(List list) {
        return SerializersKt__SerializersKt.serializerByKTypeImpl$lambda$0$SerializersKt__SerializersKt(list);
    }

    private static final kotlinx.serialization.KSerializer<? extends Object> builtinParametrizedSerializer$SerializersKt__SerializersKt(KClass<Object> $this$builtinParametrizedSerializer, List<? extends kotlinx.serialization.KSerializer<Object>> serializers, Function0<? extends KClassifier> elementClassifierIfArray) {
        boolean equal;
        boolean equal3;
        boolean equal2;
        ArrayListSerializer linkedHashSetSerializer;
        Object i;
        Object str;
        i = 0;
        if (!Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(Collection.class)) && !Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(List.class)) && !Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(List.class))) {
            if (!Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(List.class))) {
                if (!Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(List.class))) {
                    if (Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(ArrayList.class))) {
                        linkedHashSetSerializer = new ArrayListSerializer((KSerializer)serializers.get(i));
                    } else {
                        if (Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(HashSet.class))) {
                            linkedHashSetSerializer = new HashSetSerializer((KSerializer)serializers.get(i));
                        } else {
                            if (!Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(Set.class)) && !Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(Set.class))) {
                                if (!Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(Set.class))) {
                                    if (Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(LinkedHashSet.class))) {
                                        linkedHashSetSerializer = new LinkedHashSetSerializer((KSerializer)serializers.get(i));
                                    } else {
                                        str = 1;
                                        if (Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(HashMap.class))) {
                                            linkedHashSetSerializer = new HashMapSerializer((KSerializer)serializers.get(i), (KSerializer)serializers.get(str));
                                        } else {
                                            if (!Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(Map.class)) && !Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(Map.class))) {
                                                if (!Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(Map.class))) {
                                                    if (Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(LinkedHashMap.class))) {
                                                        linkedHashSetSerializer = new LinkedHashMapSerializer((KSerializer)serializers.get(i), (KSerializer)serializers.get(str));
                                                    } else {
                                                        if (Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(Map.Entry.class))) {
                                                            linkedHashSetSerializer = BuiltinSerializersKt.MapEntrySerializer((KSerializer)serializers.get(i), (KSerializer)serializers.get(str));
                                                        } else {
                                                            if (Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(Pair.class))) {
                                                                linkedHashSetSerializer = BuiltinSerializersKt.PairSerializer((KSerializer)serializers.get(i), (KSerializer)serializers.get(str));
                                                            } else {
                                                                if (Intrinsics.areEqual($this$builtinParametrizedSerializer, Reflection.getOrCreateKotlinClass(Triple.class))) {
                                                                    linkedHashSetSerializer = BuiltinSerializersKt.TripleSerializer((KSerializer)serializers.get(i), (KSerializer)serializers.get(str), (KSerializer)serializers.get(2));
                                                                } else {
                                                                    if (PlatformKt.isReferenceArray($this$builtinParametrizedSerializer)) {
                                                                        Object invoke = elementClassifierIfArray.invoke();
                                                                        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                                                                        linkedHashSetSerializer = BuiltinSerializersKt.ArraySerializer((KClass)invoke, (KSerializer)serializers.get(i));
                                                                    } else {
                                                                        linkedHashSetSerializer = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        }
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return linkedHashSetSerializer;
    }

    private static final kotlinx.serialization.KSerializer<? extends Object> compiledParametrizedSerializer$SerializersKt__SerializersKt(KClass<Object> $this$compiledParametrizedSerializer, List<? extends kotlinx.serialization.KSerializer<Object>> serializers) {
        int i = 0;
        Object[] $this$toTypedArray$iv = (Collection)serializers.toArray(new KSerializer[0]);
        return PlatformKt.constructSerializerForGivenTypeArgs($this$compiledParametrizedSerializer, (KSerializer[])Arrays.copyOf((KSerializer[])$this$toTypedArray$iv, $this$toTypedArray$iv.length));
    }

    public static final kotlinx.serialization.KSerializer<?> moduleThenPolymorphic(SerializersModule module, KClass<?> kClass) {
        kotlinx.serialization.KSerializer polymorphicSerializer;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        int i = 0;
        if (SerializersModule.getContextual$default(module, kClass, i, 2, i) == null) {
            polymorphicSerializer = new PolymorphicSerializer(kClass);
        }
        return polymorphicSerializer;
    }

    public static final kotlinx.serialization.KSerializer<?> moduleThenPolymorphic(SerializersModule module, KClass<?> kClass, kotlinx.serialization.KSerializer<?>[] argSerializers) {
        kotlinx.serialization.KSerializer polymorphicSerializer;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(argSerializers, "argSerializers");
        if (module.getContextual(kClass, ArraysKt.asList(argSerializers)) == null) {
            polymorphicSerializer = new PolymorphicSerializer(kClass);
        }
        return polymorphicSerializer;
    }

    public static final kotlinx.serialization.KSerializer<?> noCompiledSerializer(String forClass) {
        Intrinsics.checkNotNullParameter(forClass, "forClass");
        SerializationException serializationException = new SerializationException(Platform_commonKt.notRegisteredMessage(forClass));
        throw serializationException;
    }

    public static final kotlinx.serialization.KSerializer<?> noCompiledSerializer(SerializersModule module, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        int i = 0;
        kotlinx.serialization.KSerializer contextual$default = SerializersModule.getContextual$default(module, kClass, i, 2, i);
        if (contextual$default == null) {
        } else {
            return contextual$default;
        }
        Platform_commonKt.serializerNotRegistered(kClass);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final kotlinx.serialization.KSerializer<?> noCompiledSerializer(SerializersModule module, KClass<?> kClass, kotlinx.serialization.KSerializer<?>[] argSerializers) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(argSerializers, "argSerializers");
        kotlinx.serialization.KSerializer contextual = module.getContextual(kClass, ArraysKt.asList(argSerializers));
        if (contextual == null) {
        } else {
            return contextual;
        }
        Platform_commonKt.serializerNotRegistered(kClass);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private static final <T> kotlinx.serialization.KSerializer<T> nullable$SerializersKt__SerializersKt(kotlinx.serialization.KSerializer<T> $this$nullable, boolean shouldBeNullable) {
        if (shouldBeNullable) {
            return BuiltinSerializersKt.getNullable($this$nullable);
        }
        Intrinsics.checkNotNull($this$nullable, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return $this$nullable;
    }

    public static final kotlinx.serialization.KSerializer<? extends Object> parametrizedSerializerOrNull(KClass<Object> $this$parametrizedSerializerOrNull, List<? extends kotlinx.serialization.KSerializer<Object>> serializers, Function0<? extends KClassifier> elementClassifierIfArray) {
        kotlinx.serialization.KSerializer builtinParametrizedSerializer$SerializersKt__SerializersKt;
        Intrinsics.checkNotNullParameter($this$parametrizedSerializerOrNull, "<this>");
        Intrinsics.checkNotNullParameter(serializers, "serializers");
        Intrinsics.checkNotNullParameter(elementClassifierIfArray, "elementClassifierIfArray");
        if (SerializersKt__SerializersKt.builtinParametrizedSerializer$SerializersKt__SerializersKt($this$parametrizedSerializerOrNull, serializers, elementClassifierIfArray) == null) {
            builtinParametrizedSerializer$SerializersKt__SerializersKt = SerializersKt__SerializersKt.compiledParametrizedSerializer$SerializersKt__SerializersKt($this$parametrizedSerializerOrNull, serializers);
        }
        return builtinParametrizedSerializer$SerializersKt__SerializersKt;
    }

    public static final <T> kotlinx.serialization.KSerializer<T> serializer() {
        final int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        kotlinx.serialization.KSerializer serializer = SerializersKt.serializer(0);
        int i4 = 0;
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return (KSerializer)serializer;
    }

    @InternalSerializationApi
    public static final <T> kotlinx.serialization.KSerializer<T> serializer(KClass<T> $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        kotlinx.serialization.KSerializer serializerOrNull = SerializersKt.serializerOrNull($this$serializer);
        if (serializerOrNull == null) {
        } else {
            return serializerOrNull;
        }
        Platform_commonKt.serializerNotRegistered($this$serializer);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @ExperimentalSerializationApi
    public static final kotlinx.serialization.KSerializer<Object> serializer(KClass<?> kClass, List<? extends kotlinx.serialization.KSerializer<?>> typeArgumentsSerializers, boolean isNullable) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), kClass, typeArgumentsSerializers, isNullable);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializer(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), type);
    }

    public static final <T> kotlinx.serialization.KSerializer<T> serializer(SerializersModule $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        kotlinx.serialization.KSerializer serializer = SerializersKt.serializer($this$serializer, 0);
        int i4 = 0;
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return (KSerializer)serializer;
    }

    @ExperimentalSerializationApi
    public static final kotlinx.serialization.KSerializer<Object> serializer(SerializersModule $this$serializer, KClass<?> kClass, List<? extends kotlinx.serialization.KSerializer<?>> typeArgumentsSerializers, boolean isNullable) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        kotlinx.serialization.KSerializer serializerByKClassImpl$SerializersKt__SerializersKt = SerializersKt__SerializersKt.serializerByKClassImpl$SerializersKt__SerializersKt($this$serializer, kClass, typeArgumentsSerializers, isNullable);
        if (serializerByKClassImpl$SerializersKt__SerializersKt == null) {
        } else {
            return serializerByKClassImpl$SerializersKt__SerializersKt;
        }
        PlatformKt.platformSpecificSerializerNotRegistered(kClass);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final kotlinx.serialization.KSerializer<Object> serializer(SerializersModule $this$serializer, KType type) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        kotlinx.serialization.KSerializer serializerByKTypeImpl$SerializersKt__SerializersKt = SerializersKt__SerializersKt.serializerByKTypeImpl$SerializersKt__SerializersKt($this$serializer, type, true);
        if (serializerByKTypeImpl$SerializersKt__SerializersKt == null) {
        } else {
            return serializerByKTypeImpl$SerializersKt__SerializersKt;
        }
        PlatformKt.platformSpecificSerializerNotRegistered(Platform_commonKt.kclass(type));
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private static final kotlinx.serialization.KSerializer<Object> serializerByKClassImpl$SerializersKt__SerializersKt(SerializersModule $this$serializerByKClassImpl, KClass<Object> rootClass, List<? extends kotlinx.serialization.KSerializer<Object>> typeArgumentsSerializers, boolean isNullable) {
        kotlinx.serialization.KSerializer parametrizedSerializerOrNull;
        int nullable$SerializersKt__SerializersKt;
        int str;
        nullable$SerializersKt__SerializersKt = 0;
        if (typeArgumentsSerializers.isEmpty()) {
            if (SerializersKt.serializerOrNull(rootClass) == null) {
                parametrizedSerializerOrNull = SerializersModule.getContextual$default($this$serializerByKClassImpl, rootClass, nullable$SerializersKt__SerializersKt, 2, nullable$SerializersKt__SerializersKt);
            }
        } else {
            SerializersKt__SerializersKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SerializersKt__SerializersKt$$ExternalSyntheticLambda0();
            if (SerializersKt.parametrizedSerializerOrNull(rootClass, typeArgumentsSerializers, externalSyntheticLambda0) == null) {
                parametrizedSerializerOrNull = $this$serializerByKClassImpl.getContextual(rootClass, typeArgumentsSerializers);
            }
        }
        if (parametrizedSerializerOrNull != null) {
            str = 0;
            nullable$SerializersKt__SerializersKt = SerializersKt__SerializersKt.nullable$SerializersKt__SerializersKt(parametrizedSerializerOrNull, isNullable);
        }
        return nullable$SerializersKt__SerializersKt;
    }

    private static final KClassifier serializerByKClassImpl$lambda$1$SerializersKt__SerializersKt() {
        SerializationException serializationException = new SerializationException("It is not possible to retrieve an array serializer using KClass alone, use KType instead or ArraySerializer factory");
        throw serializationException;
    }

    private static final kotlinx.serialization.KSerializer<Object> serializerByKTypeImpl$SerializersKt__SerializersKt(SerializersModule $this$serializerByKTypeImpl, KType type, boolean failOnMissingTypeArgSerializer) {
        Object parametrizedCachedSerializer;
        boolean contextual$default;
        List serializersForParameters;
        int nullable$SerializersKt__SerializersKt;
        int failure-impl;
        kotlinx.serialization.KSerializer $this$polymorphicIfInterface$iv;
        Iterator polymorphicSerializer;
        Object next;
        int polymorphicSerializer2;
        KType p0;
        int i;
        int i2;
        final KClass kclass = Platform_commonKt.kclass(type);
        final boolean markedNullable = type.isMarkedNullable();
        List arguments = type.getArguments();
        int i3 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)arguments, 10));
        failure-impl = 0;
        polymorphicSerializer = arguments.iterator();
        for (Object next : polymorphicSerializer) {
            i = 0;
            i2 = 0;
            (Collection)arrayList.add(Platform_commonKt.typeOrThrow((KTypeProjection)next));
        }
        serializersForParameters = 2;
        nullable$SerializersKt__SerializersKt = 0;
        if ((List)arrayList.isEmpty()) {
            if (PlatformKt.isInterface(kclass) && SerializersModule.getContextual$default($this$serializerByKTypeImpl, kclass, nullable$SerializersKt__SerializersKt, serializersForParameters, nullable$SerializersKt__SerializersKt) != null) {
                if (SerializersModule.getContextual$default($this$serializerByKTypeImpl, kclass, nullable$SerializersKt__SerializersKt, serializersForParameters, nullable$SerializersKt__SerializersKt) != null) {
                    parametrizedCachedSerializer = nullable$SerializersKt__SerializersKt;
                } else {
                    parametrizedCachedSerializer = SerializersCacheKt.findCachedSerializer(kclass, markedNullable);
                }
            } else {
            }
        } else {
            if ($this$serializerByKTypeImpl.getHasInterfaceContextualSerializers$kotlinx_serialization_core()) {
                parametrizedCachedSerializer = nullable$SerializersKt__SerializersKt;
            } else {
                if (Result.isFailure-impl(SerializersCacheKt.findParametrizedCachedSerializer(kclass, arrayList, markedNullable))) {
                    parametrizedCachedSerializer = nullable$SerializersKt__SerializersKt;
                }
            }
        }
        if (parametrizedCachedSerializer != 0) {
            return parametrizedCachedSerializer;
        }
        if (arrayList.isEmpty()) {
            if (SerializersKt.serializerOrNull(kclass) == null && SerializersModule.getContextual$default($this$serializerByKTypeImpl, kclass, nullable$SerializersKt__SerializersKt, serializersForParameters, nullable$SerializersKt__SerializersKt) == null) {
                if (SerializersModule.getContextual$default($this$serializerByKTypeImpl, kclass, nullable$SerializersKt__SerializersKt, serializersForParameters, nullable$SerializersKt__SerializersKt) == null) {
                    serializersForParameters = kclass;
                    int i6 = 0;
                    if (PlatformKt.isInterface(serializersForParameters)) {
                        polymorphicSerializer = new PolymorphicSerializer(serializersForParameters);
                    } else {
                        polymorphicSerializer = nullable$SerializersKt__SerializersKt;
                    }
                    $this$polymorphicIfInterface$iv = polymorphicSerializer;
                }
            }
        } else {
            serializersForParameters = SerializersKt.serializersForParameters($this$serializerByKTypeImpl, arrayList, failOnMissingTypeArgSerializer);
            if (serializersForParameters == null) {
                return nullable$SerializersKt__SerializersKt;
            }
            SerializersKt__SerializersKt$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new SerializersKt__SerializersKt$$ExternalSyntheticLambda1(arrayList);
            if (SerializersKt.parametrizedSerializerOrNull(kclass, serializersForParameters, externalSyntheticLambda1) == null && $this$serializerByKTypeImpl.getContextual(kclass, serializersForParameters) == null) {
                if ($this$serializerByKTypeImpl.getContextual(kclass, serializersForParameters) == null) {
                    KClass cls = kclass;
                    polymorphicSerializer = 0;
                    if (PlatformKt.isInterface(cls)) {
                        polymorphicSerializer2 = new PolymorphicSerializer(cls);
                    } else {
                        polymorphicSerializer2 = nullable$SerializersKt__SerializersKt;
                    }
                    $this$polymorphicIfInterface$iv = polymorphicSerializer2;
                }
            }
        }
        if ($this$polymorphicIfInterface$iv != null) {
            int i5 = 0;
            nullable$SerializersKt__SerializersKt = SerializersKt__SerializersKt.nullable$SerializersKt__SerializersKt($this$polymorphicIfInterface$iv, markedNullable);
        }
        return nullable$SerializersKt__SerializersKt;
    }

    private static final KClassifier serializerByKTypeImpl$lambda$0$SerializersKt__SerializersKt(List $typeArguments) {
        return (KType)$typeArguments.get(0).getClassifier();
    }

    @InternalSerializationApi
    public static final <T> kotlinx.serialization.KSerializer<T> serializerOrNull(KClass<T> $this$serializerOrNull) {
        kotlinx.serialization.KSerializer compiledSerializerImpl;
        Intrinsics.checkNotNullParameter($this$serializerOrNull, "<this>");
        if (PlatformKt.compiledSerializerImpl($this$serializerOrNull) == null) {
            compiledSerializerImpl = PrimitivesKt.builtinSerializerOrNull($this$serializerOrNull);
        }
        return compiledSerializerImpl;
    }

    public static final kotlinx.serialization.KSerializer<Object> serializerOrNull(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializerOrNull(SerializersModuleBuildersKt.EmptySerializersModule(), type);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializerOrNull(SerializersModule $this$serializerOrNull, KType type) {
        Intrinsics.checkNotNullParameter($this$serializerOrNull, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt__SerializersKt.serializerByKTypeImpl$SerializersKt__SerializersKt($this$serializerOrNull, type, false);
    }

    public static final List<kotlinx.serialization.KSerializer<Object>> serializersForParameters(SerializersModule $this$serializersForParameters, List<? extends KType> typeArguments, boolean failOnMissingTypeArgSerializer) {
        ArrayList list;
        Object obj2;
        int i2;
        Object obj;
        int i;
        Iterator iterator;
        boolean next2;
        Object next;
        Object it;
        int i3;
        kotlinx.serialization.KSerializer serializerOrNull;
        Intrinsics.checkNotNullParameter($this$serializersForParameters, "<this>");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        int i4 = 10;
        if (failOnMissingTypeArgSerializer) {
            obj2 = typeArguments;
            i2 = 0;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)obj2, i4));
            i = 0;
            iterator = obj2.iterator();
            for (Object next : iterator) {
                i3 = 0;
                (Collection)arrayList2.add(SerializersKt.serializer($this$serializersForParameters, (KType)next));
            }
        } else {
            obj2 = typeArguments;
            i2 = 0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)obj2, i4));
            i = 0;
            iterator = obj2.iterator();
            for (Object next : iterator) {
                i3 = 0;
                serializerOrNull = SerializersKt.serializerOrNull($this$serializersForParameters, (KType)next);
                (Collection)arrayList.add(serializerOrNull);
            }
        }
        return list;
    }
}
