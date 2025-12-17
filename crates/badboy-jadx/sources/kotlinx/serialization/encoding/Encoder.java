package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000c\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0006\u001a\u00020\u0007H\u0017J\u0008\u0010\u0008\u001a\u00020\u0007H'J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u000c\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u001bH&J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013H&J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u001eH&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u001eH&J\u0018\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0013H\u0016J/\u0010&\u001a\u00020\u0007\"\n\u0008\u0000\u0010'*\u0004\u0018\u00010\u00012\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H'0)2\u0006\u0010\n\u001a\u0002H'H\u0016¢\u0006\u0002\u0010*J/\u0010+\u001a\u00020\u0007\"\u0008\u0008\u0000\u0010'*\u00020\u00012\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H'0)2\u0008\u0010\n\u001a\u0004\u0018\u0001H'H\u0017¢\u0006\u0002\u0010*R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006,", d2 = {"Lkotlinx/serialization/encoding/Encoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeNotNullMark", "", "encodeNull", "encodeBoolean", "value", "", "encodeByte", "", "encodeShort", "", "encodeChar", "", "encodeInt", "", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeString", "", "encodeEnum", "enumDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "encodeInline", "descriptor", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "beginCollection", "collectionSize", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableValue", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Encoder {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static kotlinx.serialization.encoding.CompositeEncoder beginCollection(kotlinx.serialization.encoding.Encoder $this, SerialDescriptor descriptor, int collectionSize) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return $this.beginStructure(descriptor);
        }

        @ExperimentalSerializationApi
        public static void encodeNotNullMark(kotlinx.serialization.encoding.Encoder $this) {
        }

        @ExperimentalSerializationApi
        public static <T> void encodeNullableSerializableValue(kotlinx.serialization.encoding.Encoder $this, SerializationStrategy<? super T> serializer, T value) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            if (serializer.getDescriptor().isNullable()) {
                $this.encodeSerializableValue(serializer, value);
            }
            if (value == null) {
                $this.encodeNull();
            } else {
                $this.encodeNotNullMark();
                $this.encodeSerializableValue(serializer, value);
            }
        }

        public static <T> void encodeSerializableValue(kotlinx.serialization.encoding.Encoder $this, SerializationStrategy<? super T> serializer, T value) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            serializer.serialize($this, value);
        }
    }
    public abstract kotlinx.serialization.encoding.CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i2);

    public abstract kotlinx.serialization.encoding.CompositeEncoder beginStructure(SerialDescriptor serialDescriptor);

    public abstract void encodeBoolean(boolean z);

    public abstract void encodeByte(byte b);

    public abstract void encodeChar(char c);

    public abstract void encodeDouble(double d);

    public abstract void encodeEnum(SerialDescriptor serialDescriptor, int i2);

    public abstract void encodeFloat(float f);

    public abstract kotlinx.serialization.encoding.Encoder encodeInline(SerialDescriptor serialDescriptor);

    public abstract void encodeInt(int i);

    public abstract void encodeLong(long l);

    @ExperimentalSerializationApi
    public abstract void encodeNotNullMark();

    @ExperimentalSerializationApi
    public abstract void encodeNull();

    @ExperimentalSerializationApi
    public abstract <T> void encodeNullableSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t2);

    public abstract <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t2);

    public abstract void encodeShort(short s);

    public abstract void encodeString(String string);

    public abstract SerializersModule getSerializersModule();
}
