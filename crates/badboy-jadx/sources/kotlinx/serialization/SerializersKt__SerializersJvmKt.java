package kotlinx.serialization;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0018\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004\u001a+\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0002¢\u0006\u0002\u0008\n\u001a-\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u000c2\u0006\u0010\u0008\u001a\u00020\tH\u0002¢\u0006\u0002\u0008\r\u001aG\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u0001\"\u0008\u0008\u0000\u0010\u000f*\u00020\u0002*\u00020\u00062\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u000c2\u0014\u0010\u0011\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0012H\u0002¢\u0006\u0002\u0008\u0013\u001a)\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0008\u001a\u00020\tH\u0002¢\u0006\u0002\u0008\u0016\u001a\u0015\u0010\u0017\u001a\u0006\u0012\u0002\u0008\u00030\u000c*\u00020\u0004H\u0002¢\u0006\u0002\u0008\u0018¨\u0006\u0019", d2 = {"serializer", "Lkotlinx/serialization/KSerializer;", "", "type", "Ljava/lang/reflect/Type;", "serializerOrNull", "Lkotlinx/serialization/modules/SerializersModule;", "serializerByJavaTypeImpl", "failOnMissingTypeArgSerializer", "", "serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt", "typeSerializer", "Ljava/lang/Class;", "typeSerializer$SerializersKt__SerializersJvmKt", "reflectiveOrContextual", "T", "jClass", "typeArgumentsSerializers", "", "reflectiveOrContextual$SerializersKt__SerializersJvmKt", "genericArraySerializer", "Ljava/lang/reflect/GenericArrayType;", "genericArraySerializer$SerializersKt__SerializersJvmKt", "prettyClass", "prettyClass$SerializersKt__SerializersJvmKt", "kotlinx-serialization-core"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "kotlinx/serialization/SerializersKt")
final class SerializersKt__SerializersJvmKt {
    private static final kotlinx.serialization.KSerializer<Object> genericArraySerializer$SerializersKt__SerializersJvmKt(SerializersModule $this$genericArraySerializer, GenericArrayType type, boolean failOnMissingTypeArgSerializer) {
        kotlinx.serialization.KSerializer serializerOrNull;
        Object kotlinClass;
        Object first;
        String str;
        Type genericComponentType = type.getGenericComponentType();
        int i2 = 0;
        if (genericComponentType instanceof WildcardType) {
            Type[] upperBounds = (WildcardType)genericComponentType.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            first = ArraysKt.first((Object[])upperBounds);
        } else {
            first = genericComponentType;
        }
        Intrinsics.checkNotNull(first);
        if (failOnMissingTypeArgSerializer) {
            serializerOrNull = SerializersKt.serializer($this$genericArraySerializer, first);
        } else {
            if (SerializersKt.serializerOrNull($this$genericArraySerializer, first) == null) {
                return 0;
            }
        }
        if (first instanceof ParameterizedType) {
            Type rawType = (ParameterizedType)first.getRawType();
            Intrinsics.checkNotNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            kotlinClass = JvmClassMappingKt.getKotlinClass((Class)rawType);
            Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            kotlinx.serialization.KSerializer kSerializer = BuiltinSerializersKt.ArraySerializer(kotlinClass, serializerOrNull);
            Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return kSerializer;
        } else {
            if (!first instanceof KClass) {
            } else {
                kotlinClass = first;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException kclass = new IllegalStateException(stringBuilder.append("unsupported type in GenericArray: ").append(Reflection.getOrCreateKotlinClass(first.getClass())).toString());
        throw kclass;
    }

    private static final Class<?> prettyClass$SerializersKt__SerializersJvmKt(Type $this$prettyClass) {
        Object prettyClass$SerializersKt__SerializersJvmKt;
        String str;
        final Object obj = $this$prettyClass;
        if (obj instanceof Class) {
            prettyClass$SerializersKt__SerializersJvmKt = obj;
            return prettyClass$SerializersKt__SerializersJvmKt;
        } else {
            if (obj instanceof ParameterizedType) {
                Type rawType = (ParameterizedType)obj.getRawType();
                Intrinsics.checkNotNullExpressionValue(rawType, "getRawType(...)");
                prettyClass$SerializersKt__SerializersJvmKt = SerializersKt__SerializersJvmKt.prettyClass$SerializersKt__SerializersJvmKt(rawType);
            } else {
                if (obj instanceof WildcardType) {
                    Type[] upperBounds = (WildcardType)obj.getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                    Object first = ArraysKt.first((Object[])upperBounds);
                    Intrinsics.checkNotNullExpressionValue(first, "first(...)");
                    prettyClass$SerializersKt__SerializersJvmKt = SerializersKt__SerializersJvmKt.prettyClass$SerializersKt__SerializersJvmKt((Type)first);
                } else {
                    if (!obj instanceof GenericArrayType) {
                    } else {
                        Type genericComponentType = (GenericArrayType)obj.getGenericComponentType();
                        Intrinsics.checkNotNullExpressionValue(genericComponentType, "getGenericComponentType(...)");
                        prettyClass$SerializersKt__SerializersJvmKt = SerializersKt__SerializersJvmKt.prettyClass$SerializersKt__SerializersJvmKt(genericComponentType);
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument ").append(obj).append(" has type ").append(Reflection.getOrCreateKotlinClass(obj.getClass())).toString());
        throw illegalArgumentException;
    }

    private static final <T> kotlinx.serialization.KSerializer<T> reflectiveOrContextual$SerializersKt__SerializersJvmKt(SerializersModule $this$reflectiveOrContextual, Class<T> jClass, List<? extends kotlinx.serialization.KSerializer<Object>> typeArgumentsSerializers) {
        kotlinx.serialization.KSerializer builtinSerializerOrNull;
        Object kotlinClass;
        int i = 0;
        Object[] $this$toTypedArray$iv = (Collection)typeArgumentsSerializers.toArray(new KSerializer[0]);
        kotlinx.serialization.KSerializer constructSerializerForGivenTypeArgs = PlatformKt.constructSerializerForGivenTypeArgs(jClass, (KSerializer[])Arrays.copyOf((KSerializer[])$this$toTypedArray$iv, $this$toTypedArray$iv.length));
        if (constructSerializerForGivenTypeArgs != null) {
            int i2 = 0;
            return constructSerializerForGivenTypeArgs;
        }
        kotlin.reflect.KClass kotlinClass2 = JvmClassMappingKt.getKotlinClass(jClass);
        if (PrimitivesKt.builtinSerializerOrNull(kotlinClass2) == null && $this$reflectiveOrContextual.getContextual(kotlinClass2, typeArgumentsSerializers) == null) {
            if ($this$reflectiveOrContextual.getContextual(kotlinClass2, typeArgumentsSerializers) == null) {
                if (jClass.isInterface()) {
                    builtinSerializerOrNull = new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(jClass));
                } else {
                    builtinSerializerOrNull = 0;
                }
            }
        }
        return builtinSerializerOrNull;
    }

    public static final kotlinx.serialization.KSerializer<Object> serializer(Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), type);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializer(SerializersModule $this$serializer, Type type) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        kotlinx.serialization.KSerializer serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt = SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt($this$serializer, type, true);
        if (serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt == null) {
        } else {
            return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt;
        }
        PlatformKt.serializerNotRegistered(SerializersKt__SerializersJvmKt.prettyClass$SerializersKt__SerializersJvmKt(type));
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private static final kotlinx.serialization.KSerializer<Object> serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(SerializersModule $this$serializerByJavaTypeImpl, Type type, boolean failOnMissingTypeArgSerializer) {
        kotlinx.serialization.KSerializer rootClass;
        int i3;
        Type[] objArr;
        boolean assignableFrom;
        Object serializerOrNull;
        int arrayList;
        Type[] actualTypeArguments;
        int i;
        ArrayList $i$f$map;
        Type[] arrayList2;
        int iterator;
        int length;
        int length2;
        int i5;
        kotlinx.serialization.KSerializer it;
        int i4;
        int i2;
        int i6;
        final SerializersModule serializersModule = $this$serializerByJavaTypeImpl;
        final Object obj = type;
        final boolean z = failOnMissingTypeArgSerializer;
        if (obj instanceof GenericArrayType) {
            rootClass = SerializersKt__SerializersJvmKt.genericArraySerializer$SerializersKt__SerializersJvmKt(serializersModule, (GenericArrayType)obj, z);
            return rootClass;
        } else {
            if (obj instanceof Class) {
                rootClass = SerializersKt__SerializersJvmKt.typeSerializer$SerializersKt__SerializersJvmKt(serializersModule, (Class)obj, z);
            } else {
                arrayList = 0;
                if (obj instanceof ParameterizedType) {
                    Type rawType = (ParameterizedType)obj.getRawType();
                    Intrinsics.checkNotNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
                    actualTypeArguments = (ParameterizedType)obj.getActualTypeArguments();
                    Intrinsics.checkNotNull(actualTypeArguments);
                    if (z) {
                        objArr = actualTypeArguments;
                        i = 0;
                        $i$f$map = new ArrayList(objArr.length);
                        arrayList2 = objArr;
                        iterator = 0;
                        length2 = arrayList;
                        while (length2 < arrayList2.length) {
                            Type type2 = i5;
                            i4 = 0;
                            Intrinsics.checkNotNull(type2);
                            (Collection)$i$f$map.add(SerializersKt.serializer(serializersModule, type2));
                            length2++;
                        }
                    } else {
                        i = actualTypeArguments;
                        int i9 = 0;
                        arrayList2 = new ArrayList(i.length);
                        iterator = i;
                        length = 0;
                        i5 = arrayList;
                        while (i5 < iterator.length) {
                            i4 = it;
                            i2 = 0;
                            Intrinsics.checkNotNull(i4);
                            serializerOrNull = SerializersKt.serializerOrNull(serializersModule, i4);
                            (Collection)arrayList2.add(serializerOrNull);
                            i5++;
                        }
                        $i$f$map = objArr;
                    }
                    serializerOrNull = "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>";
                    if (Set.class.isAssignableFrom((Class)rawType)) {
                        i3 = BuiltinSerializersKt.SetSerializer((KSerializer)$i$f$map.get(arrayList));
                        Intrinsics.checkNotNull(i3, serializerOrNull);
                        rootClass = i3;
                    } else {
                        if (!List.class.isAssignableFrom(rawType)) {
                            if (Collection.class.isAssignableFrom(rawType)) {
                                i3 = BuiltinSerializersKt.ListSerializer((KSerializer)$i$f$map.get(arrayList));
                                Intrinsics.checkNotNull(i3, serializerOrNull);
                                rootClass = i3;
                            } else {
                                i = 1;
                                if (Map.class.isAssignableFrom(rawType)) {
                                    i3 = BuiltinSerializersKt.MapSerializer((KSerializer)$i$f$map.get(arrayList), (KSerializer)$i$f$map.get(i));
                                    Intrinsics.checkNotNull(i3, serializerOrNull);
                                    rootClass = i3;
                                } else {
                                    if (Map.Entry.class.isAssignableFrom(rawType)) {
                                        i3 = BuiltinSerializersKt.MapEntrySerializer((KSerializer)$i$f$map.get(arrayList), (KSerializer)$i$f$map.get(i));
                                        Intrinsics.checkNotNull(i3, serializerOrNull);
                                        rootClass = i3;
                                    } else {
                                        if (Pair.class.isAssignableFrom(rawType)) {
                                            i3 = BuiltinSerializersKt.PairSerializer((KSerializer)$i$f$map.get(arrayList), (KSerializer)$i$f$map.get(i));
                                            Intrinsics.checkNotNull(i3, serializerOrNull);
                                            rootClass = i3;
                                        } else {
                                            if (Triple.class.isAssignableFrom(rawType)) {
                                                i3 = BuiltinSerializersKt.TripleSerializer((KSerializer)$i$f$map.get(arrayList), (KSerializer)$i$f$map.get(i), (KSerializer)$i$f$map.get(2));
                                                Intrinsics.checkNotNull(i3, serializerOrNull);
                                                rootClass = i3;
                                            } else {
                                                i3 = $i$f$map;
                                                serializerOrNull = 0;
                                                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)i3, 10));
                                                arrayList2 = 0;
                                                iterator = i3.iterator();
                                                for (Object length : iterator) {
                                                    length2 = length;
                                                    i5 = 0;
                                                    Intrinsics.checkNotNull((KSerializer)length2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
                                                    (Collection)arrayList.add(length2);
                                                }
                                                rootClass = SerializersKt__SerializersJvmKt.reflectiveOrContextual$SerializersKt__SerializersJvmKt(serializersModule, rawType, (List)arrayList);
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                        }
                    }
                } else {
                    if (!obj instanceof WildcardType) {
                    } else {
                        Type[] upperBounds = (WildcardType)obj.getUpperBounds();
                        Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                        Object first = ArraysKt.first((Object[])upperBounds);
                        Intrinsics.checkNotNullExpressionValue(first, "first(...)");
                        rootClass = SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt$default(serializersModule, (Type)first, arrayList, 2, 0);
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument ").append(obj).append(" has type ").append(Reflection.getOrCreateKotlinClass(obj.getClass())).toString());
        throw illegalArgumentException;
    }

    static kotlinx.serialization.KSerializer serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt$default(SerializersModule serializersModule, Type type2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 1;
        }
        return SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule, type2, obj2);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializerOrNull(Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializerOrNull(SerializersModuleBuildersKt.EmptySerializersModule(), type);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializerOrNull(SerializersModule $this$serializerOrNull, Type type) {
        Intrinsics.checkNotNullParameter($this$serializerOrNull, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt($this$serializerOrNull, type, false);
    }

    private static final kotlinx.serialization.KSerializer<Object> typeSerializer$SerializersKt__SerializersJvmKt(SerializersModule $this$typeSerializer, Class<?> type, boolean failOnMissingTypeArgSerializer) {
        boolean primitive;
        Object componentType;
        kotlinx.serialization.KSerializer serializerOrNull;
        kotlinx.serialization.KSerializer reflectiveOrContextual$SerializersKt__SerializersJvmKt;
        String str;
        if (type.isArray() && !type.getComponentType().isPrimitive()) {
            if (!type.getComponentType().isPrimitive()) {
                componentType = type.getComponentType();
                Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType(...)");
                Class cls = componentType;
                if (failOnMissingTypeArgSerializer) {
                    serializerOrNull = SerializersKt.serializer($this$typeSerializer, (Type)cls);
                } else {
                    if (SerializersKt.serializerOrNull($this$typeSerializer, cls) == null) {
                        return 0;
                    }
                }
                kotlin.reflect.KClass kotlinClass = JvmClassMappingKt.getKotlinClass(componentType);
                Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.checkNotNull(BuiltinSerializersKt.ArraySerializer(kotlinClass, serializerOrNull), "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            } else {
                Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
                reflectiveOrContextual$SerializersKt__SerializersJvmKt = SerializersKt__SerializersJvmKt.reflectiveOrContextual$SerializersKt__SerializersJvmKt($this$typeSerializer, type, CollectionsKt.emptyList());
            }
        } else {
        }
        return reflectiveOrContextual$SerializersKt__SerializersJvmKt;
    }
}
