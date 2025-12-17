package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0013\u0010\u0013\u001a\u00020\u00112\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0008\u0010\u0016\u001a\u00020\tH\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u0018H\u0097\u0001J\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0018H\u0097\u0001J\u0011\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\tH\u0097\u0001J\u0011\u0010 \u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0018H\u0097\u0001J\u0011\u0010!\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0018H\u0097\u0001R\u0014\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0014\u0010\u0008\u001a\u00020\tX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\t0\rX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0012R\u001a\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008#\u0010$R\u0014\u0010%\u001a\u00020\u00188\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008&\u0010'R\u0014\u0010(\u001a\u00020\u00118VX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008(\u0010\u0012R\u0014\u0010)\u001a\u00020*8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008+\u0010,¨\u0006-", d2 = {"Lkotlinx/serialization/internal/SerialDescriptorForNullable;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "original", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getOriginal$kotlinx_serialization_core", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "isNullable", "", "()Z", "equals", "other", "", "toString", "hashCode", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "annotations", "getAnnotations", "()Ljava/util/List;", "elementsCount", "getElementsCount", "()I", "isInline", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SerialDescriptorForNullable implements SerialDescriptor, kotlinx.serialization.internal.CachedNames {

    private final SerialDescriptor original;
    private final String serialName;
    private final Set<String> serialNames;
    public SerialDescriptorForNullable(SerialDescriptor original) {
        Intrinsics.checkNotNullParameter(original, "original");
        super();
        this.original = original;
        StringBuilder stringBuilder = new StringBuilder();
        this.serialName = stringBuilder.append(this.original.getSerialName()).append('?').toString();
        this.serialNames = Platform_commonKt.cachedSerialNames(this.original);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof SerialDescriptorForNullable) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.original, obj.original)) {
            return i2;
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
    public SerialDescriptor getElementDescriptor(int i) {
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
    public SerialKind getKind() {
        return this.original.getKind();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor getOriginal$kotlinx_serialization_core() {
        return this.original;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.serialName;
    }

    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int hashCode() {
        return i *= 31;
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
        return 1;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(this.original).append('?').toString();
    }
}
