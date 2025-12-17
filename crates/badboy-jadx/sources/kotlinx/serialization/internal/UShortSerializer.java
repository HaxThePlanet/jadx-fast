package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Á\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0015", d2 = {"Lkotlinx/serialization/internal/UShortSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/UShort;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-i8woANY", "(Lkotlinx/serialization/encoding/Encoder;S)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-BwKQO78", "(Lkotlinx/serialization/encoding/Decoder;)S", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UShortSerializer implements KSerializer<UShort> {

    public static final kotlinx.serialization.internal.UShortSerializer INSTANCE;
    private static final SerialDescriptor descriptor;
    static {
        UShortSerializer uShortSerializer = new UShortSerializer();
        UShortSerializer.INSTANCE = uShortSerializer;
        UShortSerializer.descriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlin.UShort", BuiltinSerializersKt.serializer(ShortCompanionObject.INSTANCE));
    }

    @Override // kotlinx.serialization.KSerializer
    public Object deserialize(Decoder decoder) {
        return UShort.box-impl(deserialize-BwKQO78(decoder));
    }

    @Override // kotlinx.serialization.KSerializer
    public short deserialize-BwKQO78(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return UShort.constructor-impl(decoder.decodeInline(getDescriptor()).decodeShort());
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return UShortSerializer.descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Object value) {
        serialize-i8woANY(encoder, (UShort)value.unbox-impl());
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize-i8woANY(Encoder encoder, short value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeInline(getDescriptor()).encodeShort(value);
    }
}
