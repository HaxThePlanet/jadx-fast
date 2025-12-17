package kotlinx.serialization;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginHelperInterfacesKt;
import kotlinx.serialization.modules.SerializersModule;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B7\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\u0012\u0010\u0010\u0007\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u0008¢\u0006\u0004\u0008\t\u0010\nB\u0017\u0008\u0016\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\u0008\t\u0010\u000bJ\u0016\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0016¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u001e", d2 = {"Lkotlinx/serialization/ContextualSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serializableClass", "Lkotlin/reflect/KClass;", "fallbackSerializer", "typeArgumentsSerializers", "", "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;[Lkotlinx/serialization/KSerializer;)V", "(Lkotlin/reflect/KClass;)V", "", "serializer", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ExperimentalSerializationApi
public final class ContextualSerializer<T>  implements kotlinx.serialization.KSerializer<T> {

    private final SerialDescriptor descriptor;
    private final kotlinx.serialization.KSerializer<T> fallbackSerializer;
    private final KClass<T> serializableClass;
    private final List<kotlinx.serialization.KSerializer<?>> typeArgumentsSerializers;
    public static Unit $r8$lambda$Hes48jZtrTGJGDwWLsPXnVZQ9dM(kotlinx.serialization.ContextualSerializer contextualSerializer, ClassSerialDescriptorBuilder classSerialDescriptorBuilder2) {
        return ContextualSerializer.descriptor$lambda$0(contextualSerializer, classSerialDescriptorBuilder2);
    }

    public ContextualSerializer(KClass<T> serializableClass) {
        Intrinsics.checkNotNullParameter(serializableClass, "serializableClass");
        super(serializableClass, 0, PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY);
    }

    public ContextualSerializer(KClass<T> serializableClass, kotlinx.serialization.KSerializer<T> fallbackSerializer, kotlinx.serialization.KSerializer<?>[] typeArgumentsSerializers) {
        Intrinsics.checkNotNullParameter(serializableClass, "serializableClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        super();
        this.serializableClass = serializableClass;
        this.fallbackSerializer = fallbackSerializer;
        this.typeArgumentsSerializers = ArraysKt.asList(typeArgumentsSerializers);
        ContextualSerializer$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ContextualSerializer$$ExternalSyntheticLambda0(this);
        this.descriptor = ContextAwareKt.withContext(SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.ContextualSerializer", (SerialKind)SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], externalSyntheticLambda0), this.serializableClass);
    }

    private static final Unit descriptor$lambda$0(kotlinx.serialization.ContextualSerializer this$0, ClassSerialDescriptorBuilder $this$buildSerialDescriptor) {
        Object fallbackSerializer;
        int emptyList;
        Intrinsics.checkNotNullParameter($this$buildSerialDescriptor, "$this$buildSerialDescriptor");
        fallbackSerializer = this$0.fallbackSerializer;
        fallbackSerializer = fallbackSerializer.getDescriptor();
        if (fallbackSerializer != null && fallbackSerializer != null) {
            fallbackSerializer = fallbackSerializer.getDescriptor();
            if (fallbackSerializer != null) {
                emptyList = fallbackSerializer.getAnnotations();
            } else {
                emptyList = 0;
            }
        } else {
        }
        if (emptyList == null) {
            emptyList = CollectionsKt.emptyList();
        }
        $this$buildSerialDescriptor.setAnnotations(emptyList);
        return Unit.INSTANCE;
    }

    private final kotlinx.serialization.KSerializer<T> serializer(SerializersModule serializersModule) {
        kotlinx.serialization.KSerializer fallbackSerializer;
        if (serializersModule.getContextual(this.serializableClass, this.typeArgumentsSerializers) == null) {
            if (this.fallbackSerializer == null) {
            } else {
            }
            Platform_commonKt.serializerNotRegistered(this.serializableClass);
            KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
        return fallbackSerializer;
    }

    public T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return decoder.decodeSerializableValue((DeserializationStrategy)serializer(decoder.getSerializersModule()));
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeSerializableValue((SerializationStrategy)serializer(encoder.getSerializersModule()), value);
    }
}
