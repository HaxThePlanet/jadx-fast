package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlinx.serialization.a;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008f\u0018\u0000 )2\u00020\u0001:\u0001)J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0008\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0008\u001a\u00020\tH&J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&JE\u0010\u001b\u001a\u0004\u0018\u0001H\u001c\"\u0008\u0008\u0000\u0010\u001c*\u00020\u00012\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0\u001e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u0001H\u001cH'¢\u0006\u0002\u0010 J\u0008\u0010!\u001a\u00020\u0007H\u0017J=\u0010\"\u001a\u0002H\u001c\"\u0004\u0008\u0000\u0010\u001c2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u0002H\u001c0\u001e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u0001H\u001cH&¢\u0006\u0002\u0010 J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u0008\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006*", d2 = {"Lkotlinx/serialization/encoding/CompositeDecoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeBooleanElement", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "decodeByteElement", "", "decodeCharElement", "", "decodeCollectionSize", "decodeDoubleElement", "", "decodeElementIndex", "decodeFloatElement", "", "decodeInlineElement", "Lkotlinx/serialization/encoding/Decoder;", "decodeIntElement", "decodeLongElement", "", "decodeNullableSerializableElement", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSequentially", "decodeSerializableElement", "decodeShortElement", "", "decodeStringElement", "", "endStructure", "", "Companion", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface a {
    public abstract void a(SerialDescriptor serialDescriptor);

    public abstract long b(SerialDescriptor serialDescriptor, int i2);

    public abstract int c(SerialDescriptor serialDescriptor, int i2);

    public abstract <T> T d(SerialDescriptor serialDescriptor, int i2, a<T> a3, T t4);

    public abstract String e(SerialDescriptor serialDescriptor, int i2);

    public abstract int f(SerialDescriptor serialDescriptor);

    public abstract boolean g();
}
