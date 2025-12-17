package kotlinx.serialization;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.modules.SerializersModule;

/* loaded from: classes5.dex */
@Metadata(d1 = {"kotlinx/serialization/SerializersKt__SerializersJvmKt", "kotlinx/serialization/SerializersKt__SerializersKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class SerializersKt {
    public static final kotlinx.serialization.KSerializer<?> moduleThenPolymorphic(SerializersModule module, KClass<?> kClass) {
        return SerializersKt__SerializersKt.moduleThenPolymorphic(module, kClass);
    }

    public static final kotlinx.serialization.KSerializer<?> moduleThenPolymorphic(SerializersModule module, KClass<?> kClass, kotlinx.serialization.KSerializer<?>[] argSerializers) {
        return SerializersKt__SerializersKt.moduleThenPolymorphic(module, kClass, argSerializers);
    }

    public static final kotlinx.serialization.KSerializer<?> noCompiledSerializer(String forClass) {
        return SerializersKt__SerializersKt.noCompiledSerializer(forClass);
    }

    public static final kotlinx.serialization.KSerializer<?> noCompiledSerializer(SerializersModule module, KClass<?> kClass) {
        return SerializersKt__SerializersKt.noCompiledSerializer(module, kClass);
    }

    public static final kotlinx.serialization.KSerializer<?> noCompiledSerializer(SerializersModule module, KClass<?> kClass, kotlinx.serialization.KSerializer<?>[] argSerializers) {
        return SerializersKt__SerializersKt.noCompiledSerializer(module, kClass, argSerializers);
    }

    public static final kotlinx.serialization.KSerializer<? extends Object> parametrizedSerializerOrNull(KClass<Object> $this$parametrizedSerializerOrNull, List<? extends kotlinx.serialization.KSerializer<Object>> serializers, Function0<? extends KClassifier> elementClassifierIfArray) {
        return SerializersKt__SerializersKt.parametrizedSerializerOrNull($this$parametrizedSerializerOrNull, serializers, elementClassifierIfArray);
    }

    public static final <T> kotlinx.serialization.KSerializer<T> serializer() {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return SerializersKt.serializer(0);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializer(Type type) {
        return SerializersKt__SerializersJvmKt.serializer(type);
    }

    @InternalSerializationApi
    public static final <T> kotlinx.serialization.KSerializer<T> serializer(KClass<T> $this$serializer) {
        return SerializersKt__SerializersKt.serializer($this$serializer);
    }

    @ExperimentalSerializationApi
    public static final kotlinx.serialization.KSerializer<Object> serializer(KClass<?> kClass, List<? extends kotlinx.serialization.KSerializer<?>> typeArgumentsSerializers, boolean isNullable) {
        return SerializersKt__SerializersKt.serializer(kClass, typeArgumentsSerializers, isNullable);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializer(KType type) {
        return SerializersKt__SerializersKt.serializer(type);
    }

    public static final <T> kotlinx.serialization.KSerializer<T> serializer(SerializersModule $this$serializer) {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SerializersKt.serializer($this$serializer, 0);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializer(SerializersModule $this$serializer, Type type) {
        return SerializersKt__SerializersJvmKt.serializer($this$serializer, type);
    }

    @ExperimentalSerializationApi
    public static final kotlinx.serialization.KSerializer<Object> serializer(SerializersModule $this$serializer, KClass<?> kClass, List<? extends kotlinx.serialization.KSerializer<?>> typeArgumentsSerializers, boolean isNullable) {
        return SerializersKt__SerializersKt.serializer($this$serializer, kClass, typeArgumentsSerializers, isNullable);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializer(SerializersModule $this$serializer, KType type) {
        return SerializersKt__SerializersKt.serializer($this$serializer, type);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializerOrNull(Type type) {
        return SerializersKt__SerializersJvmKt.serializerOrNull(type);
    }

    @InternalSerializationApi
    public static final <T> kotlinx.serialization.KSerializer<T> serializerOrNull(KClass<T> $this$serializerOrNull) {
        return SerializersKt__SerializersKt.serializerOrNull($this$serializerOrNull);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializerOrNull(KType type) {
        return SerializersKt__SerializersKt.serializerOrNull(type);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializerOrNull(SerializersModule $this$serializerOrNull, Type type) {
        return SerializersKt__SerializersJvmKt.serializerOrNull($this$serializerOrNull, type);
    }

    public static final kotlinx.serialization.KSerializer<Object> serializerOrNull(SerializersModule $this$serializerOrNull, KType type) {
        return SerializersKt__SerializersKt.serializerOrNull($this$serializerOrNull, type);
    }

    public static final List<kotlinx.serialization.KSerializer<Object>> serializersForParameters(SerializersModule $this$serializersForParameters, List<? extends KType> typeArguments, boolean failOnMissingTypeArgSerializer) {
        return SerializersKt__SerializersKt.serializersForParameters($this$serializersForParameters, typeArguments, failOnMissingTypeArgSerializer);
    }
}
