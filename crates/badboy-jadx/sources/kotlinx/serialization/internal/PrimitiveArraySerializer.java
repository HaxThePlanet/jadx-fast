package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010(\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008!\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u0002*\u000e\u0008\u0002\u0010\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B\u0017\u0008\u0000\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\u0008\u0008\u0010\tJ\u0011\u0010\u000e\u001a\u00020\u000f*\u00028\u0002H\u0004¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u00028\u0001*\u00028\u0002H\u0004¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u0014*\u00028\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0004¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0018*\u00028\u0001H\u0004¢\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\u00020\u0014*\u00028\u00022\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u001dJ\r\u0010\u001e\u001a\u00028\u0002H\u0004¢\u0006\u0002\u0010\u001fJ\r\u0010 \u001a\u00028\u0001H$¢\u0006\u0002\u0010!J-\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00028\u00022\u0006\u0010%\u001a\u00020&H$¢\u0006\u0002\u0010'J%\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00020\u000fH$¢\u0006\u0002\u0010,J\u001b\u0010-\u001a\u00020\u00142\u0006\u0010)\u001a\u00020.2\u0006\u0010/\u001a\u00028\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00028\u00012\u0006\u0010#\u001a\u000202¢\u0006\u0002\u00103R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u00064", d2 = {"Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Element", "Array", "Builder", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "primitiveSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builderSize", "", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)I", "toResult", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)Ljava/lang/Object;", "checkCapacity", "", "size", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;I)V", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "insert", "index", "element", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;ILjava/lang/Object;)V", "builder", "()Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "empty", "()Ljava/lang/Object;", "readElement", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/PrimitiveArrayBuilder;Z)V", "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", "content", "(Lkotlinx/serialization/encoding/CompositeEncoder;Ljava/lang/Object;I)V", "serialize", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PrimitiveArraySerializer<Element, Array, Builder extends kotlinx.serialization.internal.PrimitiveArrayBuilder<Array>>  extends kotlinx.serialization.internal.CollectionLikeSerializer<Element, Array, Builder> {

    private final SerialDescriptor descriptor;
    public PrimitiveArraySerializer(KSerializer<Element> primitiveSerializer) {
        Intrinsics.checkNotNullParameter(primitiveSerializer, "primitiveSerializer");
        super(primitiveSerializer, 0);
        PrimitiveArrayDescriptor primitiveArrayDescriptor = new PrimitiveArrayDescriptor(primitiveSerializer.getDescriptor());
        this.descriptor = (SerialDescriptor)primitiveArrayDescriptor;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public Object builder() {
        return builder();
    }

    protected final Builder builder() {
        return (PrimitiveArrayBuilder)toBuilder(empty());
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public int builderSize(Object $this$builderSize) {
        return builderSize((PrimitiveArrayBuilder)$this$builderSize);
    }

    protected final int builderSize(Builder $this$builderSize) {
        Intrinsics.checkNotNullParameter($this$builderSize, "<this>");
        return $this$builderSize.getPosition$kotlinx_serialization_core();
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public void checkCapacity(Object $this$checkCapacity, int size) {
        checkCapacity((PrimitiveArrayBuilder)$this$checkCapacity, size);
    }

    protected final void checkCapacity(Builder $this$checkCapacity, int size) {
        Intrinsics.checkNotNullParameter($this$checkCapacity, "<this>");
        $this$checkCapacity.ensureCapacity$kotlinx_serialization_core(size);
    }

    protected final Iterator<Element> collectionIterator(Array $this$collectionIterator) {
        IllegalStateException illegalStateException = new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
        throw illegalStateException;
    }

    public final Array deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return merge(decoder, 0);
    }

    protected abstract Array empty();

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public void insert(Object $this$insert, int index, Object element) {
        insert((PrimitiveArrayBuilder)$this$insert, index, element);
    }

    protected final void insert(Builder $this$insert, int index, Element element) {
        Intrinsics.checkNotNullParameter($this$insert, "<this>");
        IllegalStateException illegalStateException = new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
        throw illegalStateException;
    }

    protected abstract void readElement(CompositeDecoder compositeDecoder, int i2, Builder builder3, boolean z4);

    public final void serialize(Encoder encoder, Array value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int collectionSize = collectionSize(value);
        final SerialDescriptor descriptor = this.descriptor;
        final int i = 0;
        final CompositeEncoder beginCollection = encoder.beginCollection(descriptor, collectionSize);
        final int i2 = 0;
        writeContent(beginCollection, value, collectionSize);
        beginCollection.endStructure(descriptor);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public Object toResult(Object $this$toResult) {
        return toResult((PrimitiveArrayBuilder)$this$toResult);
    }

    protected final Array toResult(Builder $this$toResult) {
        Intrinsics.checkNotNullParameter($this$toResult, "<this>");
        return $this$toResult.build$kotlinx_serialization_core();
    }

    protected abstract void writeContent(CompositeEncoder compositeEncoder, Array array2, int i3);
}
