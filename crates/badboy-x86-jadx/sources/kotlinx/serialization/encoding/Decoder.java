package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0002\u0008\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000c\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0006\u001a\u00020\u0007H'J\n\u0010\u0008\u001a\u0004\u0018\u00010\tH'J\u0008\u0010\n\u001a\u00020\u0007H&J\u0008\u0010\u000b\u001a\u00020\u000cH&J\u0008\u0010\r\u001a\u00020\u000eH&J\u0008\u0010\u000f\u001a\u00020\u0010H&J\u0008\u0010\u0011\u001a\u00020\u0012H&J\u0008\u0010\u0013\u001a\u00020\u0014H&J\u0008\u0010\u0015\u001a\u00020\u0016H&J\u0008\u0010\u0017\u001a\u00020\u0018H&J\u0008\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001dH&J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001dH&J'\u0010\"\u001a\u0002H#\"\n\u0008\u0000\u0010#*\u0004\u0018\u00010\u00012\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H#0%H\u0016¢\u0006\u0002\u0010&J)\u0010'\u001a\u0004\u0018\u0001H#\"\u0008\u0008\u0000\u0010#*\u00020\u00012\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H#0%H\u0017¢\u0006\u0002\u0010&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006(", d2 = {"Lkotlinx/serialization/encoding/Decoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeNotNullMark", "", "decodeNull", "", "decodeBoolean", "decodeByte", "", "decodeShort", "", "decodeChar", "", "decodeInt", "", "decodeLong", "", "decodeFloat", "", "decodeDouble", "", "decodeString", "", "decodeEnum", "enumDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeInline", "descriptor", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeNullableSerializableValue", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Decoder {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        public static <T> T decodeNullableSerializableValue(kotlinx.serialization.encoding.Decoder $this, DeserializationStrategy<? extends T> deserializer) {
            Object decodeSerializableValue;
            boolean decodeNotNullMark;
            Intrinsics.checkNotNullParameter(deserializer, "deserializer");
            Object obj = $this;
            final int i = 0;
            if (!deserializer.getDescriptor().isNullable()) {
                if (obj.decodeNotNullMark()) {
                    int i2 = 0;
                    decodeSerializableValue = $this.decodeSerializableValue(deserializer);
                } else {
                    decodeSerializableValue = obj.decodeNull();
                }
            } else {
            }
            return decodeSerializableValue;
        }

        public static <T> T decodeSerializableValue(kotlinx.serialization.encoding.Decoder $this, DeserializationStrategy<? extends T> deserializer) {
            Intrinsics.checkNotNullParameter(deserializer, "deserializer");
            return deserializer.deserialize($this);
        }
    }
    public abstract kotlinx.serialization.encoding.CompositeDecoder beginStructure(SerialDescriptor serialDescriptor);

    public abstract boolean decodeBoolean();

    public abstract byte decodeByte();

    public abstract char decodeChar();

    public abstract double decodeDouble();

    public abstract int decodeEnum(SerialDescriptor serialDescriptor);

    public abstract float decodeFloat();

    public abstract kotlinx.serialization.encoding.Decoder decodeInline(SerialDescriptor serialDescriptor);

    public abstract int decodeInt();

    public abstract long decodeLong();

    @ExperimentalSerializationApi
    public abstract boolean decodeNotNullMark();

    @ExperimentalSerializationApi
    public abstract Void decodeNull();

    @ExperimentalSerializationApi
    public abstract <T> T decodeNullableSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy);

    public abstract <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy);

    public abstract short decodeShort();

    public abstract String decodeString();

    public abstract SerializersModule getSerializersModule();
}
