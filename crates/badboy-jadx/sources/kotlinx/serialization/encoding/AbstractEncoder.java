package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.NoOpEncoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000c\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rH\u0016J\u0010\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010%\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bJ\u001e\u0010&\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0014J\u001e\u0010'\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0016J\u001e\u0010(\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u001e\u0010)\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0019J\u001e\u0010*\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001bJ\u001e\u0010+\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001dJ\u001e\u0010,\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001fJ\u001e\u0010-\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020!J\u0016\u0010.\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rJ?\u0010/\u001a\u00020\t\"\n\u0008\u0000\u00100*\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u000c\u00101\u001a\u0008\u0012\u0004\u0012\u0002H0022\u0006\u0010\u000f\u001a\u0002H0H\u0016¢\u0006\u0002\u00103J?\u00104\u001a\u00020\t\"\u0008\u0008\u0000\u00100*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\r2\u000c\u00101\u001a\u0008\u0012\u0004\u0012\u0002H0022\u0008\u0010\u000f\u001a\u0004\u0018\u0001H0H\u0016¢\u0006\u0002\u00103¨\u00065", d2 = {"Lkotlinx/serialization/encoding/AbstractEncoder;", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "<init>", "()V", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "endStructure", "", "encodeElement", "", "index", "", "encodeValue", "value", "", "encodeNull", "encodeBoolean", "encodeByte", "", "encodeShort", "", "encodeInt", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeChar", "", "encodeString", "", "encodeEnum", "enumDescriptor", "encodeInline", "encodeBooleanElement", "encodeByteElement", "encodeShortElement", "encodeIntElement", "encodeLongElement", "encodeFloatElement", "encodeDoubleElement", "encodeCharElement", "encodeStringElement", "encodeInlineElement", "encodeSerializableElement", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ExperimentalSerializationApi
public abstract class AbstractEncoder implements kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder {
    @Override // kotlinx.serialization.encoding.Encoder
    public kotlinx.serialization.encoding.CompositeEncoder beginCollection(SerialDescriptor descriptor, int collectionSize) {
        return Encoder.DefaultImpls.beginCollection(this, descriptor, collectionSize);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public kotlinx.serialization.encoding.CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return (CompositeEncoder)this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean value) {
        encodeValue(Boolean.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeBooleanElement(SerialDescriptor descriptor, int index, boolean value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeBoolean(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte value) {
        encodeValue(Byte.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeByteElement(SerialDescriptor descriptor, int index, byte value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeByte(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeChar(char value) {
        encodeValue(Character.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeCharElement(SerialDescriptor descriptor, int index, char value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeChar(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double value) {
        encodeValue(Double.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeDoubleElement(SerialDescriptor descriptor, int index, double value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeDouble(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public boolean encodeElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return 1;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeEnum(SerialDescriptor enumDescriptor, int index) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeValue(Integer.valueOf(index));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float value) {
        encodeValue(Float.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeFloatElement(SerialDescriptor descriptor, int index, float value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeFloat(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public kotlinx.serialization.encoding.Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return (Encoder)this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final kotlinx.serialization.encoding.Encoder encodeInlineElement(SerialDescriptor descriptor, int index) {
        kotlinx.serialization.encoding.Encoder encodeInline;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeInline = encodeInline(descriptor.getElementDescriptor(index));
        } else {
            encodeInline = NoOpEncoder.INSTANCE;
        }
        return encodeInline;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeInt(int value) {
        encodeValue(Integer.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeIntElement(SerialDescriptor descriptor, int index, int value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeInt(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeLong(long value) {
        encodeValue(Long.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeLongElement(SerialDescriptor descriptor, int index, long value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeLong(value);
        }
    }

    @ExperimentalSerializationApi
    public void encodeNotNullMark() {
        Encoder.DefaultImpls.encodeNotNullMark(this);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        SerializationException serializationException = new SerializationException("'null' is not supported by default");
        throw serializationException;
    }

    public <T> void encodeNullableSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializer, T value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (encodeElement(descriptor, index)) {
            encodeNullableSerializableValue(serializer, value);
        }
    }

    @ExperimentalSerializationApi
    public <T> void encodeNullableSerializableValue(SerializationStrategy<? super T> serializer, T value) {
        Encoder.DefaultImpls.encodeNullableSerializableValue(this, serializer, value);
    }

    public <T> void encodeSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializer, T value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (encodeElement(descriptor, index)) {
            encodeSerializableValue(serializer, value);
        }
    }

    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T value) {
        Encoder.DefaultImpls.encodeSerializableValue(this, serializer, value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeShort(short value) {
        encodeValue(Short.valueOf(value));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeShortElement(SerialDescriptor descriptor, int index, short value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeShort(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeValue(value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeStringElement(SerialDescriptor descriptor, int index, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        if (encodeElement(descriptor, index)) {
            encodeString(value);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeValue(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder stringBuilder = new StringBuilder();
        SerializationException serializationException = new SerializationException(stringBuilder.append("Non-serializable ").append(Reflection.getOrCreateKotlinClass(value.getClass())).append(" is not supported by ").append(Reflection.getOrCreateKotlinClass(getClass())).append(" encoder").toString());
        throw serializationException;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @ExperimentalSerializationApi
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        return CompositeEncoder.DefaultImpls.shouldEncodeElementDefault(this, descriptor, index);
    }
}
