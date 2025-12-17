package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Á\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0015", d2 = {"Lkotlinx/serialization/internal/UByteSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/UByte;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-EK-6454", "(Lkotlinx/serialization/encoding/Encoder;B)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-Wa3L5BU", "(Lkotlinx/serialization/encoding/Decoder;)B", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UByteSerializer implements KSerializer<UByte> {

    public static final kotlinx.serialization.internal.UByteSerializer INSTANCE;
    private static final SerialDescriptor descriptor;
    static {
        UByteSerializer uByteSerializer = new UByteSerializer();
        UByteSerializer.INSTANCE = uByteSerializer;
        UByteSerializer.descriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlin.UByte", BuiltinSerializersKt.serializer(ByteCompanionObject.INSTANCE));
    }

    @Override // kotlinx.serialization.KSerializer
    public Object deserialize(Decoder decoder) {
        return UByte.box-impl(deserialize-Wa3L5BU(decoder));
    }

    @Override // kotlinx.serialization.KSerializer
    public byte deserialize-Wa3L5BU(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return UByte.constructor-impl(decoder.decodeInline(getDescriptor()).decodeByte());
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return UByteSerializer.descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Object value) {
        serialize-EK-6454(encoder, (UByte)value.unbox-impl());
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize-EK-6454(Encoder encoder, byte value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeInline(getDescriptor()).encodeByte(value);
    }
}
