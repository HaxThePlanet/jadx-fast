package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00081\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u0002*\u0004\u0008\u0002\u0010\u00032\u0008\u0012\u0004\u0012\u0002H\u00030\u0004B%\u0008\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001d\u0010\u0011\u001a\u00028\u00022\u0006\u0010\u000c\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H$¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001a\u00028\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u001a\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001a\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004X\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0016\u0010\u000c\u001a\u00028\u0000*\u00028\u0002X¤\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00028\u0001*\u00028\u0002X¤\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000e\u0082\u0001\u0002\u001c\u001d¨\u0006\u001e", d2 = {"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "key", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class KeyValueSerializer<K, V, R>  implements KSerializer<R> {

    private final KSerializer<K> keySerializer;
    private final KSerializer<V> valueSerializer;
    private KeyValueSerializer(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        super();
        this.keySerializer = keySerializer;
        this.valueSerializer = valueSerializer;
    }

    public KeyValueSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(kSerializer, kSerializer2);
    }

    public R deserialize(Decoder decoder) {
        Object idx2;
        int decodeSerializableElement$default;
        Object descriptor;
        Object result;
        Object idx3;
        KSerializer valueSerializer;
        int idx;
        int i;
        int i2;
        Object key;
        Object value;
        int i3;
        final int obj = this;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        kotlinx.serialization.descriptors.SerialDescriptor descriptor2 = obj.getDescriptor();
        final int i6 = 0;
        final CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        final CompositeDecoder compositeDecoder = beginStructure;
        final int i11 = 0;
        if (compositeDecoder.decodeSequentially()) {
            i = 8;
            i2 = 0;
            idx = 0;
            result = obj.toResult(CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, obj.getDescriptor(), 0, (DeserializationStrategy)obj.getKeySerializer(), idx, i, i2), CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, obj.getDescriptor(), 1, (DeserializationStrategy)obj.getValueSerializer(), idx, i, i2));
            beginStructure.endStructure(descriptor2);
            return result;
        } else {
            key = descriptor;
            value = idx3;
            while (/* condition */) {
                int idx5 = decodeSerializableElement$default;
                key = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, obj.getDescriptor(), null, (DeserializationStrategy)obj.getKeySerializer(), 0, 8, 0);
                idx2 = decoder;
                decodeSerializableElement$default = compositeDecoder.decodeElementIndex(obj.getDescriptor());
                int i4 = i3;
                value = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, obj.getDescriptor(), 1, (DeserializationStrategy)obj.getValueSerializer(), 0, 8, 0);
                idx2 = decoder;
            }
            int idx4 = decodeSerializableElement$default;
            if (key == TuplesKt.access$getNULL$p()) {
            } else {
                if (value == TuplesKt.access$getNULL$p()) {
                } else {
                    result = obj.toResult(key, value);
                }
                SerializationException serializationException2 = new SerializationException("Element 'value' is missing");
                throw serializationException2;
            }
            SerializationException serializationException = new SerializationException("Element 'key' is missing");
            throw serializationException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        SerializationException idx6 = new SerializationException(stringBuilder.append("Invalid index: ").append(decodeSerializableElement$default).toString());
        throw idx6;
    }

    protected abstract K getKey(R r);

    protected final KSerializer<K> getKeySerializer() {
        return this.keySerializer;
    }

    protected abstract V getValue(R r);

    protected final KSerializer<V> getValueSerializer() {
        return this.valueSerializer;
    }

    public void serialize(Encoder encoder, R value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        CompositeEncoder beginStructure = encoder.beginStructure(getDescriptor());
        beginStructure.encodeSerializableElement(getDescriptor(), 0, (SerializationStrategy)this.keySerializer, getKey(value));
        beginStructure.encodeSerializableElement(getDescriptor(), 1, (SerializationStrategy)this.valueSerializer, getValue(value));
        beginStructure.endStructure(getDescriptor());
    }

    protected abstract R toResult(K k, V v2);
}
