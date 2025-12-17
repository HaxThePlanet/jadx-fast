package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u0008H\u0016J\u0017\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0010H\u0097\u0001J\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0010H\u0097\u0001J\u0011\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0008H\u0097\u0001J\u0011\u0010\u0019\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u0010H\u0097\u0001J\u0011\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\u0015\u001a\u00020\u0010H\u0097\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001a\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00138VX\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010 R\u0014\u0010!\u001a\u00020\u000c8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u0014\u0010#\u001a\u00020\u000c8VX\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008#\u0010\"R\u0014\u0010$\u001a\u00020%8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008&\u0010'¨\u0006(", d2 = {"Lkotlinx/serialization/descriptors/ContextDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "kClass", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/reflect/KClass;)V", "serialName", "", "getSerialName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "annotations", "getAnnotations", "()Ljava/util/List;", "elementsCount", "getElementsCount", "()I", "isInline", "()Z", "isNullable", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ContextDescriptor implements kotlinx.serialization.descriptors.SerialDescriptor {

    public final KClass<?> kClass;
    private final kotlinx.serialization.descriptors.SerialDescriptor original;
    private final String serialName;
    public ContextDescriptor(kotlinx.serialization.descriptors.SerialDescriptor original, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        super();
        this.original = original;
        this.kClass = kClass;
        StringBuilder stringBuilder = new StringBuilder();
        this.serialName = stringBuilder.append(this.original.getSerialName()).append('<').append(this.kClass.getSimpleName()).append('>').toString();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean equals(Object other) {
        int i2;
        int i;
        boolean equal;
        Object kClass;
        if (other instanceof ContextDescriptor) {
            i2 = other;
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            return 0;
        }
        if (Intrinsics.areEqual(this.original, i2.original) && Intrinsics.areEqual(i2.kClass, this.kClass)) {
            if (Intrinsics.areEqual(i2.kClass, this.kClass)) {
                i = 1;
            }
        }
        return i;
    }

    public List<Annotation> getAnnotations() {
        return this.original.getAnnotations();
    }

    @ExperimentalSerializationApi
    public List<Annotation> getElementAnnotations(int i) {
        return this.original.getElementAnnotations(i);
    }

    @ExperimentalSerializationApi
    public kotlinx.serialization.descriptors.SerialDescriptor getElementDescriptor(int i) {
        return this.original.getElementDescriptor(i);
    }

    @ExperimentalSerializationApi
    public int getElementIndex(String string) {
        Intrinsics.checkNotNullParameter(string, "name");
        return this.original.getElementIndex(string);
    }

    @ExperimentalSerializationApi
    public String getElementName(int i) {
        return this.original.getElementName(i);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.original.getElementsCount();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public kotlinx.serialization.descriptors.SerialKind getKind() {
        return this.original.getKind();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.serialName;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int hashCode() {
        return i2 += i4;
    }

    @ExperimentalSerializationApi
    public boolean isElementOptional(int i) {
        return this.original.isElementOptional(i);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.original.isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return this.original.isNullable();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ContextDescriptor(kClass: ").append(this.kClass).append(", original: ").append(this.original).append(')').toString();
    }
}
