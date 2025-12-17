package kotlinx.serialization.c;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlinx.serialization.KSerializer;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u0002*\u0004\u0008\u0002\u0010\u0003*\u0014\u0008\u0003\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00052 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0006B#\u0008\u0004\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\t\u0012\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0002\u0010\u000bJ-\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0004¢\u0006\u0002\u0010\u001bJ-\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00028\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0004¢\u0006\u0002\u0010 J\u001d\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010%J)\u0010&\u001a\u00020\u0014*\u00028\u00032\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010'\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H$¢\u0006\u0002\u0010(R\u0012\u0010\u000c\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011\u0082\u0001\u0002)*¨\u0006+", d2 = {"Lkotlinx/serialization/internal/MapLikeSerializer;", "Key", "Value", "Collection", "Builder", "", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "readAll", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "builder", "startIndex", "", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/util/Map;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/util/Map;Z)V", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "insertKeyValuePair", "key", "(Ljava/util/Map;ILjava/lang/Object;Ljava/lang/Object;)V", "Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "Lkotlinx/serialization/internal/HashMapSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class h<Key, Value, Collection, Builder extends java.util.Map<Key, Value>>  extends kotlinx.serialization.c.a<java.util.Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    private final KSerializer<Key> a;
    private final KSerializer<Value> b;
    private h(KSerializer<Key> kSerializer, KSerializer<Value> kSerializer2) {
        super(0);
        this.a = kSerializer;
        this.b = kSerializer2;
    }

    public h(KSerializer kSerializer, KSerializer kSerializer2, g g3) {
        super(kSerializer, kSerializer2);
    }
}
