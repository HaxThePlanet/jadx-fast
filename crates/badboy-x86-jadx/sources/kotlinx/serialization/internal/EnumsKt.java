package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0010\u001b\n\u0002\u0008\u0006\u001a9\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0008\u001a_\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u00070\u0007H\u0001¢\u0006\u0002\u0010\r\u001ao\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0014\u0010\u000f\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u00070\u00072\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u0007H\u0001¢\u0006\u0002\u0010\u0011¨\u0006\u0012", d2 = {"createSimpleEnumSerializer", "Lkotlinx/serialization/KSerializer;", "T", "", "serialName", "", "values", "", "(Ljava/lang/String;[Ljava/lang/Enum;)Lkotlinx/serialization/KSerializer;", "createMarkedEnumSerializer", "names", "annotations", "", "(Ljava/lang/String;[Ljava/lang/Enum;[Ljava/lang/String;[[Ljava/lang/annotation/Annotation;)Lkotlinx/serialization/KSerializer;", "createAnnotatedEnumSerializer", "entryAnnotations", "classAnnotations", "(Ljava/lang/String;[Ljava/lang/Enum;[Ljava/lang/String;[[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EnumsKt {
    public static final <T extends Enum<T>> KSerializer<T> createAnnotatedEnumSerializer(String serialName, T[] values, String[] names, Annotation[][] entryAnnotations, Annotation[] classAnnotations) {
        Object obj7;
        Object orNull;
        Object obj5;
        int i2;
        int length2;
        Object[] objArr;
        Object $this$forEach$iv;
        int $this$forEachIndexed$iv;
        int i3;
        int length;
        int i8;
        int i;
        Object obj6;
        int i7;
        Object obj2;
        int i4;
        Object obj;
        int i5;
        Object orNull2;
        Object obj8;
        Object obj3;
        Object obj4;
        int i6;
        Object $this$forEach$iv2;
        final Object obj9 = serialName;
        final Object obj10 = values;
        Intrinsics.checkNotNullParameter(obj9, "serialName");
        Intrinsics.checkNotNullParameter(obj10, "values");
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(entryAnnotations, "entryAnnotations");
        EnumDescriptor enumDescriptor2 = new EnumDescriptor(obj9, obj10.length);
        if (classAnnotations != null) {
            objArr = classAnnotations;
            i3 = 0;
            i = 0;
            while (i < objArr.length) {
                i4 = 0;
                enumDescriptor2.pushClassAnnotation(objArr[i]);
                i++;
            }
        }
        int i10 = 0;
        i8 = 0;
        i7 = 0;
        while (i7 < $this$forEach$iv.length) {
            i5 = 0;
            if ((String)ArraysKt.getOrNull(obj7, i8) == null) {
            }
            PluginGeneratedSerialDescriptor.addElement$default((PluginGeneratedSerialDescriptor)enumDescriptor2, orNull2, false, 2, 0);
            orNull = ArraysKt.getOrNull((Object[])entryAnnotations, i8);
            if ((Annotation[])orNull != null) {
            }
            i7++;
            obj7 = names;
            obj5 = entryAnnotations;
            i8 = i4;
            $this$forEach$iv = obj8;
            i2 = 0;
            while ($this$forEachIndexed$iv < orNull.length) {
                i6 = 0;
                enumDescriptor2.pushAnnotation(orNull[$this$forEachIndexed$iv]);
                $this$forEachIndexed$iv++;
                orNull = $this$forEach$iv2;
            }
            $this$forEach$iv2 = orNull;
            i6 = 0;
            enumDescriptor2.pushAnnotation(orNull[$this$forEachIndexed$iv]);
            $this$forEachIndexed$iv++;
            orNull = $this$forEach$iv2;
            orNull2 = $this$forEach$iv[i7].name();
        }
        EnumSerializer enumSerializer = new EnumSerializer(obj9, obj10, (SerialDescriptor)enumDescriptor2);
        return (KSerializer)enumSerializer;
    }

    public static final <T extends Enum<T>> KSerializer<T> createMarkedEnumSerializer(String serialName, T[] values, String[] names, Annotation[][] annotations) {
        Object obj6;
        Object orNull2;
        Object obj2;
        int i2;
        Object obj;
        int $this$forEachIndexed$iv;
        int i4;
        kotlinx.serialization.internal.EnumDescriptor length;
        int i3;
        Object obj4;
        int i6;
        Object obj7;
        int i;
        Object orNull;
        Object obj8;
        Object obj3;
        Object obj5;
        int i5;
        Object $this$forEach$iv;
        final Object obj9 = serialName;
        final Object obj10 = values;
        Intrinsics.checkNotNullParameter(obj9, "serialName");
        Intrinsics.checkNotNullParameter(obj10, "values");
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        EnumDescriptor enumDescriptor2 = new EnumDescriptor(obj9, obj10.length);
        final int i8 = 0;
        i4 = 0;
        i3 = 0;
        while (i3 < obj.length) {
            i = 0;
            if ((String)ArraysKt.getOrNull(obj6, i4) == null) {
            }
            PluginGeneratedSerialDescriptor.addElement$default((PluginGeneratedSerialDescriptor)enumDescriptor2, orNull, false, 2, 0);
            orNull2 = ArraysKt.getOrNull((Object[])annotations, i4);
            if ((Annotation[])orNull2 != null) {
            }
            i3++;
            obj6 = names;
            obj2 = annotations;
            i4 = i6;
            obj = obj8;
            i2 = 0;
            while ($this$forEachIndexed$iv < orNull2.length) {
                i5 = 0;
                enumDescriptor2.pushAnnotation(orNull2[$this$forEachIndexed$iv]);
                $this$forEachIndexed$iv++;
                orNull2 = $this$forEach$iv;
            }
            $this$forEach$iv = orNull2;
            i5 = 0;
            enumDescriptor2.pushAnnotation(orNull2[$this$forEachIndexed$iv]);
            $this$forEachIndexed$iv++;
            orNull2 = $this$forEach$iv;
            orNull = obj[i3].name();
        }
        EnumSerializer enumSerializer = new EnumSerializer(obj9, obj10, (SerialDescriptor)enumDescriptor2);
        return (KSerializer)enumSerializer;
    }

    public static final <T extends Enum<T>> KSerializer<T> createSimpleEnumSerializer(String serialName, T[] values) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        EnumSerializer enumSerializer = new EnumSerializer(serialName, values);
        return (KSerializer)enumSerializer;
    }
}
