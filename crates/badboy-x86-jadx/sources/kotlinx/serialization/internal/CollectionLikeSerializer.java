package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00081\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u0002*\u0004\u0008\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004B\u0017\u0008\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\u0008\u0007\u0010\u0008J!\u0010\t\u001a\u00020\n*\u00028\u00022\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u00022\u0006\u0010\u001c\u001a\u00020\u000c2\u0006\u0010\u001d\u001a\u00020\u000cH\u0004¢\u0006\u0002\u0010\u001eJ-\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u001b\u001a\u00028\u00022\u0006\u0010 \u001a\u00020!H\u0014¢\u0006\u0002\u0010\"R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012\u0082\u0001\u0003#$%¨\u0006&", d2 = {"Lkotlinx/serialization/internal/CollectionLikeSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "elementSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "insert", "", "index", "", "element", "(Ljava/lang/Object;ILjava/lang/Object;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "readAll", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "builder", "startIndex", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "Lkotlinx/serialization/internal/CollectionSerializer;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlinx/serialization/internal/ReferenceArraySerializer;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CollectionLikeSerializer<Element, Collection, Builder>  extends kotlinx.serialization.internal.AbstractCollectionSerializer<Element, Collection, Builder> {

    private final KSerializer<Element> elementSerializer;
    private CollectionLikeSerializer(KSerializer<Element> elementSerializer) {
        super(0);
        this.elementSerializer = elementSerializer;
    }

    public CollectionLikeSerializer(KSerializer kSerializer, DefaultConstructorMarker defaultConstructorMarker2) {
        super(kSerializer);
    }

    public static final KSerializer access$getElementSerializer$p(kotlinx.serialization.internal.CollectionLikeSerializer $this) {
        return $this.elementSerializer;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public abstract SerialDescriptor getDescriptor();

    protected abstract void insert(Builder builder, int i2, Element element3);

    protected final void readAll(CompositeDecoder decoder, Builder builder, int startIndex, int size) {
        int i;
        int index;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        int i3 = 0;
        i = size >= 0 ? 1 : i3;
        if (i == 0) {
        } else {
            index = 0;
            while (index < size) {
                readElement(decoder, startIndex + index, builder, i3);
                index++;
            }
        }
        int i4 = 0;
        IllegalArgumentException $i$a$RequireCollectionLikeSerializer$readAll$1 = new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        throw $i$a$RequireCollectionLikeSerializer$readAll$1;
    }

    protected void readElement(CompositeDecoder decoder, int index, Builder builder, boolean checkIndex) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        final int i = index;
        insert(builder, i, CompositeDecoder.DefaultImpls.decodeSerializableElement$default(decoder, getDescriptor(), i, (DeserializationStrategy)this.elementSerializer, 0, 8, 0));
    }

    public void serialize(Encoder encoder, Collection value) {
        int index;
        SerialDescriptor descriptor;
        KSerializer kSerializer;
        Object next;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int collectionSize = collectionSize(value);
        final SerialDescriptor descriptor2 = getDescriptor();
        final int i = 0;
        final CompositeEncoder beginCollection = encoder.beginCollection(descriptor2, collectionSize);
        final int i2 = 0;
        index = 0;
        while (index < collectionSize) {
            beginCollection.encodeSerializableElement(getDescriptor(), index, (SerializationStrategy)CollectionLikeSerializer.access$getElementSerializer$p(this), collectionIterator(value).next());
            index++;
        }
        beginCollection.endStructure(descriptor2);
    }
}
