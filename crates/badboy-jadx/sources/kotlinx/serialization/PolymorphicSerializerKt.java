package kotlinx.serialization;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.AbstractPolymorphicSerializerKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a4\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0007\u001a7\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\t\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e", d2 = {"findPolymorphicSerializer", "Lkotlinx/serialization/DeserializationStrategy;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "klassName", "", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PolymorphicSerializerKt {
    @InternalSerializationApi
    public static final <T> kotlinx.serialization.DeserializationStrategy<T> findPolymorphicSerializer(AbstractPolymorphicSerializer<T> $this$findPolymorphicSerializer, CompositeDecoder decoder, String klassName) {
        Intrinsics.checkNotNullParameter($this$findPolymorphicSerializer, "<this>");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        kotlinx.serialization.DeserializationStrategy polymorphicSerializerOrNull = $this$findPolymorphicSerializer.findPolymorphicSerializerOrNull(decoder, klassName);
        if (polymorphicSerializerOrNull == null) {
        } else {
            return polymorphicSerializerOrNull;
        }
        AbstractPolymorphicSerializerKt.throwSubtypeNotRegistered(klassName, $this$findPolymorphicSerializer.getBaseClass());
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @InternalSerializationApi
    public static final <T> kotlinx.serialization.SerializationStrategy<T> findPolymorphicSerializer(AbstractPolymorphicSerializer<T> $this$findPolymorphicSerializer, Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter($this$findPolymorphicSerializer, "<this>");
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        kotlinx.serialization.SerializationStrategy polymorphicSerializerOrNull = $this$findPolymorphicSerializer.findPolymorphicSerializerOrNull(encoder, value);
        if (polymorphicSerializerOrNull == null) {
        } else {
            return polymorphicSerializerOrNull;
        }
        AbstractPolymorphicSerializerKt.throwSubtypeNotRegistered(Reflection.getOrCreateKotlinClass(value.getClass()), $this$findPolymorphicSerializer.getBaseClass());
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }
}
