package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Á\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\u0008\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u000c\u0010\u0008\u001a\u00020\t*\u00020\u0002H\u0014J\u000c\u0010\n\u001a\u00020\u0005*\u00020\u0002H\u0014J\u0008\u0010\u000b\u001a\u00020\u0002H\u0014J(\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J \u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\tH\u0014¨\u0006\u0019", d2 = {"Lkotlinx/serialization/internal/FloatArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "", "Lkotlinx/serialization/internal/FloatArrayBuilder;", "<init>", "()V", "collectionSize", "", "toBuilder", "empty", "readElement", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "builder", "checkIndex", "", "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", "content", "size", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatArraySerializer extends kotlinx.serialization.internal.PrimitiveArraySerializer<Float, float[], kotlinx.serialization.internal.FloatArrayBuilder> implements KSerializer<float[]> {

    public static final kotlinx.serialization.internal.FloatArraySerializer INSTANCE;
    static {
        FloatArraySerializer floatArraySerializer = new FloatArraySerializer();
        FloatArraySerializer.INSTANCE = floatArraySerializer;
    }

    private FloatArraySerializer() {
        super(BuiltinSerializersKt.serializer(FloatCompanionObject.INSTANCE));
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public int collectionSize(Object $this$collectionSize) {
        return collectionSize((float[])$this$collectionSize);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected int collectionSize(float[] $this$collectionSize) {
        Intrinsics.checkNotNullParameter($this$collectionSize, "<this>");
        return $this$collectionSize.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public Object empty() {
        return empty();
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected float[] empty() {
        return new float[0];
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void readElement(CompositeDecoder decoder, int index, Object builder, boolean checkIndex) {
        readElement(decoder, index, (FloatArrayBuilder)builder, checkIndex);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected void readElement(CompositeDecoder decoder, int index, kotlinx.serialization.internal.FloatArrayBuilder builder, boolean checkIndex) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.append$kotlinx_serialization_core(decoder.decodeFloatElement(getDescriptor(), index));
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void readElement(CompositeDecoder decoder, int index, kotlinx.serialization.internal.PrimitiveArrayBuilder builder, boolean checkIndex) {
        readElement(decoder, index, (FloatArrayBuilder)builder, checkIndex);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public Object toBuilder(Object $this$toBuilder) {
        return toBuilder((float[])$this$toBuilder);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected kotlinx.serialization.internal.FloatArrayBuilder toBuilder(float[] $this$toBuilder) {
        Intrinsics.checkNotNullParameter($this$toBuilder, "<this>");
        FloatArrayBuilder floatArrayBuilder = new FloatArrayBuilder($this$toBuilder);
        return floatArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void writeContent(CompositeEncoder encoder, Object content, int size) {
        writeContent(encoder, (float[])content, size);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected void writeContent(CompositeEncoder encoder, float[] content, int size) {
        int i;
        kotlinx.serialization.descriptors.SerialDescriptor descriptor;
        int i2;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        i = 0;
        while (i < size) {
            encoder.encodeFloatElement(getDescriptor(), i, content[i]);
            i++;
        }
    }
}
