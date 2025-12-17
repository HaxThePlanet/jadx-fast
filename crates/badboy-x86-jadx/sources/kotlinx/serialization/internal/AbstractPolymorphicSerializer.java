package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\t\u0008\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0002\u0010\u0017J\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\u00162\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J%\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u001dR\u0018\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u001e", d2 = {"Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "<init>", "()V", "baseClass", "Lkotlin/reflect/KClass;", "getBaseClass", "()Lkotlin/reflect/KClass;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "decodeSequentially", "compositeDecoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "(Lkotlinx/serialization/encoding/CompositeDecoder;)Ljava/lang/Object;", "findPolymorphicSerializerOrNull", "Lkotlinx/serialization/DeserializationStrategy;", "klassName", "", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalSerializationApi
public abstract class AbstractPolymorphicSerializer<T>  implements KSerializer<T> {
    public static final Object access$decodeSequentially(kotlinx.serialization.internal.AbstractPolymorphicSerializer $this, CompositeDecoder compositeDecoder) {
        return $this.decodeSequentially(compositeDecoder);
    }

    private final T decodeSequentially(CompositeDecoder compositeDecoder) {
        return CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, getDescriptor(), 1, PolymorphicSerializerKt.findPolymorphicSerializer(this, compositeDecoder, compositeDecoder.decodeStringElement(getDescriptor(), 0)), 0, 8, 0);
    }

    public final T deserialize(Decoder decoder) {
        int decodeStringElement;
        Object obj;
        boolean decodeSequentially;
        DeserializationStrategy polymorphicSerializer;
        int i3;
        Object element;
        int i2;
        int i;
        int value;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        final int i4 = 0;
        final CompositeDecoder beginStructure = decoder.beginStructure(descriptor);
        final CompositeDecoder compositeDecoder = beginStructure;
        final int i7 = 0;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = objectRef;
        if (compositeDecoder.decodeSequentially()) {
            obj = AbstractPolymorphicSerializer.access$decodeSequentially(this, compositeDecoder);
            beginStructure.endStructure(descriptor);
            return obj;
        } else {
            value = decodeStringElement;
            while (/* condition */) {
                objectRef2.element = compositeDecoder.decodeStringElement(getDescriptor(), decodeSequentially);
                decodeSequentially = compositeDecoder.decodeElementIndex(getDescriptor());
                Object element2 = objectRef2.element;
                objectRef2.element = element2;
                value = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, getDescriptor(), decodeSequentially, PolymorphicSerializerKt.findPolymorphicSerializer(this, compositeDecoder, (String)objectRef2.element), 0, 8, 0);
            }
            if (value == null) {
            } else {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer");
                obj = value;
            }
            int i6 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder.append("Polymorphic value has not been read for class ").append((String)objectRef2.element).toString().toString());
            throw illegalArgumentException2;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if ((String)objectRef2.element != null) {
        } else {
            element = "unknown class";
        }
        SerializationException serializationException = new SerializationException(stringBuilder2.append("Invalid index in polymorphic deserialization of ").append(element).append("\n Expected 0, 1 or DECODE_DONE(-1), but found ").append(decodeSequentially).toString());
        throw serializationException;
    }

    @InternalSerializationApi
    public DeserializationStrategy<T> findPolymorphicSerializerOrNull(CompositeDecoder decoder, String klassName) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return decoder.getSerializersModule().getPolymorphic(getBaseClass(), klassName);
    }

    @InternalSerializationApi
    public SerializationStrategy<T> findPolymorphicSerializerOrNull(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        return encoder.getSerializersModule().getPolymorphic(getBaseClass(), value);
    }

    public abstract KClass<T> getBaseClass();

    public final void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializationStrategy polymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(this, encoder, value);
        final SerialDescriptor descriptor = getDescriptor();
        final int i = 0;
        final CompositeEncoder beginStructure = encoder.beginStructure(descriptor);
        final CompositeEncoder compositeEncoder = beginStructure;
        final int i2 = 0;
        compositeEncoder.encodeStringElement(getDescriptor(), 0, polymorphicSerializer.getDescriptor().getSerialName());
        SerializationStrategy serializationStrategy = polymorphicSerializer;
        int i4 = 0;
        Intrinsics.checkNotNull(serializationStrategy, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        compositeEncoder.encodeSerializableElement(getDescriptor(), 1, serializationStrategy, value);
        beginStructure.endStructure(descriptor);
    }
}
