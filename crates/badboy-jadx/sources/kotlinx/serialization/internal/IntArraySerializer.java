package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Á\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\u0008\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u000c\u0010\u0008\u001a\u00020\u0004*\u00020\u0002H\u0014J\u000c\u0010\t\u001a\u00020\u0005*\u00020\u0002H\u0014J\u0008\u0010\n\u001a\u00020\u0002H\u0014J(\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J \u0010\u0013\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004H\u0014¨\u0006\u0018", d2 = {"Lkotlinx/serialization/internal/IntArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "", "Lkotlinx/serialization/internal/IntArrayBuilder;", "<init>", "()V", "collectionSize", "toBuilder", "empty", "readElement", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "builder", "checkIndex", "", "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", "content", "size", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IntArraySerializer extends kotlinx.serialization.internal.PrimitiveArraySerializer<Integer, int[], kotlinx.serialization.internal.IntArrayBuilder> implements KSerializer<int[]> {

    public static final kotlinx.serialization.internal.IntArraySerializer INSTANCE;
    static {
        IntArraySerializer intArraySerializer = new IntArraySerializer();
        IntArraySerializer.INSTANCE = intArraySerializer;
    }

    private IntArraySerializer() {
        super(BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE));
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public int collectionSize(Object $this$collectionSize) {
        return collectionSize((int[])$this$collectionSize);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected int collectionSize(int[] $this$collectionSize) {
        Intrinsics.checkNotNullParameter($this$collectionSize, "<this>");
        return $this$collectionSize.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public Object empty() {
        return empty();
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected int[] empty() {
        return new int[0];
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void readElement(CompositeDecoder decoder, int index, Object builder, boolean checkIndex) {
        readElement(decoder, index, (IntArrayBuilder)builder, checkIndex);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected void readElement(CompositeDecoder decoder, int index, kotlinx.serialization.internal.IntArrayBuilder builder, boolean checkIndex) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.append$kotlinx_serialization_core(decoder.decodeIntElement(getDescriptor(), index));
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void readElement(CompositeDecoder decoder, int index, kotlinx.serialization.internal.PrimitiveArrayBuilder builder, boolean checkIndex) {
        readElement(decoder, index, (IntArrayBuilder)builder, checkIndex);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public Object toBuilder(Object $this$toBuilder) {
        return toBuilder((int[])$this$toBuilder);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected kotlinx.serialization.internal.IntArrayBuilder toBuilder(int[] $this$toBuilder) {
        Intrinsics.checkNotNullParameter($this$toBuilder, "<this>");
        IntArrayBuilder intArrayBuilder = new IntArrayBuilder($this$toBuilder);
        return intArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void writeContent(CompositeEncoder encoder, Object content, int size) {
        writeContent(encoder, (int[])content, size);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected void writeContent(CompositeEncoder encoder, int[] content, int size) {
        int i2;
        kotlinx.serialization.descriptors.SerialDescriptor descriptor;
        int i;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        i2 = 0;
        while (i2 < size) {
            encoder.encodeIntElement(getDescriptor(), i2, content[i2]);
            i2++;
        }
    }
}
