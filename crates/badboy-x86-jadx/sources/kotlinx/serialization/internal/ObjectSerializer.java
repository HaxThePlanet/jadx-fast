package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind.OBJECT;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0001\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\u0008\u0007\u0010\u0008B'\u0008\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\u0008\u0007\u0010\u000cJ\u001d\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010\u001fR\u0010\u0010\u0006\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006 ", d2 = {"Lkotlinx/serialization/internal/ObjectSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "objectInstance", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "classAnnotations", "", "", "(Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/annotation/Annotation;)V", "Ljava/lang/Object;", "_annotations", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObjectSerializer<T>  implements KSerializer<T> {

    private List<? extends Annotation> _annotations;
    private final Lazy descriptor$delegate;
    private final T objectInstance;
    public static Unit $r8$lambda$7oDpqf8KMk_ucBPwlicAd7WQqg4(kotlinx.serialization.internal.ObjectSerializer objectSerializer, ClassSerialDescriptorBuilder classSerialDescriptorBuilder2) {
        return ObjectSerializer.descriptor_delegate$lambda$1$lambda$0(objectSerializer, classSerialDescriptorBuilder2);
    }

    public static SerialDescriptor $r8$lambda$uWbFZ4C3GF6_y2c_O5ODy-kpi44(String string, kotlinx.serialization.internal.ObjectSerializer objectSerializer2) {
        return ObjectSerializer.descriptor_delegate$lambda$1(string, objectSerializer2);
    }

    public ObjectSerializer(String serialName, T objectInstance) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(objectInstance, "objectInstance");
        super();
        this.objectInstance = objectInstance;
        this._annotations = CollectionsKt.emptyList();
        ObjectSerializer$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ObjectSerializer$$ExternalSyntheticLambda0(serialName, this);
        this.descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, externalSyntheticLambda0);
    }

    public ObjectSerializer(String serialName, T objectInstance, Annotation[] classAnnotations) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(objectInstance, "objectInstance");
        Intrinsics.checkNotNullParameter(classAnnotations, "classAnnotations");
        super(serialName, objectInstance);
        this._annotations = ArraysKt.asList(classAnnotations);
    }

    private static final SerialDescriptor descriptor_delegate$lambda$1(String $serialName, kotlinx.serialization.internal.ObjectSerializer this$0) {
        ObjectSerializer$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ObjectSerializer$$ExternalSyntheticLambda1(this$0);
        return SerialDescriptorsKt.buildSerialDescriptor($serialName, (SerialKind)StructureKind.OBJECT.INSTANCE, new SerialDescriptor[0], externalSyntheticLambda1);
    }

    private static final Unit descriptor_delegate$lambda$1$lambda$0(kotlinx.serialization.internal.ObjectSerializer this$0, ClassSerialDescriptorBuilder $this$buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildSerialDescriptor, "$this$buildSerialDescriptor");
        $this$buildSerialDescriptor.setAnnotations(this$0._annotations);
        return Unit.INSTANCE;
    }

    public T deserialize(Decoder decoder) {
        boolean decodeSequentially;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        final int i2 = 0;
        final CompositeDecoder beginStructure = decoder.beginStructure(descriptor);
        CompositeDecoder compositeDecoder = beginStructure;
        final int i3 = 0;
        if (compositeDecoder.decodeSequentially()) {
            Unit $this$deserialize_u24lambda_u242 = Unit.INSTANCE;
            beginStructure.endStructure(descriptor);
            return this.objectInstance;
        } else {
            decodeSequentially = compositeDecoder.decodeElementIndex(getDescriptor());
            if (decodeSequentially != -1) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        SerializationException serializationException = new SerializationException(stringBuilder.append("Unexpected index ").append(decodeSequentially).toString());
        throw serializationException;
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor)this.descriptor$delegate.getValue();
    }

    public void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }
}
