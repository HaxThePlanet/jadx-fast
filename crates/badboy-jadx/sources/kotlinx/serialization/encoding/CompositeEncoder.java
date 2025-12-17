package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\rH\u0017J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH&J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0011H&J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0013H&J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0015H&J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0018H&J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001aH&J \u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001cH&J \u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001eH&J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\rH&J?\u0010!\u001a\u00020\u0007\"\n\u0008\u0000\u0010\"*\u0004\u0018\u00010\u00012\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\r2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\"0$2\u0006\u0010\u000f\u001a\u0002H\"H&¢\u0006\u0002\u0010%J?\u0010&\u001a\u00020\u0007\"\u0008\u0008\u0000\u0010\"*\u00020\u00012\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\r2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u0002H\"0$2\u0008\u0010\u000f\u001a\u0004\u0018\u0001H\"H'¢\u0006\u0002\u0010%R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006'", d2 = {"Lkotlinx/serialization/encoding/CompositeEncoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "endStructure", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "shouldEncodeElementDefault", "", "index", "", "encodeBooleanElement", "value", "encodeByteElement", "", "encodeShortElement", "", "encodeCharElement", "", "encodeIntElement", "encodeLongElement", "", "encodeFloatElement", "", "encodeDoubleElement", "", "encodeStringElement", "", "encodeInlineElement", "Lkotlinx/serialization/encoding/Encoder;", "encodeSerializableElement", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface CompositeEncoder {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        public static boolean shouldEncodeElementDefault(kotlinx.serialization.encoding.CompositeEncoder $this, SerialDescriptor descriptor, int index) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return 1;
        }
    }
    public abstract void encodeBooleanElement(SerialDescriptor serialDescriptor, int i2, boolean z3);

    public abstract void encodeByteElement(SerialDescriptor serialDescriptor, int i2, byte b3);

    public abstract void encodeCharElement(SerialDescriptor serialDescriptor, int i2, char c3);

    public abstract void encodeDoubleElement(SerialDescriptor serialDescriptor, int i2, double d3);

    public abstract void encodeFloatElement(SerialDescriptor serialDescriptor, int i2, float f3);

    public abstract kotlinx.serialization.encoding.Encoder encodeInlineElement(SerialDescriptor serialDescriptor, int i2);

    public abstract void encodeIntElement(SerialDescriptor serialDescriptor, int i2, int i3);

    public abstract void encodeLongElement(SerialDescriptor serialDescriptor, int i2, long l3);

    @ExperimentalSerializationApi
    public abstract <T> void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i2, SerializationStrategy<? super T> serializationStrategy3, T t4);

    public abstract <T> void encodeSerializableElement(SerialDescriptor serialDescriptor, int i2, SerializationStrategy<? super T> serializationStrategy3, T t4);

    public abstract void encodeShortElement(SerialDescriptor serialDescriptor, int i2, short s3);

    public abstract void encodeStringElement(SerialDescriptor serialDescriptor, int i2, String string3);

    public abstract void endStructure(SerialDescriptor serialDescriptor);

    public abstract SerializersModule getSerializersModule();

    @ExperimentalSerializationApi
    public abstract boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor, int i2);
}
