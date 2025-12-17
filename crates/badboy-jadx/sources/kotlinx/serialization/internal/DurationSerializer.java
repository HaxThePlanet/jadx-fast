package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.Duration.Companion;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind.STRING;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Á\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0015", d2 = {"Lkotlinx/serialization/internal/DurationSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/time/Duration;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "serialize-HG0u8IE", "(Lkotlinx/serialization/encoding/Encoder;J)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "deserialize-5sfh64U", "(Lkotlinx/serialization/encoding/Decoder;)J", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DurationSerializer implements KSerializer<Duration> {

    public static final kotlinx.serialization.internal.DurationSerializer INSTANCE;
    private static final SerialDescriptor descriptor;
    static {
        DurationSerializer durationSerializer = new DurationSerializer();
        DurationSerializer.INSTANCE = durationSerializer;
        PrimitiveSerialDescriptor primitiveSerialDescriptor = new PrimitiveSerialDescriptor("kotlin.time.Duration", (PrimitiveKind)PrimitiveKind.STRING.INSTANCE);
        DurationSerializer.descriptor = (SerialDescriptor)primitiveSerialDescriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public Object deserialize(Decoder decoder) {
        return Duration.box-impl(deserialize-5sfh64U(decoder));
    }

    @Override // kotlinx.serialization.KSerializer
    public long deserialize-5sfh64U(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return Duration.Companion.parseIsoString-UwyO8pc(decoder.decodeString());
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return DurationSerializer.descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Object value) {
        serialize-HG0u8IE(encoder, (Duration)value.unbox-impl());
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize-HG0u8IE(Encoder encoder, long value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeString(Duration.toIsoString-impl(value));
    }
}
