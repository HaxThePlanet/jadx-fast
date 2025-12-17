package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u0002*\u0004\u0008\u0002\u0010\u0003*\u0014\u0008\u0003\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00052 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0006B%\u0008\u0004\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\t\u0012\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\u0008\u000b\u0010\u000cJ)\u0010\u0010\u001a\u00020\u0011*\u00028\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0001H$¢\u0006\u0002\u0010\u0016J-\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u00032\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013H\u0004¢\u0006\u0002\u0010!J-\u0010\"\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00028\u00032\u0006\u0010#\u001a\u00020$H\u0004¢\u0006\u0002\u0010%J\u001d\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0015\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010)R\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a\u0082\u0001\u0002*+¨\u0006,", d2 = {"Lkotlinx/serialization/internal/MapLikeSerializer;", "Key", "Value", "Collection", "Builder", "", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "insertKeyValuePair", "", "index", "", "key", "value", "(Ljava/util/Map;ILjava/lang/Object;Ljava/lang/Object;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "readAll", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "builder", "startIndex", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/util/Map;II)V", "readElement", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/util/Map;Z)V", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/internal/HashMapSerializer;", "Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalSerializationApi
public abstract class MapLikeSerializer<Key, Value, Collection, Builder extends Map<Key, Value>>  extends kotlinx.serialization.internal.AbstractCollectionSerializer<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    private final KSerializer<Key> keySerializer;
    private final KSerializer<Value> valueSerializer;
    private MapLikeSerializer(KSerializer<Key> keySerializer, KSerializer<Value> valueSerializer) {
        super(0);
        this.keySerializer = keySerializer;
        this.valueSerializer = valueSerializer;
    }

    public MapLikeSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(kSerializer, kSerializer2);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public abstract SerialDescriptor getDescriptor();

    public final KSerializer<Key> getKeySerializer() {
        return this.keySerializer;
    }

    public final KSerializer<Value> getValueSerializer() {
        return this.valueSerializer;
    }

    protected abstract void insertKeyValuePair(Builder builder, int i2, Key key3, Value value4);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void readAll(CompositeDecoder decoder, Object builder, int startIndex, int size) {
        readAll(decoder, (Map)builder, startIndex, size);
    }

    protected final void readAll(CompositeDecoder decoder, Builder builder, int startIndex, int size) {
        int i;
        int index;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        int i3 = 0;
        i = size >= 0 ? 1 : i3;
        if (i == 0) {
        } else {
            IntProgression step = RangesKt.step((IntProgression)RangesKt.until(i3, size * 2), 2);
            index = step.getFirst();
            final int last = step.getLast();
            int step2 = step.getStep();
            if (step2 > 0) {
                if (index > last && step2 < 0 && last <= index) {
                    if (step2 < 0) {
                        if (last <= index) {
                        }
                    }
                }
            } else {
            }
        }
        int i4 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void readElement(CompositeDecoder decoder, int index, Object builder, boolean checkIndex) {
        readElement(decoder, index, (Map)builder, checkIndex);
    }

    protected final void readElement(CompositeDecoder decoder, int index, Builder builder, boolean checkIndex) {
        int decodeElementIndex;
        boolean key;
        Object decodeSerializableElement$default;
        int it;
        int i3;
        KSerializer valueSerializer;
        int kSerializer;
        int value;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Object obj2 = decoder;
        final Object obj9 = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(obj2, getDescriptor(), index, (DeserializationStrategy)this.keySerializer, 0, 8, 0);
        Object obj = obj2;
        if (checkIndex) {
            decodeElementIndex = obj.decodeElementIndex(getDescriptor());
            int i5 = decodeElementIndex;
            i3 = 0;
            kSerializer = i5 == index + 1 ? 1 : 0;
            if (kSerializer == 0) {
            } else {
                it = decodeElementIndex;
                if (builder.containsKey(obj9) && !kind instanceof PrimitiveKind) {
                    if (!kind instanceof PrimitiveKind) {
                        decodeSerializableElement$default = obj.decodeSerializableElement(getDescriptor(), it, (DeserializationStrategy)this.valueSerializer, MapsKt.getValue(builder, obj9));
                    } else {
                        decodeSerializableElement$default = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(obj, getDescriptor(), it, (DeserializationStrategy)this.valueSerializer, 0, 8, 0);
                    }
                } else {
                }
                builder.put(obj9, decodeSerializableElement$default);
            }
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Value must follow key in a map, index for key: ").append(index).append(", returned index for value: ").append(i5).toString().toString());
            throw illegalArgumentException;
        }
        it = decodeElementIndex;
    }

    public void serialize(Encoder encoder, Collection value) {
        Object k;
        Object obj;
        int collectionSize;
        Object obj2;
        int i3;
        Object next;
        Object value2;
        int i;
        int i2;
        KSerializer keySerializer;
        k = this;
        obj = value;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        final SerialDescriptor descriptor3 = k.getDescriptor();
        final int i4 = 0;
        final CompositeEncoder beginCollection = encoder.beginCollection(descriptor3, k.collectionSize(obj));
        final CompositeEncoder compositeEncoder = beginCollection;
        final int i5 = 0;
        i3 = 0;
        final Iterator it = collectionIterator;
        final int i6 = 0;
        for (Object next : it) {
            Object obj4 = next;
            i = 0;
            int size = i3 + 1;
            compositeEncoder.encodeSerializableElement(getDescriptor(), i3, (SerializationStrategy)getKeySerializer(), (Map.Entry)obj4.getKey());
            i3 = size + 1;
            compositeEncoder.encodeSerializableElement(getDescriptor(), size, (SerializationStrategy)getValueSerializer(), obj4.getValue());
            k = this;
            obj2 = encoder;
            obj = value;
            collectionSize = i2;
        }
        beginCollection.endStructure(descriptor3);
    }
}
