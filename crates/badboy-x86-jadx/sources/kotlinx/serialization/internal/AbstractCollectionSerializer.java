package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u0002*\u0004\u0008\u0002\u0010\u00032\u0008\u0012\u0004\u0012\u0002H\u00020\u0004B\t\u0008\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0008*\u00028\u0001H$¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000b*\u00028\u0001H$¢\u0006\u0002\u0010\u000cJ\r\u0010\r\u001a\u00028\u0002H$¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0008*\u00028\u0002H$¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\u00028\u0001*\u00028\u0002H$¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0012\u001a\u00028\u0002*\u00028\u0001H$¢\u0006\u0002\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u0014*\u00028\u00022\u0006\u0010\u0015\u001a\u00020\u0008H$¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u001bJ\u001f\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0002\u0010 J\u0015\u0010!\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020\u00082\u0006\u0010\u001d\u001a\u00020$2\u0006\u0010\r\u001a\u00028\u0002H\u0002¢\u0006\u0002\u0010%J/\u0010&\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00082\u0006\u0010\r\u001a\u00028\u00022\u0008\u0008\u0002\u0010(\u001a\u00020)H$¢\u0006\u0002\u0010*J-\u0010+\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020$2\u0006\u0010\r\u001a\u00028\u00022\u0006\u0010,\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u0008H$¢\u0006\u0002\u0010-\u0082\u0001\u0002./¨\u00060", d2 = {"Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/KSerializer;", "<init>", "()V", "collectionSize", "", "(Ljava/lang/Object;)I", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "builder", "()Ljava/lang/Object;", "builderSize", "toResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "toBuilder", "checkCapacity", "", "size", "(Ljava/lang/Object;I)V", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "merge", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "previous", "(Lkotlinx/serialization/encoding/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "readSize", "Lkotlinx/serialization/encoding/CompositeDecoder;", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;)I", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "readAll", "startIndex", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "Lkotlinx/serialization/internal/MapLikeSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalSerializationApi
public abstract class AbstractCollectionSerializer<Element, Collection, Builder>  implements KSerializer<Collection> {
    public AbstractCollectionSerializer(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public static void readElement$default(kotlinx.serialization.internal.AbstractCollectionSerializer abstractCollectionSerializer, CompositeDecoder compositeDecoder2, int i3, Object object4, boolean z5, int i6, Object object7) {
        int obj4;
        if (object7 != null) {
        } else {
            if (i6 &= 8 != 0) {
                obj4 = 1;
            }
            abstractCollectionSerializer.readElement(compositeDecoder2, i3, object4, obj4);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        throw obj0;
    }

    private final int readSize(CompositeDecoder decoder, Builder builder) {
        int decodeCollectionSize = decoder.decodeCollectionSize(getDescriptor());
        checkCapacity(builder, decodeCollectionSize);
        return decodeCollectionSize;
    }

    protected abstract Builder builder();

    protected abstract int builderSize(Builder builder);

    protected abstract void checkCapacity(Builder builder, int i2);

    protected abstract Iterator<Element> collectionIterator(Collection collection);

    protected abstract int collectionSize(Collection collection);

    public Collection deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return merge(decoder, 0);
    }

    @InternalSerializationApi
    public final Collection merge(Decoder decoder, Collection previous) {
        Object builder;
        boolean decodeSequentially;
        boolean z;
        int i4;
        int i;
        int i3;
        int i2;
        int decodeElementIndex;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (previous != null) {
            if (toBuilder(previous) == null) {
                builder = builder();
            }
        } else {
        }
        final Object obj = builder;
        int builderSize = builderSize(obj);
        final CompositeDecoder beginStructure = decoder.beginStructure(getDescriptor());
        if (beginStructure.decodeSequentially()) {
            readAll(beginStructure, obj, builderSize, readSize(beginStructure, obj));
            z = this;
        }
        beginStructure.endStructure(getDescriptor());
        return toResult(obj);
    }

    protected abstract void readAll(CompositeDecoder compositeDecoder, Builder builder2, int i3, int i4);

    protected abstract void readElement(CompositeDecoder compositeDecoder, int i2, Builder builder3, boolean z4);

    public abstract void serialize(Encoder encoder, Collection collection2);

    protected abstract Builder toBuilder(Collection collection);

    protected abstract Collection toResult(Builder builder);
}
