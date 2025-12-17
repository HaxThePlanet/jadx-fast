package androidx.savedstate.serialization.serializers;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\u00030\u0002:\u0001\u0015B\u0015\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00080\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0016", d2 = {"Landroidx/savedstate/serialization/serializers/SparseArraySerializer;", "T", "Lkotlinx/serialization/KSerializer;", "Landroid/util/SparseArray;", "elementSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "surrogateSerializer", "Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "SparseArraySurrogate", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SparseArraySerializer<T>  implements KSerializer<SparseArray<T>> {

    private final SerialDescriptor descriptor;
    private final KSerializer<androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate<T>> surrogateSerializer;

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0003\u0018\u0000 \u001b*\u0004\u0008\u0001\u0010\u00012\u00020\u0002:\u0002\u001a\u001bB#\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\u0008\u0007\u0010\u0008B;\u0008\u0010\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\u0008\u0007\u0010\u000cJE\u0010\u0010\u001a\u00020\u0011\"\n\u0008\u0002\u0010\u0001*\u0004\u0018\u00010\u00022\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0018H\u0001¢\u0006\u0002\u0008\u0019R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000e¨\u0006\u001c", d2 = {"Landroidx/savedstate/serialization/serializers/SparseArraySerializer$SparseArraySurrogate;", "T", "", "keys", "", "", "values", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKeys", "()Ljava/util/List;", "getValues", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$savedstate_release", "$serializer", "Companion", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    private static final class SparseArraySurrogate {

        private static final SerialDescriptor $cachedDescriptor;
        private static final Lazy<KSerializer<Object>>[] $childSerializers;
        public static final androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate.Companion Companion;
        private final List<Integer> keys;
        private final List<T> values;
        public static KSerializer $r8$lambda$Te6tq_6GXP9ROR7MsQbitRJE9jo() {
            return SparseArraySerializer.SparseArraySurrogate._childSerializers$_anonymous_();
        }

        static {
            final int i2 = 0;
            SparseArraySerializer.SparseArraySurrogate.Companion companion = new SparseArraySerializer.SparseArraySurrogate.Companion(i2);
            SparseArraySerializer.SparseArraySurrogate.Companion = companion;
            int i = 2;
            Lazy[] arr = new Lazy[i];
            SparseArraySerializer.SparseArraySurrogate$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SparseArraySerializer.SparseArraySurrogate$$ExternalSyntheticLambda0();
            int i4 = 0;
            arr[i4] = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, externalSyntheticLambda0);
            arr[1] = i2;
            SparseArraySerializer.SparseArraySurrogate.$childSerializers = arr;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", i2, i);
            pluginGeneratedSerialDescriptor.addElement("keys", i4);
            pluginGeneratedSerialDescriptor.addElement("values", i4);
            SparseArraySerializer.SparseArraySurrogate.$cachedDescriptor = (SerialDescriptor)pluginGeneratedSerialDescriptor;
        }

        public SparseArraySurrogate(int seen0, List keys, List values, SerializationConstructorMarker serializationConstructorMarker) {
            int $cachedDescriptor;
            final int i = 3;
            if (i != seen0 & 3) {
                PluginExceptionsKt.throwMissingFieldException(seen0, i, SparseArraySerializer.SparseArraySurrogate.$cachedDescriptor);
            }
            super();
            this.keys = keys;
            this.values = values;
        }

        public SparseArraySurrogate(List<Integer> keys, List<? extends T> values) {
            Intrinsics.checkNotNullParameter(keys, "keys");
            Intrinsics.checkNotNullParameter(values, "values");
            super();
            this.keys = keys;
            this.values = values;
        }

        private static final KSerializer _childSerializers$_anonymous_() {
            ArrayListSerializer arrayListSerializer = new ArrayListSerializer((KSerializer)IntSerializer.INSTANCE);
            return (KSerializer)arrayListSerializer;
        }

        public static final Lazy[] access$get$childSerializers$cp() {
            return SparseArraySerializer.SparseArraySurrogate.$childSerializers;
        }

        @JvmStatic
        public static final void write$Self$savedstate_release(androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate self, CompositeEncoder output, SerialDescriptor serialDesc, KSerializer typeSerial0) {
            int i = 0;
            output.encodeSerializableElement(serialDesc, i, (SerializationStrategy)SparseArraySerializer.SparseArraySurrogate.$childSerializers[i].getValue(), self.keys);
            ArrayListSerializer arrayListSerializer = new ArrayListSerializer(typeSerial0);
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)arrayListSerializer, self.values);
        }

        public final List<Integer> getKeys() {
            return this.keys;
        }

        public final List<T> getValues() {
            return this.values;
        }
    }
    public SparseArraySerializer(KSerializer<T> elementSerializer) {
        Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
        super();
        this.surrogateSerializer = SparseArraySerializer.SparseArraySurrogate.Companion.serializer(elementSerializer);
        this.descriptor = this.surrogateSerializer.getDescriptor();
    }

    public SparseArray<T> deserialize(Decoder decoder) {
        int i;
        int index;
        int intValue;
        Object obj;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Object decodeSerializableValue = decoder.decodeSerializableValue((DeserializationStrategy)this.surrogateSerializer);
        i = (SparseArraySerializer.SparseArraySurrogate)decodeSerializableValue.getKeys().size() == decodeSerializableValue.getValues().size() ? 1 : 0;
        if (i == 0) {
        } else {
            SparseArray sparseArray = new SparseArray(decodeSerializableValue.getKeys().size());
            final int i2 = 0;
            index = 0;
            while (index < (Collection)decodeSerializableValue.getKeys().size()) {
                sparseArray.append((Number)decodeSerializableValue.getKeys().get(index).intValue(), decodeSerializableValue.getValues().get(index));
                index++;
            }
            return sparseArray;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.serialization.KSerializer
    public Object deserialize(Decoder decoder) {
        return deserialize(decoder);
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(Encoder encoder, SparseArray<T> value) {
        int i2;
        int i3;
        Integer index;
        int i;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        int size = value.size();
        ArrayList arrayList = new ArrayList(size);
        i3 = i2;
        while (i3 < size) {
            i = 0;
            arrayList.add(Integer.valueOf(value.keyAt(i3)));
            i3++;
        }
        int size2 = value.size();
        ArrayList arrayList2 = new ArrayList(size2);
        while (i2 < size2) {
            i = 0;
            arrayList2.add(value.valueAt(i2));
            i2++;
        }
        SparseArraySerializer.SparseArraySurrogate sparseArraySurrogate = new SparseArraySerializer.SparseArraySurrogate((List)arrayList, (List)arrayList2);
        encoder.encodeSerializableValue((SerializationStrategy)this.surrogateSerializer, sparseArraySurrogate);
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Object value) {
        serialize(encoder, (SparseArray)value);
    }
}
