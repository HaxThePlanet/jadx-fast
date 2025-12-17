package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.descriptors.StructureKind.OBJECT;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\u0008\u0010\u0019\u001a\u00020\u0003H\u0016J\u0008\u0010\u001a\u001a\u00020\u0005H\u0016R\u0014\u0010\u0008\u001a\u00020\tX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR!\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001b", d2 = {"Lkotlinx/serialization/internal/EnumDescriptor;", "Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "name", "", "elementsCount", "", "<init>", "(Ljava/lang/String;I)V", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "elementDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptors$delegate", "Lkotlin/Lazy;", "getElementDescriptor", "index", "equals", "", "other", "", "toString", "hashCode", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EnumDescriptor extends kotlinx.serialization.internal.PluginGeneratedSerialDescriptor {

    private final Lazy elementDescriptors$delegate;
    private final SerialKind kind;
    public static SerialDescriptor[] $r8$lambda$h6F9M2HXWZjok_R71paEwKzi_qo(int i, String string2, kotlinx.serialization.internal.EnumDescriptor enumDescriptor3) {
        return EnumDescriptor.elementDescriptors_delegate$lambda$0(i, string2, enumDescriptor3);
    }

    public EnumDescriptor(String name, int elementsCount) {
        Intrinsics.checkNotNullParameter(name, "name");
        final Object obj = this;
        final Object obj2 = name;
        final int i2 = elementsCount;
        super(obj2, 0, i2, 2, 0);
        obj.kind = (SerialKind)SerialKind.ENUM.INSTANCE;
        EnumDescriptor$$ExternalSyntheticLambda0 obj8 = new EnumDescriptor$$ExternalSyntheticLambda0(i2, obj2, this);
        obj.elementDescriptors$delegate = LazyKt.lazy(obj8);
    }

    private static final SerialDescriptor[] elementDescriptors_delegate$lambda$0(int $elementsCount, String $name, kotlinx.serialization.internal.EnumDescriptor this$0) {
        int i4;
        SerialDescriptor serialDescriptor$default;
        String string;
        StructureKind.OBJECT object;
        SerialDescriptor[] arr;
        int i;
        int i2;
        int i3;
        final SerialDescriptor[] arr2 = new SerialDescriptor[$elementsCount];
        final int i5 = 0;
        i4 = i5;
        while (i4 < $elementsCount) {
            StringBuilder stringBuilder = new StringBuilder();
            arr2[i4] = SerialDescriptorsKt.buildSerialDescriptor$default(stringBuilder.append($name).append('.').append(this$0.getElementName(i4)).toString(), (SerialKind)StructureKind.OBJECT.INSTANCE, new SerialDescriptor[i5], 0, 8, 0);
            i4++;
        }
        return arr2;
    }

    private final SerialDescriptor[] getElementDescriptors() {
        return (SerialDescriptor[])this.elementDescriptors$delegate.getValue();
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other == null) {
            return i2;
        }
        if (!other instanceof SerialDescriptor) {
            return i2;
        }
        if ((SerialDescriptor)other.getKind() != SerialKind.ENUM.INSTANCE) {
            return i2;
        }
        if (!Intrinsics.areEqual(getSerialName(), (SerialDescriptor)other.getSerialName())) {
            return i2;
        }
        if (!Intrinsics.areEqual(Platform_commonKt.cachedSerialNames((SerialDescriptor)this), Platform_commonKt.cachedSerialNames((SerialDescriptor)other))) {
            return i2;
        }
        return i;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public SerialDescriptor getElementDescriptor(int index) {
        final int i = 0;
        return getElementDescriptors()[index];
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public SerialKind getKind() {
        return this.kind;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        int accumulator$iv$iv;
        Object next;
        int i;
        Object obj;
        int i4;
        int i5;
        int i3;
        int i2;
        final int i9 = 0;
        final int i11 = 0;
        accumulator$iv$iv = i10;
        final Iterator iterator = SerialDescriptorKt.getElementNames((SerialDescriptor)this).iterator();
        while (iterator.hasNext()) {
            i4 = 0;
            Object obj2 = obj;
            i2 = 0;
            if ((String)obj2 != null) {
            } else {
            }
            i3 = 0;
            accumulator$iv$iv = i5;
            i3 = (String)obj2.hashCode();
        }
        return i7 += accumulator$iv$iv;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return CollectionsKt.joinToString$default(SerialDescriptorKt.getElementNames((SerialDescriptor)this), (CharSequence)", ", (CharSequence)stringBuilder.append(getSerialName()).append('(').toString(), (CharSequence)")", 0, 0, 0, 56, 0);
    }
}
