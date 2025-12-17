package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aA\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0007H\u0080\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0008\u001a>\u0010\t\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0019\u0008\u0004\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00010\u000c¢\u0006\u0002\u0008\u000eH\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0010", d2 = {"decodeIfNullable", "T", "", "Lkotlinx/serialization/encoding/Decoder;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "block", "Lkotlin/Function0;", "(Lkotlinx/serialization/encoding/Decoder;Lkotlinx/serialization/DeserializationStrategy;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "decodeStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlin/Function1;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/encoding/Decoder;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DecodingKt {
    public static final <T> T decodeIfNullable(kotlinx.serialization.encoding.Decoder $this$decodeIfNullable, DeserializationStrategy<? extends T> deserializer, Function0<? extends T> block) {
        Object decodeNull;
        boolean decodeNotNullMark;
        Intrinsics.checkNotNullParameter($this$decodeIfNullable, "<this>");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(block, "block");
        int i = 0;
        if (!deserializer.getDescriptor().isNullable()) {
            if ($this$decodeIfNullable.decodeNotNullMark()) {
                decodeNull = block.invoke();
            } else {
                decodeNull = $this$decodeIfNullable.decodeNull();
            }
        } else {
        }
        return decodeNull;
    }

    public static final <T> T decodeStructure(kotlinx.serialization.encoding.Decoder $this$decodeStructure, SerialDescriptor descriptor, Function1<? super kotlinx.serialization.encoding.CompositeDecoder, ? extends T> block) {
        Intrinsics.checkNotNullParameter($this$decodeStructure, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        int i = 0;
        final kotlinx.serialization.encoding.CompositeDecoder beginStructure = $this$decodeStructure.beginStructure(descriptor);
        beginStructure.endStructure(descriptor);
        return block.invoke(beginStructure);
    }
}
