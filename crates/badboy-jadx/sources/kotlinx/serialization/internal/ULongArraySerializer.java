package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Á\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\u0008\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0013\u0010\u0008\u001a\u00020\t*\u00020\u0002H\u0014¢\u0006\u0004\u0008\n\u0010\u000bJ\u0013\u0010\u000c\u001a\u00020\u0005*\u00020\u0002H\u0014¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0014¢\u0006\u0004\u0008\u0010\u0010\u0011J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J'\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\tH\u0014¢\u0006\u0004\u0008\u001f\u0010 ¨\u0006!", d2 = {"Lkotlinx/serialization/internal/ULongArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/ULongArray;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlin/ULong;", "Lkotlinx/serialization/internal/ULongArrayBuilder;", "<init>", "()V", "collectionSize", "", "collectionSize-QwZRm1k", "([J)I", "toBuilder", "toBuilder-QwZRm1k", "([J)Lkotlinx/serialization/internal/ULongArrayBuilder;", "empty", "empty-Y2RjT0g", "()[J", "readElement", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "builder", "checkIndex", "", "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", "content", "size", "writeContent-0q3Fkuo", "(Lkotlinx/serialization/encoding/CompositeEncoder;[JI)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ExperimentalSerializationApi
public final class ULongArraySerializer extends kotlinx.serialization.internal.PrimitiveArraySerializer<ULong, ULongArray, kotlinx.serialization.internal.ULongArrayBuilder> implements KSerializer<ULongArray> {

    public static final kotlinx.serialization.internal.ULongArraySerializer INSTANCE;
    static {
        ULongArraySerializer uLongArraySerializer = new ULongArraySerializer();
        ULongArraySerializer.INSTANCE = uLongArraySerializer;
    }

    private ULongArraySerializer() {
        super(BuiltinSerializersKt.serializer(ULong.Companion));
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public int collectionSize(Object $this$collectionSize) {
        return collectionSize-QwZRm1k((ULongArray)$this$collectionSize.unbox-impl());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected int collectionSize-QwZRm1k(long[] $this$collectionSize_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$collectionSize_u2dQwZRm1k, "$this$collectionSize");
        return ULongArray.getSize-impl($this$collectionSize_u2dQwZRm1k);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public Object empty() {
        return ULongArray.box-impl(empty-Y2RjT0g());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected long[] empty-Y2RjT0g() {
        return ULongArray.constructor-impl(0);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void readElement(CompositeDecoder decoder, int index, Object builder, boolean checkIndex) {
        readElement(decoder, index, (ULongArrayBuilder)builder, checkIndex);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void readElement(CompositeDecoder decoder, int index, kotlinx.serialization.internal.PrimitiveArrayBuilder builder, boolean checkIndex) {
        readElement(decoder, index, (ULongArrayBuilder)builder, checkIndex);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected void readElement(CompositeDecoder decoder, int index, kotlinx.serialization.internal.ULongArrayBuilder builder, boolean checkIndex) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.append-VKZWuLQ$kotlinx_serialization_core(ULong.constructor-impl(decoder.decodeInlineElement(getDescriptor(), index).decodeLong()));
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public Object toBuilder(Object $this$toBuilder) {
        return toBuilder-QwZRm1k((ULongArray)$this$toBuilder.unbox-impl());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected kotlinx.serialization.internal.ULongArrayBuilder toBuilder-QwZRm1k(long[] $this$toBuilder_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$toBuilder_u2dQwZRm1k, "$this$toBuilder");
        ULongArrayBuilder uLongArrayBuilder = new ULongArrayBuilder($this$toBuilder_u2dQwZRm1k, 0);
        return uLongArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public void writeContent(CompositeEncoder encoder, Object content, int size) {
        writeContent-0q3Fkuo(encoder, (ULongArray)content.unbox-impl(), size);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    protected void writeContent-0q3Fkuo(CompositeEncoder encoder, long[] content, int size) {
        int i;
        Encoder encodeInlineElement;
        long l;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        i = 0;
        while (i < size) {
            encoder.encodeInlineElement(getDescriptor(), i).encodeLong(ULongArray.get-s-VKNKU(content, i));
            i++;
        }
    }
}
