package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0001\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\u0015\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001a", d2 = {"Lkotlinx/serialization/internal/NullableSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NullableSerializer<T>  implements KSerializer<T> {

    private final SerialDescriptor descriptor;
    private final KSerializer<T> serializer;
    public NullableSerializer(KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        super();
        this.serializer = serializer;
        SerialDescriptorForNullable serialDescriptorForNullable = new SerialDescriptorForNullable(this.serializer.getDescriptor());
        this.descriptor = (SerialDescriptor)serialDescriptorForNullable;
    }

    public T deserialize(Decoder decoder) {
        Object decodeSerializableValue;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (decoder.decodeNotNullMark()) {
            decodeSerializableValue = decoder.decodeSerializableValue((DeserializationStrategy)this.serializer);
        } else {
            decodeSerializableValue = decoder.decodeNull();
        }
        return decodeSerializableValue;
    }

    @Override // kotlinx.serialization.KSerializer
    public boolean equals(Object other) {
        Class class2;
        Class class;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (getClass() != other.getClass()) {
            } else {
                Object obj = other;
                if (!Intrinsics.areEqual(this.serializer, obj2.serializer)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public int hashCode() {
        return this.serializer.hashCode();
    }

    public void serialize(Encoder encoder, T value) {
        Object serializer;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        if (value != null) {
            encoder.encodeNotNullMark();
            encoder.encodeSerializableValue((SerializationStrategy)this.serializer, value);
        } else {
            encoder.encodeNull();
        }
    }
}
