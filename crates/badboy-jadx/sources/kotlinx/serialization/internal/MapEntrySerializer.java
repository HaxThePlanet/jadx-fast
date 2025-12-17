package kotlinx.serialization.internal;

import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind.MAP;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0001\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003:\u0001\u0015B#\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\u0008\u0008\u0010\tJ)\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u0014R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR$\u0010\u000e\u001a\u00028\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R$\u0010\u0011\u001a\u00028\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0010¨\u0006\u0016", d2 = {"Lkotlinx/serialization/internal/MapEntrySerializer;", "K", "V", "Lkotlinx/serialization/internal/KeyValueSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "key", "getKey", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "MapEntry", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MapEntrySerializer<K, V>  extends kotlinx.serialization.internal.KeyValueSerializer<K, V, Map.Entry<? extends K, ? extends V>> {

    private final SerialDescriptor descriptor;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010&\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J\u000e\u0010\u000c\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\tJ\u000e\u0010\r\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u0008\u0008\u0002\u0010\u0004\u001a\u00028\u00022\u0008\u0008\u0002\u0010\u0005\u001a\u00028\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0004\u001a\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0016\u0010\u0005\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000b\u0010\t¨\u0006\u0018", d2 = {"Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "K", "V", "", "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class MapEntry implements Map.Entry<K, V>, KMappedMarker {

        private final K key;
        private final V value;
        public MapEntry(K key, V value) {
            super();
            this.key = key;
            this.value = value;
        }

        public static kotlinx.serialization.internal.MapEntrySerializer.MapEntry copy$default(kotlinx.serialization.internal.MapEntrySerializer.MapEntry mapEntrySerializer$MapEntry, Object object2, Object object3, int i4, Object object5) {
            Object obj1;
            Object obj2;
            if (i4 & 1 != 0) {
                obj1 = mapEntry.key;
            }
            if (i4 &= 2 != 0) {
                obj2 = mapEntry.value;
            }
            return mapEntry.copy(obj1, obj2);
        }

        public final K component1() {
            return this.key;
        }

        public final V component2() {
            return this.value;
        }

        public final kotlinx.serialization.internal.MapEntrySerializer.MapEntry<K, V> copy(K k, V v2) {
            MapEntrySerializer.MapEntry mapEntry = new MapEntrySerializer.MapEntry(k, v2);
            return mapEntry;
        }

        @Override // java.util.Map$Entry
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof MapEntrySerializer.MapEntry) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.key, obj.key)) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.value, obj.value)) {
                return i2;
            }
            return i;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map$Entry
        public int hashCode() {
            int i;
            int i2;
            if (this.key == null) {
                i = i2;
            } else {
                i = this.key.hashCode();
            }
            if (this.value == null) {
            } else {
                i2 = this.value.hashCode();
            }
            return i3 += i2;
        }

        public V setValue(V v) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.Map$Entry
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("MapEntry(key=").append(this.key).append(", value=").append(this.value).append(')').toString();
        }
    }
    public static Unit $r8$lambda$OpkROm_ArWMMd-jLNh8LkCpGaY0(KSerializer kSerializer, KSerializer kSerializer2, ClassSerialDescriptorBuilder classSerialDescriptorBuilder3) {
        return MapEntrySerializer.descriptor$lambda$0(kSerializer, kSerializer2, classSerialDescriptorBuilder3);
    }

    public MapEntrySerializer(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
        super(keySerializer, valueSerializer, 0);
        MapEntrySerializer$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new MapEntrySerializer$$ExternalSyntheticLambda0(keySerializer, valueSerializer);
        this.descriptor = SerialDescriptorsKt.buildSerialDescriptor("kotlin.collections.Map.Entry", (SerialKind)StructureKind.MAP.INSTANCE, new SerialDescriptor[0], externalSyntheticLambda0);
    }

    private static final Unit descriptor$lambda$0(KSerializer $keySerializer, KSerializer $valueSerializer, ClassSerialDescriptorBuilder $this$buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildSerialDescriptor, "$this$buildSerialDescriptor");
        final int i3 = 12;
        final int i4 = 0;
        final int i = 0;
        final int i2 = 0;
        final Object obj = $this$buildSerialDescriptor;
        ClassSerialDescriptorBuilder.element$default(obj, "key", $keySerializer.getDescriptor(), i, i2, i3, i4);
        ClassSerialDescriptorBuilder.element$default(obj, "value", $valueSerializer.getDescriptor(), i, i2, i3, i4);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public Object getKey(Object $this$getKey) {
        return getKey((Map.Entry)$this$getKey);
    }

    protected K getKey(Map.Entry<? extends K, ? extends V> $this$key) {
        Intrinsics.checkNotNullParameter($this$key, "<this>");
        return $this$key.getKey();
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public Object getValue(Object $this$getValue) {
        return getValue((Map.Entry)$this$getValue);
    }

    protected V getValue(Map.Entry<? extends K, ? extends V> $this$value) {
        Intrinsics.checkNotNullParameter($this$value, "<this>");
        return $this$value.getValue();
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public Object toResult(Object key, Object value) {
        return toResult(key, value);
    }

    protected Map.Entry<K, V> toResult(K key, V value) {
        MapEntrySerializer.MapEntry mapEntry = new MapEntrySerializer.MapEntry(key, value);
        return (Map.Entry)mapEntry;
    }
}
