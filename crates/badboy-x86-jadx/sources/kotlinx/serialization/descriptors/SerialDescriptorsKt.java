package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.internal.ArrayListClassDesc;
import kotlinx.serialization.internal.HashMapClassDesc;
import kotlinx.serialization.internal.HashSetClassDesc;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.internal.SerialDescriptorForNullable;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001aB\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00010\u0005\"\u00020\u00012\u0019\u0008\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n¢\u0006\u0002\u0010\u000b\u001a\u0016\u0010\u000c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e\u001a\u0018\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001aL\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00122\u0012\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00010\u0005\"\u00020\u00012\u0019\u0008\u0002\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u0001\"\u0006\u0008\u0000\u0010\u0016\u0018\u0001H\u0086\u0008\u001a\u000e\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0010\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u0019\u001a\u00020\u0001\"\u0006\u0008\u0000\u0010\u0016\u0018\u0001H\u0087\u0008\u001a\u0018\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0007\u001a\u0019\u0010\u001b\u001a\u00020\u0001\"\u0006\u0008\u0000\u0010\u001e\u0018\u0001\"\u0006\u0008\u0001\u0010\u001f\u0018\u0001H\u0087\u0008\u001a\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0007\u001a\u0011\u0010 \u001a\u00020\u0001\"\u0006\u0008\u0000\u0010\u0016\u0018\u0001H\u0087\u0008\u001a7\u0010)\u001a\u00020\t\"\u0006\u0008\u0000\u0010\u0016\u0018\u0001*\u00020\u00082\u0006\u0010*\u001a\u00020\u00032\u000e\u0008\u0002\u0010+\u001a\u0008\u0012\u0004\u0012\u00020-0,2\u0008\u0008\u0002\u0010.\u001a\u00020/H\u0086\u0008\"\u001b\u0010!\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u000c\u0012\u0004\u0008\"\u0010#\u001a\u0004\u0008$\u0010%\"\u001e\u0010&\u001a\u00020\u0001*\u00020\u00018FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008'\u0010#\u001a\u0004\u0008(\u0010%¨\u00060", d2 = {"buildClassSerialDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "typeParameters", "", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "PrimitiveSerialDescriptor", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "SerialDescriptor", "original", "buildSerialDescriptor", "Lkotlinx/serialization/descriptors/SerialKind;", "builder", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDescriptor", "T", "type", "Lkotlin/reflect/KType;", "listSerialDescriptor", "elementDescriptor", "mapSerialDescriptor", "keyDescriptor", "valueDescriptor", "K", "V", "setSerialDescriptor", "nullable", "getNullable$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getNullable", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "nonNullOriginal", "getNonNullOriginal$annotations", "getNonNullOriginal", "element", "elementName", "annotations", "", "", "isOptional", "", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SerialDescriptorsKt {
    public static Unit $r8$lambda$KcwXNYp_VkGdSk5URABBgsNIqNM(kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        return SerialDescriptorsKt.buildClassSerialDescriptor$lambda$0(classSerialDescriptorBuilder);
    }

    public static Unit $r8$lambda$QH-VGDYhXxDq3IwMAQnlLobb1dw(kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        return SerialDescriptorsKt.buildSerialDescriptor$lambda$6(classSerialDescriptorBuilder);
    }

    public static final kotlinx.serialization.descriptors.SerialDescriptor PrimitiveSerialDescriptor(String serialName, kotlinx.serialization.descriptors.PrimitiveKind kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (StringsKt.isBlank((CharSequence)serialName)) {
        } else {
            return PrimitivesKt.PrimitiveDescriptorSafe(serialName, kind);
        }
        int i = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Blank serial names are prohibited".toString());
        throw illegalArgumentException;
    }

    @ExperimentalSerializationApi
    public static final kotlinx.serialization.descriptors.SerialDescriptor SerialDescriptor(String serialName, kotlinx.serialization.descriptors.SerialDescriptor original) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(original, "original");
        if (StringsKt.isBlank((CharSequence)serialName)) {
        } else {
            if (kind instanceof PrimitiveKind) {
            } else {
                if (Intrinsics.areEqual(serialName, original.getSerialName())) {
                } else {
                    WrappedSerialDescriptor wrappedSerialDescriptor = new WrappedSerialDescriptor(serialName, original);
                    return (SerialDescriptor)wrappedSerialDescriptor;
                }
                int i2 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder.append("The name of the wrapped descriptor (").append(serialName).append(") cannot be the same as the name of the original descriptor (").append(original.getSerialName()).append(')').toString().toString());
                throw illegalArgumentException3;
            }
            int i = 0;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("For primitive descriptors please use 'PrimitiveSerialDescriptor' instead".toString());
            throw illegalArgumentException;
        }
        int i3 = 0;
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Blank serial names are prohibited".toString());
        throw illegalArgumentException2;
    }

    public static final kotlinx.serialization.descriptors.SerialDescriptor buildClassSerialDescriptor(String serialName, kotlinx.serialization.descriptors.SerialDescriptor[] typeParameters, Function1<? super kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        if (StringsKt.isBlank((CharSequence)serialName)) {
        } else {
            ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
            final kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder cls = classSerialDescriptorBuilder;
            builderAction.invoke(cls);
            SerialDescriptorImpl serialDescriptorImpl = new SerialDescriptorImpl(serialName, (SerialKind)StructureKind.CLASS.INSTANCE, cls.getElementNames$kotlinx_serialization_core().size(), ArraysKt.toList(typeParameters), cls);
            return (SerialDescriptor)serialDescriptorImpl;
        }
        Object serialName2 = serialName;
        int obj7 = 0;
        obj7 = new IllegalArgumentException("Blank serial names are prohibited".toString());
        throw obj7;
    }

    public static kotlinx.serialization.descriptors.SerialDescriptor buildClassSerialDescriptor$default(String string, kotlinx.serialization.descriptors.SerialDescriptor[] serialDescriptor2Arr2, Function1 function13, int i4, Object object5) {
        kotlinx.serialization.descriptors.SerialDescriptorsKt$$ExternalSyntheticLambda0 obj2;
        if (i4 &= 4 != 0) {
            obj2 = new SerialDescriptorsKt$$ExternalSyntheticLambda0();
        }
        return SerialDescriptorsKt.buildClassSerialDescriptor(string, serialDescriptor2Arr2, obj2);
    }

    private static final Unit buildClassSerialDescriptor$lambda$0(kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder <this>) {
        Intrinsics.checkNotNullParameter(<this>, "<this>");
        return Unit.INSTANCE;
    }

    @InternalSerializationApi
    public static final kotlinx.serialization.descriptors.SerialDescriptor buildSerialDescriptor(String serialName, kotlinx.serialization.descriptors.SerialKind kind, kotlinx.serialization.descriptors.SerialDescriptor[] typeParameters, Function1<? super kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (StringsKt.isBlank((CharSequence)serialName)) {
        } else {
            if (Intrinsics.areEqual(kind, StructureKind.CLASS.INSTANCE)) {
            } else {
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
                final kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder cls = classSerialDescriptorBuilder;
                builder.invoke(cls);
                SerialDescriptorImpl serialDescriptorImpl = new SerialDescriptorImpl(serialName, kind, cls.getElementNames$kotlinx_serialization_core().size(), ArraysKt.toList(typeParameters), cls);
                return (SerialDescriptor)serialDescriptorImpl;
            }
            Object serialName2 = serialName;
            Object obj3 = kind;
            int obj7 = 0;
            obj7 = new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
            throw obj7;
        }
        Object serialName3 = serialName;
        Object obj5 = kind;
        obj7 = 0;
        obj7 = new IllegalArgumentException("Blank serial names are prohibited".toString());
        throw obj7;
    }

    public static kotlinx.serialization.descriptors.SerialDescriptor buildSerialDescriptor$default(String string, kotlinx.serialization.descriptors.SerialKind serialKind2, kotlinx.serialization.descriptors.SerialDescriptor[] serialDescriptor3Arr3, Function1 function14, int i5, Object object6) {
        kotlinx.serialization.descriptors.SerialDescriptorsKt$$ExternalSyntheticLambda1 obj3;
        if (i5 &= 8 != 0) {
            obj3 = new SerialDescriptorsKt$$ExternalSyntheticLambda1();
        }
        return SerialDescriptorsKt.buildSerialDescriptor(string, serialKind2, serialDescriptor3Arr3, obj3);
    }

    private static final Unit buildSerialDescriptor$lambda$6(kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder <this>) {
        Intrinsics.checkNotNullParameter(<this>, "<this>");
        return Unit.INSTANCE;
    }

    public static final <T> void element(kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder $this$element, String elementName, List<? extends Annotation> annotations, boolean isOptional) {
        Intrinsics.checkNotNullParameter($this$element, "<this>");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        $this$element.element(elementName, SerializersKt.serializer(0).getDescriptor(), annotations, isOptional);
    }

    public static void element$default(kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder $this$element_u24default, String elementName, List annotations, boolean isOptional, int i5, Object object6) {
        List obj3;
        int obj4;
        if (i5 & 2 != 0) {
            obj3 = CollectionsKt.emptyList();
        }
        if (i5 &= 4 != 0) {
            obj4 = 0;
        }
        Intrinsics.checkNotNullParameter($this$element_u24default, "<this>");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(obj3, "annotations");
        int obj5 = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        $this$element_u24default.element(elementName, SerializersKt.serializer(0).getDescriptor(), obj3, obj4);
    }

    public static final kotlinx.serialization.descriptors.SerialDescriptor getNonNullOriginal(kotlinx.serialization.descriptors.SerialDescriptor $this$nonNullOriginal) {
        Object original$kotlinx_serialization_core;
        Intrinsics.checkNotNullParameter($this$nonNullOriginal, "<this>");
        if ($this$nonNullOriginal instanceof SerialDescriptorForNullable) {
            original$kotlinx_serialization_core = (SerialDescriptorForNullable)$this$nonNullOriginal.getOriginal$kotlinx_serialization_core();
        } else {
            original$kotlinx_serialization_core = $this$nonNullOriginal;
        }
        return original$kotlinx_serialization_core;
    }

    @ExperimentalSerializationApi
    public static void getNonNullOriginal$annotations(kotlinx.serialization.descriptors.SerialDescriptor serialDescriptor) {
    }

    public static final kotlinx.serialization.descriptors.SerialDescriptor getNullable(kotlinx.serialization.descriptors.SerialDescriptor $this$nullable) {
        Intrinsics.checkNotNullParameter($this$nullable, "<this>");
        if ($this$nullable.isNullable()) {
            return $this$nullable;
        }
        SerialDescriptorForNullable serialDescriptorForNullable = new SerialDescriptorForNullable($this$nullable);
        return (SerialDescriptor)serialDescriptorForNullable;
    }

    public static void getNullable$annotations(kotlinx.serialization.descriptors.SerialDescriptor serialDescriptor) {
    }

    @ExperimentalSerializationApi
    public static final <T> kotlinx.serialization.descriptors.SerialDescriptor listSerialDescriptor() {
        final int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return SerialDescriptorsKt.listSerialDescriptor(SerializersKt.serializer(0).getDescriptor());
    }

    @ExperimentalSerializationApi
    public static final kotlinx.serialization.descriptors.SerialDescriptor listSerialDescriptor(kotlinx.serialization.descriptors.SerialDescriptor elementDescriptor) {
        Intrinsics.checkNotNullParameter(elementDescriptor, "elementDescriptor");
        ArrayListClassDesc arrayListClassDesc = new ArrayListClassDesc(elementDescriptor);
        return (SerialDescriptor)arrayListClassDesc;
    }

    @ExperimentalSerializationApi
    public static final <K, V> kotlinx.serialization.descriptors.SerialDescriptor mapSerialDescriptor() {
        final int i = 0;
        final int i2 = 6;
        Intrinsics.reifiedOperationMarker(i2, "K");
        String str2 = "kotlinx.serialization.serializer.simple";
        MagicApiIntrinsics.voidMagicApiCall(str2);
        final int i3 = 0;
        Intrinsics.reifiedOperationMarker(i2, "V");
        MagicApiIntrinsics.voidMagicApiCall(str2);
        return SerialDescriptorsKt.mapSerialDescriptor(SerializersKt.serializer(i3).getDescriptor(), SerializersKt.serializer(i3).getDescriptor());
    }

    @ExperimentalSerializationApi
    public static final kotlinx.serialization.descriptors.SerialDescriptor mapSerialDescriptor(kotlinx.serialization.descriptors.SerialDescriptor keyDescriptor, kotlinx.serialization.descriptors.SerialDescriptor valueDescriptor) {
        Intrinsics.checkNotNullParameter(keyDescriptor, "keyDescriptor");
        Intrinsics.checkNotNullParameter(valueDescriptor, "valueDescriptor");
        HashMapClassDesc hashMapClassDesc = new HashMapClassDesc(keyDescriptor, valueDescriptor);
        return (SerialDescriptor)hashMapClassDesc;
    }

    public static final <T> kotlinx.serialization.descriptors.SerialDescriptor serialDescriptor() {
        final int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return SerializersKt.serializer(0).getDescriptor();
    }

    public static final kotlinx.serialization.descriptors.SerialDescriptor serialDescriptor(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializer(type).getDescriptor();
    }

    @ExperimentalSerializationApi
    public static final <T> kotlinx.serialization.descriptors.SerialDescriptor setSerialDescriptor() {
        final int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return SerialDescriptorsKt.setSerialDescriptor(SerializersKt.serializer(0).getDescriptor());
    }

    @ExperimentalSerializationApi
    public static final kotlinx.serialization.descriptors.SerialDescriptor setSerialDescriptor(kotlinx.serialization.descriptors.SerialDescriptor elementDescriptor) {
        Intrinsics.checkNotNullParameter(elementDescriptor, "elementDescriptor");
        HashSetClassDesc hashSetClassDesc = new HashSetClassDesc(elementDescriptor);
        return (SerialDescriptor)hashSetClassDesc;
    }
}
