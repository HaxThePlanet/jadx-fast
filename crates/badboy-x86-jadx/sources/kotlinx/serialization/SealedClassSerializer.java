package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind.SEALED;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u001b\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003BI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\u0008\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u000b0\t¢\u0006\u0004\u0008\u000c\u0010\rBY\u0008\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\u0008\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u000b0\t\u0012\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0004\u0008\u000c\u0010\u0010J\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0008\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0016J%\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010'R\u001a\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0019\u0010\u001a\u001a\u0004\u0008\u0017\u0010\u0018R*\u0010\u001b\u001a\u001e\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u0007\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u000b0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u000b0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006(", d2 = {"Lkotlinx/serialization/SealedClassSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "serialName", "", "baseClass", "Lkotlin/reflect/KClass;", "subclasses", "", "subclassSerializers", "Lkotlinx/serialization/KSerializer;", "<init>", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)V", "classAnnotations", "", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;[Ljava/lang/annotation/Annotation;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "_annotations", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "class2Serializer", "", "serialName2Serializer", "findPolymorphicSerializerOrNull", "Lkotlinx/serialization/DeserializationStrategy;", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "klassName", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalSerializationApi
public final class SealedClassSerializer<T>  extends AbstractPolymorphicSerializer<T> {

    private List<? extends Annotation> _annotations;
    private final KClass<T> baseClass;
    private final Map<KClass<? extends T>, kotlinx.serialization.KSerializer<? extends T>> class2Serializer;
    private final Lazy descriptor$delegate;
    private final Map<String, kotlinx.serialization.KSerializer<? extends T>> serialName2Serializer;
    public static Unit $r8$lambda$RhlDvjNBsgYtHZ5BgYZYP3NM3YY(kotlinx.serialization.SealedClassSerializer sealedClassSerializer, ClassSerialDescriptorBuilder classSerialDescriptorBuilder2) {
        return SealedClassSerializer.descriptor_delegate$lambda$3$lambda$2(sealedClassSerializer, classSerialDescriptorBuilder2);
    }

    public static Unit $r8$lambda$TNYh9oP-NdclhSLLjpe7-FslTp4(kotlinx.serialization.SealedClassSerializer sealedClassSerializer, ClassSerialDescriptorBuilder classSerialDescriptorBuilder2) {
        return SealedClassSerializer.descriptor_delegate$lambda$3$lambda$2$lambda$1(sealedClassSerializer, classSerialDescriptorBuilder2);
    }

    public static SerialDescriptor $r8$lambda$jeadrG2hLGnz6PxrhJ9SZBHdtXw(String string, kotlinx.serialization.SealedClassSerializer sealedClassSerializer2) {
        return SealedClassSerializer.descriptor_delegate$lambda$3(string, sealedClassSerializer2);
    }

    public SealedClassSerializer(String serialName, KClass<T> baseClass, KClass<? extends T>[] subclasses, kotlinx.serialization.KSerializer<? extends T>[] subclassSerializers) {
        Object obj3;
        Iterator sourceIterator;
        Object next;
        boolean it$iv$iv;
        Object keyOf;
        Object obj;
        Object value;
        Object obj2;
        int i;
        final Object obj4 = this;
        obj3 = serialName;
        Object obj6 = baseClass;
        Object obj7 = subclasses;
        final Object obj8 = subclassSerializers;
        Intrinsics.checkNotNullParameter(obj3, "serialName");
        Intrinsics.checkNotNullParameter(obj6, "baseClass");
        Intrinsics.checkNotNullParameter(obj7, "subclasses");
        Intrinsics.checkNotNullParameter(obj8, "subclassSerializers");
        super();
        obj4.baseClass = obj6;
        obj4._annotations = CollectionsKt.emptyList();
        SealedClassSerializer$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SealedClassSerializer$$ExternalSyntheticLambda0(obj3, obj4);
        obj4.descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, externalSyntheticLambda0);
        if (obj7.length != obj8.length) {
        } else {
            obj4.class2Serializer = MapsKt.toMap((Iterable)ArraysKt.zip(subclasses, subclassSerializers));
            int i6 = 0;
            SealedClassSerializer.special$$inlined.groupingBy.1 anon = new SealedClassSerializer.special$$inlined.groupingBy.1((Iterable)obj4.class2Serializer.entrySet());
            int i4 = 0;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            kotlinx.serialization.SealedClassSerializer.special$$inlined.groupingBy.1 cls = anon;
            int i8 = 0;
            sourceIterator = cls.sourceIterator();
            while (sourceIterator.hasNext()) {
                next = sourceIterator.next();
                keyOf = cls.keyOf(next);
                obj = (Map)linkedHashMap2.get(keyOf);
                if (obj == null) {
                }
                value = next;
                obj2 = obj;
                i = 0;
                linkedHashMap2.put(keyOf, (Map.Entry)value);
                obj3 = serialName;
                linkedHashMap2.containsKey(keyOf);
            }
            int i2 = 0;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
            int i5 = 0;
            int i7 = 0;
            Iterator iterator = (Iterable)linkedHashMap2.entrySet().iterator();
            for (Object sourceIterator : iterator) {
                int i9 = 0;
                obj = 0;
                (Map)linkedHashMap.put((Map.Entry)sourceIterator.getKey(), (KSerializer)(Map.Entry)(Map.Entry)sourceIterator.getValue().getValue());
            }
            obj4.serialName2Serializer = linkedHashMap;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.append("All subclasses of sealed class ").append(obj4.getBaseClass().getSimpleName()).append(" should be marked @Serializable").toString());
        throw illegalArgumentException;
    }

    public SealedClassSerializer(String serialName, KClass<T> baseClass, KClass<? extends T>[] subclasses, kotlinx.serialization.KSerializer<? extends T>[] subclassSerializers, Annotation[] classAnnotations) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(subclasses, "subclasses");
        Intrinsics.checkNotNullParameter(subclassSerializers, "subclassSerializers");
        Intrinsics.checkNotNullParameter(classAnnotations, "classAnnotations");
        super(serialName, baseClass, subclasses, subclassSerializers);
        this._annotations = ArraysKt.asList(classAnnotations);
    }

    private static final SerialDescriptor descriptor_delegate$lambda$3(String $serialName, kotlinx.serialization.SealedClassSerializer this$0) {
        SealedClassSerializer$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new SealedClassSerializer$$ExternalSyntheticLambda1(this$0);
        return SerialDescriptorsKt.buildSerialDescriptor($serialName, (SerialKind)PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], externalSyntheticLambda1);
    }

    private static final Unit descriptor_delegate$lambda$3$lambda$2(kotlinx.serialization.SealedClassSerializer this$0, ClassSerialDescriptorBuilder $this$buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildSerialDescriptor, "$this$buildSerialDescriptor");
        final int i6 = 12;
        final int i7 = 0;
        final int i5 = 0;
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "type", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), 0, i5, i6, i7);
        StringBuilder stringBuilder = new StringBuilder();
        SealedClassSerializer$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new SealedClassSerializer$$ExternalSyntheticLambda2(this$0);
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "value", SerialDescriptorsKt.buildSerialDescriptor(stringBuilder.append("kotlinx.serialization.Sealed<").append(this$0.getBaseClass().getSimpleName()).append('>').toString(), (SerialKind)SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], externalSyntheticLambda2), 0, i5, i6, i7);
        $this$buildSerialDescriptor.setAnnotations(this$0._annotations);
        return Unit.INSTANCE;
    }

    private static final Unit descriptor_delegate$lambda$3$lambda$2$lambda$1(kotlinx.serialization.SealedClassSerializer this$0, ClassSerialDescriptorBuilder $this$buildSerialDescriptor) {
        Object next;
        int i2;
        Object value;
        Object obj2;
        Object obj;
        SerialDescriptor descriptor;
        int i4;
        int i5;
        int i;
        int i3;
        Intrinsics.checkNotNullParameter($this$buildSerialDescriptor, "$this$buildSerialDescriptor");
        final int i6 = 0;
        Iterator iterator = this$0.serialName2Serializer.entrySet().iterator();
        for (Map.Entry next : iterator) {
            i2 = 0;
            ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, (String)next.getKey(), (KSerializer)next.getValue().getDescriptor(), 0, false, 12, 0);
        }
        Object $this$buildSerialDescriptor2 = $this$buildSerialDescriptor;
        return Unit.INSTANCE;
    }

    public kotlinx.serialization.DeserializationStrategy<T> findPolymorphicSerializerOrNull(CompositeDecoder decoder, String klassName) {
        Object polymorphicSerializerOrNull;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if ((KSerializer)this.serialName2Serializer.get(klassName) != null) {
        } else {
            polymorphicSerializerOrNull = super.findPolymorphicSerializerOrNull(decoder, klassName);
        }
        return polymorphicSerializerOrNull;
    }

    public kotlinx.serialization.SerializationStrategy<T> findPolymorphicSerializerOrNull(Encoder encoder, T value) {
        Object polymorphicSerializerOrNull;
        KClass orCreateKotlinClass;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        if ((KSerializer)this.class2Serializer.get(Reflection.getOrCreateKotlinClass(value.getClass())) != null) {
        } else {
            polymorphicSerializerOrNull = super.findPolymorphicSerializerOrNull(encoder, value);
        }
        if (polymorphicSerializerOrNull != null) {
            orCreateKotlinClass = 0;
        } else {
            polymorphicSerializerOrNull = 0;
        }
        return polymorphicSerializerOrNull;
    }

    public KClass<T> getBaseClass() {
        return this.baseClass;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor)this.descriptor$delegate.getValue();
    }
}
