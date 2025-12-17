package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000c\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006#", d2 = {"Lkotlinx/serialization/internal/NoOpEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "<init>", "()V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeValue", "", "value", "", "encodeNull", "encodeBoolean", "", "encodeByte", "", "encodeShort", "", "encodeInt", "", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeChar", "", "encodeString", "", "encodeEnum", "enumDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NoOpEncoder extends AbstractEncoder {

    public static final kotlinx.serialization.internal.NoOpEncoder INSTANCE;
    private static final SerializersModule serializersModule;
    static {
        NoOpEncoder noOpEncoder = new NoOpEncoder();
        NoOpEncoder.INSTANCE = noOpEncoder;
        NoOpEncoder.serializersModule = SerializersModuleBuildersKt.EmptySerializersModule();
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeBoolean(boolean value) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeByte(byte value) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeChar(char value) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeDouble(double value) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeEnum(SerialDescriptor enumDescriptor, int index) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeFloat(float value) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeInt(int value) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeLong(long value) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeNull() {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeShort(short value) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void encodeValue(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public SerializersModule getSerializersModule() {
        return NoOpEncoder.serializersModule;
    }
}
