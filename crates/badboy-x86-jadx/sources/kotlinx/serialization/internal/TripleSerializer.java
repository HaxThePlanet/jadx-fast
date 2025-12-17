package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeDecoder.DefaultImpls;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0001\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u0002*\u0004\u0008\u0002\u0010\u00032\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004B1\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\u0008\t\u0010\nJ*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\u0016J\"\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\"\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u000cX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001b", d2 = {"Lkotlinx/serialization/internal/TripleSerializer;", "A", "B", "C", "Lkotlinx/serialization/KSerializer;", "Lkotlin/Triple;", "aSerializer", "bSerializer", "cSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "decodeSequentially", "composite", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeStructure", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TripleSerializer<A, B, C>  implements KSerializer<Triple<? extends A, ? extends B, ? extends C>> {

    private final KSerializer<A> aSerializer;
    private final KSerializer<B> bSerializer;
    private final KSerializer<C> cSerializer;
    private final SerialDescriptor descriptor;
    public static Unit $r8$lambda$1rMBbyNpoVrPk6COujtyupPSbJ4(kotlinx.serialization.internal.TripleSerializer tripleSerializer, ClassSerialDescriptorBuilder classSerialDescriptorBuilder2) {
        return TripleSerializer.descriptor$lambda$0(tripleSerializer, classSerialDescriptorBuilder2);
    }

    public TripleSerializer(KSerializer<A> aSerializer, KSerializer<B> bSerializer, KSerializer<C> cSerializer) {
        Intrinsics.checkNotNullParameter(aSerializer, "aSerializer");
        Intrinsics.checkNotNullParameter(bSerializer, "bSerializer");
        Intrinsics.checkNotNullParameter(cSerializer, "cSerializer");
        super();
        this.aSerializer = aSerializer;
        this.bSerializer = bSerializer;
        this.cSerializer = cSerializer;
        TripleSerializer$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new TripleSerializer$$ExternalSyntheticLambda0(this);
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlin.Triple", new SerialDescriptor[0], externalSyntheticLambda0);
    }

    private final Triple<A, B, C> decodeSequentially(CompositeDecoder composite) {
        final int i5 = 8;
        final int i6 = 0;
        final int i4 = 0;
        CompositeDecoder compositeDecoder = composite;
        compositeDecoder.endStructure(getDescriptor());
        Triple triple = new Triple(CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, getDescriptor(), 0, (DeserializationStrategy)this.aSerializer, i4, i5, i6), CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, getDescriptor(), 1, (DeserializationStrategy)this.bSerializer, i4, i5, i6), CompositeDecoder.DefaultImpls.decodeSerializableElement$default(compositeDecoder, getDescriptor(), 2, (DeserializationStrategy)this.cSerializer, i4, i5, i6));
        return triple;
    }

    private final Triple<A, B, C> decodeStructure(CompositeDecoder composite) {
        Object a;
        Object b;
        Object c;
        int decodeElementIndex;
        CompositeDecoder composite2;
        SerialDescriptor descriptor;
        int i2;
        KSerializer kSerializer;
        int i3;
        int i;
        int i4;
        CompositeDecoder obj12;
        a = TuplesKt.access$getNULL$p();
        b = TuplesKt.access$getNULL$p();
        c = TuplesKt.access$getNULL$p();
        while (/* condition */) {
            composite2 = obj12;
            a = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite2, getDescriptor(), 0, (DeserializationStrategy)this.aSerializer, 0, 8, 0);
            obj12 = composite2;
            decodeElementIndex = obj12.decodeElementIndex(getDescriptor());
            c = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(obj12, getDescriptor(), 2, (DeserializationStrategy)this.cSerializer, 0, 8, 0);
            composite2 = obj12;
            b = CompositeDecoder.DefaultImpls.decodeSerializableElement$default(composite2, getDescriptor(), 1, (DeserializationStrategy)this.bSerializer, 0, 8, 0);
            obj12 = composite2;
        }
        obj12.endStructure(getDescriptor());
        if (a == TuplesKt.access$getNULL$p()) {
        } else {
            if (b == TuplesKt.access$getNULL$p()) {
            } else {
                if (c == TuplesKt.access$getNULL$p()) {
                } else {
                    obj12 = new Triple(a, b, c);
                    return obj12;
                }
                obj12 = new SerializationException("Element 'third' is missing");
                throw obj12;
            }
            obj12 = new SerializationException("Element 'second' is missing");
            throw obj12;
        }
        obj12 = new SerializationException("Element 'first' is missing");
        throw obj12;
    }

    private static final Unit descriptor$lambda$0(kotlinx.serialization.internal.TripleSerializer this$0, ClassSerialDescriptorBuilder $this$buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        final int i3 = 12;
        final int i4 = 0;
        final int i = 0;
        final int i2 = 0;
        final Object obj = $this$buildClassSerialDescriptor;
        ClassSerialDescriptorBuilder.element$default(obj, "first", this$0.aSerializer.getDescriptor(), i, i2, i3, i4);
        ClassSerialDescriptorBuilder.element$default(obj, "second", this$0.bSerializer.getDescriptor(), i, i2, i3, i4);
        ClassSerialDescriptorBuilder.element$default(obj, "third", this$0.cSerializer.getDescriptor(), i, i2, i3, i4);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.KSerializer
    public Object deserialize(Decoder decoder) {
        return deserialize(decoder);
    }

    public Triple<A, B, C> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        CompositeDecoder beginStructure = decoder.beginStructure(getDescriptor());
        if (beginStructure.decodeSequentially()) {
            return decodeSequentially(beginStructure);
        }
        return decodeStructure(beginStructure);
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Object value) {
        serialize(encoder, (Triple)value);
    }

    public void serialize(Encoder encoder, Triple<? extends A, ? extends B, ? extends C> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        CompositeEncoder beginStructure = encoder.beginStructure(getDescriptor());
        beginStructure.encodeSerializableElement(getDescriptor(), 0, (SerializationStrategy)this.aSerializer, value.getFirst());
        beginStructure.encodeSerializableElement(getDescriptor(), 1, (SerializationStrategy)this.bSerializer, value.getSecond());
        beginStructure.encodeSerializableElement(getDescriptor(), 2, (SerializationStrategy)this.cSerializer, value.getThird());
        beginStructure.endStructure(getDescriptor());
    }
}
