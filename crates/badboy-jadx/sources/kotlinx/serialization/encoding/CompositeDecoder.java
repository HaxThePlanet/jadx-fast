package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000c\n\u0000\n\u0002\u0010\n\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008f\u0018\u0000 )2\u00020\u0001:\u0001)J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH&J\u0008\u0010\n\u001a\u00020\u000bH\u0017J\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0008\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0008\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH&J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH&J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH&J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH&J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH&J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH&J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH&J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH&J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH&J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH&JC\u0010\"\u001a\u0002H#\"\n\u0008\u0000\u0010#*\u0004\u0018\u00010\u00012\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\r2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H#0%2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u0001H#H&¢\u0006\u0002\u0010'JE\u0010(\u001a\u0004\u0018\u0001H#\"\u0008\u0008\u0000\u0010#*\u00020\u00012\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\r2\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H#0%2\n\u0008\u0002\u0010&\u001a\u0004\u0018\u0001H#H'¢\u0006\u0002\u0010'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006*", d2 = {"Lkotlinx/serialization/encoding/CompositeDecoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "endStructure", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeSequentially", "", "decodeElementIndex", "", "decodeCollectionSize", "decodeBooleanElement", "index", "decodeByteElement", "", "decodeCharElement", "", "decodeShortElement", "", "decodeIntElement", "decodeLongElement", "", "decodeFloatElement", "", "decodeDoubleElement", "", "decodeStringElement", "", "decodeInlineElement", "Lkotlinx/serialization/encoding/Decoder;", "decodeSerializableElement", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "Companion", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface CompositeDecoder {

    public static final kotlinx.serialization.encoding.CompositeDecoder.Companion Companion = null;
    public static final int DECODE_DONE = -1;
    public static final int UNKNOWN_NAME = -3;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lkotlinx/serialization/encoding/CompositeDecoder$Companion;", "", "<init>", "()V", "DECODE_DONE", "", "UNKNOWN_NAME", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        static final kotlinx.serialization.encoding.CompositeDecoder.Companion $$INSTANCE = null;
        public static final int DECODE_DONE = -1;
        public static final int UNKNOWN_NAME = -3;
        static {
            CompositeDecoder.Companion companion = new CompositeDecoder.Companion();
            CompositeDecoder.Companion.$$INSTANCE = companion;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int decodeCollectionSize(kotlinx.serialization.encoding.CompositeDecoder $this, SerialDescriptor descriptor) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return -1;
        }

        public static Object decodeNullableSerializableElement$default(kotlinx.serialization.encoding.CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor2, int i3, DeserializationStrategy deserializationStrategy4, Object object5, int i6, Object object7) {
            int obj4;
            if (object7 != null) {
            } else {
                if (i6 &= 8 != 0) {
                    obj4 = 0;
                }
                return compositeDecoder.decodeNullableSerializableElement(serialDescriptor2, i3, deserializationStrategy4, obj4);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeNullableSerializableElement");
            throw obj0;
        }

        @ExperimentalSerializationApi
        public static boolean decodeSequentially(kotlinx.serialization.encoding.CompositeDecoder $this) {
            return 0;
        }

        public static Object decodeSerializableElement$default(kotlinx.serialization.encoding.CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor2, int i3, DeserializationStrategy deserializationStrategy4, Object object5, int i6, Object object7) {
            int obj4;
            if (object7 != null) {
            } else {
                if (i6 &= 8 != 0) {
                    obj4 = 0;
                }
                return compositeDecoder.decodeSerializableElement(serialDescriptor2, i3, deserializationStrategy4, obj4);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
            throw obj0;
        }
    }
    static {
        CompositeDecoder.Companion = CompositeDecoder.Companion.$$INSTANCE;
    }

    public abstract boolean decodeBooleanElement(SerialDescriptor serialDescriptor, int i2);

    public abstract byte decodeByteElement(SerialDescriptor serialDescriptor, int i2);

    public abstract char decodeCharElement(SerialDescriptor serialDescriptor, int i2);

    public abstract int decodeCollectionSize(SerialDescriptor serialDescriptor);

    public abstract double decodeDoubleElement(SerialDescriptor serialDescriptor, int i2);

    public abstract int decodeElementIndex(SerialDescriptor serialDescriptor);

    public abstract float decodeFloatElement(SerialDescriptor serialDescriptor, int i2);

    public abstract kotlinx.serialization.encoding.Decoder decodeInlineElement(SerialDescriptor serialDescriptor, int i2);

    public abstract int decodeIntElement(SerialDescriptor serialDescriptor, int i2);

    public abstract long decodeLongElement(SerialDescriptor serialDescriptor, int i2);

    @ExperimentalSerializationApi
    public abstract <T> T decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i2, DeserializationStrategy<? extends T> deserializationStrategy3, T t4);

    @ExperimentalSerializationApi
    public abstract boolean decodeSequentially();

    public abstract <T> T decodeSerializableElement(SerialDescriptor serialDescriptor, int i2, DeserializationStrategy<? extends T> deserializationStrategy3, T t4);

    public abstract short decodeShortElement(SerialDescriptor serialDescriptor, int i2);

    public abstract String decodeStringElement(SerialDescriptor serialDescriptor, int i2);

    public abstract void endStructure(SerialDescriptor serialDescriptor);

    public abstract SerializersModule getSerializersModule();
}
